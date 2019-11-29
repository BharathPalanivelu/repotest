package com.shopee.app.ui.product.search;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.react.uimanager.ViewProps;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.data.store.SearchHistoryData;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.viewmodel.CuratedHint;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.tracking.c;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.ui.actionbar.k;
import com.shopee.app.ui.follow.search.e;
import com.shopee.app.util.af;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.l;
import com.shopee.app.util.x;
import com.shopee.app.web.protocol.SearchConfig;
import com.shopee.id.R;
import java.util.List;

public class o extends FrameLayout implements AbsListView.OnScrollListener, com.shopee.app.ui.a.o, e.a {

    /* renamed from: a  reason: collision with root package name */
    TextView f24866a;

    /* renamed from: b  reason: collision with root package name */
    ListView f24867b;

    /* renamed from: c  reason: collision with root package name */
    ProgressBar f24868c;

    /* renamed from: d  reason: collision with root package name */
    l f24869d;

    /* renamed from: e  reason: collision with root package name */
    bc f24870e;

    /* renamed from: f  reason: collision with root package name */
    ak f24871f;

    /* renamed from: g  reason: collision with root package name */
    Activity f24872g;
    com.shopee.app.tracking.a h;
    c i;
    SearchKeywordsStore j;
    com.shopee.app.a.a.a k;
    b l;
    b m;
    com.shopee.app.ui.product.search.a.a n;
    com.shopee.app.ui.product.search.tracking.b o;
    private final int p;
    private final SearchConfig q;
    private String r;
    private int s = 0;
    private int t = (b.a.f7696g * 30);
    private boolean u;
    private int v;

    public interface a {
        void a(o oVar);
    }

    public o(Context context, String str, SearchConfig searchConfig, int i2) {
        super(context);
        this.r = str;
        this.q = searchConfig;
        this.p = searchConfig.getSearchParam();
        this.v = i2;
        this.m = new com.shopee.app.tracking.trackingv3.b(String.valueOf(System.currentTimeMillis()), "search_hint");
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f24870e.a(this.f24869d);
        this.f24869d.a(this);
        n nVar = new n(this, this.l);
        this.o = new com.shopee.app.ui.product.search.tracking.b(this.f24867b, this.i, this.l, this.k);
        this.n = new com.shopee.app.ui.product.search.a.a(nVar, this.o.a());
        this.o.a(this.n);
        this.f24867b.setAdapter(this.n);
        this.f24867b.setOnScrollListener(this);
        this.f24869d.a(this.q, this.v);
        if (!TextUtils.isEmpty(this.r)) {
            this.f24869d.a(this.r, 40, 0, this.p);
        } else {
            this.f24869d.a(this.p);
        }
        this.f24866a = (TextView) inflate(getContext(), R.layout.search_history_item_layout, (ViewGroup) null);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int i6 = i5 - i3;
        if (i6 >= l.p) {
            this.t = i6;
            this.u = true;
        } else if (i6 <= (-l.p) && i5 != 0) {
            this.u = false;
        }
    }

    public void setKeyword(String str) {
        this.r = str;
    }

    public void x_() {
        this.f24868c.setVisibility(0);
    }

    public void d() {
        this.f24868c.setVisibility(8);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        com.shopee.app.ui.product.search.a.a aVar = this.n;
        if (aVar != null && !af.a(aVar.a())) {
            SearchProductItem searchProductItem = this.n.a().get(i2);
            this.o.a(searchProductItem, i2);
            switch (searchProductItem.getType()) {
                case 0:
                    this.f24869d.a(searchProductItem, "", this.s, i2, searchProductItem.getCateId());
                    a(searchProductItem);
                    return;
                case 2:
                    this.f24871f.a(searchProductItem.getKeyword(), true);
                    this.i.a("ViewAllShop", new com.google.a.o());
                    this.m.a("show_all_button", "search_shop_hint", com.shopee.app.tracking.trackingv3.b.a(this.f24869d.e()));
                    return;
                case 3:
                    this.f24869d.f();
                    return;
                case 4:
                    if (searchProductItem.getExtra() != null) {
                        SearchHistoryData searchHistoryData = (SearchHistoryData) searchProductItem.getExtra();
                        int type = searchHistoryData.getType();
                        if (type == 0) {
                            this.f24869d.a(searchProductItem, "", this.s, i2, searchProductItem.getCateId());
                        } else if (type == 1) {
                            String keyword = searchHistoryData.getKeyword();
                            this.j.addShopHistory(keyword);
                            this.f24871f.a(keyword, true);
                        } else if (type == 2) {
                            if (searchHistoryData.getShopId() > 0) {
                                this.f24871f.b(searchHistoryData.getShopId());
                            } else {
                                this.f24871f.c(searchHistoryData.getUserId());
                            }
                        }
                    } else {
                        this.f24869d.a(searchProductItem, "", this.s, i2, searchProductItem.getCateId());
                    }
                    a(searchProductItem);
                    return;
                case 5:
                    this.f24869d.h();
                    return;
                case 6:
                    this.f24869d.a(searchProductItem.getKeywords().get(0).trim(), searchProductItem.getCount(), this.s, i2, this.p);
                    return;
                case 9:
                    String trim = searchProductItem.getKeywords().get(0).trim();
                    this.j.addShopHistory(trim);
                    this.f24871f.a(trim, true);
                    this.h.b(trim);
                    return;
                case 10:
                    if (searchProductItem.getExtra() instanceof UserBriefInfo) {
                        UserBriefInfo userBriefInfo = (UserBriefInfo) searchProductItem.getExtra();
                        this.j.addUserHistory(userBriefInfo.getNickName(), userBriefInfo.getUserId(), userBriefInfo.getShopId());
                        if (userBriefInfo.getShopId() != -1) {
                            this.f24871f.b(userBriefInfo.getShopId());
                        } else {
                            this.f24871f.c(userBriefInfo.getUserId());
                        }
                        int b2 = i2 - this.n.b();
                        com.google.a.o oVar = new com.google.a.o();
                        oVar.a("clicked_shop_id", (Number) Integer.valueOf(userBriefInfo.getShopId()));
                        oVar.a(ViewProps.POSITION, (Number) Integer.valueOf(b2));
                        this.i.a("ShopHint", oVar);
                        return;
                    }
                    return;
                case 11:
                    this.f24869d.g();
                    return;
                case 12:
                    this.f24869d.a(searchProductItem, "searchPrefillFirstItem", this.s, i2, searchProductItem.getCateId());
                    a(searchProductItem);
                    return;
                case 14:
                    if (searchProductItem.getExtra() instanceof CuratedHint) {
                        CuratedHint curatedHint = (CuratedHint) searchProductItem.getExtra();
                        this.l.a("click", "curated_search", "search_bar", com.shopee.app.ui.product.search.tracking.a.a(curatedHint, i2, 0, searchProductItem));
                        a(curatedHint.getUrl(), "curated");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void a(SearchProductItem searchProductItem) {
        if (this.f24869d.i()) {
            this.h.a(this.n.a(), searchProductItem, this.s);
        }
    }

    public void a(List<SearchProductItem> list) {
        if (list != null) {
            this.n.a(list);
            this.n.notifyDataSetChanged();
            this.s = this.f24867b.getLastVisiblePosition() - 1;
        }
    }

    public void b() {
        this.f24869d.c();
    }

    public void e() {
        this.f24869d.d();
    }

    public void f() {
        com.shopee.app.ui.product.search.tracking.b bVar = this.o;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 != 0) {
            com.shopee.app.c.a.a(getContext());
        }
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        this.s = Math.max(this.s, (i2 + i3) - 2);
    }

    public void a(String str, String str2) {
        if (str2.equals("curated")) {
            this.f24871f.s(str);
            this.f24872g.finish();
            return;
        }
        this.f24869d.a(str, str2);
    }

    public int getKeyboardHeight() {
        return this.t;
    }

    public void g() {
        this.f24867b.setSelection(0);
    }

    public void h() {
        ((k) this.f24872g.findViewById(R.id.search_view)).setTextColor(com.garena.android.appkit.tools.b.a(R.color.black));
    }
}
