package com.shopee.app.ui.home.me.v3.feature;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.afollestad.materialdialogs.f;
import com.shopee.app.a;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.al;
import com.shopee.app.data.viewmodel.MeTabNoticeItem;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.data.viewmodel.WebPageModel;
import com.shopee.app.data.viewmodel.order.SellerOrderCountItem;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.home.me.v3.NotificationRow;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.ui.webview.TouchWebView;
import com.shopee.app.ui.webview.WebPageView_;
import com.shopee.app.ui.webview.g;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.util.bi;
import com.shopee.app.util.i;
import com.shopee.app.util.x;
import com.shopee.id.R;
import d.d.b.j;
import d.d.b.r;
import d.m;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class k extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public MeFeatureRecyclerView f22628a;

    /* renamed from: b  reason: collision with root package name */
    public UploadManager f22629b;

    /* renamed from: c  reason: collision with root package name */
    public bi f22630c;

    /* renamed from: d  reason: collision with root package name */
    public com.shopee.app.tracking.a f22631d;

    /* renamed from: e  reason: collision with root package name */
    public al f22632e;

    /* renamed from: f  reason: collision with root package name */
    private final a f22633f;

    /* renamed from: g  reason: collision with root package name */
    private com.shopee.app.ui.home.me.tracking.seller.b f22634g;
    private HashMap h;

    public k(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    public View a(int i) {
        if (this.h == null) {
            this.h = new HashMap();
        }
        View view = (View) this.h.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.h.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        setOrientation(1);
        setDescendantFocusability(393216);
        Object b2 = ((x) context).b();
        if (b2 != null) {
            ((com.shopee.app.ui.home.e) b2).a(this);
            this.f22633f = new a(context);
            return;
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.ui.home.HomeComponent");
    }

    public MeFeatureRecyclerView getFeatureRecyclerView() {
        MeFeatureRecyclerView meFeatureRecyclerView = this.f22628a;
        if (meFeatureRecyclerView == null) {
            j.b("featureRecyclerView");
        }
        return meFeatureRecyclerView;
    }

    public void setFeatureRecyclerView(MeFeatureRecyclerView meFeatureRecyclerView) {
        j.b(meFeatureRecyclerView, "<set-?>");
        this.f22628a = meFeatureRecyclerView;
    }

    public UploadManager getUploader() {
        UploadManager uploadManager = this.f22629b;
        if (uploadManager == null) {
            j.b("uploader");
        }
        return uploadManager;
    }

    public void setUploader(UploadManager uploadManager) {
        j.b(uploadManager, "<set-?>");
        this.f22629b = uploadManager;
    }

    public bi getUiEventBus() {
        bi biVar = this.f22630c;
        if (biVar == null) {
            j.b("uiEventBus");
        }
        return biVar;
    }

    public void setUiEventBus(bi biVar) {
        j.b(biVar, "<set-?>");
        this.f22630c = biVar;
    }

    public com.shopee.app.tracking.a getActionTracker() {
        com.shopee.app.tracking.a aVar = this.f22631d;
        if (aVar == null) {
            j.b("actionTracker");
        }
        return aVar;
    }

    public void setActionTracker(com.shopee.app.tracking.a aVar) {
        j.b(aVar, "<set-?>");
        this.f22631d = aVar;
    }

    public al getLoginStore() {
        al alVar = this.f22632e;
        if (alVar == null) {
            j.b("loginStore");
        }
        return alVar;
    }

    public void setLoginStore(al alVar) {
        j.b(alVar, "<set-?>");
        this.f22632e = alVar;
    }

    public a getMetaData() {
        return this.f22633f;
    }

    public com.shopee.app.ui.home.me.tracking.seller.b getTrackSession() {
        return this.f22634g;
    }

    public void setTrackSession(com.shopee.app.ui.home.me.tracking.seller.b bVar) {
        this.f22634g = bVar;
        getMetaData().a(bVar);
    }

    public void a() {
        h();
        b();
    }

    public void b() {
        List<MeFeature> D = getLoginStore().D();
        j.a((Object) D, "loginStore.sellerFeatures");
        getFeatureRecyclerView().a(getMetaData(), D);
        com.shopee.app.ui.home.me.tracking.seller.b trackSession = getTrackSession();
        if (trackSession != null) {
            trackSession.a(getFeatureRecyclerView());
        }
    }

    public void c() {
        i();
    }

    public void setShopDetail(ShopDetail shopDetail) {
        ShopDetail shopDetail2 = shopDetail;
        j.b(shopDetail2, "shop");
        if (!j.a((Object) getMetaData().c(), (Object) shopDetail2)) {
            getMetaData().a(shopDetail2);
            setHolidayMode(shopDetail.isOnHoliday());
            getFeatureRecyclerView().y();
        }
        if (shopDetail.isSeller()) {
            ((OptionRow) a(a.C0250a.btnViewMyShop)).setValue(d.h.m.a(d.h.m.a(i.f7041d + shopDetail.getUserName(), "http://", "", false, 4, (Object) null), "https://", "", false, 4, (Object) null));
            WebPageView_ webPageView_ = (WebPageView_) a(a.C0250a.listingWebView);
            j.a((Object) webPageView_, "listingWebView");
            if (webPageView_.getVisibility() != 0) {
                WebPageView_ webPageView_2 = (WebPageView_) a(a.C0250a.listingWebView);
                j.a((Object) webPageView_2, "listingWebView");
                webPageView_2.setVisibility(0);
                r rVar = r.f32672a;
                Locale locale = Locale.ENGLISH;
                j.a((Object) locale, "Locale.ENGLISH");
                Object[] objArr = {Integer.valueOf(shopDetail.getShopId())};
                String format = String.format(locale, i.f7040c + "shop/%d/item_list", Arrays.copyOf(objArr, objArr.length));
                j.a((Object) format, "java.lang.String.format(locale, format, *args)");
                ((WebPageView_) a(a.C0250a.listingWebView)).b(new WebPageModel(format));
                WebPageView_ webPageView_3 = (WebPageView_) a(a.C0250a.listingWebView);
                j.a((Object) webPageView_3, "listingWebView");
                TouchWebView webView = webPageView_3.getWebView();
                j.a((Object) webView, "listingWebView.webView");
                webView.setWebViewClient(new d(this, (WebPageView_) a(a.C0250a.listingWebView)));
            }
        }
    }

    public static final class d extends g.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f22638a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(k kVar, g gVar) {
            super(gVar);
            this.f22638a = kVar;
        }

        public void a() {
            this.f22638a.g();
        }

        public void onPageFinished(WebView webView, String str) {
            j.b(webView, "view");
            j.b(str, "url");
            super.onPageFinished(webView, str);
            this.f22638a.g();
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        WebPageView_ webPageView_ = (WebPageView_) a(a.C0250a.listingWebView);
        j.a((Object) webPageView_, "listingWebView");
        webPageView_.getWebView().loadUrl("javascript:if(!document || !document.body){MeTabView.resize(0);}else{MeTabView.resize(document.body.offsetHeight);}");
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f22635a;

        b(k kVar) {
            this.f22635a = kVar;
        }

        public final void run() {
            this.f22635a.g();
        }
    }

    @JavascriptInterface
    public void resize(int i) {
        if (i == 0) {
            postDelayed(new b(this), 500);
        } else {
            post(new c(this, i));
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f22636a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f22637b;

        c(k kVar, int i) {
            this.f22636a = kVar;
            this.f22637b = i;
        }

        public final void run() {
            Resources resources = this.f22636a.getResources();
            j.a((Object) resources, "resources");
            int b2 = com.garena.android.appkit.tools.b.b();
            WebPageView_ webPageView_ = (WebPageView_) this.f22636a.a(a.C0250a.listingWebView);
            j.a((Object) webPageView_, "listingWebView");
            webPageView_.setLayoutParams(new LinearLayout.LayoutParams(b2, (int) (((float) this.f22637b) * resources.getDisplayMetrics().density)));
            WebPageView_ webPageView_2 = (WebPageView_) this.f22636a.a(a.C0250a.listingWebView);
            j.a((Object) webPageView_2, "listingWebView");
            TouchWebView webView = webPageView_2.getWebView();
            j.a((Object) webView, "listingWebView.webView");
            com.shopee.app.e.b.b(webView);
            WebPageView_ webPageView_3 = (WebPageView_) this.f22636a.a(a.C0250a.listingWebView);
            j.a((Object) webPageView_3, "listingWebView");
            com.shopee.app.e.b.b(webPageView_3);
            this.f22636a.requestLayout();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void h() {
        WebPageView_ webPageView_ = (WebPageView_) a(a.C0250a.listingWebView);
        j.a((Object) webPageView_, "listingWebView");
        webPageView_.getSwipeRefreshLayout().setEnabled(false);
        WebPageView_ webPageView_2 = (WebPageView_) a(a.C0250a.listingWebView);
        j.a((Object) webPageView_2, "listingWebView");
        webPageView_2.getWebView().addJavascriptInterface(this, "MeTabView");
    }

    public void a(UserInfo userInfo) {
        j.b(userInfo, "user");
        if (!j.a((Object) getMetaData().j(), (Object) userInfo)) {
            getMetaData().a(userInfo);
            getFeatureRecyclerView().y();
        }
    }

    public void a(SellerOrderCountItem sellerOrderCountItem) {
        j.b(sellerOrderCountItem, "sellerOrderCountItem");
        if (!j.a((Object) getMetaData().b(), (Object) sellerOrderCountItem)) {
            getMetaData().a(sellerOrderCountItem);
            getFeatureRecyclerView().y();
        }
    }

    public static /* synthetic */ void a(k kVar, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = kVar.getMetaData().a();
            }
            kVar.a(j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateBalance");
    }

    public void a(long j) {
        if (getMetaData().a() != j) {
            getMetaData().a(j);
            getFeatureRecyclerView().y();
        }
    }

    public void setNoticeData(MeTabNoticeItem meTabNoticeItem) {
        j.b(meTabNoticeItem, "data");
        NotificationRow notificationRow = (NotificationRow) a(a.C0250a.notificationRow);
        ShopDetail c2 = getMetaData().c();
        notificationRow.a(c2 != null ? c2.isOnHoliday() : false, meTabNoticeItem);
    }

    public void d() {
        WebPageView_ webPageView_ = (WebPageView_) a(a.C0250a.listingWebView);
        j.a((Object) webPageView_, "listingWebView");
        if (webPageView_.getVisibility() == 0) {
            ((WebPageView_) a(a.C0250a.listingWebView)).onRefresh();
        }
    }

    public void setJKOStatus(boolean z) {
        if (getMetaData().d() != z) {
            getMetaData().a(z);
            getFeatureRecyclerView().y();
        }
    }

    public void e() {
        a(this, 0, 1, (Object) null);
    }

    private void setHolidayMode(boolean z) {
        RelativeLayout relativeLayout = (RelativeLayout) a(a.C0250a.vacationMode);
        j.a((Object) relativeLayout, "vacationMode");
        com.shopee.app.e.b.a((View) relativeLayout, z);
        NotificationRow.a((NotificationRow) a(a.C0250a.notificationRow), z, (MeTabNoticeItem) null, 2, (Object) null);
    }

    private void i() {
        String string = getResources().getString(R.string.sp_label_camera);
        j.a((Object) string, "resources.getString(R.string.sp_label_camera)");
        String string2 = getResources().getString(R.string.sp_label_photos);
        j.a((Object) string2, "resources.getString(R.string.sp_label_photos)");
        String string3 = getResources().getString(R.string.sp_label_instagram);
        j.a((Object) string3, "resources.getString(R.string.sp_label_instagram)");
        com.shopee.app.ui.dialog.a.a(getContext(), com.garena.android.appkit.tools.b.e(R.string.sp_title_action_sheet_sell), new CharSequence[]{string, string2, string3}, (a.c) new e(this));
    }

    static final class e implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f22639a;

        e(k kVar) {
            this.f22639a = kVar;
        }

        public final void a(f fVar, View view, int i, CharSequence charSequence) {
            if (i == 0) {
                this.f22639a.j();
            } else if (i != 1) {
                this.f22639a.l();
            } else {
                this.f22639a.k();
            }
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        getMetaData().k().a(0, getUploader(), getMetaData().j().isBACheckNeeded() && getMetaData().p().allowBACheck(), true);
        getActionTracker().c(0);
    }

    /* access modifiers changed from: private */
    public void k() {
        getMetaData().k().a(1, getUploader(), getMetaData().j().isBACheckNeeded() && getMetaData().p().allowBACheck(), true);
        getActionTracker().c(1);
    }

    /* access modifiers changed from: private */
    public void l() {
        getMetaData().k().a(2, getUploader(), getMetaData().j().isBACheckNeeded() && getMetaData().p().allowBACheck(), true);
        getActionTracker().c(2);
    }

    public void f() {
        getMetaData().k().I();
    }

    public void a(View view) {
        j.b(view, "view");
        ShopDetail c2 = getMetaData().c();
        if (c2 != null) {
            getMetaData().k().b(c2.getShopId());
        }
        com.shopee.app.ui.home.me.tracking.seller.b trackSession = getTrackSession();
        if (trackSession != null) {
            trackSession.a(view);
        }
    }

    public static final class a extends i {
        private long j;
        private SellerOrderCountItem k;
        private ShopDetail l;
        private boolean m;

        public a(Context context) {
            j.b(context, "context");
            Object b2 = ((x) context).b();
            if (b2 != null) {
                ((com.shopee.app.ui.home.e) b2).a(this);
                return;
            }
            throw new m("null cannot be cast to non-null type com.shopee.app.ui.home.HomeComponent");
        }

        public final long a() {
            return this.j;
        }

        public final void a(long j2) {
            this.j = j2;
        }

        public final void a(SellerOrderCountItem sellerOrderCountItem) {
            this.k = sellerOrderCountItem;
        }

        public final SellerOrderCountItem b() {
            return this.k;
        }

        public final void a(ShopDetail shopDetail) {
            this.l = shopDetail;
        }

        public final ShopDetail c() {
            return this.l;
        }

        public final void a(boolean z) {
            this.m = z;
        }

        public final boolean d() {
            return this.m;
        }
    }
}
