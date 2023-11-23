package org.example;

import io.grpc.stub.StreamObserver;
import org.example.grpc.GreetingServiceGrpc;
import org.example.grpc.HelloService;


public class GreetingServiceImp extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting (HelloService.HelloRequest request,
                          StreamObserver<HelloService.HelloResponse> responseObserver) {

        System.out.println(request);

        HelloService.HelloResponse response = HelloService.HelloResponse.newBuilder()
                .setGreeting("Hello from server, " + request.getName()).build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
