package com.google.android.exoplayer2.e.e;

import android.util.Log;
import com.google.android.exoplayer2.ak;
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

    public static d a(com.google.android.exoplayer2.n.k kVar) throws ak {
        com.google.android.exoplayer2.n.k kVar2 = kVar;
        a(1, kVar2, false);
        long m = kVar.m();
        int g2 = kVar.g();
        long m2 = kVar.m();
        int o = kVar.o();
        int o2 = kVar.o();
        int o3 = kVar.o();
        int g3 = kVar.g();
        return new d(m, g2, m2, o, o2, o3, (int) Math.pow(2.0d, (double) (g3 & 15)), (int) Math.pow(2.0d, (double) ((g3 & 240) >> 4)), (kVar.g() & 1) > 0, Arrays.copyOf(kVar2.f10948a, kVar.c()));
    }

    public static b b(com.google.android.exoplayer2.n.k kVar) throws ak {
        a(3, kVar, false);
        String e2 = kVar.e((int) kVar.m());
        int length = 11 + e2.length();
        long m = kVar.m();
        String[] strArr = new String[((int) m)];
        int i = length + 4;
        for (int i2 = 0; ((long) i2) < m; i2++) {
            strArr[i2] = kVar.e((int) kVar.m());
            i = i + 4 + strArr[i2].length();
        }
        if ((kVar.g() & 1) != 0) {
            return new b(e2, strArr, i + 1);
        }
        throw new ak("framing bit expected to be set");
    }

    public static boolean a(int i, com.google.android.exoplayer2.n.k kVar, boolean z) throws ak {
        if (kVar.b() < 7) {
            if (z) {
                return false;
            }
            throw new ak("too short header: " + kVar.b());
        } else if (kVar.g() != i) {
            if (z) {
                return false;
            }
            throw new ak("expected header type " + Integer.toHexString(i));
        } else if (kVar.g() == 118 && kVar.g() == 111 && kVar.g() == 114 && kVar.g() == 98 && kVar.g() == 105 && kVar.g() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw new ak("expected characters 'vorbis'");
        }
    }

    public static c[] a(com.google.android.exoplayer2.n.k kVar, int i) throws ak {
        int i2 = 0;
        a(5, kVar, false);
        int g2 = kVar.g() + 1;
        i iVar = new i(kVar.f10948a);
        iVar.b(kVar.d() * 8);
        for (int i3 = 0; i3 < g2; i3++) {
            d(iVar);
        }
        int a2 = iVar.a(6) + 1;
        while (i2 < a2) {
            if (iVar.a(16) == 0) {
                i2++;
            } else {
                throw new ak("placeholder of time domain transforms not zeroed out");
            }
        }
        c(iVar);
        b(iVar);
        a(i, iVar);
        c[] a3 = a(iVar);
        if (iVar.a()) {
            return a3;
        }
        throw new ak("framing bit after modes not set as expected");
    }

    private static c[] a(i iVar) {
        int a2 = iVar.a(6) + 1;
        c[] cVarArr = new c[a2];
        for (int i = 0; i < a2; i++) {
            cVarArr[i] = new c(iVar.a(), iVar.a(16), iVar.a(16), iVar.a(8));
        }
        return cVarArr;
    }

    private static void a(int i, i iVar) throws ak {
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
                    throw new ak("to reserved bits must be zero after mapping coupling steps");
                }
            }
        }
    }

    private static void b(i iVar) throws ak {
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
                throw new ak("residueType greater than 2 is not decodable");
            }
        }
    }

    private static void c(i iVar) throws ak {
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
                throw new ak("floor type greater than 1 not decodable: " + a3);
            }
        }
    }

    private static a d(i iVar) throws ak {
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
            throw new ak("lookup type greater than 2 not decodable: " + a8);
        }
        throw new ak("expected code book to start with [0x56, 0x43, 0x42] at " + iVar.b());
    }

    private static long a(long j, long j2) {
        double d2 = (double) j2;
        Double.isNaN(d2);
        return (long) Math.floor(Math.pow((double) j, 1.0d / d2));
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f9566a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9567b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f9568c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9569d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f9570e;

        public a(int i, int i2, long[] jArr, int i3, boolean z) {
            this.f9566a = i;
            this.f9567b = i2;
            this.f9568c = jArr;
            this.f9569d = i3;
            this.f9570e = z;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f9571a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f9572b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9573c;

        public b(String str, String[] strArr, int i) {
            this.f9571a = str;
            this.f9572b = strArr;
            this.f9573c = i;
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final long f9578a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9579b;

        /* renamed from: c  reason: collision with root package name */
        public final long f9580c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9581d;

        /* renamed from: e  reason: collision with root package name */
        public final int f9582e;

        /* renamed from: f  reason: collision with root package name */
        public final int f9583f;

        /* renamed from: g  reason: collision with root package name */
        public final int f9584g;
        public final int h;
        public final boolean i;
        public final byte[] j;

        public d(long j2, int i2, long j3, int i3, int i4, int i5, int i6, int i7, boolean z, byte[] bArr) {
            this.f9578a = j2;
            this.f9579b = i2;
            this.f9580c = j3;
            this.f9581d = i3;
            this.f9582e = i4;
            this.f9583f = i5;
            this.f9584g = i6;
            this.h = i7;
            this.i = z;
            this.j = bArr;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f9574a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9575b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9576c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9577d;

        public c(boolean z, int i, int i2, int i3) {
            this.f9574a = z;
            this.f9575b = i;
            this.f9576c = i2;
            this.f9577d = i3;
        }
    }
}
