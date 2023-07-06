package com.bjtu.web.spring_boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@TableName("sys_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "系统用户实体类")
public class SysUser {
    @ApiModelProperty(value = "系统管理员id")
    @TableId(type = IdType.AUTO)
    private Integer id;



    @ApiModelProperty(value = "用户名")
    @TableField("UserName")
    private String userName;

    @ApiModelProperty(value = "密码")
    @TableField("Password")
    private String password;

    @ApiModelProperty(value = "真实姓名")
    @TableField("REAL_NAME")
    private String realName;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    private String sex;

    @ApiModelProperty(value = "电子邮件")
    @TableField("EMAIL")
    private String email;

    @ApiModelProperty(value = "电话号码")
    @TableField("PHONE")
    private String phone;

    @ApiModelProperty(value = "手机号码")
    @TableField("MOBILE")
    private String mobile;

    @ApiModelProperty(value = "描述")
    @TableField("DESCRIPTION")
    private String description;

    @ApiModelProperty(value = "是否激活")
    @TableField("ISACTIVE")
    private String isActive;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime created;

    @ApiModelProperty(value = "创建者")
    @TableField("CREATEBY")
    private Integer createBy;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATED")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updated;

    @ApiModelProperty(value = "更新者")
    @TableField("UPDATEBY")
    private Integer updateBy;

    @ApiModelProperty(value = "是否移除")
    @TableField("REMOVE")
    private String remove;

    @ApiModelProperty("token")
    @TableField(exist = false)
    private String token;

    // Getters and Setters
}