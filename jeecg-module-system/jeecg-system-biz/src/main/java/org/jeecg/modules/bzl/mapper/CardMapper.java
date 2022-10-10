package org.jeecg.modules.bzl.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.jeecg.modules.bzl.doman.Card;

import java.util.List;


/**
 * @description:
 * @author: bzl
 * @date: 2022年10月09日 9:43
 */
@Mapper
public interface CardMapper {

    List<Card> selectAll();

    List<Card> selectByUserId(int userId);
}
