package com.comeup.springcomeup.infrashtructure.db.service.impl;

import com.comeup.springcomeup.infrashtructure.db.service.TestService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【config_dictionary(字典)】的数据库操作Service实现
* @createDate 2024-02-06 11:18:22
*/
@Service
public class TestServiceImpl implements TestService {

    @Override
    public Integer test() {
        return 8;
    }

}




