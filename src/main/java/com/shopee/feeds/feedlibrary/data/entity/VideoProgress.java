package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class VideoProgress implements Serializable {
    private int progress;

    public VideoProgress(int i) {
        this.progress = i;
    }

    public int getProgress() {
        return this.progress;
    }
}
