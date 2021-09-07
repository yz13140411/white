package com.evan.wj.controller;

import com.evan.wj.pojo.User;
import com.evan.wj.result.Result;
import com.evan.wj.result.ResultFactory;
import com.evan.wj.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


import org.apache.shiro.subject.Subject;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    // @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        String username = requestUser.getUsername();
        Subject subject = SecurityUtils.getSubject();
        // username = HtmlUtils.htmlEscape(username);
        // User user = userService.get(username,requestUser.getPassword());
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,requestUser.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            subject.login(usernamePasswordToken);
            return ResultFactory.buildSuccessResult(username);
        }catch (AuthenticationException e){
            String message = "账号密码错误";
            return ResultFactory.buildFailResult(message);
        }


//        if(null == user){
//            return new Result(400,"找不到",null);
//        }else{
//            return new Result(200);
//        }
    }
    @PostMapping("/api/register")
    @ResponseBody
    public Result register(@RequestBody User user){
        int status = userService.register(user);
        switch (status){
            case 0:
                return ResultFactory.buildFailResult("用户名和密码不能为空");
            case 1:
                return ResultFactory.buildSuccessResult("成功");
            case 2:
                return ResultFactory.buildFailResult("用户已存在");
        }
        return ResultFactory.buildFailResult("未知错误");
    }
    @GetMapping("/api/logout")
    public Result logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultFactory.buildSuccessResult("退出登录成功");
    }
    @GetMapping("/api/authentication")
    public String authentication(){
        return "身份认证成功";
    }
}
