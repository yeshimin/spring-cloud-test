package com.yeshimin.test.springcloud.hystrixclient;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Filter for initializing HystrixRequestContext when use Hystrix @CacheResult annotation
 *
 * @author yeshimin
 * @since 2017-09-16
 */
@Component
@WebFilter(urlPatterns = "/hystrixclient/**")
public class HystrixRequestContextInitFilter extends GenericFilterBean {
    private static final Logger logger = LoggerFactory.getLogger(HystrixRequestContextInitFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("HystrixRequestContextInitFilter.doFilter()");

        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            chain.doFilter(request, response);
        } finally {
            context.shutdown();
        }
    }
}
