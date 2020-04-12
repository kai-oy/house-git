package com.example.house.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.DigestUtils;

public class Md5 {
    //盐 相当于二重密码
    private static final String slat = "&1%1A2Asc*&%$$#@";


    /**
     * @param value 对密码进行加密
     * @return
     */
    public static String getMD5(String value) {
        String base = value + "/s/" + slat;
        byte[] bytes = base.getBytes();
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}
