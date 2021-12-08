package com.eric.springcloud.goods.dashboard.service;

import org.springframework.stereotype.Component;

@Component
public class GoodsRemoteClientFallBack implements GoodsRemoteClient{
    @Override
    public String getTest(String goodsId) {
        return null;
    }
}
