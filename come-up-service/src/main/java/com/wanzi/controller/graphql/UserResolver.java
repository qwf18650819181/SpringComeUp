package com.wanzi.controller.graphql;

import com.wanzi.controller.dto.User;
import com.wanzi.domain.aggregateUser.UserGraphqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * 功能描述:
 *
 * @author: qiu wanzi
 * @date: 2024年12月20日 星期五
 * @version: 1.0
 */
@Controller
public class UserResolver {

    @Autowired
    UserGraphqlService userService;


    @QueryMapping
    public User findUserById(@Argument String id) {
        return userService.findUserById(id);
    }

    @MutationMapping
    public User updateUser(@Argument String id, @Argument String email) {
        return userService.updateUser(id, email);
    }
}