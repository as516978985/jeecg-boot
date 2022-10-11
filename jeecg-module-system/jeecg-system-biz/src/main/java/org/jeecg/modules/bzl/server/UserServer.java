package org.jeecg.modules.bzl.server;

import org.jeecg.modules.bzl.entity.User;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: bzl
 * @date: 2022年09月23日 11:47
 */
public interface UserServer {
    User userLogin(User user);

    Boolean userRegister(User user);

    String saveAvatar(MultipartFile file);

    boolean deleteProfile(String name);
}
