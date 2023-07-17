package com.bjtu.web.spring_boot.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@ApiModel(value = "老人信息实体类")
@TableName("oldperson_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OldPersonInfo {
    @ApiModelProperty(value = "ID")
    @TableId(type = IdType.AUTO)
    private Integer id;


    @ApiModelProperty(value = "老人姓名")
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
    private LocalDateTime birthday;

    @ApiModelProperty(value = "入养老院日期")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @TableField("checkin_date")
    private LocalDateTime checkinDate;

    @ApiModelProperty(value = "离开养老院日期")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @TableField("checkout_date")
    private LocalDateTime checkoutDate;

    @ApiModelProperty(value = "图像目录")
    @TableField("imgset_dir")
    private String imgsetDir;

    @ApiModelProperty(value = "头像路径")
    @TableField("profile_photo")
    private String profilePhoto;

    @ApiModelProperty(value = "房间号")
    @TableField("room_number")
    private String roomNumber;

    @ApiModelProperty(value = "第一监护人姓名")
    @TableField("firstguardian_name")
    private String firstGuardianName;

    @ApiModelProperty(value = "第一监护人关系")
    @TableField("firstguardian_relationship")
    private String firstGuardianRelationship;

    @ApiModelProperty(value = "第一监护人电话")
    @TableField("firstguardian_phone")
    private String firstGuardianPhone;

    @ApiModelProperty(value = "第一监护人微信")
    @TableField("firstguardian_wechat")
    private String firstGuardianWechat;

    @ApiModelProperty(value = "第二监护人姓名")
    @TableField("secondguardian_name")
    private String secondGuardianName;

    @ApiModelProperty(value = "第二监护人关系")
    @TableField("secondguardian_relationship")
    private String secondGuardianRelationship;

    @ApiModelProperty(value = "第二监护人电话")
    @TableField("secondguardian_phone")
    private String secondGuardianPhone;

    @ApiModelProperty(value = "第二监护人微信")
    @TableField("secondguardian_wechat")
    private String secondGuardianWechat;

    @ApiModelProperty(value = "健康状态")
    @TableField("health_state")
    private String healthState;

    @ApiModelProperty(value = "描述")
    @TableField("DESCRIPTION")
    private String description;

    @ApiModelProperty(value = "年龄")
    @TableField("age")
    private Integer age;
    @ApiModelProperty(value = "标识")
    @TableField("flag")
    private Integer flag;

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


}
