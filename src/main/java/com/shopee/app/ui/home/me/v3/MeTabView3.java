package com.shopee.app.ui.home.me.v3;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.google.android.material.tabs.TabLayout;
import com.shopee.app.a;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.theme.ActionBarTheme;
import com.shopee.app.data.viewmodel.CoinInfo;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.data.viewmodel.MeTabNoticeItem;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.order.BuyerOrderCountItem;
import com.shopee.app.h.q;
import com.shopee.app.network.http.data.kredit.CreditData;
import com.shopee.app.react.modules.app.data.k;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.tracking.trackingv3.model.ViewCommon;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.common.scrollview.BaseNestedScrollView;
import com.shopee.app.ui.home.e;
import com.shopee.app.ui.home.me.tracking.d;
import com.shopee.app.ui.home.me.v3.feature.c;
import com.shopee.app.ui.home.react.ReactTabView;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.id.R;
import d.d.b.j;
import d.m;
import java.util.HashMap;

public class MeTabView3 extends com.shopee.app.ui.a.a implements SwipeRefreshLayout.b, TabLayout.c {
    private static boolean C;
    public static final a r = new a((g) null);
    private final int A;
    private final b B;
    private HashMap D;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f22446a;

    /* renamed from: b  reason: collision with root package name */
    public SwipeRefreshLayout f22447b;

    /* renamed from: c  reason: collision with root package name */
    public a f22448c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f22449d;

    /* renamed from: e  reason: collision with root package name */
    public TabLayout f22450e;

    /* renamed from: f  reason: collision with root package name */
    public c f22451f;

    /* renamed from: g  reason: collision with root package name */
    public bc f22452g;
    public UserInfo h;
    public ak i;
    public bi j;
    public be k;
    public SettingConfigStore l;
    public r m;
    public com.shopee.app.ui.actionbar.a n;
    public Activity o;
    public com.shopee.app.tracking.trackingv3.b p;
    public k q;
    private com.shopee.app.ui.home.me.v3.feature.b s;
    private View t;
    private View u;
    private ReactTabView v;
    private final View[] w = new View[2];
    private String x = String.valueOf(System.currentTimeMillis());
    private boolean y;
    private d z;

    public static final boolean j() {
        a aVar = r;
        return C;
    }

    public static final void setDisplayed(boolean z2) {
        a aVar = r;
        C = z2;
    }

    public View c(int i2) {
        if (this.D == null) {
            this.D = new HashMap();
        }
        View view = (View) this.D.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.D.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeTabView3(Context context) {
        super(context);
        j.b(context, "context");
        Object b2 = ((x) context).b();
        if (b2 != null) {
            ((e) b2).a(this);
            this.A = com.shopee.app.util.o.d.a().a(context) >> 1;
            this.B = new b(this);
            return;
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.ui.home.HomeComponent");
    }

    public RelativeLayout getMeTabContentLayout() {
        RelativeLayout relativeLayout = this.f22446a;
        if (relativeLayout == null) {
            j.b("meTabContentLayout");
        }
        return relativeLayout;
    }

    public void setMeTabContentLayout(RelativeLayout relativeLayout) {
        j.b(relativeLayout, "<set-?>");
        this.f22446a = relativeLayout;
    }

    public SwipeRefreshLayout getSwipeContainer() {
        SwipeRefreshLayout swipeRefreshLayout = this.f22447b;
        if (swipeRefreshLayout == null) {
            j.b("swipeContainer");
        }
        return swipeRefreshLayout;
    }

    public void setSwipeContainer(SwipeRefreshLayout swipeRefreshLayout) {
        j.b(swipeRefreshLayout, "<set-?>");
        this.f22447b = swipeRefreshLayout;
    }

    public a getCoverView() {
        a aVar = this.f22448c;
        if (aVar == null) {
            j.b("coverView");
        }
        return aVar;
    }

    public void setCoverView(a aVar) {
        j.b(aVar, "<set-?>");
        this.f22448c = aVar;
    }

    public FrameLayout getSwitchContainer() {
        FrameLayout frameLayout = this.f22449d;
        if (frameLayout == null) {
            j.b("switchContainer");
        }
        return frameLayout;
    }

    public void setSwitchContainer(FrameLayout frameLayout) {
        j.b(frameLayout, "<set-?>");
        this.f22449d = frameLayout;
    }

    public TabLayout getTabLayout() {
        TabLayout tabLayout = this.f22450e;
        if (tabLayout == null) {
            j.b("tabLayout");
        }
        return tabLayout;
    }

    public void setTabLayout(TabLayout tabLayout) {
        j.b(tabLayout, "<set-?>");
        this.f22450e = tabLayout;
    }

    public c getPresenter() {
        c cVar = this.f22451f;
        if (cVar == null) {
            j.b("presenter");
        }
        return cVar;
    }

    public void setPresenter(c cVar) {
        j.b(cVar, "<set-?>");
        this.f22451f = cVar;
    }

    public bc getScope() {
        bc bcVar = this.f22452g;
        if (bcVar == null) {
            j.b("scope");
        }
        return bcVar;
    }

    public void setScope(bc bcVar) {
        j.b(bcVar, "<set-?>");
        this.f22452g = bcVar;
    }

    public UserInfo getUser() {
        UserInfo userInfo = this.h;
        if (userInfo == null) {
            j.b("user");
        }
        return userInfo;
    }

    public void setUser(UserInfo userInfo) {
        j.b(userInfo, "<set-?>");
        this.h = userInfo;
    }

    public ak getNavigator() {
        ak akVar = this.i;
        if (akVar == null) {
            j.b("navigator");
        }
        return akVar;
    }

    public void setNavigator(ak akVar) {
        j.b(akVar, "<set-?>");
        this.i = akVar;
    }

    public bi getUiEventBus() {
        bi biVar = this.j;
        if (biVar == null) {
            j.b("uiEventBus");
        }
        return biVar;
    }

    public void setUiEventBus(bi biVar) {
        j.b(biVar, "<set-?>");
        this.j = biVar;
    }

    public be getUiSettingStore() {
        be beVar = this.k;
        if (beVar == null) {
            j.b("uiSettingStore");
        }
        return beVar;
    }

    public void setUiSettingStore(be beVar) {
        j.b(beVar, "<set-?>");
        this.k = beVar;
    }

    public SettingConfigStore getConfigStore() {
        SettingConfigStore settingConfigStore = this.l;
        if (settingConfigStore == null) {
            j.b("configStore");
        }
        return settingConfigStore;
    }

    public void setConfigStore(SettingConfigStore settingConfigStore) {
        j.b(settingConfigStore, "<set-?>");
        this.l = settingConfigStore;
    }

    public r getProgress() {
        r rVar = this.m;
        if (rVar == null) {
            j.b("progress");
        }
        return rVar;
    }

    public void setProgress(r rVar) {
        j.b(rVar, "<set-?>");
        this.m = rVar;
    }

    public com.shopee.app.ui.actionbar.a getActionBar() {
        com.shopee.app.ui.actionbar.a aVar = this.n;
        if (aVar == null) {
            j.b("actionBar");
        }
        return aVar;
    }

    public void setActionBar(com.shopee.app.ui.actionbar.a aVar) {
        j.b(aVar, "<set-?>");
        this.n = aVar;
    }

    public Activity getActivity() {
        Activity activity = this.o;
        if (activity == null) {
            j.b("activity");
        }
        return activity;
    }

    public void setActivity(Activity activity) {
        j.b(activity, "<set-?>");
        this.o = activity;
    }

    public com.shopee.app.tracking.trackingv3.b getBiTrackerV3() {
        com.shopee.app.tracking.trackingv3.b bVar = this.p;
        if (bVar == null) {
            j.b("biTrackerV3");
        }
        return bVar;
    }

    public void setBiTrackerV3(com.shopee.app.tracking.trackingv3.b bVar) {
        j.b(bVar, "<set-?>");
        this.p = bVar;
    }

    public k getRnConfigProvider() {
        k kVar = this.q;
        if (kVar == null) {
            j.b("rnConfigProvider");
        }
        return kVar;
    }

    public void setRnConfigProvider(k kVar) {
        j.b(kVar, "<set-?>");
        this.q = kVar;
    }

    public void d() {
        getScope().a(getPresenter());
        getPresenter().a(this);
        getSwipeContainer().setOnRefreshListener(this);
        l();
        k();
        setSwitchIndex(getUiSettingStore().C());
        getPresenter().e();
        m();
        this.y = true;
        n();
        o();
    }

    public void a() {
        super.a();
        C = true;
        getPresenter().c();
        com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
        if (bVar == null) {
            j.b("buyerFeatureContainerView");
        }
        bVar.c();
        com.shopee.app.tracking.trackingv3.b biTrackerV3 = getBiTrackerV3();
        boolean z2 = this.y;
        biTrackerV3.a("me", new ViewCommon(z2, !z2, this.x), com.shopee.app.tracking.trackingv3.b.f19172a);
        if (this.y) {
            this.y = false;
        }
        if (getTabLayout().getSelectedTabPosition() == 1) {
            ReactTabView reactTabView = this.v;
            if (reactTabView != null) {
                reactTabView.a();
                getUiEventBus().a().A.a(true).a();
            }
        }
        d dVar = this.z;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void b() {
        super.b();
        getPresenter().d();
        C = false;
        if (this.v != null && getTabLayout().getSelectedTabPosition() == 1) {
            ReactTabView reactTabView = this.v;
            if (reactTabView != null) {
                reactTabView.b();
                getUiEventBus().a().A.a(false).a();
            }
        }
        d dVar = this.z;
        if (dVar != null) {
            dVar.b();
        }
    }

    private void k() {
        getTabLayout().a((TabLayout.b) this);
        com.shopee.app.ui.home.me.v3.feature.b a2 = c.a(getContext());
        View view = a2;
        getSwitchContainer().addView(view);
        this.w[0] = view;
        j.a((Object) a2, "MeBuyerFeatureContainerV…hTabs[0] = this\n        }");
        this.s = a2;
        if (getUser().canPostFeed()) {
            ReactTabView reactTabView = new ReactTabView(getContext(), "EMBEDDED_POSTS_PAGE", "");
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.topMargin = com.shopee.app.ui.image.editor.d.d.a(10, reactTabView.getContext());
            View view2 = reactTabView;
            getSwitchContainer().addView(view2, marginLayoutParams);
            this.w[1] = view2;
            com.shopee.app.e.b.a(view2);
            this.v = reactTabView;
        }
    }

    private void l() {
        this.t = d(R.string.sp_me_tab_buying);
        if (getUser().canPostFeed()) {
            this.u = d(R.string.sp_feed_title_posts);
        }
    }

    private View d(int i2) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.me_tab_header_view, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.text);
        if (textView instanceof TextView) {
            textView.setText(getActivity().getString(i2));
        }
        getTabLayout().a(getTabLayout().a().a(inflate));
        j.a((Object) inflate, "headerView");
        return inflate;
    }

    private void m() {
        if (getUser().isLoggedIn()) {
            com.shopee.app.e.b.d(getSwipeContainer());
            if (getTabLayout().getTabCount() > 1) {
                com.shopee.app.e.b.b(getTabLayout());
            } else {
                com.shopee.app.e.b.a(getTabLayout());
            }
        } else {
            com.shopee.app.e.b.a(getTabLayout());
            getCoverView().d();
            com.shopee.app.e.b.c(getSwipeContainer());
        }
    }

    public void setSwitchIndex(int i2) {
        TabLayout.f a2 = getTabLayout().a(i2);
        if (a2 != null) {
            a2.f();
        }
    }

    public void onRefresh() {
        getPresenter().e();
        int selectedTabPosition = getTabLayout().getSelectedTabPosition();
        if (selectedTabPosition == 0) {
            com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
            if (bVar == null) {
                j.b("buyerFeatureContainerView");
            }
            bVar.b();
        } else if (selectedTabPosition == 1) {
            ReactTabView reactTabView = this.v;
            if (reactTabView != null) {
                reactTabView.k();
            }
        }
    }

    public void c(TabLayout.f fVar) {
        Integer valueOf = fVar != null ? Integer.valueOf(fVar.d()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
            if (bVar == null) {
                j.b("buyerFeatureContainerView");
            }
            bVar.c();
        } else if (valueOf != null && valueOf.intValue() == 1) {
            ReactTabView reactTabView = this.v;
            if (reactTabView != null) {
                reactTabView.a();
            }
        }
    }

    public void b(TabLayout.f fVar) {
        if (fVar != null) {
            int intValue = Integer.valueOf(fVar.d()).intValue();
            View view = this.w[intValue];
            if (view != null) {
                com.shopee.app.e.b.a(view);
            }
            if (intValue == 1) {
                ReactTabView reactTabView = this.v;
                if (reactTabView != null) {
                    reactTabView.b();
                    getUiEventBus().a().A.a(false).a();
                }
            }
        }
    }

    public void a(TabLayout.f fVar) {
        if (fVar != null) {
            int intValue = Integer.valueOf(fVar.d()).intValue();
            View view = this.w[intValue];
            if (view != null) {
                com.shopee.app.e.b.b(view);
            }
            if (intValue == 0) {
                com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
                if (bVar == null) {
                    j.b("buyerFeatureContainerView");
                }
                bVar.c();
            } else if (intValue == 1 && C) {
                ReactTabView reactTabView = this.v;
                if (reactTabView != null) {
                    reactTabView.a();
                    getUiEventBus().a().A.a(true).a();
                }
            }
        }
        d dVar = this.z;
        if (dVar != null) {
            dVar.b(fVar != null ? fVar.d() : 0);
        }
    }

    public void e() {
        getProgress().b();
    }

    public void f() {
        getProgress().a();
    }

    public void a(CreditData creditData) {
        j.b(creditData, AbTestingModule.KEY_RESULT);
        com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
        if (bVar == null) {
            j.b("buyerFeatureContainerView");
        }
        bVar.a(creditData);
    }

    public void a(String str) {
        j.b(str, "displayValue");
        com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
        if (bVar == null) {
            j.b("buyerFeatureContainerView");
        }
        bVar.a(str);
    }

    public void a(MeCounter meCounter) {
        j.b(meCounter, "meCounter");
        getCoverView().a("ACTION_BAR_CART", meCounter.getCartCount());
    }

    public void a(UserInfo userInfo) {
        j.b(userInfo, "user");
        setUser(userInfo);
        m();
        com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
        if (bVar == null) {
            j.b("buyerFeatureContainerView");
        }
        bVar.setUserInfo(userInfo);
    }

    public void a(ShopDetail shopDetail) {
        j.b(shopDetail, "shop");
        m();
        getCoverView().setShopDetail(shopDetail);
        com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
        if (bVar == null) {
            j.b("buyerFeatureContainerView");
        }
        bVar.setShopDetail(shopDetail);
        getSwipeContainer().setRefreshing(false);
    }

    public void b(String str) {
        q.b(this, str);
    }

    public void a(int i2) {
        com.shopee.app.ui.dialog.a.a(getContext(), 0, i2, 0, (int) R.string.sp_label_ok);
    }

    public void a(long j2) {
        com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
        if (bVar == null) {
            j.b("buyerFeatureContainerView");
        }
        CoinInfo coinMultiplier = getConfigStore().coinMultiplier();
        j.a((Object) coinMultiplier, "configStore.coinMultiplier()");
        bVar.a(j2, coinMultiplier);
    }

    public void b(long j2) {
        com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
        if (bVar == null) {
            j.b("buyerFeatureContainerView");
        }
        com.shopee.app.ui.home.me.v3.feature.b.a(bVar, j2, 0, 2, (Object) null);
    }

    public void c(long j2) {
        com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
        if (bVar == null) {
            j.b("buyerFeatureContainerView");
        }
        com.shopee.app.ui.home.me.v3.feature.b.a(bVar, 0, j2, 1, (Object) null);
    }

    public void setMeTabNoticeData(MeTabNoticeItem meTabNoticeItem) {
        j.b(meTabNoticeItem, "data");
        com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
        if (bVar == null) {
            j.b("buyerFeatureContainerView");
        }
        bVar.setNoticeData(meTabNoticeItem);
    }

    public void b(int i2) {
        getCoverView().a("ACTION_BAR_ACTION_BOX", i2);
    }

    public void a(ShareMessage shareMessage) {
        j.b(shareMessage, "shareMessage");
        if (getActivity() instanceof com.shopee.app.ui.home.c) {
            boolean isMyShop = getUser().isMyShop(shareMessage.getShopID());
            int i2 = shareMessage.getmTime();
            String url = shareMessage.getUrl();
            if (isMyShop) {
                if (i2 == 0) {
                    url = url + "?is_owner=1";
                } else {
                    url = url + "?is_owner=1&v=" + i2;
                }
            } else if (i2 != 0) {
                url = url + "?v=" + i2;
            }
            if (TextUtils.isEmpty(url)) {
                com.shopee.app.h.r.a().b((int) R.string.sp_server_error);
                return;
            }
            ShareDialog shareDialog = new ShareDialog(getActivity());
            if (ShareDialog.canShow(ShareLinkContent.class)) {
                shareDialog.show(((ShareLinkContent.Builder) new ShareLinkContent.Builder().setContentUrl(Uri.parse(url))).build());
            }
        }
    }

    public void a(BuyerOrderCountItem buyerOrderCountItem) {
        j.b(buyerOrderCountItem, "buyerOrderCountItem");
        com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
        if (bVar == null) {
            j.b("buyerFeatureContainerView");
        }
        bVar.setBuyerOrderCount(buyerOrderCountItem);
    }

    public void a(int i2, int i3) {
        com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
        if (bVar == null) {
            j.b("buyerFeatureContainerView");
        }
        bVar.a(i2, i3);
    }

    public void g() {
        com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
        if (bVar == null) {
            j.b("buyerFeatureContainerView");
        }
        bVar.b();
    }

    public int getReactTag() {
        if (getUser().canPostFeed()) {
            ReactTabView reactTabView = this.v;
            if (reactTabView != null) {
                if (reactTabView == null) {
                    j.a();
                }
                return reactTabView.getReactTag();
            }
        }
        return 0;
    }

    private void n() {
        this.z = new d(getBiTrackerV3());
        getCoverView().setTrackSession(this.z);
        getCoverView().setCoverTrackSession(this.z);
        com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
        if (bVar == null) {
            j.b("buyerFeatureContainerView");
        }
        bVar.setTrackSession(this.z);
    }

    public void h() {
        com.shopee.app.ui.home.me.v3.feature.b bVar = this.s;
        if (bVar == null) {
            j.b("buyerFeatureContainerView");
        }
        bVar.d();
    }

    public int getOffsetForStatusBarScroll() {
        return this.A;
    }

    public static final class b implements com.shopee.app.ui.common.scrollview.a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MeTabView3 f22453a;

        b(MeTabView3 meTabView3) {
            this.f22453a = meTabView3;
        }

        public void a(int i, int i2, int i3, int i4) {
            int offsetForStatusBarScroll = i2 + this.f22453a.getOffsetForStatusBarScroll();
            MeCoverView3_ meCoverView3_ = (MeCoverView3_) this.f22453a.c(a.C0250a.me_cover);
            j.a((Object) meCoverView3_, "me_cover");
            if (offsetForStatusBarScroll >= meCoverView3_.getMeasuredHeight()) {
                com.shopee.app.util.o.d.a().a(this.f22453a.getActivity());
            } else {
                com.shopee.app.util.o.d.a().b(this.f22453a.getActivity());
            }
        }
    }

    private void o() {
        ((BaseNestedScrollView) c(a.C0250a.scrollView)).a((com.shopee.app.ui.common.scrollview.a.b) this.B);
    }

    public void i() {
        getNavigator().t();
    }

    public void a(ActionBarTheme actionBarTheme) {
        j.b(actionBarTheme, "theme");
        getCoverView().setDefaultCover(actionBarTheme.getLongBg());
    }
}
