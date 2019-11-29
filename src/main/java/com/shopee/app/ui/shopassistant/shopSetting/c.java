package com.shopee.app.ui.shopassistant.shopSetting;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class c extends b implements x<j> {

    /* renamed from: a  reason: collision with root package name */
    String f25550a;

    /* renamed from: b  reason: collision with root package name */
    boolean f25551b;

    /* renamed from: c  reason: collision with root package name */
    boolean f25552c;

    /* renamed from: d  reason: collision with root package name */
    private j f25553d;

    /* renamed from: e  reason: collision with root package name */
    private f f25554e;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f25554e = g.a(this, this.f25550a);
        a((View) this.f25554e);
    }

    public void onBackPressed() {
        this.f25554e.d();
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).b((int) R.string.sp_auto_reply_title).a("SUBMIT_AUTO_REPLY", (int) R.drawable.com_garena_shopee_ic_done).e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f25553d = b.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f25553d.a(this);
    }

    /* renamed from: c */
    public j b() {
        return this.f25553d;
    }
}
