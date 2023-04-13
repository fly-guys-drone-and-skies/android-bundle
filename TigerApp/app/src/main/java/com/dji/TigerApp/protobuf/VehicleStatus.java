// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: VehicleStatus.proto

package com.dji.TigerApp.protobuf;

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
    status_ = "";
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
            com.dji.TigerApp.protobuf.Location.Builder subBuilder = null;
            if (location_ != null) {
              subBuilder = location_.toBuilder();
            }
            location_ = input.readMessage(com.dji.TigerApp.protobuf.Location.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(location_);
              location_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            com.dji.TigerApp.protobuf.VehicleVelocity.Builder subBuilder = null;
            if (velocityXYZ_ != null) {
              subBuilder = velocityXYZ_.toBuilder();
            }
            velocityXYZ_ = input.readMessage(com.dji.TigerApp.protobuf.VehicleVelocity.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(velocityXYZ_);
              velocityXYZ_ = subBuilder.buildPartial();
            }

            break;
          }
          case 26: {
            com.dji.TigerApp.protobuf.VehicleAttitude.Builder subBuilder = null;
            if (attitude_ != null) {
              subBuilder = attitude_.toBuilder();
            }
            attitude_ = input.readMessage(com.dji.TigerApp.protobuf.VehicleAttitude.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(attitude_);
              attitude_ = subBuilder.buildPartial();
            }

            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            status_ = s;
            break;
          }
          case 40: {

            time_ = input.readInt64();
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
    return com.dji.TigerApp.protobuf.VehicleStatusOuterClass.internal_static_tutorial_VehicleStatus_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dji.TigerApp.protobuf.VehicleStatusOuterClass.internal_static_tutorial_VehicleStatus_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dji.TigerApp.protobuf.VehicleStatus.class, com.dji.TigerApp.protobuf.VehicleStatus.Builder.class);
  }

  public static final int LOCATION_FIELD_NUMBER = 1;
  private com.dji.TigerApp.protobuf.Location location_;
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
  public com.dji.TigerApp.protobuf.Location getLocation() {
    return location_ == null ? com.dji.TigerApp.protobuf.Location.getDefaultInstance() : location_;
  }
  /**
   * <code>.tutorial.Location location = 1;</code>
   */
  @java.lang.Override
  public com.dji.TigerApp.protobuf.LocationOrBuilder getLocationOrBuilder() {
    return getLocation();
  }

  public static final int VELOCITYXYZ_FIELD_NUMBER = 2;
  private com.dji.TigerApp.protobuf.VehicleVelocity velocityXYZ_;
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
  public com.dji.TigerApp.protobuf.VehicleVelocity getVelocityXYZ() {
    return velocityXYZ_ == null ? com.dji.TigerApp.protobuf.VehicleVelocity.getDefaultInstance() : velocityXYZ_;
  }
  /**
   * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
   */
  @java.lang.Override
  public com.dji.TigerApp.protobuf.VehicleVelocityOrBuilder getVelocityXYZOrBuilder() {
    return getVelocityXYZ();
  }

  public static final int ATTITUDE_FIELD_NUMBER = 3;
  private com.dji.TigerApp.protobuf.VehicleAttitude attitude_;
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
  public com.dji.TigerApp.protobuf.VehicleAttitude getAttitude() {
    return attitude_ == null ? com.dji.TigerApp.protobuf.VehicleAttitude.getDefaultInstance() : attitude_;
  }
  /**
   * <code>.tutorial.VehicleAttitude attitude = 3;</code>
   */
  @java.lang.Override
  public com.dji.TigerApp.protobuf.VehicleAttitudeOrBuilder getAttitudeOrBuilder() {
    return getAttitude();
  }

  public static final int STATUS_FIELD_NUMBER = 4;
  private volatile java.lang.Object status_;
  /**
   * <code>string status = 4;</code>
   * @return The status.
   */
  @java.lang.Override
  public java.lang.String getStatus() {
    java.lang.Object ref = status_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      status_ = s;
      return s;
    }
  }
  /**
   * <code>string status = 4;</code>
   * @return The bytes for status.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getStatusBytes() {
    java.lang.Object ref = status_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      status_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TIME_FIELD_NUMBER = 5;
  private long time_;
  /**
   * <code>int64 time = 5;</code>
   * @return The time.
   */
  @java.lang.Override
  public long getTime() {
    return time_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(status_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, status_);
    }
    if (time_ != 0L) {
      output.writeInt64(5, time_);
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(status_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, status_);
    }
    if (time_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, time_);
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
    if (!(obj instanceof com.dji.TigerApp.protobuf.VehicleStatus)) {
      return super.equals(obj);
    }
    com.dji.TigerApp.protobuf.VehicleStatus other = (com.dji.TigerApp.protobuf.VehicleStatus) obj;

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
    if (!getStatus()
        .equals(other.getStatus())) return false;
    if (getTime()
        != other.getTime()) return false;
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
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + getStatus().hashCode();
    hash = (37 * hash) + TIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getTime());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dji.TigerApp.protobuf.VehicleStatus parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dji.TigerApp.protobuf.VehicleStatus parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dji.TigerApp.protobuf.VehicleStatus parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dji.TigerApp.protobuf.VehicleStatus parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dji.TigerApp.protobuf.VehicleStatus parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dji.TigerApp.protobuf.VehicleStatus parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dji.TigerApp.protobuf.VehicleStatus parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dji.TigerApp.protobuf.VehicleStatus parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dji.TigerApp.protobuf.VehicleStatus parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dji.TigerApp.protobuf.VehicleStatus parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dji.TigerApp.protobuf.VehicleStatus parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dji.TigerApp.protobuf.VehicleStatus parseFrom(
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
  public static Builder newBuilder(com.dji.TigerApp.protobuf.VehicleStatus prototype) {
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
      com.dji.TigerApp.protobuf.VehicleStatusOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dji.TigerApp.protobuf.VehicleStatusOuterClass.internal_static_tutorial_VehicleStatus_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dji.TigerApp.protobuf.VehicleStatusOuterClass.internal_static_tutorial_VehicleStatus_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dji.TigerApp.protobuf.VehicleStatus.class, com.dji.TigerApp.protobuf.VehicleStatus.Builder.class);
    }

    // Construct using com.dji.TigerApp.protobuf.VehicleStatus.newBuilder()
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
      status_ = "";

      time_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dji.TigerApp.protobuf.VehicleStatusOuterClass.internal_static_tutorial_VehicleStatus_descriptor;
    }

    @java.lang.Override
    public com.dji.TigerApp.protobuf.VehicleStatus getDefaultInstanceForType() {
      return com.dji.TigerApp.protobuf.VehicleStatus.getDefaultInstance();
    }

    @java.lang.Override
    public com.dji.TigerApp.protobuf.VehicleStatus build() {
      com.dji.TigerApp.protobuf.VehicleStatus result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.dji.TigerApp.protobuf.VehicleStatus buildPartial() {
      com.dji.TigerApp.protobuf.VehicleStatus result = new com.dji.TigerApp.protobuf.VehicleStatus(this);
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
      result.status_ = status_;
      result.time_ = time_;
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
      if (other instanceof com.dji.TigerApp.protobuf.VehicleStatus) {
        return mergeFrom((com.dji.TigerApp.protobuf.VehicleStatus)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dji.TigerApp.protobuf.VehicleStatus other) {
      if (other == com.dji.TigerApp.protobuf.VehicleStatus.getDefaultInstance()) return this;
      if (other.hasLocation()) {
        mergeLocation(other.getLocation());
      }
      if (other.hasVelocityXYZ()) {
        mergeVelocityXYZ(other.getVelocityXYZ());
      }
      if (other.hasAttitude()) {
        mergeAttitude(other.getAttitude());
      }
      if (!other.getStatus().isEmpty()) {
        status_ = other.status_;
        onChanged();
      }
      if (other.getTime() != 0L) {
        setTime(other.getTime());
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
      com.dji.TigerApp.protobuf.VehicleStatus parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.dji.TigerApp.protobuf.VehicleStatus) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.dji.TigerApp.protobuf.Location location_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dji.TigerApp.protobuf.Location, com.dji.TigerApp.protobuf.Location.Builder, com.dji.TigerApp.protobuf.LocationOrBuilder> locationBuilder_;
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
    public com.dji.TigerApp.protobuf.Location getLocation() {
      if (locationBuilder_ == null) {
        return location_ == null ? com.dji.TigerApp.protobuf.Location.getDefaultInstance() : location_;
      } else {
        return locationBuilder_.getMessage();
      }
    }
    /**
     * <code>.tutorial.Location location = 1;</code>
     */
    public Builder setLocation(com.dji.TigerApp.protobuf.Location value) {
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
        com.dji.TigerApp.protobuf.Location.Builder builderForValue) {
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
    public Builder mergeLocation(com.dji.TigerApp.protobuf.Location value) {
      if (locationBuilder_ == null) {
        if (location_ != null) {
          location_ =
            com.dji.TigerApp.protobuf.Location.newBuilder(location_).mergeFrom(value).buildPartial();
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
    public com.dji.TigerApp.protobuf.Location.Builder getLocationBuilder() {
      
      onChanged();
      return getLocationFieldBuilder().getBuilder();
    }
    /**
     * <code>.tutorial.Location location = 1;</code>
     */
    public com.dji.TigerApp.protobuf.LocationOrBuilder getLocationOrBuilder() {
      if (locationBuilder_ != null) {
        return locationBuilder_.getMessageOrBuilder();
      } else {
        return location_ == null ?
            com.dji.TigerApp.protobuf.Location.getDefaultInstance() : location_;
      }
    }
    /**
     * <code>.tutorial.Location location = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dji.TigerApp.protobuf.Location, com.dji.TigerApp.protobuf.Location.Builder, com.dji.TigerApp.protobuf.LocationOrBuilder> 
        getLocationFieldBuilder() {
      if (locationBuilder_ == null) {
        locationBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dji.TigerApp.protobuf.Location, com.dji.TigerApp.protobuf.Location.Builder, com.dji.TigerApp.protobuf.LocationOrBuilder>(
                getLocation(),
                getParentForChildren(),
                isClean());
        location_ = null;
      }
      return locationBuilder_;
    }

    private com.dji.TigerApp.protobuf.VehicleVelocity velocityXYZ_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dji.TigerApp.protobuf.VehicleVelocity, com.dji.TigerApp.protobuf.VehicleVelocity.Builder, com.dji.TigerApp.protobuf.VehicleVelocityOrBuilder> velocityXYZBuilder_;
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
    public com.dji.TigerApp.protobuf.VehicleVelocity getVelocityXYZ() {
      if (velocityXYZBuilder_ == null) {
        return velocityXYZ_ == null ? com.dji.TigerApp.protobuf.VehicleVelocity.getDefaultInstance() : velocityXYZ_;
      } else {
        return velocityXYZBuilder_.getMessage();
      }
    }
    /**
     * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
     */
    public Builder setVelocityXYZ(com.dji.TigerApp.protobuf.VehicleVelocity value) {
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
        com.dji.TigerApp.protobuf.VehicleVelocity.Builder builderForValue) {
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
    public Builder mergeVelocityXYZ(com.dji.TigerApp.protobuf.VehicleVelocity value) {
      if (velocityXYZBuilder_ == null) {
        if (velocityXYZ_ != null) {
          velocityXYZ_ =
            com.dji.TigerApp.protobuf.VehicleVelocity.newBuilder(velocityXYZ_).mergeFrom(value).buildPartial();
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
    public com.dji.TigerApp.protobuf.VehicleVelocity.Builder getVelocityXYZBuilder() {
      
      onChanged();
      return getVelocityXYZFieldBuilder().getBuilder();
    }
    /**
     * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
     */
    public com.dji.TigerApp.protobuf.VehicleVelocityOrBuilder getVelocityXYZOrBuilder() {
      if (velocityXYZBuilder_ != null) {
        return velocityXYZBuilder_.getMessageOrBuilder();
      } else {
        return velocityXYZ_ == null ?
            com.dji.TigerApp.protobuf.VehicleVelocity.getDefaultInstance() : velocityXYZ_;
      }
    }
    /**
     * <code>.tutorial.VehicleVelocity velocityXYZ = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dji.TigerApp.protobuf.VehicleVelocity, com.dji.TigerApp.protobuf.VehicleVelocity.Builder, com.dji.TigerApp.protobuf.VehicleVelocityOrBuilder> 
        getVelocityXYZFieldBuilder() {
      if (velocityXYZBuilder_ == null) {
        velocityXYZBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dji.TigerApp.protobuf.VehicleVelocity, com.dji.TigerApp.protobuf.VehicleVelocity.Builder, com.dji.TigerApp.protobuf.VehicleVelocityOrBuilder>(
                getVelocityXYZ(),
                getParentForChildren(),
                isClean());
        velocityXYZ_ = null;
      }
      return velocityXYZBuilder_;
    }

    private com.dji.TigerApp.protobuf.VehicleAttitude attitude_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dji.TigerApp.protobuf.VehicleAttitude, com.dji.TigerApp.protobuf.VehicleAttitude.Builder, com.dji.TigerApp.protobuf.VehicleAttitudeOrBuilder> attitudeBuilder_;
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
    public com.dji.TigerApp.protobuf.VehicleAttitude getAttitude() {
      if (attitudeBuilder_ == null) {
        return attitude_ == null ? com.dji.TigerApp.protobuf.VehicleAttitude.getDefaultInstance() : attitude_;
      } else {
        return attitudeBuilder_.getMessage();
      }
    }
    /**
     * <code>.tutorial.VehicleAttitude attitude = 3;</code>
     */
    public Builder setAttitude(com.dji.TigerApp.protobuf.VehicleAttitude value) {
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
        com.dji.TigerApp.protobuf.VehicleAttitude.Builder builderForValue) {
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
    public Builder mergeAttitude(com.dji.TigerApp.protobuf.VehicleAttitude value) {
      if (attitudeBuilder_ == null) {
        if (attitude_ != null) {
          attitude_ =
            com.dji.TigerApp.protobuf.VehicleAttitude.newBuilder(attitude_).mergeFrom(value).buildPartial();
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
    public com.dji.TigerApp.protobuf.VehicleAttitude.Builder getAttitudeBuilder() {
      
      onChanged();
      return getAttitudeFieldBuilder().getBuilder();
    }
    /**
     * <code>.tutorial.VehicleAttitude attitude = 3;</code>
     */
    public com.dji.TigerApp.protobuf.VehicleAttitudeOrBuilder getAttitudeOrBuilder() {
      if (attitudeBuilder_ != null) {
        return attitudeBuilder_.getMessageOrBuilder();
      } else {
        return attitude_ == null ?
            com.dji.TigerApp.protobuf.VehicleAttitude.getDefaultInstance() : attitude_;
      }
    }
    /**
     * <code>.tutorial.VehicleAttitude attitude = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.dji.TigerApp.protobuf.VehicleAttitude, com.dji.TigerApp.protobuf.VehicleAttitude.Builder, com.dji.TigerApp.protobuf.VehicleAttitudeOrBuilder> 
        getAttitudeFieldBuilder() {
      if (attitudeBuilder_ == null) {
        attitudeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.dji.TigerApp.protobuf.VehicleAttitude, com.dji.TigerApp.protobuf.VehicleAttitude.Builder, com.dji.TigerApp.protobuf.VehicleAttitudeOrBuilder>(
                getAttitude(),
                getParentForChildren(),
                isClean());
        attitude_ = null;
      }
      return attitudeBuilder_;
    }

    private java.lang.Object status_ = "";
    /**
     * <code>string status = 4;</code>
     * @return The status.
     */
    public java.lang.String getStatus() {
      java.lang.Object ref = status_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        status_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string status = 4;</code>
     * @return The bytes for status.
     */
    public com.google.protobuf.ByteString
        getStatusBytes() {
      java.lang.Object ref = status_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        status_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string status = 4;</code>
     * @param value The status to set.
     * @return This builder for chaining.
     */
    public Builder setStatus(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string status = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatus() {
      
      status_ = getDefaultInstance().getStatus();
      onChanged();
      return this;
    }
    /**
     * <code>string status = 4;</code>
     * @param value The bytes for status to set.
     * @return This builder for chaining.
     */
    public Builder setStatusBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      status_ = value;
      onChanged();
      return this;
    }

    private long time_ ;
    /**
     * <code>int64 time = 5;</code>
     * @return The time.
     */
    @java.lang.Override
    public long getTime() {
      return time_;
    }
    /**
     * <code>int64 time = 5;</code>
     * @param value The time to set.
     * @return This builder for chaining.
     */
    public Builder setTime(long value) {
      
      time_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 time = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearTime() {
      
      time_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:tutorial.VehicleStatus)
  }

  // @@protoc_insertion_point(class_scope:tutorial.VehicleStatus)
  private static final com.dji.TigerApp.protobuf.VehicleStatus DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dji.TigerApp.protobuf.VehicleStatus();
  }

  public static com.dji.TigerApp.protobuf.VehicleStatus getDefaultInstance() {
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
  public com.dji.TigerApp.protobuf.VehicleStatus getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

