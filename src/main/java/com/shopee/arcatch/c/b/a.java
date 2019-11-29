package com.shopee.arcatch.c.b;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.shopee.arcatch.data.data_tracking.TrackingProp;
import java.util.List;

public class a {
    public static void a() {
        d dVar = new d();
        dVar.f26741e = "view";
        o e2 = e();
        e2.a("arcatch_source", b.a().d());
        a(dVar, e2);
    }

    public static void a(List<TrackingProp> list, float f2) {
        d dVar = new d();
        dVar.f26740d = "caught_prop";
        dVar.f26741e = "action_game_end";
        o e2 = e();
        a(list, e2);
        e2.a("prop_value_amount", (Number) Float.valueOf(f2));
        b.a().a(e2);
        a(dVar, e2);
    }

    public static void b() {
        d dVar = new d();
        dVar.f26740d = "bgm_icon";
        dVar.f26741e = "click";
        a(dVar, e());
    }

    public static void a(List<TrackingProp> list, float f2, int i, String str, int i2) {
        d dVar = new d();
        dVar.f26739c = "end_failed";
        dVar.f26741e = "action_game_monitor";
        o e2 = e();
        o oVar = new o();
        oVar.a(NativeProtocol.BRIDGE_ARG_ERROR_CODE, (Number) Integer.valueOf(i));
        oVar.a("error_msg", str);
        oVar.a("net_status", (Number) Integer.valueOf(i2));
        e2.a(ShareConstants.FEED_SOURCE_PARAM, (l) oVar);
        a(list, e2);
        e2.a("prop_value_amount", (Number) Float.valueOf(f2));
        b.a().a(e2);
        a(dVar, e2);
    }

    public static void c() {
        d dVar = new d();
        dVar.f26739c = "game_page_background";
        dVar.f26741e = "action_game_monitor";
        o e2 = e();
        o oVar = new o();
        oVar.a("stay_time", (Number) Long.valueOf(System.currentTimeMillis() / 1000));
        e2.a(ShareConstants.FEED_SOURCE_PARAM, (l) oVar);
        b.a().a(e2);
        a(dVar, e2);
    }

    public static void a(boolean z) {
        a("record_video_permission", z);
    }

    public static void d() {
        a("record_video_permission");
    }

    private static void a(String str, boolean z) {
        d dVar = new d();
        dVar.f26739c = str;
        dVar.f26741e = "click";
        dVar.f26740d = z ? "agree" : "disagree";
        a(dVar, e());
    }

    private static void a(String str) {
        d dVar = new d();
        dVar.f26739c = str;
        dVar.f26741e = "impression";
        a(dVar, e());
    }

    private static o e() {
        return b.a().c();
    }

    private static void a(d dVar, o oVar) {
        b.a().a(dVar, oVar);
    }

    private static void a(List<TrackingProp> list, o oVar) {
        i iVar = new i();
        for (TrackingProp next : list) {
            o oVar2 = new o();
            oVar2.a("prop_id", next.propId);
            oVar2.a("quantity", (Number) Float.valueOf(next.quantity));
            oVar2.a("falling_count", (Number) Integer.valueOf(next.fallingCount));
            oVar2.a("prop_value", (Number) Float.valueOf(next.propValue));
            iVar.a((l) oVar2);
        }
        oVar.a("game_prop", (l) iVar);
    }
}
