package com.tencent.qalsdk.service;

import com.tencent.qalsdk.base.remote.IMsfServiceCallbacker;
import com.tencent.qalsdk.sdk.r;
import com.tencent.qalsdk.util.QLog;
import java.util.concurrent.LinkedBlockingDeque;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f32303a = true;

    /* renamed from: b  reason: collision with root package name */
    String f32304b;

    /* renamed from: c  reason: collision with root package name */
    String f32305c;

    /* renamed from: d  reason: collision with root package name */
    LinkedBlockingDeque<r> f32306d = new LinkedBlockingDeque<>();

    /* renamed from: e  reason: collision with root package name */
    private volatile long f32307e = 0;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f32308f = false;

    /* renamed from: g  reason: collision with root package name */
    private volatile long f32309g = 0;
    private IMsfServiceCallbacker h;

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r3, java.lang.String r4, com.tencent.qalsdk.base.remote.IMsfServiceCallbacker r5) {
        /*
            r2 = this;
            r2.f32304b = r3
            r2.f32305c = r4
            r4 = 0
            if (r5 == 0) goto L_0x000a
            r2.h = r5
            goto L_0x0011
        L_0x000a:
            com.tencent.qalsdk.base.remote.IMsfServiceCallbacker r5 = r2.h
            if (r5 != 0) goto L_0x0011
            r2.f32303a = r4
            goto L_0x0014
        L_0x0011:
            r5 = 1
            r2.f32303a = r5
        L_0x0014:
            r0 = 0
            r2.f32309g = r0
            r2.f32308f = r4
            boolean r4 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r4 == 0) goto L_0x003c
            r4 = 2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            java.lang.String r3 = " onAppBind, isAppConnected "
            r5.append(r3)
            boolean r3 = r2.f32303a
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.String r5 = "MSF.S.AppProcessInfo"
            com.tencent.qalsdk.util.QLog.d(r5, r4, r3)
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.service.b.a(java.lang.String, java.lang.String, com.tencent.qalsdk.base.remote.IMsfServiceCallbacker):void");
    }

    public final IMsfServiceCallbacker a() {
        return this.h;
    }

    public final void b() {
        this.h = null;
        this.f32303a = false;
        this.f32308f = false;
        if (QLog.isColorLevel()) {
            QLog.d("MSF.S.AppProcessInfo", 2, this.f32304b + " setAppDisConnected, isAppConnected " + this.f32303a);
        }
    }
}
