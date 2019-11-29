package com.shopee.livequiz.c;

import com.garena.android.appkit.d.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile g f29704a;

    /* renamed from: b  reason: collision with root package name */
    private static final TimeUnit f29705b = TimeUnit.SECONDS;

    /* renamed from: c  reason: collision with root package name */
    private static final BlockingQueue<Runnable> f29706c = new LinkedBlockingQueue();

    /* renamed from: d  reason: collision with root package name */
    private ThreadPoolExecutor f29707d = new ThreadPoolExecutor(3, 5, 120, f29705b, f29706c);

    private g() {
    }

    public <T, C> void a(final a<T, C> aVar, final T t, final C c2) {
        this.f29707d.submit(new Runnable() {
            public void run() {
                try {
                    aVar.a(t, c2);
                } catch (Exception e2) {
                    a.a(e2);
                }
            }
        });
    }

    public static c a() {
        if (f29704a == null) {
            f29704a = new g();
        }
        return f29704a;
    }
}
