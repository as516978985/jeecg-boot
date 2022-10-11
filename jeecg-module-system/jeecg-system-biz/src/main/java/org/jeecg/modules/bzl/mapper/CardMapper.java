package org.jeecg.modules.bzl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.jeecg.modules.bzl.entity.Card;


/**
 * @description:
 * @author: bzl
 * @date: 2022年10月09日 9:43
 */
@Mapper
public interface CardMapper extends BaseMapper<Card> {

//    List<Card> selectAll();
//
//    List<Card> selectByUserId(int userId);
}
