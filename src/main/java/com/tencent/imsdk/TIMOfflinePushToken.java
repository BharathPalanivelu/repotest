package com.tencent.imsdk;

public class TIMOfflinePushToken {
    private long bussid;
    private String token;

    public TIMOfflinePushToken(long j, String str) {
        this.bussid = j;
        this.token = str;
    }

    public long getBussid() {
        return this.bussid;
    }

    public String getToken() {
        return this.token;
    }

    public TIMOfflinePushToken setBussid(long j) {
        this.bussid = j;
        return this;
    }

    public TIMOfflinePushToken setToken(String str) {
        this.token = str;
        return this;
    }
}
