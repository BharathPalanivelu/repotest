package com.shopee.livequiz.c;

public abstract class a<T, C> {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f29686a;

    /* renamed from: b  reason: collision with root package name */
    protected c f29687b;

    /* access modifiers changed from: protected */
    public abstract void a(T t, C c2);

    public a(c cVar) {
        this.f29687b = cVar;
    }

    public void b(T t, C c2) {
        this.f29687b.a(this, t, c2);
    }

    /* access modifiers changed from: protected */
    public void a(e eVar) {
        if (this.f29686a) {
            f.a(eVar);
        } else {
            f.c(eVar);
        }
    }
}
