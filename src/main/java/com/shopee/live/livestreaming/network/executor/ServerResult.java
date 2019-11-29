package com.shopee.live.livestreaming.network.executor;

public class ServerResult<T> {
    private T data;
    private int err_code;
    private String err_msg;

    public int getErr_code() {
        return this.err_code;
    }

    public void setErr_code(int i) {
        this.err_code = i;
    }

    public String getErr_msg() {
        String str = this.err_msg;
        return str == null ? "" : str;
    }

    public void setErr_msg(String str) {
        this.err_msg = str;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }
}
