package com.shopee.app.ui.follow.search;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.facebook.react.uimanager.ViewProps;
import com.shopee.app.data.store.SearchHistoryData;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.h.q;
import com.shopee.app.tracking.ImpressionObserver;
import com.shopee.app.tracking.c;
import com.shopee.app.ui.a.o;
import com.shopee.app.ui.a.u;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.follow.search.e;
import com.shopee.app.ui.product.search.n;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.shopeetracker.utils.Logger;
import java.util.List;

public class m extends FrameLayout implements AbsListView.OnScrollListener, o, e.a {

    /* renamed from: a  reason: collision with root package name */
    ListView f21818a;

    /* renamed from: b  reason: collision with root package name */
    ListView f21819b;

    /* renamed from: c  reason: collision with root package name */
    r f21820c;

    /* renamed from: d  reason: collision with root package name */
    k f21821d;

    /* renamed from: e  reason: collision with root package name */
    bc f21822e;

    /* renamed from: f  reason: collision with root package name */
    b f21823f;

    /* renamed from: g  reason: collision with root package name */
    ak f21824g;
    View h;
    com.shopee.app.h.m i;
    Activity j;
    com.shopee.app.tracking.a k;
    c l;
    com.shopee.app.tracking.trackingv3.b m;
    com.shopee.app.a.a.a n;
    ImpressionObserver o;
    com.shopee.app.ui.product.search.a.b p;
    private p q;
    private final String r;
    private final boolean s;
    private final int t;
    private boolean u;
    private final String v;

    public interface a {
        void a(m mVar);
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    public m(Context context, String str, boolean z, int i2, boolean z2, String str2) {
        super(context);
        this.r = str;
        this.s = z;
        this.t = i2;
        this.u = z2;
        this.v = str2;
        ((a) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f21822e.a(this.f21821d);
        this.f21821d.a(this);
        this.f21821d.a(this.t);
        this.o = new ImpressionObserver(this.f21818a, this.l, this.m, new ImpressionObserver.b("shop", "", "ShopResults"), (d.d.a.b<? super Integer, com.google.a.o>) new d.d.a.b<Integer, com.google.a.o>() {
            public com.google.a.o a(Integer num) {
                if (num.intValue() < 0 || num.intValue() >= m.this.f21823f.getCount()) {
                    return null;
                }
                UserBriefInfo userBriefInfo = (UserBriefInfo) m.this.f21823f.getItem(num.intValue());
                Logger.debug("Shop impression " + userBriefInfo.getShopId());
                return com.shopee.app.tracking.trackingv3.b.a(num.intValue(), (long) userBriefInfo.getShopId(), m.this.f21821d.g());
            }
        });
        this.n.a(this.o);
        this.f21823f = new b(this.o);
        this.f21818a.setAdapter(this.f21823f);
        this.p = new com.shopee.app.ui.product.search.a.b(new n(this, this.m));
        this.f21819b.setAdapter(this.p);
        this.q = new p(this.f21818a);
        this.q.a((p.a) this.f21821d);
        this.q.a((AbsListView.OnScrollListener) this);
        this.f21821d.a(this.r, this.s);
        this.f21821d.e();
        this.h.setVisibility(8);
    }

    public void x_() {
        this.f21820c.a();
    }

    public void d() {
        this.f21820c.b();
    }

    /* access modifiers changed from: package-private */
    public void a(SearchProductItem searchProductItem) {
        int type = searchProductItem.getType();
        if (type == 0) {
            return;
        }
        if (type == 2) {
            this.f21824g.d(searchProductItem.getKeyword());
        } else if (type == 3) {
            this.f21821d.i();
        } else if (type != 4) {
            if (type == 5) {
                this.f21821d.h();
            }
        } else if (searchProductItem.getExtra() != null) {
            this.f21821d.a((SearchHistoryData) searchProductItem.getExtra());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        UserBriefInfo userBriefInfo = (UserBriefInfo) this.f21823f.getItem(i2);
        if (userBriefInfo != null) {
            if (this.u) {
                this.k.a(userBriefInfo.getShopId(), i2);
                this.m.a("shop", com.shopee.app.tracking.trackingv3.b.a(i2, (long) userBriefInfo.getShopId(), this.f21821d.g()));
            }
            int i3 = this.t;
            if (i3 == 0) {
                int intValue = this.i.g().intValue();
                int shopId = userBriefInfo.getShopId();
                this.f21821d.a(userBriefInfo.getNickName(), userBriefInfo.getUserId(), userBriefInfo.getShopId());
                c(userBriefInfo.getShopId());
                com.google.a.o oVar = new com.google.a.o();
                oVar.a("clicked_shop_id", (Number) Integer.valueOf(userBriefInfo.getShopId()));
                oVar.a(ViewProps.POSITION, (Number) Integer.valueOf(i2));
                this.l.a("Shop", oVar);
            } else if (i3 == 1) {
                this.f21824g.a(userBriefInfo.getUserId(), userBriefInfo.getShopId(), "", userBriefInfo.getUserName());
            }
        }
    }

    public void a(List<UserBriefInfo> list) {
        if (list != null) {
            this.f21823f.a(list);
            this.f21823f.notifyDataSetChanged();
            this.h.setVisibility(8);
            this.f21819b.setVisibility(8);
        }
    }

    public void b() {
        this.h.setVisibility(0);
        this.f21819b.setVisibility(8);
    }

    public void b(List<SearchProductItem> list) {
        this.h.setVisibility(8);
        this.f21819b.setVisibility(0);
        this.p.a(list);
        this.p.notifyDataSetChanged();
    }

    public void b(int i2) {
        this.f21823f.a(i2);
        this.f21823f.notifyDataSetChanged();
    }

    public void a(String str) {
        q.a((View) this, str);
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 != 0) {
            com.shopee.app.c.a.a(getContext());
        }
    }

    public void a(String str, String str2) {
        this.f21821d.a(str);
    }

    public void c(int i2) {
        this.f21824g.a(i2, this.v);
    }

    public void d(int i2) {
        this.f21824g.c(i2);
    }

    public void e() {
        this.f21821d.c();
        ImpressionObserver impressionObserver = this.o;
        if (impressionObserver != null) {
            impressionObserver.onResume();
        }
    }

    public void f() {
        this.f21821d.d();
        ImpressionObserver impressionObserver = this.o;
        if (impressionObserver != null) {
            impressionObserver.onPause();
        }
    }

    public void g() {
        ImpressionObserver impressionObserver = this.o;
        if (impressionObserver != null) {
            impressionObserver.a();
        }
    }

    public void h() {
        this.o.b();
    }

    public static class b extends u<UserBriefInfo> {
        protected b(ImpressionObserver impressionObserver) {
            super(impressionObserver);
        }

        /* access modifiers changed from: protected */
        public com.shopee.app.ui.a.n<UserBriefInfo> a(Context context, int i) {
            return b.a(context);
        }

        public void a(int i) {
            for (int i2 = 0; i2 < getCount(); i2++) {
                if (((UserBriefInfo) getItem(i2)).getShopId() == i) {
                    ((UserBriefInfo) getItem(i2)).setFollowed(true);
                    return;
                }
            }
        }
    }

    public void i() {
        this.q.c();
    }

    public void j() {
        this.q.b();
    }
}
