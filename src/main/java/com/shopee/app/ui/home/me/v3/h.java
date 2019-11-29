package com.shopee.app.ui.home.me.v3;

import android.text.TextUtils;
import android.util.Pair;
import com.facebook.react.uimanager.ViewProps;
import com.garena.android.appkit.b.i;
import com.shopee.app.a;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.aw;
import com.shopee.app.d.c.bc;
import com.shopee.app.d.c.bk;
import com.shopee.app.d.c.bt;
import com.shopee.app.d.c.cw;
import com.shopee.app.data.store.be;
import com.shopee.app.data.viewmodel.MeTabNoticeItem;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.order.SellerOrderCountItem;
import com.shopee.app.h.c.d;
import com.shopee.app.h.o;
import com.shopee.app.network.d.ao;
import com.shopee.app.network.d.az;
import com.shopee.app.network.d.bf;
import com.shopee.app.network.g;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.auth.IsAuthProxyActivity_;
import com.shopee.app.ui.common.ProductProgressView_;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.id.R;
import com.shopee.protocol.shop.Wallet;
import com.shopee.shopeetracker.EventRepository;
import d.d.b.j;
import d.d.b.k;
import d.d.b.m;
import d.d.b.n;
import d.d.b.p;
import d.f;
import d.f.e;

public final class h extends q<j> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ e[] f22644a = {p.a((m) new n(p.a(h.class), "view", "getView()Lcom/shopee/app/ui/home/me/v3/MyShopView;"))};

    /* renamed from: c  reason: collision with root package name */
    private final i f22645c;

    /* renamed from: d  reason: collision with root package name */
    private final d.e f22646d = f.a(new b(this));

    /* renamed from: e  reason: collision with root package name */
    private io.b.b.b f22647e;

    /* renamed from: f  reason: collision with root package name */
    private UserInfo f22648f;

    /* renamed from: g  reason: collision with root package name */
    private final be f22649g;
    private final cw h;
    private final bt i;
    private final bk j;
    private final aw k;
    private final bc l;

    /* access modifiers changed from: private */
    public final j l() {
        d.e eVar = this.f22646d;
        e eVar2 = f22644a[0];
        return (j) eVar.a();
    }

    public static final /* synthetic */ j b(h hVar) {
        return (j) hVar.f19220b;
    }

    public h(UserInfo userInfo, be beVar, cw cwVar, bt btVar, bk bkVar, aw awVar, bc bcVar) {
        j.b(userInfo, "user");
        j.b(beVar, "uiSettingStore");
        j.b(cwVar, "prepareMeTabNotificationItem");
        j.b(btVar, "getShopAndUserInfoInteractor");
        j.b(bkVar, "getSellerOrderCountInteractor");
        j.b(awVar, "getJkoWalletStatusInteractor");
        j.b(bcVar, "getMeFeaturesInteractor");
        this.f22648f = userInfo;
        this.f22649g = beVar;
        this.h = cwVar;
        this.i = btVar;
        this.j = bkVar;
        this.k = awVar;
        this.l = bcVar;
        i a2 = com.garena.a.a.a.b.a(this);
        j.a((Object) a2, "EventHandler.get(this)");
        this.f22645c = a2;
    }

    static final class b extends k implements d.d.a.a<j> {
        final /* synthetic */ h this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(h hVar) {
            super(0);
            this.this$0 = hVar;
        }

        /* renamed from: a */
        public final j invoke() {
            j b2 = h.b(this.this$0);
            if (b2 != null) {
                return b2;
            }
            throw new IllegalArgumentException("View must not be null");
        }
    }

    public void a() {
        this.f22645c.a();
        l().a(this.f22648f.isSeller());
        f();
    }

    public void b() {
        this.f22645c.b();
        io.b.b.b bVar = this.f22647e;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    public void c() {
        this.f22645c.c();
        ProductProgressView_ productProgressView_ = (ProductProgressView_) l().b(a.C0250a.productProgress);
        if (productProgressView_ != null) {
            productProgressView_.e();
        }
    }

    public void d() {
        this.f22645c.d();
        ProductProgressView_ productProgressView_ = (ProductProgressView_) l().b(a.C0250a.productProgress);
        if (productProgressView_ != null) {
            productProgressView_.f();
        }
    }

    public final void e() {
        m();
    }

    public final void f() {
        this.l.a(2);
        this.i.a(this.f22648f.getUserId(), this.f22648f.getShopId(), new g());
        this.j.a(1);
        n();
        o();
        m();
    }

    private final void m() {
        io.b.b.b bVar = this.f22647e;
        if (bVar == null || bVar.isDisposed()) {
            this.f22647e = this.k.a(new a(this));
        } else {
            this.k.a();
        }
    }

    static final class a<T> implements io.b.d.f<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f22650a;

        a(h hVar) {
            this.f22650a = hVar;
        }

        /* renamed from: a */
        public final void accept(Boolean bool) {
            j a2 = this.f22650a.l();
            j.a((Object) bool, ViewProps.ENABLED);
            a2.setJKOStatus(bool.booleanValue());
        }
    }

    public final void a(ShopDetail shopDetail) {
        j.b(shopDetail, "shop");
        if (this.f22648f.isMyShop(shopDetail.getShopId())) {
            l().a(shopDetail);
            b(shopDetail);
        }
    }

    public final void g() {
        n();
    }

    public final void a(Pair<Integer, Wallet> pair) {
        j.b(pair, "walletData");
        com.shopee.app.d.b.b.a((Integer) pair.first);
        l().a(pair.second != null ? com.shopee.app.d.b.b.a(((Wallet) pair.second).available) : -1);
    }

    public final void h() {
        f();
        l().g();
    }

    public final void a(SellerOrderCountItem sellerOrderCountItem) {
        j.b(sellerOrderCountItem, "sellerOrderCountItem");
        l().a(sellerOrderCountItem);
    }

    public final void a(d dVar) {
        j.b(dVar, EventRepository.TABLE);
        UserInfo a2 = dVar.a();
        if (a2 != null) {
            f();
            l().a(a2);
        }
    }

    public final void a(UserInfo userInfo) {
        j.b(userInfo, "user");
        this.f22648f = userInfo;
        l().a(userInfo);
    }

    public final void a(com.shopee.app.ui.auth.a.a aVar) {
        j.b(aVar, EventRepository.TABLE);
        a(aVar.a());
    }

    public final void a(MeTabNoticeItem meTabNoticeItem) {
        j.b(meTabNoticeItem, "notice");
        ((j) this.f19220b).setNoticeData(meTabNoticeItem);
    }

    public final void b(MeTabNoticeItem meTabNoticeItem) {
        j.b(meTabNoticeItem, "notice");
        int actionId = meTabNoticeItem.getActionId();
        if (actionId == 0) {
            IsAuthProxyActivity_.a(l().getContext()).b(0).a();
        } else if (actionId == 1) {
            this.f22649g.x();
            if (TextUtils.isEmpty(this.f22648f.getEmail())) {
                IsAuthProxyActivity_.a(l().getContext()).b(1).a();
                return;
            }
            l().e();
            bf bfVar = new bf();
            bfVar.a(l().hashCode());
            o.a().a((az) bfVar);
            bfVar.a(this.f22648f.getEmail(), 0);
        } else if (actionId == 2) {
            this.f22649g.A();
            l().h();
        } else if (actionId == 3) {
            this.f22649g.L();
            l().l();
        }
    }

    public final void c(MeTabNoticeItem meTabNoticeItem) {
        j.b(meTabNoticeItem, "notice");
        int actionId = meTabNoticeItem.getActionId();
        if (actionId == 0) {
            cw.f16743c = true;
        } else if (actionId == 1) {
            this.f22649g.x();
            l().a((int) R.string.sp_label_email_verification_popup_close_alert);
        } else if (actionId == 2) {
            this.f22649g.A();
            l().a((int) R.string.sp_label_phone_public_popup_close_alert);
        } else if (actionId == 3) {
            this.f22649g.L();
            l().a((int) R.string.sp_me_tab_complete_info_popup_close_alert);
        }
        p();
    }

    public final void i() {
        l().i();
    }

    public final void j() {
        int j2 = this.f22649g.j();
        if (j2 == 0) {
            j l2 = l();
            ShareMessage o = this.f22649g.o();
            j.a((Object) o, "uiSettingStore.shareMessage");
            l2.a(o);
        } else if (j2 == 1) {
            l().j();
        } else if (j2 == 2) {
            l().k();
        }
        f();
        if (!this.f22648f.isSeller()) {
            p();
        }
        this.f22649g.c(-1);
    }

    public final void a(String str) {
        j.b(str, "requestId");
        az f2 = o.a().f(str);
        if (f2 != null && ((bf) f2).b() == l().hashCode()) {
            this.f22649g.x();
            l().f();
            l().a(com.garena.android.appkit.tools.b.e(R.string.sp_email_hint_sent));
        }
        f();
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
        l().f();
        l().a(str);
    }

    public final void k() {
        l().a();
    }

    private final void n() {
        com.shopee.app.network.d.aw.d().g();
    }

    private final void o() {
        new com.shopee.app.network.d.h.h().a(true);
    }

    private final void p() {
        if (this.f22648f.isLoggedIn()) {
            new ao().a(this.f22648f.getShopId());
        }
    }

    private final void b(ShopDetail shopDetail) {
        this.h.a(shopDetail);
    }
}
