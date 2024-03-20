package com.comeup.springcomeup.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: qiu wanzi
 * @date: 2024年2月29日 0029
 * @version: 1.0
 * @description: TODO
 */
@Data
public class Book {


    @Schema(description = "书名", example = "三国演义")
    private String title;
    @Schema(description = "作者", example = "罗贯中")
    private String author;


}
