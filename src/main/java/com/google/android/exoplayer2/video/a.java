package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.c;
import com.google.android.exoplayer2.s.j;
import com.google.android.exoplayer2.s.l;
import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f12233a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12234b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12235c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12236d;

    /* renamed from: e  reason: collision with root package name */
    public final float f12237e;

    public static a a(l lVar) throws p {
        float f2;
        int i;
        int i2;
        try {
            lVar.d(4);
            int g2 = (lVar.g() & 3) + 1;
            if (g2 != 3) {
                ArrayList arrayList = new ArrayList();
                int g3 = lVar.g() & 31;
                for (int i3 = 0; i3 < g3; i3++) {
                    arrayList.add(b(lVar));
                }
                int g4 = lVar.g();
                for (int i4 = 0; i4 < g4; i4++) {
                    arrayList.add(b(lVar));
                }
                if (g3 > 0) {
                    j.b a2 = j.a((byte[]) arrayList.get(0), g2, ((byte[]) arrayList.get(0)).length);
                    int i5 = a2.f11412b;
                    int i6 = a2.f11413c;
                    f2 = a2.f11414d;
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
            throw new p("Error parsing AVC config", e2);
        }
    }

    private a(List<byte[]> list, int i, int i2, int i3, float f2) {
        this.f12233a = list;
        this.f12234b = i;
        this.f12235c = i2;
        this.f12236d = i3;
        this.f12237e = f2;
    }

    private static byte[] b(l lVar) {
        int h = lVar.h();
        int d2 = lVar.d();
        lVar.d(h);
        return c.a(lVar.f11422a, d2, h);
    }
}
