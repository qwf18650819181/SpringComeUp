package com.wanzi.controller.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述:
 *
 * @author: qiu wanzi
 * @date: 2024年3月22日 0022
 * @version: 1.0
 */
@RestController
public class DemoClient {
    @GetMapping("/feign/demo")
    public String demo() {
        return "Hello from the remote service!";
    }
}
