package com.shopee.shopeetracker.bimodel;

import com.google.a.a.c;

public class TrackingEvent {
    @c(a = "pageId")
    public String pageId;
    @c(a = "source")
    public String source = "android";
    @c(a = "timestamp")
    public long timestamp;
    @c(a = "type")
    public String type;

    public TrackingEvent(String str) {
        this.type = str;
        this.timestamp = System.currentTimeMillis();
    }
}
