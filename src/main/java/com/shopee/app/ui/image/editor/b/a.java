package com.shopee.app.ui.image.editor.b;

import android.view.View;
import android.view.ViewGroup;
import com.garena.imageeditor.a.b.g;
import com.garena.imageeditor.a.d;
import com.garena.imageeditor.a.h;
import com.shopee.app.ui.image.editor.c.a.b;
import com.shopee.app.ui.image.editor.i;

public class a implements i.a<b> {

    /* renamed from: a  reason: collision with root package name */
    private final g f22874a;

    /* renamed from: b  reason: collision with root package name */
    private int f22875b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22876c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f22877d = false;

    /* renamed from: e  reason: collision with root package name */
    private com.garena.imageeditor.b f22878e;

    /* renamed from: f  reason: collision with root package name */
    private h f22879f;

    /* renamed from: g  reason: collision with root package name */
    private com.garena.imageeditor.a.g f22880g;
    private com.garena.imageeditor.a.g h;

    public a(com.garena.imageeditor.b bVar) {
        this.f22878e = bVar;
        this.f22874a = (g) this.f22878e.a(d.ROTATE);
        this.f22879f = this.f22874a.c();
        this.f22880g = this.f22874a.j();
        this.h = new com.garena.imageeditor.a.g(this.f22880g);
    }

    public void a(int i, View view, b bVar, ViewGroup viewGroup) {
        this.f22875b = this.f22880g.d("rotation");
        this.f22876c = this.f22880g.e("flipX");
        this.f22877d = this.f22880g.e("flipY");
        com.shopee.app.ui.image.editor.c.a.a aVar = (com.shopee.app.ui.image.editor.c.a.a) bVar.e();
        if (aVar.d()) {
            this.f22875b -= 90;
            this.f22880g.a("rotation", Integer.valueOf(this.f22875b));
            this.f22880g.a("flipX", Boolean.valueOf(this.f22876c));
            this.f22880g.a("flipY", Boolean.valueOf(this.f22877d));
            this.f22879f.a(this.f22880g);
        } else if (aVar.c()) {
            this.f22875b += 90;
            this.f22880g.a("rotation", Integer.valueOf(this.f22875b));
            this.f22880g.a("flipX", Boolean.valueOf(this.f22876c));
            this.f22880g.a("flipY", Boolean.valueOf(this.f22877d));
            this.f22879f.a(this.f22880g);
        } else if (aVar.b()) {
            int i2 = (this.f22875b + 360) % 360;
            if (i2 == 90 || i2 == 270) {
                this.f22877d = !this.f22877d;
            } else {
                this.f22876c = !this.f22876c;
            }
            this.f22880g.a("rotation", Integer.valueOf(this.f22875b));
            this.f22880g.a("flipX", Boolean.valueOf(this.f22876c));
            this.f22880g.a("flipY", Boolean.valueOf(this.f22877d));
            this.f22879f.a(this.f22880g);
        } else if (aVar.a()) {
            int i3 = (this.f22875b + 360) % 360;
            if (i3 == 90 || i3 == 270) {
                this.f22876c = !this.f22876c;
            } else {
                this.f22877d = !this.f22877d;
            }
            this.f22880g.a("rotation", Integer.valueOf(this.f22875b));
            this.f22880g.a("flipX", Boolean.valueOf(this.f22876c));
            this.f22880g.a("flipY", Boolean.valueOf(this.f22877d));
            this.f22879f.a(this.f22880g);
        }
    }

    public void a() {
        this.f22879f.a().a();
        this.h = new com.garena.imageeditor.a.g(this.f22880g);
    }

    public void b() {
        this.f22879f.b();
        this.f22880g = new com.garena.imageeditor.a.g(this.h);
    }
}
