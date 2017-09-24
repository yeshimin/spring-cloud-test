package com.yeshimin.test.springcloud.sleuthclient;

import com.yeshimin.test.springcloud.feign.FeignClientTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sleuth Client
 *
 * @author yeshimin
 * @since 2017-09-24
 */
@RestController
@RequestMapping("sleuthclient")
public class SleuthClientController {
    private static final Logger logger = LoggerFactory.getLogger(SleuthClientController.class);

    @Autowired
    private FeignClientTestService feignClientTestService;

    @GetMapping("test")
    public Object test() {
        logger.info("SleuthClientController.test()");

        return feignClientTestService.sleuthservertest();
    }
}
