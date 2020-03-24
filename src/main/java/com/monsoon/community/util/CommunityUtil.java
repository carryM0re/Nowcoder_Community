package com.monsoon.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

public class CommunityUtil {

    // 生成随机的字符串(激活码、或者上传图片时需要用到)
    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    // MD5加密(password+salt提高安全性)
    public static String md5(String key){
        if(StringUtils.isBlank(key)){  // commons.lang3.StringUtils这个包
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
