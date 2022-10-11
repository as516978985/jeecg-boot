package org.jeecg.modules.bzl.server.impl;

import org.jeecg.modules.bzl.entity.Schedule;
import org.jeecg.modules.bzl.mapper.ScheduleMapper;
import org.jeecg.modules.bzl.server.ScheduleServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
