package com.comeup.springcomeup.infrashtructure.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comeup.springcomeup.infrashtructure.db.domain.ConfigDictionaryEntity;
import com.comeup.springcomeup.infrashtructure.db.mapper.ConfigDictionaryMapper;
import com.comeup.springcomeup.infrashtructure.db.service.ConfigDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
* @author Administrator
* @description 针对表【config_dictionary(字典)】的数据库操作Service实现
* @createDate 2024-02-06 11:18:22
*/
@Service
public class ConfigDictionaryServiceImpl extends ServiceImpl<ConfigDictionaryMapper, ConfigDictionaryEntity>
    implements ConfigDictionaryService {

    @Autowired
    TestServiceImpl testService;


    @Override
    public ConfigDictionaryEntity getDictionaryByCode(String code) {
        ConfigDictionaryEntity configDictionaryEntity = Optional.ofNullable(this.getById(code)).orElse(new ConfigDictionaryEntity());
        configDictionaryEntity.setValue(String.valueOf(testService.test()));
        return configDictionaryEntity;
    }

    @Override
    public ConfigDictionaryEntity getDictionaryByCode() {
        ConfigDictionaryEntity configDictionaryEntity = new ConfigDictionaryEntity();
        configDictionaryEntity.setValue(String.valueOf(testService.test()));
        return configDictionaryEntity;
    }
}




