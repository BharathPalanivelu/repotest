package com.shopee.app.ui.setting.privacy;

import android.text.TextUtils;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.f;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.bt;
import com.shopee.app.h.m;
import com.shopee.app.h.o;
import com.shopee.app.network.d.au;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.bo;
import com.shopee.app.network.g;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.n;
import com.shopee.id.R;

public class b extends q<d> {

    /* renamed from: a  reason: collision with root package name */
    private final n f25313a;

    /* renamed from: c  reason: collision with root package name */
    private final bt f25314c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public g f25315d = new g();

    /* renamed from: e  reason: collision with root package name */
    private final UserInfo f25316e;

    /* renamed from: f  reason: collision with root package name */
    private final m f25317f;

    /* renamed from: g  reason: collision with root package name */
    private final i f25318g;
    private e h = new f() {
        public void a(a aVar) {
            b.this.f();
        }
    };
    private e i = new f() {
        public void a(a aVar) {
            ((d) b.this.f19220b).a(b.this.a(((Integer) aVar.data).intValue()));
            b.this.f();
        }
    };
    private e j = new f() {
        public void a(a aVar) {
            ((d) b.this.f19220b).c();
            com.shopee.app.ui.home.me.editprofile.e eVar = (com.shopee.app.ui.home.me.editprofile.e) aVar;
            if (b.this.f25315d != null && eVar.f22356d != null && b.this.f25315d.a().equals(eVar.f22356d.a())) {
                ((d) b.this.f19220b).a(eVar.f22355c);
            }
        }
    };

    public b(n nVar, m mVar, UserInfo userInfo, bt btVar) {
        this.f25313a = nVar;
        this.f25314c = btVar;
        this.f25317f = mVar;
        this.f25316e = userInfo;
        this.f25318g = com.garena.a.a.a.b.a(this);
    }

    public void a() {
        this.f25318g.a();
        this.f25313a.a("SHOP_INFO_EDIT_PROFILE_LOCAL_LOAD", this.j);
        this.f25313a.a("GET_USER_INFO_LOAD", this.h);
        this.f25313a.a("GET_USER_INFO_ERROR", this.i);
    }

    public void b() {
        this.f25318g.b();
        this.f25313a.b("SHOP_INFO_EDIT_PROFILE_LOCAL_LOAD", this.j);
        this.f25313a.b("GET_USER_INFO_LOAD", this.h);
        this.f25313a.b("GET_USER_INFO_ERROR", this.i);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            str = a(aVar.f17892a);
        }
        ((d) this.f19220b).a(str);
        f();
    }

    /* access modifiers changed from: private */
    public String a(int i2) {
        if (i2 != -100) {
            return com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        }
        return com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
    }

    public void e() {
        ((d) this.f19220b).b();
        new au().a(this.f25316e.getUserId());
    }

    public void f() {
        this.f25315d = new g();
        this.f25314c.a(this.f25317f.b(), this.f25316e.getShopId(), this.f25315d);
    }

    public void a(boolean z, boolean z2, boolean z3) {
        bo boVar = new bo();
        o.a().a((az) boVar);
        boVar.a(z, z2, z3);
        ((d) this.f19220b).b();
    }
}
