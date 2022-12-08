# Run this from this directory.
rm generated/Route*
rm generated/Vehicle*
# Assumes you have the protobuf-schemas repo right next to the this (the android-bundle) repo.
# Should just use the ones in this directory already if you don't.
cp ../../../../../../../../../../../../protobuf-schemas/*.proto ./

protoc -I=./ --java_out=../../../../../../ Route.proto
protoc -I=./ --java_out=../../../../../../ VehicleStatus.proto
