package com.hao.rmb.service.login.impl;

import static com.hao.common.utils.RmbUtils.*;

import com.hao.common.exception.BizException;
import com.hao.rmb.dao.user.UserDao;
import com.hao.rmb.entity.user.UserEntity;
import com.hao.rmb.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired(required=true)
    private UserDao userDao;
    @Override
    public UserEntity login(String account, String password) throws Exception {
        account =$(account,"账号不能为空");
        password = $(password,"密码不能为空");
        UserEntity userEntity = userDao.findUserByAccount(account);
        if(!password.equals(userEntity.getPassword())){
            throw new BizException("密码不正确");
        }
        return userEntity;
    }
}
