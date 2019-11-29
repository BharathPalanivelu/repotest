package com.shopee.app.ui.home.me.v3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.devspark.robototextview.widget.RobotoButton;
import com.shopee.app.a;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.RegionConfig;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.data.store.be;
import com.shopee.app.data.viewmodel.MeTabNoticeItem;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.order.SellerOrderCountItem;
import com.shopee.app.g.h;
import com.shopee.app.h.q;
import com.shopee.app.ui.a.r;
import com.shopee.app.ui.auth.IsAuthProxyActivity_;
import com.shopee.app.ui.common.i;
import com.shopee.app.ui.common.scrollview.BaseNestedScrollView;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.home.me.v3.feature.MeSellerFeatureContainerView_;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.id.R;
import d.m;
import java.util.HashMap;
import java.util.List;

public final class j extends SwipeRefreshLayout implements SwipeRefreshLayout.b, r {

    /* renamed from: a  reason: collision with root package name */
    public ak f22674a;

    /* renamed from: b  reason: collision with root package name */
    public h f22675b;

    /* renamed from: c  reason: collision with root package name */
    public SettingConfigStore f22676c;

    /* renamed from: d  reason: collision with root package name */
    public com.shopee.app.ui.common.r f22677d;

    /* renamed from: e  reason: collision with root package name */
    public ShareConfigStore f22678e;

    /* renamed from: f  reason: collision with root package name */
    public be f22679f;

    /* renamed from: g  reason: collision with root package name */
    public RegionConfig f22680g;
    public bc h;
    public com.shopee.app.tracking.trackingv3.b i;
    /* access modifiers changed from: private */
    public com.shopee.app.ui.home.me.tracking.seller.b j;
    private final h k;
    private final com.shopee.app.ui.a.d l;
    private HashMap m;

    public View b(int i2) {
        if (this.m == null) {
            this.m = new HashMap();
        }
        View view = (View) this.m.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.m.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void d() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(com.shopee.app.ui.a.d dVar, Context context, AttributeSet attributeSet, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : dVar, context, (i2 & 4) != 0 ? null : attributeSet);
    }

    public final com.shopee.app.ui.a.d getActionView() {
        return this.l;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(com.shopee.app.ui.a.d dVar, Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d.d.b.j.b(context, "context");
        this.l = dVar;
        SwipeRefreshLayout.inflate(context, R.layout.my_shop_view, this);
        if (!isInEditMode()) {
            Object b2 = ((x) context).b();
            if (b2 != null) {
                ((com.shopee.app.ui.home.e) b2).a(this);
            } else {
                throw new m("null cannot be cast to non-null type com.shopee.app.ui.home.HomeComponent");
            }
        }
        this.k = new h(getContext());
        setProgressViewOffset(true, 0, getResources().getDimensionPixelOffset(R.dimen.action_bar_height));
        setOnRefreshListener(this);
        o();
        n();
        bc bcVar = this.h;
        if (bcVar == null) {
            d.d.b.j.b("scope");
        }
        h hVar = this.f22675b;
        if (hVar == null) {
            d.d.b.j.b("presenter");
        }
        bcVar.a(hVar);
        h hVar2 = this.f22675b;
        if (hVar2 == null) {
            d.d.b.j.b("presenter");
        }
        hVar2.a(this);
    }

    public final ak getNavigator() {
        ak akVar = this.f22674a;
        if (akVar == null) {
            d.d.b.j.b("navigator");
        }
        return akVar;
    }

    public final void setNavigator(ak akVar) {
        d.d.b.j.b(akVar, "<set-?>");
        this.f22674a = akVar;
    }

    public final h getPresenter() {
        h hVar = this.f22675b;
        if (hVar == null) {
            d.d.b.j.b("presenter");
        }
        return hVar;
    }

    public final void setPresenter(h hVar) {
        d.d.b.j.b(hVar, "<set-?>");
        this.f22675b = hVar;
    }

    public final SettingConfigStore getConfigStore() {
        SettingConfigStore settingConfigStore = this.f22676c;
        if (settingConfigStore == null) {
            d.d.b.j.b("configStore");
        }
        return settingConfigStore;
    }

    public final void setConfigStore(SettingConfigStore settingConfigStore) {
        d.d.b.j.b(settingConfigStore, "<set-?>");
        this.f22676c = settingConfigStore;
    }

    public final com.shopee.app.ui.common.r getProgress() {
        com.shopee.app.ui.common.r rVar = this.f22677d;
        if (rVar == null) {
            d.d.b.j.b("progress");
        }
        return rVar;
    }

    public final void setProgress(com.shopee.app.ui.common.r rVar) {
        d.d.b.j.b(rVar, "<set-?>");
        this.f22677d = rVar;
    }

    public final ShareConfigStore getShareConfigStore() {
        ShareConfigStore shareConfigStore = this.f22678e;
        if (shareConfigStore == null) {
            d.d.b.j.b("shareConfigStore");
        }
        return shareConfigStore;
    }

    public final void setShareConfigStore(ShareConfigStore shareConfigStore) {
        d.d.b.j.b(shareConfigStore, "<set-?>");
        this.f22678e = shareConfigStore;
    }

    public final be getUiSettingStore() {
        be beVar = this.f22679f;
        if (beVar == null) {
            d.d.b.j.b("uiSettingStore");
        }
        return beVar;
    }

    public final void setUiSettingStore(be beVar) {
        d.d.b.j.b(beVar, "<set-?>");
        this.f22679f = beVar;
    }

    public final RegionConfig getRegionConfig() {
        RegionConfig regionConfig = this.f22680g;
        if (regionConfig == null) {
            d.d.b.j.b("regionConfig");
        }
        return regionConfig;
    }

    public final void setRegionConfig(RegionConfig regionConfig) {
        d.d.b.j.b(regionConfig, "<set-?>");
        this.f22680g = regionConfig;
    }

    public final bc getScope() {
        bc bcVar = this.h;
        if (bcVar == null) {
            d.d.b.j.b("scope");
        }
        return bcVar;
    }

    public final void setScope(bc bcVar) {
        d.d.b.j.b(bcVar, "<set-?>");
        this.h = bcVar;
    }

    public final com.shopee.app.tracking.trackingv3.b getBiTrackerV3() {
        com.shopee.app.tracking.trackingv3.b bVar = this.i;
        if (bVar == null) {
            d.d.b.j.b("biTrackerV3");
        }
        return bVar;
    }

    public final void setBiTrackerV3(com.shopee.app.tracking.trackingv3.b bVar) {
        d.d.b.j.b(bVar, "<set-?>");
        this.i = bVar;
    }

    public void b() {
        com.shopee.app.ui.home.me.tracking.seller.b bVar = this.j;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void c() {
        com.shopee.app.ui.home.me.tracking.seller.b bVar = this.j;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void onRefresh() {
        h hVar = this.f22675b;
        if (hVar == null) {
            d.d.b.j.b("presenter");
        }
        hVar.f();
        setRefreshing(true);
    }

    public final void a() {
        ((MeSellerFeatureContainerView_) b(a.C0250a.meSellerView)).b();
    }

    public final void a(ShopDetail shopDetail) {
        d.d.b.j.b(shopDetail, "shop");
        setRefreshing(false);
        a(shopDetail.isSeller());
        ((MeCoverView3_) b(a.C0250a.meCoverView)).setShopDetail(shopDetail);
        ((MeSellerFeatureContainerView_) b(a.C0250a.meSellerView)).setShopDetail(shopDetail);
    }

    public final void a(long j2) {
        ((MeSellerFeatureContainerView_) b(a.C0250a.meSellerView)).a(j2);
    }

    public final void e() {
        com.shopee.app.ui.common.r rVar = this.f22677d;
        if (rVar == null) {
            d.d.b.j.b("progress");
        }
        rVar.a();
    }

    public final void f() {
        com.shopee.app.ui.common.r rVar = this.f22677d;
        if (rVar == null) {
            d.d.b.j.b("progress");
        }
        rVar.b();
    }

    public final void a(String str) {
        q.b(this, str);
    }

    public final void a(SellerOrderCountItem sellerOrderCountItem) {
        d.d.b.j.b(sellerOrderCountItem, "sellerOrderCountItem");
        ((MeSellerFeatureContainerView_) b(a.C0250a.meSellerView)).a(sellerOrderCountItem);
    }

    public final void g() {
        ((MeSellerFeatureContainerView_) b(a.C0250a.meSellerView)).d();
    }

    public final void a(UserInfo userInfo) {
        d.d.b.j.b(userInfo, "userInfo");
        a(userInfo.isSeller());
        ((MeSellerFeatureContainerView_) b(a.C0250a.meSellerView)).a(userInfo);
    }

    public final void a(int i2) {
        com.shopee.app.ui.dialog.a.a(getContext(), 0, i2, 0, (int) R.string.sp_label_ok);
    }

    public final void h() {
        SettingConfigStore settingConfigStore = this.f22676c;
        if (settingConfigStore == null) {
            d.d.b.j.b("configStore");
        }
        if (settingConfigStore.shopSettingRN()) {
            ak akVar = this.f22674a;
            if (akVar == null) {
                d.d.b.j.b("navigator");
            }
            akVar.I();
            return;
        }
        ak akVar2 = this.f22674a;
        if (akVar2 == null) {
            d.d.b.j.b("navigator");
        }
        akVar2.H();
    }

    public final void setNoticeData(MeTabNoticeItem meTabNoticeItem) {
        d.d.b.j.b(meTabNoticeItem, "data");
        ((MeSellerFeatureContainerView_) b(a.C0250a.meSellerView)).setNoticeData(meTabNoticeItem);
    }

    public final void i() {
        ((MeSellerFeatureContainerView_) b(a.C0250a.meSellerView)).e();
        h hVar = this.f22675b;
        if (hVar == null) {
            d.d.b.j.b("presenter");
        }
        hVar.e();
    }

    public final void a(ShareMessage shareMessage) {
        d.d.b.j.b(shareMessage, "shareMessage");
        String e2 = com.garena.android.appkit.tools.b.e(R.string.sp_share_my_product_title);
        String e3 = com.garena.android.appkit.tools.b.e(R.string.sp_share_my_product_subtitle);
        h hVar = this.k;
        ShareConfigStore shareConfigStore = this.f22678e;
        if (shareConfigStore == null) {
            d.d.b.j.b("shareConfigStore");
        }
        List<String> shareOptions = shareConfigStore.getShareOptions();
        ShareConfigStore shareConfigStore2 = this.f22678e;
        if (shareConfigStore2 == null) {
            d.d.b.j.b("shareConfigStore");
        }
        hVar.a(shareMessage, shareOptions, shareConfigStore2, shareMessage.getShopID() == ((MeSellerFeatureContainerView_) b(a.C0250a.meSellerView)).getMetaData().j().getShopId(), e2, e3);
    }

    public static final class b implements a.C0318a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f22682a;

        b(j jVar) {
            this.f22682a = jVar;
        }

        public void onPositive() {
            this.f22682a.getUiSettingStore().c(0);
            this.f22682a.getNavigator().L();
        }

        public void onNegative() {
            this.f22682a.m();
        }
    }

    public final void j() {
        RegionConfig regionConfig = this.f22680g;
        if (regionConfig == null) {
            d.d.b.j.b("regionConfig");
        }
        if (regionConfig.isFullBuild()) {
            com.shopee.app.ui.dialog.a.a(getContext(), R.string.sp_enter_bank_account, R.string.sp_enter_bank_account_reminder, R.drawable.com_garena_shopee_ic_bank_account, R.string.sp_label_later, R.string.sp_enter, new b(this), new c(this));
        } else {
            m();
        }
    }

    static final class c implements a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f22683a;

        c(j jVar) {
            this.f22683a = jVar;
        }

        public final void a() {
            this.f22683a.m();
        }
    }

    public static final class d implements a.C0318a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f22684a;

        d(j jVar) {
            this.f22684a = jVar;
        }

        public void onPositive() {
            this.f22684a.getUiSettingStore().c(-1);
            IsAuthProxyActivity_.a(this.f22684a.getContext()).b(0).a();
        }

        public void onNegative() {
            this.f22684a.getUiSettingStore().c(-1);
        }
    }

    public final void k() {
        com.shopee.app.ui.dialog.a.a(getContext(), R.string.sp_pending_phone_verification, R.string.sp_pending_phone_verification_reminder, R.drawable.com_garena_shopee_ic_dialog_crying, R.string.sp_label_later, R.string.sp_verify_capital, new d(this), new e(this));
    }

    static final class e implements a.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f22685a;

        e(j jVar) {
            this.f22685a = jVar;
        }

        public final void a() {
            this.f22685a.getUiSettingStore().c(-1);
        }
    }

    /* access modifiers changed from: private */
    public final void m() {
        be beVar = this.f22679f;
        if (beVar == null) {
            d.d.b.j.b("uiSettingStore");
        }
        ShareMessage o = beVar.o();
        d.d.b.j.a((Object) o, "uiSettingStore.shareMessage");
        a(o);
        be beVar2 = this.f22679f;
        if (beVar2 == null) {
            d.d.b.j.b("uiSettingStore");
        }
        beVar2.c(-1);
    }

    public final void a(boolean z) {
        if (z) {
            MeSellerFeatureContainerView_ meSellerFeatureContainerView_ = (MeSellerFeatureContainerView_) b(a.C0250a.meSellerView);
            d.d.b.j.a((Object) meSellerFeatureContainerView_, "meSellerView");
            com.shopee.app.e.b.b(meSellerFeatureContainerView_);
            ConstraintLayout constraintLayout = (ConstraintLayout) b(a.C0250a.shopEmptyView);
            d.d.b.j.a((Object) constraintLayout, "shopEmptyView");
            com.shopee.app.e.b.a(constraintLayout);
            ((RobotoButton) b(a.C0250a.btnAddNewProductEmpty)).setOnClickListener((View.OnClickListener) null);
            return;
        }
        ((RobotoButton) b(a.C0250a.btnAddNewProductEmpty)).setOnClickListener(new f(this));
        ConstraintLayout constraintLayout2 = (ConstraintLayout) b(a.C0250a.shopEmptyView);
        d.d.b.j.a((Object) constraintLayout2, "shopEmptyView");
        com.shopee.app.e.b.b(constraintLayout2);
        MeSellerFeatureContainerView_ meSellerFeatureContainerView_2 = (MeSellerFeatureContainerView_) b(a.C0250a.meSellerView);
        d.d.b.j.a((Object) meSellerFeatureContainerView_2, "meSellerView");
        com.shopee.app.e.b.a(meSellerFeatureContainerView_2);
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f22686a;

        f(j jVar) {
            this.f22686a = jVar;
        }

        public final void onClick(View view) {
            ((MeSellerFeatureContainerView_) this.f22686a.b(a.C0250a.meSellerView)).c();
            com.shopee.app.ui.home.me.tracking.seller.b b2 = this.f22686a.j;
            if (b2 != null) {
                d.d.b.j.a((Object) view, "it");
                b2.a(view);
            }
        }
    }

    public final void l() {
        ak akVar = this.f22674a;
        if (akVar == null) {
            d.d.b.j.b("navigator");
        }
        akVar.t();
    }

    private final void n() {
        com.shopee.app.tracking.trackingv3.b bVar = this.i;
        if (bVar == null) {
            d.d.b.j.b("biTrackerV3");
        }
        this.j = new com.shopee.app.ui.home.me.tracking.seller.b(bVar);
        ((MeSellerFeatureContainerView_) b(a.C0250a.meSellerView)).setTrackSession(this.j);
        ((MeCoverView3_) b(a.C0250a.meCoverView)).setCoverTrackSession(this.j);
    }

    public static final class a implements com.shopee.app.ui.common.scrollview.a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f22681a;

        a(j jVar) {
            this.f22681a = jVar;
        }

        public void a(int i, int i2, int i3, int i4) {
            com.shopee.app.ui.a.d actionView = this.f22681a.getActionView();
            if (actionView != null) {
                i shadowContainer = actionView.getShadowContainer();
                if (shadowContainer != null) {
                    shadowContainer.a(i2 > 0, false);
                }
            }
        }
    }

    private final void o() {
        ((BaseNestedScrollView) b(a.C0250a.scrollView)).a((com.shopee.app.ui.common.scrollview.a.b) new a(this));
    }

    public final void setJKOStatus(boolean z) {
        ((MeSellerFeatureContainerView_) b(a.C0250a.meSellerView)).setJKOStatus(z);
    }
}
