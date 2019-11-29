package io.b.e.d;

import io.b.b.b;
import io.b.o;

public abstract class a<T, R> implements io.b.e.c.a<R>, o<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final o<? super R> f33338a;

    /* renamed from: b  reason: collision with root package name */
    protected b f33339b;

    /* renamed from: c  reason: collision with root package name */
    protected io.b.e.c.a<T> f33340c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f33341d;

    /* renamed from: e  reason: collision with root package name */
    protected int f33342e;

    /* access modifiers changed from: protected */
    public boolean b() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    public a(o<? super R> oVar) {
        this.f33338a = oVar;
    }

    public final void a(b bVar) {
        if (io.b.e.a.b.validate(this.f33339b, bVar)) {
            this.f33339b = bVar;
            if (bVar instanceof io.b.e.c.a) {
                this.f33340c = (io.b.e.c.a) bVar;
            }
            if (b()) {
                this.f33338a.a((b) this);
                c();
            }
        }
    }

    public void a(Throwable th) {
        if (this.f33341d) {
            io.b.g.a.a(th);
            return;
        }
        this.f33341d = true;
        this.f33338a.a(th);
    }

    /* access modifiers changed from: protected */
    public final void b(Throwable th) {
        io.b.c.b.b(th);
        this.f33339b.dispose();
        a(th);
    }

    public void a() {
        if (!this.f33341d) {
            this.f33341d = true;
            this.f33338a.a();
        }
    }

    /* access modifiers changed from: protected */
    public final int a(int i) {
        io.b.e.c.a<T> aVar = this.f33340c;
        if (aVar == null || (i & 4) != 0) {
            return 0;
        }
        int requestFusion = aVar.requestFusion(i);
        if (requestFusion != 0) {
            this.f33342e = requestFusion;
        }
        return requestFusion;
    }

    public void dispose() {
        this.f33339b.dispose();
    }

    public boolean isDisposed() {
        return this.f33339b.isDisposed();
    }

    public boolean isEmpty() {
        return this.f33340c.isEmpty();
    }

    public void clear() {
        this.f33340c.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
