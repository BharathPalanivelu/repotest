package com.shopee.app.web.protocol;

import com.google.a.a.c;
import d.d.b.j;

public class TraceDataInfo {
    @c(a = "metricName")
    private final String metricName;
    @c(a = "metricValue")
    private final long metricValue;
    @c(a = "traceId")
    private final String traceId;

    public TraceDataInfo(String str, String str2, long j) {
        j.b(str, "traceId");
        j.b(str2, "metricName");
        this.traceId = str;
        this.metricName = str2;
        this.metricValue = j;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final String getMetricName() {
        return this.metricName;
    }

    public final long getMetricValue() {
        return this.metricValue;
    }
}
