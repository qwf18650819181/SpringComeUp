package com.wanzi.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wanzi.infrastructure.db.domain.ConfigDictionaryEntity;
import com.wanzi.infrastructure.db.service.ConfigDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auth: qwf
 * @date: 2024年2月6日 0006
 * @description:
 */
@RestController
public class JdbcController {


    @Autowired
    ConfigDictionaryService configDictionaryService;


    @GetMapping("/jdbc")
    public List<ConfigDictionaryEntity> demo() {
        IPage page = new Page(1, 10);
        return configDictionaryService.page(page).getRecords();
    }


}
