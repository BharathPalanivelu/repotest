package com.shopee.app.ui.common;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.f.f;
import com.garena.android.gpns.utility.AppLogger;
import com.garena.android.uikit.a.c;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.ui.a.r;
import com.shopee.app.ui.product.newsearch.SearchTabActivity_;
import com.shopee.app.util.x;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.ConfigureButtonMessage;
import com.shopee.app.web.protocol.SearchConfig;
import com.shopee.app.web.protocol.TabsConfig;
import java.util.List;

public class ay extends RelativeLayout implements c.b, r, au {

    /* renamed from: a  reason: collision with root package name */
    c f21209a;

    /* renamed from: b  reason: collision with root package name */
    ImageButton f21210b;

    /* renamed from: c  reason: collision with root package name */
    ax f21211c;

    /* renamed from: d  reason: collision with root package name */
    com.shopee.app.tracking.a f21212d;

    /* renamed from: e  reason: collision with root package name */
    i f21213e;

    /* renamed from: f  reason: collision with root package name */
    private l f21214f;

    /* renamed from: g  reason: collision with root package name */
    private l f21215g;
    private SearchConfig h;
    private TabsConfig i;
    private int j;
    private int k;
    private boolean l;
    private e m = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ConfigureButtonMessage configureButtonMessage = (ConfigureButtonMessage) aVar.data;
            if (ay.this.e(configureButtonMessage.getWebviewId()) && ay.this.f21210b != null && ay.this.f21210b.getVisibility() == 0 && configureButtonMessage.getKey().equals(ay.this.f21210b.getTag())) {
                ay.this.f21210b.setImageResource(configureButtonMessage.getIconDrawable());
            }
        }
    };
    private e n = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            ay.this.j();
        }
    };

    public void a(int i2) {
    }

    public void a(o oVar) {
    }

    public ay(Context context, l lVar, l lVar2, l lVar3, SearchConfig searchConfig, int i2, boolean z) {
        super(context);
        this.f21214f = lVar;
        this.j = i2;
        this.l = z;
        if (lVar2 != null) {
            this.i = (TabsConfig) WebRegister.GSON.a(lVar2, TabsConfig.class);
        }
        this.f21215g = lVar3;
        this.h = searchConfig;
        ((com.shopee.app.ui.webview.e) ((x) context).b()).a(this);
    }

    public int f() {
        int a2 = com.garena.android.appkit.tools.c.a().a(49);
        ImageButton imageButton = this.f21210b;
        if (imageButton == null || imageButton.getVisibility() != 0) {
            return 0;
        }
        return a2;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.f21211c = new ax(this.f21214f, this, this.i);
        aq aqVar = new aq(this.f21211c.b());
        TabsConfig tabsConfig = this.i;
        if (tabsConfig != null) {
            aqVar.a(tabsConfig.getActiveColor());
        }
        this.f21209a.setHeaderScrollListener(this.f21211c);
        this.f21209a.setAdapter(this.f21211c);
        this.f21209a.setTabChangeListener(this);
        ImageButton imageButton = this.f21210b;
        this.f21209a.a();
        this.f21209a.setTabIndicator(aqVar);
        this.f21209a.setSelectedIndex(this.i.getTabIndex());
        if (!this.l) {
            this.f21213e.setShadowTopOffset(0);
        }
    }

    public String getActiveTabUrl() {
        return d(this.f21209a.getSelectedIndex());
    }

    public av getCurrentTabContent() {
        return this.f21211c.a(this.f21209a.getSelectedIndex());
    }

    public void d(String str) {
        for (int i2 = 0; i2 < this.f21211c.b(); i2++) {
            f.a().a(new a(str, i2, 0));
        }
    }

    public void a(int i2, int i3) {
        int i4;
        int i5 = this.j;
        if (i5 == 109 || i5 == -1) {
            if (this.f21211c.c()) {
                i4 = 0;
            } else {
                i4 = this.f21211c.e() ? 1 : -1;
            }
            this.f21211c.d();
            this.f21211c.f();
            if (i4 != -1) {
                this.f21212d.a(i4, i3, c(i3), this.j == 109 ? "official_shop_landing" : "third_tab");
            }
        }
    }

    public int getTabHeaderHeight() {
        c cVar = this.f21209a;
        if (cVar == null || cVar.getChildCount() <= 0) {
            return 0;
        }
        return this.f21209a.getChildAt(0).getMeasuredHeight();
    }

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private String f21219b;

        /* renamed from: c  reason: collision with root package name */
        private int f21220c;

        /* renamed from: d  reason: collision with root package name */
        private int f21221d;

        public a(String str, int i, int i2) {
            this.f21219b = str;
            this.f21220c = i;
            this.f21221d = i2;
        }

        public void run() {
            av a2 = ay.this.f21211c.a(this.f21220c);
            if (a2 != null) {
                a2.f21195a.d(this.f21219b);
            } else if (this.f21221d <= 5) {
                f a3 = f.a();
                ay ayVar = ay.this;
                String str = this.f21219b;
                int i = this.f21220c;
                int i2 = this.f21221d;
                this.f21221d = i2 + 1;
                a3.a(new a(str, i, i2), 500);
            }
        }
    }

    public void a(String str, int i2, int i3, String str2, int i4, int i5, String str3, String str4) {
        this.k = i2;
        av currentTabContent = getCurrentTabContent();
        if (currentTabContent == null || currentTabContent.getWebPageView() == null || !currentTabContent.getWebPageView().a(str, i2, i3, str2, i4, i5, 0, str3, str4)) {
            for (int i6 = 0; i6 < this.f21211c.b(); i6++) {
                av a2 = this.f21211c.a(i6);
                if (a2 != null) {
                    String str5 = str;
                    a2.getWebPageView().k(str);
                } else {
                    String str6 = str;
                }
            }
        }
    }

    public void a(List<String> list) {
        av currentTabContent = getCurrentTabContent();
        if (currentTabContent != null && currentTabContent.getWebPageView() != null) {
            currentTabContent.getWebPageView().a(list);
        }
    }

    public void e(String str) {
        av currentTabContent = getCurrentTabContent();
        if (currentTabContent != null && currentTabContent.getWebPageView() != null) {
            currentTabContent.getWebPageView().e(str);
        }
    }

    public void f(String str) {
        av currentTabContent = getCurrentTabContent();
        if (currentTabContent != null && currentTabContent.getWebPageView() != null) {
            currentTabContent.getWebPageView().f(str);
        }
    }

    public void g() {
        av currentTabContent = getCurrentTabContent();
        if (currentTabContent != null && currentTabContent.getWebPageView() != null) {
            currentTabContent.getWebPageView().g();
        }
    }

    public void h() {
        av currentTabContent = getCurrentTabContent();
        if (currentTabContent != null && currentTabContent.getWebPageView() != null) {
            currentTabContent.getWebPageView().h();
        }
    }

    public void b(int i2) {
        av currentTabContent = getCurrentTabContent();
        if (currentTabContent != null && currentTabContent.getWebPageView() != null) {
            currentTabContent.getWebPageView().b(i2);
        }
    }

    public void a(int i2, List<String> list) {
        av currentTabContent = getCurrentTabContent();
        if (currentTabContent != null && currentTabContent.getWebPageView() != null) {
            currentTabContent.getWebPageView().a(i2, list);
        }
    }

    public void a(int i2, Intent intent) {
        av currentTabContent = getCurrentTabContent();
        if (currentTabContent != null && currentTabContent.getWebPageView() != null) {
            currentTabContent.getWebPageView().a(i2, intent);
        }
    }

    public void e() {
        for (int i2 = 0; i2 < this.f21211c.b(); i2++) {
            av a2 = this.f21211c.a(i2);
            if (a2 != null) {
                a2.f21195a.e();
            }
        }
    }

    public boolean a() {
        av currentTabContent = getCurrentTabContent();
        if (currentTabContent == null || currentTabContent.getWebPageView() == null) {
            return false;
        }
        return currentTabContent.getWebPageView().a();
    }

    public String c(int i2) {
        try {
            return this.f21214f.n().a(i2).m().c("name").c();
        } catch (Exception e2) {
            AppLogger.e(e2);
            return "";
        }
    }

    public String d(int i2) {
        try {
            return this.f21214f.n().a(i2).m().c("url").c();
        } catch (Exception e2) {
            AppLogger.e(e2);
            return "";
        }
    }

    public void b() {
        this.f21209a.b();
        b.a("SEARCH", this.n, b.a.UI_BUS);
        b.a("FILTER", this.m, b.a.UI_BUS);
    }

    public void c() {
        this.f21209a.c();
        b.b("SEARCH", this.n, b.a.UI_BUS);
        b.b("FILTER", this.m, b.a.UI_BUS);
    }

    public void d() {
        this.f21209a.d();
        this.f21211c.g();
    }

    public void j() {
        ((SearchTabActivity_.a) SearchTabActivity_.a(getContext()).b(WebRegister.GSON.b(this.h, SearchConfig.class)).b(this.h.getCurrentSearchType()).c(this.j).a(((com.shopee.app.ui.a.b) getContext()).v().getSearchText()).k(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)).a(this.j == 109 ? 10029 : 10030);
    }

    /* access modifiers changed from: private */
    public boolean e(int i2) {
        for (int i3 = 0; i3 < this.f21211c.b(); i3++) {
            if (this.f21211c.a(i3).getWebviewId() == i2) {
                return true;
            }
        }
        return false;
    }

    public void a(av avVar) {
        this.f21211c.a(avVar);
    }
}
