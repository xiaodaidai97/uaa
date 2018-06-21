package com.hawker.entity.dataobject;

import java.io.Serializable;

/**
 * Created by yylc
 *
 * @author zmf
 * @date 2018/6/21 AND 10:08
 */
public class RequestParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pageSize;

    private Integer pageNum;

    private String userId;

    private Integer sysId;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }
}
