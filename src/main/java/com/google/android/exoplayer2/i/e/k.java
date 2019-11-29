package com.google.android.exoplayer2.i.e;

import android.util.Log;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.l;
import java.util.Arrays;

final class k {
    public static int a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static d a(l lVar) throws p {
        l lVar2 = lVar;
        a(1, lVar2, false);
        long m = lVar.m();
        int g2 = lVar.g();
        long m2 = lVar.m();
        int o = lVar.o();
        int o2 = lVar.o();
        int o3 = lVar.o();
        int g3 = lVar.g();
        return new d(m, g2, m2, o, o2, o3, (int) Math.pow(2.0d, (double) (g3 & 15)), (int) Math.pow(2.0d, (double) ((g3 & 240) >> 4)), (lVar.g() & 1) > 0, Arrays.copyOf(lVar2.f11422a, lVar.c()));
    }

    public static b b(l lVar) throws p {
        a(3, lVar, false);
        String e2 = lVar.e((int) lVar.m());
        int length = 11 + e2.length();
        long m = lVar.m();
        String[] strArr = new String[((int) m)];
        int i = length + 4;
        for (int i2 = 0; ((long) i2) < m; i2++) {
            strArr[i2] = lVar.e((int) lVar.m());
            i = i + 4 + strArr[i2].length();
        }
        if ((lVar.g() & 1) != 0) {
            return new b(e2, strArr, i + 1);
        }
        throw new p("framing bit expected to be set");
    }

    public static boolean a(int i, l lVar, boolean z) throws p {
        if (lVar.b() < 7) {
            if (z) {
                return false;
            }
            throw new p("too short header: " + lVar.b());
        } else if (lVar.g() != i) {
            if (z) {
                return false;
            }
            throw new p("expected header type " + Integer.toHexString(i));
        } else if (lVar.g() == 118 && lVar.g() == 111 && lVar.g() == 114 && lVar.g() == 98 && lVar.g() == 105 && lVar.g() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw new p("expected characters 'vorbis'");
        }
    }

    public static c[] a(l lVar, int i) throws p {
        int i2 = 0;
        a(5, lVar, false);
        int g2 = lVar.g() + 1;
        i iVar = new i(lVar.f11422a);
        iVar.b(lVar.d() * 8);
        for (int i3 = 0; i3 < g2; i3++) {
            d(iVar);
        }
        int a2 = iVar.a(6) + 1;
        while (i2 < a2) {
            if (iVar.a(16) == 0) {
                i2++;
            } else {
                throw new p("placeholder of time domain transforms not zeroed out");
            }
        }
        c(iVar);
        b(iVar);
        a(i, iVar);
        c[] a3 = a(iVar);
        if (iVar.a()) {
            return a3;
        }
        throw new p("framing bit after modes not set as expected");
    }

    private static c[] a(i iVar) {
        int a2 = iVar.a(6) + 1;
        c[] cVarArr = new c[a2];
        for (int i = 0; i < a2; i++) {
            cVarArr[i] = new c(iVar.a(), iVar.a(16), iVar.a(16), iVar.a(8));
        }
        return cVarArr;
    }

    private static void a(int i, i iVar) throws p {
        int a2 = iVar.a(6) + 1;
        for (int i2 = 0; i2 < a2; i2++) {
            int a3 = iVar.a(16);
            if (a3 != 0) {
                Log.e("VorbisUtil", "mapping type other than 0 not supported: " + a3);
            } else {
                int a4 = iVar.a() ? iVar.a(4) + 1 : 1;
                if (iVar.a()) {
                    int a5 = iVar.a(8) + 1;
                    for (int i3 = 0; i3 < a5; i3++) {
                        int i4 = i - 1;
                        iVar.b(a(i4));
                        iVar.b(a(i4));
                    }
                }
                if (iVar.a(2) == 0) {
                    if (a4 > 1) {
                        for (int i5 = 0; i5 < i; i5++) {
                            iVar.b(4);
                        }
                    }
                    for (int i6 = 0; i6 < a4; i6++) {
                        iVar.b(8);
                        iVar.b(8);
                        iVar.b(8);
                    }
                } else {
                    throw new p("to reserved bits must be zero after mapping coupling steps");
                }
            }
        }
    }

    private static void b(i iVar) throws p {
        int a2 = iVar.a(6) + 1;
        int i = 0;
        while (i < a2) {
            if (iVar.a(16) <= 2) {
                iVar.b(24);
                iVar.b(24);
                iVar.b(24);
                int a3 = iVar.a(6) + 1;
                iVar.b(8);
                int[] iArr = new int[a3];
                for (int i2 = 0; i2 < a3; i2++) {
                    iArr[i2] = ((iVar.a() ? iVar.a(5) : 0) * 8) + iVar.a(3);
                }
                for (int i3 = 0; i3 < a3; i3++) {
                    for (int i4 = 0; i4 < 8; i4++) {
                        if ((iArr[i3] & (1 << i4)) != 0) {
                            iVar.b(8);
                        }
                    }
                }
                i++;
            } else {
                throw new p("residueType greater than 2 is not decodable");
            }
        }
    }

    private static void c(i iVar) throws p {
        int a2 = iVar.a(6) + 1;
        for (int i = 0; i < a2; i++) {
            int a3 = iVar.a(16);
            if (a3 == 0) {
                iVar.b(8);
                iVar.b(16);
                iVar.b(16);
                iVar.b(6);
                iVar.b(8);
                int a4 = iVar.a(4) + 1;
                for (int i2 = 0; i2 < a4; i2++) {
                    iVar.b(8);
                }
            } else if (a3 == 1) {
                int a5 = iVar.a(5);
                int[] iArr = new int[a5];
                int i3 = -1;
                for (int i4 = 0; i4 < a5; i4++) {
                    iArr[i4] = iVar.a(4);
                    if (iArr[i4] > i3) {
                        i3 = iArr[i4];
                    }
                }
                int[] iArr2 = new int[(i3 + 1)];
                for (int i5 = 0; i5 < iArr2.length; i5++) {
                    iArr2[i5] = iVar.a(3) + 1;
                    int a6 = iVar.a(2);
                    if (a6 > 0) {
                        iVar.b(8);
                    }
                    for (int i6 = 0; i6 < (1 << a6); i6++) {
                        iVar.b(8);
                    }
                }
                iVar.b(2);
                int a7 = iVar.a(4);
                int i7 = 0;
                int i8 = 0;
                for (int i9 = 0; i9 < a5; i9++) {
                    i7 += iArr2[iArr[i9]];
                    while (i8 < i7) {
                        iVar.b(a7);
                        i8++;
                    }
                }
            } else {
                throw new p("floor type greater than 1 not decodable: " + a3);
            }
        }
    }

    private static a d(i iVar) throws p {
        if (iVar.a(24) == 5653314) {
            int a2 = iVar.a(16);
            int a3 = iVar.a(24);
            long[] jArr = new long[a3];
            boolean a4 = iVar.a();
            long j = 0;
            if (!a4) {
                boolean a5 = iVar.a();
                for (int i = 0; i < jArr.length; i++) {
                    if (!a5) {
                        jArr[i] = (long) (iVar.a(5) + 1);
                    } else if (iVar.a()) {
                        jArr[i] = (long) (iVar.a(5) + 1);
                    } else {
                        jArr[i] = 0;
                    }
                }
            } else {
                int a6 = iVar.a(5) + 1;
                int i2 = 0;
                while (i2 < jArr.length) {
                    int a7 = iVar.a(a(a3 - i2));
                    int i3 = i2;
                    for (int i4 = 0; i4 < a7 && i3 < jArr.length; i4++) {
                        jArr[i3] = (long) a6;
                        i3++;
                    }
                    a6++;
                    i2 = i3;
                }
            }
            int a8 = iVar.a(4);
            if (a8 <= 2) {
                if (a8 == 1 || a8 == 2) {
                    iVar.b(32);
                    iVar.b(32);
                    int a9 = iVar.a(4) + 1;
                    iVar.b(1);
                    if (a8 != 1) {
                        j = (long) (a3 * a2);
                    } else if (a2 != 0) {
                        j = a((long) a3, (long) a2);
                    }
                    iVar.b((int) (j * ((long) a9)));
                }
                return new a(a2, a3, jArr, a8, a4);
            }
            throw new p("lookup type greater than 2 not decodable: " + a8);
        }
        throw new p("expected code book to start with [0x56, 0x43, 0x42] at " + iVar.b());
    }

    private static long a(long j, long j2) {
        double d2 = (double) j2;
        Double.isNaN(d2);
        return (long) Math.floor(Math.pow((double) j, 1.0d / d2));
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f10200a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10201b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f10202c;

        /* renamed from: d  reason: collision with root package name */
        public final int f10203d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f10204e;

        public a(int i, int i2, long[] jArr, int i3, boolean z) {
            this.f10200a = i;
            this.f10201b = i2;
            this.f10202c = jArr;
            this.f10203d = i3;
            this.f10204e = z;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f10205a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f10206b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10207c;

        public b(String str, String[] strArr, int i) {
            this.f10205a = str;
            this.f10206b = strArr;
            this.f10207c = i;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final long f10212a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10213b;

        /* renamed from: c  reason: collision with root package name */
        public final long f10214c;

        /* renamed from: d  reason: collision with root package name */
        public final int f10215d;

        /* renamed from: e  reason: collision with root package name */
        public final int f10216e;

        /* renamed from: f  reason: collision with root package name */
        public final int f10217f;

        /* renamed from: g  reason: collision with root package name */
        public final int f10218g;
        public final int h;
        public final boolean i;
        public final byte[] j;

        public d(long j2, int i2, long j3, int i3, int i4, int i5, int i6, int i7, boolean z, byte[] bArr) {
            this.f10212a = j2;
            this.f10213b = i2;
            this.f10214c = j3;
            this.f10215d = i3;
            this.f10216e = i4;
            this.f10217f = i5;
            this.f10218g = i6;
            this.h = i7;
            this.i = z;
            this.j = bArr;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f10208a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10209b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10210c;

        /* renamed from: d  reason: collision with root package name */
        public final int f10211d;

        public c(boolean z, int i, int i2, int i3) {
            this.f10208a = z;
            this.f10209b = i;
            this.f10210c = i2;
            this.f10211d = i3;
        }
    }
}
