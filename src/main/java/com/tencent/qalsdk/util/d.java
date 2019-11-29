package com.tencent.qalsdk.util;

import com.tencent.qalsdk.QALCallBack;

final class d implements QALCallBack {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ c f32329a;

    d(c cVar) {
        this.f32329a = cVar;
    }

    public final void onError(int i, String str) {
        QLog.e("GuestHelper", 1, this.f32329a.f32327a + "tlsRefreshID bindID fail:" + i + ":" + str);
    }

    public final void onSuccess() {
        QLog.i("GuestHelper", 1, this.f32329a.f32327a + "tlsRefreshID bindID succ");
    }
}
