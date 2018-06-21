package com.hawker.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "user_role")
public class UserRole implements Serializable{
    private static final long serialVersionUID = -916411139749530670L;
    @Column(name = "user_id")
    private String userId;

    @Column(name = "role_id")
    private String roleId;


    @Id
    @Column(name = "id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}