// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: VehicleStatus.proto

package com.dji.sdk.sample.tigersalvage.proto.generated;

public final class VehicleStatusOuterClass {
  private VehicleStatusOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_VehicleVelocity_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_VehicleVelocity_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_VehicleAttitude_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_VehicleAttitude_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_VehicleStatus_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_VehicleStatus_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023VehicleStatus.proto\022\010tutorial\032\013Route.p" +
      "roto\"2\n\017VehicleVelocity\022\t\n\001x\030\001 \001(\002\022\t\n\001y\030" +
      "\002 \001(\002\022\t\n\001z\030\003 \001(\002\";\n\017VehicleAttitude\022\r\n\005p" +
      "itch\030\001 \001(\001\022\013\n\003yaw\030\002 \001(\001\022\014\n\004roll\030\003 \001(\001\"\242\001" +
      "\n\rVehicleStatus\022$\n\010location\030\001 \001(\0132\022.tuto" +
      "rial.Location\022.\n\013velocityXYZ\030\002 \001(\0132\031.tut" +
      "orial.VehicleVelocity\022+\n\010attitude\030\003 \001(\0132" +
      "\031.tutorial.VehicleAttitude\022\016\n\006status\030\004 \001" +
      "(\tB3\n/com.dji.sdk.sample.tigersalvage.pr" +
      "oto.generatedP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.dji.sdk.sample.tigersalvage.proto.generated.Route.getDescriptor(),
        });
    internal_static_tutorial_VehicleVelocity_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tutorial_VehicleVelocity_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_VehicleVelocity_descriptor,
        new java.lang.String[] { "X", "Y", "Z", });
    internal_static_tutorial_VehicleAttitude_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_tutorial_VehicleAttitude_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_VehicleAttitude_descriptor,
        new java.lang.String[] { "Pitch", "Yaw", "Roll", });
    internal_static_tutorial_VehicleStatus_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_tutorial_VehicleStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_VehicleStatus_descriptor,
        new java.lang.String[] { "Location", "VelocityXYZ", "Attitude", "Status", });
    com.dji.sdk.sample.tigersalvage.proto.generated.Route.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}