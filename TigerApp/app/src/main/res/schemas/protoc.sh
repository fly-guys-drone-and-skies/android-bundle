# Run this from this directory.
rm -r ../../java/src/main/com/dji/TigerApp/protobuf/

# Assumes you have the protobuf-schemas repo right next to the this (the android-bundle) repo.
# Should just use the ones in this directory already if you don't.
cp ../../../../../../../protobuf-schemas/*.proto ./
sed -i "s/PACKAGENAME/com.dji.TigerApp.protobuf/g" VehicleStatus.proto
sed -i "s/PACKAGENAME/com.dji.TigerApp.protobuf/g" Route.proto

protoc -I=./ --java_out=../../java/ Route.proto
protoc -I=./ --java_out=../../java VehicleStatus.proto
