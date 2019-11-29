package com.shopee.app.ui.shopassistant.chatSetting;

import android.text.TextUtils;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.bt;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.h.m;
import com.shopee.app.network.c.d.a;
import com.shopee.app.network.d.ao;
import com.shopee.app.network.g;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.home.me.editprofile.e;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.id.R;

public class d extends q<f> {

    /* renamed from: a  reason: collision with root package name */
    i f25398a;

    /* renamed from: c  reason: collision with root package name */
    private final n f25399c;

    /* renamed from: d  reason: collision with root package name */
    private final bi f25400d;

    /* renamed from: e  reason: collision with root package name */
    private final bt f25401e;

    /* renamed from: f  reason: collision with root package name */
    private final c f25402f;

    /* renamed from: g  reason: collision with root package name */
    private final UserInfo f25403g;
    private final m h;
    private ShopDetail i;
    private g j = new g();

    public d(n nVar, bi biVar, bt btVar, c cVar, m mVar, UserInfo userInfo) {
        this.f25399c = nVar;
        this.f25401e = btVar;
        this.f25400d = biVar;
        this.f25402f = cVar;
        this.h = mVar;
        this.f25403g = userInfo;
        this.f25398a = b.a(this);
    }

    public void e() {
        f();
        new ao().a(this.f25403g.getShopId());
    }

    public void f() {
        this.j = new g();
        this.f25401e.a(this.h.b(), this.f25403g.getShopId(), this.j);
    }

    public void a() {
        this.f25398a.a();
    }

    public void c() {
        this.f25398a.c();
    }

    public void d() {
        this.f25398a.d();
    }

    public void b() {
        this.f25398a.b();
    }

    /* access modifiers changed from: package-private */
    public void a(ShopDetail shopDetail) {
        if (this.f25403g.getShopId() == shopDetail.getShopId()) {
            ((f) this.f19220b).b();
            ((f) this.f19220b).a(shopDetail);
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        ((f) this.f19220b).b();
    }

    /* access modifiers changed from: package-private */
    public void h() {
        ((f) this.f19220b).b();
    }

    /* access modifiers changed from: package-private */
    public void i() {
        ((f) this.f19220b).e();
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        String str;
        ((f) this.f19220b).b();
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            str = a(aVar.f17892a);
        }
        ((f) this.f19220b).a(str);
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar) {
        if (eVar.f22356d != null && this.j.a().equals(eVar.f22356d.a())) {
            this.i = eVar.f22355c;
            ((f) this.f19220b).a(this.i);
        }
    }

    private String a(int i2) {
        if (i2 != -100) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        }
        return com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
    }

    public void a(boolean z, String str, boolean z2) {
        this.f25402f.a(z, str, z2);
    }
}
