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
import java.util.List;


@TableName("event")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "事件信息实体类")
public class EventInfo {
    @ApiModelProperty(value = "事件id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "事件类型")
    @TableField("event_type")
    private Integer eventType;

    @ApiModelProperty(value = "事件发生的时间")
    @TableField("event_date")
    private LocalDateTime eventDate;

    @ApiModelProperty(value = "事件发生的地点")
    @TableField("event_location")
    private String eventLocation;

    @ApiModelProperty(value = "事件描述")
    @TableField("event_desc")
    private String eventDesc;

    @ApiModelProperty(value = "老人ID")
    @TableField("oldperson_id")
    private Integer oldpersonId;


}