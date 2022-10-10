package org.jeecg.modules.bzl.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.jeecg.modules.bzl.doman.User;

@Mapper
public interface MyUserMapper {

    User selectUser(User user);

    User selectUserByName(User user);

    int register(User user);

}
