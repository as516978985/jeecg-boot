package org.jeecg.modules.bzl.server.impl;

import org.jeecg.modules.bzl.constant.Path;
import org.jeecg.modules.bzl.mapper.MyUserMapper;
import org.jeecg.modules.bzl.entity.User;
import org.jeecg.modules.bzl.server.UserServer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @description:
 * @author: bzl
 * @date: 2022年09月23日 11:47
 */
@Service
public class UserServerImpl implements UserServer {

//    @Autowired(required = false)
    @Resource
    private MyUserMapper myUserMapper;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User userLogin(User user) {
        User relUser = myUserMapper.selectUser(user);
        relUser.setPassword(null);
        return relUser;
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public Boolean userRegister(User user) {
        System.out.println("接收到的user"+user);
        //查用户是否存在
        if (myUserMapper.selectUserByName(user) != null) {
            return false;
        }
        return myUserMapper.register(user) > 0;
    }

    /**
     * 保存前端传来的文件
     * @param file
     * @return
     */
    @Override
    public String saveAvatar(MultipartFile file) {
        String filename = file.getOriginalFilename();
        String filePath = Path.PictureSavePath + filename;
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "http://localhost:8080/img/" + filename;
    }

    /**
     * 删除图片文件
     * @param name
     * @return
     */
    @Override
    public boolean deleteProfile(String name) {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("");
        String pic = resource + "static/img/" + name;
        pic = pic.substring(6).replaceAll("\"", "");
        File file = new File(pic);
        String relPath = Path.PictureSavePath + name.replaceAll("\"", "");
        File relFile = new File(relPath);
        return file.delete() && relFile.delete();
    }
}
