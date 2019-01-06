package com.meal.pojo;

public class Address {
    private String addrid;

    private String userid;

    private String addrdesc;

    private Integer recentuse;

    public String getAddrid() {
        return addrid;
    }

    public void setAddrid(String addrid) {
        this.addrid = addrid == null ? null : addrid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getAddrdesc() {
        return addrdesc;
    }

    public void setAddrdesc(String addrdesc) {
        this.addrdesc = addrdesc == null ? null : addrdesc.trim();
    }

    public Integer getRecentuse() {
        return recentuse;
    }

    public void setRecentuse(Integer recentuse) {
        this.recentuse = recentuse;
    }
}