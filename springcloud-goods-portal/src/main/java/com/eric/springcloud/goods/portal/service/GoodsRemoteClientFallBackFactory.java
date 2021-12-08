package com.eric.springcloud.goods.dashboard.service;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class GoodsRemoteClientFallBackFactory implements FallbackFactory<GoodsRemoteClient> {
    @Override
    public GoodsRemoteClient create(Throwable cause) {
        return new GoodsRemoteClient(){
            @Override
            public String getTest(String goodsId) {
                System.out.println("获取异常信息"+cause.getMessage());
                return null;
            }
        };
    }
}
