package com.google.zxing.f;

import com.google.zxing.w;

public final class t extends q {
    /* renamed from: a */
    public s b(w wVar) {
        String str;
        String c2 = c(wVar);
        if (!c2.startsWith("smsto:") && !c2.startsWith("SMSTO:") && !c2.startsWith("mmsto:") && !c2.startsWith("MMSTO:")) {
            return null;
        }
        String substring = c2.substring(6);
        int indexOf = substring.indexOf(58);
        if (indexOf >= 0) {
            str = substring.substring(indexOf + 1);
            substring = substring.substring(0, indexOf);
        } else {
            str = null;
        }
        return new s(substring, (String) null, (String) null, str);
    }
}
