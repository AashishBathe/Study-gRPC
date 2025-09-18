package com.aashish.filler_service;

import com.aashish.grpc.FillerGrpc;
import com.aashish.grpc.WordReply;
import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class FillerServiceImpl extends FillerGrpc.FillerImplBase {
	
	public void getWord(Empty request, StreamObserver<WordReply> responseObserver) {
		WordReply reply = WordReply.newBuilder().setWord("world").build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
}
