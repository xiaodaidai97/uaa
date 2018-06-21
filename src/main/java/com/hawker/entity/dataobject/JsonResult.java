package com.hawker.entity.dataobject;

import com.hawker.exception.UaaErrorCode;

import java.io.Serializable;

public class JsonResult<T> implements Serializable{

    private static final long serialVersionUID = 5326126096738923805L;
    //结果代码
    private String code;
    //结果说明
    private String message = null;
    //数据
    private T data = null;
    //数据总条数
    private Integer rows = 0;

    public JsonResult() {
    }

    public JsonResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public JsonResult(UaaErrorCode dqcErrorCode) {
        this.code = dqcErrorCode.getCode();
        this.message = dqcErrorCode.getDescription();
    }

    public JsonResult status(Integer status) {
        this.code = code;
        return this;
    }

    // Getter Setter


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}

