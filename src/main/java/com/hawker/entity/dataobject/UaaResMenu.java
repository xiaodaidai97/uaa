package com.hawker.entity.dataobject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yylc
 *
 * @author zmf
 * @date 2018/6/15 AND 16:17
 */
public class UaaResMenu implements Serializable {
    private Integer id;

    private String code;

    private String name;

    private Integer sysId;

    private Integer roleId;

    private List<UaaResMenu> uaaResMenu;

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

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<UaaResMenu> getUaaResMenu() {
        return uaaResMenu;
    }

    public void setUaaResMenu(List<UaaResMenu> uaaResMenu) {
        this.uaaResMenu = uaaResMenu;
    }

}
