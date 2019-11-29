package com.google.android.exoplayer2.k;

import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.n.i;
import com.google.android.exoplayer2.n.k;
import java.util.Collections;
import java.util.List;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f10643a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10644b;

    public static c a(k kVar) throws ak {
        List list;
        try {
            kVar.d(21);
            int g2 = kVar.g() & 3;
            int g3 = kVar.g();
            int d2 = kVar.d();
            int i = 0;
            int i2 = 0;
            while (i < g3) {
                kVar.d(1);
                int h = kVar.h();
                int i3 = i2;
                for (int i4 = 0; i4 < h; i4++) {
                    int h2 = kVar.h();
                    i3 += h2 + 4;
                    kVar.d(h2);
                }
                i++;
                i2 = i3;
            }
            kVar.c(d2);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < g3) {
                kVar.d(1);
                int h3 = kVar.h();
                int i7 = i6;
                for (int i8 = 0; i8 < h3; i8++) {
                    int h4 = kVar.h();
                    System.arraycopy(i.f10930a, 0, bArr, i7, i.f10930a.length);
                    int length = i7 + i.f10930a.length;
                    System.arraycopy(kVar.f10948a, kVar.d(), bArr, length, h4);
                    i7 = length + h4;
                    kVar.d(h4);
                }
                i5++;
                i6 = i7;
            }
            if (i2 == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new c(list, g2 + 1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new ak("Error parsing HEVC config", e2);
        }
    }

    private c(List<byte[]> list, int i) {
        this.f10643a = list;
        this.f10644b = i;
    }
}
