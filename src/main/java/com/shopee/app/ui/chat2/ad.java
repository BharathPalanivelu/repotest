package com.shopee.app.ui.chat2;

import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.chat2.s;
import com.shopee.id.R;

public class ad extends q<af> {

    /* renamed from: a  reason: collision with root package name */
    private final i f20256a = b.a(this);

    /* renamed from: c  reason: collision with root package name */
    private final s f20257c;

    public ad(s sVar) {
        this.f20257c = sVar;
    }

    public void a() {
        this.f20256a.a();
    }

    public void c() {
        this.f20256a.c();
    }

    public void e() {
        this.f20257c.a();
    }

    public void a(boolean z) {
        this.f20257c.a(z);
        ((af) this.f19220b).a(z, ((af) this.f19220b).l);
        ((af) this.f19220b).c();
    }

    /* access modifiers changed from: package-private */
    public void a(s.a aVar) {
        ((af) this.f19220b).a(aVar.f20854a, aVar.f20855b);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f20257c.c();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        ((af) this.f19220b).d();
        ((af) this.f19220b).a(com.garena.android.appkit.tools.b.e(R.string.sp_message_shortcut_updated));
        this.f20257c.c();
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        ((af) this.f19220b).d();
        ((af) this.f19220b).b(com.garena.android.appkit.tools.b.e(R.string.sp_network_error));
        this.f20257c.c();
    }

    public void d() {
        this.f20256a.d();
    }

    public void b() {
        this.f20256a.b();
    }

    public void b(int i) {
        this.f20257c.a(i);
    }
}
