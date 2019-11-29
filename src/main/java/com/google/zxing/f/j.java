package com.google.zxing.f;

import com.google.zxing.c;
import com.google.zxing.w;

public final class j extends q {
    /* renamed from: a */
    public i b(w wVar) {
        if (wVar.d() != c.EAN_13) {
            return null;
        }
        String c2 = c(wVar);
        if (c2.length() != 13) {
            return null;
        }
        if (c2.startsWith("978") || c2.startsWith("979")) {
            return new i(c2);
        }
        return null;
    }
}
