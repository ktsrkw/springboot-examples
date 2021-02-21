package com.wt.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截未登录就请求form和dashboard页面的请求,继承了HandlerInterceptor接口就表示这是一个拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆成功后，应该有session
        Object logInUser = request.getSession().getAttribute("logInUser");

        //如果没有登录，则设置错误信息并重定向到登录页
        if(logInUser==null){
            request.setAttribute("errorMsg02","请先登录");
            request.getRequestDispatcher("/signin.html").forward(request,response);//重定向到signin
            return false;//不放行（拦截）
        }else{
            return true;//登录后放行
        }
    }


//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
}
