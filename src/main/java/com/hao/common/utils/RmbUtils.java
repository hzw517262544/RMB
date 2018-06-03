package com.hao.common.utils;

import com.hao.common.exception.BizException;
import org.springframework.util.StringUtils;

/*
* 工具类
* */
public class RmbUtils {
    public static String validEmpty(String target,String message) {
        if(StringUtils.isEmpty(target)){
            throw new BizException(message);
        }
        return target;
    }

    public static String $(String target,String message){
        return validEmpty(target,message);
    }
}
