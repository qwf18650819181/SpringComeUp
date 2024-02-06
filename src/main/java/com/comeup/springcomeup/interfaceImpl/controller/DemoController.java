package com.comeup.springcomeup.interfaceImpl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth: qwf
 * @date: 2024年2月6日 0006
 * @description:
 */
@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo() {
        return "demo";
    }


}
