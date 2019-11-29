package com.shopee.app.util;

import com.google.a.o;
import d.j;

public final class ac {
    public static final o a(j<String, String>... jVarArr) {
        d.d.b.j.b(jVarArr, "pair");
        o oVar = new o();
        for (j<String, String> jVar : jVarArr) {
            oVar.a(jVar.a(), jVar.b());
        }
        return oVar;
    }
}
