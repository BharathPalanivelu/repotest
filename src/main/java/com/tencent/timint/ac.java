package com.tencent.timint;

import com.tencent.imsdk.log.QLog;
import com.tencent.imsdk.protocol.quality_report;

final class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ quality_report.ReqBody f32496a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ TIMIntManager f32497b;

    ac(TIMIntManager tIMIntManager, quality_report.ReqBody reqBody) {
        this.f32497b = tIMIntManager;
        this.f32496a = reqBody;
    }

    public final void run() {
        if (!this.f32497b.dbhelper.a(this.f32496a.toByteArray())) {
            QLog.d("MSF.C.TIMIntManager", 1, "Failed to store reqbody to local, uin: " + this.f32496a.uint64_from_uin.get() + " timestamp: " + this.f32496a.uint32_timestamp.get() + " seq: " + this.f32496a.uint32_seq);
        }
    }
}
