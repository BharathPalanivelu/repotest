package com.shopee.app.ui.product.search.tracking;

import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.facebook.react.uimanager.ViewProps;
import com.google.a.o;
import com.shopee.app.data.store.SearchHistoryData;
import com.shopee.app.data.viewmodel.CuratedHint;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import d.d.b.j;

public final class a {
    public static final String a(SearchProductItem searchProductItem) {
        j.b(searchProductItem, "searchItem");
        int type = searchProductItem.getType();
        if (type == 0) {
            return "hint";
        }
        if (type == 4) {
            Object extra = searchProductItem.getExtra();
            if (!(extra instanceof SearchHistoryData)) {
                extra = null;
            }
            SearchHistoryData searchHistoryData = (SearchHistoryData) extra;
            Integer valueOf = searchHistoryData != null ? Integer.valueOf(searchHistoryData.getType()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                return "history";
            }
            if (valueOf != null && valueOf.intValue() == 2) {
                return "shop_history";
            }
            return null;
        } else if (type == 10) {
            return "shop";
        } else {
            if (type != 12) {
                return null;
            }
            return "search_prefill";
        }
    }

    public static final o a(SearchProductItem searchProductItem, int i, String str, int i2) {
        j.b(searchProductItem, "searchItem");
        j.b(str, "type");
        o oVar = new o();
        oVar.a("user_input", searchProductItem.getOriginalKeyword());
        oVar.a("keyword", searchProductItem.getKeyword());
        oVar.a("absolute_location", (Number) Integer.valueOf(i));
        oVar.a("input_type", str);
        oVar.a("cat_id", (Number) Integer.valueOf(searchProductItem.getCateId()));
        if (!TextUtils.isEmpty(searchProductItem.getTrackingId())) {
            oVar.a("tracking_id", searchProductItem.getTrackingId());
        }
        if (searchProductItem.getHintSourceType() != -1) {
            oVar.a("keyword_source", (Number) Integer.valueOf(searchProductItem.getHintSourceType()));
        }
        a(searchProductItem, i, oVar, i2);
        return oVar;
    }

    public static final void a(SearchProductItem searchProductItem, int i, o oVar, int i2) {
        j.b(searchProductItem, "searchItem");
        j.b(oVar, "data");
        Object extra = searchProductItem.getExtra();
        if (searchProductItem.getType() == 10 && (extra instanceof UserBriefInfo)) {
            oVar.a("shopid", (Number) Integer.valueOf(((UserBriefInfo) extra).getShopId()));
            oVar.a("absolute_location", (Number) Integer.valueOf(i - i2));
        }
    }

    public static final o a(CuratedHint curatedHint, int i, int i2, SearchProductItem searchProductItem) {
        j.b(curatedHint, "curatedHint");
        j.b(searchProductItem, "searchProductItem");
        String url = curatedHint.getUrl();
        if (url == null) {
            url = "";
        }
        String name = curatedHint.getName();
        if (name == null) {
            name = "";
        }
        return a(url, name, i, i2, searchProductItem);
    }

    public static final o a(String str, String str2, int i, int i2, SearchProductItem searchProductItem) {
        j.b(str, "url");
        j.b(str2, "text");
        j.b(searchProductItem, "searchProductItem");
        o oVar = new o();
        oVar.a("user_input", searchProductItem.getOriginalKeyword());
        oVar.a("keyword", str2);
        oVar.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i2));
        if (i >= 0) {
            oVar.a(ViewProps.POSITION, (Number) Integer.valueOf(i));
        }
        oVar.a("url", str);
        return oVar;
    }
}
