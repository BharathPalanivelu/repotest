package com.google.zxing.f;

import com.google.zxing.w;

public final class v extends q {
    /* renamed from: a */
    public u b(w wVar) {
        String str;
        String c2 = c(wVar);
        if (!c2.startsWith("tel:") && !c2.startsWith("TEL:")) {
            return null;
        }
        if (c2.startsWith("TEL:")) {
            str = "tel:" + c2.substring(4);
        } else {
            str = c2;
        }
        int indexOf = c2.indexOf(63, 4);
        return new u(indexOf < 0 ? c2.substring(4) : c2.substring(4, indexOf), str, (String) null);
    }
}
