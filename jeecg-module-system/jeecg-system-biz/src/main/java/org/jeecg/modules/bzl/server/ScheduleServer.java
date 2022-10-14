package org.jeecg.modules.bzl.server;

import org.jeecg.modules.bzl.entity.Schedule;

import java.util.List;

public interface ScheduleServer {

    List<Schedule> selectAll();

    List<Schedule> changeScheduleFlag(int id, int userId, String date);

    List<Schedule> selectScheduleByDate(int id, String date);
}
