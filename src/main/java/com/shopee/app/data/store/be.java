package com.shopee.app.data.store;

import android.content.SharedPreferences;
import c.a.a.a.a;
import c.a.a.a.b;
import c.a.a.a.c;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.shopee.app.ui.product.add.t;
import com.shopee.app.util.ad;
import com.shopee.app.util.bf;
import com.shopee.app.web.protocol.ShareMessage;
import java.util.List;

public class be extends ay {
    private a A;
    private bf B;
    private b C;

    /* renamed from: a  reason: collision with root package name */
    private b f17254a;

    /* renamed from: b  reason: collision with root package name */
    private b f17255b;

    /* renamed from: c  reason: collision with root package name */
    private b f17256c;

    /* renamed from: d  reason: collision with root package name */
    private a f17257d;

    /* renamed from: e  reason: collision with root package name */
    private a f17258e;

    /* renamed from: f  reason: collision with root package name */
    private b f17259f;

    /* renamed from: g  reason: collision with root package name */
    private b f17260g;
    private a h;
    private b i;
    private ad<ShareMessage> j;
    private ad<t> k;
    private ad<List<String>> l;
    private c m;
    private b n;
    private b o;
    private c p;
    private a q;
    private a r;
    private a s;
    private a t;
    private a u;
    private a v;
    private b w;
    private a x;
    private a y;
    private b z;

    public be(SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f17254a = new b(sharedPreferences, "locationLastShownTime", 0);
        this.n = new b(sharedPreferences, "mIncomeStartTime", 0);
        this.o = new b(sharedPreferences, "mIncomeEndTime", 0);
        this.p = new c(sharedPreferences, "mIncomeSum", 0);
        this.f17255b = new b(sharedPreferences, "minVersionPopupTime", 0);
        this.f17256c = new b(sharedPreferences, "temporaryFilesLastCleanTime", 0);
        this.f17257d = new a(sharedPreferences, "bankAccount", false);
        this.f17258e = new a(sharedPreferences, "postToFeed", true);
        this.q = new a(sharedPreferences, "showDeleteDialog", true);
        this.r = new a(sharedPreferences, "showXiaomiGuide", true);
        this.f17259f = new b(sharedPreferences, "lastConnectionTime", 0);
        this.f17260g = new b(sharedPreferences, "lastShowVerifyEmailTime", 0);
        this.h = new a(sharedPreferences, "skipMakePhonePublic", false);
        this.i = new b(sharedPreferences, "postProductStatus", -1);
        this.j = new ad<>(sharedPreferences, "shareMessage", ServiceLogger.PLACEHOLDER, com.google.a.c.a.get(ShareMessage.class));
        this.k = new ad<>(sharedPreferences, "facebookPageInfo", ServiceLogger.PLACEHOLDER, com.google.a.c.a.get(t.class));
        this.s = new a(sharedPreferences, "needChatScamBanner", true);
        this.t = new a(sharedPreferences, "needMyAccountNoticeBanner", true);
        this.u = new a(sharedPreferences, "mNeedHideFromFriendPopup", true);
        this.l = new ad<>(sharedPreferences, "downloadedStickerPackList", "[]", new com.google.a.c.a<List<String>>() {
        });
        this.w = new b(sharedPreferences, "lastMeTag", 0);
        this.m = new c(sharedPreferences, "crashingBundleVersion", 0);
        this.x = new a(sharedPreferences, "imageSearchBoundBoxHintUpload", true);
        this.y = new a(sharedPreferences, "imageSearchBoundBoxHintEdit", true);
        this.z = new b(sharedPreferences, "secondTabSeenCount", 0);
        this.A = new a(sharedPreferences, "popupShownInFollowView", false);
        this.v = new a(sharedPreferences, "tracking64BitDevice", false);
        this.B = new bf(sharedPreferences, "meViewedFeature");
        this.C = new b(sharedPreferences, "lastShowSetUserInfoTime", 0);
    }

    public void a(int i2) {
        this.n.a(i2);
    }

    public void a(long j2) {
        this.p.a(j2);
    }

    public void b(int i2) {
        this.o.a(i2);
    }

    public long a() {
        return this.p.a();
    }

    public boolean b() {
        return this.q.a();
    }

    public void c() {
        this.q.a(false);
    }

    public boolean d() {
        return this.r.a();
    }

    public void e() {
        this.r.a(false);
    }

    public int f() {
        return this.n.a();
    }

    public int g() {
        return this.o.a();
    }

    public boolean h() {
        return this.f17258e.a();
    }

    public void a(boolean z2) {
        this.f17258e.a(z2);
    }

    public boolean i() {
        return this.f17257d.a();
    }

    public int j() {
        return this.i.a();
    }

    public void c(int i2) {
        this.i.a(i2);
    }

    public boolean k() {
        return this.s.a();
    }

    public void l() {
        this.s.a(false);
    }

    public boolean m() {
        return this.u.a();
    }

    public void n() {
        this.u.a(false);
    }

    public ShareMessage o() {
        return this.j.a();
    }

    public void a(ShareMessage shareMessage) {
        this.j.a(shareMessage);
    }

    public t p() {
        return this.k.a();
    }

    public void a(t tVar) {
        if (tVar == null) {
            this.k.b();
        } else {
            this.k.a(tVar);
        }
    }

    public void q() {
        this.f17254a.a(com.garena.android.appkit.tools.a.a.a());
    }

    public void r() {
        this.f17256c.a(com.garena.android.appkit.tools.a.a.a());
    }

    public boolean s() {
        return com.garena.android.appkit.tools.a.a.a() - this.f17254a.a() > 7200;
    }

    public boolean t() {
        return com.garena.android.appkit.tools.a.a.a() - this.f17256c.a() > 43200;
    }

    public int u() {
        return this.f17255b.a();
    }

    public void v() {
        this.f17255b.a(com.garena.android.appkit.tools.a.a.a());
    }

    public void d(int i2) {
        this.f17259f.a(i2);
    }

    public int w() {
        return this.f17259f.a();
    }

    public void x() {
        this.f17260g.a(com.garena.android.appkit.tools.a.a.a());
    }

    public boolean y() {
        return this.f17260g.a() != 0 && com.garena.android.appkit.tools.a.a.a() - this.f17260g.a() < 2592000;
    }

    public boolean z() {
        return this.h.a();
    }

    public void A() {
        this.h.a(true);
    }

    public List<String> B() {
        return this.l.a();
    }

    public void a(String str) {
        List a2 = this.l.a();
        a2.add(str);
        this.l.a(a2);
    }

    public int C() {
        return this.w.a();
    }

    public void b(long j2) {
        this.m.a(j2);
    }

    public boolean D() {
        return this.x.a();
    }

    public boolean E() {
        return this.y.a();
    }

    public void F() {
        this.x.a(false);
    }

    public void G() {
        this.y.a(false);
    }

    public int H() {
        return this.z.a();
    }

    public void e(int i2) {
        this.z.a(i2);
    }

    public boolean I() {
        return this.A.a();
    }

    public void b(boolean z2) {
        this.A.a(z2);
    }

    public boolean J() {
        return this.v.a();
    }

    public void K() {
        this.v.a(true);
    }

    public boolean b(String str) {
        return this.B.a().contains(str);
    }

    public void c(String str) {
        this.B.a(str);
    }

    public void L() {
        this.C.a(com.garena.android.appkit.tools.a.a.a());
    }

    public boolean M() {
        return this.C.a() != 0 && com.garena.android.appkit.tools.a.a.a() - this.C.a() < 2592000;
    }
}
