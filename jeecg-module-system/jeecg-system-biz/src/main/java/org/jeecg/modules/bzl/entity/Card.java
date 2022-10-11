package org.jeecg.modules.bzl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description:
 * @author: bzl
 * @date: 2022年10月09日 9:25
 */
@Data
@TableName(value = "mem_card")
public class Card {
    @TableId(value = "id", type = IdType.AUTO)//指定自增策略
    private Integer id;
    private String title;
    private int count;
    private double percent;
    private String color;
    @TableField(value = "user_id")
    private int userId;
}
