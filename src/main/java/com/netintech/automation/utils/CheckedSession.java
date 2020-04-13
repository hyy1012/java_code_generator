package com.netintech.automation.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 验证sesion的方法
 */
public class CheckedSession {

    //生成key和验证session
    public static String check(HttpServletRequest request){
        String key = "";
        long date = new Date().getTime();// new Date()为获取当前系统时间，也可使用当前时间戳
        HttpSession session = request.getSession();
        if(session.getAttribute("KEY") == null){
            key =date+ IpUtil.getIpAddr(request);
            session.setAttribute("KEY",key);
        }else{
            key = session.getAttribute("KEY").toString();
        }
        return key;

    }

}
