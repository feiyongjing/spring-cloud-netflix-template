package com.eric.springcloud.service.goods.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

// 将channels(信道)和exchange(交换机)绑定在一起
@EnableBinding({Source.class})
public class SenderMessage {
    @Autowired
    private MessageChannel output; // 消息发送的信道，jar包处理好了直接注入就行

    public void publish(String msg){
        boolean flag = output.send(MessageBuilder.withPayload(msg).build());
        System.out.println("发送消息："+msg+"是否成功："+flag);
    }
}
