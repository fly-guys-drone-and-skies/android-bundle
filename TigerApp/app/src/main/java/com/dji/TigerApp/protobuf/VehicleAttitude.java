// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: VehicleStatus.proto

package com.dji.TigerApp.protobuf;

/**
 * Protobuf type {@code tutorial.VehicleAttitude}
 */
public final class VehicleAttitude extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tutorial.VehicleAttitude)
    VehicleAttitudeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use VehicleAttitude.newBuilder() to construct.
  private VehicleAttitude(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VehicleAttitude() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new VehicleAttitude();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private VehicleAttitude(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 9: {

            pitch_ = input.readDouble();
            break;
          }
          case 17: {

            yaw_ = input.readDouble();
            break;
          }
          case 25: {

            roll_ = input.readDouble();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dji.TigerApp.protobuf.VehicleStatusOuterClass.internal_static_tutorial_VehicleAttitude_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dji.TigerApp.protobuf.VehicleStatusOuterClass.internal_static_tutorial_VehicleAttitude_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dji.TigerApp.protobuf.VehicleAttitude.class, com.dji.TigerApp.protobuf.VehicleAttitude.Builder.class);
  }

  public static final int PITCH_FIELD_NUMBER = 1;
  private double pitch_;
  /**
   * <code>double pitch = 1;</code>
   * @return The pitch.
   */
  @java.lang.Override
  public double getPitch() {
    return pitch_;
  }

  public static final int YAW_FIELD_NUMBER = 2;
  private double yaw_;
  /**
   * <code>double yaw = 2;</code>
   * @return The yaw.
   */
  @java.lang.Override
  public double getYaw() {
    return yaw_;
  }

  public static final int ROLL_FIELD_NUMBER = 3;
  private double roll_;
  /**
   * <code>double roll = 3;</code>
   * @return The roll.
   */
  @java.lang.Override
  public double getRoll() {
    return roll_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (java.lang.Double.doubleToRawLongBits(pitch_) != 0) {
      output.writeDouble(1, pitch_);
    }
    if (java.lang.Double.doubleToRawLongBits(yaw_) != 0) {
      output.writeDouble(2, yaw_);
    }
    if (java.lang.Double.doubleToRawLongBits(roll_) != 0) {
      output.writeDouble(3, roll_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (java.lang.Double.doubleToRawLongBits(pitch_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(1, pitch_);
    }
    if (java.lang.Double.doubleToRawLongBits(yaw_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, yaw_);
    }
    if (java.lang.Double.doubleToRawLongBits(roll_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, roll_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.dji.TigerApp.protobuf.VehicleAttitude)) {
      return super.equals(obj);
    }
    com.dji.TigerApp.protobuf.VehicleAttitude other = (com.dji.TigerApp.protobuf.VehicleAttitude) obj;

    if (java.lang.Double.doubleToLongBits(getPitch())
        != java.lang.Double.doubleToLongBits(
            other.getPitch())) return false;
    if (java.lang.Double.doubleToLongBits(getYaw())
        != java.lang.Double.doubleToLongBits(
            other.getYaw())) return false;
    if (java.lang.Double.doubleToLongBits(getRoll())
        != java.lang.Double.doubleToLongBits(
            other.getRoll())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PITCH_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getPitch()));
    hash = (37 * hash) + YAW_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getYaw()));
    hash = (37 * hash) + ROLL_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getRoll()));
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dji.TigerApp.protobuf.VehicleAttitude parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dji.TigerApp.protobuf.VehicleAttitude parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dji.TigerApp.protobuf.VehicleAttitude parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dji.TigerApp.protobuf.VehicleAttitude parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dji.TigerApp.protobuf.VehicleAttitude parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dji.TigerApp.protobuf.VehicleAttitude parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dji.TigerApp.protobuf.VehicleAttitude parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dji.TigerApp.protobuf.VehicleAttitude parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dji.TigerApp.protobuf.VehicleAttitude parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dji.TigerApp.protobuf.VehicleAttitude parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dji.TigerApp.protobuf.VehicleAttitude parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dji.TigerApp.protobuf.VehicleAttitude parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.dji.TigerApp.protobuf.VehicleAttitude prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code tutorial.VehicleAttitude}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tutorial.VehicleAttitude)
      com.dji.TigerApp.protobuf.VehicleAttitudeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dji.TigerApp.protobuf.VehicleStatusOuterClass.internal_static_tutorial_VehicleAttitude_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dji.TigerApp.protobuf.VehicleStatusOuterClass.internal_static_tutorial_VehicleAttitude_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dji.TigerApp.protobuf.VehicleAttitude.class, com.dji.TigerApp.protobuf.VehicleAttitude.Builder.class);
    }

    // Construct using com.dji.TigerApp.protobuf.VehicleAttitude.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      pitch_ = 0D;

      yaw_ = 0D;

      roll_ = 0D;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dji.TigerApp.protobuf.VehicleStatusOuterClass.internal_static_tutorial_VehicleAttitude_descriptor;
    }

    @java.lang.Override
    public com.dji.TigerApp.protobuf.VehicleAttitude getDefaultInstanceForType() {
      return com.dji.TigerApp.protobuf.VehicleAttitude.getDefaultInstance();
    }

    @java.lang.Override
    public com.dji.TigerApp.protobuf.VehicleAttitude build() {
      com.dji.TigerApp.protobuf.VehicleAttitude result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.dji.TigerApp.protobuf.VehicleAttitude buildPartial() {
      com.dji.TigerApp.protobuf.VehicleAttitude result = new com.dji.TigerApp.protobuf.VehicleAttitude(this);
      result.pitch_ = pitch_;
      result.yaw_ = yaw_;
      result.roll_ = roll_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.dji.TigerApp.protobuf.VehicleAttitude) {
        return mergeFrom((com.dji.TigerApp.protobuf.VehicleAttitude)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dji.TigerApp.protobuf.VehicleAttitude other) {
      if (other == com.dji.TigerApp.protobuf.VehicleAttitude.getDefaultInstance()) return this;
      if (other.getPitch() != 0D) {
        setPitch(other.getPitch());
      }
      if (other.getYaw() != 0D) {
        setYaw(other.getYaw());
      }
      if (other.getRoll() != 0D) {
        setRoll(other.getRoll());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.dji.TigerApp.protobuf.VehicleAttitude parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dji.TigerApp.protobuf.VehicleAttitude) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private double pitch_ ;
    /**
     * <code>double pitch = 1;</code>
     * @return The pitch.
     */
    @java.lang.Override
    public double getPitch() {
      return pitch_;
    }
    /**
     * <code>double pitch = 1;</code>
     * @param value The pitch to set.
     * @return This builder for chaining.
     */
    public Builder setPitch(double value) {
      
      pitch_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double pitch = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearPitch() {
      
      pitch_ = 0D;
      onChanged();
      return this;
    }

    private double yaw_ ;
    /**
     * <code>double yaw = 2;</code>
     * @return The yaw.
     */
    @java.lang.Override
    public double getYaw() {
      return yaw_;
    }
    /**
     * <code>double yaw = 2;</code>
     * @param value The yaw to set.
     * @return This builder for chaining.
     */
    public Builder setYaw(double value) {
      
      yaw_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double yaw = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearYaw() {
      
      yaw_ = 0D;
      onChanged();
      return this;
    }

    private double roll_ ;
    /**
     * <code>double roll = 3;</code>
     * @return The roll.
     */
    @java.lang.Override
    public double getRoll() {
      return roll_;
    }
    /**
     * <code>double roll = 3;</code>
     * @param value The roll to set.
     * @return This builder for chaining.
     */
    public Builder setRoll(double value) {
      
      roll_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double roll = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearRoll() {
      
      roll_ = 0D;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:tutorial.VehicleAttitude)
  }

  // @@protoc_insertion_point(class_scope:tutorial.VehicleAttitude)
  private static final com.dji.TigerApp.protobuf.VehicleAttitude DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dji.TigerApp.protobuf.VehicleAttitude();
  }

  public static com.dji.TigerApp.protobuf.VehicleAttitude getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<VehicleAttitude>
      PARSER = new com.google.protobuf.AbstractParser<VehicleAttitude>() {
    @java.lang.Override
    public VehicleAttitude parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new VehicleAttitude(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<VehicleAttitude> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<VehicleAttitude> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.dji.TigerApp.protobuf.VehicleAttitude getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

