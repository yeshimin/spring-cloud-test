package com.yeshimin.test.springcloud.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Mesage receiver
 *
 * @author yeshimin
 * @since 2017-09-21
 */
@Component
@RabbitListener(queues = "testreceiver")
public class Receiver {
    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    @RabbitHandler
    public void handle(String msg) {
        logger.info("Receiver.handle(), msg: {}", msg);
    }
}
