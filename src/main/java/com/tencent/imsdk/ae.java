package com.tencent.imsdk;

import com.tencent.imcore.RunClosure;
import com.tencent.imsdk.log.QLog;

final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ RunClosure f30687a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMCoreAndroidEnv f30688b;

    ae(IMCoreAndroidEnv iMCoreAndroidEnv, RunClosure runClosure) {
        this.f30688b = iMCoreAndroidEnv;
        this.f30687a = runClosure;
    }

    public final void run() {
        try {
            this.f30687a.run();
        } catch (Throwable th) {
            QLog.e(IMCoreAndroidEnv.logTag, 1, IMFunc.getExceptionInfo(th));
        }
    }
}
