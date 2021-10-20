package com.pkslow.grpc;

import com.pkslow.grpc.gen.OrderRespone;
import com.pkslow.grpc.gen.OrderServiceGrpc;

public class OrderServiceImpl extends OrderServiceGrpc.OrderServiceImplBase {
    @Override
    public void getOrder(com.pkslow.grpc.gen.OrderRequest request,
                         io.grpc.stub.StreamObserver<OrderRespone> responseObserver) {
        System.out.println("Request from Client: " + request);

        int orderId = request.getOrderId();

        OrderRespone respone = OrderRespone.newBuilder()
                .setOrderId(orderId)
                .setPrice(orderId + 100)
                .setName("Pumpkin" + orderId)
                .build();

        responseObserver.onNext(respone);
        responseObserver.onCompleted();
    }
}
