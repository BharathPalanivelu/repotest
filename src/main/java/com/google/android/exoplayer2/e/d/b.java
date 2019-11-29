package com.google.android.exoplayer2.e.d;

import android.util.Log;
import android.util.Pair;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.e.d.a;
import com.google.android.exoplayer2.e.d.d;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import com.path.android.jobqueue.JobManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f9415a = t.g("vide");

    /* renamed from: b  reason: collision with root package name */
    private static final int f9416b = t.g("soun");

    /* renamed from: c  reason: collision with root package name */
    private static final int f9417c = t.g("text");

    /* renamed from: d  reason: collision with root package name */
    private static final int f9418d = t.g("sbtl");

    /* renamed from: e  reason: collision with root package name */
    private static final int f9419e = t.g("subt");

    /* renamed from: f  reason: collision with root package name */
    private static final int f9420f = t.g("clcp");

    /* renamed from: g  reason: collision with root package name */
    private static final int f9421g = t.g("cenc");
    private static final int h = t.g("meta");

    /* renamed from: com.google.android.exoplayer2.e.d.b$b  reason: collision with other inner class name */
    private interface C0163b {
        int a();

        int b();

        boolean c();
    }

    public static j a(a.C0162a aVar, a.b bVar, long j, com.google.android.exoplayer2.c.a aVar2, boolean z) throws ak {
        long j2;
        a.b bVar2;
        a.C0162a aVar3 = aVar;
        a.C0162a e2 = aVar3.e(a.E);
        int c2 = c(e2.d(a.S).aQ);
        if (c2 == -1) {
            return null;
        }
        f b2 = b(aVar3.d(a.O).aQ);
        long j3 = -9223372036854775807L;
        if (j == -9223372036854775807L) {
            j2 = b2.f9442b;
            bVar2 = bVar;
        } else {
            bVar2 = bVar;
            j2 = j;
        }
        long a2 = a(bVar2.aQ);
        if (j2 != -9223372036854775807L) {
            j3 = t.a(j2, (long) JobManager.NS_PER_MS, a2);
        }
        long j4 = j3;
        a.C0162a e3 = e2.e(a.F).e(a.G);
        Pair<Long, String> d2 = d(e2.d(a.R).aQ);
        c a3 = a(e3.d(a.T).aQ, b2.f9441a, b2.f9443c, (String) d2.second, aVar2, z);
        Pair<long[], long[]> a4 = a(aVar3.e(a.P));
        if (a3.f9430b == null) {
            return null;
        }
        int b3 = b2.f9441a;
        long longValue = ((Long) d2.first).longValue();
        j jVar = a3.f9430b;
        int i = a3.f9432d;
        k[] kVarArr = a3.f9429a;
        int i2 = a3.f9431c;
        return new j(b3, c2, longValue, a2, j4, jVar, i, kVarArr, i2, (long[]) a4.first, (long[]) a4.second);
    }

    public static m a(j jVar, a.C0162a aVar, com.google.android.exoplayer2.e.j jVar2) throws ak {
        C0163b bVar;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        long j;
        boolean z2;
        int[] iArr3;
        int i5;
        long[] jArr3;
        int[] iArr4;
        int[] iArr5;
        int[] iArr6;
        int i6;
        int i7;
        j jVar3 = jVar;
        a.C0162a aVar2 = aVar;
        com.google.android.exoplayer2.e.j jVar4 = jVar2;
        a.b d2 = aVar2.d(a.aq);
        if (d2 != null) {
            bVar = new d(d2);
        } else {
            a.b d3 = aVar2.d(a.ar);
            if (d3 != null) {
                bVar = new e(d3);
            } else {
                throw new ak("Track has no sample table size information");
            }
        }
        int a2 = bVar.a();
        if (a2 == 0) {
            return new m(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        a.b d4 = aVar2.d(a.as);
        if (d4 == null) {
            d4 = aVar2.d(a.at);
            z = true;
        } else {
            z = false;
        }
        k kVar = d4.aQ;
        k kVar2 = aVar2.d(a.ap).aQ;
        k kVar3 = aVar2.d(a.am).aQ;
        a.b d5 = aVar2.d(a.an);
        k kVar4 = d5 != null ? d5.aQ : null;
        a.b d6 = aVar2.d(a.ao);
        k kVar5 = d6 != null ? d6.aQ : null;
        a aVar3 = new a(kVar2, kVar, z);
        kVar3.c(12);
        int t = kVar3.t() - 1;
        int t2 = kVar3.t();
        int t3 = kVar3.t();
        if (kVar5 != null) {
            kVar5.c(12);
            i = kVar5.t();
        } else {
            i = 0;
        }
        int i8 = -1;
        if (kVar4 != null) {
            kVar4.c(12);
            i2 = kVar4.t();
            if (i2 > 0) {
                i8 = kVar4.t() - 1;
            } else {
                kVar4 = null;
            }
        } else {
            i2 = 0;
        }
        long j2 = 0;
        if (!(bVar.c() && "audio/raw".equals(jVar3.f9493f.f10427f) && t == 0 && i == 0 && i2 == 0)) {
            jArr2 = new long[a2];
            iArr = new int[a2];
            jArr = new long[a2];
            int i9 = i2;
            iArr2 = new int[a2];
            int i10 = i9;
            k kVar6 = kVar3;
            int i11 = t3;
            int i12 = i;
            int i13 = i8;
            long j3 = 0;
            long j4 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = t2;
            int i19 = t;
            int i20 = 0;
            while (i20 < a2) {
                long j5 = j3;
                int i21 = i14;
                while (i21 == 0) {
                    com.google.android.exoplayer2.n.a.b(aVar3.a());
                    j5 = aVar3.f9425d;
                    i21 = aVar3.f9424c;
                    i19 = i19;
                    i11 = i11;
                }
                int i22 = i19;
                int i23 = i11;
                if (kVar5 != null) {
                    while (i17 == 0 && i12 > 0) {
                        i17 = kVar5.t();
                        i16 = kVar5.n();
                        i12--;
                    }
                    i17--;
                }
                int i24 = i16;
                jArr2[i20] = j5;
                iArr[i20] = bVar.b();
                if (iArr[i20] > i15) {
                    i6 = a2;
                    i15 = iArr[i20];
                } else {
                    i6 = a2;
                }
                C0163b bVar2 = bVar;
                jArr[i20] = j4 + ((long) i24);
                iArr2[i20] = kVar4 == null ? 1 : 0;
                if (i20 == i13) {
                    iArr2[i20] = 1;
                    i10--;
                    if (i10 > 0) {
                        i13 = kVar4.t() - 1;
                    }
                }
                int i25 = i10;
                int i26 = i13;
                int i27 = i23;
                j4 += (long) i27;
                i18--;
                if (i18 != 0 || i22 <= 0) {
                    i7 = i22;
                } else {
                    i7 = i22 - 1;
                    i18 = kVar6.t();
                    i27 = kVar6.t();
                }
                int i28 = i7;
                i20++;
                i13 = i26;
                a2 = i6;
                i14 = i21 - 1;
                i16 = i24;
                i19 = i28;
                j3 = j5 + ((long) iArr[i20]);
                C0163b bVar3 = bVar2;
                i11 = i27;
                i10 = i25;
                bVar = bVar3;
            }
            i4 = a2;
            int i29 = i19;
            com.google.android.exoplayer2.n.a.a(i17 == 0);
            while (i12 > 0) {
                com.google.android.exoplayer2.n.a.a(kVar5.t() == 0);
                kVar5.n();
                i12--;
            }
            if (i10 == 0 && i18 == 0 && i14 == 0 && i29 == 0) {
                jVar3 = jVar;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Inconsistent stbl box for track ");
                int i30 = i10;
                jVar3 = jVar;
                sb.append(jVar3.f9488a);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i30);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i18);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i14);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i29);
                Log.w("AtomParsers", sb.toString());
            }
            j = j4;
            i3 = i15;
        } else {
            i4 = a2;
            C0163b bVar4 = bVar;
            long[] jArr4 = new long[aVar3.f9422a];
            int[] iArr7 = new int[aVar3.f9422a];
            while (aVar3.a()) {
                jArr4[aVar3.f9423b] = aVar3.f9425d;
                iArr7[aVar3.f9423b] = aVar3.f9424c;
            }
            d.a a3 = d.a(bVar4.b(), jArr4, iArr7, (long) t3);
            jArr2 = a3.f9448a;
            iArr = a3.f9449b;
            int i31 = a3.f9450c;
            jArr = a3.f9451d;
            iArr2 = a3.f9452e;
            i3 = i31;
            j = 0;
        }
        if (jVar3.i == null || jVar2.a()) {
            t.a(jArr, (long) JobManager.NS_PER_MS, jVar3.f9490c);
            return new m(jArr2, iArr, i3, jArr, iArr2);
        }
        if (jVar3.i.length == 1 && jVar3.f9489b == 1 && jArr.length >= 2) {
            long j6 = jVar3.j[0];
            long a4 = t.a(jVar3.i[0], jVar3.f9490c, jVar3.f9491d) + j6;
            if (jArr[0] <= j6 && j6 < jArr[1] && jArr[jArr.length - 1] < a4 && a4 <= j) {
                long j7 = j - a4;
                long a5 = t.a(j6 - jArr[0], (long) jVar3.f9493f.s, jVar3.f9490c);
                long a6 = t.a(j7, (long) jVar3.f9493f.s, jVar3.f9490c);
                if (!(a5 == 0 && a6 == 0) && a5 <= 2147483647L && a6 <= 2147483647L) {
                    int i32 = (int) a5;
                    com.google.android.exoplayer2.e.j jVar5 = jVar2;
                    jVar5.f9770b = i32;
                    jVar5.f9771c = (int) a6;
                    t.a(jArr, (long) JobManager.NS_PER_MS, jVar3.f9490c);
                    return new m(jArr2, iArr, i3, jArr, iArr2);
                }
            }
        }
        if (jVar3.i.length == 1) {
            char c2 = 0;
            if (jVar3.i[0] == 0) {
                int i33 = 0;
                while (i33 < jArr.length) {
                    jArr[i33] = t.a(jArr[i33] - jVar3.j[c2], (long) JobManager.NS_PER_MS, jVar3.f9490c);
                    i33++;
                    c2 = 0;
                }
                return new m(jArr2, iArr, i3, jArr, iArr2);
            }
        }
        boolean z3 = jVar3.f9489b == 1;
        int i34 = 0;
        boolean z4 = false;
        int i35 = 0;
        int i36 = 0;
        while (i34 < jVar3.i.length) {
            long j8 = jVar3.j[i34];
            if (j8 != -1) {
                iArr6 = iArr;
                long a7 = t.a(jVar3.i[i34], jVar3.f9490c, jVar3.f9491d);
                int b2 = t.b(jArr, j8, true, true);
                int b3 = t.b(jArr, j8 + a7, z3, false);
                i35 += b3 - b2;
                z4 |= i36 != b2;
                i36 = b3;
            } else {
                iArr6 = iArr;
            }
            i34++;
            iArr = iArr6;
        }
        int[] iArr8 = iArr;
        boolean z5 = (i35 != i4) | z4;
        long[] jArr5 = z5 ? new long[i35] : jArr2;
        int[] iArr9 = z5 ? new int[i35] : iArr8;
        if (z5) {
            i3 = 0;
        }
        int[] iArr10 = z5 ? new int[i35] : iArr2;
        long[] jArr6 = new long[i35];
        int i37 = i3;
        int i38 = 0;
        int i39 = 0;
        while (i38 < jVar3.i.length) {
            long j9 = jVar3.j[i38];
            long j10 = jVar3.i[i38];
            if (j9 != -1) {
                long j11 = jVar3.f9490c;
                int[] iArr11 = iArr10;
                i5 = i38;
                int b4 = t.b(jArr, j9, true, true);
                int b5 = t.b(jArr, t.a(j10, j11, jVar3.f9491d) + j9, z3, false);
                if (z5) {
                    int i40 = b5 - b4;
                    System.arraycopy(jArr2, b4, jArr5, i39, i40);
                    iArr4 = iArr8;
                    System.arraycopy(iArr4, b4, iArr9, i39, i40);
                    z2 = z3;
                    iArr5 = iArr11;
                    System.arraycopy(iArr2, b4, iArr5, i39, i40);
                } else {
                    iArr4 = iArr8;
                    z2 = z3;
                    iArr5 = iArr11;
                }
                int i41 = i37;
                while (b4 < b5) {
                    long[] jArr7 = jArr2;
                    int[] iArr12 = iArr2;
                    long j12 = j9;
                    jArr6[i39] = t.a(j2, (long) JobManager.NS_PER_MS, jVar3.f9491d) + t.a(jArr[b4] - j9, (long) JobManager.NS_PER_MS, jVar3.f9490c);
                    if (z5 && iArr9[i39] > i41) {
                        i41 = iArr4[b4];
                    }
                    i39++;
                    b4++;
                    jArr2 = jArr7;
                    j9 = j12;
                    iArr2 = iArr12;
                }
                jArr3 = jArr2;
                iArr3 = iArr2;
                i37 = i41;
            } else {
                iArr4 = iArr8;
                z2 = z3;
                jArr3 = jArr2;
                iArr3 = iArr2;
                iArr5 = iArr10;
                i5 = i38;
            }
            j2 += j10;
            i38 = i5 + 1;
            iArr10 = iArr5;
            jArr2 = jArr3;
            iArr2 = iArr3;
            z3 = z2;
            iArr8 = iArr4;
        }
        int[] iArr13 = iArr10;
        boolean z6 = false;
        for (int i42 = 0; i42 < iArr13.length && !z6; i42++) {
            z6 |= (iArr13[i42] & 1) != 0;
        }
        if (z6) {
            return new m(jArr5, iArr9, i37, jArr6, iArr13);
        }
        throw new ak("The edited sample sequence does not contain a sync sample.");
    }

    public static com.google.android.exoplayer2.f.a a(a.b bVar, boolean z) {
        if (z) {
            return null;
        }
        k kVar = bVar.aQ;
        kVar.c(8);
        while (kVar.b() >= 8) {
            int d2 = kVar.d();
            int n = kVar.n();
            if (kVar.n() == a.aB) {
                kVar.c(d2);
                return a(kVar, d2 + n);
            }
            kVar.d(n - 8);
        }
        return null;
    }

    private static com.google.android.exoplayer2.f.a a(k kVar, int i) {
        kVar.d(12);
        while (kVar.d() < i) {
            int d2 = kVar.d();
            int n = kVar.n();
            if (kVar.n() == a.aC) {
                kVar.c(d2);
                return b(kVar, d2 + n);
            }
            kVar.d(n - 8);
        }
        return null;
    }

    private static com.google.android.exoplayer2.f.a b(k kVar, int i) {
        kVar.d(8);
        ArrayList arrayList = new ArrayList();
        while (kVar.d() < i) {
            a.C0166a a2 = f.a(kVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new com.google.android.exoplayer2.f.a((List<? extends a.C0166a>) arrayList);
    }

    private static long a(k kVar) {
        int i = 8;
        kVar.c(8);
        if (a.a(kVar.n()) != 0) {
            i = 16;
        }
        kVar.d(i);
        return kVar.l();
    }

    private static f b(k kVar) {
        boolean z;
        int i = 8;
        kVar.c(8);
        int a2 = a.a(kVar.n());
        kVar.d(a2 == 0 ? 8 : 16);
        int n = kVar.n();
        kVar.d(4);
        int d2 = kVar.d();
        if (a2 == 0) {
            i = 4;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                z = true;
                break;
            } else if (kVar.f10948a[d2 + i3] != -1) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        long j = -9223372036854775807L;
        if (z) {
            kVar.d(i);
        } else {
            long l = a2 == 0 ? kVar.l() : kVar.v();
            if (l != 0) {
                j = l;
            }
        }
        kVar.d(16);
        int n2 = kVar.n();
        int n3 = kVar.n();
        kVar.d(4);
        int n4 = kVar.n();
        int n5 = kVar.n();
        if (n2 == 0 && n3 == 65536 && n4 == -65536 && n5 == 0) {
            i2 = 90;
        } else if (n2 == 0 && n3 == -65536 && n4 == 65536 && n5 == 0) {
            i2 = 270;
        } else if (n2 == -65536 && n3 == 0 && n4 == 0 && n5 == -65536) {
            i2 = 180;
        }
        return new f(n, j, i2);
    }

    private static int c(k kVar) {
        kVar.c(16);
        int n = kVar.n();
        if (n == f9416b) {
            return 1;
        }
        if (n == f9415a) {
            return 2;
        }
        if (n == f9417c || n == f9418d || n == f9419e || n == f9420f) {
            return 3;
        }
        return n == h ? 4 : -1;
    }

    private static Pair<Long, String> d(k kVar) {
        int i = 8;
        kVar.c(8);
        int a2 = a.a(kVar.n());
        kVar.d(a2 == 0 ? 8 : 16);
        long l = kVar.l();
        if (a2 == 0) {
            i = 4;
        }
        kVar.d(i);
        int h2 = kVar.h();
        return Pair.create(Long.valueOf(l), "" + ((char) (((h2 >> 10) & 31) + 96)) + ((char) (((h2 >> 5) & 31) + 96)) + ((char) ((h2 & 31) + 96)));
    }

    private static c a(k kVar, int i, int i2, String str, com.google.android.exoplayer2.c.a aVar, boolean z) throws ak {
        k kVar2 = kVar;
        kVar2.c(12);
        int n = kVar.n();
        c cVar = new c(n);
        for (int i3 = 0; i3 < n; i3++) {
            int d2 = kVar.d();
            int n2 = kVar.n();
            com.google.android.exoplayer2.n.a.a(n2 > 0, "childAtomSize should be positive");
            int n3 = kVar.n();
            if (n3 == a.f9402b || n3 == a.f9403c || n3 == a.Z || n3 == a.al || n3 == a.f9404d || n3 == a.f9405e || n3 == a.f9406f || n3 == a.aK || n3 == a.aL) {
                a(kVar, n3, d2, n2, i, i2, aVar, cVar, i3);
            } else if (n3 == a.i || n3 == a.aa || n3 == a.n || n3 == a.p || n3 == a.r || n3 == a.u || n3 == a.s || n3 == a.t || n3 == a.ay || n3 == a.az || n3 == a.l || n3 == a.m || n3 == a.j || n3 == a.aO) {
                com.google.android.exoplayer2.c.a aVar2 = aVar;
                a(kVar, n3, d2, n2, i, str, z, aVar, cVar, i3);
            } else if (n3 == a.aj || n3 == a.au || n3 == a.av || n3 == a.aw || n3 == a.ax) {
                com.google.android.exoplayer2.c.a aVar3 = aVar;
                a(kVar, n3, d2, n2, i, str, aVar, cVar);
            } else if (n3 == a.aN) {
                cVar.f9430b = j.a(Integer.toString(i), "application/x-camera-motion", (String) null, -1, aVar);
            } else {
                com.google.android.exoplayer2.c.a aVar4 = aVar;
            }
            kVar2.c(d2 + n2);
        }
        return cVar;
    }

    private static void a(k kVar, int i, int i2, int i3, int i4, String str, com.google.android.exoplayer2.c.a aVar, c cVar) throws ak {
        k kVar2 = kVar;
        int i5 = i;
        c cVar2 = cVar;
        kVar2.c(i2 + 8 + 8);
        int i6 = a.aj;
        String str2 = "application/ttml+xml";
        List list = null;
        long j = Clock.MAX_TIME;
        if (i5 != i6) {
            if (i5 == a.au) {
                int i7 = (i3 - 8) - 8;
                byte[] bArr = new byte[i7];
                kVar2.a(bArr, 0, i7);
                list = Collections.singletonList(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i5 == a.av) {
                str2 = "application/x-mp4-vtt";
            } else if (i5 == a.aw) {
                j = 0;
            } else if (i5 == a.ax) {
                cVar2.f9432d = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        cVar2.f9430b = j.a(Integer.toString(i4), str2, (String) null, -1, 0, str, -1, aVar, j, (List<byte[]>) list);
    }

    private static void a(k kVar, int i, int i2, int i3, int i4, int i5, com.google.android.exoplayer2.c.a aVar, c cVar, int i6) throws ak {
        int i7;
        k kVar2 = kVar;
        int i8 = i2;
        int i9 = i3;
        c cVar2 = cVar;
        kVar2.c(i8 + 8 + 8);
        kVar2.d(16);
        int h2 = kVar.h();
        int h3 = kVar.h();
        kVar2.d(50);
        int d2 = kVar.d();
        int i10 = i;
        if (i10 == a.Z) {
            i7 = a(kVar2, i8, i9, cVar2, i6);
            kVar2.c(d2);
        } else {
            i7 = i10;
        }
        String str = null;
        List<byte[]> list = null;
        byte[] bArr = null;
        boolean z = false;
        float f2 = 1.0f;
        int i11 = -1;
        while (d2 - i8 < i9) {
            kVar2.c(d2);
            int d3 = kVar.d();
            int n = kVar.n();
            if (n == 0 && kVar.d() - i8 == i9) {
                break;
            }
            com.google.android.exoplayer2.n.a.a(n > 0, "childAtomSize should be positive");
            int n2 = kVar.n();
            if (n2 == a.H) {
                com.google.android.exoplayer2.n.a.b(str == null);
                kVar2.c(d3 + 8);
                com.google.android.exoplayer2.k.a a2 = com.google.android.exoplayer2.k.a.a(kVar);
                list = a2.f10633a;
                cVar2.f9431c = a2.f10634b;
                if (!z) {
                    f2 = a2.f10637e;
                }
                str = "video/avc";
            } else if (n2 == a.I) {
                com.google.android.exoplayer2.n.a.b(str == null);
                kVar2.c(d3 + 8);
                com.google.android.exoplayer2.k.c a3 = com.google.android.exoplayer2.k.c.a(kVar);
                list = a3.f10643a;
                cVar2.f9431c = a3.f10644b;
                str = "video/hevc";
            } else if (n2 == a.aM) {
                com.google.android.exoplayer2.n.a.b(str == null);
                str = i7 == a.aK ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
            } else if (n2 == a.f9407g) {
                com.google.android.exoplayer2.n.a.b(str == null);
                str = "video/3gpp";
            } else if (n2 == a.J) {
                com.google.android.exoplayer2.n.a.b(str == null);
                Pair<String, byte[]> d4 = d(kVar2, d3);
                str = (String) d4.first;
                list = Collections.singletonList(d4.second);
            } else if (n2 == a.ai) {
                f2 = c(kVar2, d3);
                z = true;
            } else if (n2 == a.aI) {
                bArr = d(kVar2, d3, n);
            } else if (n2 == a.aH) {
                int g2 = kVar.g();
                kVar2.d(3);
                if (g2 == 0) {
                    int g3 = kVar.g();
                    if (g3 == 0) {
                        i11 = 0;
                    } else if (g3 == 1) {
                        i11 = 1;
                    } else if (g3 == 2) {
                        i11 = 2;
                    } else if (g3 == 3) {
                        i11 = 3;
                    }
                }
            }
            d2 += n;
            i8 = i2;
        }
        if (str != null) {
            cVar2.f9430b = j.a(Integer.toString(i4), str, (String) null, -1, -1, h2, h3, -1.0f, list, i5, f2, bArr, i11, (com.google.android.exoplayer2.k.b) null, aVar);
        }
    }

    private static Pair<long[], long[]> a(a.C0162a aVar) {
        if (aVar != null) {
            a.b d2 = aVar.d(a.Q);
            if (d2 != null) {
                k kVar = d2.aQ;
                kVar.c(8);
                int a2 = a.a(kVar.n());
                int t = kVar.t();
                long[] jArr = new long[t];
                long[] jArr2 = new long[t];
                int i = 0;
                while (i < t) {
                    jArr[i] = a2 == 1 ? kVar.v() : kVar.l();
                    jArr2[i] = a2 == 1 ? kVar.p() : (long) kVar.n();
                    if (kVar.j() == 1) {
                        kVar.d(2);
                        i++;
                    } else {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                }
                return Pair.create(jArr, jArr2);
            }
        }
        return Pair.create((Object) null, (Object) null);
    }

    private static float c(k kVar, int i) {
        kVar.c(i + 8);
        return ((float) kVar.t()) / ((float) kVar.t());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.google.android.exoplayer2.n.k r28, int r29, int r30, int r31, int r32, java.lang.String r33, boolean r34, com.google.android.exoplayer2.c.a r35, com.google.android.exoplayer2.e.d.b.c r36, int r37) {
        /*
            r0 = r28
            r1 = r30
            r2 = r31
            r14 = r33
            r15 = r35
            r13 = r36
            int r3 = r1 + 8
            r4 = 8
            int r3 = r3 + r4
            r0.c(r3)
            r3 = 6
            r12 = 0
            if (r34 == 0) goto L_0x0020
            int r4 = r28.h()
            r0.d(r3)
            goto L_0x0024
        L_0x0020:
            r0.d(r4)
            r4 = 0
        L_0x0024:
            r11 = 2
            r5 = 16
            r10 = 1
            if (r4 == 0) goto L_0x0048
            if (r4 != r10) goto L_0x002d
            goto L_0x0048
        L_0x002d:
            if (r4 != r11) goto L_0x0047
            r0.d(r5)
            double r3 = r28.w()
            long r3 = java.lang.Math.round(r3)
            int r4 = (int) r3
            int r3 = r28.t()
            r5 = 20
            r0.d(r5)
            r6 = r3
            r3 = r4
            goto L_0x0058
        L_0x0047:
            return
        L_0x0048:
            int r6 = r28.h()
            r0.d(r3)
            int r3 = r28.r()
            if (r4 != r10) goto L_0x0058
            r0.d(r5)
        L_0x0058:
            int r4 = r28.d()
            int r5 = com.google.android.exoplayer2.e.d.a.aa
            r7 = r29
            if (r7 != r5) goto L_0x006c
            r5 = r37
            int r5 = a((com.google.android.exoplayer2.n.k) r0, (int) r1, (int) r2, (com.google.android.exoplayer2.e.d.b.c) r13, (int) r5)
            r0.c(r4)
            r7 = r5
        L_0x006c:
            int r5 = com.google.android.exoplayer2.e.d.a.n
            java.lang.String r9 = "audio/raw"
            r16 = 0
            if (r7 != r5) goto L_0x0077
            java.lang.String r5 = "audio/ac3"
            goto L_0x00c1
        L_0x0077:
            int r5 = com.google.android.exoplayer2.e.d.a.p
            if (r7 != r5) goto L_0x007e
            java.lang.String r5 = "audio/eac3"
            goto L_0x00c1
        L_0x007e:
            int r5 = com.google.android.exoplayer2.e.d.a.r
            if (r7 != r5) goto L_0x0085
            java.lang.String r5 = "audio/vnd.dts"
            goto L_0x00c1
        L_0x0085:
            int r5 = com.google.android.exoplayer2.e.d.a.s
            if (r7 == r5) goto L_0x00bf
            int r5 = com.google.android.exoplayer2.e.d.a.t
            if (r7 != r5) goto L_0x008e
            goto L_0x00bf
        L_0x008e:
            int r5 = com.google.android.exoplayer2.e.d.a.u
            if (r7 != r5) goto L_0x0095
            java.lang.String r5 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x00c1
        L_0x0095:
            int r5 = com.google.android.exoplayer2.e.d.a.ay
            if (r7 != r5) goto L_0x009c
            java.lang.String r5 = "audio/3gpp"
            goto L_0x00c1
        L_0x009c:
            int r5 = com.google.android.exoplayer2.e.d.a.az
            if (r7 != r5) goto L_0x00a3
            java.lang.String r5 = "audio/amr-wb"
            goto L_0x00c1
        L_0x00a3:
            int r5 = com.google.android.exoplayer2.e.d.a.l
            if (r7 == r5) goto L_0x00bd
            int r5 = com.google.android.exoplayer2.e.d.a.m
            if (r7 != r5) goto L_0x00ac
            goto L_0x00bd
        L_0x00ac:
            int r5 = com.google.android.exoplayer2.e.d.a.j
            if (r7 != r5) goto L_0x00b3
            java.lang.String r5 = "audio/mpeg"
            goto L_0x00c1
        L_0x00b3:
            int r5 = com.google.android.exoplayer2.e.d.a.aO
            if (r7 != r5) goto L_0x00ba
            java.lang.String r5 = "audio/alac"
            goto L_0x00c1
        L_0x00ba:
            r5 = r16
            goto L_0x00c1
        L_0x00bd:
            r5 = r9
            goto L_0x00c1
        L_0x00bf:
            java.lang.String r5 = "audio/vnd.dts.hd"
        L_0x00c1:
            r18 = r3
            r8 = r4
            r7 = r5
            r17 = r6
            r19 = r16
        L_0x00c9:
            int r3 = r8 - r1
            r4 = -1
            if (r3 >= r2) goto L_0x01d6
            r0.c(r8)
            int r6 = r28.n()
            if (r6 <= 0) goto L_0x00d9
            r3 = 1
            goto L_0x00da
        L_0x00d9:
            r3 = 0
        L_0x00da:
            java.lang.String r5 = "childAtomSize should be positive"
            com.google.android.exoplayer2.n.a.a(r3, r5)
            int r3 = r28.n()
            int r5 = com.google.android.exoplayer2.e.d.a.J
            if (r3 == r5) goto L_0x0181
            if (r34 == 0) goto L_0x00ef
            int r5 = com.google.android.exoplayer2.e.d.a.k
            if (r3 != r5) goto L_0x00ef
            goto L_0x0181
        L_0x00ef:
            int r4 = com.google.android.exoplayer2.e.d.a.o
            if (r3 != r4) goto L_0x0110
            int r3 = r8 + 8
            r0.c(r3)
            java.lang.String r3 = java.lang.Integer.toString(r32)
            com.google.android.exoplayer2.j r3 = com.google.android.exoplayer2.a.a.a(r0, r3, r14, r15)
            r13.f9430b = r3
        L_0x0102:
            r5 = r6
            r25 = r7
            r6 = r8
            r27 = r9
            r2 = r13
            r7 = 0
            r20 = 1
            r21 = 2
            goto L_0x01c8
        L_0x0110:
            int r4 = com.google.android.exoplayer2.e.d.a.q
            if (r3 != r4) goto L_0x0124
            int r3 = r8 + 8
            r0.c(r3)
            java.lang.String r3 = java.lang.Integer.toString(r32)
            com.google.android.exoplayer2.j r3 = com.google.android.exoplayer2.a.a.b(r0, r3, r14, r15)
            r13.f9430b = r3
            goto L_0x0102
        L_0x0124:
            int r4 = com.google.android.exoplayer2.e.d.a.v
            if (r3 != r4) goto L_0x015a
            java.lang.String r3 = java.lang.Integer.toString(r32)
            r5 = 0
            r20 = -1
            r21 = -1
            r22 = 0
            r23 = 0
            r4 = r7
            r24 = r6
            r6 = r20
            r25 = r7
            r7 = r21
            r26 = r8
            r8 = r17
            r27 = r9
            r9 = r18
            r20 = 1
            r10 = r22
            r21 = 2
            r11 = r35
            r12 = r23
            r2 = r13
            r13 = r33
            com.google.android.exoplayer2.j r3 = com.google.android.exoplayer2.j.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r2.f9430b = r3
            goto L_0x017b
        L_0x015a:
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r9
            r2 = r13
            r20 = 1
            r21 = 2
            int r4 = com.google.android.exoplayer2.e.d.a.aO
            if (r3 != r4) goto L_0x017b
            r5 = r24
            byte[] r3 = new byte[r5]
            r6 = r26
            r0.c(r6)
            r7 = 0
            r0.a(r3, r7, r5)
            r19 = r3
            goto L_0x01c8
        L_0x017b:
            r5 = r24
            r6 = r26
            r7 = 0
            goto L_0x01c8
        L_0x0181:
            r5 = r6
            r25 = r7
            r6 = r8
            r27 = r9
            r2 = r13
            r7 = 0
            r20 = 1
            r21 = 2
            int r8 = com.google.android.exoplayer2.e.d.a.J
            if (r3 != r8) goto L_0x0193
            r8 = r6
            goto L_0x0197
        L_0x0193:
            int r8 = a((com.google.android.exoplayer2.n.k) r0, (int) r6, (int) r5)
        L_0x0197:
            if (r8 == r4) goto L_0x01c4
            android.util.Pair r3 = d(r0, r8)
            java.lang.Object r4 = r3.first
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.second
            r19 = r3
            byte[] r19 = (byte[]) r19
            java.lang.String r3 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x01c6
            android.util.Pair r3 = com.google.android.exoplayer2.n.b.a((byte[]) r19)
            java.lang.Object r8 = r3.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r18 = r8.intValue()
            java.lang.Object r3 = r3.second
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r17 = r3.intValue()
            goto L_0x01c6
        L_0x01c4:
            r4 = r25
        L_0x01c6:
            r25 = r4
        L_0x01c8:
            int r8 = r6 + r5
            r13 = r2
            r7 = r25
            r9 = r27
            r10 = 1
            r11 = 2
            r12 = 0
            r2 = r31
            goto L_0x00c9
        L_0x01d6:
            r25 = r7
            r27 = r9
            r2 = r13
            r21 = 2
            com.google.android.exoplayer2.j r0 = r2.f9430b
            if (r0 != 0) goto L_0x0215
            r5 = r25
            if (r5 == 0) goto L_0x0215
            r0 = r27
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x01ef
            r7 = 2
            goto L_0x01f0
        L_0x01ef:
            r7 = -1
        L_0x01f0:
            java.lang.String r0 = java.lang.Integer.toString(r32)
            r3 = 0
            r4 = -1
            r6 = -1
            if (r19 != 0) goto L_0x01fc
            r8 = r16
            goto L_0x0201
        L_0x01fc:
            java.util.List r1 = java.util.Collections.singletonList(r19)
            r8 = r1
        L_0x0201:
            r10 = 0
            r1 = r5
            r12 = r2
            r2 = r3
            r3 = r4
            r4 = r6
            r5 = r17
            r6 = r18
            r9 = r35
            r11 = r33
            com.google.android.exoplayer2.j r0 = com.google.android.exoplayer2.j.a((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (java.util.List<byte[]>) r8, (com.google.android.exoplayer2.c.a) r9, (int) r10, (java.lang.String) r11)
            r12.f9430b = r0
        L_0x0215:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.d.b.a(com.google.android.exoplayer2.n.k, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.c.a, com.google.android.exoplayer2.e.d.b$c, int):void");
    }

    private static int a(k kVar, int i, int i2) {
        int d2 = kVar.d();
        while (d2 - i < i2) {
            kVar.c(d2);
            int n = kVar.n();
            com.google.android.exoplayer2.n.a.a(n > 0, "childAtomSize should be positive");
            if (kVar.n() == a.J) {
                return d2;
            }
            d2 += n;
        }
        return -1;
    }

    private static Pair<String, byte[]> d(k kVar, int i) {
        kVar.c(i + 8 + 4);
        kVar.d(1);
        e(kVar);
        kVar.d(2);
        int g2 = kVar.g();
        if ((g2 & 128) != 0) {
            kVar.d(2);
        }
        if ((g2 & 64) != 0) {
            kVar.d(kVar.h());
        }
        if ((g2 & 32) != 0) {
            kVar.d(2);
        }
        kVar.d(1);
        e(kVar);
        int g3 = kVar.g();
        String str = null;
        if (g3 == 32) {
            str = "video/mp4v-es";
        } else if (g3 == 33) {
            str = "video/avc";
        } else if (g3 != 35) {
            if (g3 != 64) {
                if (g3 == 107) {
                    return Pair.create("audio/mpeg", (Object) null);
                }
                if (g3 == 165) {
                    str = "audio/ac3";
                } else if (g3 != 166) {
                    switch (g3) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (g3) {
                                case 169:
                                case 172:
                                    return Pair.create("audio/vnd.dts", (Object) null);
                                case 170:
                                case 171:
                                    return Pair.create("audio/vnd.dts.hd", (Object) null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        kVar.d(12);
        kVar.d(1);
        int e2 = e(kVar);
        byte[] bArr = new byte[e2];
        kVar.a(bArr, 0, e2);
        return Pair.create(str, bArr);
    }

    private static int a(k kVar, int i, int i2, c cVar, int i3) {
        int d2 = kVar.d();
        while (true) {
            boolean z = false;
            if (d2 - i >= i2) {
                return 0;
            }
            kVar.c(d2);
            int n = kVar.n();
            if (n > 0) {
                z = true;
            }
            com.google.android.exoplayer2.n.a.a(z, "childAtomSize should be positive");
            if (kVar.n() == a.V) {
                Pair<Integer, k> b2 = b(kVar, d2, n);
                if (b2 != null) {
                    cVar.f9429a[i3] = (k) b2.second;
                    return ((Integer) b2.first).intValue();
                }
            }
            d2 += n;
        }
    }

    private static Pair<Integer, k> b(k kVar, int i, int i2) {
        int i3 = i + 8;
        boolean z = false;
        Integer num = null;
        k kVar2 = null;
        boolean z2 = false;
        while (true) {
            boolean z3 = true;
            if (i3 - i >= i2) {
                break;
            }
            kVar.c(i3);
            int n = kVar.n();
            int n2 = kVar.n();
            if (n2 == a.ab) {
                num = Integer.valueOf(kVar.n());
            } else if (n2 == a.W) {
                kVar.d(4);
                if (kVar.n() != f9421g) {
                    z3 = false;
                }
                z2 = z3;
            } else if (n2 == a.X) {
                kVar2 = c(kVar, i3, n);
            }
            i3 += n;
        }
        if (!z2) {
            return null;
        }
        com.google.android.exoplayer2.n.a.a(num != null, "frma atom is mandatory");
        if (kVar2 != null) {
            z = true;
        }
        com.google.android.exoplayer2.n.a.a(z, "schi->tenc atom is mandatory");
        return Pair.create(num, kVar2);
    }

    private static k c(k kVar, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            kVar.c(i3);
            int n = kVar.n();
            if (kVar.n() == a.Y) {
                kVar.d(6);
                boolean z = true;
                if (kVar.g() != 1) {
                    z = false;
                }
                int g2 = kVar.g();
                byte[] bArr = new byte[16];
                kVar.a(bArr, 0, bArr.length);
                return new k(z, g2, bArr);
            }
            i3 += n;
        }
        return null;
    }

    private static byte[] d(k kVar, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            kVar.c(i3);
            int n = kVar.n();
            if (kVar.n() == a.aJ) {
                return Arrays.copyOfRange(kVar.f10948a, i3, n + i3);
            }
            i3 += n;
        }
        return null;
    }

    private static int e(k kVar) {
        int g2 = kVar.g();
        int i = g2 & 127;
        while ((g2 & 128) == 128) {
            g2 = kVar.g();
            i = (i << 7) | (g2 & 127);
        }
        return i;
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f9422a;

        /* renamed from: b  reason: collision with root package name */
        public int f9423b;

        /* renamed from: c  reason: collision with root package name */
        public int f9424c;

        /* renamed from: d  reason: collision with root package name */
        public long f9425d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f9426e;

        /* renamed from: f  reason: collision with root package name */
        private final k f9427f;

        /* renamed from: g  reason: collision with root package name */
        private final k f9428g;
        private int h;
        private int i;

        public a(k kVar, k kVar2, boolean z) {
            this.f9428g = kVar;
            this.f9427f = kVar2;
            this.f9426e = z;
            kVar2.c(12);
            this.f9422a = kVar2.t();
            kVar.c(12);
            this.i = kVar.t();
            com.google.android.exoplayer2.n.a.b(kVar.n() != 1 ? false : true, "first_chunk must be 1");
            this.f9423b = -1;
        }

        public boolean a() {
            long j;
            int i2 = this.f9423b + 1;
            this.f9423b = i2;
            if (i2 == this.f9422a) {
                return false;
            }
            if (this.f9426e) {
                j = this.f9427f.v();
            } else {
                j = this.f9427f.l();
            }
            this.f9425d = j;
            if (this.f9423b == this.h) {
                this.f9424c = this.f9428g.t();
                this.f9428g.d(4);
                int i3 = this.i - 1;
                this.i = i3;
                this.h = i3 > 0 ? this.f9428g.t() - 1 : -1;
            }
            return true;
        }
    }

    private static final class f {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f9441a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f9442b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f9443c;

        public f(int i, long j, int i2) {
            this.f9441a = i;
            this.f9442b = j;
            this.f9443c = i2;
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final k[] f9429a;

        /* renamed from: b  reason: collision with root package name */
        public j f9430b;

        /* renamed from: c  reason: collision with root package name */
        public int f9431c;

        /* renamed from: d  reason: collision with root package name */
        public int f9432d = 0;

        public c(int i) {
            this.f9429a = new k[i];
        }
    }

    static final class d implements C0163b {

        /* renamed from: a  reason: collision with root package name */
        private final int f9433a = this.f9435c.t();

        /* renamed from: b  reason: collision with root package name */
        private final int f9434b = this.f9435c.t();

        /* renamed from: c  reason: collision with root package name */
        private final k f9435c;

        public d(a.b bVar) {
            this.f9435c = bVar.aQ;
            this.f9435c.c(12);
        }

        public int a() {
            return this.f9434b;
        }

        public int b() {
            int i = this.f9433a;
            return i == 0 ? this.f9435c.t() : i;
        }

        public boolean c() {
            return this.f9433a != 0;
        }
    }

    static final class e implements C0163b {

        /* renamed from: a  reason: collision with root package name */
        private final k f9436a;

        /* renamed from: b  reason: collision with root package name */
        private final int f9437b = this.f9436a.t();

        /* renamed from: c  reason: collision with root package name */
        private final int f9438c = (this.f9436a.t() & 255);

        /* renamed from: d  reason: collision with root package name */
        private int f9439d;

        /* renamed from: e  reason: collision with root package name */
        private int f9440e;

        public boolean c() {
            return false;
        }

        public e(a.b bVar) {
            this.f9436a = bVar.aQ;
            this.f9436a.c(12);
        }

        public int a() {
            return this.f9437b;
        }

        public int b() {
            int i = this.f9438c;
            if (i == 8) {
                return this.f9436a.g();
            }
            if (i == 16) {
                return this.f9436a.h();
            }
            int i2 = this.f9439d;
            this.f9439d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.f9440e & 15;
            }
            this.f9440e = this.f9436a.g();
            return (this.f9440e & 240) >> 4;
        }
    }
}
