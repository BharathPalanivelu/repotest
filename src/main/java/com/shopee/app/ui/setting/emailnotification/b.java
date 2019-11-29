package com.shopee.app.ui.setting.emailnotification;

import android.text.TextUtils;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.h.c.d;
import com.shopee.app.network.d.br;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import com.shopee.id.R;

public class b extends q<d> {

    /* renamed from: a  reason: collision with root package name */
    private final n f25217a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public br f25218c;

    /* renamed from: d  reason: collision with root package name */
    private final i f25219d;

    /* renamed from: e  reason: collision with root package name */
    private e f25220e = new g() {
        public void onEvent(a aVar) {
            d dVar = (d) aVar;
            if (b.this.f25218c != null && dVar.b().equals(b.this.f25218c.i().a())) {
                ((d) b.this.f19220b).e();
                ((d) b.this.f19220b).a(dVar.a());
            }
        }
    };

    public b(n nVar) {
        this.f25217a = nVar;
        this.f25219d = com.garena.a.a.a.b.a(this);
    }

    public void a() {
        this.f25219d.a();
        this.f25217a.a("SET_USER_INFO", this.f25220e);
    }

    public void b() {
        this.f25219d.b();
        this.f25217a.b("SET_USER_INFO", this.f25220e);
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
        ((d) this.f19220b).e();
        ((d) this.f19220b).b();
        ((d) this.f19220b).a(str);
    }

    public void a(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).d();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25218c = new br();
        this.f25218c.j(userInfo2, z);
    }

    public void b(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).d();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25218c = new br();
        this.f25218c.n(userInfo2, z);
    }

    public void c(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).d();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25218c = new br();
        this.f25218c.l(userInfo2, z);
    }

    public void d(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).d();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25218c = new br();
        this.f25218c.m(userInfo2, z);
    }

    public void e(UserInfo userInfo, boolean z) {
        ((d) this.f19220b).d();
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setPnOption(userInfo.getPnOption());
        this.f25218c = new br();
        this.f25218c.k(userInfo2, z);
    }
}
