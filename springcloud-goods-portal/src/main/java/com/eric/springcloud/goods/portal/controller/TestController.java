package com.eric.springcloud.goods.portal.controller;

import com.eric.springcloud.goods.portal.service.GoodsRemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parent_goods")
public class TestController {
    // 使用Feign调用
    GoodsRemoteClient goodsRemoteClient;

    @Autowired
    public TestController(GoodsRemoteClient goodsRemoteClient) {
        this.goodsRemoteClient = goodsRemoteClient;
    }

    @GetMapping("/parent_test")
    public String getTest1(@RequestParam("goodsId") String goodsId) {

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        String str = null;
//        if (str == null) {
//            throw new RuntimeException("消费者异常");
//        }
        return goodsRemoteClient.getTest(goodsId);
    }


//    public String fallback(@RequestParam("goodsId")String goodsId,Throwable throwable){
//        System.out.println("goodsId是"+goodsId);
//        return "调用服务时，服务熔断降级了";
//    }


}
