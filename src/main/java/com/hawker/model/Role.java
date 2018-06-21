package com.hawker.model;

import javax.persistence.*;
import java.io.Serializable;

public class Role implements Serializable{
    private static final long serialVersionUID = -6140090613812307452L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String roleDesc;

    @Column(name ="name")
    private String name;


    @Column(name ="type")
    private String type;


    @Column(name ="ext_info")
    private String extInfo;

    @Column(name ="sys_id")
    private String sysId;

    @Transient
    private Integer selected;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleDesc='" + roleDesc + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", extInfo='" + extInfo + '\'' +
                ", selected=" + selected +
                '}';
    }
}