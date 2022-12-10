package com.dji.sdk.sample.tigersalvage;

import com.dji.sdk.sample.tigersalvage.proto.generated.Location;
import com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude;
import com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus;
import com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity;

import dji.common.flightcontroller.Attitude;
import dji.common.flightcontroller.LocationCoordinate3D;

public class Status {
    LocationCoordinate3D location;
    Attitude attitude;
    float[] velocityXYZ;
    String status;

    public Status (LocationCoordinate3D location, Attitude attitude, float[] velocityXYZ, String status) {
        this.location = location;
        this.attitude = attitude;
        this.velocityXYZ = velocityXYZ;
        this.status = status;
    }

    // Converts to VehicleStatus protobuf message
    public VehicleStatus toMessage() {
        Location locationMessage = Location.newBuilder().
                setLat(Double.isNaN(location.getLatitude()) ? 0 : location.getLatitude()).
                setLong(Double.isNaN(location.getLongitude()) ? 0 : location.getLongitude()).
                setAlt(Double.isNaN(location.getAltitude()) ? 0 : location.getAltitude()).
                build();
        VehicleAttitude attitudeMessage = VehicleAttitude.newBuilder().
            setPitch(Double.isNaN(attitude.pitch) ? 0 : attitude.pitch).
            setYaw(Double.isNaN(attitude.yaw) ? 0 : attitude.yaw).
            setRoll(Double.isNaN(attitude.roll) ? 0 : attitude.roll).
            build();
        VehicleVelocity velocityMessage = VehicleVelocity.newBuilder().
            setX(velocityXYZ[0]).
            setY(velocityXYZ[1]).
            setZ(velocityXYZ[2]).
            build();

        VehicleStatus vehicleStatus = VehicleStatus.newBuilder().
            setLocation(locationMessage).
            setVelocityXYZ(velocityMessage).
            setAttitude(attitudeMessage).
            setStatus(status).
            build();

        return vehicleStatus;
    }
}
