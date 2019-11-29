package com.google.zxing.d.a.a.a;

import com.google.zxing.c.a;
import com.google.zxing.q;

final class e extends i {

    /* renamed from: a  reason: collision with root package name */
    private final String f14536a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14537b;

    e(a aVar, String str, String str2) {
        super(aVar);
        this.f14536a = str2;
        this.f14537b = str;
    }

    public String a() throws q {
        if (b().a() == 84) {
            StringBuilder sb = new StringBuilder();
            b(sb, 8);
            b(sb, 48, 20);
            c(sb, 68);
            return sb.toString();
        }
        throw q.a();
    }

    private void c(StringBuilder sb, int i) {
        int a2 = c().a(i, 16);
        if (a2 != 38400) {
            sb.append('(');
            sb.append(this.f14536a);
            sb.append(')');
            int i2 = a2 % 32;
            int i3 = a2 / 32;
            int i4 = (i3 % 12) + 1;
            int i5 = i3 / 12;
            if (i5 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i5);
            if (i4 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i4);
            if (i2 / 10 == 0) {
                sb.append('0');
            }
            sb.append(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.f14537b);
        sb.append(i / 100000);
        sb.append(')');
    }

    /* access modifiers changed from: protected */
    public int a(int i) {
        return i % 100000;
    }
}
