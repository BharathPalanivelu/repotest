package com.shopee.app.ui.follow.search;

import android.text.TextUtils;
import com.garena.android.appkit.d.a;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.web.protocol.SearchConfig;

public class f {
    public static String a(SearchConfig searchConfig) {
        if (!(searchConfig == null || searchConfig.getSearchFirstPrefillItem() == null)) {
            try {
                return searchConfig.getSearchFirstPrefillItem().c("text").c();
            } catch (Exception e2) {
                a.a(e2);
            }
        }
        return "";
    }

    public static String b(SearchConfig searchConfig) {
        if (!(searchConfig == null || searchConfig.getSearchFirstPrefillItem() == null)) {
            try {
                return searchConfig.getSearchFirstPrefillItem().c("logo").c();
            } catch (Exception e2) {
                a.a(e2);
            }
        }
        return "";
    }

    public static SearchProductItem c(SearchConfig searchConfig) {
        String a2 = a(searchConfig);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        SearchProductItem searchProductItem = new SearchProductItem();
        searchProductItem.setType(12);
        searchProductItem.setKeyword(a2);
        searchProductItem.setLogoUrl(b(searchConfig));
        return searchProductItem;
    }
}
