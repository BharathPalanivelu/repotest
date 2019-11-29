package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class GetInsTokenEntity implements Serializable {
    private boolean insState;

    public GetInsTokenEntity(boolean z) {
        this.insState = z;
    }

    public boolean isInsState() {
        return this.insState;
    }

    public void setInsState(boolean z) {
        this.insState = z;
    }
}
