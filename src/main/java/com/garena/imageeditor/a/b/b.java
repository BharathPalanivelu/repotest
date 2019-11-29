package com.garena.imageeditor.a.b;

import com.garena.imageeditor.a.a;
import com.garena.imageeditor.a.d;
import com.garena.imageeditor.a.g;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import jp.co.cyberagent.android.gpuimage.c;
import jp.co.cyberagent.android.gpuimage.e;

public class b extends a {

    /* renamed from: f  reason: collision with root package name */
    private final c f8072f = new c();

    public b(com.garena.imageeditor.b bVar, com.garena.imageeditor.b.b bVar2) {
        super(bVar, bVar2);
    }

    /* access modifiers changed from: protected */
    public e d(g gVar) {
        this.f8072f.a(gVar.a("brightness"));
        return this.f8072f;
    }

    public d g() {
        return d.BRIGHTNESS;
    }

    public g h() {
        g gVar = new g();
        gVar.a("brightness", Float.valueOf(BitmapDescriptorFactory.HUE_RED));
        return gVar;
    }

    public g a(int i) {
        g gVar = new g();
        gVar.a("brightness", Float.valueOf(((float) (i - 50)) / 100.0f));
        return gVar;
    }

    public int i() {
        return ((int) (this.f8066c.a("brightness") * 100.0f)) + 50;
    }
}
