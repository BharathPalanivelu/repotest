package com.tencent.imsdk.log;

import android.os.Process;
import android.util.Log;
import com.garena.android.gpns.utility.CONSTANT;
import com.tencent.qalsdk.sdk.MsfSdkUtils;

final class af extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ ae f31099a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    af(ae aeVar, String str) {
        super(str);
        this.f31099a = aeVar;
    }

    public final void run() {
        if (QLogImpl.isLogToFile && QLogImpl.isInitLogFileDone.compareAndSet(false, true)) {
            try {
                String unused = QLogImpl.processName = MsfSdkUtils.getProcessName(QLogImpl.sContext);
                try {
                    String unused2 = QLogImpl.packageName = QLogImpl.sContext.getPackageName();
                } catch (Exception unused3) {
                    String unused4 = QLogImpl.packageName = "unknow";
                }
                int unused5 = QLogImpl.myProcessId = Process.myPid();
                Log.d("appMemory", "QLog init retry ");
                QLogImpl.initLogFile(System.currentTimeMillis());
                QLogImpl.t.setName("logWriteThread");
                QLogImpl.t.start();
                QLogImpl.retryInitHandler.removeCallbacks(QLogImpl.acutualInitRunnable);
            } catch (Exception e2) {
                QLogImpl.isInitLogFileDone.set(false);
                e2.printStackTrace();
                int i = QLogImpl.retryInitTimes.get();
                Log.d("appMemory", "QLog init post retry " + i + " times, interval " + QLogImpl.INTERVAL_RETRY_INIT[i]);
                QLogImpl.retryInitHandler.removeCallbacks(QLogImpl.acutualInitRunnable);
                QLogImpl.retryInitHandler.postDelayed(QLogImpl.acutualInitRunnable, (long) (QLogImpl.INTERVAL_RETRY_INIT[i] * CONSTANT.TIME.MIN_1));
                int i2 = i + 1;
                if (i2 >= QLogImpl.INTERVAL_RETRY_INIT.length) {
                    i2 = 0;
                }
                QLogImpl.retryInitTimes.set(i2);
            }
        }
    }
}
