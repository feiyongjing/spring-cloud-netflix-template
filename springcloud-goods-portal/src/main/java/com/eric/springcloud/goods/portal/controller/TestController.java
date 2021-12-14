package com.eric.springcloud.goods.portal.controller;

import com.eric.springcloud.goods.portal.service.GoodsRemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/parent_goods")
public class TestController {
    // 使用Feign调用
    GoodsRemoteClient goodsRemoteClient;

    @Autowired
    public TestController(GoodsRemoteClient goodsRemoteClient) {
        this.goodsRemoteClient = goodsRemoteClient;
    }


    @Value(value = "${aaa.test}")
    Integer aaaTest;

    @Value(value = "${abc}")
    String abc;

    @Value(value = "${kkk}")
    String kkk;

    @GetMapping("/getTestConfig")
    public String getTest1() {
        return "获取的配置信息："+aaaTest;
    }

    @GetMapping("/parent_test")
    public String getTest1(@RequestParam("goodsId") String goodsId) {
        return goodsRemoteClient.getTest(goodsId);
    }




}
