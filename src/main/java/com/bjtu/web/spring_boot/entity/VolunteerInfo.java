package com.bjtu.web.spring_boot.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@TableName("volunteer_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "志愿者信息实体类")
public class VolunteerInfo {
    @ApiModelProperty(value = "义工id")
    @TableId(type = IdType.AUTO)
    private Integer id;


    @ApiModelProperty(value = "义工姓名")
    @TableField("name")
    private String name;

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
    @TableField("birthday")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime birthday;

    @ApiModelProperty(value = "访问日期")
    @TableField("checkin_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime checkinDate;

    @ApiModelProperty(value = "离职日期")
    @TableField("checkout_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime checkoutDate;

    @ApiModelProperty(value = "图片集目录")
    @TableField("imgset_dir")
    private String imgsetDir;

    @ApiModelProperty(value = "头像路径")
    @TableField("profile_photo")
    private String profilePhoto;

    @ApiModelProperty(value = "描述")
    @TableField("DESCRIPTION")
    private String description;

    @ApiModelProperty(value = "是否激活")
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