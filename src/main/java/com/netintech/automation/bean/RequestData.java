package com.netintech.automation.bean;

import java.util.List;

public class RequestData {
    private String msg;
    private String code;
    private Object objData;
    private List<?> listData;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setObjData(Object objData) {
        this.objData = objData;
    }

    public void setListData(List<?> listData) {
        this.listData = listData;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public Object getObjData() {
        return objData;
    }

    public List<?> getListData() {
        return listData;
    }
}
