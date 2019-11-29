package com.shopee.app.ui.tutorial;

import android.os.Bundle;
import android.view.View;
import com.garena.android.appkit.tools.a.a;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.data.store.al;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;

public class f extends b implements x<g> {

    /* renamed from: a  reason: collision with root package name */
    public static long f25713a;

    /* renamed from: b  reason: collision with root package name */
    private g f25714b;

    /* renamed from: c  reason: collision with root package name */
    private al f25715c;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        f25713a = a.b();
        this.f25715c = ar.f().e().loginStore();
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) k.a(this, false));
        v().setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f25714b = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f25714b.a(this);
    }

    /* renamed from: c */
    public g b() {
        return this.f25714b;
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.f25715c.i();
    }
}
