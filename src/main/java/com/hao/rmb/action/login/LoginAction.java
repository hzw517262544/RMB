package com.hao.rmb.action.login;

import com.hao.common.utils.RmbUtils;
import com.hao.rmb.entity.user.UserEntity;
import com.hao.rmb.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginAction {
    @Autowired(required=true)
    private LoginService loginService;
    @RequestMapping("/login.do")
    public String login(String account, String password, HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            UserEntity userEntity = loginService.login(account,password);
            session.setAttribute("currentUser",userEntity);
        } catch (Exception e) {
            request.setAttribute("message",e.getMessage());
            return "forward:/welcome.html";
        }
        return "reirect:/welcome.do";
    }
    @RequestMapping("/welcome.do")
    public String welcome(){
        return "loginOk";
    }
}
