package com.google.zxing.f;

import com.google.zxing.w;

public final class c extends a {
    /* renamed from: a */
    public d b(w wVar) {
        String c2 = q.c(wVar);
        if (!c2.startsWith("MECARD:")) {
            return null;
        }
        String[] a2 = a("N:", c2, true);
        if (a2 == null) {
            return null;
        }
        String e2 = e(a2[0]);
        String b2 = b("SOUND:", c2, true);
        String[] a3 = a("TEL:", c2, true);
        String[] a4 = a("EMAIL:", c2, true);
        String b3 = b("NOTE:", c2, false);
        String[] a5 = a("ADR:", c2, true);
        String b4 = b("BDAY:", c2, true);
        return new d(q.a(e2), (String[]) null, b2, a3, (String[]) null, a4, (String[]) null, (String) null, b3, a5, (String[]) null, b("ORG:", c2, true), !q.a((CharSequence) b4, 8) ? null : b4, (String) null, a("URL:", c2, true), (String[]) null);
    }

    private static String e(String str) {
        int indexOf = str.indexOf(44);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1) + ' ' + str.substring(0, indexOf);
    }
}
