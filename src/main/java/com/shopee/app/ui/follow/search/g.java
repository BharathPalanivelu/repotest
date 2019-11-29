package com.shopee.app.ui.follow.search;

import com.facebook.places.model.PlaceFields;
import com.google.a.o;
import com.shopee.app.data.viewmodel.HotWordData;
import java.util.List;

public final class g {
    public static final o a(int i, String str, List<HotWordData> list, String str2) {
        if (list == null || list.size() <= i) {
            return new o();
        }
        return a(i, str, list.get(i), str2);
    }

    public static final o a(int i, String str, HotWordData hotWordData, String str2) {
        o oVar = new o();
        oVar.a("keyword", str);
        oVar.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i));
        if (hotWordData != null) {
            oVar.a("concept_id", hotWordData.getConceptid());
            oVar.a("recommendation_algorithm", hotWordData.getRecommendation_algorithm());
            oVar.a("recommendation_info", hotWordData.getAlgorithm_info());
        }
        oVar.a("domain_type", str2);
        return oVar;
    }
}
