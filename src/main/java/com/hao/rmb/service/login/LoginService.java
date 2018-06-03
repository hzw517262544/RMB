package com.hao.rmb.service.login;

import com.hao.rmb.entity.user.UserEntity;

public interface LoginService {
    /**
     * 登录
     * @param account
     * @param password
     * @return
     * @throws Exception
     */
    public UserEntity login(String account, String password) throws Exception;

}
