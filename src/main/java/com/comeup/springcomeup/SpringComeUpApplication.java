package com.comeup.springcomeup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * DDD 模型 domain-driven design
 * 领域驱动设计模型
 *
 */
@SpringBootApplication
public class SpringComeUpApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringComeUpApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringComeUpApplication.class, args);
        LOGGER.info("success");
    }

}
