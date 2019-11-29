package io.b.e.e.c;

import io.b.b.b;
import io.b.g;
import io.b.g.a;
import io.b.h;
import java.util.concurrent.Callable;

public final class c<T> extends g<T> implements Callable<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends T> f33360a;

    public c(Callable<? extends T> callable) {
        this.f33360a = callable;
    }

    /* access modifiers changed from: protected */
    public void b(h<? super T> hVar) {
        b a2 = io.b.b.c.a();
        hVar.a(a2);
        if (!a2.isDisposed()) {
            try {
                Object call = this.f33360a.call();
                if (a2.isDisposed()) {
                    return;
                }
                if (call == null) {
                    hVar.a();
                } else {
                    hVar.a(call);
                }
            } catch (Throwable th) {
                io.b.c.b.b(th);
                if (!a2.isDisposed()) {
                    hVar.a(th);
                } else {
                    a.a(th);
                }
            }
        }
    }

    public T call() throws Exception {
        return this.f33360a.call();
    }
}
