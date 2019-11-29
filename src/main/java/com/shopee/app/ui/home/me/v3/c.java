package com.shopee.app.ui.home.me.v3;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.bc;
import com.shopee.app.d.c.bk;
import com.shopee.app.d.c.bt;
import com.shopee.app.d.c.cw;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.theme.ActionBarTheme;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.data.viewmodel.MeTabNoticeItem;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.order.BuyerOrderCountItem;
import com.shopee.app.h.c.d;
import com.shopee.app.h.o;
import com.shopee.app.network.d.ao;
import com.shopee.app.network.d.aw;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.bf;
import com.shopee.app.network.d.h.h;
import com.shopee.app.network.d.w;
import com.shopee.app.network.g;
import com.shopee.app.network.http.data.kredit.CreditData;
import com.shopee.app.network.http.data.kredit.CreditStatusResponse;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.auth.IsAuthProxyActivity_;
import com.shopee.app.util.s;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.id.R;
import com.shopee.protocol.shop.Wallet;
import com.shopee.shopeetracker.EventRepository;
import d.d.b.j;
import io.b.d.f;

public final class c extends q<MeTabView3> {

    /* renamed from: a  reason: collision with root package name */
    private final i f22497a;

    /* renamed from: c  reason: collision with root package name */
    private io.b.b.b f22498c;

    /* renamed from: d  reason: collision with root package name */
    private final MeCounter f22499d;

    /* renamed from: e  reason: collision with root package name */
    private final cw f22500e;

    /* renamed from: f  reason: collision with root package name */
    private final be f22501f;

    /* renamed from: g  reason: collision with root package name */
    private UserInfo f22502g;
    private final com.shopee.app.network.http.a.b h;
    private final bt i;
    private final bk j;
    private final bk k;
    private final bk l;
    private final bc m;
    private final s n;

    public c(MeCounter meCounter, cw cwVar, be beVar, UserInfo userInfo, com.shopee.app.network.http.a.b bVar, bt btVar, bk bkVar, bk bkVar2, bk bkVar3, bc bcVar, s sVar) {
        j.b(meCounter, "meCounter");
        j.b(cwVar, "prepareMeTabNotificationItem");
        j.b(beVar, "uiSettingStore");
        j.b(userInfo, "user");
        j.b(bVar, "creditAPI");
        j.b(btVar, "getShopAndUserInfoInteractor");
        j.b(bkVar, "getBuyerOrderCountInteractor");
        j.b(bkVar2, "getSellerOrderCountInteractor");
        j.b(bkVar3, "getGroupBuyOrderCountInteractor");
        j.b(bcVar, "getMeFeaturesInteractor");
        j.b(sVar, "featureToggleManager");
        this.f22499d = meCounter;
        this.f22500e = cwVar;
        this.f22501f = beVar;
        this.f22502g = userInfo;
        this.h = bVar;
        this.i = btVar;
        this.j = bkVar;
        this.k = bkVar2;
        this.l = bkVar3;
        this.m = bcVar;
        this.n = sVar;
        i a2 = com.garena.a.a.a.b.a(this);
        j.a((Object) a2, "EventHandler.get(this)");
        this.f22497a = a2;
    }

    /* access modifiers changed from: private */
    public final MeTabView3 o() {
        MeTabView3 meTabView3 = (MeTabView3) this.f19220b;
        if (meTabView3 != null) {
            return meTabView3;
        }
        throw new RuntimeException("MeTabView3 is null");
    }

    public final void e() {
        p();
        if (this.f22502g.isLoggedIn()) {
            o().a(this.f22499d);
            r();
            s();
            t();
            new w().g();
            q();
            if (this.n.a("shopee_kredit")) {
                f();
            }
        }
    }

    private final void p() {
        this.m.a(3);
    }

    private final void q() {
        aw.c().g();
        aw.d().g();
    }

    private final void r() {
        this.i.a(this.f22502g.getUserId(), this.f22502g.getShopId(), new g());
    }

    private final void s() {
        if (this.f22502g.isLoggedIn()) {
            new ao().a(this.f22502g.getShopId());
        }
    }

    private final void t() {
        u();
        v();
        w();
    }

    private final void u() {
        new h().a(false);
    }

    private final void v() {
        new h().a(true);
    }

    private final void w() {
        new h().a(true, true);
    }

    public final void f() {
        io.b.b.b bVar = this.f22498c;
        if (bVar != null) {
            bVar.dispose();
        }
        this.f22498c = this.h.a().b(io.b.h.a.b()).a(io.b.a.b.a.a()).a(new a(this), (f<? super Throwable>) new b(this));
    }

    static final class a<T> implements f<CreditStatusResponse> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f22503a;

        a(c cVar) {
            this.f22503a = cVar;
        }

        /* renamed from: a */
        public final void accept(CreditStatusResponse creditStatusResponse) {
            j.a((Object) creditStatusResponse, "creditStatusResponse");
            if (!creditStatusResponse.isSuccess() || creditStatusResponse.data == null) {
                this.f22503a.o().a("");
                com.garena.android.appkit.d.a.e("fetchKreditInfo:" + creditStatusResponse.detailErrorCode, new Object[0]);
                return;
            }
            MeTabView3 a2 = this.f22503a.o();
            CreditData creditData = creditStatusResponse.data;
            j.a((Object) creditData, "creditStatusResponse.data");
            a2.a(creditData);
        }
    }

    static final class b<T> implements f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f22504a;

        b(c cVar) {
            this.f22504a = cVar;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f22504a.o().a("");
            com.garena.android.appkit.d.a.a(th);
            this.f22504a.o().e();
        }
    }

    public void a() {
        this.f22497a.a();
        if (this.f22502g.isLoggedIn()) {
            this.j.a(0);
            this.k.a(1);
            this.l.e();
        }
    }

    public void b() {
        this.f22497a.b();
        io.b.b.b bVar = this.f22498c;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    public void c() {
        this.f22497a.c();
    }

    public void d() {
        this.f22497a.d();
    }

    public final void g() {
        q();
    }

    public final void h() {
        e();
    }

    public final void a(UserInfo userInfo) {
        j.b(userInfo, "user");
        this.f22502g = userInfo;
        o().a(userInfo);
    }

    public final void a(com.shopee.app.ui.auth.a.a aVar) {
        j.b(aVar, EventRepository.TABLE);
        a(aVar.a());
    }

    public final void a(ShopDetail shopDetail) {
        j.b(shopDetail, "shop");
        if (this.f22502g.isMyShop(shopDetail.getShopId())) {
            o().a(shopDetail);
            this.f22500e.a(shopDetail);
        }
    }

    public final void a(d dVar) {
        j.b(dVar, EventRepository.TABLE);
        e();
        MeTabView3 o = o();
        UserInfo a2 = dVar.a();
        j.a((Object) a2, "event.userInfo");
        o.a(a2);
    }

    public final void a(MeTabNoticeItem meTabNoticeItem) {
        j.b(meTabNoticeItem, "notice");
        int actionId = meTabNoticeItem.getActionId();
        if (actionId == 1) {
            this.f22501f.x();
            if (TextUtils.isEmpty(this.f22502g.getEmail())) {
                IsAuthProxyActivity_.a(o().getContext()).b(1).a();
                return;
            }
            o().f();
            bf bfVar = new bf();
            bfVar.a(o().hashCode());
            o.a().a((az) bfVar);
            bfVar.a(this.f22502g.getEmail(), 0);
        } else if (actionId == 3) {
            this.f22501f.L();
            o().i();
        }
    }

    public final void b(MeTabNoticeItem meTabNoticeItem) {
        j.b(meTabNoticeItem, "notice");
        int actionId = meTabNoticeItem.getActionId();
        if (actionId == 1) {
            this.f22501f.x();
            o().a((int) R.string.sp_label_email_verification_popup_close_alert);
        } else if (actionId == 3) {
            this.f22501f.L();
            o().a((int) R.string.sp_me_tab_complete_info_popup_close_alert);
        }
        s();
    }

    public final void i() {
        o().a(this.f22499d.getCoinCount());
    }

    public final void j() {
        o().a(0);
    }

    public final void a(Pair<Integer, Wallet> pair) {
        j.b(pair, "walletData");
        int a2 = com.shopee.app.d.b.b.a((Integer) pair.first);
        long a3 = pair.second != null ? com.shopee.app.d.b.b.a(((Wallet) pair.second).available) : -1;
        if (a2 == 1) {
            o().b(a3);
        } else if (a2 == 2) {
            o().c(a3);
        }
    }

    public final void c(MeTabNoticeItem meTabNoticeItem) {
        j.b(meTabNoticeItem, "data");
        o().setMeTabNoticeData(meTabNoticeItem);
    }

    public final void a(String str) {
        j.b(str, "requestId");
        az f2 = o.a().f(str);
        if (f2 != null && ((bf) f2).b() == o().hashCode()) {
            this.f22501f.x();
            o().e();
            o().b(com.garena.android.appkit.tools.b.e(R.string.sp_email_hint_sent));
        }
        s();
    }

    public final void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        j.b(aVar, "responseCommonData");
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
            j.a((Object) str, "responseCommonData.errorMsg");
        } else {
            int i2 = aVar.f17892a;
            if (i2 == -100 || i2 == 1) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
                j.a((Object) str, "BBAppResource.string(R.string.sp_network_error)");
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
                j.a((Object) str, "BBAppResource.string(R.string.sp_unknown_error)");
            }
        }
        o().e();
        o().b(str);
    }

    public final void a(int i2) {
        o().b(i2);
    }

    public final void a(MeCounter meCounter) {
        j.b(meCounter, "counter");
        o().a(meCounter);
    }

    public final void k() {
        o().f();
    }

    public final void l() {
        o().e();
    }

    public final void a(ShareMessage shareMessage) {
        j.b(shareMessage, "shareMessage");
        o().a(shareMessage);
    }

    public final void a(BuyerOrderCountItem buyerOrderCountItem) {
        j.b(buyerOrderCountItem, "buyerOrderCountItem");
        o().a(buyerOrderCountItem);
    }

    public final void b(Pair<Integer, Integer> pair) {
        j.b(pair, "counts");
        MeTabView3 o = o();
        Object obj = pair.first;
        j.a(obj, "counts.first");
        int intValue = ((Number) obj).intValue();
        Object obj2 = pair.second;
        j.a(obj2, "counts.second");
        o.a(intValue, ((Number) obj2).intValue());
    }

    public final void m() {
        o().g();
    }

    public final void n() {
        o().h();
    }

    public final void a(ActionBarTheme actionBarTheme) {
        j.b(actionBarTheme, "theme");
        o().a(actionBarTheme);
    }
}
