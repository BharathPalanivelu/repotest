package com.google.zxing.f;

import com.google.zxing.c;
import com.google.zxing.d.z;
import com.google.zxing.w;

public final class n extends q {
    /* renamed from: a */
    public m b(w wVar) {
        c d2 = wVar.d();
        if (d2 != c.UPC_A && d2 != c.UPC_E && d2 != c.EAN_8 && d2 != c.EAN_13) {
            return null;
        }
        String c2 = c(wVar);
        if (!a((CharSequence) c2, c2.length())) {
            return null;
        }
        return new m(c2, (d2 == c.UPC_E && c2.length() == 8) ? z.b(c2) : c2);
    }
}
