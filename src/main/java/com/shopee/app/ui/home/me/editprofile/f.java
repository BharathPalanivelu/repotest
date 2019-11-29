package com.shopee.app.ui.home.me.editprofile;

import android.text.TextUtils;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.i;
import com.garena.android.appkit.tools.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.bt;
import com.shopee.app.d.c.dx;
import com.shopee.app.d.c.eh;
import com.shopee.app.d.c.ej;
import com.shopee.app.d.c.g.d;
import com.shopee.app.network.d.ao;
import com.shopee.app.network.d.au;
import com.shopee.app.network.d.bq;
import com.shopee.app.network.g;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.id.R;

public class f extends q<h> {

    /* renamed from: a  reason: collision with root package name */
    private final bi f22357a;

    /* renamed from: c  reason: collision with root package name */
    private final UserInfo f22358c;

    /* renamed from: d  reason: collision with root package name */
    private final n f22359d;

    /* renamed from: e  reason: collision with root package name */
    private final bt f22360e;

    /* renamed from: f  reason: collision with root package name */
    private final eh f22361f;

    /* renamed from: g  reason: collision with root package name */
    private final ej f22362g;
    private final d h;
    private final dx i;
    /* access modifiers changed from: private */
    public g j;
    /* access modifiers changed from: private */
    public ao k;
    /* access modifiers changed from: private */
    public au l;
    /* access modifiers changed from: private */
    public String m;
    private final i n;
    private e o = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            ((h) f.this.f19220b).p();
        }
    };
    private e p = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            if (((com.shopee.app.h.c.d) aVar).b().equals(f.this.m)) {
                ((h) f.this.f19220b).r();
                ((h) f.this.f19220b).n();
            }
        }
    };
    private e q = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            ((h) f.this.f19220b).r();
            ((h) f.this.f19220b).o();
        }
    };
    private e r = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            String str = (String) aVar.data;
            if (f.this.k != null && str.equals(f.this.k.i().a())) {
                ((h) f.this.f19220b).r();
                f.this.f();
            }
        }
    };
    private e s = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            String str = (String) aVar.data;
            if (f.this.l != null && str.equals(f.this.l.i().a())) {
                ((h) f.this.f19220b).r();
                f.this.f();
            }
        }
    };
    private e t = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            ((h) f.this.f19220b).r();
            e eVar = (e) aVar;
            if (eVar.f22356d != null && f.this.j != null && eVar.f22356d.a().equals(f.this.j.a())) {
                ((h) f.this.f19220b).a(eVar.f22355c);
            }
        }
    };
    private e u = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            ((h) f.this.f19220b).setAvatar((String) aVar.data);
        }
    };
    private e v = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            ((h) f.this.f19220b).b(b.e(R.string.sp_unable_to_load_image));
        }
    };
    private e w = new com.garena.android.appkit.b.g() {
        public void onEvent(a aVar) {
            ((h) f.this.f19220b).setCover((String) aVar.data);
        }
    };

    public f(n nVar, bi biVar, UserInfo userInfo, d dVar, bt btVar, eh ehVar, dx dxVar, ej ejVar) {
        this.f22359d = nVar;
        this.f22357a = biVar;
        this.f22358c = userInfo;
        this.f22360e = btVar;
        this.f22361f = ehVar;
        this.h = dVar;
        this.i = dxVar;
        this.f22362g = ejVar;
        this.n = com.garena.a.a.a.b.a(this);
    }

    public void e() {
        ((h) this.f19220b).q();
        f();
        int shopId = this.f22358c.getShopId();
        int userId = this.f22358c.getUserId();
        this.k = new ao();
        this.k.a(shopId);
        this.l = new au();
        this.l.a(userId);
    }

    /* access modifiers changed from: private */
    public void f() {
        this.j = new g();
        this.f22360e.a(this.f22358c.getUserId(), this.f22358c.getShopId(), this.j);
    }

    public void a(String str) {
        this.f22361f.a(str);
    }

    public void b(String str) {
        this.f22362g.a(str);
    }

    public void a() {
        this.n.a();
        this.f22359d.a("SHOP_INFO_EDIT_PROFILE_LOCAL_LOAD", this.t);
        this.f22359d.a("SET_USER_INFO", this.p);
        this.f22359d.a("UPDATE_SHOP_INFO", this.q);
        this.f22359d.a("SHOP_EDIT_INFO_FETCHED", this.r);
        this.f22359d.a("GET_USER_INFO_LOAD_EDIT", this.s);
        this.f22359d.a("AVATAR_SELECTED", this.u);
        this.f22359d.a("AVATAR_SELECTED_FAIL", this.v);
        this.f22359d.a("COVER_SELECTED", this.w);
        this.f22359d.a("COVER_SELECTED_FAIL", this.v);
    }

    public void c() {
        this.f22357a.a("EDIT_PROFILE_SUBMIT_PROFILE", this.o);
    }

    public void d() {
        this.f22357a.b("EDIT_PROFILE_SUBMIT_PROFILE", this.o);
    }

    public void b() {
        this.n.b();
        this.f22359d.b("SHOP_INFO_EDIT_PROFILE_LOCAL_LOAD", this.t);
        this.f22359d.b("UPDATE_SHOP_INFO", this.q);
        this.f22359d.b("SET_USER_INFO", this.p);
        this.f22359d.b("SHOP_EDIT_INFO_FETCHED", this.r);
        this.f22359d.b("GET_USER_INFO_LOAD_EDIT", this.s);
        this.f22359d.b("AVATAR_SELECTED", this.u);
        this.f22359d.b("AVATAR_SELECTED_FAIL", this.v);
        this.f22359d.b("COVER_SELECTED", this.w);
        this.f22359d.b("COVER_SELECTED_FAIL", this.v);
    }

    public void c(String str) {
        this.h.a(str);
    }

    private String a(int i2) {
        if (i2 == -100) {
            return b.e(R.string.sp_network_error);
        }
        if (i2 != 11) {
            return b.e(R.string.sp_unknown_error);
        }
        return b.e(R.string.sp_duplicate_shop_name);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        ((h) this.f19220b).r();
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i2 = aVar.f17892a;
            if (i2 == -100) {
                str = b.e(R.string.sp_network_error);
            } else if (i2 != 11) {
                str = b.e(R.string.sp_unknown_error);
            } else {
                str = b.e(R.string.sp_error_user_name_duplicate);
            }
        }
        ((h) this.f19220b).b(str);
    }

    /* access modifiers changed from: package-private */
    public void a(UserInfo userInfo) {
        this.k = new ao();
        this.k.a(this.f22358c.getShopId());
        ((h) this.f19220b).a(userInfo);
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.ui.auth.a.a aVar) {
        a(aVar.a());
    }

    /* access modifiers changed from: package-private */
    public void b(com.shopee.app.network.c.d.a aVar) {
        String str;
        ((h) this.f19220b).r();
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            str = a(aVar.f17892a);
        }
        ((h) this.f19220b).b(str);
    }

    public void a(String str, String str2, String str3, int i2, Integer num, String str4, String str5) {
        ((h) this.f19220b).q();
        bq bqVar = new bq();
        this.m = bqVar.i().a();
        this.i.a(str, str2, str3, i2, num, str4, str5, bqVar);
    }
}
