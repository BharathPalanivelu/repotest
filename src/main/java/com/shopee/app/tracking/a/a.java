package com.shopee.app.tracking.a;

import androidx.recyclerview.widget.RecyclerView;
import com.facebook.places.model.PlaceFields;
import com.google.a.o;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.ActionContentInfo;
import com.shopee.app.data.viewmodel.ActivityItemInfo;
import com.shopee.app.tracking.impression.RecyclerViewImpressionObserver;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.tracking.trackingv3.model.Info;

public class a {
    public static String a(int i) {
        return i != 4 ? "" : "order_updates";
    }

    public static String a(int i, boolean z) {
        if (i == 1) {
            return "promotions";
        }
        if (i == 2) {
            return "seller_updates";
        }
        if (i == 3) {
            return z ? "seller_updates" : "activity";
        }
        if (i == 6) {
            return "shopee_updates";
        }
        if (i == 7) {
            return "rating_updates";
        }
        if (i == 8) {
            return "wallet_updates";
        }
        if (i != 10) {
            return null;
        }
        return "social_updates";
    }

    public static RecyclerViewImpressionObserver a(RecyclerView recyclerView, b bVar, int i, int i2) {
        RecyclerViewImpressionObserver recyclerViewImpressionObserver = new RecyclerViewImpressionObserver(recyclerView, bVar, Info.InfoBuilder.Companion.builder().withTargetType("action_required").withPageSection(a(i)).withPageType(a(bVar)));
        o oVar = new o();
        a(oVar, i, i2);
        recyclerViewImpressionObserver.a(oVar);
        return recyclerViewImpressionObserver;
    }

    public static void a(b bVar, int i, int i2) {
        o oVar = new o();
        a(oVar, i, i2);
        bVar.a("tab", "notification_folder_tab", oVar, "notification_folder");
    }

    public static void a(b bVar, int i, int i2, ActionContentInfo actionContentInfo, int i3, boolean z) {
        o trackingImpressionData = actionContentInfo.getTrackingImpressionData();
        a(trackingImpressionData, i, i2);
        if (z) {
            i3--;
        }
        trackingImpressionData.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i3));
        bVar.a("action_required", a(i), trackingImpressionData, a(bVar));
    }

    public static void a(b bVar, int i, int i2, ActivityItemInfo activityItemInfo) {
        o trackingImpressionData = activityItemInfo.getTrackingImpressionData();
        a(trackingImpressionData, i, i2);
        bVar.a("action_required", a(i), trackingImpressionData, a(bVar));
    }

    public static void a(b bVar, int i, int i2, ActionContentInfo actionContentInfo, boolean z, int i3, boolean z2) {
        o trackingImpressionData = actionContentInfo.getTrackingImpressionData();
        a(trackingImpressionData, i, i2);
        if (z2) {
            i3--;
        }
        trackingImpressionData.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i3));
        bVar.a("action_required_dropdown", "order_updates", trackingImpressionData, a(bVar));
    }

    public static String b(int i) {
        UserInfo loggedInUser = ar.f().e().loggedInUser();
        return loggedInUser != null && loggedInUser.isSeller() ? i == 0 ? "seller_info" : "activities" : i == 0 ? "all_activities" : "comments";
    }

    public static void a(b bVar, int i) {
        o oVar = new o();
        oVar.a("noti_folder", c(i));
        bVar.a("tab", "notification_folder", oVar, "notifications");
    }

    public static void a(o oVar, int i, int i2) {
        oVar.a("noti_folder", c(i));
        oVar.a("noti_folder_tab", a(i, i2));
    }

    public static String c(int i) {
        UserInfo loggedInUser = ar.f().e().loggedInUser();
        return a(i, loggedInUser != null && loggedInUser.isSeller());
    }

    public static String a(int i, int i2) {
        if (i == 2) {
            return "seller_info";
        }
        if (i != 3) {
            return "";
        }
        UserInfo loggedInUser = ar.f().e().loggedInUser();
        boolean z = loggedInUser != null && loggedInUser.isSeller();
        if (i2 != 4) {
            return z ? "activities" : "all_activities";
        }
        return "comments";
    }

    public static String a(b bVar) {
        if (bVar.a().equals("HomeActivity_")) {
            return "notifications";
        }
        return bVar.a();
    }
}
