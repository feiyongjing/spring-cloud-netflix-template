package com.eric.springcloud.goods.dashboard.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SPRING-CLOUD-GOODS", // 声明调用微服务的名字
//        fallback = GoodsRemoteClientFallBack.class, // 声明服务降级方法所在的类
          fallbackFactory = GoodsRemoteClientFallBackFactory.class
)
public interface GoodsRemoteClient {
    /**
     * 声明一个Feign的接口，它的实现是服务提供者的Controller层实现
     * 微服务的消费者调用当前接口就相当于调用服务提供者的Controller层
     */
    @GetMapping("/test")
    String getTest(@RequestParam("goodsId")String goodsId);
}
