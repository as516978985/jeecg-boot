package org.jeecg.modules.bzl.controller;

import org.jeecg.modules.bzl.constant.Code;
import org.jeecg.modules.bzl.entity.*;
import org.jeecg.modules.bzl.server.CardServer;
import org.jeecg.modules.bzl.server.EventServer;
import org.jeecg.modules.bzl.server.ScheduleServer;
import org.jeecg.modules.bzl.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    @Autowired
    private CardServer cardServer;

    @Autowired
    private ScheduleServer scheduleServer;

    @Autowired
    private EventServer eventServer;

    /**
     * 获取任务卡片（对应前端左上角内容）
     *
     * @return
     */
    @GetMapping("/getTaskCard")
    public Result SelectAllTaskCard() {
        List<Card> cards = cardServer.selectAll();
        if (cards != null)
            return new Result(Code.GET_OK, cards, "查询成功");
        else
            return new Result(Code.GET_OK, null, "查询失败");
    }

    /**
     * 获取事件卡片信息
     *
     * @param id
     * @return
     */
    @GetMapping("/getEventCard/{id}")
    public Result SelectEventCardById(@PathVariable int id) {
        List<Event> events = eventServer.selectEventById(id);
        if (events != null)
            return new Result(Code.GET_OK, events, "查询成功");
        else
            return new Result(Code.GET_OK, null, "查询失败");
    }

    @GetMapping("/changeEventCardAttention/{id}")
    public Result changeEventCardAttention(@PathVariable int id) {
        System.out.println("接口测试");
        boolean flag = true;
        if (flag)
            return new Result(Code.GET_OK, null, "查询成功");
        else
            return new Result(Code.GET_OK, null, "查询失败");
    }


    /**
     * 获取用户信息（对应前端有下角）
     *
     * @return
     */
    @GetMapping("/getUserInfo/{id}")
    public Result SelectUserById(@PathVariable int id) {
        User user = userServer.userInfo(id);
        if (user != null) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(user.getId());
            userInfo.setName(user.getName());
            userInfo.setDepartment(user.getDepartment());
            userInfo.setImg(user.getImg());
            return new Result(Code.GET_OK, userInfo, "查询成功");
        } else
            return new Result(Code.GET_OK, null, "查询失败");
    }

    /**
     * 获取日程（对应前端有下角）
     *
     * @return
     */
    @GetMapping("/getScheduleCard")
    public Result SelectAllEventCard() {
        List<Schedule> scheduleList = scheduleServer.selectAll();
        if (scheduleList != null)
            return new Result(Code.GET_OK, scheduleList, "查询成功");
        else
            return new Result(Code.GET_OK, null, "查询失败");
    }


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
