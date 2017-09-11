package com.yeshimin.test.springcloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Feign client test service
 *
 * @author yeshimin
 * @since 2017-09-12
 */
@FeignClient("service1-application-name")
public interface FeignClientTestService {

    @RequestMapping("/feignserver/test")
    String test();
}
