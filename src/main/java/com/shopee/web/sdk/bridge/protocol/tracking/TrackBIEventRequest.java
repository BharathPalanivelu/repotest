package com.shopee.web.sdk.bridge.protocol.tracking;

public class TrackBIEventRequest {
    private String events;

    public TrackBIEventRequest(String str) {
        this.events = str;
    }

    public String getEvents() {
        return this.events;
    }

    public void setEvents(String str) {
        this.events = str;
    }
}
