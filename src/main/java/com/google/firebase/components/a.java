package com.google.firebase.components;

import java.util.Set;

abstract class a implements e {
    a() {
    }

    public <T> T a(Class<T> cls) {
        com.google.firebase.b.a<T> c2 = c(cls);
        if (c2 == null) {
            return null;
        }
        return c2.a();
    }

    public <T> Set<T> b(Class<T> cls) {
        return d(cls).a();
    }
}
