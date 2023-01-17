package com.dji.sdk.sample.tigersalvage;

import com.dji.sdk.sample.internal.utils.ToastUtils;
import com.dji.sdk.sample.tigersalvage.MissionHandler;
import dji.common.flightcontroller.FlightControllerState;

public class FlightControllerStateCallback implements FlightControllerState.Callback {
    public void onUpdate(FlightControllerState state) {
        try {
            Status status = new Status(
                    state.getAircraftLocation(),
                    state.getAttitude(),
                    new float[]{
                            state.getVelocityX(),
                            state.getVelocityY(),
                            state.getVelocityZ(),
                    },
                    MissionHandler.operator.getCurrentState().toString()
            );
            Sender.send(status.toMessage().toByteArray(), "ui-exchange", "status", "status");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //ToastUtils.setResultToToast("Status sent");
    }
}
