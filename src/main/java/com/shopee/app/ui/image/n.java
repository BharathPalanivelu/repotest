package com.shopee.app.ui.image;

import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.garena.android.appkit.d.a;
import com.shopee.app.d.c.cu;
import com.shopee.app.ui.a.q;

public class n extends q<p> {

    /* renamed from: a  reason: collision with root package name */
    private final com.shopee.app.util.n f23041a;

    /* renamed from: c  reason: collision with root package name */
    private final cu f23042c;

    /* renamed from: d  reason: collision with root package name */
    private i f23043d = b.a(this);

    /* renamed from: e  reason: collision with root package name */
    private String f23044e;

    public n(com.shopee.app.util.n nVar, cu cuVar) {
        this.f23041a = nVar;
        this.f23042c = cuVar;
    }

    public void a() {
        this.f23043d.a();
    }

    public void b() {
        this.f23043d.b();
    }

    public void a(String str) {
        this.f23044e = str;
        this.f23042c.a(this.f23044e);
    }

    /* access modifiers changed from: package-private */
    public void a(cu.c cVar) {
        a.b("image_search onImageSearchPrepareDone %s ", cVar.toString());
        ((p) this.f19220b).a(cVar.f16735c, cVar.f16737e, cVar.f16738f);
    }

    /* access modifiers changed from: package-private */
    public void b(cu.c cVar) {
        ((p) this.f19220b).d();
    }

    /* access modifiers changed from: package-private */
    public void c(cu.c cVar) {
        ((p) this.f19220b).a(cVar.f16734b);
    }
}
