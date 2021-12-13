package com.eric.springcloud.service.goods.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class GoodsController {

    //    @RequestMapping(value = "/goods/test",method = RequestMethod.GET)
    @GetMapping("/goods/test")
    public String getTest(@RequestParam("goodsId") String goodsId) {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        String str = null;
        if (str == null) {
            throw new RuntimeException("消费者异常");
        }
        return "goodsInfo:" + goodsId;
    }
}
