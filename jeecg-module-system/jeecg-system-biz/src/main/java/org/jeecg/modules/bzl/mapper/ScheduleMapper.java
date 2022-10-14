package org.jeecg.modules.bzl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.bzl.entity.Schedule;

import java.util.List;

/**
 * @Description: schedule
 * @Author: jeecg-boot
 * @Date: 2022-10-11
 * @Version: V1.0
 */
public interface ScheduleMapper extends BaseMapper<Schedule> {

    List<Schedule> selectScheduleByDate(@Param("userId") int id, @Param("currentDate") String date);

}
