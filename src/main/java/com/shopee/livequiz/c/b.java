package com.shopee.livequiz.c;

import com.garena.android.appkit.d.a;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f29688a;

    /* renamed from: b  reason: collision with root package name */
    private static final TimeUnit f29689b = TimeUnit.SECONDS;

    /* renamed from: c  reason: collision with root package name */
    private static final SynchronousQueue<Runnable> f29690c = new SynchronousQueue<>();

    /* renamed from: d  reason: collision with root package name */
    private ThreadPoolExecutor f29691d = new ThreadPoolExecutor(0, 30, 60, f29689b, f29690c);

    private b() {
    }

    public <T, C> void a(final a<T, C> aVar, final T t, final C c2) {
        this.f29691d.submit(new Runnable() {
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
        if (f29688a == null) {
            f29688a = new b();
        }
        return f29688a;
    }
}
