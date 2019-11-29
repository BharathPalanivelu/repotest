package com.garena.imageeditor.a;

import com.garena.imageeditor.b;

public abstract class a extends b {
    public a(b bVar, com.garena.imageeditor.b.b bVar2) {
        super(bVar, bVar2);
    }

    public void a(g gVar) {
        this.f8066c = gVar;
        this.f8065b.b((b) this);
        this.f8065b.b();
    }

    /* access modifiers changed from: protected */
    public void b(g gVar) {
        this.f8067d = gVar;
        this.f8065b.a((b) this);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f8066c = this.f8067d;
        this.f8065b.b((b) this);
        this.f8065b.a();
        this.f8065b.b();
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f8065b.a();
        this.f8065b.b();
    }
}
