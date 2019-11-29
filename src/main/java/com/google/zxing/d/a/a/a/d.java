package com.google.zxing.d.a.a.a;

import com.google.zxing.c.a;
import com.google.zxing.m;
import com.google.zxing.q;

final class d extends h {
    d(a aVar) {
        super(aVar);
    }

    public String a() throws q, m {
        if (b().a() >= 48) {
            StringBuilder sb = new StringBuilder();
            b(sb, 8);
            int a2 = c().a(48, 2);
            sb.append("(393");
            sb.append(a2);
            sb.append(')');
            int a3 = c().a(50, 10);
            if (a3 / 100 == 0) {
                sb.append('0');
            }
            if (a3 / 10 == 0) {
                sb.append('0');
            }
            sb.append(a3);
            sb.append(c().a(60, (String) null).a());
            return sb.toString();
        }
        throw q.a();
    }
}
