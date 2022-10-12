package org.jeecg.modules.bzl.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @description:
 * @author: bzl
 * @date: 2022年09月14日 16:13
 */
@TableName("mem_user")
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String department;
    private String img;


    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String name, String department, String img) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.department = department;
        this.img = img;
    }

    public User(int id, String username, String password, String name, String department, String img) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.department = department;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
