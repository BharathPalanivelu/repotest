package com.shopee.app.ui.setting.notification2;

import android.text.TextUtils;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.i.a;
import com.shopee.app.h.c.d;
import com.shopee.app.network.d.br;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import com.shopee.id.R;

public class b extends q<d> {

    /* renamed from: a  reason: collision with root package name */
    private final n f25268a;

    /* renamed from: c  reason: collision with root package name */
    private final a f25269c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public br f25270d;

    /* renamed from: e  reason: collision with root package name */
    private final i f25271e;

    /* renamed from: f  reason: collision with root package name */
    private e f25272f = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            d dVar = (d) aVar;
            if (b.this.f25270d != null && dVar.b().equals(b.this.f25270d.i().a())) {
                ((d) b.this.f19220b).i();
                ((d) b.this.f19220b).a(dVar.a());
            }
        }
    };

    public b(n nVar, a aVar) {
        this.f25268a = nVar;
        this.f25271e = com.garena.a.a.a.b.a(this);
        this.f25269c = aVar;
    }

    public void a() {
        this.f25271e.a();
        this.f25268a.a("SET_USER_INFO", this.f25272f);
        this.f25269c.a();
    }

    public void b() {
        this.f25271e.b();
        this.f25268a.b("SET_USER_INFO", this.f25272f);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else if (aVar.f17892a != -100) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        } else {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        ((d) this.f19220b).i();
        ((d) this.f19220b).e();
        ((d) this.f19220b).a(str);
    }

    /* access modifiers changed from: package-private */
    public void a(a.C0257a aVar) {
        ((d) this.f19220b).i();
        ((d) this.f19220b).a(aVar.a());
    }

    public void a(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).h();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25270d = new br();
        this.f25270d.a(userInfo2, z);
    }

    public void b(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).h();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25270d = new br();
        this.f25270d.b(userInfo2, z);
    }

    public void c(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).h();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25270d = new br();
        this.f25270d.c(userInfo2, z);
    }

    public void d(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).h();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25270d = new br();
        this.f25270d.d(userInfo2, z);
    }

    public void e(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).h();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25270d = new br();
        this.f25270d.e(userInfo2, z);
    }

    public void f(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).h();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25270d = new br();
        this.f25270d.f(userInfo2, z);
    }

    public void g(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).h();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25270d = new br();
        this.f25270d.g(userInfo2, z);
    }

    public void h(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).h();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25270d = new br();
        this.f25270d.h(userInfo2, z);
    }

    public void i(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).h();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25270d = new br();
        this.f25270d.i(userInfo2, z);
    }

    public void j(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).h();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25270d = new br();
        this.f25270d.o(userInfo2, z);
    }

    public void a(boolean z) {
        ((d) this.f19220b).h();
        this.f25269c.a(z);
    }

    /* access modifiers changed from: package-private */
    public void k(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).h();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25270d = new br();
        this.f25270d.p(userInfo2, z);
    }

    /* access modifiers changed from: package-private */
    public void l(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).h();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25270d = new br();
        this.f25270d.q(userInfo2, z);
    }

    /* access modifiers changed from: package-private */
    public void m(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).h();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25270d = new br();
        this.f25270d.r(userInfo2, z);
    }
}
