// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Route.proto

package com.dji.TigerApp.schemas.generated;

public interface RouteArrayOrBuilder extends
    // @@protoc_insertion_point(interface_extends:tutorial.RouteArray)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .tutorial.RoutePoint waypoints = 1;</code>
   */
  java.util.List<com.dji.TigerApp.schemas.generated.RoutePoint> 
      getWaypointsList();
  /**
   * <code>repeated .tutorial.RoutePoint waypoints = 1;</code>
   */
  com.dji.TigerApp.schemas.generated.RoutePoint getWaypoints(int index);
  /**
   * <code>repeated .tutorial.RoutePoint waypoints = 1;</code>
   */
  int getWaypointsCount();
  /**
   * <code>repeated .tutorial.RoutePoint waypoints = 1;</code>
   */
  java.util.List<? extends com.dji.TigerApp.schemas.generated.RoutePointOrBuilder> 
      getWaypointsOrBuilderList();
  /**
   * <code>repeated .tutorial.RoutePoint waypoints = 1;</code>
   */
  com.dji.TigerApp.schemas.generated.RoutePointOrBuilder getWaypointsOrBuilder(
      int index);
}