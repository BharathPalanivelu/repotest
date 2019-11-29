package com.shopee.feeds.feedlibrary.data.entity;

public class ImageSizeEntity {
    private boolean hasSet = false;
    private long height = 0;
    private long width = 0;

    public void setHasSet(boolean z) {
        this.hasSet = z;
    }

    public boolean isHasSet() {
        return this.hasSet;
    }

    public void setWidth(long j) {
        this.width = j;
    }

    public long getWidth() {
        return this.width;
    }

    public void setHeight(long j) {
        this.height = j;
    }

    public long getHeight() {
        return this.height;
    }
}
