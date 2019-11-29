package com.shopee.live.livestreaming.data.entity.require;

import java.io.Serializable;

public class NotifyRequireEntity implements Serializable {
    private boolean notify_followers;

    public boolean isNotify_followers() {
        return this.notify_followers;
    }

    public void setNotify_followers(boolean z) {
        this.notify_followers = z;
    }
}
