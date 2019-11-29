package com.shopee.app.ui.product.add;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.follow.search.d;
import com.shopee.app.ui.product.newsearch.b;
import com.shopee.app.util.af;
import com.shopee.app.util.bi;
import com.shopee.app.util.n;
import java.util.ArrayList;

public class ae extends q<ad> {

    /* renamed from: a  reason: collision with root package name */
    private final n f23977a;

    /* renamed from: c  reason: collision with root package name */
    private final d f23978c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final bi f23979d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f23980e = "";

    /* renamed from: f  reason: collision with root package name */
    private final SearchKeywordsStore f23981f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f23982g;
    private e h = new g() {
        public void onEvent(a aVar) {
            if (aVar instanceof b) {
                b bVar = (b) aVar;
                if (ae.this.f23980e != null && ae.this.f23980e.equals(bVar.f24686b)) {
                    ((ad) ae.this.f19220b).a(af.a(bVar.f24687c, new af.b<SearchProductItem, SearchProductItem>() {
                        /* renamed from: a */
                        public SearchProductItem map(SearchProductItem searchProductItem) {
                            searchProductItem.setKeyword("#" + searchProductItem.getKeyword());
                            return searchProductItem;
                        }
                    }));
                    ae.this.f23979d.a("HIDE_SEARCH_PROGRESS", new a());
                }
            }
        }
    };
    private e i = new g() {
        public void onEvent(a aVar) {
            ae.this.f23979d.a("HIDE_SEARCH_PROGRESS", new a());
        }
    };
    private e j = new g() {
        public void onEvent(a aVar) {
            ae aeVar = ae.this;
            aeVar.a(aeVar.f23982g);
        }
    };
    private af.b<String, String> k = new af.b<String, String>() {
        /* renamed from: a */
        public String map(String str) {
            if (str.startsWith("#")) {
                return str;
            }
            return "#" + str;
        }
    };

    public ae(n nVar, bi biVar, SearchKeywordsStore searchKeywordsStore, d dVar) {
        this.f23977a = nVar;
        this.f23979d = biVar;
        this.f23981f = searchKeywordsStore;
        this.f23978c = dVar;
    }

    public void a() {
        this.f23977a.a("SEARCH_HINT_LOAD", this.h);
        this.f23977a.a("SEARCH_HINT_ERROR", this.i);
        this.f23977a.a("HOT_HASH_TAG_DOWNLOAD", this.j);
    }

    public void b() {
        this.f23977a.b("SEARCH_HINT_LOAD", this.h);
        this.f23977a.b("SEARCH_HINT_ERROR", this.i);
        this.f23977a.b("HOT_HASH_TAG_DOWNLOAD", this.j);
    }

    public void a(int i2) {
        this.f23982g = i2;
        ((ad) this.f19220b).a(new ArrayList());
    }
}
