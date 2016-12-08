package com.zh.cn.wzl.demo.business.entity;

public class ImUser {
    private Integer id;

    private String syskey;

    private String uid;

    private String imuid;

    private String impwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSyskey() {
        return syskey;
    }

    public void setSyskey(String syskey) {
        this.syskey = syskey == null ? null : syskey.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getImuid() {
        return imuid;
    }

    public void setImuid(String imuid) {
        this.imuid = imuid == null ? null : imuid.trim();
    }

    public String getImpwd() {
        return impwd;
    }

    public void setImpwd(String impwd) {
        this.impwd = impwd == null ? null : impwd.trim();
    }
}