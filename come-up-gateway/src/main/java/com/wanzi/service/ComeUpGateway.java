package com.wanzi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 功能描述:
 *
 * @author: qiu wanzi
 * @date: 2024年3月26日 0026
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class ComeUpGateway {
    public static void main(String[] args) {
        SpringApplication.run(ComeUpGateway.class, args);
        log.info("success");
    }
}