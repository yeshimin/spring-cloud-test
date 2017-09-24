package com.yeshimin.test.springcloud.sleuthserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sleuth Server
 *
 * @author yeshimin
 * @since 2017-09-14
 */
@RestController
@RequestMapping("sleuthserver")
public class SleuthServerController {
    private static final Logger logger = LoggerFactory.getLogger(SleuthServerController.class);

    @GetMapping("test")
    public Object test() {
        logger.info("SleuthServerController.test()");

        return "msg from sleuth server test()";
    }
}
