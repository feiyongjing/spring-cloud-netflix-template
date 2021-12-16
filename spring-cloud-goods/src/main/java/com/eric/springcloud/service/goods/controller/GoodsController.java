package com.eric.springcloud.service.goods.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {

    @GetMapping("/goods/test")
    public String getTest(@RequestParam("goodsId") String goodsId) {
        return "goodsInfo:" + goodsId;
    }
}
