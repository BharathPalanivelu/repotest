package com.salesforce.android.service.common.utilities.internal.android;

import android.os.Build;

public class AndroidInfo {
    public String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public String getDeviceModel() {
        return Build.MODEL;
    }

    public String getDeviceOSVersion() {
        return Build.VERSION.RELEASE;
    }
}
