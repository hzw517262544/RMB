package com.hao.rmb.action.login;

import com.hao.common.constant.SystemConstants;
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
            session.setAttribute(SystemConstants.CURRENT_USER,userEntity);
            if(!password.equals(userEntity.getPassword())){
                return "forward:/welcome.html";
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message",e.getMessage());
            return "forward:/welcome.html";
        }
        return "redirect:/welcome.do";
    }
    @RequestMapping("/welcome.do")
    public String welcome(){
        return "mainPage";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session){
        //session失效
        session.invalidate();
        return "redirect:/welcome.html";
    }
}
