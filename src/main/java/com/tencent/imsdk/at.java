package com.tencent.imsdk;

import com.tencent.imcore.IMCore;
import com.tencent.imsdk.log.QLog;
import java.io.File;

final class at implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f30726a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ IMCoreWrapper f30727b;

    at(IMCoreWrapper iMCoreWrapper, String str) {
        this.f30727b = iMCoreWrapper;
        this.f30726a = str;
    }

    public final void run() {
        try {
            TIMManager.getInstanceById(this.f30726a).getCoreUser().loginSync();
            if (IMMsfCoreProxy.get().getSdkConfig() != null) {
                IMCore.get().clearLog(IMMsfCoreProxy.get().getSdkConfig().getLogPath(), System.currentTimeMillis() / 1000);
                File[] listFiles = IMMsfCoreProxy.get().getContext().getCacheDir().listFiles();
                if (listFiles != null) {
                    for (File delete : listFiles) {
                        delete.delete();
                    }
                }
            }
        } catch (Throwable th) {
            QLog.e("imsdk.IMCoreWrapper", 1, QLog.getStackTraceString(th));
        }
    }
}
