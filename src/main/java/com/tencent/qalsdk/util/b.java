package com.tencent.qalsdk.util;

import com.tencent.qalsdk.QALCallBack;

final class b implements QALCallBack {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f32326a;

    b(GuestHelper guestHelper, String str) {
        this.f32326a = str;
    }

    public final void onError(int i, String str) {
        QLog.e("GuestHelper", 1, this.f32326a + " bindID fail:" + i + ":" + str);
    }

    public final void onSuccess() {
        QLog.i("GuestHelper", 1, this.f32326a + " bindID succ");
    }
}
