rm generated/Route*
protoc -I=./ --java_out=../../../../../../../ Route.proto
