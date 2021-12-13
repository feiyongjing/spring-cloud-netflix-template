package com.eric.springcloud.zuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * zuul服务降级
 */
@Component
public class ZuulFallback implements FallbackProvider {
    /**
     * @return 表示对哪些路由服务进行熔断降级
     */
    @Override
    public String getRoute() {
        return "*";
    }

    /**
     * zuul服务的降级方法
     * @param route 路由
     * @param cause 降级时抛出的异常
     * @return http响应的连接
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            /**
             * 返回http响应码
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            /**
             * 返回http响应码的值
             */
            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST.value();
            }

            /**
             * 返回http响应码对应的文本
             */
            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.BAD_REQUEST.getReasonPhrase();
            }

            /**
             * 一般不用写，response流自动关闭，可以用来做一些清理工作
             */
            @Override
            public void close() {
            }

            /**
             * http响应体
             */
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("服务正在维护，请稍后再试".getBytes());
            }

            /**
             * http响应头
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.set("Content-Type","application/json; charset=UTF-8");
                return httpHeaders;
            }
        };
    }
}
