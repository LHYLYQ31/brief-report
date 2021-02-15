/**
 * Copyright 2018 LM. All Rights Reserved.
 */
package com.lypz.briefreport.commom.utils;

/**
 * <B>系统名称：tr</B><BR>
 * <B>模块名称：统一返回结果</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 */
public class Result<T> {
    /** 状态码. */
    private Integer code;
    /** 提示信息. */
    private String msg;
    /** 返回数据. */
    private T data;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

}
