package com.garena.imageeditor;

import com.garena.imageeditor.a.b.a;
import com.garena.imageeditor.a.b.e;
import com.garena.imageeditor.a.b.f;
import com.garena.imageeditor.a.b.g;
import com.garena.imageeditor.a.b.h;
import com.garena.imageeditor.a.c;
import com.garena.imageeditor.a.d;
import com.garena.imageeditor.b.b;
import jp.co.cyberagent.android.gpuimage.p;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.garena.imageeditor.b.b f8097a = new com.garena.imageeditor.b.b();

    /* renamed from: b  reason: collision with root package name */
    private final ImageEditView f8098b;

    /* renamed from: c  reason: collision with root package name */
    private final jp.co.cyberagent.android.gpuimage.b f8099c;

    /* renamed from: d  reason: collision with root package name */
    private final c f8100d = new c();

    public b(ImageEditView imageEditView, jp.co.cyberagent.android.gpuimage.b bVar) {
        this.f8098b = imageEditView;
        this.f8099c = bVar;
    }

    public com.garena.imageeditor.a.b a(d dVar) {
        com.garena.imageeditor.a.b a2 = this.f8100d.a(dVar);
        if (a2 != null) {
            return a2;
        }
        switch (dVar) {
            case BRIGHTNESS:
                return new com.garena.imageeditor.a.b.b(this, this.f8097a);
            case CONTRAST:
                return new com.garena.imageeditor.a.b.c(this, this.f8097a);
            case SATURATION:
                return new h(this, this.f8097a);
            case FOCUS_BLUR:
                return new a(this.f8098b, this, this.f8097a);
            case ROTATE:
                return new g(this.f8098b, this, this.f8097a);
            case CROP:
                return new com.garena.imageeditor.a.b.d(this.f8098b, this, this.f8097a);
            case FLIP:
                return new e(this.f8098b, this, this.f8097a);
            case PRESET:
                return new f(this.f8098b, this, this.f8097a);
            default:
                return new com.garena.imageeditor.a.b.b(this, this.f8097a);
        }
    }

    public void a(com.garena.imageeditor.a.b bVar) {
        this.f8100d.b(bVar);
        this.f8099c.a(this.f8100d.b());
    }

    public void a() {
        this.f8100d.b((com.garena.imageeditor.a.b) null);
    }

    public void b(com.garena.imageeditor.a.b bVar) {
        this.f8100d.a(bVar);
    }

    public void b() {
        this.f8099c.a(this.f8100d.a());
    }

    public void c() {
        com.garena.imageeditor.b.a a2 = this.f8097a.a();
        if (a2.f8103b == null) {
            a(a2.f8102a).d();
            b();
            return;
        }
        a(a2.f8102a).a(a2.f8103b);
    }

    public void d() {
        com.garena.imageeditor.b.a b2 = this.f8097a.b();
        a(b2.f8102a).a(b2.f8103b);
    }

    public void b(d dVar) {
        this.f8100d.b(dVar);
    }

    public void a(p pVar, boolean z, boolean z2) {
        this.f8099c.a(pVar, z, z2);
        this.f8098b.a(pVar);
        this.f8099c.a();
    }

    public void a(boolean z, boolean z2) {
        jp.co.cyberagent.android.gpuimage.b bVar = this.f8099c;
        bVar.a(bVar.b(), z, z2);
        this.f8099c.a();
    }

    public void a(b.a aVar) {
        this.f8097a.a(aVar);
    }
}
