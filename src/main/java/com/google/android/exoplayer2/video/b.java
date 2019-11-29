package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.j;
import com.google.android.exoplayer2.s.l;
import java.util.Collections;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f12238a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12239b;

    public static b a(l lVar) throws p {
        List list;
        try {
            lVar.d(21);
            int g2 = lVar.g() & 3;
            int g3 = lVar.g();
            int d2 = lVar.d();
            int i = 0;
            int i2 = 0;
            while (i < g3) {
                lVar.d(1);
                int h = lVar.h();
                int i3 = i2;
                for (int i4 = 0; i4 < h; i4++) {
                    int h2 = lVar.h();
                    i3 += h2 + 4;
                    lVar.d(h2);
                }
                i++;
                i2 = i3;
            }
            lVar.c(d2);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < g3) {
                lVar.d(1);
                int h3 = lVar.h();
                int i7 = i6;
                for (int i8 = 0; i8 < h3; i8++) {
                    int h4 = lVar.h();
                    System.arraycopy(j.f11404a, 0, bArr, i7, j.f11404a.length);
                    int length = i7 + j.f11404a.length;
                    System.arraycopy(lVar.f11422a, lVar.d(), bArr, length, h4);
                    i7 = length + h4;
                    lVar.d(h4);
                }
                i5++;
                i6 = i7;
            }
            if (i2 == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new b(list, g2 + 1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new p("Error parsing HEVC config", e2);
        }
    }

    private b(List<byte[]> list, int i) {
        this.f12238a = list;
        this.f12239b = i;
    }
}
