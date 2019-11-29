package com.shopee.app.ui.product.search;

import android.text.TextUtils;
import android.util.Pair;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.google.a.o;
import com.shopee.app.data.store.SearchHistoryData;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.tracking.c;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.follow.search.d;
import com.shopee.app.ui.follow.search.f;
import com.shopee.app.ui.follow.search.j;
import com.shopee.app.ui.product.newsearch.b;
import com.shopee.app.util.af;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import com.shopee.app.web.protocol.SearchConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class l extends q<o> {

    /* renamed from: a  reason: collision with root package name */
    private final n f24846a;

    /* renamed from: c  reason: collision with root package name */
    private final d f24847c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final bi f24848d;

    /* renamed from: e  reason: collision with root package name */
    private final j f24849e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f24850f = "";

    /* renamed from: g  reason: collision with root package name */
    private final SearchKeywordsStore f24851g;
    /* access modifiers changed from: private */
    public int h;
    /* access modifiers changed from: private */
    public SearchConfig i;
    private i j;
    private List<UserBriefInfo> k = new ArrayList();
    /* access modifiers changed from: private */
    public List<SearchProductItem> l = new ArrayList();
    /* access modifiers changed from: private */
    public List<SearchProductItem> m = new ArrayList();
    private boolean n = false;
    private int o = -1;
    /* access modifiers changed from: private */
    public c p;
    private e q = new g() {
        public void onEvent(a aVar) {
            ((o) l.this.f19220b).f();
            String unused = l.this.f24850f = (String) aVar.data;
            ((o) l.this.f19220b).g();
            l lVar = l.this;
            if (lVar.b(lVar.e())) {
                l lVar2 = l.this;
                lVar2.a(lVar2.f24850f, 10, 0, l.this.h);
                l.this.f24848d.a("SHOW_SEARCH_PROGRESS", new a());
            }
            l lVar3 = l.this;
            if (lVar3.c(lVar3.e())) {
                l lVar4 = l.this;
                lVar4.a(lVar4.h);
            }
        }
    };
    private e r = new g() {
        public void onEvent(a aVar) {
            String unused = l.this.f24850f = (String) aVar.data;
            if (TextUtils.isEmpty(l.this.f24850f)) {
                SearchProductItem c2 = f.c(l.this.i);
                if (c2 != null) {
                    l.this.a(c2, "searchPrefillFirstItem", -1, -1, -1);
                    return;
                }
                return;
            }
            l.this.a("");
        }
    };
    private e s = new g() {
        public void onEvent(a aVar) {
            ((o) l.this.f19220b).f24872g.finish();
        }
    };
    private e t = new g() {
        public void onEvent(a aVar) {
            l.this.h();
        }
    };
    private e u = new g() {
        public void onEvent(a aVar) {
            l lVar = l.this;
            lVar.a(lVar.h);
        }
    };
    private e v = new g() {
        public void onEvent(a aVar) {
            if (aVar instanceof b) {
                b bVar = (b) aVar;
                if (bVar.f24685a != 0 && bVar.f24685a != 2) {
                    return;
                }
                if (l.this.f24850f == null || !l.this.e().equals(bVar.f24686b)) {
                    l.this.f24848d.a("HIDE_SEARCH_PROGRESS", new a());
                    return;
                }
                List unused = l.this.l = bVar.f24687c;
                if (l.this.i.isGlobalSearch() && (l.this.i.getExtInfo() == null || !"mall".equals(l.this.i.getExtInfo().getDomainType()))) {
                    List unused2 = l.this.m = bVar.f24688d;
                }
                ((o) l.this.f19220b).setVisibility(0);
                l.this.d(bVar.f24686b);
                o oVar = new o();
                oVar.a("isEmpty", Boolean.valueOf(af.a(bVar.f24687c)));
                l.this.p.b("search_hint_product", oVar);
            }
        }
    };
    private e w = new g() {
        public void onEvent(a aVar) {
            l.this.f24848d.a("HIDE_SEARCH_PROGRESS", new a());
        }
    };

    private int j() {
        return 0;
    }

    public l(n nVar, bi biVar, SearchKeywordsStore searchKeywordsStore, j jVar, d dVar, c cVar) {
        this.f24846a = nVar;
        this.f24848d = biVar;
        this.f24851g = searchKeywordsStore;
        this.f24849e = jVar;
        this.f24847c = dVar;
        this.p = cVar;
        this.j = com.garena.a.a.a.b.a(this);
    }

    public void a(SearchConfig searchConfig, int i2) {
        this.i = searchConfig;
        this.o = i2;
    }

    /* access modifiers changed from: private */
    public boolean b(String str) {
        if (!c(str)) {
            SearchConfig searchConfig = this.i;
            return searchConfig != null && !searchConfig.isHideSearchHints();
        }
    }

    /* access modifiers changed from: private */
    public boolean c(String str) {
        return str == null || TextUtils.isEmpty(str.trim());
    }

    public void a(String str, int i2, int i3, int i4) {
        this.f24850f = str;
        this.h = i4;
        if (!b(str)) {
            ((o) this.f19220b).a((List<SearchProductItem>) Collections.emptyList());
            return;
        }
        ((o) this.f19220b).h();
        this.f24847c.a(e(), i2, i3, i4, this.i.getSearchMatchType(), this.i.getSearchMatchValue());
        if (this.i.isGlobalSearch()) {
            this.k.clear();
            int i5 = this.o;
            this.f24849e.a(str, i2, i3, 0, i5 == 109 || i5 == -1);
        }
    }

    /* access modifiers changed from: protected */
    public String e() {
        String str = this.f24850f;
        if (str != null) {
            return str.replace("＃", "").replace("#", "");
        }
        return "";
    }

    public void a() {
        this.j.a();
        this.f24846a.a("SEARCH_HINT_LOAD", this.v);
        this.f24846a.a("SEARCH_HINT_ERROR", this.w);
    }

    public void c() {
        this.j.c();
        this.f24848d.a("SEARCH_TEXT_CHANGED", this.q);
        this.f24848d.a("SEARCH_TEXT_DONE", this.r);
        this.f24848d.a("SEARCH_TEXT_CANCELLED", this.s);
        this.f24848d.a("CLEAR", this.t);
        this.f24848d.a("LOAD_SEARCH_HIT", this.u);
    }

    public void d() {
        this.j.d();
        this.f24848d.b("SEARCH_TEXT_CHANGED", this.q);
        this.f24848d.b("SEARCH_TEXT_DONE", this.r);
        this.f24848d.b("SEARCH_TEXT_CANCELLED", this.s);
        this.f24848d.b("CLEAR", this.t);
        this.f24848d.b("LOAD_SEARCH_HIT", this.u);
    }

    public void b() {
        this.j.b();
        this.f24846a.b("SEARCH_HINT_LOAD", this.v);
        this.f24846a.b("SEARCH_HINT_ERROR", this.w);
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<String, List<UserBriefInfo>> pair) {
        String str = this.f24850f;
        if (str == null || !str.equals(pair.first)) {
            this.k.clear();
            return;
        }
        this.k.addAll((Collection) pair.second);
        ((o) this.f19220b).setVisibility(0);
        d((String) pair.first);
        o oVar = new o();
        oVar.a("isEmpty", Boolean.valueOf(af.a((List) pair.second)));
        this.p.b("search_hint_user", oVar);
    }

    /* access modifiers changed from: private */
    public void d(final String str) {
        ArrayList arrayList = new ArrayList();
        a(this.l, str);
        if (this.m.size() > 2) {
            arrayList.addAll(0, this.m.subList(0, 2));
        } else {
            arrayList.addAll(0, this.m);
        }
        boolean z = true;
        if (this.i.isGlobalSearch() && !af.a(this.k)) {
            int min = Math.min(this.k.size(), 5);
            int i2 = 10 - min;
            arrayList.addAll(this.l.size() > i2 ? this.l.subList(0, i2) : this.l);
            if (arrayList.size() > 0) {
                arrayList.add(com.shopee.app.ui.follow.search.e.a());
            }
            if (min >= this.k.size()) {
                z = false;
            }
            arrayList.add(com.shopee.app.ui.follow.search.e.a(str, z));
            arrayList.addAll(af.a(this.k.subList(0, min), new af.b<SearchProductItem, UserBriefInfo>() {
                /* renamed from: a */
                public SearchProductItem map(UserBriefInfo userBriefInfo) {
                    SearchProductItem searchProductItem = new SearchProductItem();
                    searchProductItem.setExtra(userBriefInfo);
                    searchProductItem.setType(10);
                    searchProductItem.setKeyword(str);
                    searchProductItem.setOriginalKeyword(userBriefInfo.getMatchKeyword());
                    return searchProductItem;
                }
            }));
        } else {
            arrayList.addAll(this.l.size() > 10 ? this.l.subList(0, 10) : this.l);
        }
        a((List<SearchProductItem>) arrayList);
        ((o) this.f19220b).a((List<SearchProductItem>) arrayList);
        this.f24848d.a("HIDE_SEARCH_PROGRESS", new a());
    }

    private void a(List<SearchProductItem> list, String str) {
        List<SearchHistoryData> list2;
        if (this.i.isGlobalSearch()) {
            list2 = this.f24851g.getProductHistory();
        } else {
            list2 = this.f24851g.getProductHistoryWithNoCategory();
        }
        for (SearchHistoryData next : list2) {
            if (next.getKeyword().toLowerCase().startsWith(str.toLowerCase())) {
                SearchProductItem searchProductItem = next.toSearchProductItem(str, next.isHashTagHint());
                searchProductItem.setExtra(next);
                if (list.contains(searchProductItem)) {
                    list.remove(searchProductItem);
                }
                list.add(0, searchProductItem);
                return;
            }
        }
    }

    public void a(String str) {
        a(SearchProductItem.from(e(), j()), str, -1, -1, -1);
    }

    public void a(SearchProductItem searchProductItem, String str, int i2, int i3, int i4) {
        this.f24848d.a("SEARCH_PRODUCT", (a) new c(((o) this.f19220b).hashCode(), searchProductItem, str, com.shopee.app.react.util.f.a(e(), i2, i3, i4, searchProductItem.isFromHistory())));
        this.f24848d.a("HIDE_SEARCH_PROGRESS", new a());
    }

    public void a(String str, int i2, int i3, int i4, int i5) {
        SearchProductItem searchProductItem = new SearchProductItem();
        searchProductItem.setKeyword(str);
        this.f24848d.a("SEARCH_PRODUCT", (a) new c(((o) this.f19220b).hashCode(), searchProductItem, i2, com.shopee.app.react.util.f.a(str, i3, i4, i5, searchProductItem.isFromHistory())));
        this.f24848d.a("HIDE_SEARCH_PROGRESS", new a());
    }

    public void a(int i2) {
        this.h = i2;
        ArrayList arrayList = new ArrayList();
        if (!this.i.isHideSearchHints()) {
            SearchProductItem c2 = f.c(this.i);
            if (c2 != null) {
                arrayList.add(c2);
            }
            arrayList.addAll(k());
        }
        arrayList.addAll(b(i2));
        ((o) this.f19220b).a((List<SearchProductItem>) arrayList);
    }

    private List<SearchProductItem> k() {
        if (this.i.isGlobalSearch()) {
            return com.shopee.app.ui.follow.search.e.a(this.f24851g.getProductHistoryWithShopHintAndCategory(), 3);
        }
        return com.shopee.app.ui.follow.search.e.a(this.f24851g.getProductHistoryWithNoCategory(), 3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.shopee.app.data.viewmodel.SearchProductItem> b(int r14) {
        /*
            r13 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.shopee.app.web.protocol.SearchConfig r1 = r13.i
            com.google.a.o r1 = r1.getSearchDefaultSuggestions()
            r2 = 0
            r3 = 2131888500(0x7f120974, float:1.9411637E38)
            if (r1 == 0) goto L_0x011a
            com.shopee.app.web.protocol.SearchConfig r1 = r13.i
            com.google.a.o r1 = r1.getSearchDefaultSuggestions()
            java.lang.String r4 = "list"
            boolean r1 = r1.b(r4)
            if (r1 == 0) goto L_0x011a
            com.shopee.app.web.protocol.SearchConfig r1 = r13.i
            com.google.a.o r1 = r1.getSearchDefaultSuggestions()
            java.lang.String r5 = "type"
            boolean r6 = r1.b(r5)
            java.lang.String r7 = "text"
            java.lang.String r8 = "title"
            if (r6 == 0) goto L_0x00a3
            com.google.a.l r6 = r1.c(r5)
            int r6 = r6.g()
            r9 = 1
            if (r6 != r9) goto L_0x00a3
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            com.google.a.l r4 = r1.c(r4)
            com.google.a.i r4 = r4.n()
            r9 = 0
        L_0x004f:
            int r10 = r4.a()
            if (r9 >= r10) goto L_0x007a
            com.google.a.l r10 = r4.a((int) r9)
            com.google.a.o r10 = r10.m()
            com.google.a.l r11 = r10.c(r7)
            java.lang.String r11 = r11.c()
            r5.add(r11)
            com.google.a.f r11 = com.shopee.app.web.WebRegister.GSON
            java.lang.String r10 = r10.toString()
            java.lang.Class<com.shopee.app.data.viewmodel.HotWordData> r12 = com.shopee.app.data.viewmodel.HotWordData.class
            java.lang.Object r10 = r11.a((java.lang.String) r10, r12)
            r6.add(r10)
            int r9 = r9 + 1
            goto L_0x004f
        L_0x007a:
            int r7 = r5.size()
            if (r7 <= 0) goto L_0x011b
            boolean r7 = r1.b(r8)
            if (r7 == 0) goto L_0x008f
            com.google.a.l r1 = r1.c(r8)
            java.lang.String r1 = r1.c()
            goto L_0x0093
        L_0x008f:
            java.lang.String r1 = com.garena.android.appkit.tools.b.e(r3)
        L_0x0093:
            com.shopee.app.data.viewmodel.SearchProductItem r7 = com.shopee.app.ui.follow.search.e.a()
            r0.add(r7)
            com.shopee.app.data.viewmodel.SearchProductItem r1 = com.shopee.app.ui.follow.search.e.a((java.util.List<java.lang.String>) r5, (java.lang.String) r1, (java.util.List<com.shopee.app.data.viewmodel.HotWordData>) r6)
            r0.add(r1)
            goto L_0x011b
        L_0x00a3:
            boolean r6 = r1.b(r5)
            if (r6 == 0) goto L_0x011a
            com.google.a.l r5 = r1.c(r5)
            int r5 = r5.g()
            r6 = 2
            if (r5 != r6) goto L_0x011a
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            com.google.a.l r4 = r1.c(r4)
            com.google.a.i r4 = r4.n()
            r9 = 0
        L_0x00c7:
            int r10 = r4.a()
            if (r9 >= r10) goto L_0x00f2
            com.google.a.l r10 = r4.a((int) r9)
            com.google.a.o r10 = r10.m()
            com.google.a.l r11 = r10.c(r7)
            java.lang.String r11 = r11.c()
            r5.add(r11)
            com.google.a.f r11 = com.shopee.app.web.WebRegister.GSON
            java.lang.String r10 = r10.toString()
            java.lang.Class<com.shopee.app.data.viewmodel.HotWordData> r12 = com.shopee.app.data.viewmodel.HotWordData.class
            java.lang.Object r10 = r11.a((java.lang.String) r10, r12)
            r6.add(r10)
            int r9 = r9 + 1
            goto L_0x00c7
        L_0x00f2:
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x011b
            boolean r5 = r1.b(r8)
            if (r5 == 0) goto L_0x0107
            com.google.a.l r1 = r1.c(r8)
            java.lang.String r1 = r1.c()
            goto L_0x010b
        L_0x0107:
            java.lang.String r1 = com.garena.android.appkit.tools.b.e(r3)
        L_0x010b:
            com.shopee.app.data.viewmodel.SearchProductItem r5 = com.shopee.app.ui.follow.search.e.a()
            r0.add(r5)
            com.shopee.app.data.viewmodel.SearchProductItem r1 = com.shopee.app.ui.follow.search.e.a((java.lang.String) r1, (java.util.List<com.shopee.app.data.viewmodel.HotWordData>) r6)
            r0.add(r1)
            goto L_0x011b
        L_0x011a:
            r4 = 0
        L_0x011b:
            if (r4 != 0) goto L_0x0199
            com.shopee.app.web.protocol.SearchConfig r1 = r13.i
            com.google.a.o r1 = r1.getSearchHotwords()
            if (r1 == 0) goto L_0x0141
            com.shopee.app.web.protocol.SearchConfig r1 = r13.i
            com.google.a.o r1 = r1.getSearchHotwords()
            java.lang.String r5 = "0"
            boolean r1 = r1.b(r5)
            if (r1 == 0) goto L_0x0141
            com.shopee.app.web.protocol.SearchConfig r1 = r13.i
            com.google.a.o r1 = r1.getSearchHotwords()
            com.google.a.l r1 = r1.c(r5)
            com.google.a.i r4 = r1.n()
        L_0x0141:
            if (r4 != 0) goto L_0x0168
            com.shopee.app.data.store.SearchKeywordsStore r1 = r13.f24851g
            java.util.List r1 = r1.getSearchKeywords(r14)
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0199
            com.shopee.app.data.viewmodel.SearchProductItem r1 = com.shopee.app.ui.follow.search.e.a()
            r0.add(r1)
            com.shopee.app.data.store.SearchKeywordsStore r1 = r13.f24851g
            java.util.List r14 = r1.getSearchKeywords(r14)
            java.lang.String r1 = com.garena.android.appkit.tools.b.e(r3)
            com.shopee.app.data.viewmodel.SearchProductItem r14 = com.shopee.app.ui.follow.search.e.a((java.util.List<java.lang.String>) r14, (java.lang.String) r1)
            r0.add(r14)
            goto L_0x0199
        L_0x0168:
            int r14 = r4.a()
            if (r14 <= 0) goto L_0x0199
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
        L_0x0173:
            int r1 = r4.a()
            if (r2 >= r1) goto L_0x0187
            com.google.a.l r1 = r4.a((int) r2)
            java.lang.String r1 = r1.c()
            r14.add(r1)
            int r2 = r2 + 1
            goto L_0x0173
        L_0x0187:
            com.shopee.app.data.viewmodel.SearchProductItem r1 = com.shopee.app.ui.follow.search.e.a()
            r0.add(r1)
            java.lang.String r1 = com.garena.android.appkit.tools.b.e(r3)
            com.shopee.app.data.viewmodel.SearchProductItem r14 = com.shopee.app.ui.follow.search.e.a((java.util.List<java.lang.String>) r14, (java.lang.String) r1)
            r0.add(r14)
        L_0x0199:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.product.search.l.b(int):java.util.List");
    }

    public void a(String str, String str2) {
        this.f24850f = str;
        a(str2);
    }

    public void f() {
        ArrayList arrayList = new ArrayList();
        SearchProductItem c2 = f.c(this.i);
        if (c2 != null) {
            arrayList.add(c2);
        }
        if (this.i.isGlobalSearch()) {
            arrayList.addAll(com.shopee.app.ui.follow.search.e.a(this.f24851g.getProductHistoryWithShopHintAndCategory(), -1));
        } else {
            arrayList.addAll(com.shopee.app.ui.follow.search.e.a(this.f24851g.getProductHistoryWithNoCategory(), -1));
        }
        arrayList.addAll(b(this.h));
        ((o) this.f19220b).a((List<SearchProductItem>) arrayList);
    }

    public void g() {
        this.n = true;
        d(this.f24850f);
    }

    public void h() {
        this.f24851g.clearProductHistory();
        this.f24851g.clearUserHistory();
        a(this.h);
    }

    private void a(List<SearchProductItem> list) {
        com.shopee.app.ui.follow.search.e.a(list, this.i.getSearchScope(), 0, this.f24850f, ((o) this.f19220b).f24866a);
    }

    public boolean i() {
        return !TextUtils.isDigitsOnly(this.f24850f);
    }
}
