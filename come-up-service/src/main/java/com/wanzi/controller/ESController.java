package com.wanzi.controller;

import com.wanzi.application.req.CreateUserReq;
import com.wanzi.application.service.UserService;
import com.wanzi.domain.aggregateA.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auth: qwf
 * @date: 2024年2月6日 0006
 * @description:
 */
@RestController
@Tag(name = "ESController", description = "ESController")
public class ESController {

    @Autowired
    UserService userService;


    @GetMapping("/es/{name}")
    @Operation(summary = "查询", description = "查询")
    public List<User> queryUserByName(@PathVariable String name) {
        return userService.queryUserByName(name);
    }

    @PostMapping("/es/create")
    @Operation(summary = "es 创建demo", description = "创建demo")
    public User createUser(@RequestBody @Valid CreateUserReq req) {
        return userService.createUser(req);
    }




}
