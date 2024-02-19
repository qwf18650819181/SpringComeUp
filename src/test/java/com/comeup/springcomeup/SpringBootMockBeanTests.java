package com.comeup.springcomeup;

import com.comeup.springcomeup.infrashtructure.db.domain.ConfigDictionaryEntity;
import com.comeup.springcomeup.infrashtructure.db.service.ConfigDictionaryService;
import com.comeup.springcomeup.infrashtructure.db.service.impl.TestServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class SpringBootMockBeanTests {

    @Autowired
    private ConfigDictionaryService configDictionaryService;

    @MockBean
    private TestServiceImpl testService;

//    @SpyBean
//    private TestService testService1;

    @BeforeEach
    void init() {
//        when(testService1.test()).thenReturn(5);
    }

    @Test
    void contextLoads() {
        ConfigDictionaryEntity configDictionaryEntity = configDictionaryService.getDictionaryByCode("2");
        System.out.println(configDictionaryEntity);
    }

}
