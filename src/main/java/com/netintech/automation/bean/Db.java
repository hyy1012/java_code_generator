package com.netintech.automation.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库链接类
 */
public class Db {

    private String dbtype;
    private String dbip;
    private String dbport;
    private String dbusername;
    private String dbpassword;
    private String dbname;
    private String tablename;

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbtype(String dbtype) {
        this.dbtype = dbtype;
    }

    public void setDbip(String dbip) {
        this.dbip = dbip;
    }

    public void setDbport(String dbport) {
        this.dbport = dbport;
    }

    public void setDbusername(String dbusername) {
        this.dbusername = dbusername;
    }

    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }

    public String getDbtype() {
        return dbtype;
    }

    public String getDbip() {
        return dbip;
    }

    public String getDbport() {
        return dbport;
    }

    public String getDbusername() {
        return dbusername;
    }

    public String getDbpassword() {
        return dbpassword;
    }
}
