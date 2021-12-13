package com.eric.springcloud.goods.portal.service;

import org.springframework.stereotype.Component;

//@Component
public class GoodsRemoteClientFallBack
//        implements GoodsRemoteClient
{
//    @Override
    public String getTest(String goodsId) {
        System.out.println("hystrix整合Feign");
        System.out.println("goodsId是"+goodsId);
        return "调用服务时，服务熔断降级了";
    }
}
