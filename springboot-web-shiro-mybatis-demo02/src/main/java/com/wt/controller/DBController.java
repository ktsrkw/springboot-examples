package com.wt.controller;

import com.wt.mapper.UserMapper;
import com.wt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DBController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/allUsers")
    @ResponseBody
    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }

    @RequestMapping ("/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id")int id){
        return userMapper.getUserById(id);
    }

    @GetMapping("/userByName/{username}")
    @ResponseBody
    public User getUserByUsername(@PathVariable("username")String username){
        return userMapper.getUserByUsername(username);
    }

    @RequestMapping("/add")
    @ResponseBody
    public int addUser(){
        return userMapper.addUser(new User(3,"Sam","111111"));
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public int deleteUser(@PathVariable("id")int id){
        return userMapper.deleteUserById(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public int updateUser(){
        return userMapper.updateUser(new User(7,"Luna","111111"));
    }
}
