package com.yeshimin.test.springcloud.registry2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Registry2Application {

	public static void main(String[] args) {
		SpringApplication.run(Registry2Application.class, args);
	}
}
