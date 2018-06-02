package com.hao.rmb.service.login;

import com.hao.rmb.entity.user.UserEntity;

public interface LoginService {
    public UserEntity login(String account, String password) throws Exception;
}
