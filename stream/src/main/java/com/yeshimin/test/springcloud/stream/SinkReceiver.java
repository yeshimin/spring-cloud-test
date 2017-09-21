package com.yeshimin.test.springcloud.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author yeshimin
 * @since 2017-09-22
 */
@EnableBinding(Sink.class)
public class SinkReceiver {
    private static final Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        logger.info("SinkReceiver.receive(), payload: {}", payload);
    }
}
