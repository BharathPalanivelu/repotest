package com.google.zxing.f;

import com.google.zxing.w;

public final class aa extends q {
    /* renamed from: a */
    public y b(w wVar) {
        String c2 = c(wVar);
        String str = null;
        if (!c2.startsWith("urlto:") && !c2.startsWith("URLTO:")) {
            return null;
        }
        int indexOf = c2.indexOf(58, 6);
        if (indexOf < 0) {
            return null;
        }
        if (indexOf > 6) {
            str = c2.substring(6, indexOf);
        }
        return new y(c2.substring(indexOf + 1), str);
    }
}
