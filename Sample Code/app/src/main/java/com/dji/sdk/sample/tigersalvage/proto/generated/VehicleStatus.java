// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: VehicleStatus.proto

package com.dji.sdk.sample.tigersalvage.proto.generated;

/**
 * Protobuf type {@code tutorial.VehicleStatus}
 */
public final class VehicleStatus extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tutorial.VehicleStatus)
    VehicleStatusOrBuilder {
private static final long serialVersionUID = 0L;
  // Use VehicleStatus.newBuilder() to construct.
  private VehicleStatus(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VehicleStatus() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new VehicleStatus();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private VehicleStatus(
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
          case 10: {
            com.dji.sdk.sample.tigersalvage.proto.generated.Location.Builder subBuilder = null;
            if (location_ != null) {
              subBuilder = location_.toBuilder();
            }
            location_ = input.readMessage(com.dji.sdk.sample.tigersalvage.proto.generated.Location.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(location_);
              location_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity.Builder subBuilder = null;
            if (velocityXYZ_ != null) {
              subBuilder = velocityXYZ_.toBuilder();
            }
            velocityXYZ_ = input.readMessage(com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(velocityXYZ_);
              velocityXYZ_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude.Builder subBuilder = null;
            if (attitude_ != null) {
              subBuilder = attitude_.toBuilder();
            }
            attitude_ = input.readMessage(com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(attitude_);
              attitude_ = subBuilder.buildPartial();
            }

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
    return com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatusOuterClass.internal_static_tutorial_VehicleStatus_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatusOuterClass.internal_static_tutorial_VehicleStatus_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus.class, com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus.Builder.class);
  }

  public static final int LOCATION_FIELD_NUMBER = 1;
  private com.dji.sdk.sample.tigersalvage.proto.generated.Location location_;
  /**
   * <code>.tutorial.Location location = 1;</code>
   * @return Whether the location field is set.
   */
  @java.lang.Override
  public boolean hasLocation() {
    return location_ != null;
  }
  /**
   * <code>.tutorial.Location location = 1;</code>
   * @return The location.
   */
  @java.lang.Override
  public com.dji.sdk.sample.tigersalvage.proto.generated.Location getLocation() {
    return location_ == null ? com.dji.sdk.sample.tigersalvage.proto.generated.Location.getDefaultInstance() : location_;
  }
  /**
   * <code>.tutorial.Location location = 1;</code>
   */
  @java.lang.Override
  public com.dji.sdk.sample.tigersalvage.proto.generated.LocationOrBuilder getLocationOrBuilder() {
    return getLocation();
  }

  public static final int VELOCITYXYZ_FIELD_NUMBER = 2;
  private com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity velocityXYZ_;
  /**
   * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
   * @return Whether the velocityXYZ field is set.
   */
  @java.lang.Override
  public boolean hasVelocityXYZ() {
    return velocityXYZ_ != null;
  }
  /**
   * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
   * @return The velocityXYZ.
   */
  @java.lang.Override
  public com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity getVelocityXYZ() {
    return velocityXYZ_ == null ? com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity.getDefaultInstance() : velocityXYZ_;
  }
  /**
   * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
   */
  @java.lang.Override
  public com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocityOrBuilder getVelocityXYZOrBuilder() {
    return getVelocityXYZ();
  }

  public static final int ATTITUDE_FIELD_NUMBER = 3;
  private com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude attitude_;
  /**
   * <code>.tutorial.VehicleAttitude attitude = 3;</code>
   * @return Whether the attitude field is set.
   */
  @java.lang.Override
  public boolean hasAttitude() {
    return attitude_ != null;
  }
  /**
   * <code>.tutorial.VehicleAttitude attitude = 3;</code>
   * @return The attitude.
   */
  @java.lang.Override
  public com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude getAttitude() {
    return attitude_ == null ? com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude.getDefaultInstance() : attitude_;
  }
  /**
   * <code>.tutorial.VehicleAttitude attitude = 3;</code>
   */
  @java.lang.Override
  public com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitudeOrBuilder getAttitudeOrBuilder() {
    return getAttitude();
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
    if (location_ != null) {
      output.writeMessage(1, getLocation());
    }
    if (velocityXYZ_ != null) {
      output.writeMessage(2, getVelocityXYZ());
    }
    if (attitude_ != null) {
      output.writeMessage(3, getAttitude());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (location_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getLocation());
    }
    if (velocityXYZ_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getVelocityXYZ());
    }
    if (attitude_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getAttitude());
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
    if (!(obj instanceof com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus)) {
      return super.equals(obj);
    }
    com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus other = (com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus) obj;

    if (hasLocation() != other.hasLocation()) return false;
    if (hasLocation()) {
      if (!getLocation()
          .equals(other.getLocation())) return false;
    }
    if (hasVelocityXYZ() != other.hasVelocityXYZ()) return false;
    if (hasVelocityXYZ()) {
      if (!getVelocityXYZ()
          .equals(other.getVelocityXYZ())) return false;
    }
    if (hasAttitude() != other.hasAttitude()) return false;
    if (hasAttitude()) {
      if (!getAttitude()
          .equals(other.getAttitude())) return false;
    }
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
    if (hasLocation()) {
      hash = (37 * hash) + LOCATION_FIELD_NUMBER;
      hash = (53 * hash) + getLocation().hashCode();
    }
    if (hasVelocityXYZ()) {
      hash = (37 * hash) + VELOCITYXYZ_FIELD_NUMBER;
      hash = (53 * hash) + getVelocityXYZ().hashCode();
    }
    if (hasAttitude()) {
      hash = (37 * hash) + ATTITUDE_FIELD_NUMBER;
      hash = (53 * hash) + getAttitude().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus parseFrom(
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
  public static Builder newBuilder(com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus prototype) {
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
   * Protobuf type {@code tutorial.VehicleStatus}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tutorial.VehicleStatus)
      com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatusOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatusOuterClass.internal_static_tutorial_VehicleStatus_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatusOuterClass.internal_static_tutorial_VehicleStatus_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus.class, com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus.Builder.class);
    }

    // Construct using com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus.newBuilder()
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
      if (locationBuilder_ == null) {
        location_ = null;
      } else {
        location_ = null;
        locationBuilder_ = null;
      }
      if (velocityXYZBuilder_ == null) {
        velocityXYZ_ = null;
      } else {
        velocityXYZ_ = null;
        velocityXYZBuilder_ = null;
      }
      if (attitudeBuilder_ == null) {
        attitude_ = null;
      } else {
        attitude_ = null;
        attitudeBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatusOuterClass.internal_static_tutorial_VehicleStatus_descriptor;
    }

    @java.lang.Override
    public com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus getDefaultInstanceForType() {
      return com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus.getDefaultInstance();
    }

    @java.lang.Override
    public com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus build() {
      com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus buildPartial() {
      com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus result = new com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus(this);
      if (locationBuilder_ == null) {
        result.location_ = location_;
      } else {
        result.location_ = locationBuilder_.build();
      }
      if (velocityXYZBuilder_ == null) {
        result.velocityXYZ_ = velocityXYZ_;
      } else {
        result.velocityXYZ_ = velocityXYZBuilder_.build();
      }
      if (attitudeBuilder_ == null) {
        result.attitude_ = attitude_;
      } else {
        result.attitude_ = attitudeBuilder_.build();
      }
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
      if (other instanceof com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus) {
        return mergeFrom((com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus other) {
      if (other == com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus.getDefaultInstance()) return this;
      if (other.hasLocation()) {
        mergeLocation(other.getLocation());
      }
      if (other.hasVelocityXYZ()) {
        mergeVelocityXYZ(other.getVelocityXYZ());
      }
      if (other.hasAttitude()) {
        mergeAttitude(other.getAttitude());
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
      com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.dji.sdk.sample.tigersalvage.proto.generated.Location location_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dji.sdk.sample.tigersalvage.proto.generated.Location, com.dji.sdk.sample.tigersalvage.proto.generated.Location.Builder, com.dji.sdk.sample.tigersalvage.proto.generated.LocationOrBuilder> locationBuilder_;
    /**
     * <code>.tutorial.Location location = 1;</code>
     * @return Whether the location field is set.
     */
    public boolean hasLocation() {
      return locationBuilder_ != null || location_ != null;
    }
    /**
     * <code>.tutorial.Location location = 1;</code>
     * @return The location.
     */
    public com.dji.sdk.sample.tigersalvage.proto.generated.Location getLocation() {
      if (locationBuilder_ == null) {
        return location_ == null ? com.dji.sdk.sample.tigersalvage.proto.generated.Location.getDefaultInstance() : location_;
      } else {
        return locationBuilder_.getMessage();
      }
    }
    /**
     * <code>.tutorial.Location location = 1;</code>
     */
    public Builder setLocation(com.dji.sdk.sample.tigersalvage.proto.generated.Location value) {
      if (locationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        location_ = value;
        onChanged();
      } else {
        locationBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.tutorial.Location location = 1;</code>
     */
    public Builder setLocation(
        com.dji.sdk.sample.tigersalvage.proto.generated.Location.Builder builderForValue) {
      if (locationBuilder_ == null) {
        location_ = builderForValue.build();
        onChanged();
      } else {
        locationBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.tutorial.Location location = 1;</code>
     */
    public Builder mergeLocation(com.dji.sdk.sample.tigersalvage.proto.generated.Location value) {
      if (locationBuilder_ == null) {
        if (location_ != null) {
          location_ =
            com.dji.sdk.sample.tigersalvage.proto.generated.Location.newBuilder(location_).mergeFrom(value).buildPartial();
        } else {
          location_ = value;
        }
        onChanged();
      } else {
        locationBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.tutorial.Location location = 1;</code>
     */
    public Builder clearLocation() {
      if (locationBuilder_ == null) {
        location_ = null;
        onChanged();
      } else {
        location_ = null;
        locationBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.tutorial.Location location = 1;</code>
     */
    public com.dji.sdk.sample.tigersalvage.proto.generated.Location.Builder getLocationBuilder() {
      
      onChanged();
      return getLocationFieldBuilder().getBuilder();
    }
    /**
     * <code>.tutorial.Location location = 1;</code>
     */
    public com.dji.sdk.sample.tigersalvage.proto.generated.LocationOrBuilder getLocationOrBuilder() {
      if (locationBuilder_ != null) {
        return locationBuilder_.getMessageOrBuilder();
      } else {
        return location_ == null ?
            com.dji.sdk.sample.tigersalvage.proto.generated.Location.getDefaultInstance() : location_;
      }
    }
    /**
     * <code>.tutorial.Location location = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dji.sdk.sample.tigersalvage.proto.generated.Location, com.dji.sdk.sample.tigersalvage.proto.generated.Location.Builder, com.dji.sdk.sample.tigersalvage.proto.generated.LocationOrBuilder> 
        getLocationFieldBuilder() {
      if (locationBuilder_ == null) {
        locationBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dji.sdk.sample.tigersalvage.proto.generated.Location, com.dji.sdk.sample.tigersalvage.proto.generated.Location.Builder, com.dji.sdk.sample.tigersalvage.proto.generated.LocationOrBuilder>(
                getLocation(),
                getParentForChildren(),
                isClean());
        location_ = null;
      }
      return locationBuilder_;
    }

    private com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity velocityXYZ_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity, com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity.Builder, com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocityOrBuilder> velocityXYZBuilder_;
    /**
     * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
     * @return Whether the velocityXYZ field is set.
     */
    public boolean hasVelocityXYZ() {
      return velocityXYZBuilder_ != null || velocityXYZ_ != null;
    }
    /**
     * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
     * @return The velocityXYZ.
     */
    public com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity getVelocityXYZ() {
      if (velocityXYZBuilder_ == null) {
        return velocityXYZ_ == null ? com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity.getDefaultInstance() : velocityXYZ_;
      } else {
        return velocityXYZBuilder_.getMessage();
      }
    }
    /**
     * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
     */
    public Builder setVelocityXYZ(com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity value) {
      if (velocityXYZBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        velocityXYZ_ = value;
        onChanged();
      } else {
        velocityXYZBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
     */
    public Builder setVelocityXYZ(
        com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity.Builder builderForValue) {
      if (velocityXYZBuilder_ == null) {
        velocityXYZ_ = builderForValue.build();
        onChanged();
      } else {
        velocityXYZBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
     */
    public Builder mergeVelocityXYZ(com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity value) {
      if (velocityXYZBuilder_ == null) {
        if (velocityXYZ_ != null) {
          velocityXYZ_ =
            com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity.newBuilder(velocityXYZ_).mergeFrom(value).buildPartial();
        } else {
          velocityXYZ_ = value;
        }
        onChanged();
      } else {
        velocityXYZBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
     */
    public Builder clearVelocityXYZ() {
      if (velocityXYZBuilder_ == null) {
        velocityXYZ_ = null;
        onChanged();
      } else {
        velocityXYZ_ = null;
        velocityXYZBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
     */
    public com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity.Builder getVelocityXYZBuilder() {
      
      onChanged();
      return getVelocityXYZFieldBuilder().getBuilder();
    }
    /**
     * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
     */
    public com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocityOrBuilder getVelocityXYZOrBuilder() {
      if (velocityXYZBuilder_ != null) {
        return velocityXYZBuilder_.getMessageOrBuilder();
      } else {
        return velocityXYZ_ == null ?
            com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity.getDefaultInstance() : velocityXYZ_;
      }
    }
    /**
     * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity, com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity.Builder, com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocityOrBuilder> 
        getVelocityXYZFieldBuilder() {
      if (velocityXYZBuilder_ == null) {
        velocityXYZBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity, com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocity.Builder, com.dji.sdk.sample.tigersalvage.proto.generated.VehicleVelocityOrBuilder>(
                getVelocityXYZ(),
                getParentForChildren(),
                isClean());
        velocityXYZ_ = null;
      }
      return velocityXYZBuilder_;
    }

    private com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude attitude_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude, com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude.Builder, com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitudeOrBuilder> attitudeBuilder_;
    /**
     * <code>.tutorial.VehicleAttitude attitude = 3;</code>
     * @return Whether the attitude field is set.
     */
    public boolean hasAttitude() {
      return attitudeBuilder_ != null || attitude_ != null;
    }
    /**
     * <code>.tutorial.VehicleAttitude attitude = 3;</code>
     * @return The attitude.
     */
    public com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude getAttitude() {
      if (attitudeBuilder_ == null) {
        return attitude_ == null ? com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude.getDefaultInstance() : attitude_;
      } else {
        return attitudeBuilder_.getMessage();
      }
    }
    /**
     * <code>.tutorial.VehicleAttitude attitude = 3;</code>
     */
    public Builder setAttitude(com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude value) {
      if (attitudeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        attitude_ = value;
        onChanged();
      } else {
        attitudeBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.tutorial.VehicleAttitude attitude = 3;</code>
     */
    public Builder setAttitude(
        com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude.Builder builderForValue) {
      if (attitudeBuilder_ == null) {
        attitude_ = builderForValue.build();
        onChanged();
      } else {
        attitudeBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.tutorial.VehicleAttitude attitude = 3;</code>
     */
    public Builder mergeAttitude(com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude value) {
      if (attitudeBuilder_ == null) {
        if (attitude_ != null) {
          attitude_ =
            com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude.newBuilder(attitude_).mergeFrom(value).buildPartial();
        } else {
          attitude_ = value;
        }
        onChanged();
      } else {
        attitudeBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.tutorial.VehicleAttitude attitude = 3;</code>
     */
    public Builder clearAttitude() {
      if (attitudeBuilder_ == null) {
        attitude_ = null;
        onChanged();
      } else {
        attitude_ = null;
        attitudeBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.tutorial.VehicleAttitude attitude = 3;</code>
     */
    public com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude.Builder getAttitudeBuilder() {
      
      onChanged();
      return getAttitudeFieldBuilder().getBuilder();
    }
    /**
     * <code>.tutorial.VehicleAttitude attitude = 3;</code>
     */
    public com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitudeOrBuilder getAttitudeOrBuilder() {
      if (attitudeBuilder_ != null) {
        return attitudeBuilder_.getMessageOrBuilder();
      } else {
        return attitude_ == null ?
            com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude.getDefaultInstance() : attitude_;
      }
    }
    /**
     * <code>.tutorial.VehicleAttitude attitude = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude, com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude.Builder, com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitudeOrBuilder> 
        getAttitudeFieldBuilder() {
      if (attitudeBuilder_ == null) {
        attitudeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude, com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitude.Builder, com.dji.sdk.sample.tigersalvage.proto.generated.VehicleAttitudeOrBuilder>(
                getAttitude(),
                getParentForChildren(),
                isClean());
        attitude_ = null;
      }
      return attitudeBuilder_;
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


    // @@protoc_insertion_point(builder_scope:tutorial.VehicleStatus)
  }

  // @@protoc_insertion_point(class_scope:tutorial.VehicleStatus)
  private static final com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus();
  }

  public static com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<VehicleStatus>
      PARSER = new com.google.protobuf.AbstractParser<VehicleStatus>() {
    @java.lang.Override
    public VehicleStatus parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new VehicleStatus(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<VehicleStatus> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<VehicleStatus> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.dji.sdk.sample.tigersalvage.proto.generated.VehicleStatus getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

