package com.wanzi.infrastructure.db.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 字典
 * @TableName config_dictionary
 */
@TableName(value ="config_dictionary")
@Data
public class ConfigDictionaryEntity implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String dictionaryKey;

    /**
     * 
     */
    private String value;

    /**
     * 1只能由系统管理员维护，0可由用户维护
     */
    private Integer isSystem;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 
     */
    private String createBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 
     */
    private String updateBy;

    /**
     * 版本号
     */
    private Long version;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}