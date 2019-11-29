package com.shopee.app.web.protocol;

import com.google.a.a.c;
import d.d.b.j;

public final class StartTraceInfo {
    @c(a = "traceName")
    private final String traceName;

    public StartTraceInfo(String str) {
        j.b(str, "traceName");
        this.traceName = str;
    }

    public final String getTraceName() {
        return this.traceName;
    }
}
