package com.hao.rmb.action.user;

import com.hao.common.constant.SystemConstants;
import com.hao.common.exception.BizException;
import com.hao.rmb.entity.user.UserEntity;
import com.hao.rmb.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserAction {
    @Autowired
    private UserService userService;
    @RequestMapping(method = RequestMethod.GET,path = "/updatepassword.do")
    public String updatePasswordView(){
        return "/updatepassword";
    }
    @RequestMapping(method = RequestMethod.POST,path = "/updatepassword.do")
    public String updatePassword(String oldPassword,String newPassword,String newPasswordConfirm,HttpServletRequest request) throws Exception{
        try {
            HttpSession session = request.getSession();
            UserEntity userEntity = (UserEntity) session.getAttribute(SystemConstants.CURRENT_USER);
            userService.updatePassword(userEntity,oldPassword,newPassword,newPasswordConfirm);
            session.invalidate();
        } catch (BizException e) {
            e.printStackTrace();
            return "updatepassword";
        }
        return "redirect:/welcome.html";
    }
}
