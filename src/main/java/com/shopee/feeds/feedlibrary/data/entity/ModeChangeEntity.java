package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class ModeChangeEntity implements Serializable {
    private boolean mSingleMode;

    public boolean ismSingleMode() {
        return this.mSingleMode;
    }

    public void setmSingleMode(boolean z) {
        this.mSingleMode = z;
    }
}
