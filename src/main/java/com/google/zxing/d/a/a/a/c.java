package com.google.zxing.d.a.a.a;

import com.google.zxing.c.a;
import com.google.zxing.m;
import com.google.zxing.q;

final class c extends h {
    c(a aVar) {
        super(aVar);
    }

    public String a() throws q, m {
        if (b().a() >= 48) {
            StringBuilder sb = new StringBuilder();
            b(sb, 8);
            int a2 = c().a(48, 2);
            sb.append("(392");
            sb.append(a2);
            sb.append(')');
            sb.append(c().a(50, (String) null).a());
            return sb.toString();
        }
        throw q.a();
    }
}
