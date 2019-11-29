package com.tencent.timint;

import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.log.QLog;

final class ae implements TIMValueCallBack<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f32500a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ ad f32501b;

    ae(ad adVar, int i) {
        this.f32501b = adVar;
        this.f32500a = i;
    }

    public final void onError(int i, String str) {
        QLog.d("MSF.C.TIMIntManager", 1, "resend quality_report faild! code: " + i + " desc: " + str);
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        if (!this.f32501b.f32498a.dbhelper.a(this.f32500a)) {
            QLog.d("MSF.C.TIMIntManager", 1, "delete row from local failed, id: " + this.f32500a);
        }
    }
}
