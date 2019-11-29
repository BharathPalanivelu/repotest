package com.tencent.imsdk;

import com.tencent.imcore.ThreadEntry;
import com.tencent.imsdk.log.QLog;

final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ThreadEntry f30685a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMCoreAndroidEnv f30686b;

    ad(IMCoreAndroidEnv iMCoreAndroidEnv, ThreadEntry threadEntry) {
        this.f30686b = iMCoreAndroidEnv;
        this.f30685a = threadEntry;
    }

    public final void run() {
        try {
            this.f30685a.run();
        } catch (Throwable th) {
            QLog.e(IMCoreAndroidEnv.logTag, 1, IMFunc.getExceptionInfo(th));
        }
    }
}
