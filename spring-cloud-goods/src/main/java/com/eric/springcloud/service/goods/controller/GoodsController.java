package com.eric.springcloud.service.goods.controller;

import com.eric.springcloud.service.goods.message.SenderMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {
    @Autowired
    SenderMessage senderMessage;

    @GetMapping("/goods/test")
    public String getTest(@RequestParam("goodsId") String goodsId) {
        return "goodsInfo:" + goodsId;
    }

    @GetMapping("/goods/senderMessage")
    public void senderMessage(@RequestParam("message") String message) {
        System.out.println("业务处理");
        senderMessage.publish(message);
    }

}
