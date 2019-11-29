package io.b.e.e.a;

import io.b.b;
import io.b.c;
import java.util.concurrent.Callable;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    final Callable<?> f33349a;

    public a(Callable<?> callable) {
        this.f33349a = callable;
    }

    /* access modifiers changed from: protected */
    public void b(c cVar) {
        io.b.b.b a2 = io.b.b.c.a();
        cVar.a(a2);
        try {
            this.f33349a.call();
            if (!a2.isDisposed()) {
                cVar.a();
            }
        } catch (Throwable th) {
            io.b.c.b.b(th);
            if (!a2.isDisposed()) {
                cVar.a(th);
            }
        }
    }
}
