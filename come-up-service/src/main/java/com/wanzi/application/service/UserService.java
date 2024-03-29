package com.wanzi.application.service;

import cn.hutool.core.lang.UUID;
import com.wanzi.application.req.CreateUserReq;
import com.wanzi.domain.aggregateA.entity.User;
import com.wanzi.infrastructure.es.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述:
 *
 * @author: qiu wanzi
 * @date: 2024年3月28日 0028
 * @version: 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User createUser(CreateUserReq req) {
        User user = User.builder()
                .id(UUID.fastUUID().toString())
                .name(req.getName())
                .age(req.getAge())
                .build();
        return userRepo.save(user);
    }

    public List<User> queryUserByName(String name) {
        return userRepo.findAllByName(name);
    }


}
