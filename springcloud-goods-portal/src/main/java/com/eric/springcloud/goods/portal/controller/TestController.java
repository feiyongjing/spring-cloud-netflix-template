package com.eric.springcloud.goods.portal.controller;

import com.eric.springcloud.goods.portal.service.GoodsRemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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

    // 注意SPRING-CLOUD-GOODS是微服务程序的名字，而不是注册中心服务实例的id
    public static String GOODS_SERVICE_URL_2="http://SPRING-CLOUD-GOODS/goods/test?goodsId={goodsId}";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpHeaders httpHeaders;

    @GetMapping("/parent_test1")
    public String getTest(@RequestParam("aaa") String goodsId){
        Map<String,String> params=new HashMap<>();
        params.put("goodsId",goodsId);
        // 第一参数是微服务的url，第二参数是响应类型，第三参数是请求的实际参数
        ResponseEntity<String> entity = restTemplate.getForEntity(GOODS_SERVICE_URL_2, String.class,params);

//        第一参数是微服务的url，第二参数是请求的方式，第三参数是请求实体内部包含请求头，第四参数是响应类型，第五参数是请求的实际参数
//        ResponseEntity<String> entity = restTemplate.exchange(GOODS_SERVICE_URL_2, HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class,params);
        System.out.println(entity.getStatusCode());
        System.out.println(entity.getStatusCodeValue());
        System.out.println(entity.getHeaders());
        System.out.println(entity.getBody());
        return entity.getBody();
    }




}
