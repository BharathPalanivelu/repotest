package com.shopee.app.ui.product.newsearch.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.LinearLayout;
import com.facebook.share.internal.ShareConstants;
import com.garena.android.appkit.b.g;
import com.garena.android.uikit.a.a.a;
import com.shopee.app.data.store.SearchKeywordsStore;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.ui.follow.search.f;
import com.shopee.app.ui.product.search.c;
import com.shopee.app.ui.product.search.o;
import com.shopee.app.ui.product.search.p;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.web.protocol.SearchConfig;

public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    bi f24673a;

    /* renamed from: b  reason: collision with root package name */
    Activity f24674b;

    /* renamed from: c  reason: collision with root package name */
    SearchKeywordsStore f24675c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final o f24676d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final SearchConfig f24677e;

    /* renamed from: f  reason: collision with root package name */
    private com.garena.android.appkit.b.e f24678f = new g() {
        public void onEvent(com.garena.android.appkit.b.a aVar) {
            c cVar = (c) aVar;
            if (cVar.f24820b == e.this.f24676d.hashCode()) {
                SearchProductItem searchProductItem = (SearchProductItem) aVar.data;
                Intent intent = new Intent();
                intent.putExtra("type", searchProductItem.isHashTagHint() ? 2 : 0);
                intent.putExtra("defaultSuggestionsIndex", -1);
                intent.putExtra("scopeListIndex", cVar.f24821c);
                intent.putExtra("keyword", searchProductItem.getKeyword());
                intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, cVar.f24819a);
                intent.putExtra("cateId", searchProductItem.getCateId());
                intent.putExtra("cateName", searchProductItem.getCategoryName());
                intent.putExtra("tracking", cVar.a());
                String a2 = f.a(e.this.f24677e);
                if (a2 != null && !a2.equals(searchProductItem.getKeyword())) {
                    e.this.f24675c.addProductHistory(searchProductItem, 0);
                }
                e.this.f24674b.setResult(-1, intent);
                e.this.f24674b.finish();
            }
        }
    };

    public e(Context context, String str, SearchConfig searchConfig, int i) {
        super(context);
        this.f24677e = searchConfig;
        ((com.shopee.app.ui.product.newsearch.e) ((x) context).b()).a(this);
        this.f24676d = p.a(getContext(), str, searchConfig, i);
        addView(this.f24676d, new LinearLayout.LayoutParams(-1, -1));
    }

    public void a() {
        this.f24673a.a("SEARCH_PRODUCT", this.f24678f);
        this.f24676d.b();
    }

    public void b() {
        this.f24673a.b("SEARCH_PRODUCT", this.f24678f);
        this.f24676d.e();
    }
}
