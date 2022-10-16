package org.jeecg.modules.bzl.controller;

import org.jeecg.modules.bzl.constant.Code;
import org.jeecg.modules.bzl.entity.*;
import org.jeecg.modules.bzl.server.*;
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

    @Autowired
    private NoteServer noteServer;

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
     * @param id 用户id
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

    /**
     * 改变关注任务的关注状态
     *
     * @param id 用户id
     * @return
     */
    @PostMapping("/changeEventCardAttention")
    public Result changeEventCardAttention(int id) {
        List<Event> events = eventServer.changeAttention(id);
        if (events != null)
            return new Result(Code.GET_OK, events, "查询成功");
        else
            return new Result(Code.GET_OK, null, "查询失败");
    }


    /**
     * 获取用户信息（对应前端有下角）
     *
     * @param id 用户id
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
     * @param userId 用户id
     * @param date   日期
     * @return
     */
    @PostMapping("/getScheduleCard")
    public Result SelectAllEventCard(int userId, String date) {
        List<Schedule> scheduleList = scheduleServer.selectScheduleByDate(userId, date);
        if (scheduleList != null)
            return new Result(Code.GET_OK, scheduleList, "查询成功");
        else
            return new Result(Code.GET_OK, null, "查询失败");
    }

    /**
     * 改变日程
     *
     * @param scheduleId 被改变的日程id
     * @param userId     用户id
     * @param date       时间
     * @return
     */
    @PostMapping("/changeScheduleFlag")
    public Result changeScheduleFlag(int scheduleId, int userId, String date) {

        List<Schedule> scheduleList = scheduleServer.changeScheduleFlag(scheduleId, userId, date);
        System.out.println("scheduleList = " + scheduleList);
        if (scheduleList != null) {
            return new Result(Code.GET_OK, scheduleList, "查询成功");
        } else
            return new Result(Code.GET_OK, null, "查询失败");
    }

    /**
     * 获取笔记数据
     *
     * @param userId 用户id
     * @param date   日期
     * @return
     */
    @PostMapping("/getNote")
    public Result getNote(int userId, String date) {
        List<Note> noteList = noteServer.getNode(userId, date);

        if (noteList != null) {
            return new Result(Code.GET_OK, noteList, "查询成功");
        } else
            return new Result(Code.GET_OK, null, "查询失败");
    }

    /**
     * 按照日期添加笔记
     * @param content
     * @param date
     * @param userId
     * @return
     */
    @PostMapping("/addNote")
    public Result increaseNote(String content, String date, int userId) {
        List<Note> noteList = noteServer.addNode(content, date, userId);

        if (noteList != null) {
            return new Result(Code.GET_OK, noteList, "查询成功");
        } else
            return new Result(Code.GET_OK, null, "查询失败");
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~以下用不到了（之前学习的时候写的）~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

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
