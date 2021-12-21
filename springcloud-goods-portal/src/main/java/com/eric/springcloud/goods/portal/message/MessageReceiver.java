package com.eric.springcloud.goods.portal.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
public class MessageReceiver {

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("接收消息处理："+message.getPayload());
    }
}
