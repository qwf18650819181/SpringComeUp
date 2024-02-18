package com.comeup.springcomeup.infrashtructure.db.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.comeup.springcomeup.infrashtructure.db.domain.ConfigDictionaryEntity;

/**
* @author Administrator
* @description 针对表【config_dictionary(字典)】的数据库操作Service
* @createDate 2024-02-06 11:18:22
*/
public interface ConfigDictionaryService extends IService<ConfigDictionaryEntity> {

    ConfigDictionaryEntity getDictionaryByCode(String code);

    ConfigDictionaryEntity getDictionaryByCode();


}
