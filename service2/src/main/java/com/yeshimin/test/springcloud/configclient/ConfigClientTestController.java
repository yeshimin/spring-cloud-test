package com.yeshimin.test.springcloud.configclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Cloud Config client test
 *
 * @author yeshimin
 * @since 2017-09-20
 */
@RefreshScope
@RestController
@RequestMapping("configclient")
public class ConfigClientTestController {
    private static final Logger logger = LoggerFactory.getLogger(ConfigClientTestController.class);

    @Value("${from}")
    private String from;

    @Autowired
    private Environment env;

    @GetMapping("test")
    public Object test() {
        logger.info("ConfigClientTestController.test()");

        return String.format("value -> 'from': %s", from);
    }

    @GetMapping("test2")
    public Object test2() {
        logger.info("ConfigClientTestController.test2()");

        return String.format("env -> 'from': %s", env.getProperty("from", "undefined"));
    }
}
