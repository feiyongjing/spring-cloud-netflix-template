package com.eric.springcloud.goods.portal.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MySink {
    String INPUT = "myinput";

    @Input(MySink.INPUT)
    SubscribableChannel input();
}
