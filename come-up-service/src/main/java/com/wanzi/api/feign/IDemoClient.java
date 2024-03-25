package com.wanzi.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 功能描述:
 *
 * @author: qiu wanzi
 * @date: 2024年3月22日 0022
 * @version: 1.0
 */
@FeignClient(name = "spring-come-up", contextId = "spring-come-up-1")
public interface IDemoClient {

    @GetMapping("/feign/demo")
    String getData();
}
