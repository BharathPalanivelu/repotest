package com.garena.imageeditor.a.b;

import com.garena.imageeditor.ImageEditView;
import com.garena.imageeditor.a.d;
import com.garena.imageeditor.a.f;
import com.garena.imageeditor.a.g;
import com.garena.imageeditor.b;

public class e extends f {
    public void d() {
    }

    public e(ImageEditView imageEditView, b bVar, com.garena.imageeditor.b.b bVar2) {
        super(imageEditView, bVar, bVar2);
    }

    public void a(g gVar) {
        this.f8066c = gVar;
        this.f8065b.a(this.f8066c.e("flipX"), this.f8066c.e("flipY"));
        this.f8065b.b((com.garena.imageeditor.a.b) this);
    }

    /* access modifiers changed from: protected */
    public void b(g gVar) {
        this.f8067d = gVar;
        this.f8065b.a(this.f8067d.e("flipX"), this.f8067d.e("flipY"));
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f8066c = this.f8067d;
        this.f8065b.b((com.garena.imageeditor.a.b) this);
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f8065b.a(this.f8066c.e("flipX"), this.f8066c.e("flipY"));
    }

    public d g() {
        return d.FLIP;
    }

    public g h() {
        g gVar = new g();
        gVar.a("flipX", false);
        gVar.a("flipY", false);
        return gVar;
    }
}
