package com.shopee.shopeetracker.model;

import com.shopee.shopeetracker.bimodel.TrackingEvent;

public class TrackingEventV3 extends TrackingEvent {
    private InfoV3 info;

    public final boolean isV3Event() {
        return "v3".equals(this.type);
    }

    public TrackingEventV3(String str, InfoV3 infoV3) {
        super("v3");
        this.pageId = str;
        this.info = infoV3;
        this.source = "android";
        this.timestamp = System.currentTimeMillis();
    }

    public TrackingEventV3(InfoV3 infoV3) {
        this("", infoV3);
    }
}
