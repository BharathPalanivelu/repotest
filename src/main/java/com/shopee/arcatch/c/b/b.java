package com.shopee.arcatch.c.b;

import com.google.a.o;
import com.shopee.sdk.modules.app.tracker.TrackingEvent;
import com.shopee.shopeetracker.EventSender;
import io.b.h.a;
import io.b.j;
import io.b.k;
import io.b.l;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f26730a;

    /* renamed from: b  reason: collision with root package name */
    private String f26731b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f26732c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f26733d = "";

    public static b a() {
        if (f26730a == null) {
            synchronized (b.class) {
                if (f26730a == null) {
                    f26730a = new b();
                }
            }
        }
        return f26730a;
    }

    private b() {
    }

    public void a(String str, String str2, String str3) {
        this.f26731b = str;
        this.f26732c = str2;
        this.f26733d = str3;
    }

    public void b() {
        this.f26731b = "";
        this.f26732c = "";
        this.f26733d = "";
    }

    public void a(final d dVar, final o oVar) {
        j.a(new l<Void>() {
            public void a(k<Void> kVar) {
                TrackingEvent.TrackingInfo.Builder pageSection = new TrackingEvent.TrackingInfo.Builder().data(oVar).operation(dVar.f26741e).pageSection(dVar.f26739c);
                dVar.getClass();
                com.shopee.sdk.b.a().j().logTrackingEvent(new TrackingEvent.Builder().info(pageSection.pageType("game_arcatch_game").targetType(dVar.f26740d).build()).type("v3").source("android").timestamp(System.currentTimeMillis()).build());
            }
        }).b(a.b()).h();
    }

    public o c() {
        o oVar = new o();
        oVar.a("arcatch_event_id", this.f26731b);
        oVar.a("arcatch_session_id", this.f26732c);
        return oVar;
    }

    public void a(o oVar) {
        oVar.a(EventSender.TRACKING_DATA_USAGE_ID, (Number) 1);
    }

    public String d() {
        return this.f26733d;
    }
}
