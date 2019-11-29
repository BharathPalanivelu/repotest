package com.airpay.paysdk.base.bean;

public class BPEvent {
    private int endTime;
    private long eventId;
    private String message;
    private int priority;
    private String rule;
    private int startTime;
    private int type;

    public BPEvent(long j, int i, int i2, int i3, int i4, String str, String str2) {
        this.eventId = j;
        this.startTime = i;
        this.endTime = i2;
        this.priority = i3;
        this.type = i4;
        this.rule = str;
        this.message = str2;
    }

    public long getEventId() {
        return this.eventId;
    }

    public int getType() {
        return this.type;
    }

    public String getRule() {
        return this.rule;
    }

    public String getMessage() {
        return this.message;
    }
}
