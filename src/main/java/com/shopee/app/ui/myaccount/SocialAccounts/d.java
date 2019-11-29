package com.shopee.app.ui.myaccount.SocialAccounts;

import android.text.TextUtils;
import com.beetalk.sdk.f;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.an;
import com.shopee.app.d.c.ao;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.instagram.e;
import com.shopee.app.line.LineAuthProxyActivity;
import com.shopee.app.network.d.bq;
import com.shopee.app.network.d.bt;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.setting.account.a;
import com.shopee.app.util.n;
import com.shopee.id.R;

public class d extends q<f> {

    /* renamed from: a  reason: collision with root package name */
    private final n f23282a;

    /* renamed from: c  reason: collision with root package name */
    private final an f23283c;

    /* renamed from: d  reason: collision with root package name */
    private e f23284d;

    /* renamed from: e  reason: collision with root package name */
    private a f23285e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public bt f23286f;

    /* renamed from: g  reason: collision with root package name */
    private final i f23287g;
    private final UserInfo h;
    private final com.shopee.app.d.c.bt i;
    private final ao j;
    private ShopDetail k;
    private com.garena.android.appkit.b.e l = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((f) d.this.f19220b).m();
            ((f) d.this.f19220b).c((String) aVar.data);
        }
    };
    private com.garena.android.appkit.b.e m = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            if (((String) aVar.data) != null) {
                ((f) d.this.f19220b).e((String) aVar.data);
            }
        }
    };
    private com.garena.android.appkit.b.e n = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((f) d.this.f19220b).d((String) aVar.data);
        }
    };
    private com.garena.android.appkit.b.e o = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((f) d.this.f19220b).m();
            ((f) d.this.f19220b).a((UserInfo) aVar.data);
        }
    };
    private com.garena.android.appkit.b.e p = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((f) d.this.f19220b).m();
            ((f) d.this.f19220b).a(((com.shopee.app.ui.auth.a.a) aVar).a());
        }
    };
    private com.garena.android.appkit.b.e q = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ((f) d.this.f19220b).m();
            ((f) d.this.f19220b).a((UserInfo) aVar.data);
            new com.shopee.app.network.d.ao().a(((UserInfo) aVar.data).getShopId());
            if (d.this.f23286f != null && d.this.f23286f.f18222a) {
                bt unused = d.this.f23286f = null;
                com.shopee.app.f.a.a().f();
                ((f) d.this.f19220b).n();
            } else if (d.this.f23286f != null && d.this.f23286f.f18224c) {
                bt unused2 = d.this.f23286f = null;
                ((f) d.this.f19220b).o();
            }
        }
    };

    public d(n nVar, UserInfo userInfo, an anVar, com.shopee.app.d.c.bt btVar, ao aoVar, e eVar, a aVar) {
        this.f23282a = nVar;
        this.f23283c = anVar;
        this.f23284d = eVar;
        this.h = userInfo;
        this.i = btVar;
        this.f23285e = aVar;
        this.j = aoVar;
        this.f23287g = b.a(this);
    }

    public void a() {
        this.f23287g.a();
        this.f23282a.a("EMAIL_VERIFIED", this.o);
        this.f23282a.a("BIND_ACCOUNT_SUCCESS", this.p);
        this.f23282a.a("FACEBOOK_INFO_GET", this.l);
        this.f23282a.a("UNBIND_ACCOUNT_SUCCESS", this.q);
        this.f23282a.a("ON_TWITTER_USERNAME", this.n);
        this.f23282a.a("INSTAGRAM_NAME", this.m);
    }

    public void b() {
        this.f23287g.b();
        this.f23282a.b("EMAIL_VERIFIED", this.o);
        this.f23282a.b("BIND_ACCOUNT_SUCCESS", this.p);
        this.f23282a.b("FACEBOOK_INFO_GET", this.l);
        this.f23282a.b("UNBIND_ACCOUNT_SUCCESS", this.q);
        this.f23282a.b("ON_TWITTER_USERNAME", this.n);
        this.f23282a.b("INSTAGRAM_NAME", this.m);
    }

    public void a(String str) {
        new com.shopee.app.network.d.d().b(str);
        ((f) this.f19220b).l();
    }

    public void e() {
        bt a2 = new bt.a().b(true).a();
        a2.g();
        if (com.shopee.app.f.a.a().b()) {
            this.f23286f = a2;
        }
        ((f) this.f19220b).l();
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i2 = aVar.f17892a;
            if (i2 == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i2 != 5) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                com.shopee.app.f.a.a().f();
                f.d();
                str = com.garena.android.appkit.tools.b.e(R.string.sp_social_bind_error);
            }
        }
        ((f) this.f19220b).m();
        ((f) this.f19220b).b(str);
    }

    /* access modifiers changed from: package-private */
    public void b(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else if (aVar.f17892a != -100) {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
        } else {
            str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
        }
        ((f) this.f19220b).m();
        ((f) this.f19220b).b(str);
    }

    /* access modifiers changed from: package-private */
    public void a(ShopDetail shopDetail) {
        this.k = shopDetail;
    }

    public void f() {
        this.i.a(this.h.getUserId(), this.h.getShopId(), (com.shopee.app.network.g) null);
        new com.shopee.app.network.d.ao().a(this.h.getShopId());
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.h.c.b bVar) {
        ShopDetail shopDetail = this.k;
        if (shopDetail != null) {
            int gender = shopDetail.getGender();
            if (!(this.k.getGender() == 1 || this.k.getGender() == 2)) {
                gender = bVar.a();
            }
            int i2 = gender;
            Integer birthdayTimeStamp = this.k.getBirthdayTimeStamp();
            new bq().a((String) null, (String) null, (String) null, i2, birthdayTimeStamp == null ? Integer.valueOf(bVar.b()) : birthdayTimeStamp);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(com.shopee.app.network.c.d.a aVar) {
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
        ((f) this.f19220b).m();
        ((f) this.f19220b).k();
        ((f) this.f19220b).b(str);
    }

    public void b(String str) {
        this.f23283c.a(str);
        this.j.a();
        ((f) this.f19220b).l();
    }

    public void g() {
        this.f23285e.a(this.f23284d);
    }

    /* access modifiers changed from: package-private */
    public void c(String str) {
        new com.shopee.app.network.d.d().c(str);
        ((f) this.f19220b).l();
    }

    public void h() {
        bt a2 = new bt.a().a(true).a();
        a2.g();
        this.f23286f = a2;
        ((f) this.f19220b).l();
    }

    public void i() {
        if (this.f19220b != null && ((f) this.f19220b).f23310f != null) {
            LineAuthProxyActivity.a(((f) this.f19220b).f23310f);
        }
    }
}
