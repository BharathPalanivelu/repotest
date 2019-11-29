package com.shopee.app.data.store;

import android.content.SharedPreferences;
import c.a.a.a.a;
import c.a.a.a.b;
import c.a.a.a.d;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.income.ShopBalance;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.util.ad;
import java.util.List;

public class al extends ay {
    private ad<List<MeFeature>> A;
    private ad<List<MeFeature>> B;
    private a C;

    /* renamed from: a  reason: collision with root package name */
    private b f6943a;

    /* renamed from: b  reason: collision with root package name */
    private b f6944b;

    /* renamed from: c  reason: collision with root package name */
    private ad<UserInfo> f6945c;

    /* renamed from: d  reason: collision with root package name */
    private ad<ShopBalance> f6946d;

    /* renamed from: e  reason: collision with root package name */
    private b f6947e;

    /* renamed from: f  reason: collision with root package name */
    private a f6948f;

    /* renamed from: g  reason: collision with root package name */
    private a f6949g;
    private a h;
    private d i;
    private d j;
    private b k;
    private d l;
    private a m;
    private a n;
    private a o;
    private a p;
    private a q;
    private a r;
    private a s;
    private a t;
    private a u;
    private ad<com.shopee.app.data.a> v;
    private d w;
    private d x;
    private a y;
    private a z;

    public al(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f6945c = new ad<>(sharedPreferences, "userInfo", ServiceLogger.PLACEHOLDER, new com.google.a.c.a<UserInfo>() {
        });
        this.f6946d = new ad<>(sharedPreferences, "shopBalance", ServiceLogger.PLACEHOLDER, new com.google.a.c.a<ShopBalance>() {
        });
        this.f6947e = new b(sharedPreferences, "connectionType", 2);
        this.f6948f = new a(sharedPreferences, "rnLocalhost", false);
        this.f6949g = new a(sharedPreferences, "tutorialSeen", false);
        this.h = new a(sharedPreferences, "languageSet", false);
        this.i = new d(sharedPreferences, "webConnection", "");
        this.j = new d(sharedPreferences, "serverConnection", "");
        this.f6943a = new b(sharedPreferences, "upgradeCoolDownTime", 172800);
        this.f6944b = new b(sharedPreferences, "forbiddenAggressiveCacheState", 0);
        this.k = new b(sharedPreferences, "developerSupport", 0);
        this.l = new d(sharedPreferences, "rnConnection", "");
        this.m = new a(sharedPreferences, "frescoDebug", false);
        this.n = new a(sharedPreferences, "csHelpMode", false);
        this.o = new a(sharedPreferences, "trackLogEnabled", false);
        this.p = new a(sharedPreferences, "accessToContacts", false);
        this.q = new a(sharedPreferences, "isReferralNew", true);
        this.s = new a(sharedPreferences, "isShopeeKreditNew", true);
        this.t = new a(sharedPreferences, "isLiveStreamingNew", true);
        this.u = new a(sharedPreferences, "isPhoneAutoConverted", false);
        this.v = new ad<>(sharedPreferences, "voucherInfo", ServiceLogger.PLACEHOLDER, new com.google.a.c.a<com.shopee.app.data.a>() {
        });
        this.w = new d(sharedPreferences, "trackConnection", "");
        this.x = new d(sharedPreferences, "tongdunDomainUrl", "");
        this.r = new a(sharedPreferences, "isNewWalletUnseen", true);
        this.y = new a(sharedPreferences, "isJKOEnabled", false);
        this.z = new a(sharedPreferences, "isSimulateSlowStorageEnabled", false);
        this.A = new ad<>(sharedPreferences, "buyerFeatures", "[]", new com.google.a.c.a<List<MeFeature>>() {
        });
        this.B = new ad<>(sharedPreferences, "sellerFeatures", "[]", new com.google.a.c.a<List<MeFeature>>() {
        });
        this.C = new a(sharedPreferences, "isForcedMeCache", false);
    }

    public UserInfo a() {
        return this.f6945c.a();
    }

    public void a(UserInfo userInfo) {
        this.f6945c.a(userInfo);
    }

    public ShopBalance b() {
        return this.f6946d.a();
    }

    public void a(ShopBalance shopBalance) {
        this.f6946d.a(shopBalance);
    }

    public boolean c() {
        return this.f6947e.a() == 0;
    }

    public boolean d() {
        return this.f6947e.a() == 1;
    }

    public boolean e() {
        return this.f6947e.a() == 2;
    }

    public boolean f() {
        return this.f6947e.a() == 3;
    }

    public int g() {
        return this.f6947e.a();
    }

    public boolean h() {
        return this.f6949g.a();
    }

    public void i() {
        this.f6949g.a(true);
    }

    public String j() {
        return this.i.a();
    }

    public String k() {
        return this.j.a();
    }

    public boolean l() {
        return this.f6944b.a() == 1;
    }

    public boolean m() {
        return this.f6944b.a() == 0;
    }

    public int n() {
        return this.k.a();
    }

    public void a(int i2) {
        this.k.a(i2);
    }

    public boolean o() {
        return this.n.a();
    }

    public void a(boolean z2) {
        this.n.a(z2);
    }

    public boolean p() {
        return this.o.a();
    }

    public void b(boolean z2) {
        this.o.a(z2);
    }

    public boolean q() {
        return this.m.a();
    }

    public void c(boolean z2) {
        this.m.a(z2);
    }

    public boolean r() {
        return this.p.a();
    }

    public void d(boolean z2) {
        this.p.a(z2);
    }

    public void s() {
        this.q.a(false);
    }

    public boolean t() {
        return this.r.a();
    }

    public void u() {
        this.r.a(false);
    }

    public boolean v() {
        return this.s.a();
    }

    public void w() {
        this.s.a(false);
    }

    public boolean x() {
        return this.u.a();
    }

    public void e(boolean z2) {
        this.u.a(z2);
    }

    public com.shopee.app.data.a y() {
        return this.v.a();
    }

    public void a(com.shopee.app.data.a aVar) {
        if (aVar == null) {
            this.v.b();
        } else {
            this.v.a(aVar);
        }
    }

    public String z() {
        return this.w.a();
    }

    public String A() {
        return this.x.a();
    }

    public void a(String str) {
        this.x.a(str);
    }

    public Boolean B() {
        return Boolean.valueOf(this.y.a());
    }

    public void f(boolean z2) {
        this.y.a(z2);
    }

    public List<MeFeature> C() {
        return this.A.a();
    }

    public void a(List<MeFeature> list) {
        this.A.a(list);
    }

    public List<MeFeature> D() {
        return this.B.a();
    }

    public void b(List<MeFeature> list) {
        this.B.a(list);
    }

    public Boolean E() {
        return Boolean.valueOf(this.C.a());
    }

    public void g(boolean z2) {
        this.C.a(z2);
    }
}
