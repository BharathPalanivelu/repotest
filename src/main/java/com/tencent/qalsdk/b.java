package com.tencent.qalsdk;

import com.tencent.qalsdk.util.QLog;

final class b implements QALInitListener {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ QALSDKManager f32146a;

    b(QALSDKManager qALSDKManager) {
        this.f32146a = qALSDKManager;
    }

    public final void onInitSuccess() {
        this.f32146a.inited = true;
        QLog.e("QALSDKManager", 1, this.f32146a.processName + " init qal sdk done!");
    }

    public final void onInitError(int i, String str) {
        this.f32146a.inited = false;
    }
}
