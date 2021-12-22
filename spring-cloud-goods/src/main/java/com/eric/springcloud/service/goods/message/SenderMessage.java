package com.eric.springcloud.service.goods.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

// 将channels(信道)和exchange(交换机)绑定在一起
@EnableBinding({MySource.class})
public class SenderMessage {
    @Autowired
    private MySource mySource;

    public void publish(String msg){
        boolean flag = mySource.output().send(MessageBuilder.withPayload(msg).build());
        System.out.println("发送消息："+msg+"是否成功："+flag);
    }
}
