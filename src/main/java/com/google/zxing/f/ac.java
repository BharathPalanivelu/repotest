package com.google.zxing.f;

import com.google.zxing.w;

public final class ac extends q {
    /* renamed from: a */
    public ab b(w wVar) {
        String c2 = c(wVar);
        if (!c2.startsWith("WIFI:")) {
            return null;
        }
        String b2 = b("S:", c2, ';', false);
        if (b2 == null || b2.isEmpty()) {
            return null;
        }
        String b3 = b("P:", c2, ';', false);
        String b4 = b("T:", c2, ';', false);
        if (b4 == null) {
            b4 = "nopass";
        }
        return new ab(b4, b2, b3, Boolean.parseBoolean(b("H:", c2, ';', false)));
    }
}
