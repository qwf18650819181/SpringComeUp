package com.wanzi;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

/**
 *
 * DDD 模型 domain-driven design
 * 领域驱动设计模型
 *
 */
@SpringBootApplication
@MapperScan("com.wanzi.infrastructure.db.mapper")
@EnableCaching
@EnableKafka
@EnableFeignClients(basePackages = "com.wanzi.api")
@EnableDiscoveryClient
public class SpringComeUpApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringComeUpApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringComeUpApplication.class, args);
        LOGGER.info("success");
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mybatisPlusInterceptor;
    }

}
