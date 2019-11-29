package com.shopee.arcatch.data.network_bean.game;

import com.google.a.a.c;

public class EndBody {
    @c(a = "catch_token")
    private String catchToken;
    @c(a = "finish_time")
    private long finishTime;
    @c(a = "instance_id")
    private String instanceId;

    public String getInstanceId() {
        return this.instanceId;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public String getCatchToken() {
        return this.catchToken;
    }

    public void setCatchToken(String str) {
        this.catchToken = str;
    }

    public long getFinishTime() {
        return this.finishTime;
    }

    public void setFinishTime(long j) {
        this.finishTime = j;
    }
}
