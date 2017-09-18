package com.yeshimin.test.springcloud.zuulserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Called for testing Zuul
 *
 * @author yeshimin
 * @since 2017-09-18
 */
@RestController
@RequestMapping("zuulserver")
public class ZuulServerController {
    private static final Logger logger = LoggerFactory.getLogger(ZuulServerController.class);

    @GetMapping("test")
    public Object test() {
        logger.info("ZuulServerController.test()");

        return "msg from service1 zuul server";
    }
}
