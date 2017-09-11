package com.yeshimin.test.springcloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Called for Feign Client
 *
 * @author yeshimin
 * @since 2017-09-12
 */
@RestController
@RequestMapping("feignserver")
public class FeignCallTestController {
    private static final Logger logger = LoggerFactory.getLogger(FeignCallTestController.class);

    @GetMapping("test")
    public String test() {
        logger.info("FeignCallTestController.test()");

        return "feign server test";
    }
}
