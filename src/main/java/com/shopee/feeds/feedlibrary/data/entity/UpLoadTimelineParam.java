package com.shopee.feeds.feedlibrary.data.entity;

import java.io.Serializable;

public class UpLoadTimelineParam implements Serializable {
    private String feed_id;
    private boolean share_ins;

    public String getFeed_id() {
        String str = this.feed_id;
        return str == null ? "" : str;
    }

    public void setFeed_id(String str) {
        this.feed_id = str;
    }

    public boolean isShare_ins() {
        return this.share_ins;
    }

    public void setShare_ins(boolean z) {
        this.share_ins = z;
    }
}
