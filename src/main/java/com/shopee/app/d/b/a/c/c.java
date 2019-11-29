package com.shopee.app.d.b.a.c;

import com.shopee.app.d.b.a.a;
import d.d.b.j;

public enum c {
    SHORT_TEXT(String.class),
    PRIMARY_BUTTON(a.C0251a.class),
    STATUS(String.class);
    
    private final Class<?> clazz;

    private c(Class<?> cls) {
        this.clazz = cls;
    }

    public final Class<?> getClazz() {
        return this.clazz;
    }

    public final Object getValue(Object obj) {
        Object cast = this.clazz.cast(obj);
        j.a((Object) cast, "clazz.cast(data)");
        return cast;
    }
}
