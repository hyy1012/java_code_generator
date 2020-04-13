package com.netintech.automation.bean;

import java.util.List;

/**
 * 数据库表实体类
 */
public class DataBaseBean {
    //表名
    private String tablename;

    private String ctablename;

    private List<DataBaseTableBean> list;

    public List<DataBaseTableBean> getList() {
        return list;
    }

    public void setList(List<DataBaseTableBean> list) {
        this.list = list;
    }

    public String getCtablename() {
        return ctablename;
    }

    public void setCtablename(String ctablename) {
        this.ctablename = ctablename;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }
}
