package com.eric.springcloud.parent.demo.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface GoodsRemoteClient {
    @GetMapping("/test")
    String getTest(@RequestParam("goodsId")String goodsId);
}
