package com.yeshimin.test.springcloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign client test service
 *
 * @author yeshimin
 * @since 2017-09-12
 */
@FeignClient(name = "service1-application-name", fallback = FeignCallTestHystrixFallback.class)
public interface FeignClientTestService {

    @GetMapping("/feignserver/test")
    String test();

    @GetMapping("/hystrixserver/test2")
    String test2();

    @GetMapping("/sleuthserver/test")
    String sleuthservertest();
}
