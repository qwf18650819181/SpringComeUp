package com.wanzi.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * DDD 模型 domain-driven design
 * 领域驱动设计模型
 *
 */
@SpringBootApplication
@EnableFeignClients(basePackages = "com.wanzi.api.feign")
@EnableDiscoveryClient
public class ComeUpRemoteApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComeUpRemoteApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ComeUpRemoteApplication.class, args);
        LOGGER.info("success");
    }

}
