package com.shopee.app.util.q;

import d.d.b.j;
import d.h.k;
import d.h.m;
import java.util.ArrayList;
import java.util.List;

public final class b {
    public static final List<Integer> a(String str) {
        j.b(str, "blacklist");
        if (d(str)) {
            return d.a.j.a();
        }
        if (new k("^\\[\\s*\\d+(,\\s*\\d+)*\\s*\\]$").b(str) != null) {
            List<String> b2 = m.b((CharSequence) m.b(m.a(str, (CharSequence) "["), "]"), new String[]{","}, false, 0, 6, (Object) null);
            List<Integer> arrayList = new ArrayList<>();
            for (String str2 : b2) {
                if (str2 != null) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(m.b(str2).toString())));
                } else {
                    throw new d.m("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            return arrayList;
        }
        throw new IllegalStateException("The blacklist format is not correct, please follow this pattern: ^\\[\\s*\\d+(,\\s*\\d+)*\\s*\\]$");
    }

    public static final List<String> b(String str) {
        j.b(str, "blacklist");
        if (d(str)) {
            return d.a.j.a();
        }
        if (new k("^\\[\\s*.+(,\\s*.+)*\\s*\\]$").b(str) != null) {
            List<String> b2 = m.b((CharSequence) m.b(m.a(str, (CharSequence) "["), "]"), new String[]{","}, false, 0, 6, (Object) null);
            List<String> arrayList = new ArrayList<>();
            for (String str2 : b2) {
                if (str2 != null) {
                    arrayList.add(c(m.c(m.b(str2).toString(), "\"")));
                } else {
                    throw new d.m("null cannot be cast to non-null type kotlin.CharSequence");
                }
            }
            return arrayList;
        }
        throw new IllegalStateException("The blacklist format is not correct, please follow this pattern: ^\\[\\s*.+(,\\s*.+)*\\s*\\]$");
    }

    private static final boolean d(String str) {
        CharSequence charSequence = str;
        return (charSequence.length() == 0) || new k("^\\[\\s*\\]$").b(charSequence) != null;
    }

    public static final String c(String str) {
        j.b(str, "str");
        try {
            if (m.a(str, "\\u", false, 2, (Object) null)) {
                List<String> b2 = d.a.j.b(m.b((CharSequence) m.a(str, "\\", "", false, 4, (Object) null), new String[]{"u"}, false, 0, 6, (Object) null), 1);
                StringBuilder sb = new StringBuilder();
                for (String parseInt : b2) {
                    sb.append((char) Integer.parseInt(parseInt, 16));
                }
                String sb2 = sb.toString();
                j.a((Object) sb2, "builder.toString()");
                return sb2;
            }
            throw new IllegalStateException("Not an emoji unicode format");
        } catch (Exception unused) {
            return str;
        }
    }
}
