package org.jeecg.modules.bzl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.jeecg.modules.bzl.entity.User;

@Mapper
public interface MyUserMapper extends BaseMapper<User> {

    User selectUser(User user);

    User selectUserByName(User user);

    int register(User user);

}
