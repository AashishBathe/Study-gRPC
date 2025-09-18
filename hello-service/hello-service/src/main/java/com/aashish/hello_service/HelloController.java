package com.aashish.hello_service;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aashish.grpc.FillerGrpc;
import com.aashish.grpc.WordReply;
import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;

@RestController
public class HelloController {
	
	@GrpcClient("filler")
	private FillerGrpc.FillerStub fillerStub;
	
	@GetMapping("/hello")
	public CompletableFuture<String> hello() {
		CompletableFuture<String> future = new CompletableFuture<>();
		fillerStub.getWord(Empty.getDefaultInstance(), new StreamObserver<WordReply>() {
			
			@Override
			public void onNext(WordReply value) {
				future.complete("Hello " + value.getWord());
			}
			
			@Override
			public void onError(Throwable t) {
				future.completeExceptionally(t);
				
			}
			
			@Override
			public void onCompleted() {
				// No-OP
				
			}
		});
		return future;
	}

}
