package com.wanzi.controller;

import com.wanzi.controller.dto.Book;
import com.wanzi.infrastructure.mq.KafkaSendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth: qwf
 * @date: 2024年2月6日 0006
 * @description:
 */
@RestController
@Tag(name = "Demo API", description = "demo to spring doc")
public class DemoController {

    @Autowired
    KafkaSendService kafkaSendService;


    @GetMapping("/demo/{name}")
    @Operation(summary = "案例", description = "案例 action")
//    @ApiResponse(responseCode = "200", description = "demo success")
    public String demo(/*@Parameter(description = "request name")*/ @PathVariable String name) {
        return "demo";
    }

    @PostMapping("/demo/book")
    @Operation(summary = "book 案例", description = "book 案例 action")
//    @ApiResponse(responseCode = "200", description = "demoBook success")
    public Book demoBook(/*@io.swagger.v3.oas.annotations.parameters.RequestBody*/ @RequestBody Book request) {
        return request;
    }

    @GetMapping("/demo/kafka")
    @Operation(summary = "kafka 案例", description = "kafka 案例 action")
    public void demoKafka(@RequestParam String message) {
        kafkaSendService.sendDemo(message);
    }




}
