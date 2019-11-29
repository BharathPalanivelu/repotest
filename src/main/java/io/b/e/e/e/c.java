package io.b.e.e.e;

import io.b.b.b;
import io.b.g.a;
import io.b.q;
import io.b.s;
import java.util.concurrent.Callable;

public final class c<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    final Callable<? extends T> f33465a;

    public c(Callable<? extends T> callable) {
        this.f33465a = callable;
    }

    /* access modifiers changed from: protected */
    public void b(s<? super T> sVar) {
        b a2 = io.b.b.c.a();
        sVar.a(a2);
        if (!a2.isDisposed()) {
            try {
                Object a3 = io.b.e.b.b.a(this.f33465a.call(), "The callable returned a null value");
                if (!a2.isDisposed()) {
                    sVar.a(a3);
                }
            } catch (Throwable th) {
                io.b.c.b.b(th);
                if (!a2.isDisposed()) {
                    sVar.a(th);
                } else {
                    a.a(th);
                }
            }
        }
    }
}
