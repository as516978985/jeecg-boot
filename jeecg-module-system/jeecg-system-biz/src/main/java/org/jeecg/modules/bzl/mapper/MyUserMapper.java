package org.jeecg.modules.bzl.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.jeecg.modules.bzl.entity.User;

@Mapper
public interface MyUserMapper {

    User selectUser(User user);

    User selectUserByName(User user);

    int register(User user);

}
