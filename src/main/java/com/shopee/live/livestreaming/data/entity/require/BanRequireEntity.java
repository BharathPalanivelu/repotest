package com.shopee.live.livestreaming.data.entity.require;

import java.io.Serializable;

public class BanRequireEntity implements Serializable {
    private long ban_uid;

    public long getBan_uid() {
        return this.ban_uid;
    }

    public void setBan_uid(long j) {
        this.ban_uid = j;
    }
}
