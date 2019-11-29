package com.shopee.app.ui.product.attributes;

import android.os.Bundle;
import android.view.View;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.product.add.d;
import com.shopee.app.ui.product.add.o;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class g extends b implements x<d> {

    /* renamed from: a  reason: collision with root package name */
    int f24284a;

    /* renamed from: b  reason: collision with root package name */
    String f24285b;

    /* renamed from: c  reason: collision with root package name */
    int f24286c;

    /* renamed from: d  reason: collision with root package name */
    String f24287d;

    /* renamed from: e  reason: collision with root package name */
    boolean f24288e = false;

    /* renamed from: f  reason: collision with root package name */
    byte[] f24289f;

    /* renamed from: g  reason: collision with root package name */
    int f24290g;
    private d h;

    public interface a {
        void a(g gVar);
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        a((View) r.a(this, this.f24284a, this.f24287d, this.f24286c, this.f24289f, this.f24290g, this.f24288e));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        if (this.f24286c < 20) {
            aVar.f(1);
        } else {
            aVar.f(2);
            aVar.b(com.garena.android.appkit.tools.b.a(R.string.sp_search_for_x, this.f24285b));
        }
        aVar.e(0).a(com.garena.android.appkit.tools.b.e(R.string.sp_label_set) + SQLBuilder.BLANK + this.f24285b);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.h = o.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.h.a(this);
    }

    /* renamed from: c */
    public d b() {
        return this.h;
    }
}
