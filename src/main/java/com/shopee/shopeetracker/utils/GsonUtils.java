package com.shopee.shopeetracker.utils;

import com.google.a.f;
import com.google.a.g;
import com.google.a.l;
import com.google.a.o;
import com.google.a.u;

public class GsonUtils {
    public static final f gson = new g().d();
    public static final f serializeNullsGson = new g().a().d();

    public static o fromString(String str) {
        try {
            return (o) gson.a(str, o.class);
        } catch (u e2) {
            e2.printStackTrace();
            return new o();
        } catch (Exception e3) {
            e3.printStackTrace();
            return new o();
        }
    }

    public static String fromEvent(o oVar) {
        return gson.a((l) oVar);
    }

    public static String toJson(Object obj, boolean z) {
        return (z ? serializeNullsGson : gson).b(obj);
    }
}
