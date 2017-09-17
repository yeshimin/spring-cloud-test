package com.yeshimin.test.springcloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Feign Hystrix fallback class
 *
 * @author yeshimin
 * @since 2017-09-16
 */
@Component
public class FeignCallTestHystrixFallback implements FeignClientTestService {
    private static final Logger logger = LoggerFactory.getLogger(FeignCallTestHystrixFallback.class);

    @Override
    public String test() {
        logger.info("FeignCallTestHystrixFallback.test()");

        return "FeignCallTestHystrixFallback.test";
    }

    @Override
    public String test2() {
        logger.info("FeignCallTestHystrixFallback.test2()");

        return "FeignCallTestHystrixFallback.test2";
    }
}
