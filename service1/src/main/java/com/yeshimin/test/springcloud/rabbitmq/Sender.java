package com.yeshimin.test.springcloud.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Message sender
 *
 * @author yeshimin
 * @since 2017-09-21
 */
@Component
public class Sender {
    private static final Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg) {
        logger.info("Sender.send(), msg: {}", msg);

        amqpTemplate.convertAndSend("testreceiver", msg);
    }
}
