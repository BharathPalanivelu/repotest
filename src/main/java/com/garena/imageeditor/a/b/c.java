package com.garena.imageeditor.a.b;

import com.garena.imageeditor.a.a;
import com.garena.imageeditor.a.g;
import com.garena.imageeditor.b;
import jp.co.cyberagent.android.gpuimage.d;
import jp.co.cyberagent.android.gpuimage.e;

public class c extends a {

    /* renamed from: f  reason: collision with root package name */
    private final d f8073f = new d();

    public c(b bVar, com.garena.imageeditor.b.b bVar2) {
        super(bVar, bVar2);
    }

    /* access modifiers changed from: protected */
    public e d(g gVar) {
        this.f8073f.a(gVar.a("contrast"));
        return this.f8073f;
    }

    public com.garena.imageeditor.a.d g() {
        return com.garena.imageeditor.a.d.CONTRAST;
    }

    public g h() {
        g gVar = new g();
        gVar.a("contrast", Float.valueOf(1.0f));
        return gVar;
    }

    public g a(int i) {
        g gVar = new g();
        gVar.a("contrast", Float.valueOf(((float) i) / 50.0f));
        return gVar;
    }

    public int i() {
        return (int) (this.f8066c.a("contrast") * 50.0f);
    }
}
