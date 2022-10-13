package org.jeecg.modules.bzl.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

/**
 * @description:
 * @author: bzl
 * @date: 2022年10月12日 13:27
 */
@Data
@TableName(value = "mem_event")
public class Event {
    private Integer id;
    private String title;
    private String content;
    @TableField(value = "start_time")
    private Date startTime;
    @TableField(value = "end_time")
    private Date endTime;
    @TableField(value = "right_img")
    private String rightImg;
    @TableField(value = "left_img")
    private String leftImg;
    private String name;
    @TableField(value = "create_time")
    private Date createTime;
    @TableField(value = "user_id")
    private int userId;
    @TableField(value = "attention_flag")
    private String attentionFlag;

}
