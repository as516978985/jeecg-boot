package org.jeecg.modules.bzl.server.impl;

import org.jeecg.modules.bzl.entity.Schedule;
import org.jeecg.modules.bzl.mapper.ScheduleMapper;
import org.jeecg.modules.bzl.server.ScheduleServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: bzl
 * @date: 2022年10月11日 9:52
 */
@Service
public class ScheduleServerImp implements ScheduleServer {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public List<Schedule> selectAll() {
        return scheduleMapper.selectList(null);
    }

    @Override
    public List<Schedule> selectScheduleByDate(int id, String date) {
        return scheduleMapper.selectScheduleByDate(id, date);
    }

    @Override
    public List<Schedule> changeScheduleFlag(int id, int userId, String date) {
        Schedule schedule = scheduleMapper.selectById(id);
        //时间格规则式化
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取格式化后的当前时间并转化为Timestamp类型，以对应entity类的字段
        Timestamp currentTime = Timestamp.valueOf(df.format(new Date()));
        if (schedule == null) {
            return null;
        } else if ("1".equals(schedule.getCheckFlag())) {
            schedule.setCheckFlag("0");
            schedule.setModifyTime(currentTime);
            scheduleMapper.updateById(schedule);
        } else {
            schedule.setCheckFlag("1");
            schedule.setModifyTime(currentTime);
            scheduleMapper.updateById(schedule);
        }
        return selectScheduleByDate(userId, date);
    }


}
