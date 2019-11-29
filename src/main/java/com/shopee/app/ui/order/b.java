package com.shopee.app.ui.order;

import android.os.Bundle;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.d;
import com.shopee.app.ui.actionbar.e;
import com.shopee.app.ui.order.MyOrderActivity_;
import com.shopee.app.util.ak;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class b extends com.shopee.app.ui.a.b implements e.c, x<d> {

    /* renamed from: a  reason: collision with root package name */
    int f23462a;

    /* renamed from: b  reason: collision with root package name */
    int f23463b;

    /* renamed from: c  reason: collision with root package name */
    String f23464c;

    /* renamed from: d  reason: collision with root package name */
    String f23465d;

    /* renamed from: e  reason: collision with root package name */
    String f23466e;

    /* renamed from: f  reason: collision with root package name */
    UserInfo f23467f;

    /* renamed from: g  reason: collision with root package name */
    bi f23468g;
    ak h;
    MeCounter i;
    private g j;
    private d k;
    private a.b l = new a.b("HOT_WORD_CLICK", R.drawable.com_garena_shopee_ic_search) {
        public void a() {
            b.this.h.am();
        }
    };

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.j = h.a(this, this.f23462a, this.f23464c);
        a((View) this.j);
        this.j.setSelectedIndex(this.f23463b);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1);
        aVar.e(0);
        if (this.f23462a == 1) {
            aVar.b((int) R.string.sp_my_sell);
            aVar.a(this.l);
        } else {
            aVar.b((int) R.string.sp_my_buy);
        }
        aVar.a((a.b) new d(this));
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.k = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.k.a(this);
    }

    /* renamed from: c */
    public d b() {
        return this.k;
    }

    public void a(int i2, Object obj) {
        if (this.f23462a != i2) {
            ((MyOrderActivity_.a) MyOrderActivity_.a(this).b(i2).k(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)).a();
            finish();
            overridePendingTransition(0, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.f23468g.a("ON_SCANNER_RESULT", new com.garena.android.appkit.b.a(str));
    }
}
