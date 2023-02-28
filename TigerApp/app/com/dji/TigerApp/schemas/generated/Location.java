// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Route.proto

package com.dji.TigerApp.schemas.generated;

/**
 * Protobuf type {@code tutorial.Location}
 */
public final class Location extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tutorial.Location)
    LocationOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Location.newBuilder() to construct.
  private Location(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Location() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Location();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.dji.TigerApp.schemas.generated.Route.internal_static_tutorial_Location_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.dji.TigerApp.schemas.generated.Route.internal_static_tutorial_Location_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.dji.TigerApp.schemas.generated.Location.class, com.dji.TigerApp.schemas.generated.Location.Builder.class);
  }

  public static final int LAT_FIELD_NUMBER = 1;
  private double lat_;
  /**
   * <code>double lat = 1;</code>
   * @return The lat.
   */
  @java.lang.Override
  public double getLat() {
    return lat_;
  }

  public static final int LONG_FIELD_NUMBER = 2;
  private double long_;
  /**
   * <code>double long = 2;</code>
   * @return The long.
   */
  @java.lang.Override
  public double getLong() {
    return long_;
  }

  public static final int ALT_FIELD_NUMBER = 3;
  private float alt_;
  /**
   * <code>float alt = 3;</code>
   * @return The alt.
   */
  @java.lang.Override
  public float getAlt() {
    return alt_;
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
    if (java.lang.Double.doubleToRawLongBits(lat_) != 0) {
      output.writeDouble(1, lat_);
    }
    if (java.lang.Double.doubleToRawLongBits(long_) != 0) {
      output.writeDouble(2, long_);
    }
    if (java.lang.Float.floatToRawIntBits(alt_) != 0) {
      output.writeFloat(3, alt_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (java.lang.Double.doubleToRawLongBits(lat_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(1, lat_);
    }
    if (java.lang.Double.doubleToRawLongBits(long_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, long_);
    }
    if (java.lang.Float.floatToRawIntBits(alt_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(3, alt_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.dji.TigerApp.schemas.generated.Location)) {
      return super.equals(obj);
    }
    com.dji.TigerApp.schemas.generated.Location other = (com.dji.TigerApp.schemas.generated.Location) obj;

    if (java.lang.Double.doubleToLongBits(getLat())
        != java.lang.Double.doubleToLongBits(
            other.getLat())) return false;
    if (java.lang.Double.doubleToLongBits(getLong())
        != java.lang.Double.doubleToLongBits(
            other.getLong())) return false;
    if (java.lang.Float.floatToIntBits(getAlt())
        != java.lang.Float.floatToIntBits(
            other.getAlt())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + LAT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getLat()));
    hash = (37 * hash) + LONG_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getLong()));
    hash = (37 * hash) + ALT_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getAlt());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.dji.TigerApp.schemas.generated.Location parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dji.TigerApp.schemas.generated.Location parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dji.TigerApp.schemas.generated.Location parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dji.TigerApp.schemas.generated.Location parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dji.TigerApp.schemas.generated.Location parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.dji.TigerApp.schemas.generated.Location parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.dji.TigerApp.schemas.generated.Location parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dji.TigerApp.schemas.generated.Location parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dji.TigerApp.schemas.generated.Location parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.dji.TigerApp.schemas.generated.Location parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.dji.TigerApp.schemas.generated.Location parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.dji.TigerApp.schemas.generated.Location parseFrom(
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
  public static Builder newBuilder(com.dji.TigerApp.schemas.generated.Location prototype) {
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
   * Protobuf type {@code tutorial.Location}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tutorial.Location)
      com.dji.TigerApp.schemas.generated.LocationOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.dji.TigerApp.schemas.generated.Route.internal_static_tutorial_Location_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.dji.TigerApp.schemas.generated.Route.internal_static_tutorial_Location_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.dji.TigerApp.schemas.generated.Location.class, com.dji.TigerApp.schemas.generated.Location.Builder.class);
    }

    // Construct using com.dji.TigerApp.schemas.generated.Location.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      lat_ = 0D;

      long_ = 0D;

      alt_ = 0F;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.dji.TigerApp.schemas.generated.Route.internal_static_tutorial_Location_descriptor;
    }

    @java.lang.Override
    public com.dji.TigerApp.schemas.generated.Location getDefaultInstanceForType() {
      return com.dji.TigerApp.schemas.generated.Location.getDefaultInstance();
    }

    @java.lang.Override
    public com.dji.TigerApp.schemas.generated.Location build() {
      com.dji.TigerApp.schemas.generated.Location result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.dji.TigerApp.schemas.generated.Location buildPartial() {
      com.dji.TigerApp.schemas.generated.Location result = new com.dji.TigerApp.schemas.generated.Location(this);
      result.lat_ = lat_;
      result.long_ = long_;
      result.alt_ = alt_;
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
      if (other instanceof com.dji.TigerApp.schemas.generated.Location) {
        return mergeFrom((com.dji.TigerApp.schemas.generated.Location)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.dji.TigerApp.schemas.generated.Location other) {
      if (other == com.dji.TigerApp.schemas.generated.Location.getDefaultInstance()) return this;
      if (other.getLat() != 0D) {
        setLat(other.getLat());
      }
      if (other.getLong() != 0D) {
        setLong(other.getLong());
      }
      if (other.getAlt() != 0F) {
        setAlt(other.getAlt());
      }
      this.mergeUnknownFields(other.getUnknownFields());
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
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 9: {
              lat_ = input.readDouble();

              break;
            } // case 9
            case 17: {
              long_ = input.readDouble();

              break;
            } // case 17
            case 29: {
              alt_ = input.readFloat();

              break;
            } // case 29
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private double lat_ ;
    /**
     * <code>double lat = 1;</code>
     * @return The lat.
     */
    @java.lang.Override
    public double getLat() {
      return lat_;
    }
    /**
     * <code>double lat = 1;</code>
     * @param value The lat to set.
     * @return This builder for chaining.
     */
    public Builder setLat(double value) {
      
      lat_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double lat = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearLat() {
      
      lat_ = 0D;
      onChanged();
      return this;
    }

    private double long_ ;
    /**
     * <code>double long = 2;</code>
     * @return The long.
     */
    @java.lang.Override
    public double getLong() {
      return long_;
    }
    /**
     * <code>double long = 2;</code>
     * @param value The long to set.
     * @return This builder for chaining.
     */
    public Builder setLong(double value) {
      
      long_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double long = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearLong() {
      
      long_ = 0D;
      onChanged();
      return this;
    }

    private float alt_ ;
    /**
     * <code>float alt = 3;</code>
     * @return The alt.
     */
    @java.lang.Override
    public float getAlt() {
      return alt_;
    }
    /**
     * <code>float alt = 3;</code>
     * @param value The alt to set.
     * @return This builder for chaining.
     */
    public Builder setAlt(float value) {
      
      alt_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float alt = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearAlt() {
      
      alt_ = 0F;
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


    // @@protoc_insertion_point(builder_scope:tutorial.Location)
  }

  // @@protoc_insertion_point(class_scope:tutorial.Location)
  private static final com.dji.TigerApp.schemas.generated.Location DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.dji.TigerApp.schemas.generated.Location();
  }

  public static com.dji.TigerApp.schemas.generated.Location getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Location>
      PARSER = new com.google.protobuf.AbstractParser<Location>() {
    @java.lang.Override
    public Location parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<Location> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Location> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.dji.TigerApp.schemas.generated.Location getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
