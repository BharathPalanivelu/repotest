package com.shopee.app.ui.product.rating;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class d extends b implements x<c> {

    /* renamed from: a  reason: collision with root package name */
    int f24733a;

    /* renamed from: b  reason: collision with root package name */
    long f24734b;

    /* renamed from: c  reason: collision with root package name */
    int f24735c;

    /* renamed from: d  reason: collision with root package name */
    int f24736d;

    /* renamed from: e  reason: collision with root package name */
    String f24737e;

    /* renamed from: f  reason: collision with root package name */
    int f24738f;

    /* renamed from: g  reason: collision with root package name */
    boolean f24739g;
    private c h;
    private g i;

    /* access modifiers changed from: protected */
    public void b(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.b(bundle);
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.i = h.a(this, this.f24733a, this.f24734b, this.f24738f, this.f24739g, this.f24735c, this.f24736d, this.f24737e);
        this.i.setId(R.id.tab_cont);
        a((View) this.i);
        v().setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.h = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.h.a(this);
    }

    /* renamed from: c */
    public c b() {
        return this.h;
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.i.c();
    }

    public void onBackPressed() {
        this.i.d();
    }
}
