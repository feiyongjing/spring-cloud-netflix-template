package com.eric.springcloud.goods.portal.service;


import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class GoodsRemoteClientFallBackFactory implements FallbackFactory<GoodsRemoteClient> {
    @Override
    public GoodsRemoteClient create(Throwable cause) {
        return new GoodsRemoteClient(){
            @Override
            public String getTest(String goodsId) {
                System.out.println("获取异常信息"+cause.getMessage());
                System.out.println("hystrix整合Feign");
                System.out.println("goodsId是"+goodsId);
                return "调用服务时，服务熔断降级了";
            }
        };
    }
}
