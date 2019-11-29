package io.a.a.a.a.c;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class h<V> extends FutureTask<V> implements b<l>, i, l {

    /* renamed from: b  reason: collision with root package name */
    final Object f33142b;

    public h(Callable<V> callable) {
        super(callable);
        this.f33142b = a((Object) callable);
    }

    public h(Runnable runnable, V v) {
        super(runnable, v);
        this.f33142b = a((Object) runnable);
    }

    public int compareTo(Object obj) {
        return ((i) a()).compareTo(obj);
    }

    /* renamed from: a */
    public void c(l lVar) {
        ((b) ((i) a())).c(lVar);
    }

    public Collection<l> c() {
        return ((b) ((i) a())).c();
    }

    public boolean d() {
        return ((b) ((i) a())).d();
    }

    public e b() {
        return ((i) a()).b();
    }

    public void b(boolean z) {
        ((l) ((i) a())).b(z);
    }

    public boolean f() {
        return ((l) ((i) a())).f();
    }

    public void a(Throwable th) {
        ((l) ((i) a())).a(th);
    }

    public <T extends b<l> & i & l> T a() {
        return (b) this.f33142b;
    }

    /* access modifiers changed from: protected */
    public <T extends b<l> & i & l> T a(Object obj) {
        if (j.a(obj)) {
            return (b) obj;
        }
        return new j();
    }
}
