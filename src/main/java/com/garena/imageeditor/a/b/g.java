package com.garena.imageeditor.a.b;

import com.garena.imageeditor.ImageEditView;
import com.garena.imageeditor.a.d;
import com.garena.imageeditor.a.f;
import com.garena.imageeditor.b;
import jp.co.cyberagent.android.gpuimage.p;

public class g extends f {
    public g(ImageEditView imageEditView, b bVar, com.garena.imageeditor.b.b bVar2) {
        super(imageEditView, bVar, bVar2);
    }

    public void a(com.garena.imageeditor.a.g gVar) {
        this.f8066c = new com.garena.imageeditor.a.g(gVar);
        e(this.f8066c);
        this.f8065b.b((com.garena.imageeditor.a.b) this);
    }

    /* access modifiers changed from: protected */
    public void b(com.garena.imageeditor.a.g gVar) {
        this.f8067d = gVar;
        int d2 = this.f8067d.d("rotation");
        this.f8065b.a(p.fromInt((d2 + 360) % 360), this.f8067d.e("flipX"), this.f8067d.e("flipY"));
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f8066c = new com.garena.imageeditor.a.g(this.f8067d);
        this.f8065b.b((com.garena.imageeditor.a.b) this);
    }

    /* access modifiers changed from: protected */
    public void b() {
        int d2 = this.f8066c.d("rotation");
        this.f8065b.a(p.fromInt((d2 + 360) % 360), this.f8066c.e("flipX"), this.f8066c.e("flipY"));
    }

    public void d() {
        this.f8066c = h();
        this.f8065b.a(p.NORMAL, false, false);
    }

    public d g() {
        return d.ROTATE;
    }

    public com.garena.imageeditor.a.g h() {
        com.garena.imageeditor.a.g gVar = new com.garena.imageeditor.a.g();
        gVar.a("rotation", 0);
        gVar.a("flipX", false);
        gVar.a("flipY", false);
        return gVar;
    }

    private void e(com.garena.imageeditor.a.g gVar) {
        boolean z;
        int d2 = gVar.d("rotation");
        boolean e2 = gVar.e("flipX");
        boolean e3 = gVar.e("flipY");
        int i = (d2 + 360) % 360;
        if (i == 90 || i == 270) {
            boolean z2 = false;
            if (!e2 || !e3) {
                z = false;
            } else {
                z2 = true;
                z = true;
            }
            if (e2) {
                z = true;
            }
            e2 = e3 ? true : z2;
        } else {
            z = e3;
        }
        this.f8065b.a(p.fromInt(i), e2, z);
    }

    public com.garena.imageeditor.a.g j() {
        return new com.garena.imageeditor.a.g(this.f8066c);
    }
}
