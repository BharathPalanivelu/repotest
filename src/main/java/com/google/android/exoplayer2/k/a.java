package com.google.android.exoplayer2.k;

import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.n.b;
import com.google.android.exoplayer2.n.i;
import com.google.android.exoplayer2.n.k;
import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f10633a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10634b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10635c;

    /* renamed from: d  reason: collision with root package name */
    public final int f10636d;

    /* renamed from: e  reason: collision with root package name */
    public final float f10637e;

    public static a a(k kVar) throws ak {
        float f2;
        int i;
        int i2;
        try {
            kVar.d(4);
            int g2 = (kVar.g() & 3) + 1;
            if (g2 != 3) {
                ArrayList arrayList = new ArrayList();
                int g3 = kVar.g() & 31;
                for (int i3 = 0; i3 < g3; i3++) {
                    arrayList.add(b(kVar));
                }
                int g4 = kVar.g();
                for (int i4 = 0; i4 < g4; i4++) {
                    arrayList.add(b(kVar));
                }
                if (g3 > 0) {
                    i.b a2 = i.a((byte[]) arrayList.get(0), g2, ((byte[]) arrayList.get(0)).length);
                    int i5 = a2.f10938b;
                    int i6 = a2.f10939c;
                    f2 = a2.f10940d;
                    i2 = i5;
                    i = i6;
                } else {
                    i2 = -1;
                    i = -1;
                    f2 = 1.0f;
                }
                return new a(arrayList, g2, i2, i, f2);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new ak("Error parsing AVC config", e2);
        }
    }

    private a(List<byte[]> list, int i, int i2, int i3, float f2) {
        this.f10633a = list;
        this.f10634b = i;
        this.f10635c = i2;
        this.f10636d = i3;
        this.f10637e = f2;
    }

    private static byte[] b(k kVar) {
        int h = kVar.h();
        int d2 = kVar.d();
        kVar.d(h);
        return b.a(kVar.f10948a, d2, h);
    }
}
