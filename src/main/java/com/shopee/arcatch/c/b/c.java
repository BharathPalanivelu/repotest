package com.shopee.arcatch.c.b;

import com.google.a.o;

public class c {
    public static void a(long j) {
        d dVar = new d();
        dVar.f26739c = "download_end";
        dVar.f26741e = "action_game_monitor";
        o a2 = a();
        b.a().a(a2);
        a2.a("download_time", (Number) Long.valueOf(j));
        a(dVar, a2);
    }

    public static void a(String str) {
        d dVar = new d();
        dVar.f26739c = "resource_download_failed";
        dVar.f26741e = "action_game_monitor";
        o a2 = a();
        b.a().a(a2);
        a2.a("failed_url", str);
        a(dVar, a2);
    }

    public static void b(String str) {
        d dVar = new d();
        dVar.f26739c = "model_params_error";
        dVar.f26741e = "action_game_monitor";
        o a2 = a();
        b.a().a(a2);
        a2.a("error_msg", str);
        a(dVar, a2);
    }

    public static void a(String str, int i) {
        d dVar = new d();
        dVar.f26739c = "app_start_failed";
        dVar.f26741e = "action_game_monitor";
        o a2 = a();
        b.a().a(a2);
        a2.a("error_msg", str);
        a2.a("failed_type", (Number) Integer.valueOf(i));
        a(dVar, a2);
    }

    private static o a() {
        return b.a().c();
    }

    private static void a(d dVar, o oVar) {
        b.a().a(dVar, oVar);
    }
}
