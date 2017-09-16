package com.yeshimin.test.springcloud.hystrixclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Hystrix client
 *
 * @author yeshimin
 * @since 2017-09-16
 */
@RestController
@RequestMapping("hystrixclient")
public class HystrixClientController {
    private static final Logger logger = LoggerFactory.getLogger(HystrixClientController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HystrixClientService hystrixClientService;

    @HystrixCommand(fallbackMethod = "testFallback")
    @GetMapping("test")
    public Object test() {
        logger.info("HystrixClientController.test()");

        // use service aplication name, not service instance name
        return restTemplate.getForEntity(
                "http://service1-application-name/hystrixserver/test", String.class).getBody();
    }

    public Object testFallback() {
        logger.info("testFallback");

        return "service unavaliable";
    }

    private String getTestCacheKey() {
        logger.info("HystrixClientController.getTestCacheKey()");

        return "testCacheKey";
    }

    // ========================================================================

    @GetMapping("test2")
    public Object test2() {
        logger.info("HystrixClientController.test2()");

        StringBuilder sb = new StringBuilder();
        sb
                .append(test2Service())
                .append("\n")
                .append(test2Service())
                .append("\n")
                .append(test2Service());

        return sb.toString();
    }

    // Below two annotations does not work here
    @CacheResult(cacheKeyMethod = "getTest2CacheKey")
    @HystrixCommand(fallbackMethod = "testFallback2")
    public Object test2Service() {
        logger.info("HystrixClientController.test2Service()");

        // use service aplication name, not service instance name
        return restTemplate.getForEntity(
                "http://service1-application-name/hystrixserver/test2", String.class).getBody();
    }

    public Object testFallback2() {
        logger.info("testFallback2()");

        return "service timeout";
    }

    private String getTest2CacheKey() {
        logger.info("HystrixClientController.getTest2CacheKey()");

        return "test2cachekey";
    }

    // ========================================================================

    @GetMapping("test3")
    public Object test3() {
        logger.info("HystrixClientController.test3()");

        HystrixRequestContext context = HystrixRequestContext.initializeContext();

        StringBuilder sb = new StringBuilder();
        sb.append(hystrixClientService.test3() + "\n");
        sb.append(hystrixClientService.test3() + "\n");
        sb.append(hystrixClientService.test3() + "\n");

        context.shutdown();

        return sb.toString();
    }
}
