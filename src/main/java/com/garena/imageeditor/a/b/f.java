package com.garena.imageeditor.a.b;

import com.garena.imageeditor.ImageEditView;
import com.garena.imageeditor.a.c.n;
import com.garena.imageeditor.a.c.o;
import com.garena.imageeditor.a.d;
import com.garena.imageeditor.a.g;
import com.garena.imageeditor.b;
import jp.co.cyberagent.android.gpuimage.e;

public class f extends com.garena.imageeditor.a.f {
    /* access modifiers changed from: protected */
    public void b() {
    }

    public f(ImageEditView imageEditView, b bVar, com.garena.imageeditor.b.b bVar2) {
        super(imageEditView, bVar, bVar2);
    }

    public void a(g gVar) {
        this.f8066c = gVar;
        this.f8065b.b((com.garena.imageeditor.a.b) this);
        this.f8065b.b();
        this.f8095f.a(this.f8066c.f("preset"));
    }

    /* access modifiers changed from: protected */
    public void b(g gVar) {
        this.f8067d = gVar;
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f8066c = this.f8067d;
        this.f8065b.b((com.garena.imageeditor.a.b) this);
        this.f8065b.b();
    }

    public void d() {
        this.f8095f.a(n.NONE);
        super.d();
    }

    /* access modifiers changed from: protected */
    public e d(g gVar) {
        return o.a(this.f8095f.getContext(), this.f8066c.f("preset"));
    }

    public d g() {
        return d.PRESET;
    }

    public g h() {
        g gVar = new g();
        gVar.a("preset", n.NONE);
        return gVar;
    }
}
