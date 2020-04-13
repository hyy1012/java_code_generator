package com.netintech.automation.bean;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 日志信息表
 */
@Entity
@Table(name = "logs")
public class logs {
    private int id;
    private String ip;
    private String db;
    private String pageurl;
    private String tablename;
    private String dbname;
    private String dbip;
    private String dbusername;
    private String dbpassword;
    private String downurl;


    @Id
    public int getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public String getDb() {
        return db;
    }

    public String getPageurl() {
        return pageurl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public void setPageurl(String pageurl) {
        this.pageurl = pageurl;
    }

    public String getDownurl() {
        return downurl;
    }

    public void setDownurl(String downurl) {
        this.downurl = downurl;
    }

    public String getTablename() {
        return tablename;
    }

    public String getDbname() {
        return dbname;
    }

    public String getDbip() {
        return dbip;
    }

    public String getDbusername() {
        return dbusername;
    }

    public String getDbpassword() {
        return dbpassword;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public void setDbip(String dbip) {
        this.dbip = dbip;
    }

    public void setDbusername(String dbusername) {
        this.dbusername = dbusername;
    }

    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }
}
