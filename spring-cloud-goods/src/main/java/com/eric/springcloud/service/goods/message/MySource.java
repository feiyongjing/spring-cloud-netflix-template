package com.eric.springcloud.service.goods.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MySource {

    String OUTPUT = "myoutput";

    @Output(MySource.OUTPUT)
    MessageChannel output();
}
