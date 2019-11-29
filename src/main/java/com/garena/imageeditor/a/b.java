package com.garena.imageeditor.a;

import com.garena.imageeditor.b.a;
import jp.co.cyberagent.android.gpuimage.e;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected final com.garena.imageeditor.b.b f8064a;

    /* renamed from: b  reason: collision with root package name */
    protected final com.garena.imageeditor.b f8065b;

    /* renamed from: c  reason: collision with root package name */
    protected g f8066c = h();

    /* renamed from: d  reason: collision with root package name */
    protected g f8067d = this.f8066c;

    /* renamed from: e  reason: collision with root package name */
    protected h f8068e = new h() {
        public void a(g gVar) {
            b.this.b(gVar);
        }

        public i a() {
            b.this.a();
            return new i() {
                public void a() {
                    b.this.c(b.this.f8066c);
                }
            };
        }

        public void b() {
            b.this.b();
        }
    };

    public abstract g a(int i);

    /* access modifiers changed from: protected */
    public abstract void a();

    public abstract void a(g gVar);

    /* access modifiers changed from: protected */
    public abstract void b();

    /* access modifiers changed from: protected */
    public abstract void b(g gVar);

    /* access modifiers changed from: protected */
    public abstract e d(g gVar);

    public abstract d g();

    public abstract g h();

    public abstract int i();

    public b(com.garena.imageeditor.b bVar, com.garena.imageeditor.b.b bVar2) {
        this.f8065b = bVar;
        this.f8064a = bVar2;
    }

    public h c() {
        return this.f8068e;
    }

    public void d() {
        this.f8065b.b(g());
    }

    /* access modifiers changed from: protected */
    public void c(g gVar) {
        this.f8064a.a(new a(g(), gVar));
    }

    public e e() {
        return d(this.f8067d);
    }

    public e f() {
        return d(this.f8066c);
    }
}
