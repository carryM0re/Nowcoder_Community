package com.monsoon.community.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
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

    public static String getJSONString(int code, String msg, Map<String, Object> map){
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        if(map != null){
            for(String key : map.keySet()){
                json.put(key, map.get(key));
            }
        }
        return json.toJSONString();
    }

    // 重载
    public static String getJSONString(int code, String msg){
        return getJSONString(code, msg, null);
    }

    // 重载
    public static String getJSONString(int code){
        return getJSONString(code, null, null);
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "xietao");
        map.put("age", 25);
        System.out.println(getJSONString(0, "ok", map));
    }
}
