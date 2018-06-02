package com.hao.rmb.dao.user;

import com.hao.rmb.entity.user.UserEntity;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    public UserEntity findUserByAccount(@Param("account") String account) throws Exception;
}
