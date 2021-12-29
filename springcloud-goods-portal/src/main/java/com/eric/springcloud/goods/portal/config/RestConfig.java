package com.eric.springcloud.goods.portal.config;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Configuration
public class RestConfig {
    @LoadBalanced // 使用Ribbon实现负载均衡调用
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 进行HTTP头信息配置
     */
    @Bean
    public HttpHeaders getHttpHeaders(){
        // 定义HTTP头部信息
        HttpHeaders httpHeaders=new HttpHeaders();
        // 认证的原始信息
        String auth="cat:123456";
        // 进行加密处理
        byte[] encodeAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.US_ASCII));
        String authHeader="Basic "+new String(encodeAuth);
        httpHeaders.set("Authorization",authHeader);
        return httpHeaders;
    }

    @Bean
    public RandomRule iRule(){
        return new RandomRule();
    }

}
