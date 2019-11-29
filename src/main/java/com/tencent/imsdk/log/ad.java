package com.tencent.imsdk.log;

import android.text.format.DateFormat;
import com.tencent.imsdk.IMCoreWrapper;
import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.TIMLogLevel;
import java.io.FileWriter;

final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ TIMLogLevel f31096a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f31097b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ String f31098c;

    ad(TIMLogLevel tIMLogLevel, String str, String str2) {
        this.f31096a = tIMLogLevel;
        this.f31097b = str;
        this.f31098c = str2;
    }

    public final void run() {
        try {
            if (IMMsfCoreProxy.get().getMode() == 1 && IMMsfCoreProxy.get().getSdkConfig() != null && !IMCoreWrapper.get().isIMCoreInited()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (QLog.writer == null) {
                    QLog.initLogFile(currentTimeMillis);
                }
                if (QLog.writer != null && QLog.lock.tryLock()) {
                    QLog.writer.write("[" + DateFormat.format("yy-MM-dd HH:mm:ss", currentTimeMillis).toString() + "][" + this.f31096a.getDescr() + "][][" + this.f31097b + "]" + this.f31098c + "\n");
                    QLog.writer.flush();
                    QLog.lock.unlock();
                }
            } else if (IMCoreWrapper.get().isIMCoreInited() && QLog.writer != null) {
                QLog.writer.close();
                FileWriter unused = QLog.writer = null;
            }
        } catch (Throwable unused2) {
        }
    }
}
