package com.wanzi.service.log;

import feign.Logger;
import org.springframework.cloud.openfeign.FeignLoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述:
 *
 * @author: qiu wanzi
 * @date: 2024年3月22日 0022
 * @version: 1.0
 */

@Configuration
public class NsyFeignLoggerFactory implements FeignLoggerFactory {
    private Logger logger;

    public NsyFeignLoggerFactory() {
    }

    public NsyFeignLoggerFactory(Logger logger) {
        this.logger = logger;
    }

    public Logger create(Class<?> type) {
        return (Logger)(this.logger != null ? this.logger : new NsyFeignLogger());
    }
}
