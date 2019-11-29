package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

public class f extends Handler implements l {

    /* renamed from: a  reason: collision with root package name */
    private final k f34008a = new k();

    /* renamed from: b  reason: collision with root package name */
    private final int f34009b;

    /* renamed from: c  reason: collision with root package name */
    private final c f34010c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f34011d;

    protected f(c cVar, Looper looper, int i) {
        super(looper);
        this.f34010c = cVar;
        this.f34009b = i;
    }

    public void a(q qVar, Object obj) {
        j a2 = j.a(qVar, obj);
        synchronized (this) {
            this.f34008a.a(a2);
            if (!this.f34011d) {
                this.f34011d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new e("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                j a2 = this.f34008a.a();
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.f34008a.a();
                        if (a2 == null) {
                            this.f34011d = false;
                            this.f34011d = false;
                            return;
                        }
                    }
                }
                this.f34010c.a(a2);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f34009b));
            if (sendMessage(obtainMessage())) {
                this.f34011d = true;
                return;
            }
            throw new e("Could not send handler message");
        } catch (Throwable th) {
            this.f34011d = false;
            throw th;
        }
    }
}
