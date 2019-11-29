package com.garena.android.appkit.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.garena.android.appkit.d.a;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f6694a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f6695b = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            a.e("ui handler thread id=" + Thread.currentThread().getId(), new Object[0]);
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            } else {
                a.a("UI callback is null", new Object[0]);
            }
        }
    };

    public static f a() {
        if (f6694a == null) {
            synchronized (f.class) {
                if (f6694a == null) {
                    f6694a = new f();
                }
            }
        }
        return f6694a;
    }

    private f() {
    }

    public void a(Runnable runnable) {
        this.f6695b.post(runnable);
    }

    public void a(Runnable runnable, int i) {
        this.f6695b.postDelayed(runnable, (long) i);
    }

    public void b(Runnable runnable) {
        this.f6695b.removeCallbacks(runnable);
    }
}
