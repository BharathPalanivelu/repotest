package com.shopee.app.ui.image.crop;

import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends b implements x<b> {

    /* renamed from: a  reason: collision with root package name */
    String f22792a;

    /* renamed from: b  reason: collision with root package name */
    int f22793b = 1;

    /* renamed from: c  reason: collision with root package name */
    int f22794c = 1;

    /* renamed from: d  reason: collision with root package name */
    boolean f22795d = false;

    /* renamed from: e  reason: collision with root package name */
    private b f22796e;

    /* renamed from: f  reason: collision with root package name */
    private d f22797f;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f22797f = e.a(this, this.f22792a, this.f22793b, this.f22794c, this.f22795d);
        a((View) this.f22797f);
        v().setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.secondary_dark));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).c((int) R.color.white).b((int) R.string.sp_label_image_crop);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f22796e = g.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f22796e.a(this);
    }

    /* renamed from: c */
    public b b() {
        return this.f22796e;
    }
}
