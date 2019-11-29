package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Handler f31426a;

    /* renamed from: b  reason: collision with root package name */
    private Looper f31427b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31428c = true;

    /* renamed from: d  reason: collision with root package name */
    private Thread f31429d;

    public c(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        this.f31427b = handlerThread.getLooper();
        this.f31426a = new Handler(this.f31427b);
        this.f31429d = handlerThread;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        if (this.f31428c) {
            this.f31426a.getLooper().quit();
        }
        super.finalize();
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(final java.lang.Runnable r6) {
        /*
            r5 = this;
            r0 = 1
            boolean[] r0 = new boolean[r0]
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.Thread r2 = r5.f31429d
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0013
            r6.run()
            goto L_0x0033
        L_0x0013:
            android.os.Handler r1 = r5.f31426a
            monitor-enter(r1)
            r2 = 0
            r0[r2] = r2     // Catch:{ all -> 0x0034 }
            android.os.Handler r3 = r5.f31426a     // Catch:{ all -> 0x0034 }
            com.tencent.liteav.basic.util.c$1 r4 = new com.tencent.liteav.basic.util.c$1     // Catch:{ all -> 0x0034 }
            r4.<init>(r6, r0)     // Catch:{ all -> 0x0034 }
            r3.post(r4)     // Catch:{ all -> 0x0034 }
        L_0x0023:
            boolean r6 = r0[r2]     // Catch:{ all -> 0x0034 }
            if (r6 != 0) goto L_0x0032
            android.os.Handler r6 = r5.f31426a     // Catch:{ Exception -> 0x002d }
            r6.wait()     // Catch:{ Exception -> 0x002d }
            goto L_0x0023
        L_0x002d:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x0034 }
            goto L_0x0023
        L_0x0032:
            monitor-exit(r1)     // Catch:{ all -> 0x0034 }
        L_0x0033:
            return
        L_0x0034:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0034 }
            goto L_0x0038
        L_0x0037:
            throw r6
        L_0x0038:
            goto L_0x0037
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.util.c.a(java.lang.Runnable):void");
    }

    public void b(Runnable runnable) {
        this.f31426a.post(runnable);
    }

    public void a(Runnable runnable, long j) {
        this.f31426a.postDelayed(runnable, j);
    }
}
