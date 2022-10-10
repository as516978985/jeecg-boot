package org.jeecg.modules.bzl.controller;

import org.jeecg.modules.bzl.constant.Code;
import org.jeecg.modules.bzl.doman.Result;
import org.jeecg.modules.bzl.doman.User;
import org.jeecg.modules.bzl.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @description: 用户操作控制器
 * @author: bzl
 * @date: 2022年09月23日 11:44
 */
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServer userServer;

    /**
     * 用户登录
     *
     * @param user
     * @param req
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest req) {
        User relUser = userServer.userLogin(user);
        if (relUser != null) {
            HttpSession session = req.getSession();
            //将用户信息添加到session中
            session.setAttribute(user.getUsername(), user);
            return new Result(Code.LOGIN_OK, relUser, "登录成功");
        }
        return new Result(Code.LOGIN_ERR, null, "登录失败");
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        Boolean row = userServer.userRegister(user);
        if (row) {
            return new Result(Code.REGISTER_OK, "注册成功");
        }
        return new Result(Code.REGISTER_ERR, null, "注册失败,该用户已存在");
    }

    /**
     * 图片上传
     *
     * @param avatar 前端传来的图片文件，名字需要与前端的name对应
     * @return
     */
    @RequestMapping("/profileSave")
    public String avatar(@RequestBody MultipartFile avatar) {
        String picturePath = userServer.saveAvatar(avatar);
        System.out.println(picturePath);
        return picturePath;
    }

    /**
     * 删除图片
     *
     * @param name 图片名称
     * @return
     * @description 如果用户换图片后需要把用户之前上传的图片删除
     */
    @RequestMapping("/profileDelete")
    public boolean avatar(@RequestBody String name) {
        System.out.println(name);
        boolean status = userServer.deleteProfile(name);
        System.out.println(status);
        return status;
    }
}
