package com.netintech.automation.utils;

public class FliterUtils {

    /**
     * 过滤控制字符方法
     * @param content
     * @return
     */
    public static String filter(String content) {
        if (content != null && content.length() > 0) {
            char[] contentCharArr = content.toCharArray();
            for (int i = 0; i < contentCharArr.length; i++) {
                if (contentCharArr[i] < 0x20 || contentCharArr[i] == 0x7F) {
                    contentCharArr[i] = 0x20;
                }
            }
            return new String(contentCharArr);
        }
        return "";
    }
}
