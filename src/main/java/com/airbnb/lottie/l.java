package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class l<T> {

    /* renamed from: a  reason: collision with root package name */
    public static Executor f3762a = Executors.newCachedThreadPool();

    /* renamed from: b  reason: collision with root package name */
    private Thread f3763b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<h<T>> f3764c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<h<Throwable>> f3765d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f3766e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final FutureTask<k<T>> f3767f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public volatile k<T> f3768g;

    public l(Callable<k<T>> callable) {
        this(callable, false);
    }

    l(Callable<k<T>> callable, boolean z) {
        this.f3764c = new LinkedHashSet(1);
        this.f3765d = new LinkedHashSet(1);
        this.f3766e = new Handler(Looper.getMainLooper());
        this.f3768g = null;
        this.f3767f = new FutureTask<>(callable);
        if (z) {
            try {
                a(callable.call());
            } catch (Throwable th) {
                a(new k(th));
            }
        } else {
            f3762a.execute(this.f3767f);
            b();
        }
    }

    /* access modifiers changed from: private */
    public void a(k<T> kVar) {
        if (this.f3768g == null) {
            this.f3768g = kVar;
            a();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized l<T> a(h<T> hVar) {
        if (!(this.f3768g == null || this.f3768g.a() == null)) {
            hVar.a(this.f3768g.a());
        }
        this.f3764c.add(hVar);
        b();
        return this;
    }

    public synchronized l<T> b(h<T> hVar) {
        this.f3764c.remove(hVar);
        c();
        return this;
    }

    public synchronized l<T> c(h<Throwable> hVar) {
        if (!(this.f3768g == null || this.f3768g.b() == null)) {
            hVar.a(this.f3768g.b());
        }
        this.f3765d.add(hVar);
        b();
        return this;
    }

    public synchronized l<T> d(h<Throwable> hVar) {
        this.f3765d.remove(hVar);
        c();
        return this;
    }

    private void a() {
        this.f3766e.post(new Runnable() {
            public void run() {
                if (l.this.f3768g != null && !l.this.f3767f.isCancelled()) {
                    k a2 = l.this.f3768g;
                    if (a2.a() != null) {
                        l.this.a(a2.a());
                    } else {
                        l.this.a(a2.b());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(T t) {
        for (h a2 : new ArrayList(this.f3764c)) {
            a2.a(t);
        }
    }

    /* access modifiers changed from: private */
    public void a(Throwable th) {
        ArrayList<h> arrayList = new ArrayList<>(this.f3765d);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (h a2 : arrayList) {
            a2.a(th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void b() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.d()     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0021
            com.airbnb.lottie.k<T> r0 = r2.f3768g     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x000c
            goto L_0x0021
        L_0x000c:
            com.airbnb.lottie.l$2 r0 = new com.airbnb.lottie.l$2     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "LottieTaskObserver"
            r0.<init>(r1)     // Catch:{ all -> 0x0023 }
            r2.f3763b = r0     // Catch:{ all -> 0x0023 }
            java.lang.Thread r0 = r2.f3763b     // Catch:{ all -> 0x0023 }
            r0.start()     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = "Starting TaskObserver thread"
            com.airbnb.lottie.c.a(r0)     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            return
        L_0x0021:
            monitor-exit(r2)
            return
        L_0x0023:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.l.b():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void c() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.d()     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r1)
            return
        L_0x0009:
            java.util.Set<com.airbnb.lottie.h<T>> r0 = r1.f3764c     // Catch:{ all -> 0x0024 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0015
            com.airbnb.lottie.k<T> r0 = r1.f3768g     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
        L_0x0015:
            java.lang.Thread r0 = r1.f3763b     // Catch:{ all -> 0x0024 }
            r0.interrupt()     // Catch:{ all -> 0x0024 }
            r0 = 0
            r1.f3763b = r0     // Catch:{ all -> 0x0024 }
            java.lang.String r0 = "Stopping TaskObserver thread"
            com.airbnb.lottie.c.a(r0)     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r1)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.l.c():void");
    }

    private boolean d() {
        Thread thread = this.f3763b;
        return thread != null && thread.isAlive();
    }
}
