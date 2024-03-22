package com.wanzi.remote.controller;

import com.wanzi.api.feign.IDemoClient;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DemoController {

    @Autowired
    IDemoClient iDemoClient;

    @GetMapping("/feign/demo")
    public String getData() {
        return iDemoClient.getData();
    }




}
