package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.a.a.c;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;

@BatchedEvent(groupId = "deviceEvents")
public class DeviceEvent extends BaseEvent {
    @c(a = "application")
    private final String mApplication;
    @c(a = "applicationVersion")
    private final String mApplicationVersion;
    @c(a = "device")
    private final String mDevice;
    @c(a = "os")
    private final String mOsVersion;
    @c(a = "sdk")
    private final String mSdkVersion;

    public DeviceEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        super(str, str2);
        this.mDevice = str4;
        this.mSdkVersion = str3;
        this.mApplication = str5;
        this.mApplicationVersion = str6;
        this.mOsVersion = str7;
    }

    public String getSdkVersion() {
        return this.mSdkVersion;
    }

    public String getDevice() {
        return this.mDevice;
    }

    public String getApplication() {
        return this.mApplication;
    }

    public String getApplicationVersion() {
        return this.mApplicationVersion;
    }

    public String getOsVersion() {
        return this.mOsVersion;
    }
}
