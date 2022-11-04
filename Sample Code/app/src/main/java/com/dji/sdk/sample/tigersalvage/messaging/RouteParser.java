package com.dji.sdk.sample.tigersalvage.messaging;

import com.dji.sdk.sample.tigersalvage.proto.schemas.generated.Route;

public class RouteParser {
    public static void parseRoute(byte[] routeBytes) {
        Route route = Route.parseFrom(routeBytes);
    }
}
