package com.tencent.imsdk.log;

final class ae implements Runnable {
    ae() {
    }

    public final void run() {
        if (QLogImpl.sContext != null && QLogImpl.isLogToFile && !QLogImpl.isInitLogFileDone.get()) {
            new af(this, "QLogInitThread").start();
        }
    }
}
