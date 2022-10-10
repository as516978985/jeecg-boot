package org.jeecg.modules.bzl.doman;


import lombok.Data;

import java.sql.Timestamp;

/**
 * @description:
 * @author: bzl
 * @date: 2022年10月09日 9:25
 */
@Data
public class Schedule {
    private int id;
    private String title;
    private Timestamp startTime;
    private Timestamp endTime;
    private int advance;
    private String icon;
    private String checkFlag;
}
