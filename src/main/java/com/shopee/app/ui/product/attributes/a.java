package com.shopee.app.ui.product.attributes;

import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.VMItemAttribute;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;

public class a extends q<c> {

    /* renamed from: a  reason: collision with root package name */
    private final i f24238a = b.a(this);

    /* renamed from: c  reason: collision with root package name */
    private n f24239c;

    /* renamed from: d  reason: collision with root package name */
    private VMItemAttribute f24240d;

    public a(n nVar) {
        this.f24239c = nVar;
    }

    public void a() {
        this.f24238a.a();
    }

    public void c() {
        super.c();
        this.f24238a.c();
    }

    public void d() {
        super.d();
        this.f24238a.d();
    }

    public void b() {
        this.f24238a.b();
    }

    public void a(VMItemAttribute vMItemAttribute) {
        this.f24240d = vMItemAttribute;
    }

    /* access modifiers changed from: package-private */
    public void a(u uVar) {
        if (this.f24240d != null && uVar.a() == this.f24240d.getAttrId()) {
            ((c) this.f19220b).a(uVar);
            this.f24239c.a("ON_ATTRIBUTE_SELECTED", new com.garena.android.appkit.b.a(uVar));
        }
    }

    /* access modifiers changed from: package-private */
    public void b(u uVar) {
        VMItemAttribute vMItemAttribute = this.f24240d;
        if (vMItemAttribute != null && vMItemAttribute.getAttrId() == uVar.a()) {
            ((c) this.f19220b).a(uVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(u uVar) {
        VMItemAttribute vMItemAttribute = this.f24240d;
        if (vMItemAttribute != null && vMItemAttribute.getAttrId() == uVar.a()) {
            ((c) this.f19220b).a(this.f24240d, uVar);
        }
    }
}
