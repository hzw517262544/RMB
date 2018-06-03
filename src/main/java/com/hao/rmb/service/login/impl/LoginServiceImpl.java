package com.hao.rmb.service.login.impl;

import com.hao.rmb.dao.user.UserDao;
import com.hao.rmb.entity.user.UserEntity;
import com.hao.rmb.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.hao.common.utils.SystemUtils.*;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired(required=true)
    private UserDao userDao;
    @Override
    public UserEntity login(String account, String password) throws Exception {
        account =$(account,"账号不能为空");
        password = $(password,"密码不能为空");
        UserEntity userEntity = userDao.select("account",account);
        return userEntity;
    }
}
