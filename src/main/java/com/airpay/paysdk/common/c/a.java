package com.airpay.paysdk.common.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Handler f3964a;

    /* renamed from: b  reason: collision with root package name */
    private Timer f3965b;

    /* renamed from: com.airpay.paysdk.common.c.a$a  reason: collision with other inner class name */
    private static class C0075a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final a f3969a = new a();
    }

    private a() {
    }

    public static a a() {
        return C0075a.f3969a;
    }

    public void b() {
        com.airpay.paysdk.common.b.a.d("BBUILoop init", new Object[0]);
        this.f3964a = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                com.airpay.paysdk.common.b.a.d("ui handler thread id=" + Thread.currentThread().getId(), new Object[0]);
                Runnable runnable = (Runnable) message.obj;
                if (runnable != null) {
                    runnable.run();
                } else {
                    com.airpay.paysdk.common.b.a.a("UI callback is null", new Object[0]);
                }
            }
        };
        this.f3965b = new Timer();
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            if (c()) {
                runnable.run();
            } else {
                this.f3964a.post(runnable);
            }
        }
    }

    public void a(Runnable runnable, long j) {
        if (runnable != null) {
            this.f3964a.postDelayed(runnable, j);
        }
    }

    public void b(final Runnable runnable, long j) {
        if (runnable != null) {
            this.f3965b.schedule(new TimerTask() {
                public void run() {
                    runnable.run();
                }
            }, j);
        }
    }

    public void b(Runnable runnable) {
        Handler handler = this.f3964a;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public static boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
