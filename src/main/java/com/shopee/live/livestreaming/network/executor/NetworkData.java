package com.shopee.live.livestreaming.network.executor;

public class NetworkData<T> {
    public T data;
    public int err_code;
    public String err_msg;

    public NetworkData(T t, String str) {
        this.data = t;
        this.err_code = 0;
        this.err_msg = str;
    }

    public NetworkData(int i, String str) {
        this.err_code = i;
        this.err_msg = str;
        this.data = null;
    }

    public boolean hasError() {
        return this.err_code != 0;
    }
}
