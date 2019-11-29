package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final c f31194a = new c();

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<Integer, WeakReference<e>> f31195b = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public PhoneStateListener f31196c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f31197d;

    public static c a() {
        return f31194a;
    }

    private c() {
    }

    public synchronized void a(e eVar) {
        if (eVar != null) {
            this.f31195b.put(Integer.valueOf(eVar.hashCode()), new WeakReference(eVar));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(com.tencent.liteav.audio.impl.e r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0005
            monitor-exit(r2)
            return
        L_0x0005:
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.ref.WeakReference<com.tencent.liteav.audio.impl.e>> r0 = r2.f31195b     // Catch:{ all -> 0x0024 }
            int r1 = r3.hashCode()     // Catch:{ all -> 0x0024 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0024 }
            boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.ref.WeakReference<com.tencent.liteav.audio.impl.e>> r0 = r2.f31195b     // Catch:{ all -> 0x0024 }
            int r3 = r3.hashCode()     // Catch:{ all -> 0x0024 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0024 }
            r0.remove(r3)     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r2)
            return
        L_0x0024:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.audio.impl.c.b(com.tencent.liteav.audio.impl.e):void");
    }

    /* access modifiers changed from: private */
    public synchronized void a(int i) {
        Iterator<Map.Entry<Integer, WeakReference<e>>> it = this.f31195b.entrySet().iterator();
        while (it.hasNext()) {
            e eVar = (e) ((WeakReference) it.next().getValue()).get();
            if (eVar != null) {
                eVar.c(i);
            } else {
                it.remove();
            }
        }
    }

    public void a(Context context) {
        if (this.f31196c == null) {
            this.f31197d = context.getApplicationContext();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (c.this.f31196c == null) {
                        PhoneStateListener unused = c.this.f31196c = new PhoneStateListener() {
                            public void onCallStateChanged(int i, String str) {
                                super.onCallStateChanged(i, str);
                                TXCLog.i("AudioCenter:TXCTelephonyMgr", "onCallStateChanged:" + i);
                                c.this.a(i);
                            }
                        };
                        ((TelephonyManager) c.this.f31197d.getSystemService("phone")).listen(c.this.f31196c, 32);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        if (this.f31196c != null && this.f31197d != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (!(c.this.f31196c == null || c.this.f31197d == null)) {
                        ((TelephonyManager) c.this.f31197d.getApplicationContext().getSystemService("phone")).listen(c.this.f31196c, 0);
                    }
                    PhoneStateListener unused = c.this.f31196c = null;
                }
            });
        }
    }
}
