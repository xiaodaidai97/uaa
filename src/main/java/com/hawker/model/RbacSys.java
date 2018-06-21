package com.hawker.model;

import java.sql.Timestamp;

public class RbacSys {
    private Integer id;
    private String code;
    private String name;

    private String userId;

    private String remark;
    private String clientId;
    private String clientSecret;
    private String extInfo;

    private Timestamp optime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public Timestamp getOptime() {
        return optime;
    }

    public void setOptime(Timestamp optime) {
        this.optime = optime;
    }

    @Override
    public String toString() {
        return "RbacSys{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", remark='" + remark + '\'' +
                ", clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", extInfo='" + extInfo + '\'' +
                ", optime=" + optime +
                '}';
    }
}
