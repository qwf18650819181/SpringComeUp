package com.comeup.springcomeup;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.comeup.springcomeup.infrashtructure.db.domain.ConfigDictionaryEntity;
import com.comeup.springcomeup.infrashtructure.db.service.ConfigDictionaryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class SpringComeUpApplicationTests {

    @MockBean
    private ConfigDictionaryService configDictionaryService;

    IPage page = new Page(1, 10);
    @BeforeEach
    void init() {

        ConfigDictionaryEntity entity = new ConfigDictionaryEntity();
        entity.setId(23);
        page.setRecords(List.of(entity));
        when(configDictionaryService.page(page)).thenReturn(page);
    }

    @Test
    void contextLoads() {
        List records = configDictionaryService.page(page).getRecords();
        System.out.println(records);


    }

}
