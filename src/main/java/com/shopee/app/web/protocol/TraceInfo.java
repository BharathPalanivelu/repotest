package com.shopee.app.web.protocol;

import com.google.a.a.c;
import d.d.b.j;

public final class TraceInfo {
    @c(a = "traceId")
    private final String traceId;

    public TraceInfo(String str) {
        j.b(str, "traceId");
        this.traceId = str;
    }

    public final String getTraceId() {
        return this.traceId;
    }
}
