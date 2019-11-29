package com.shopee.app.ui.image.a;

import android.text.TextUtils;
import com.google.a.l;
import com.google.a.o;
import com.google.a.q;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.tracking.trackingv3.model.Info;
import com.shopee.app.ui.image.MediaData;
import d.d.b.j;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f22736a;

    public a(b bVar) {
        j.b(bVar, "biTrackerV3");
        this.f22736a = bVar;
    }

    public final void a(MediaData mediaData, long j, long j2) {
        j.b(mediaData, "mediaData");
        o a2 = a(mediaData.getTrackingData());
        if (a2 != null) {
            o oVar = new o();
            oVar.a("video_duration", (Number) Long.valueOf(j2 - j));
            oVar.a("video_start_time", (Number) Long.valueOf(j));
            a(oVar, a2);
            this.f22736a.a("action_video_stop", a(a2), oVar);
        }
    }

    public final void a(MediaData mediaData) {
        j.b(mediaData, "mediaData");
        o a2 = a(mediaData.getTrackingData());
        if (a2 != null) {
            o oVar = new o();
            a(oVar, a2);
            this.f22736a.a("action_adjust_video_time", a(a2), oVar);
        }
    }

    private final o a(String str) {
        if (TextUtils.isEmpty(str)) {
            com.garena.b.a.a.a("ImageBrowserTracking", "Tracking fail because of missing pageType from bridge param");
            return null;
        }
        try {
            l a2 = new q().a(str);
            j.a((Object) a2, "JsonParser().parse(json)");
            o m = a2.m();
            if (m.b("pageType")) {
                return m;
            }
            return null;
        } catch (Exception e2) {
            com.beetalk.sdk.e.a.a(e2);
        }
    }

    private final void a(o oVar, o oVar2) {
        try {
            if (oVar2.b("customData")) {
                l c2 = oVar2.c("customData");
                j.a((Object) c2, "trackingData.get(\"customData\")");
                for (Map.Entry next : c2.m().a()) {
                    oVar.a((String) next.getKey(), (l) next.getValue());
                }
            }
        } catch (Exception e2) {
            com.garena.b.a.a.b("Invalid custom tracking data", (Throwable) e2);
        }
    }

    private final Info.InfoBuilder a(o oVar) {
        Info.InfoBuilder builder = Info.InfoBuilder.Companion.builder();
        try {
            l c2 = oVar.c("pageType");
            j.a((Object) c2, "trackingObject.get(\"pageType\")");
            String c3 = c2.c();
            j.a((Object) c3, "trackingObject.get(\"pageType\").asString");
            builder.withPageType(c3).withTargetType("video");
            if (oVar.b("pageSection")) {
                l c4 = oVar.c("pageSection");
                j.a((Object) c4, "trackingObject.get(\"pageSection\")");
                String c5 = c4.c();
                j.a((Object) c5, "trackingObject.get(\"pageSection\").asString");
                builder.withPageSection(c5);
            }
        } catch (Exception e2) {
            com.garena.b.a.a.b("Invalid custom tracking data", (Throwable) e2);
        }
        return builder;
    }
}
