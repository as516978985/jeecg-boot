package org.jeecg.modules.bzl.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @description:
 * @author: bzl
 * @date: 2022年10月14日 16:32
 */
@Data
@TableName("mem_note")
public class Note {
    private int id;
    @JsonFormat(timezone = "GMT+8", pattern = "YYYY-MM-dd")
    @TableField(value = "create_time")
    private Timestamp createTime;
    private String content;
    @TableField(value = "check_flag")
    private String checkFlag;
    @TableField(value = "user_id")
    private int userId;
}
