package com.netintech.automation.bean;

/**
 * 描述包实体
 */
public class DbBean extends Db  {
    private String compages;
    private String zdname;
    private String mk;

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getZdname() {
        return zdname;
    }

    public void setZdname(String zdname) {
        this.zdname = zdname;
    }
    public String getCompages() {
        return compages;
    }

    public void setCompages(String compages) {
        this.compages = compages;
    }
}
