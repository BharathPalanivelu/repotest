package com.shopee.app.ui.follow.search;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SearchHistoryData;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.tracking.f;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.common.p;
import com.shopee.app.ui.follow.following.c;
import com.shopee.app.ui.follow.following.j;
import com.shopee.app.ui.follow.following.m;
import com.shopee.app.ui.follow.following.t;
import com.shopee.app.util.af;
import com.shopee.app.util.ak;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class k extends q<m> implements p.a {
    private e A = new g() {
        public void onEvent(a aVar) {
            k.this.h();
        }
    };
    private e B = new g() {
        public void onEvent(a aVar) {
            if (aVar.data != null && (aVar.data instanceof Pair)) {
                Pair pair = (Pair) aVar.data;
                if (k.this.p == null || !k.this.p.equals(pair.first)) {
                    k.this.n.clear();
                    return;
                }
                k.this.n.addAll((List) pair.second);
                ((m) k.this.f19220b).a((List<UserBriefInfo>) new ArrayList(k.this.n));
                if (k.this.n.isEmpty()) {
                    ((m) k.this.f19220b).b();
                }
                k.this.o.a("HIDE_SEARCH_PROGRESS", new a());
                if (k.this.n.size() + 1 == k.this.l) {
                    ((m) k.this.f19220b).i();
                } else {
                    ((m) k.this.f19220b).j();
                }
            }
        }
    };
    private e C = new g() {
        public void onEvent(a aVar) {
            if (k.this.n == null || k.this.n.size() <= 0) {
                ((m) k.this.f19220b).a((List<UserBriefInfo>) new ArrayList());
                ((m) k.this.f19220b).b();
            } else if (k.this.n.size() + 1 == k.this.l) {
                ((m) k.this.f19220b).i();
            } else {
                ((m) k.this.f19220b).j();
            }
            k.this.o.a("HIDE_SEARCH_PROGRESS", new a());
        }
    };
    private e D = new g() {
        public void onEvent(a aVar) {
            k.this.o.a("HIDE_SEARCH_PROGRESS", new a());
        }
    };
    private e E = new g() {
        public void onEvent(a aVar) {
            ((m) k.this.f19220b).x_();
            int intValue = ((Integer) aVar.data).intValue();
            k.this.b(k.this.f21800e.a(intValue).a(), intValue);
        }
    };
    private e F = new g() {
        public void onEvent(a aVar) {
            k.this.f21802g.a((String) aVar.data);
        }
    };
    private e G = new g() {
        public void onEvent(a aVar) {
            ((m) k.this.f19220b).d();
            if (aVar.data != null && (aVar.data instanceof String)) {
                String str = (String) aVar.data;
                if (k.this.f21797a.containsKey(str)) {
                    ((m) k.this.f19220b).b(k.this.f21797a.get(str).intValue());
                    k.this.c(str);
                }
            }
        }
    };
    private e H = new g() {
        public void onEvent(a aVar) {
            if (aVar.data != null && (aVar.data instanceof List)) {
                List unused = k.this.u = (List) aVar.data;
                k kVar = k.this;
                List unused2 = kVar.s = af.a(kVar.u, new af.b<String, t>() {
                    /* renamed from: a */
                    public String map(t tVar) {
                        return tVar.f();
                    }
                });
                if (TextUtils.isEmpty(k.this.p)) {
                    k.this.f();
                }
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    Map<String, Integer> f21797a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final n f21798c;

    /* renamed from: d  reason: collision with root package name */
    private final j f21799d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final c f21800e;

    /* renamed from: f  reason: collision with root package name */
    private final j f21801f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final m f21802g;
    /* access modifiers changed from: private */
    public final SearchKeywordsStore h;
    private final ak i;
    private final f j;
    private final UserInfo k;
    /* access modifiers changed from: private */
    public int l;
    private int m = 0;
    /* access modifiers changed from: private */
    public Set<UserBriefInfo> n = new LinkedHashSet();
    /* access modifiers changed from: private */
    public final bi o;
    /* access modifiers changed from: private */
    public String p;
    private boolean q;
    private int r;
    /* access modifiers changed from: private */
    public List<String> s = new ArrayList();
    private List<SearchProductItem> t;
    /* access modifiers changed from: private */
    public List<t> u;
    private boolean v;
    private final i w;
    private e x = new g() {
        public void onEvent(a aVar) {
            ((m) k.this.f19220b).g();
            if (k.this.b((String) aVar.data)) {
                k.this.o.a("SHOW_SEARCH_PROGRESS", new a());
                return;
            }
            ((m) k.this.f19220b).a((List<UserBriefInfo>) new ArrayList());
            k.this.f();
        }
    };
    private e y = new g() {
        public void onEvent(a aVar) {
            if (k.this.b((String) aVar.data)) {
                k.this.h.addShopHistory((String) aVar.data);
                k.this.o.a("SHOW_SEARCH_PROGRESS", new a());
                return;
            }
            ((m) k.this.f19220b).a((List<UserBriefInfo>) new ArrayList());
            k.this.f();
        }
    };
    private e z = new g() {
        public void onEvent(a aVar) {
            ((m) k.this.f19220b).a((List<UserBriefInfo>) new ArrayList());
            k.this.f();
            k.this.o.a("HIDE_SEARCH_PROGRESS", new a());
        }
    };

    public k(n nVar, bi biVar, c cVar, j jVar, SearchKeywordsStore searchKeywordsStore, ak akVar, f fVar, UserInfo userInfo, m mVar, j jVar2) {
        this.f21798c = nVar;
        this.o = biVar;
        this.f21799d = jVar;
        this.f21800e = cVar;
        this.h = searchKeywordsStore;
        this.f21801f = jVar2;
        this.i = akVar;
        this.f21802g = mVar;
        this.j = fVar;
        this.k = userInfo;
        this.w = b.a(this);
    }

    /* access modifiers changed from: private */
    public boolean b(String str) {
        if (!str.equals(this.p) || this.m == 0) {
            this.n.clear();
            this.m = 0;
            this.p = str;
        }
        if (TextUtils.isEmpty(this.p)) {
            return false;
        }
        if (!this.v) {
            this.v = true;
        }
        Set<UserBriefInfo> set = this.n;
        if (set == null || set.isEmpty()) {
            this.f21799d.a(str, 20, 0, this.r, this.q);
        } else {
            this.f21799d.a(str, 20, this.m, this.r, this.q);
        }
        return true;
    }

    public void a() {
        this.w.a();
        this.f21798c.a("SEARCH_USER_LOAD", this.B);
        this.f21798c.a("SEARCH_USER_EMPTY", this.C);
        this.f21798c.a("SEARCH_USER_ERROR", this.D);
        this.f21798c.a("FOLLOW_SUCCESS", this.G);
        this.f21798c.a("BATCH_ITEM_LOAD", this.F);
        this.f21798c.a("GET_REC_FRIEND_LIST", this.H);
    }

    public void c() {
        this.o.a("FOLLOW_SHOP_REQUEST", this.E);
        this.o.a("SEARCH_TEXT_CHANGED", this.x);
        this.o.a("SEARCH_TEXT_DONE", this.y);
        this.o.a("SEARCH_TEXT_CANCELLED", this.z);
        this.o.a("CLEAR", this.A);
    }

    public void d() {
        this.o.b("FOLLOW_SHOP_REQUEST", this.E);
        this.o.b("SEARCH_TEXT_CHANGED", this.x);
        this.o.b("SEARCH_TEXT_DONE", this.y);
        this.o.b("SEARCH_TEXT_CANCELLED", this.z);
        this.o.b("CLEAR", this.A);
        ((m) this.f19220b).h();
    }

    public void b() {
        this.w.b();
        this.f21798c.b("SEARCH_USER_LOAD", this.B);
        this.f21798c.b("SEARCH_USER_EMPTY", this.C);
        this.f21798c.b("SEARCH_USER_ERROR", this.D);
        this.f21798c.b("FOLLOW_SUCCESS", this.G);
        this.f21798c.b("BATCH_ITEM_LOAD", this.F);
        this.f21798c.b("GET_REC_FRIEND_LIST", this.H);
    }

    public void a(String str, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            this.q = z2;
            b(str);
            this.o.a("SHOW_SEARCH_PROGRESS", new a());
            return;
        }
        f();
    }

    public void e() {
        this.f21801f.a();
    }

    private SearchProductItem j() {
        if (this.s.size() <= 0) {
            return null;
        }
        SearchProductItem searchProductItem = new SearchProductItem();
        searchProductItem.setKeyword(com.garena.android.appkit.tools.b.e(R.string.sp_recommended_shops));
        List<String> list = this.s;
        searchProductItem.setKeywords(list.subList(0, Math.min(list.size(), 20)));
        searchProductItem.setType(1);
        return searchProductItem;
    }

    public void f() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(e.a(this.h.getUserHistory(), 3));
        if (!this.s.isEmpty()) {
            arrayList.add(j());
        }
        this.t = arrayList;
        ((m) this.f19220b).b((List<SearchProductItem>) arrayList);
    }

    /* access modifiers changed from: protected */
    public String g() {
        return this.p;
    }

    /* access modifiers changed from: private */
    public void b(String str, int i2) {
        if (str != null) {
            this.f21797a.put(str, Integer.valueOf(i2));
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        if (str != null) {
            this.f21797a.remove(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(com.shopee.app.network.c.d.a aVar) {
        String str;
        if (!TextUtils.isEmpty(aVar.f17893b)) {
            str = aVar.f17893b;
        } else {
            int i2 = aVar.f17892a;
            if (i2 == -100) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_network_error);
            } else if (i2 == 3) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_err_follow_limit);
            } else if (i2 != 15) {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_unknown_error);
            } else {
                str = com.garena.android.appkit.tools.b.e(R.string.sp_err_frequent);
            }
        }
        ((m) this.f19220b).a(str);
    }

    public void c(int i2) {
        this.l = i2;
        this.m += 20;
        b(this.p);
    }

    public void a(int i2) {
        this.r = i2;
    }

    public void a(String str, int i2, int i3) {
        this.h.addUserHistory(str, i2, i3);
    }

    public void h() {
        this.h.clearUserHistory();
        f();
    }

    public void i() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(e.a(this.h.getUserHistory(), -1));
        if (!this.s.isEmpty()) {
            arrayList.add(j());
        }
        this.t = arrayList;
        ((m) this.f19220b).b((List<SearchProductItem>) arrayList);
    }

    public void a(String str, int i2) {
        ((m) this.f19220b).c(i2);
        this.h.addUserHistory(str, i2);
    }

    public void a(SearchHistoryData searchHistoryData) {
        if (searchHistoryData.getShopId() > 0) {
            ((m) this.f19220b).c(searchHistoryData.getShopId());
        } else {
            ((m) this.f19220b).d(searchHistoryData.getUserId());
        }
        this.h.addUserHistory(searchHistoryData.getKeyword(), searchHistoryData.getUserId(), searchHistoryData.getShopId());
    }

    public void a(String str) {
        List<t> list = this.u;
        if (list != null) {
            for (t next : list) {
                if (next.f().equals(str)) {
                    a(str, next.a());
                    return;
                }
            }
        }
    }
}
