package com.shopee.app.ui.product.newsearch.a;

import com.shopee.app.data.viewmodel.HotWordData;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.ui.follow.search.g;
import com.shopee.app.web.protocol.SearchConfig;
import com.shopee.app.web.protocol.SearchConfigExtInfo;
import d.d.b.j;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f24659a;

    public a(b bVar) {
        j.b(bVar, "biTrackerV3");
        this.f24659a = bVar;
    }

    public final void a(SearchConfig searchConfig, String str, int i, SearchProductItem searchProductItem) {
        if (searchConfig != null && searchProductItem != null) {
            b bVar = this.f24659a;
            List<HotWordData> keywordsTrackingData = searchProductItem.getKeywordsTrackingData();
            SearchConfigExtInfo extInfo = searchConfig.getExtInfo();
            b.a(bVar, "keyword", "popular_searches", g.a(i, str, keywordsTrackingData, extInfo != null ? extInfo.getDomainType() : null), (String) null, 8, (Object) null);
        }
    }
}
