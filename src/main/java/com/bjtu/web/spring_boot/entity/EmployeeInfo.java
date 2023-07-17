package com.bjtu.web.spring_boot.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


@TableName("employee_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "员工信息实体类")
public class EmployeeInfo {
    @ApiModelProperty(value = "工作人员id")
    @TableId(type = IdType.AUTO)
    private Integer id;


    @ApiModelProperty(value = "工作人员姓名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "性别")
    @TableField("gender")
    private String gender;

    @ApiModelProperty(value = "电话号码")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "身份证号码")
    @TableField("id_card")
    private String idCard;

    @ApiModelProperty(value = "出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @TableField("birthday")
    private LocalDateTime  birthday;

    @ApiModelProperty(value = "入职日期")
    @TableField("hire_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime  hireDate;
    @ApiModelProperty(value = "标识")
    @TableField("flag")
    private Integer flag;
    @ApiModelProperty(value = "离职日期")
    @TableField("resign_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime  resignDate;

    @ApiModelProperty(value = "图像目录")
    @TableField("imgset_dir")
    private String imgsetDir;

    @ApiModelProperty(value = "头像路径")
    @TableField("profile_photo")
    private String profilePhoto;

    @ApiModelProperty(value = "描述")
    @TableField("DESCRIPTION")
    private String description;

    @ApiModelProperty(value = "是否有效")
    @TableField("ISACTIVE")
    private String isActive;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "CREATED", fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime created;

    @ApiModelProperty(value = "创建者ID")
    @TableField("CREATEBY")
    private Integer createdBy;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "UPDATED", fill = FieldFill.UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updated;

    @ApiModelProperty(value = "更新者ID")
    @TableField("UPDATEBY")
    private Integer updatedBy;

    @ApiModelProperty(value = "删除标记")
    @TableField("REMOVE")
    private String remove;

    // Getters and Setters
}