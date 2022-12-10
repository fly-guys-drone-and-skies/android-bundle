package com.dji.sdk.sample.tigersalvage;

import com.dji.sdk.sample.tigersalvage.MissionHandler;
import dji.common.flightcontroller.FlightControllerState;

public class FlightControllerStateCallback implements FlightControllerState.Callback {
    public void onUpdate(FlightControllerState state) {
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
}
