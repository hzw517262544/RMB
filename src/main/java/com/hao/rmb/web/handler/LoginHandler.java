package com.hao.rmb.web.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginHandler {
    @RequestMapping("/login.do")
    public String login(){
        System.out.println("项目第一步");
        return "login";
    }
}
