package com.dji.TigerApp;

import com.dji.TigerApp.protobuf.Location;
import com.dji.TigerApp.protobuf.VehicleAttitude;
import com.dji.TigerApp.protobuf.VehicleStatus;
import com.dji.TigerApp.protobuf.VehicleVelocity;
import com.dji.TigerApp.protobuf.Attitude;
import com.dji.TigerApp.protobuf.LocationCoordinate3D;

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
                setLat(location.getLatitude()).
                setLong(location.getLongitude()).
                setAlt(location.getAltitude()).
                build();
        VehicleAttitude attitudeMessage = VehicleAttitude.newBuilder().
            setPitch(attitude.pitch).
            setYaw(attitude.yaw).
            setRoll(attitude.roll).
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
