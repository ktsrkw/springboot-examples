package com.wt.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RouterController {

    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg01","Hello,shiro");
        return "index";
    }

    @RequestMapping("/user/add")
    public String toAdd(){
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String toUpdate(){
        return "user/update";
    }

    @PostMapping("/login")
    public String login(String username,String password,Model model){
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据成token对象
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        //检查用户登录数据，
        try{
            subject.login(token);
            return "redirect:/index";
        }catch (UnknownAccountException uae){
            model.addAttribute("msg01","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException ice){
            model.addAttribute("msg01","密码错误");
            return "login";
        }

    }

    @GetMapping("/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/unAuthorized")
    @ResponseBody
    public String unAuthorized(){
        return "该账户未被授予足够的权限以访问此页面";
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();//先获取当前用户对象
        subject.logout();//再执行登出

        return "redirect:/";
    }

}
