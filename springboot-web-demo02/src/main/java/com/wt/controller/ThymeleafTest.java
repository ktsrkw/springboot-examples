package com.wt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class ThymeleafTest {
    @RequestMapping({"/signin","/"})
    public String signInPage(){
        return "signin";
    }

    @RequestMapping("/user/login")
    public String signInTest(
            @RequestParam("username")String username,//@RequestParam("")可以根据标签的name拿到前台的值
            @RequestParam("password")String password,
            Model model,
            HttpSession session
    ){
        //拿到参数后就来写逻辑了，判断用户名密码是否正确等等，这里先简化了写
        //如果输入的用户名不为空且密码为123456则让他登录成功
        if(!StringUtils.isEmpty(username) && password.equals("123456")){
            //登陆成功，重定向到dashboard页
            session.setAttribute("logInUser",username);//登陆成功后设置session，方便拦截功能的实现
            return "redirect:/dashboard.html";//重定向到/dashboard.html
        } else {
            //登录失败，设置提示信息并重新返回（转发）到siginin
            model.addAttribute("errorMsg01","用户名或密码错误");
            return "signin";
        }
    }

    @RequestMapping("/dashboard.html")//处理重定向以及其他请求，如果直接访问会被拦截器拦截，必须登录成功才行
    public String toDashboard(){
        return "dashboard";
    }

    @RequestMapping("/form")//处理重定向以及其他请求，如果直接访问会被拦截器拦截，必须登录成功才行
    public String toForm(){
        return "form";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String toAdd(int a,int b){
        int c = a + b;
        return "c";
    }

    @RequestMapping("/add/{a}/{b}")
    @ResponseBody
    public String toAddRestful(@PathVariable int a,@PathVariable int b){
        int c = a + b;
        return "c";
    }

}
