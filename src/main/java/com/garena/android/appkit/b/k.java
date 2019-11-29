package com.garena.android.appkit.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class k {

    /* renamed from: a  reason: collision with root package name */
    private static k f7629a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f7630b = new a(Looper.getMainLooper());

    public static k a() {
        if (f7629a == null) {
            synchronized (k.class) {
                if (f7629a == null) {
                    f7629a = new k();
                }
            }
        }
        return f7629a;
    }

    private k() {
    }

    public void a(Runnable runnable) {
        this.f7630b.post(runnable);
    }

    public void a(Runnable runnable, int i) {
        this.f7630b.postDelayed(runnable, (long) i);
    }

    private static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
