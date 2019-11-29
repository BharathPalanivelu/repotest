package com.shopee.live.livestreaming.data.entity;

import com.google.a.a.c;
import com.shopee.sdk.b.a;

public class FollowStatusEntity extends a {
    @c(a = "followed")
    private boolean followed;

    public boolean isFollowed() {
        return this.followed;
    }

    public void setFollowed(boolean z) {
        this.followed = z;
    }
}
