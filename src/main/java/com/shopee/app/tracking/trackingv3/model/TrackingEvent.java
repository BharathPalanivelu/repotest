package com.shopee.app.tracking.trackingv3.model;

import d.d.b.j;

public final class TrackingEvent {
    private final Info info;
    private final String pageId;
    private final String source = "android";
    private final long timestamp = System.currentTimeMillis();
    private final String type = "v3";

    public TrackingEvent(String str, Info info2) {
        j.b(str, "pageId");
        j.b(info2, "info");
        this.pageId = str;
        this.info = info2;
    }

    public TrackingEvent(Info info2) {
        j.b(info2, "info");
        this.info = info2;
        this.pageId = "";
    }

    public final boolean isV3Event() {
        return "v3".equals(this.type);
    }
}
