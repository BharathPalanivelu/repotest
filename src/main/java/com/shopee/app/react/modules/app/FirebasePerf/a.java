package com.shopee.app.react.modules.app.FirebasePerf;

import android.text.TextUtils;
import androidx.b.g;
import com.google.firebase.perf.metrics.Trace;
import com.shopee.app.react.protocol.BridgeResult;
import com.shopee.app.web.protocol.StartTraceInfo;
import com.shopee.app.web.protocol.TraceDataInfo;
import com.shopee.app.web.protocol.TraceInfo;
import d.d.b.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final g<String, Trace> f18695a = new g<>();

    public final BridgeResult<?> a(StartTraceInfo startTraceInfo, boolean z) {
        j.b(startTraceInfo, "startTraceParams");
        String traceName = startTraceInfo.getTraceName();
        if (TextUtils.isEmpty(traceName)) {
            return BridgeResult.Companion.fail(1);
        }
        Trace a2 = com.google.firebase.perf.a.a().a(traceName);
        j.a((Object) a2, "FirebasePerformance.getI…nce().newTrace(traceName)");
        a2.start();
        if (!z) {
            traceName = traceName + System.nanoTime();
        }
        this.f18695a.put(traceName, a2);
        return BridgeResult.Companion.success(new TraceInfo(traceName));
    }

    public final BridgeResult<?> a(TraceDataInfo traceDataInfo) {
        j.b(traceDataInfo, "traceDataInfo");
        Trace trace = this.f18695a.get(traceDataInfo.getTraceId());
        if (trace == null) {
            return BridgeResult.Companion.fail(1);
        }
        trace.putMetric(traceDataInfo.getMetricName(), traceDataInfo.getMetricValue());
        return BridgeResult.Companion.success();
    }

    public final BridgeResult<?> a(TraceInfo traceInfo) {
        j.b(traceInfo, "stopTraceParams");
        Trace trace = this.f18695a.get(traceInfo.getTraceId());
        if (trace == null) {
            return BridgeResult.Companion.fail(1);
        }
        trace.stop();
        this.f18695a.remove(trace);
        return BridgeResult.Companion.success();
    }

    public final void a() {
        int size = this.f18695a.size() - 1;
        for (int i = 0; i < size; i++) {
            Trace trace = this.f18695a.get(Integer.valueOf(i));
            if (trace != null) {
                trace.stop();
            }
        }
    }
}
