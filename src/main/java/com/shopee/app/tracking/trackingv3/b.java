package com.shopee.app.tracking.trackingv3;

import com.facebook.places.model.PlaceFields;
import com.google.a.o;
import com.shopee.app.tracking.trackingv3.model.Info;
import com.shopee.app.tracking.trackingv3.model.TrackingEvent;
import com.shopee.app.tracking.trackingv3.model.UserActionV3;
import com.shopee.app.tracking.trackingv3.model.ViewCommon;
import d.d.b.j;
import d.h.m;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final o f19172a = new o();

    /* renamed from: b  reason: collision with root package name */
    public static final a f19173b = new a((g) null);

    /* renamed from: c  reason: collision with root package name */
    private final String f19174c;

    /* renamed from: d  reason: collision with root package name */
    private final String f19175d;

    public static final o a(int i, long j, String str) {
        return f19173b.a(i, j, str);
    }

    public static final o a(long j, long j2) {
        return f19173b.a(j, j2);
    }

    public static final o a(String str) {
        return f19173b.a(str);
    }

    public static final o b(String str) {
        return f19173b.b(str);
    }

    public void a(String str, String str2, o oVar) {
        a(this, str, str2, oVar, (String) null, 8, (Object) null);
    }

    public b(String str, String str2) {
        j.b(str, "mPageId");
        j.b(str2, "mPageType");
        this.f19174c = str;
        this.f19175d = str2;
    }

    public final String a() {
        return this.f19175d;
    }

    public void a(String str, o oVar) {
        j.b(str, "targetType");
        j.b(oVar, "targetData");
        a(this, str, "", oVar, (String) null, 8, (Object) null);
    }

    public static /* synthetic */ void a(b bVar, String str, String str2, o oVar, String str3, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str2 = "";
            }
            if ((i & 4) != 0) {
                oVar = f19172a;
            }
            if ((i & 8) != 0) {
                str3 = bVar.f19175d;
            }
            bVar.a(str, str2, oVar, str3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackClick");
    }

    public void a(String str, String str2, o oVar, String str3) {
        j.b(str, "targetType");
        j.b(str2, "pageSection");
        j.b(oVar, "targetData");
        j.b(str3, "pageType");
        UserActionV3.Companion.create(new TrackingEvent(this.f19174c, Info.Companion.click(Info.InfoBuilder.Companion.builder().withTargetType(str).withPageSection(str2).withPageType(str3), oVar))).log();
    }

    public void b(String str, String str2, o oVar) {
        j.b(str, "pageType");
        j.b(str2, "actionName");
        j.b(oVar, "targetData");
        UserActionV3.Companion.create(new TrackingEvent(this.f19174c, Info.Companion.action(str2, Info.InfoBuilder.Companion.builder().withPageType(str), oVar))).log();
    }

    public void b(String str, o oVar) {
        j.b(str, "actionName");
        j.b(oVar, "targetData");
        UserActionV3.Companion.create(new TrackingEvent(this.f19174c, Info.Companion.action(str, Info.InfoBuilder.Companion.builder(), oVar))).log();
    }

    public void a(String str, String str2, String str3, o oVar) {
        j.b(str, "actionName");
        j.b(str2, "targetType");
        j.b(str3, "pageSection");
        j.b(oVar, "targetData");
        UserActionV3.Companion.create(new TrackingEvent(this.f19174c, Info.Companion.action(str, Info.InfoBuilder.Companion.builder().withTargetType(str2).withPageSection(str3).withPageType(this.f19175d), oVar))).log();
    }

    public void a(String str, Info.InfoBuilder infoBuilder, o oVar) {
        j.b(str, "actionName");
        j.b(infoBuilder, "builder");
        j.b(oVar, "targetData");
        UserActionV3.Companion.create(new TrackingEvent(this.f19174c, Info.Companion.action(str, infoBuilder, oVar))).log();
    }

    public final void a(Info.InfoBuilder infoBuilder, List<o> list) {
        j.b(infoBuilder, "infoBuilder");
        if (list != null && !list.isEmpty()) {
            String str = this.f19175d;
            CharSequence pageType = infoBuilder.getPageType();
            if (!(pageType == null || m.a(pageType))) {
                str = infoBuilder.getPageType();
                if (str == null) {
                    str = "";
                }
            }
            UserActionV3.Companion.create(new TrackingEvent(this.f19174c, Info.Companion.impression(infoBuilder.withPageType(str), list))).log();
        }
    }

    public void a(String str, String str2, List<o> list) {
        j.b(str, "targetType");
        j.b(str2, "pageSection");
        if (list != null && !list.isEmpty()) {
            UserActionV3.Companion.create(new TrackingEvent(this.f19174c, Info.Companion.impression(Info.InfoBuilder.Companion.builder().withTargetType(str).withPageSection(str2).withPageType(this.f19175d), list))).log();
        }
    }

    public void a(String str, String str2) {
        j.b(str, "pageType");
        j.b(str2, "targetType");
        UserActionV3.Companion.create(new TrackingEvent(this.f19174c, Info.Companion.impression(Info.InfoBuilder.Companion.builder().withTargetType(str2).withPageType(str), d.a.j.a(f19172a)))).log();
    }

    public void a(String str, ViewCommon viewCommon, o oVar) {
        j.b(str, "pageType");
        j.b(viewCommon, "viewCommon");
        UserActionV3.Companion.create(new TrackingEvent(this.f19174c, Info.Companion.view(Info.InfoBuilder.Companion.builder().withPageType(str), viewCommon, oVar))).log();
    }

    public void a(ViewCommon viewCommon, o oVar) {
        j.b(viewCommon, "viewCommon");
        a(this.f19175d, viewCommon, oVar);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final o a(long j, long j2) {
            o oVar = new o();
            oVar.a("itemid", (Number) Long.valueOf(j));
            oVar.a("shopid", (Number) Long.valueOf(j2));
            return oVar;
        }

        public final o a(int i, long j, String str) {
            j.b(str, "keyword");
            o oVar = new o();
            oVar.a(PlaceFields.LOCATION, (Number) Integer.valueOf(i));
            oVar.a("shopid", (Number) Long.valueOf(j));
            oVar.a("keyword", str);
            return oVar;
        }

        public final o a(String str) {
            j.b(str, "keyword");
            o oVar = new o();
            oVar.a("keyword", str);
            return oVar;
        }

        public final o b(String str) {
            j.b(str, "loginOption");
            o oVar = new o();
            oVar.a("login_option", str);
            return oVar;
        }
    }
}
