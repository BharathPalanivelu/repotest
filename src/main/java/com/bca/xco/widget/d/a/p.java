package com.bca.xco.widget.d.a;

import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.a.w;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private int f5108a = 64;

    /* renamed from: b  reason: collision with root package name */
    private int f5109b = 5;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f5110c;

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f5111d;

    /* renamed from: e  reason: collision with root package name */
    private final Deque<w.a> f5112e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    private final Deque<w.a> f5113f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    private final Deque<w> f5114g = new ArrayDeque();

    public synchronized ExecutorService a() {
        if (this.f5111d == null) {
            this.f5111d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp Dispatcher", false));
        }
        return this.f5111d;
    }

    private void c() {
        if (this.f5113f.size() < this.f5108a && !this.f5112e.isEmpty()) {
            Iterator<w.a> it = this.f5112e.iterator();
            while (it.hasNext()) {
                w.a next = it.next();
                if (b(next) < this.f5109b) {
                    it.remove();
                    this.f5113f.add(next);
                    a().execute(next);
                }
                if (this.f5113f.size() >= this.f5108a) {
                    return;
                }
            }
        }
    }

    private int b(w.a aVar) {
        int i = 0;
        for (w.a b2 : this.f5113f) {
            if (b2.b().equals(aVar.b())) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(w wVar) {
        this.f5114g.add(wVar);
    }

    /* access modifiers changed from: package-private */
    public void a(w.a aVar) {
        a(this.f5113f, aVar, true);
    }

    /* access modifiers changed from: package-private */
    public void b(w wVar) {
        a(this.f5114g, wVar, false);
    }

    private <T> void a(Deque<T> deque, T t, boolean z) {
        int b2;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    c();
                }
                b2 = b();
                runnable = this.f5110c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (b2 == 0 && runnable != null) {
            runnable.run();
        }
    }

    public synchronized int b() {
        return this.f5113f.size() + this.f5114g.size();
    }
}
