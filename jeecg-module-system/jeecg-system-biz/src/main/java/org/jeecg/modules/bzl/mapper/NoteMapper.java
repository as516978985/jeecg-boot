package org.jeecg.modules.bzl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.bzl.entity.Note;

import java.util.List;

@Mapper
public interface NoteMapper extends BaseMapper<NoteMapper> {

    List<Note> selectNoteByDate(@Param("userId") int id, @Param("currentDate") String date);

    void addNote(@Param("content") String content, @Param("currentDate") String date, @Param("userId") int userId);
}
