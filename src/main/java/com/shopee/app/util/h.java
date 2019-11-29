package com.shopee.app.util;

import com.google.a.l;
import com.google.a.r;
import com.shopee.app.util.f;
import d.d.b.j;

public final class h {
    public static final f.a a(l lVar) {
        j.b(lVar, "$this$getType");
        if (lVar.l()) {
            return f.a.Null;
        }
        if (lVar.k()) {
            r o = lVar.o();
            j.a((Object) o, "jsonPrimitive");
            if (o.a()) {
                return f.a.Boolean;
            }
            if (o.q()) {
                return f.a.Number;
            }
            if (o.r()) {
                return f.a.String;
            }
        }
        return f.a.Unsupported;
    }
}
