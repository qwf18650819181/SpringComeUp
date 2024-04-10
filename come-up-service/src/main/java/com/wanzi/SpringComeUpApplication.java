package com.wanzi;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.wanzi.infrastructure.redis.MessageSubscriber;
import com.wanzi.infrastructure.redis.RedisMessageConsumer;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Bean
    public MessageSubscriber messageSubscriber(RedisConnectionFactory connectionFactory, RedisMessageConsumer redisMessageConsumer) {
        return new MessageSubscriber(connectionFactory, redisMessageConsumer);
    }
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        return template;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        return RedisCacheManager.create(factory);
    }

}
