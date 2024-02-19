package com.comeup.springcomeup;

import com.comeup.springcomeup.infrashtructure.db.domain.ConfigDictionaryEntity;
import com.comeup.springcomeup.infrashtructure.db.service.impl.ConfigDictionaryServiceImpl;
import com.comeup.springcomeup.infrashtructure.db.service.impl.TestServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MockTests {

    @InjectMocks
    private ConfigDictionaryServiceImpl configDictionaryService;

    @Mock
    private TestServiceImpl testService;

//    @Spy
//    private TestServiceImpl testService1;

    @BeforeEach
    void init() {
//        when(testService1.test()).thenReturn("gate");
    }

    @Test
    void contextLoads() {
        ConfigDictionaryEntity configDictionaryEntity = configDictionaryService.getDictionaryByCode();
        System.out.println(configDictionaryEntity);
    }

}
