package com.dji.sdk.sample.tigersalvage;

import static android.content.Context.WIFI_SERVICE;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dji.sdk.sample.R;
import com.dji.sdk.sample.demo.camera.LiveStreamView;
import com.dji.sdk.sample.demo.camera.VideoFeederView;
import com.dji.sdk.sample.internal.controller.DJISampleApplication;
import com.dji.sdk.sample.internal.utils.ToastUtils;
import com.dji.sdk.sample.internal.utils.VideoFeedView;
import com.dji.sdk.sample.internal.view.PresentableView;
import com.dji.sdk.sample.tigersalvage.proto.schemas.generated.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import dji.sdk.base.BaseProduct;
import dji.sdk.camera.VideoFeeder;
import dji.sdk.flightcontroller.FlightController;
import dji.sdk.mission.MissionControl;
import dji.sdk.products.Aircraft;
import dji.sdk.sdkmanager.DJISDKManager;


/**
 * Class for the Tiger Salvage Test Script.
 */
public class TestScriptView extends LinearLayout implements PresentableView {

    private MissionControl missionControl;
    private FlightController flightController;

    protected TextView timelineInfoTV;
    protected TextView runningInfoTV;
    protected VideoFeedView primaryVideoFeedView;

    Thread Thread1;
    TextView tvIP, tvPort;
    TextView tvMessages;
    public static String SERVER_IP = "";
    public static final int SERVER_PORT = 8280;

    Context ctx;
    Activity mainActivity;

    public TestScriptView(Context context) {
        super(context);
        initTestScriptView(context);
    }

    public TestScriptView(Context context, @Nullable AttributeSet attrs) {
        super(context);
        initTestScriptView(context);
    }

    public TestScriptView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context);
        initTestScriptView(context);
    }

    private void initTestScriptView(Context context) {
        this.ctx = context;
        //Malicious cast!
        this.mainActivity = (Activity) context;

        initUI(context);
    }

    private String getLocalIpAddress() throws UnknownHostException {
        WifiManager wifiManager = (WifiManager) ctx.getApplicationContext().getSystemService(WIFI_SERVICE);
        assert wifiManager != null;
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipInt = wifiInfo.getIpAddress();
        return InetAddress.getByAddress(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(ipInt).array()).getHostAddress();
    }
    private PrintWriter output;
    private BufferedReader input;


    class Thread1 implements Runnable {
        @Override
        public void run() {
            Socket socket;
            try {
                ServerSocket serverSocket = new ServerSocket();
                serverSocket.setReuseAddress(true);
                serverSocket.bind(new InetSocketAddress(SERVER_PORT));
                mainActivity.runOnUiThread(() -> {
                    tvMessages.setText("Not connected");
                    tvIP.setText("IP: " + SERVER_IP);
                    tvPort.setText("Port: " + SERVER_PORT);
                });
                try {
                    socket = serverSocket.accept();
                    new Thread() {
                        @Override
                        public void run() {
                            DJISDKManager.getInstance().getLiveStreamManager().setLiveUrl("rtmp://" + socket.getInetAddress().getHostAddress() + "/live");
                            int result = DJISDKManager.getInstance().getLiveStreamManager().startStream();
                            DJISDKManager.getInstance().getLiveStreamManager().setStartTime();

                            ToastUtils.setResultToToast("startLive:" + result +
                                    "\n isVideoStreamSpeedConfigurable:" + DJISDKManager.getInstance().getLiveStreamManager().isVideoStreamSpeedConfigurable() +
                                    "\n isLiveAudioEnabled:" + DJISDKManager.getInstance().getLiveStreamManager().isLiveAudioEnabled());
                        }
                    }.start();
                    output = new PrintWriter(socket.getOutputStream());
                    input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    mainActivity.runOnUiThread(() -> tvMessages.setText("Connected\n"));
                    new Thread(new Thread2()).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class Thread2 implements Runnable {

        private byte[] formatStringToByteArray (String literalBytes) {
            if (literalBytes == null || literalBytes.length() < 2) {
                return new byte[0];
            }
            String[] tokens = literalBytes.substring(1,literalBytes.length() - 1).split(",");
            byte[] bytes = new byte[tokens.length];
            for (int i = 0 ; i < tokens.length ; i ++ ) {
                bytes[i] = Byte.decode(tokens[i].trim());
            }
            return bytes;
        }

        @Override
        public void run() {
            Set<Command.CommandCase> handledCases = new HashSet<>();
            handledCases.add(Command.CommandCase.GETPOSITION);
            handledCases.add(Command.CommandCase.TAKEOFF);
            handledCases.add(Command.CommandCase.MOVEGIMBAL);
            handledCases.add(Command.CommandCase.CHANGEZOOMLEVEL);
            handledCases.add(Command.CommandCase.MOVETO);
            handledCases.add(Command.CommandCase.LAND);
            while (true) {
                try {
                    final String message = input.readLine();
                    if (message != null) {
                        byte[] realMessage = formatStringToByteArray(message);
                        if (realMessage.length > 0) {
                            RouteHandler.RouteSet rs = RouteHandler.buildTimelineIfRoute(realMessage, missionControl);
                            if (rs != null) {
                                //Route set object was provided, and mission was set.
                                new Thread(new Thread3(Arrays.toString(rs.event.toByteArray()) + "\n")).start();
                                mainActivity.runOnUiThread(() -> tvMessages.append(rs.operation + "\n") );
                            } else {
                                //Other command was provided.
                                Converter.Pair interpretedMessage = Converter.parse(realMessage, missionControl, flightController);
                                if (handledCases.contains(interpretedMessage.command.getCommandCase())) {
                                    new Thread(new Thread3(Arrays.toString(interpretedMessage.event.toByteArray()) + "\n")).start();
                                }
                                mainActivity.runOnUiThread(() -> tvMessages.append(interpretedMessage.operation + "\n") );
                            }

                        }

                    } else {
                        Thread1 = new Thread(new Thread1());
                        Thread1.start();
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Thread3 implements Runnable {
        private final String message;
        Thread3(String message) {
            this.message = message;
        }
        @Override
        public void run() {
            output.write(message);
            output.flush();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        BaseProduct product = DJISampleApplication.getProductInstance();

        if (product == null || !product.isConnected()) {
            ToastUtils.setResultToToast("Disconnect");
            missionControl = null;
            return;
        } else {
            missionControl = MissionControl.getInstance();
            if (product instanceof Aircraft) {
                flightController = ((Aircraft) product).getFlightController();
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (missionControl != null && missionControl.scheduledCount() > 0) {
            missionControl.unscheduleEverything();
            missionControl.removeAllListeners();
        }
    }

    private void initUI(Context context) {
        setClickable(true);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.view_server, this, true);

        timelineInfoTV = findViewById(R.id.tv_timeline_info);
        runningInfoTV = findViewById(R.id.tv_running_info);
        tvIP = findViewById(R.id.tvIP);
        tvPort = findViewById(R.id.tvPort);
        tvMessages = findViewById(R.id.tvMessages);
        tvMessages.setMovementMethod(new ScrollingMovementMethod());
        primaryVideoFeedView = findViewById(R.id.video_view_primary_video_feed);

        try {
            SERVER_IP = getLocalIpAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        primaryVideoFeedView.registerLiveVideo(VideoFeeder.getInstance().getPrimaryVideoFeed(), true);


        Thread1 = new Thread(new Thread1());
        Thread1.start();
    }


    @Override
    public int getDescription() {
        return R.string.component_listview_timeline_mission_control;
    }

    @NonNull
    @Override
    public String getHint() {
        return this.getClass().getSimpleName() + ".java";
    }
}
