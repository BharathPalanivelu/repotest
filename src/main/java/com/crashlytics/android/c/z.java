package com.crashlytics.android.c;

import android.content.Context;
import android.os.Bundle;

class z implements at {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6610a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6611b;

    public z(Context context, String str) {
        this.f6610a = context;
        this.f6611b = str;
    }

    public String a() {
        try {
            Bundle bundle = this.f6610a.getPackageManager().getApplicationInfo(this.f6611b, 128).metaData;
            if (bundle != null) {
                return bundle.getString("io.fabric.unity.crashlytics.version");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
