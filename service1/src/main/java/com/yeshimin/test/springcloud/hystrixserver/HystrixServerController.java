package com.yeshimin.test.springcloud.hystrixserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Called for hystrixserver test
 *
 * @author yeshimin
 * @since 2017-09-16
 */
@RestController
@RequestMapping("hystrixserver")
public class HystrixServerController {
    private static final Logger logger = LoggerFactory.getLogger(HystrixServerController.class);

    @GetMapping("test")
    public Object test() {
        logger.info("HystrixServerController.test()");

        return "msg from hystrixserver server";
    }

    @GetMapping("test2")
    public Object test2() throws InterruptedException {
        logger.info("HystrixServerController.test2()");

        Thread.sleep(new Random().nextInt(3000));

        return "msg from hystrixserver server.test2()";
    }
}
