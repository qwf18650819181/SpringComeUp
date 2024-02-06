package com.comeup.springcomeup;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.comeup.springcomeup.infrashtructure.db.service.ConfigDictionaryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringComeUpApplicationTests {


    @Autowired
    ConfigDictionaryService configDictionaryService;

    @Test
    void contextLoads() {
        IPage page = new Page(1, 10);
        List records = configDictionaryService.page(page).getRecords();
        System.out.println(records);


    }

}
