# Run this from this directory.
rm generated/Route*
rm generated/Vehicle*
# Uncomment the 2 lines below to use the protobuf-schemas repo. May have to change depending on your repo location.
# cp ../../../../../../../../../../../../protobuf-schemas/*.proto ./
# sed -i "s/PACKAGENAME/com.dji.sdk.sample.tigersalvage.proto.generated/g" VehicleStatus.proto
# sed -i "s/PACKAGENAME/com.dji.sdk.sample.tigersalvage.proto.generated/g" Route.proto

protoc -I=./ --java_out=../../../../../../ Route.proto
protoc -I=./ --java_out=../../../../../../ VehicleStatus.proto
