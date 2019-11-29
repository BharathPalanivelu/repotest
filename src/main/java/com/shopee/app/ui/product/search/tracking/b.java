package com.shopee.app.ui.product.search.tracking;

import android.widget.ListView;
import com.google.a.o;
import com.shopee.app.data.viewmodel.CuratedHint;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.tracking.ImpressionObserver;
import com.shopee.app.tracking.trackingv3.model.Info;
import com.shopee.shopeetracker.utils.Logger;
import d.d.b.j;
import d.d.b.k;
import d.d.b.m;
import d.d.b.n;
import d.d.b.p;
import d.f;
import d.f.e;
import java.util.ArrayList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ e[] f24880a = {p.a((m) new n(p.a(b.class), "impressionObserver", "getImpressionObserver()Lcom/shopee/app/tracking/ImpressionObserver;"))};

    /* renamed from: b  reason: collision with root package name */
    private final String f24881b = "hint_keyword";

    /* renamed from: c  reason: collision with root package name */
    private final String f24882c = "search_bar";

    /* renamed from: d  reason: collision with root package name */
    private final String f24883d = "pre_search";

    /* renamed from: e  reason: collision with root package name */
    private final d.e f24884e;

    /* renamed from: f  reason: collision with root package name */
    private com.shopee.app.ui.product.search.a.a f24885f;

    /* renamed from: g  reason: collision with root package name */
    private final List<C0382b> f24886g;
    /* access modifiers changed from: private */
    public final com.shopee.app.tracking.c h;
    /* access modifiers changed from: private */
    public final com.shopee.app.tracking.trackingv3.b i;

    /* renamed from: com.shopee.app.ui.product.search.tracking.b$b  reason: collision with other inner class name */
    private interface C0382b {
        void a(int i, SearchProductItem searchProductItem, int i2);

        void a(com.shopee.app.tracking.c cVar, com.shopee.app.tracking.trackingv3.b bVar);
    }

    public final ImpressionObserver a() {
        d.e eVar = this.f24884e;
        e eVar2 = f24880a[0];
        return (ImpressionObserver) eVar.a();
    }

    public b(ListView listView, com.shopee.app.tracking.c cVar, com.shopee.app.tracking.trackingv3.b bVar, com.shopee.app.a.a.a aVar) {
        j.b(listView, "listView");
        j.b(cVar, "biTracker");
        j.b(bVar, "biTrackerV3");
        j.b(aVar, "lifeCycleManager");
        this.h = cVar;
        this.i = bVar;
        this.f24884e = f.a(new d(this, listView, aVar));
        List<C0382b> arrayList = new ArrayList<>();
        arrayList.add(new a());
        arrayList.add(new c());
        this.f24886g = arrayList;
    }

    static final class d extends k implements d.d.a.a<SearchProductImpressionObserver> {
        final /* synthetic */ com.shopee.app.a.a.a $lifeCycleManager;
        final /* synthetic */ ListView $listView;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar, ListView listView, com.shopee.app.a.a.a aVar) {
            super(0);
            this.this$0 = bVar;
            this.$listView = listView;
            this.$lifeCycleManager = aVar;
        }

        /* renamed from: a */
        public final SearchProductImpressionObserver invoke() {
            SearchProductImpressionObserver searchProductImpressionObserver = new SearchProductImpressionObserver(this.$listView, this.this$0.h, this.this$0.i, this.this$0);
            this.$lifeCycleManager.a(searchProductImpressionObserver);
            return searchProductImpressionObserver;
        }
    }

    public final void a(com.shopee.app.ui.product.search.a.a aVar) {
        this.f24885f = aVar;
    }

    public final void a(SearchProductItem searchProductItem, int i2) {
        j.b(searchProductItem, "item");
        String a2 = a.a(searchProductItem);
        if (a2 != null) {
            com.shopee.app.ui.product.search.a.a aVar = this.f24885f;
            o a3 = a.a(searchProductItem, i2, a2, aVar != null ? aVar.b() : 0);
            Logger.debug("Hint click: " + a3);
            this.i.a(this.f24881b, this.f24882c, a3, this.f24883d);
        }
    }

    public final void b() {
        a().a();
    }

    public final void a(int i2) {
        com.shopee.app.ui.product.search.a.a aVar = this.f24885f;
        if (aVar != null && i2 >= 0 && i2 < aVar.getCount()) {
            SearchProductItem searchProductItem = (SearchProductItem) aVar.getItem(i2);
            if (searchProductItem != null) {
                for (C0382b a2 : this.f24886g) {
                    a2.a(i2, searchProductItem, aVar.b());
                }
            }
        }
    }

    public final void c() {
        for (C0382b a2 : this.f24886g) {
            a2.a(this.h, this.i);
        }
    }

    private static final class a implements C0382b {

        /* renamed from: a  reason: collision with root package name */
        private final List<o> f24887a = new ArrayList();

        public ImpressionObserver.b a() {
            return new ImpressionObserver.b("curated_search", "search_bar", (String) null);
        }

        public void a(int i, SearchProductItem searchProductItem, int i2) {
            j.b(searchProductItem, "searchItem");
            Object extra = searchProductItem.getExtra();
            if ((extra instanceof CuratedHint) && searchProductItem.getType() == 14) {
                StringBuilder sb = new StringBuilder();
                sb.append("CuratedHint impression ");
                CuratedHint curatedHint = (CuratedHint) extra;
                sb.append(curatedHint.getName());
                sb.append(" keyword=");
                sb.append(searchProductItem.getKeyword());
                Logger.debug(sb.toString());
                this.f24887a.add(a.a(curatedHint, -1, i, searchProductItem));
            }
        }

        public void a(com.shopee.app.tracking.c cVar, com.shopee.app.tracking.trackingv3.b bVar) {
            j.b(bVar, "biTrackerV3");
            if (this.f24887a.size() > 0) {
                ImpressionObserver.b a2 = a();
                bVar.a(Info.InfoBuilder.Companion.builder().withPageSection(a2.b()).withTargetType(a2.a()), this.f24887a);
                this.f24887a.clear();
            }
        }
    }

    private static final class c implements C0382b {

        /* renamed from: a  reason: collision with root package name */
        private final List<o> f24888a = new ArrayList();

        public ImpressionObserver.b a() {
            return new ImpressionObserver.b("hint_keyword", "search_bar", (String) null);
        }

        public void a(int i, SearchProductItem searchProductItem, int i2) {
            j.b(searchProductItem, "searchItem");
            String a2 = a.a(searchProductItem);
            if (a2 != null) {
                o a3 = a.a(searchProductItem, i, a2, i2);
                this.f24888a.add(a3);
                Logger.debug("Hint impression: " + a3);
            }
        }

        public void a(com.shopee.app.tracking.c cVar, com.shopee.app.tracking.trackingv3.b bVar) {
            j.b(bVar, "biTrackerV3");
            if (this.f24888a.size() > 0) {
                ImpressionObserver.b a2 = a();
                bVar.a(Info.InfoBuilder.Companion.builder().withPageSection(a2.b()).withTargetType(a2.a()), this.f24888a);
                this.f24888a.clear();
            }
        }
    }
}
