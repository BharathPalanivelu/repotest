package com.shopee.navigator;

import com.google.a.l;
import com.google.a.o;

public abstract class b {
    public String toJson() {
        return a.f30102a.b((Object) this);
    }

    public o toJsonObject() {
        return a.f30102a.a((Object) this).m();
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        return a.f30102a.a(str, cls);
    }

    public static <T> T fromJson(o oVar, Class<T> cls) {
        return a.f30102a.a((l) oVar, cls);
    }
}
