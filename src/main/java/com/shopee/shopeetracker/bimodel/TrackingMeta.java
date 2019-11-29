package com.shopee.shopeetracker.bimodel;

import com.google.a.a.c;

public class TrackingMeta {
    @c(a = "advertising_id")
    public String advertising_id;
    @c(a = "app_id")
    public int appId = 0;
    @c(a = "app_version")
    public String app_version;
    @c(a = "brand")
    public String brand;
    @c(a = "client_ip")
    public String client_ip;
    @c(a = "cookies")
    public TrackingCookie cookies;
    @c(a = "finger_print")
    public String finger_print;
    @c(a = "locale")
    public String locale;
    @c(a = "model")
    public String model;
    @c(a = "os")
    public String os;
    @c(a = "os_version")
    public String os_version;
    @c(a = "platform")
    public String platform = "android";
    @c(a = "userid")
    public Integer userid;
    @c(a = "wifi")
    public boolean wifi;
}
