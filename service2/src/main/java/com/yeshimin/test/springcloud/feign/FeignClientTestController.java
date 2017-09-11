package com.yeshimin.test.springcloud.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Feign client test controller
 *
 * @author yeshimin
 * @since 2017-09-12
 */
@RestController
@RequestMapping("feignclient")
public class FeignClientTestController {
    private static final Logger logger = LoggerFactory.getLogger(FeignClientTestController.class);

    @Autowired
    private FeignClientTestService feignClientTestService;

    @GetMapping("test")
    public String test() {
        logger.info("FeignClientTestController.test()");

        return feignClientTestService.test();
    }
}
