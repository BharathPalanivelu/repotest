package com.shopee.app.ui.home.me.v3.feature;

import android.content.Context;
import android.widget.LinearLayout;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.al;
import com.shopee.app.data.viewmodel.CoinInfo;
import com.shopee.app.data.viewmodel.MeTabNoticeItem;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.order.BuyerOrderCountItem;
import com.shopee.app.network.http.data.kredit.CreditData;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.ui.home.e;
import com.shopee.app.ui.home.me.tracking.d;
import com.shopee.app.ui.home.me.v3.NotificationRow;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;
import d.d.b.j;
import d.m;
import java.util.List;

public class b extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public NotificationRow f22582a;

    /* renamed from: b  reason: collision with root package name */
    public MeFeatureRecyclerView f22583b;

    /* renamed from: c  reason: collision with root package name */
    public ak f22584c;

    /* renamed from: d  reason: collision with root package name */
    public UserInfo f22585d;

    /* renamed from: e  reason: collision with root package name */
    public al f22586e;

    /* renamed from: f  reason: collision with root package name */
    public com.shopee.app.tracking.trackingv3.b f22587f;

    /* renamed from: g  reason: collision with root package name */
    private d f22588g;
    private final a h;

    public void c() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        j.b(context, "context");
        Object b2 = ((x) context).b();
        if (b2 != null) {
            ((e) b2).a(this);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            setOrientation(1);
            this.h = new a(context);
            return;
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.ui.home.HomeComponent");
    }

    public NotificationRow getNotificationView() {
        NotificationRow notificationRow = this.f22582a;
        if (notificationRow == null) {
            j.b("notificationView");
        }
        return notificationRow;
    }

    public void setNotificationView(NotificationRow notificationRow) {
        j.b(notificationRow, "<set-?>");
        this.f22582a = notificationRow;
    }

    public MeFeatureRecyclerView getFeatureRecyclerView() {
        MeFeatureRecyclerView meFeatureRecyclerView = this.f22583b;
        if (meFeatureRecyclerView == null) {
            j.b("featureRecyclerView");
        }
        return meFeatureRecyclerView;
    }

    public void setFeatureRecyclerView(MeFeatureRecyclerView meFeatureRecyclerView) {
        j.b(meFeatureRecyclerView, "<set-?>");
        this.f22583b = meFeatureRecyclerView;
    }

    public ak getNavigator() {
        ak akVar = this.f22584c;
        if (akVar == null) {
            j.b("navigator");
        }
        return akVar;
    }

    public void setNavigator(ak akVar) {
        j.b(akVar, "<set-?>");
        this.f22584c = akVar;
    }

    public UserInfo getUser() {
        UserInfo userInfo = this.f22585d;
        if (userInfo == null) {
            j.b("user");
        }
        return userInfo;
    }

    public void setUser(UserInfo userInfo) {
        j.b(userInfo, "<set-?>");
        this.f22585d = userInfo;
    }

    public al getLoginStore() {
        al alVar = this.f22586e;
        if (alVar == null) {
            j.b("loginStore");
        }
        return alVar;
    }

    public void setLoginStore(al alVar) {
        j.b(alVar, "<set-?>");
        this.f22586e = alVar;
    }

    public com.shopee.app.tracking.trackingv3.b getBiTrackerV3() {
        com.shopee.app.tracking.trackingv3.b bVar = this.f22587f;
        if (bVar == null) {
            j.b("biTrackerV3");
        }
        return bVar;
    }

    public void setBiTrackerV3(com.shopee.app.tracking.trackingv3.b bVar) {
        j.b(bVar, "<set-?>");
        this.f22587f = bVar;
    }

    public d getTrackSession() {
        return this.f22588g;
    }

    public void setTrackSession(d dVar) {
        this.f22588g = dVar;
        this.h.a(dVar);
    }

    public void a() {
        d();
    }

    public void b() {
        getFeatureRecyclerView().y();
        d trackSession = getTrackSession();
        if (trackSession != null) {
            trackSession.a(getFeatureRecyclerView());
        }
    }

    public void setUserInfo(UserInfo userInfo) {
        j.b(userInfo, "user");
        this.h.a(userInfo);
        b();
    }

    public void a(long j, CoinInfo coinInfo) {
        j.b(coinInfo, "multiplier");
        if (j == 0) {
            this.h.a((String) null);
        } else {
            this.h.a(coinInfo.value(j));
        }
        b();
    }

    public void setShopDetail(ShopDetail shopDetail) {
        j.b(shopDetail, "shop");
        this.h.a(shopDetail);
        b();
    }

    public static /* synthetic */ void a(b bVar, long j, long j2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = bVar.h.c();
            }
            if ((i & 2) != 0) {
                j2 = bVar.h.d();
            }
            bVar.a(j, j2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setWalletBalance");
    }

    public void a(long j, long j2) {
        this.h.a(j);
        this.h.b(j2);
        b();
    }

    public void setNoticeData(MeTabNoticeItem meTabNoticeItem) {
        j.b(meTabNoticeItem, "data");
        int actionId = meTabNoticeItem.getActionId();
        if (actionId == 1 || actionId == 3) {
            getNotificationView().a(getUser().isHolidayMode(), meTabNoticeItem);
        } else {
            com.shopee.app.e.b.a(getNotificationView());
        }
    }

    public void a(CreditData creditData) {
        j.b(creditData, AbTestingModule.KEY_RESULT);
        this.h.a(creditData);
        b();
    }

    public void a(String str) {
        j.b(str, "displayValue");
        if (str.length() == 0) {
            this.h.a((CreditData) null);
        }
        b();
    }

    public void setBuyerOrderCount(BuyerOrderCountItem buyerOrderCountItem) {
        j.b(buyerOrderCountItem, "buyerOrderCountItem");
        this.h.a(buyerOrderCountItem);
        b();
    }

    public void a(int i, int i2) {
        this.h.a(i);
        this.h.b(i2);
        b();
    }

    public void d() {
        List<MeFeature> C = getLoginStore().C();
        j.a((Object) C, "loginStore.buyerFeatures");
        getFeatureRecyclerView().a(this.h, C);
    }

    public static final class a extends i {
        private ShopDetail j;
        private int k;
        private int l;
        private long m;
        private long n;
        private String o;
        private String p = "";
        private BuyerOrderCountItem q;
        private CreditData r;

        public a(Context context) {
            j.b(context, "context");
            Object b2 = ((x) context).b();
            if (b2 != null) {
                ((e) b2).a(this);
                return;
            }
            throw new m("null cannot be cast to non-null type com.shopee.app.ui.home.HomeComponent");
        }

        public final ShopDetail a() {
            return this.j;
        }

        public final void a(ShopDetail shopDetail) {
            this.j = shopDetail;
        }

        public final void a(int i) {
            this.k = i;
        }

        public final int b() {
            return this.l;
        }

        public final void b(int i) {
            this.l = i;
        }

        public final void a(long j2) {
            this.m = j2;
        }

        public final long c() {
            return this.m;
        }

        public final void b(long j2) {
            this.n = j2;
        }

        public final long d() {
            return this.n;
        }

        public final void a(String str) {
            this.o = str;
        }

        public final String e() {
            return this.o;
        }

        public final void a(BuyerOrderCountItem buyerOrderCountItem) {
            this.q = buyerOrderCountItem;
        }

        public final BuyerOrderCountItem f() {
            return this.q;
        }

        public final void a(CreditData creditData) {
            this.r = creditData;
        }

        public final CreditData g() {
            return this.r;
        }
    }
}
