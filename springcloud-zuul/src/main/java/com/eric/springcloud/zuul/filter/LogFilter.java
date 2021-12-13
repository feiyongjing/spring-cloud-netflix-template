package com.eric.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LogFilter extends ZuulFilter {
    /**
     * 过滤器类型，可选值有 pre、route、post、error。根据不同的业务使用不同的类型
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器的执行顺序，数值越小，优先级越高。根据多个业务的优先级来决定
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER;
    }

    /**
     * 是否执行该过滤器，true 为执行，false 为不执行，这个也可以利用配置中心来实现，达到动态的开启和关闭过滤器。
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 执行自己的业务过滤逻辑
     * @return 返回值是没有意义的，返回null就可以了
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        System.out.println("访问的地址："+request.getServerName()+request.getRequestURI());
        return null;
    }
}
