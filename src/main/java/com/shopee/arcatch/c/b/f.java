package com.shopee.arcatch.c.b;

import com.google.a.o;
import com.shopee.e.a.a;

public class f {
    public static void a(e eVar) {
        a.a((Object) eVar.toString());
        b a2 = b.a();
        d dVar = new d();
        dVar.f26739c = "end_analysis";
        dVar.f26741e = "action_game_monitor";
        o c2 = a2.c();
        b.a().a(c2);
        o oVar = c2;
        a(oVar, "cpu_rate", eVar.f26743b, eVar.f26742a, eVar.f26744c);
        a(oVar, "ram", eVar.f26746e, eVar.f26745d, eVar.f26747f);
        a(c2, "detect_time", eVar.j, eVar.i, eVar.k);
        a(c2, "app_frame_rate", eVar.m, eVar.l, eVar.n);
        a(c2, "game_frame_rate", eVar.p, eVar.o, eVar.q);
        a(c2, "phisics_copute_time", eVar.s, eVar.r, eVar.t);
        a(c2, "capture_interval", eVar.x, eVar.w, eVar.y);
        c2.a("capture_frame_rate", (Number) Float.valueOf(eVar.v));
        c2.a("resolution", eVar.u);
        a2.a(dVar, c2);
    }

    private static void a(o oVar, String str, float f2, float f3, float f4) {
        oVar.a(str + "_min", (Number) Float.valueOf(f2));
        oVar.a(str + "_max", (Number) Float.valueOf(f3));
        oVar.a(str + "_avg", (Number) Float.valueOf(f4));
    }

    private static void a(o oVar, String str, float f2, float f3, double d2) {
        oVar.a(str + "_min", (Number) Float.valueOf(f2));
        oVar.a(str + "_max", (Number) Float.valueOf(f3));
        oVar.a(str + "_avg", (Number) Double.valueOf(d2));
    }
}
