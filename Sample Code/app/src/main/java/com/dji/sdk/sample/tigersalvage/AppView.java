package com.dji.sdk.sample.tigersalvage;

import android.widget.LinearLayout;
import com.dji.sdk.sample.internal.view.PresentableView;
import android.content.Context;
import com.dji.sdk.sample.R;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;


public class AppView extends LinearLayout implements PresentableView {
    public AppView(Context context) {
        super(context);
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

    private void initUI(Context context) {
        setClickable(true);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.view_server, this, true);
    }
}
