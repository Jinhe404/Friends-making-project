package com.partner.boot.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import cn.hutool.core.annotation.Alias;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
* <p>
* 
* </p>
*
* @author 金同学
* @since 2023-02-02
*/
@Getter
@Setter
@TableName("sys_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    // 用户名
    @ApiModelProperty("用户名")
    @Alias("用户名")
    private String username;

    // 密码
    @ApiModelProperty("密码")
    @Alias("密码")
    private String password;

    // 昵称
    @ApiModelProperty("昵称")
    @Alias("昵称")
    private String name;

    // 唯一标识
    @ApiModelProperty("唯一标识")
    @Alias("唯一标识")
    private String uid;

    // 逻辑删除字段
    @ApiModelProperty("逻辑删除")
    @TableLogic(value = "0",delval = "id")
    private Integer deleted;
    // 创建时间
    @ApiModelProperty("创建时间")
    @Alias("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
/*
* 插入和更新都写此字段
* 若使用FieldFill.UPDATE,则只更新此字段
* */

    // 更新时间
    @ApiModelProperty("更新时间")
    @Alias("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

}