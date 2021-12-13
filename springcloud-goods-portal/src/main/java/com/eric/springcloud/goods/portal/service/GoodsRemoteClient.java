package com.eric.springcloud.goods.portal.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


//@FeignClient(value = "SPRING-CLOUD-GOODS",
//        fallback = GoodsRemoteClientFallBack.class
@FeignClient(value = "SPRING-CLOUD-GOODS",
        fallbackFactory = GoodsRemoteClientFallBackFactory.class
)
public interface GoodsRemoteClient {
    /**
     * 声明一个Feign的接口，它的实现是服务提供者的Controller层实现
     * 微服务的消费者调用当前接口就相当于调用服务提供者的Controller层
     */
//    @RequestMapping(value = "/goods/test",method = RequestMethod.GET)
    @GetMapping("/goods/test")
    String getTest(@RequestParam("goodsId")String goodsId);
}
