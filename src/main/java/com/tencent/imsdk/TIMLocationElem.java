package com.tencent.imsdk;

public class TIMLocationElem extends TIMElem {
    private String desc;
    private double latitude;
    private double longitude;

    public TIMLocationElem() {
        this.type = TIMElemType.Location;
    }

    public String getDesc() {
        return this.desc;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setLatitude(double d2) {
        this.latitude = d2;
    }

    public void setLongitude(double d2) {
        this.longitude = d2;
    }
}
