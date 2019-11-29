package com.shopee.arcatch.data.network_bean;

import com.google.a.a.c;

public class CommonBean<T> {
    @c(a = "data")
    private T data;
    @c(a = "code")
    private int errCode;
    @c(a = "msg")
    private String errMsg;

    public int getErrCode() {
        return this.errCode;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }

    public String toString() {
        return "CommonBean{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + ", data=" + this.data + '}';
    }
}
