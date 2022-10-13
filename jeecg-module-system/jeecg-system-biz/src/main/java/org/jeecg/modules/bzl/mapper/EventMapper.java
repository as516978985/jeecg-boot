package org.jeecg.modules.bzl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.bzl.entity.Event;

import java.util.List;

@Mapper
public interface EventMapper extends BaseMapper<Event> {

    List<Event> selectEventByUserId(int id);


    void changeAttention(@Param("flag") String flag, @Param("id") int id);
}
