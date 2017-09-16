package com.yeshimin.test.springcloud.hystrixclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Hystrix client service
 *
 * @author yeshimin
 * @since 2017-09-16
 */
@Service
public class HystrixClientService {
    private static final Logger logger = LoggerFactory.getLogger(HystrixClientService.class);

    @Autowired
    private RestTemplate restTemplate;

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

    @CacheResult(cacheKeyMethod = "getTest3CacheKey")
    @HystrixCommand(fallbackMethod = "testFallback3")
    public Object test3() {
        logger.info("HystrixClientService.test3()");

        // use service aplication name, not service instance name
        return restTemplate.getForEntity(
                "http://service1-application-name/hystrixserver/test2", String.class).getBody();
    }

    public Object testFallback3() {
        logger.info("HystrixClientService.testFallback3()");

        return "testFallback3";
    }

    private String getTest3CacheKey() {
        logger.info("HystrixClientController.getTest3CacheKey()");

        return "test3cachekey";
    }
}
