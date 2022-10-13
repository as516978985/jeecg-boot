package org.jeecg.modules.bzl.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @description:
 * @author: bzl
 * @date: 2022年10月09日 9:25
 */
@Data
@TableName(value = "mem_schedule")
public class Schedule {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String title;
    @JsonFormat(timezone = "GMT+8", pattern = "YYYY-MM-dd")
    @TableField(value = "rec_date")
    private Timestamp recDate;
    @JsonFormat(timezone = "GMT+8", pattern = "h:mm")
    @TableField(value = "start_time")
    private Timestamp startTime;
    @JsonFormat(timezone = "GMT+8", pattern = "h:mm")
    @TableField(value = "end_time")
    private Timestamp endTime;
    @TableField(value = "advance_time")
    private int advanceTime;
    private String icon;
    @TableField(value = "check_flag")
    private String checkFlag;
    @TableField(value = "user_id")
    private int userId;
    @TableField(value = "modify_time")
    private Timestamp modifyTime;
}
