package com.shopee.shopeetracker.utils;

import com.google.a.o;
import com.shopee.shopeetracker.model.InfoV3;
import com.shopee.shopeetracker.model.TrackingEventV3;
import com.shopee.shopeetracker.model.UserActionV3;
import com.shopee.shopeetracker.model.ViewCommon;
import java.util.List;

public class BiTrackerV3 {
    private final String mPageId;
    private final String mPageType;

    public BiTrackerV3(String str, String str2) {
        this.mPageId = str;
        this.mPageType = str2;
    }

    public void trackClick(String str, String str2, o oVar, String str3) {
        UserActionV3.create(new TrackingEventV3(this.mPageId, InfoV3.click(InfoV3.InfoBuilder.getInstance().withTargetType(str).withPageSection(str2).withPageType(str3), oVar))).log();
    }

    public void trackClick(String str, String str2, o oVar, String str3, int i) {
        UserActionV3.create(new TrackingEventV3(this.mPageId, InfoV3.click(InfoV3.InfoBuilder.getInstance().withTargetType(str).withPageSection(str2).withPageType(str3).withUsageId(i), oVar))).log();
    }

    public void trackImpression(String str, String str2, String str3, List<o> list) {
        trackImpression(str, str2, str3, 0, list);
    }

    public void trackImpression(String str, String str2, String str3, int i, List<o> list) {
        UserActionV3.create(new TrackingEventV3(this.mPageId, InfoV3.impression(InfoV3.InfoBuilder.getInstance().withTargetType(str).withPageSection(str2).withPageType(str3), list))).log();
    }

    public void trackPageView(String str, ViewCommon viewCommon, o oVar) {
        trackPageView(str, 0, viewCommon, oVar);
    }

    public void trackPageView(String str, int i, ViewCommon viewCommon, o oVar) {
        UserActionV3.create(new TrackingEventV3(this.mPageId, InfoV3.view(InfoV3.InfoBuilder.getInstance().withPageType(str), viewCommon, oVar))).log();
    }
}
