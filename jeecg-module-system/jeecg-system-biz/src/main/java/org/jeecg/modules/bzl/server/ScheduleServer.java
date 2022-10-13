package org.jeecg.modules.bzl.server;

import org.jeecg.modules.bzl.entity.Schedule;

import java.sql.Timestamp;
import java.util.List;

public interface ScheduleServer {

    List<Schedule> selectAll();

    List<Schedule> changeScheduleFlag(int id);

    List<Schedule> selectScheduleByDate(int id, Timestamp date);
}
