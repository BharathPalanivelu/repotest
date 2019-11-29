package com.android.a.a;

import android.os.Bundle;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f4555a;

    public d(Bundle bundle) {
        this.f4555a = bundle;
    }

    public String a() {
        return this.f4555a.getString("install_referrer");
    }

    public long b() {
        return this.f4555a.getLong("referrer_click_timestamp_seconds");
    }

    public long c() {
        return this.f4555a.getLong("install_begin_timestamp_seconds");
    }
}
