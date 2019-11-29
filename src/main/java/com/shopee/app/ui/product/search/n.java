package com.shopee.app.ui.product.search;

import android.content.Context;
import android.view.View;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.ui.a.s;
import com.shopee.app.ui.follow.search.e;
import com.shopee.app.ui.follow.search.g;
import com.shopee.app.ui.product.search.a;
import com.shopee.app.ui.product.search.b.c;
import com.shopee.app.ui.product.search.b.d;
import com.shopee.app.ui.product.search.j;
import com.shopee.app.web.protocol.SearchConfigExtInfo;
import com.shopee.id.R;

public class n implements s<SearchProductItem>, a.C0381a, j.b {

    /* renamed from: a  reason: collision with root package name */
    private e.a f24864a;

    /* renamed from: b  reason: collision with root package name */
    private b f24865b;

    public int a() {
        return 15;
    }

    public n(e.a aVar, b bVar) {
        this.f24864a = aVar;
        this.f24865b = bVar;
    }

    public int a(SearchProductItem searchProductItem, int i) {
        return searchProductItem.getType();
    }

    public View a(Context context, int i) {
        switch (i) {
            case 0:
            case 4:
            case 12:
                return e.a(context);
            case 1:
                j a2 = k.a(context);
                a2.setOnItemClickListener(this);
                return a2;
            case 2:
                return s.a(context);
            case 3:
            case 11:
                return g.a(context);
            case 5:
                return g.a(context);
            case 7:
                View view = new View(context);
                view.setMinimumHeight(b.a.h);
                view.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.background));
                return view;
            case 9:
                h a3 = i.a(context);
                a3.setLeftDrawable(R.drawable.ic_me_shop);
                return a3;
            case 10:
                return com.shopee.app.ui.follow.search.b.a(context);
            case 13:
                c a4 = d.a(context);
                a4.setOnItemClickListener(this);
                return a4;
            case 14:
                a a5 = b.a(context);
                a5.setOnClickListener(this);
                return a5;
            default:
                return i.a(context);
        }
    }

    public void a(View view, String str, int i, SearchProductItem searchProductItem) {
        com.shopee.app.c.a.a(view);
        e.a aVar = this.f24864a;
        if (aVar != null) {
            aVar.a(str, "hotwords");
            Context context = view.getContext();
            if (context instanceof com.shopee.app.ui.product.newsearch.c) {
                SearchConfigExtInfo extInfo = ((com.shopee.app.ui.product.newsearch.c) context).l().getExtInfo();
                if (extInfo != null) {
                    this.f24865b.a("keyword", "popular_searches", g.a(i, str, searchProductItem.getKeywordsTrackingData(), extInfo.getDomainType()));
                }
            }
        }
    }

    public void a(String str, String str2, int i, int i2, SearchProductItem searchProductItem) {
        e.a aVar = this.f24864a;
        if (aVar != null) {
            aVar.a(str, "curated");
            this.f24865b.a("curated_search", "search_bar", com.shopee.app.ui.product.search.tracking.a.a(str, str2, i, i2, searchProductItem), "pre_search");
        }
    }
}
