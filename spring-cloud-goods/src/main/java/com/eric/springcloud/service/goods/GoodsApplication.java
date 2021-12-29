package com.eric.springcloud.service.goods;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.eric.springcloud.auth.AuthApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableApolloConfig
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackageClasses = {AuthApplication.class,GoodsApplication.class})
public class GoodsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GoodsApplication.class, args);

    }

}
