package com.garena.imageeditor.a.b;

import com.garena.imageeditor.a.a;
import com.garena.imageeditor.a.d;
import com.garena.imageeditor.a.g;
import com.garena.imageeditor.b;
import jp.co.cyberagent.android.gpuimage.e;
import jp.co.cyberagent.android.gpuimage.j;

public class h extends a {

    /* renamed from: f  reason: collision with root package name */
    private final j f8076f = new j();

    public h(b bVar, com.garena.imageeditor.b.b bVar2) {
        super(bVar, bVar2);
    }

    /* access modifiers changed from: protected */
    public e d(g gVar) {
        this.f8076f.a(gVar.a("saturation"));
        return this.f8076f;
    }

    public d g() {
        return d.SATURATION;
    }

    public g h() {
        g gVar = new g();
        gVar.a("saturation", Float.valueOf(1.0f));
        return gVar;
    }

    public g a(int i) {
        g gVar = new g();
        gVar.a("saturation", Float.valueOf(((float) i) / 50.0f));
        return gVar;
    }

    public int i() {
        return (int) (this.f8066c.a("saturation") * 50.0f);
    }
}
