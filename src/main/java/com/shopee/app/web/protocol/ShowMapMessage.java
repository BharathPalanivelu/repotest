package com.shopee.app.web.protocol;

public class ShowMapMessage {
    private double latitude;
    private double longitude;
    private String shopname;
    private String title;

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getTitle() {
        return this.title;
    }

    public String getShopname() {
        return this.shopname;
    }
}
