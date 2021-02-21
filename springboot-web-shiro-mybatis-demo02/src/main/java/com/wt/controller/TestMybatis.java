package com.wt.controller;

import com.wt.mapper.UserMapper;
import com.wt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class TestMybatis {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/userlist")
    @ResponseBody
    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }

    @RequestMapping("/tom")
    @ResponseBody
    public String getUserByUsername(){
       User user = userMapper.getUserByUsername("tom");
       return user.toString();
    }
}
