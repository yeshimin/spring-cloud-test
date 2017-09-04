package com.yeshimin.test.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yeshimin
 * @since 2017-09-05
 */
@RestController
@RequestMapping("test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("test")
    public String test() {
        logger.info("TestController.test()");

        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        logger.info("host: {}, serviceId: {}", serviceInstance.getHost(), serviceInstance.getServiceId());
        logger.info("uri: {}, port: ", serviceInstance.getUri(), serviceInstance.getPort());
        logger.info("serviceInstance: {}", serviceInstance);

        List<String> listService = discoveryClient.getServices();
        logger.info("listService.size: {}", listService.size());
        for (String s : listService) {
            logger.info("service: {}", s);
        }

        // get by eureka.instance.appname
        List<ServiceInstance> listServiceInstance =
                discoveryClient.getInstances("service1-instance-appname");
        logger.info("get by eureka.instance.appname - listServiceInstance.size: " + listServiceInstance.size());


        // get by spring.application.name
        List<ServiceInstance> listServiceInstance2 =
                discoveryClient.getInstances("service1-application-name");
        logger.info("get by spring.application.name - listServiceInstance.size: " + listServiceInstance.size());


        return "test";
    }
}
