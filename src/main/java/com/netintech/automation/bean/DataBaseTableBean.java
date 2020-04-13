package com.netintech.automation.bean;

/**
 * 数据库表属性实体类
 */
public class DataBaseTableBean {

    private String name;//字段名称
    private String type;//字段类型
    private String isnull;//是否为空
    private String length;//字段长度
    private String bz;//字段备注
    private String qtype;//字段全类型
    private long size;//字段大小
    private String key;//主键标识

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIsnull() {
        return isnull;
    }

    public String getLength() {
        return length;
    }

    public String getBz() {
        return bz;
    }

    public String getQtype() {
        return qtype;
    }

    public void setIsnull(String isnull) {
        this.isnull = isnull;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public void setQtype(String qtype) {
        this.qtype = qtype;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public long getSize() {
        return size;
    }
}
