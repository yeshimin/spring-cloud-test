package com.yeshimin.test.springcloud.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yeshimin
 * @since 2017-09-21
 */
@RestController
@RequestMapping("rabbitmq")
public class RabbitMQTestController {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQTestController.class);

    @Autowired
    private Sender sender;

    @GetMapping("test")
    public Object test() {
        logger.info("RabbitMQTestController.test()");

        sender.send("hello");

        return "test";
    }
}
