package com.wanzi.domain.aggregateUser;

import com.wanzi.controller.dto.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author: qiu wanzi
 * @date: 2024年12月20日 星期五
 * @version: 1.0
 */
@Service
public class UserGraphqlService {
    private final Map<String, User> users = new HashMap<>();

    public UserGraphqlService() {
        users.put("1", new User("1", "Alice", "alice@example.com"));
    }

    public User findUserById(String id) {
        return users.get(id);
    }

    public User updateUser(String id, String email) {
        User user = users.get(id);
        if (user != null) {
            user.setEmail(email);
        }
        return user;
    }
}
