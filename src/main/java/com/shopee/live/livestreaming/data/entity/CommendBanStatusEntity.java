package com.shopee.live.livestreaming.data.entity;

import com.google.a.a.c;
import com.shopee.sdk.b.a;

public class CommendBanStatusEntity extends a {
    @c(a = "is_ban")
    private boolean ban;

    public boolean isBan() {
        return this.ban;
    }

    public void setBan(boolean z) {
        this.ban = z;
    }
}
