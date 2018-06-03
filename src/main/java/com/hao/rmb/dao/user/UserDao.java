package com.hao.rmb.dao.user;

import com.hao.common.dao.BaseDao;
import com.hao.rmb.entity.user.UserEntity;
import org.apache.ibatis.annotations.Param;

public interface UserDao extends BaseDao<UserEntity> {
    @Override
    void insert(UserEntity userEntity) throws Exception;

    @Override
    void delete(@Param("key") String ukfield, @Param("value") Object value) throws Exception;

    @Override
    void update(UserEntity userEntity) throws Exception;

    @Override
    UserEntity select(@Param("key") String ukfield, @Param("value") Object value) throws Exception;
}
