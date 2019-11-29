package com.shopee.sdk.b;

import com.google.a.l;
import com.google.a.o;

public abstract class a {
    public String toJson() {
        return com.shopee.sdk.f.a.f30357a.b((Object) this);
    }

    public o toJsonObject() {
        return com.shopee.sdk.f.a.f30357a.a((Object) this).m();
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        return com.shopee.sdk.f.a.f30357a.a(str, cls);
    }

    public static <T> T fromJson(o oVar, Class<T> cls) {
        return com.shopee.sdk.f.a.f30357a.a((l) oVar, cls);
    }
}
