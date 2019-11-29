package com.shopee.app.web.protocol.notification;

public class UpdateItemShippingMessage {
    private String displayDimension;
    private String displayWeight;
    private String displayedShippingInfo;
    private long editID;
    private long height;
    private long length;
    private String logisticsInfo;
    private int unit;
    private long weight;
    private long width;

    public void setWeight(long j) {
        this.weight = j;
    }

    public long getLength() {
        return this.length;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public long getWidth() {
        return this.width;
    }

    public void setWidth(long j) {
        this.width = j;
    }

    public long getHeight() {
        return this.height;
    }

    public void setHeight(long j) {
        this.height = j;
    }

    public int getUnit() {
        return this.unit;
    }

    public void setUnit(int i) {
        this.unit = i;
    }

    public String getDisplayDimension() {
        return this.displayDimension;
    }

    public String getDisplayWeight() {
        return this.displayWeight;
    }

    public long getWeight() {
        return this.weight;
    }

    public long getEditID() {
        return this.editID;
    }

    public String getLogisticsInfo() {
        return this.logisticsInfo;
    }

    public String getDisplayedShippingInfo() {
        return this.displayedShippingInfo;
    }
}
