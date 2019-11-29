package com.shopee.app.ui.tracklog;

import com.shopee.app.tracking.trackingv3.model.TrackingEvent;
import com.shopee.app.tracking.trackingv3.model.UserActionV3;
import com.shopee.app.web.WebRegister;
import com.shopee.shopeetracker.model.UserAction;
import d.d.b.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class c {
    public static final g a(g gVar) {
        j.b(gVar, "trackBadgeStatus");
        try {
            UserActionV3[] userActionV3Arr = (UserActionV3[]) WebRegister.GSON.a(gVar.f25659f, UserActionV3[].class);
            j.a((Object) userActionV3Arr, "userActions");
            Collection arrayList = new ArrayList();
            for (UserActionV3 userActionV3 : userActionV3Arr) {
                if (a((UserAction) userActionV3) == -1) {
                    arrayList.add(userActionV3);
                }
            }
            gVar.f25659f = WebRegister.GSON.b((Object) (List) arrayList);
            gVar.f25660g = -1;
        } catch (Exception unused) {
        }
        return gVar;
    }

    public static final int a(UserAction userAction) {
        j.b(userAction, "userAction");
        try {
            if (((TrackingEvent) WebRegister.GSON.a(userAction.getActionData(), TrackingEvent.class)).isV3Event()) {
                return -1;
            }
        } catch (Exception unused) {
        }
        return userAction.getType();
    }
}
