package com.yeshimin.test.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yeshimin
 * @since 2017-09-05
 */
@RestController
@RequestMapping("ribbontest")
public class RibbonLoadBalanceTestController {
    private static final Logger logger = LoggerFactory.getLogger(RibbonLoadBalanceTestController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("test")
    public Object test() {
        logger.info("RibbonLoadBalanceTestController.test()");

        // use service aplication name, not service instance name
        return restTemplate.getForEntity("http://service1-application-name/test/test", String.class).getBody();
    }
}
