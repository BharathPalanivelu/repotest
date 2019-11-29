package com.shopee.live.livestreaming.data.entity;

import com.shopee.sdk.b.a;

public class CICCountDownData extends a {
    private long saveTimestamp;
    private int seconds;
    private int sessionId;
    private int userId;

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public int getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(int i) {
        this.sessionId = i;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setSeconds(int i) {
        this.seconds = i;
    }

    public long getSaveTimestamp() {
        return this.saveTimestamp;
    }

    public void setSaveTimestamp(long j) {
        this.saveTimestamp = j;
    }
}
