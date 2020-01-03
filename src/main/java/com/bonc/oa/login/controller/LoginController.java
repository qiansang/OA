package com.bonc.oa.login.controller;

import com.bonc.oa.login.bean.User;
import com.bonc.oa.login.service.UserService;
import com.bonc.oa.utils.IpUtils;
import com.bonc.oa.utils.ResultResponse;
import com.bonc.oa.utils.Test;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger("oa");
    @Autowired
    private UserService userService;

    //退出的时候是get请求，主要是用于退出
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login/login";
    }

    //post登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse login(String username, String password, HttpServletRequest request){
        //添加用户认证信息
        if(!Test.checkTime()){
            return new ResultResponse(400, "登录失败,您的试用期已到！", null);
        }
        if(userService.findByUsername(username) == null){
            return new ResultResponse(400, "没有此账号，请联系管理员注册！", null);
        }
        if(userService.findByUsername(username).getLogin().equals(1)){
            return new ResultResponse(400, "该用户已被锁定，无法登陆！", null);
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        //进行验证，这里可以捕获异常，然后返回对应信息
        try {
            subject.login(usernamePasswordToken);
            if(subject.isAuthenticated()){
                String ipAddr = IpUtils.getIpAddr(request);
                logger.info("用户：" + username + "在IP:" + ipAddr + "登录成功");
                return new ResultResponse(200, "登录成功", null);
            }
        }catch (Exception e){
            return new ResultResponse(400, "登录失败,用户名或密码错误", null);
        }
        return new ResultResponse(400, "登录失败,用户名或密码错误", null);
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "home/index";
    }

    @RequestMapping(value = "/console")
    public String console(){
        return "home/console";
    }

    @RequestMapping(value = "/getUserByUsername")
    @ResponseBody
    public ResultResponse getUserByUsername(){
        Subject subject = SecurityUtils.getSubject();
        return new ResultResponse(200, "", userService.findByUsername(subject.getPrincipals() + ""));
    }

    //登出
    @RequestMapping(value = "/logout")
    public String logout(){
        return "logout";
    }

    //错误页面展示
    @RequestMapping(value = "/error",method = RequestMethod.POST)
    public String error(){
        return "error ok!";
    }

    @RequestMapping(value = "/editPassword")
    @ResponseBody
    public ResultResponse editPassword(@RequestBody User user){
        return new ResultResponse(200, "", userService.editPassword(user));
    }

    @RequestMapping(value = "/personCenter")
    public String personCenter(){
        return "home/personCenter";
    }
}