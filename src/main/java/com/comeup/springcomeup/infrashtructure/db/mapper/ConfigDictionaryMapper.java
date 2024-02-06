package com.comeup.springcomeup.infrashtructure.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.comeup.springcomeup.infrashtructure.db.domain.ConfigDictionaryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author Administrator
* @description 针对表【config_dictionary(字典)】的数据库操作Mapper
* @createDate 2024-02-06 11:18:22
* @Entity com/comeup/springcomeup/infrashtructure/db.domain.ConfigDictionaryEntity
*/
public interface ConfigDictionaryMapper extends BaseMapper<ConfigDictionaryEntity> {

}




