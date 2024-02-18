package com.comeup.springcomeup;

import com.comeup.springcomeup.infrashtructure.db.domain.ConfigDictionaryEntity;
import com.comeup.springcomeup.infrashtructure.db.service.ConfigDictionaryService;
import com.comeup.springcomeup.infrashtructure.db.service.impl.TestServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

@SpringBootTest
class SpringBootMockBeanTests {

    @Autowired
    private ConfigDictionaryService configDictionaryService;

    @MockBean
    private TestServiceImpl testService;

    @BeforeEach
    void init() {
        when(testService.test()).thenReturn("gate");
    }

    @Test
    void contextLoads() {
        ConfigDictionaryEntity configDictionaryEntity = configDictionaryService.getDictionaryByCode("2");
        System.out.println(configDictionaryEntity);
    }

}
