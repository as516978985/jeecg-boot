package org.jeecg.modules.bzl.server;

import org.jeecg.modules.bzl.entity.Schedule;

import java.util.List;

public interface ScheduleServer {

    List<Schedule> selectAll();

}
