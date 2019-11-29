package com.shopee.app.ui.home.e;

import com.facebook.places.model.PlaceFields;
import com.google.a.o;
import com.shopee.app.tracking.trackingv3.model.Info;
import com.shopee.app.tracking.trackingv3.model.TrackingEvent;
import com.shopee.app.tracking.trackingv3.model.UserActionV3;
import d.d.b.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f22195a = new a();

    private a() {
    }

    public final void a(com.shopee.app.ui.home.a aVar) {
        j.b(aVar, "navData");
        o oVar = new o();
        oVar.a(PlaceFields.LOCATION, (Number) Integer.valueOf(aVar.getPos()));
        oVar.a("tab_name", b(aVar));
        UserActionV3.Companion.create(new TrackingEvent("", Info.InfoBuilder.Companion.builder().withTargetType("").withOperation("action_click_navigation_bar_button").withData(oVar).build())).log();
    }

    private final String b(com.shopee.app.ui.home.a aVar) {
        switch (b.f22196a[aVar.ordinal()]) {
            case 1:
                return "home";
            case 2:
                return "feed";
            case 3:
                return "shopee_live";
            case 4:
                return "mall";
            case 5:
                return "notification";
            case 6:
                return "me";
            default:
                return "";
        }
    }
}
