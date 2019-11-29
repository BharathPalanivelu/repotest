package com.google.zxing.e.a;

import com.google.zxing.c.b;
import com.google.zxing.c.b.a;
import com.google.zxing.c.b.c;
import com.google.zxing.g;
import com.google.zxing.j;
import com.google.zxing.m;
import java.util.Map;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final c f14650a = new c(a.f14487e);

    public com.google.zxing.c.e a(b bVar, Map<j, ?> map) throws m, g {
        g e2;
        a aVar = new a(bVar);
        m mVar = null;
        try {
            return a(aVar, map);
        } catch (m e3) {
            m mVar2 = e3;
            e2 = null;
            mVar = mVar2;
            try {
                aVar.d();
                aVar.a(true);
                aVar.b();
                aVar.a();
                aVar.e();
                com.google.zxing.c.e a2 = a(aVar, map);
                a2.a(new i(true));
                return a2;
            } catch (g | m e4) {
                if (mVar != null) {
                    throw mVar;
                } else if (e2 != null) {
                    throw e2;
                } else {
                    throw e4;
                }
            }
        } catch (g e5) {
            e2 = e5;
            aVar.d();
            aVar.a(true);
            aVar.b();
            aVar.a();
            aVar.e();
            com.google.zxing.c.e a22 = a(aVar, map);
            a22.a(new i(true));
            return a22;
        }
    }

    private com.google.zxing.c.e a(a aVar, Map<j, ?> map) throws m, g {
        j b2 = aVar.b();
        f a2 = aVar.a().a();
        b[] a3 = b.a(aVar.c(), b2, a2);
        int i = 0;
        for (b a4 : a3) {
            i += a4.a();
        }
        byte[] bArr = new byte[i];
        int length = a3.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            b bVar = a3[i2];
            byte[] b3 = bVar.b();
            int a5 = bVar.a();
            a(b3, a5);
            int i4 = i3;
            int i5 = 0;
            while (i5 < a5) {
                bArr[i4] = b3[i5];
                i5++;
                i4++;
            }
            i2++;
            i3 = i4;
        }
        return d.a(bArr, b2, a2, map);
    }

    private void a(byte[] bArr, int i) throws g {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f14650a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (com.google.zxing.c.b.e unused) {
            throw g.a();
        }
    }
}
