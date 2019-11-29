package com.shopee.app.ui.shopassistant.shopSetting;

import android.text.TextUtils;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.bt;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.h.c.d;
import com.shopee.app.h.m;
import com.shopee.app.network.c.d.a;
import com.shopee.app.network.d.ao;
import com.shopee.app.network.d.bm;
import com.shopee.app.network.d.bs;
import com.shopee.app.network.g;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.home.me.editprofile.e;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.id.R;

public class l extends q<n> {

    /* renamed from: a  reason: collision with root package name */
    i f25587a;

    /* renamed from: c  reason: collision with root package name */
    private final n f25588c;

    /* renamed from: d  reason: collision with root package name */
    private final bi f25589d;

    /* renamed from: e  reason: collision with root package name */
    private final bt f25590e;

    /* renamed from: f  reason: collision with root package name */
    private final k f25591f;

    /* renamed from: g  reason: collision with root package name */
    private final UserInfo f25592g;
    private final m h;
    private String i;
    private ShopDetail j;
    private g k = new g();
    private int l;

    public l(n nVar, bi biVar, bt btVar, k kVar, m mVar, UserInfo userInfo) {
        this.f25588c = nVar;
        this.f25590e = btVar;
        this.f25589d = biVar;
        this.f25591f = kVar;
        this.h = mVar;
        this.f25592g = userInfo;
        this.f25587a = b.a(this);
    }

    public void e() {
        f();
        new ao().a(this.f25592g.getShopId());
    }

    public void f() {
        this.k = new g();
        this.f25590e.a(this.h.b(), this.f25592g.getShopId(), this.k);
    }

    public void a() {
        this.f25587a.a();
    }

    public void c() {
        this.f25587a.c();
    }

    public void d() {
        this.f25587a.d();
    }

    public void b() {
        this.f25587a.b();
    }

    /* access modifiers changed from: package-private */
    public void a(ShopDetail shopDetail) {
        ((n) this.f19220b).b();
        ((n) this.f19220b).a(shopDetail);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        ((n) this.f19220b).b();
    }

    /* access modifiers changed from: package-private */
    public void h() {
        ((n) this.f19220b).b();
    }

    /* access modifiers changed from: package-private */
    public void i() {
        ((n) this.f19220b).d();
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        String str;
        ((n) this.f19220b).b();
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            str = a(aVar.f17892a);
        }
        ((n) this.f19220b).a(str);
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar) {
        if (eVar.f22356d != null && this.k.a().equals(eVar.f22356d.a())) {
            this.j = eVar.f22355c;
            ((n) this.f19220b).a(this.j);
        }
    }

    private String a(int i2) {
        if (i2 != -100) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        }
        return com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
    }

    public void a(boolean z, boolean z2) {
        this.f25591f.a(z, z2);
        ((n) this.f19220b).a();
    }

    public void a(boolean z, boolean z2, boolean z3) {
        this.f25591f.a(z, z2, z3);
        ((n) this.f19220b).a();
    }

    public void a(boolean z) {
        ((n) this.f19220b).a();
        bm bmVar = new bm();
        this.l = 1;
        this.i = bmVar.i().a();
        bmVar.a(z);
    }

    /* access modifiers changed from: package-private */
    public void a(d dVar) {
        ((n) this.f19220b).b();
        if (this.l == 2) {
            if (dVar.a().isHolidayMode()) {
                ((n) this.f19220b).a((int) R.string.sp_vacation_mode_on_success);
            } else {
                ((n) this.f19220b).a((int) R.string.sp_vacation_mode_off_success);
            }
        }
        ((n) this.f19220b).a(dVar.a());
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i2 = aVar.f17892a;
            if (i2 == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i2 == 1) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_invalid_email_format);
            } else if (i2 != 11) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_duplicate_user_name);
            }
        }
        ((n) this.f19220b).b();
        ((n) this.f19220b).b(str);
    }

    public void b(boolean z) {
        ((n) this.f19220b).a();
        this.l = 2;
        new bs().a(z);
    }
}
