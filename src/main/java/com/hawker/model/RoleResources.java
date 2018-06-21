package com.hawker.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "role_resources")
public class RoleResources implements Serializable{
    private static final long serialVersionUID = -8559867942708057891L;

    private Integer roleId;

    private String resourcesId;

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name ="action")
    private String action;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(String resourcesId) {
        this.resourcesId = resourcesId;
    }

    @Override
    public String toString() {
        return "RoleResources{" +
                "roleId=" + roleId +
                ", resourcesId='" + resourcesId + '\'' +
                ", id=" + id +
                ", action='" + action + '\'' +
                '}';
    }
}