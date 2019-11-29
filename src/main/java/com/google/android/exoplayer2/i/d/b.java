package com.google.android.exoplayer2.i.d;

import android.util.Log;
import android.util.Pair;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.d.a;
import com.google.android.exoplayer2.i.d.d;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.v;
import com.google.android.exoplayer2.video.ColorInfo;
import com.path.android.jobqueue.JobManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f10045a = v.g("vide");

    /* renamed from: b  reason: collision with root package name */
    private static final int f10046b = v.g("soun");

    /* renamed from: c  reason: collision with root package name */
    private static final int f10047c = v.g("text");

    /* renamed from: d  reason: collision with root package name */
    private static final int f10048d = v.g("sbtl");

    /* renamed from: e  reason: collision with root package name */
    private static final int f10049e = v.g("subt");

    /* renamed from: f  reason: collision with root package name */
    private static final int f10050f = v.g("clcp");

    /* renamed from: g  reason: collision with root package name */
    private static final int f10051g = v.g("cenc");
    private static final int h = v.g("meta");

    /* renamed from: com.google.android.exoplayer2.i.d.b$b  reason: collision with other inner class name */
    private interface C0170b {
        int a();

        int b();

        boolean c();
    }

    public static j a(a.C0169a aVar, a.b bVar, long j, DrmInitData drmInitData, boolean z) throws p {
        long j2;
        a.b bVar2;
        a.C0169a aVar2 = aVar;
        a.C0169a e2 = aVar2.e(a.E);
        int c2 = c(e2.d(a.S).aQ);
        if (c2 == -1) {
            return null;
        }
        f b2 = b(aVar2.d(a.O).aQ);
        long j3 = -9223372036854775807L;
        if (j == -9223372036854775807L) {
            j2 = b2.f10072b;
            bVar2 = bVar;
        } else {
            bVar2 = bVar;
            j2 = j;
        }
        long a2 = a(bVar2.aQ);
        if (j2 != -9223372036854775807L) {
            j3 = v.b(j2, JobManager.NS_PER_MS, a2);
        }
        long j4 = j3;
        a.C0169a e3 = e2.e(a.F).e(a.G);
        Pair<Long, String> d2 = d(e2.d(a.R).aQ);
        c a3 = a(e3.d(a.T).aQ, b2.f10071a, b2.f10073c, (String) d2.second, drmInitData, z);
        Pair<long[], long[]> a4 = a(aVar2.e(a.P));
        if (a3.f10060b == null) {
            return null;
        }
        int b3 = b2.f10071a;
        long longValue = ((Long) d2.first).longValue();
        Format format = a3.f10060b;
        int i = a3.f10062d;
        k[] kVarArr = a3.f10059a;
        int i2 = a3.f10061c;
        return new j(b3, c2, longValue, a2, j4, format, i, kVarArr, i2, (long[]) a4.first, (long[]) a4.second);
    }

    public static m a(j jVar, a.C0169a aVar, i iVar) throws p {
        C0170b bVar;
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
        j jVar2 = jVar;
        a.C0169a aVar2 = aVar;
        i iVar2 = iVar;
        a.b d2 = aVar2.d(a.aq);
        if (d2 != null) {
            bVar = new d(d2);
        } else {
            a.b d3 = aVar2.d(a.ar);
            if (d3 != null) {
                bVar = new e(d3);
            } else {
                throw new p("Track has no sample table size information");
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
        l lVar = d4.aQ;
        l lVar2 = aVar2.d(a.ap).aQ;
        l lVar3 = aVar2.d(a.am).aQ;
        a.b d5 = aVar2.d(a.an);
        l lVar4 = d5 != null ? d5.aQ : null;
        a.b d6 = aVar2.d(a.ao);
        l lVar5 = d6 != null ? d6.aQ : null;
        a aVar3 = new a(lVar2, lVar, z);
        lVar3.c(12);
        int t = lVar3.t() - 1;
        int t2 = lVar3.t();
        int t3 = lVar3.t();
        if (lVar5 != null) {
            lVar5.c(12);
            i = lVar5.t();
        } else {
            i = 0;
        }
        int i8 = -1;
        if (lVar4 != null) {
            lVar4.c(12);
            i2 = lVar4.t();
            if (i2 > 0) {
                i8 = lVar4.t() - 1;
            } else {
                lVar4 = null;
            }
        } else {
            i2 = 0;
        }
        long j2 = 0;
        if (!(bVar.c() && "audio/raw".equals(jVar2.f10123f.f8958f) && t == 0 && i == 0 && i2 == 0)) {
            jArr2 = new long[a2];
            iArr = new int[a2];
            jArr = new long[a2];
            int i9 = i2;
            iArr2 = new int[a2];
            int i10 = i9;
            l lVar6 = lVar3;
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
                    com.google.android.exoplayer2.s.a.b(aVar3.a());
                    j5 = aVar3.f10055d;
                    i21 = aVar3.f10054c;
                    i19 = i19;
                    i11 = i11;
                }
                int i22 = i19;
                int i23 = i11;
                if (lVar5 != null) {
                    while (i17 == 0 && i12 > 0) {
                        i17 = lVar5.t();
                        i16 = lVar5.n();
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
                C0170b bVar2 = bVar;
                jArr[i20] = j4 + ((long) i24);
                iArr2[i20] = lVar4 == null ? 1 : 0;
                if (i20 == i13) {
                    iArr2[i20] = 1;
                    i10--;
                    if (i10 > 0) {
                        i13 = lVar4.t() - 1;
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
                    i18 = lVar6.t();
                    i27 = lVar6.t();
                }
                int i28 = i7;
                i20++;
                i13 = i26;
                a2 = i6;
                i14 = i21 - 1;
                i16 = i24;
                i19 = i28;
                j3 = j5 + ((long) iArr[i20]);
                C0170b bVar3 = bVar2;
                i11 = i27;
                i10 = i25;
                bVar = bVar3;
            }
            i4 = a2;
            int i29 = i19;
            com.google.android.exoplayer2.s.a.a(i17 == 0);
            while (i12 > 0) {
                com.google.android.exoplayer2.s.a.a(lVar5.t() == 0);
                lVar5.n();
                i12--;
            }
            if (i10 == 0 && i18 == 0 && i14 == 0 && i29 == 0) {
                jVar2 = jVar;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Inconsistent stbl box for track ");
                int i30 = i10;
                jVar2 = jVar;
                sb.append(jVar2.f10118a);
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
            C0170b bVar4 = bVar;
            long[] jArr4 = new long[aVar3.f10052a];
            int[] iArr7 = new int[aVar3.f10052a];
            while (aVar3.a()) {
                jArr4[aVar3.f10053b] = aVar3.f10055d;
                iArr7[aVar3.f10053b] = aVar3.f10054c;
            }
            d.a a3 = d.a(bVar4.b(), jArr4, iArr7, (long) t3);
            jArr2 = a3.f10078a;
            iArr = a3.f10079b;
            int i31 = a3.f10080c;
            jArr = a3.f10081d;
            iArr2 = a3.f10082e;
            i3 = i31;
            j = 0;
        }
        if (jVar2.h == null || iVar.a()) {
            v.a(jArr, (long) JobManager.NS_PER_MS, jVar2.f10120c);
            return new m(jArr2, iArr, i3, jArr, iArr2);
        }
        if (jVar2.h.length == 1 && jVar2.f10119b == 1 && jArr.length >= 2) {
            long j6 = jVar2.i[0];
            long b2 = v.b(jVar2.h[0], jVar2.f10120c, jVar2.f10121d) + j6;
            if (jArr[0] <= j6 && j6 < jArr[1] && jArr[jArr.length - 1] < b2 && b2 <= j) {
                long j7 = j - b2;
                long b3 = v.b(j6 - jArr[0], (long) jVar2.f10123f.s, jVar2.f10120c);
                long b4 = v.b(j7, (long) jVar2.f10123f.s, jVar2.f10120c);
                if (!(b3 == 0 && b4 == 0) && b3 <= 2147483647L && b4 <= 2147483647L) {
                    int i32 = (int) b3;
                    i iVar3 = iVar;
                    iVar3.f10407b = i32;
                    iVar3.f10408c = (int) b4;
                    v.a(jArr, (long) JobManager.NS_PER_MS, jVar2.f10120c);
                    return new m(jArr2, iArr, i3, jArr, iArr2);
                }
            }
        }
        if (jVar2.h.length == 1) {
            char c2 = 0;
            if (jVar2.h[0] == 0) {
                int i33 = 0;
                while (i33 < jArr.length) {
                    jArr[i33] = v.b(jArr[i33] - jVar2.i[c2], JobManager.NS_PER_MS, jVar2.f10120c);
                    i33++;
                    c2 = 0;
                }
                return new m(jArr2, iArr, i3, jArr, iArr2);
            }
        }
        boolean z3 = jVar2.f10119b == 1;
        int i34 = 0;
        boolean z4 = false;
        int i35 = 0;
        int i36 = 0;
        while (i34 < jVar2.h.length) {
            long j8 = jVar2.i[i34];
            if (j8 != -1) {
                iArr6 = iArr;
                long b5 = v.b(jVar2.h[i34], jVar2.f10120c, jVar2.f10121d);
                int b6 = v.b(jArr, j8, true, true);
                int b7 = v.b(jArr, j8 + b5, z3, false);
                i35 += b7 - b6;
                z4 |= i36 != b6;
                i36 = b7;
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
        while (i38 < jVar2.h.length) {
            long j9 = jVar2.i[i38];
            long j10 = jVar2.h[i38];
            if (j9 != -1) {
                long j11 = jVar2.f10120c;
                int[] iArr11 = iArr10;
                i5 = i38;
                int b8 = v.b(jArr, j9, true, true);
                int b9 = v.b(jArr, v.b(j10, j11, jVar2.f10121d) + j9, z3, false);
                if (z5) {
                    int i40 = b9 - b8;
                    System.arraycopy(jArr2, b8, jArr5, i39, i40);
                    iArr4 = iArr8;
                    System.arraycopy(iArr4, b8, iArr9, i39, i40);
                    z2 = z3;
                    iArr5 = iArr11;
                    System.arraycopy(iArr2, b8, iArr5, i39, i40);
                } else {
                    iArr4 = iArr8;
                    z2 = z3;
                    iArr5 = iArr11;
                }
                int i41 = i37;
                while (b8 < b9) {
                    long[] jArr7 = jArr2;
                    int[] iArr12 = iArr2;
                    long j12 = j9;
                    jArr6[i39] = v.b(j2, JobManager.NS_PER_MS, jVar2.f10121d) + v.b(jArr[b8] - j9, JobManager.NS_PER_MS, jVar2.f10120c);
                    if (z5 && iArr9[i39] > i41) {
                        i41 = iArr4[b8];
                    }
                    i39++;
                    b8++;
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
        throw new p("The edited sample sequence does not contain a sync sample.");
    }

    public static Metadata a(a.b bVar, boolean z) {
        if (z) {
            return null;
        }
        l lVar = bVar.aQ;
        lVar.c(8);
        while (lVar.b() >= 8) {
            int d2 = lVar.d();
            int n = lVar.n();
            if (lVar.n() == a.aB) {
                lVar.c(d2);
                return a(lVar, d2 + n);
            }
            lVar.d(n - 8);
        }
        return null;
    }

    private static Metadata a(l lVar, int i) {
        lVar.d(12);
        while (lVar.d() < i) {
            int d2 = lVar.d();
            int n = lVar.n();
            if (lVar.n() == a.aC) {
                lVar.c(d2);
                return b(lVar, d2 + n);
            }
            lVar.d(n - 8);
        }
        return null;
    }

    private static Metadata b(l lVar, int i) {
        lVar.d(8);
        ArrayList arrayList = new ArrayList();
        while (lVar.d() < i) {
            Metadata.Entry a2 = f.a(lVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static long a(l lVar) {
        int i = 8;
        lVar.c(8);
        if (a.a(lVar.n()) != 0) {
            i = 16;
        }
        lVar.d(i);
        return lVar.l();
    }

    private static f b(l lVar) {
        boolean z;
        int i = 8;
        lVar.c(8);
        int a2 = a.a(lVar.n());
        lVar.d(a2 == 0 ? 8 : 16);
        int n = lVar.n();
        lVar.d(4);
        int d2 = lVar.d();
        if (a2 == 0) {
            i = 4;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                z = true;
                break;
            } else if (lVar.f11422a[d2 + i3] != -1) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        long j = -9223372036854775807L;
        if (z) {
            lVar.d(i);
        } else {
            long l = a2 == 0 ? lVar.l() : lVar.v();
            if (l != 0) {
                j = l;
            }
        }
        lVar.d(16);
        int n2 = lVar.n();
        int n3 = lVar.n();
        lVar.d(4);
        int n4 = lVar.n();
        int n5 = lVar.n();
        if (n2 == 0 && n3 == 65536 && n4 == -65536 && n5 == 0) {
            i2 = 90;
        } else if (n2 == 0 && n3 == -65536 && n4 == 65536 && n5 == 0) {
            i2 = 270;
        } else if (n2 == -65536 && n3 == 0 && n4 == 0 && n5 == -65536) {
            i2 = 180;
        }
        return new f(n, j, i2);
    }

    private static int c(l lVar) {
        lVar.c(16);
        int n = lVar.n();
        if (n == f10046b) {
            return 1;
        }
        if (n == f10045a) {
            return 2;
        }
        if (n == f10047c || n == f10048d || n == f10049e || n == f10050f) {
            return 3;
        }
        return n == h ? 4 : -1;
    }

    private static Pair<Long, String> d(l lVar) {
        int i = 8;
        lVar.c(8);
        int a2 = a.a(lVar.n());
        lVar.d(a2 == 0 ? 8 : 16);
        long l = lVar.l();
        if (a2 == 0) {
            i = 4;
        }
        lVar.d(i);
        int h2 = lVar.h();
        return Pair.create(Long.valueOf(l), "" + ((char) (((h2 >> 10) & 31) + 96)) + ((char) (((h2 >> 5) & 31) + 96)) + ((char) ((h2 & 31) + 96)));
    }

    private static c a(l lVar, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws p {
        l lVar2 = lVar;
        lVar2.c(12);
        int n = lVar.n();
        c cVar = new c(n);
        for (int i3 = 0; i3 < n; i3++) {
            int d2 = lVar.d();
            int n2 = lVar.n();
            com.google.android.exoplayer2.s.a.a(n2 > 0, "childAtomSize should be positive");
            int n3 = lVar.n();
            if (n3 == a.f10039b || n3 == a.f10040c || n3 == a.Z || n3 == a.al || n3 == a.f10041d || n3 == a.f10042e || n3 == a.f10043f || n3 == a.aK || n3 == a.aL) {
                a(lVar, n3, d2, n2, i, i2, drmInitData, cVar, i3);
            } else if (n3 == a.i || n3 == a.aa || n3 == a.n || n3 == a.p || n3 == a.r || n3 == a.u || n3 == a.s || n3 == a.t || n3 == a.ay || n3 == a.az || n3 == a.l || n3 == a.m || n3 == a.j || n3 == a.aO) {
                a(lVar, n3, d2, n2, i, str, z, drmInitData, cVar, i3);
            } else if (n3 == a.aj || n3 == a.au || n3 == a.av || n3 == a.aw || n3 == a.ax) {
                a(lVar, n3, d2, n2, i, str, cVar);
            } else if (n3 == a.aN) {
                cVar.f10060b = Format.a(Integer.toString(i), "application/x-camera-motion", (String) null, -1, (DrmInitData) null);
            }
            lVar2.c(d2 + n2);
        }
        return cVar;
    }

    private static void a(l lVar, int i, int i2, int i3, int i4, String str, c cVar) throws p {
        l lVar2 = lVar;
        int i5 = i;
        c cVar2 = cVar;
        lVar2.c(i2 + 8 + 8);
        int i6 = a.aj;
        String str2 = "application/ttml+xml";
        List list = null;
        long j = Clock.MAX_TIME;
        if (i5 != i6) {
            if (i5 == a.au) {
                int i7 = (i3 - 8) - 8;
                byte[] bArr = new byte[i7];
                lVar2.a(bArr, 0, i7);
                list = Collections.singletonList(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i5 == a.av) {
                str2 = "application/x-mp4-vtt";
            } else if (i5 == a.aw) {
                j = 0;
            } else if (i5 == a.ax) {
                cVar2.f10062d = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        cVar2.f10060b = Format.a(Integer.toString(i4), str2, (String) null, -1, 0, str, -1, (DrmInitData) null, j, (List<byte[]>) list);
    }

    private static void a(l lVar, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, c cVar, int i6) throws p {
        l lVar2 = lVar;
        int i7 = i2;
        int i8 = i3;
        DrmInitData drmInitData2 = drmInitData;
        c cVar2 = cVar;
        lVar2.c(i7 + 8 + 8);
        lVar2.d(16);
        int h2 = lVar.h();
        int h3 = lVar.h();
        lVar2.d(50);
        int d2 = lVar.d();
        String str = null;
        int i9 = i;
        if (i9 == a.Z) {
            Pair<Integer, k> b2 = b(lVar2, i7, i8);
            if (b2 != null) {
                i9 = ((Integer) b2.first).intValue();
                if (drmInitData2 == null) {
                    drmInitData2 = null;
                } else {
                    drmInitData2 = drmInitData2.a(((k) b2.second).f10126b);
                }
                cVar2.f10059a[i6] = (k) b2.second;
            }
            lVar2.c(d2);
        }
        DrmInitData drmInitData3 = drmInitData2;
        List<byte[]> list = null;
        byte[] bArr = null;
        boolean z = false;
        float f2 = 1.0f;
        int i10 = -1;
        while (d2 - i7 < i8) {
            lVar2.c(d2);
            int d3 = lVar.d();
            int n = lVar.n();
            if (n == 0 && lVar.d() - i7 == i8) {
                break;
            }
            com.google.android.exoplayer2.s.a.a(n > 0, "childAtomSize should be positive");
            int n2 = lVar.n();
            if (n2 == a.H) {
                com.google.android.exoplayer2.s.a.b(str == null);
                lVar2.c(d3 + 8);
                com.google.android.exoplayer2.video.a a2 = com.google.android.exoplayer2.video.a.a(lVar);
                list = a2.f12233a;
                cVar2.f10061c = a2.f12234b;
                if (!z) {
                    f2 = a2.f12237e;
                }
                str = "video/avc";
            } else if (n2 == a.I) {
                com.google.android.exoplayer2.s.a.b(str == null);
                lVar2.c(d3 + 8);
                com.google.android.exoplayer2.video.b a3 = com.google.android.exoplayer2.video.b.a(lVar);
                list = a3.f12238a;
                cVar2.f10061c = a3.f12239b;
                str = "video/hevc";
            } else if (n2 == a.aM) {
                com.google.android.exoplayer2.s.a.b(str == null);
                str = i9 == a.aK ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
            } else if (n2 == a.f10044g) {
                com.google.android.exoplayer2.s.a.b(str == null);
                str = "video/3gpp";
            } else if (n2 == a.J) {
                com.google.android.exoplayer2.s.a.b(str == null);
                Pair<String, byte[]> d4 = d(lVar2, d3);
                str = (String) d4.first;
                list = Collections.singletonList(d4.second);
            } else if (n2 == a.ai) {
                f2 = c(lVar2, d3);
                z = true;
            } else if (n2 == a.aI) {
                bArr = d(lVar2, d3, n);
            } else if (n2 == a.aH) {
                int g2 = lVar.g();
                lVar2.d(3);
                if (g2 == 0) {
                    int g3 = lVar.g();
                    if (g3 == 0) {
                        i10 = 0;
                    } else if (g3 == 1) {
                        i10 = 1;
                    } else if (g3 == 2) {
                        i10 = 2;
                    } else if (g3 == 3) {
                        i10 = 3;
                    }
                }
            }
            d2 += n;
        }
        if (str != null) {
            cVar2.f10060b = Format.a(Integer.toString(i4), str, (String) null, -1, -1, h2, h3, -1.0f, list, i5, f2, bArr, i10, (ColorInfo) null, drmInitData3);
        }
    }

    private static Pair<long[], long[]> a(a.C0169a aVar) {
        if (aVar != null) {
            a.b d2 = aVar.d(a.Q);
            if (d2 != null) {
                l lVar = d2.aQ;
                lVar.c(8);
                int a2 = a.a(lVar.n());
                int t = lVar.t();
                long[] jArr = new long[t];
                long[] jArr2 = new long[t];
                int i = 0;
                while (i < t) {
                    jArr[i] = a2 == 1 ? lVar.v() : lVar.l();
                    jArr2[i] = a2 == 1 ? lVar.p() : (long) lVar.n();
                    if (lVar.j() == 1) {
                        lVar.d(2);
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

    private static float c(l lVar, int i) {
        lVar.c(i + 8);
        return ((float) lVar.t()) / ((float) lVar.t());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.google.android.exoplayer2.s.l r28, int r29, int r30, int r31, int r32, java.lang.String r33, boolean r34, com.google.android.exoplayer2.drm.DrmInitData r35, com.google.android.exoplayer2.i.d.b.c r36, int r37) {
        /*
            r0 = r28
            r1 = r30
            r2 = r31
            r14 = r33
            r3 = r35
            r15 = r36
            int r4 = r1 + 8
            r5 = 8
            int r4 = r4 + r5
            r0.c(r4)
            r4 = 6
            r13 = 0
            if (r34 == 0) goto L_0x0020
            int r5 = r28.h()
            r0.d(r4)
            goto L_0x0024
        L_0x0020:
            r0.d(r5)
            r5 = 0
        L_0x0024:
            r12 = 2
            r6 = 16
            r11 = 1
            if (r5 == 0) goto L_0x0048
            if (r5 != r11) goto L_0x002d
            goto L_0x0048
        L_0x002d:
            if (r5 != r12) goto L_0x0047
            r0.d(r6)
            double r4 = r28.w()
            long r4 = java.lang.Math.round(r4)
            int r5 = (int) r4
            int r4 = r28.t()
            r6 = 20
            r0.d(r6)
            r7 = r4
            r4 = r5
            goto L_0x0058
        L_0x0047:
            return
        L_0x0048:
            int r7 = r28.h()
            r0.d(r4)
            int r4 = r28.r()
            if (r5 != r11) goto L_0x0058
            r0.d(r6)
        L_0x0058:
            int r5 = r28.d()
            int r6 = com.google.android.exoplayer2.i.d.a.aa
            r16 = 0
            r8 = r29
            if (r8 != r6) goto L_0x008c
            android.util.Pair r6 = b(r0, r1, r2)
            if (r6 == 0) goto L_0x0089
            java.lang.Object r8 = r6.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r3 != 0) goto L_0x0077
            r3 = r16
            goto L_0x0081
        L_0x0077:
            java.lang.Object r9 = r6.second
            com.google.android.exoplayer2.i.d.k r9 = (com.google.android.exoplayer2.i.d.k) r9
            java.lang.String r9 = r9.f10126b
            com.google.android.exoplayer2.drm.DrmInitData r3 = r3.a((java.lang.String) r9)
        L_0x0081:
            com.google.android.exoplayer2.i.d.k[] r9 = r15.f10059a
            java.lang.Object r6 = r6.second
            com.google.android.exoplayer2.i.d.k r6 = (com.google.android.exoplayer2.i.d.k) r6
            r9[r37] = r6
        L_0x0089:
            r0.c(r5)
        L_0x008c:
            r10 = r3
            int r3 = com.google.android.exoplayer2.i.d.a.n
            java.lang.String r9 = "audio/raw"
            if (r8 != r3) goto L_0x0096
            java.lang.String r3 = "audio/ac3"
            goto L_0x00e0
        L_0x0096:
            int r3 = com.google.android.exoplayer2.i.d.a.p
            if (r8 != r3) goto L_0x009d
            java.lang.String r3 = "audio/eac3"
            goto L_0x00e0
        L_0x009d:
            int r3 = com.google.android.exoplayer2.i.d.a.r
            if (r8 != r3) goto L_0x00a4
            java.lang.String r3 = "audio/vnd.dts"
            goto L_0x00e0
        L_0x00a4:
            int r3 = com.google.android.exoplayer2.i.d.a.s
            if (r8 == r3) goto L_0x00de
            int r3 = com.google.android.exoplayer2.i.d.a.t
            if (r8 != r3) goto L_0x00ad
            goto L_0x00de
        L_0x00ad:
            int r3 = com.google.android.exoplayer2.i.d.a.u
            if (r8 != r3) goto L_0x00b4
            java.lang.String r3 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x00e0
        L_0x00b4:
            int r3 = com.google.android.exoplayer2.i.d.a.ay
            if (r8 != r3) goto L_0x00bb
            java.lang.String r3 = "audio/3gpp"
            goto L_0x00e0
        L_0x00bb:
            int r3 = com.google.android.exoplayer2.i.d.a.az
            if (r8 != r3) goto L_0x00c2
            java.lang.String r3 = "audio/amr-wb"
            goto L_0x00e0
        L_0x00c2:
            int r3 = com.google.android.exoplayer2.i.d.a.l
            if (r8 == r3) goto L_0x00dc
            int r3 = com.google.android.exoplayer2.i.d.a.m
            if (r8 != r3) goto L_0x00cb
            goto L_0x00dc
        L_0x00cb:
            int r3 = com.google.android.exoplayer2.i.d.a.j
            if (r8 != r3) goto L_0x00d2
            java.lang.String r3 = "audio/mpeg"
            goto L_0x00e0
        L_0x00d2:
            int r3 = com.google.android.exoplayer2.i.d.a.aO
            if (r8 != r3) goto L_0x00d9
            java.lang.String r3 = "audio/alac"
            goto L_0x00e0
        L_0x00d9:
            r3 = r16
            goto L_0x00e0
        L_0x00dc:
            r3 = r9
            goto L_0x00e0
        L_0x00de:
            java.lang.String r3 = "audio/vnd.dts.hd"
        L_0x00e0:
            r18 = r4
            r8 = r5
            r17 = r7
            r19 = r16
            r7 = r3
        L_0x00e8:
            int r3 = r8 - r1
            r4 = -1
            if (r3 >= r2) goto L_0x01f6
            r0.c(r8)
            int r6 = r28.n()
            if (r6 <= 0) goto L_0x00f8
            r3 = 1
            goto L_0x00f9
        L_0x00f8:
            r3 = 0
        L_0x00f9:
            java.lang.String r5 = "childAtomSize should be positive"
            com.google.android.exoplayer2.s.a.a(r3, r5)
            int r3 = r28.n()
            int r5 = com.google.android.exoplayer2.i.d.a.J
            if (r3 == r5) goto L_0x01a5
            if (r34 == 0) goto L_0x010e
            int r5 = com.google.android.exoplayer2.i.d.a.k
            if (r3 != r5) goto L_0x010e
            goto L_0x01a5
        L_0x010e:
            int r4 = com.google.android.exoplayer2.i.d.a.o
            if (r3 != r4) goto L_0x0130
            int r3 = r8 + 8
            r0.c(r3)
            java.lang.String r3 = java.lang.Integer.toString(r32)
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.b.a.a(r0, r3, r14, r10)
            r15.f10060b = r3
        L_0x0121:
            r5 = r6
            r25 = r7
            r6 = r8
            r27 = r9
            r20 = r10
            r1 = 0
            r21 = 1
            r22 = 2
            goto L_0x01a2
        L_0x0130:
            int r4 = com.google.android.exoplayer2.i.d.a.q
            if (r3 != r4) goto L_0x0144
            int r3 = r8 + 8
            r0.c(r3)
            java.lang.String r3 = java.lang.Integer.toString(r32)
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.b.a.b(r0, r3, r14, r10)
            r15.f10060b = r3
            goto L_0x0121
        L_0x0144:
            int r4 = com.google.android.exoplayer2.i.d.a.v
            if (r3 != r4) goto L_0x017c
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
            r20 = r10
            r10 = r22
            r21 = 1
            r11 = r20
            r22 = 2
            r12 = r23
            r1 = 0
            r13 = r33
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.Format.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r15.f10060b = r3
            goto L_0x019e
        L_0x017c:
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r9
            r20 = r10
            r1 = 0
            r21 = 1
            r22 = 2
            int r4 = com.google.android.exoplayer2.i.d.a.aO
            if (r3 != r4) goto L_0x019e
            r5 = r24
            byte[] r3 = new byte[r5]
            r6 = r26
            r0.c(r6)
            r0.a(r3, r1, r5)
            r19 = r3
            goto L_0x01a2
        L_0x019e:
            r5 = r24
            r6 = r26
        L_0x01a2:
            r7 = r25
            goto L_0x01e9
        L_0x01a5:
            r5 = r6
            r25 = r7
            r6 = r8
            r27 = r9
            r20 = r10
            r1 = 0
            r21 = 1
            r22 = 2
            int r7 = com.google.android.exoplayer2.i.d.a.J
            if (r3 != r7) goto L_0x01b8
            r8 = r6
            goto L_0x01bc
        L_0x01b8:
            int r8 = a((com.google.android.exoplayer2.s.l) r0, (int) r6, (int) r5)
        L_0x01bc:
            if (r8 == r4) goto L_0x01a2
            android.util.Pair r3 = d(r0, r8)
            java.lang.Object r4 = r3.first
            r7 = r4
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r3 = r3.second
            r19 = r3
            byte[] r19 = (byte[]) r19
            java.lang.String r3 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x01e9
            android.util.Pair r3 = com.google.android.exoplayer2.s.c.a((byte[]) r19)
            java.lang.Object r4 = r3.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r18 = r4.intValue()
            java.lang.Object r3 = r3.second
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r17 = r3.intValue()
        L_0x01e9:
            int r8 = r6 + r5
            r1 = r30
            r10 = r20
            r9 = r27
            r11 = 1
            r12 = 2
            r13 = 0
            goto L_0x00e8
        L_0x01f6:
            r25 = r7
            r27 = r9
            r20 = r10
            r22 = 2
            com.google.android.exoplayer2.Format r0 = r15.f10060b
            if (r0 != 0) goto L_0x0234
            r7 = r25
            if (r7 == 0) goto L_0x0234
            r0 = r27
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x020f
            goto L_0x0211
        L_0x020f:
            r22 = -1
        L_0x0211:
            java.lang.String r0 = java.lang.Integer.toString(r32)
            r2 = 0
            r3 = -1
            r4 = -1
            if (r19 != 0) goto L_0x021d
            r8 = r16
            goto L_0x0222
        L_0x021d:
            java.util.List r1 = java.util.Collections.singletonList(r19)
            r8 = r1
        L_0x0222:
            r10 = 0
            r1 = r7
            r5 = r17
            r6 = r18
            r7 = r22
            r9 = r20
            r11 = r33
            com.google.android.exoplayer2.Format r0 = com.google.android.exoplayer2.Format.a((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (java.util.List<byte[]>) r8, (com.google.android.exoplayer2.drm.DrmInitData) r9, (int) r10, (java.lang.String) r11)
            r15.f10060b = r0
        L_0x0234:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.i.d.b.a(com.google.android.exoplayer2.s.l, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData, com.google.android.exoplayer2.i.d.b$c, int):void");
    }

    private static int a(l lVar, int i, int i2) {
        int d2 = lVar.d();
        while (d2 - i < i2) {
            lVar.c(d2);
            int n = lVar.n();
            com.google.android.exoplayer2.s.a.a(n > 0, "childAtomSize should be positive");
            if (lVar.n() == a.J) {
                return d2;
            }
            d2 += n;
        }
        return -1;
    }

    private static Pair<String, byte[]> d(l lVar, int i) {
        lVar.c(i + 8 + 4);
        lVar.d(1);
        e(lVar);
        lVar.d(2);
        int g2 = lVar.g();
        if ((g2 & 128) != 0) {
            lVar.d(2);
        }
        if ((g2 & 64) != 0) {
            lVar.d(lVar.h());
        }
        if ((g2 & 32) != 0) {
            lVar.d(2);
        }
        lVar.d(1);
        e(lVar);
        int g3 = lVar.g();
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
        lVar.d(12);
        lVar.d(1);
        int e2 = e(lVar);
        byte[] bArr = new byte[e2];
        lVar.a(bArr, 0, e2);
        return Pair.create(str, bArr);
    }

    private static Pair<Integer, k> b(l lVar, int i, int i2) {
        int d2 = lVar.d();
        while (d2 - i < i2) {
            lVar.c(d2);
            int n = lVar.n();
            com.google.android.exoplayer2.s.a.a(n > 0, "childAtomSize should be positive");
            if (lVar.n() == a.V) {
                Pair<Integer, k> c2 = c(lVar, d2, n);
                if (c2 != null) {
                    return c2;
                }
            }
            d2 += n;
        }
        return null;
    }

    private static Pair<Integer, k> c(l lVar, int i, int i2) {
        int i3 = i + 8;
        String str = null;
        Integer num = null;
        int i4 = -1;
        int i5 = 0;
        while (i3 - i < i2) {
            lVar.c(i3);
            int n = lVar.n();
            int n2 = lVar.n();
            if (n2 == a.ab) {
                num = Integer.valueOf(lVar.n());
            } else if (n2 == a.W) {
                lVar.d(4);
                str = lVar.e(4);
            } else if (n2 == a.X) {
                i4 = i3;
                i5 = n;
            }
            i3 += n;
        }
        if (str == null) {
            return null;
        }
        boolean z = true;
        com.google.android.exoplayer2.s.a.a(num != null, "frma atom is mandatory");
        com.google.android.exoplayer2.s.a.a(i4 != -1, "schi atom is mandatory");
        k a2 = a(lVar, i4, i5, str);
        if (a2 == null) {
            z = false;
        }
        com.google.android.exoplayer2.s.a.a(z, "tenc atom is mandatory");
        return Pair.create(num, a2);
    }

    private static k a(l lVar, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            lVar.c(i5);
            int n = lVar.n();
            if (lVar.n() == a.Y) {
                int a2 = a.a(lVar.n());
                lVar.d(1);
                if (a2 == 0) {
                    lVar.d(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int g2 = lVar.g();
                    i3 = g2 & 15;
                    i4 = (g2 & 240) >> 4;
                }
                boolean z = lVar.g() == 1;
                int g3 = lVar.g();
                byte[] bArr2 = new byte[16];
                lVar.a(bArr2, 0, bArr2.length);
                if (z && g3 == 0) {
                    int g4 = lVar.g();
                    bArr = new byte[g4];
                    lVar.a(bArr, 0, g4);
                }
                return new k(z, str, g3, bArr2, i4, i3, bArr);
            }
            i5 += n;
        }
    }

    private static byte[] d(l lVar, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            lVar.c(i3);
            int n = lVar.n();
            if (lVar.n() == a.aJ) {
                return Arrays.copyOfRange(lVar.f11422a, i3, n + i3);
            }
            i3 += n;
        }
        return null;
    }

    private static int e(l lVar) {
        int g2 = lVar.g();
        int i = g2 & 127;
        while ((g2 & 128) == 128) {
            g2 = lVar.g();
            i = (i << 7) | (g2 & 127);
        }
        return i;
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f10052a;

        /* renamed from: b  reason: collision with root package name */
        public int f10053b;

        /* renamed from: c  reason: collision with root package name */
        public int f10054c;

        /* renamed from: d  reason: collision with root package name */
        public long f10055d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f10056e;

        /* renamed from: f  reason: collision with root package name */
        private final l f10057f;

        /* renamed from: g  reason: collision with root package name */
        private final l f10058g;
        private int h;
        private int i;

        public a(l lVar, l lVar2, boolean z) {
            this.f10058g = lVar;
            this.f10057f = lVar2;
            this.f10056e = z;
            lVar2.c(12);
            this.f10052a = lVar2.t();
            lVar.c(12);
            this.i = lVar.t();
            com.google.android.exoplayer2.s.a.b(lVar.n() != 1 ? false : true, "first_chunk must be 1");
            this.f10053b = -1;
        }

        public boolean a() {
            long j;
            int i2 = this.f10053b + 1;
            this.f10053b = i2;
            if (i2 == this.f10052a) {
                return false;
            }
            if (this.f10056e) {
                j = this.f10057f.v();
            } else {
                j = this.f10057f.l();
            }
            this.f10055d = j;
            if (this.f10053b == this.h) {
                this.f10054c = this.f10058g.t();
                this.f10058g.d(4);
                int i3 = this.i - 1;
                this.i = i3;
                this.h = i3 > 0 ? this.f10058g.t() - 1 : -1;
            }
            return true;
        }
    }

    private static final class f {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f10071a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f10072b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f10073c;

        public f(int i, long j, int i2) {
            this.f10071a = i;
            this.f10072b = j;
            this.f10073c = i2;
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final k[] f10059a;

        /* renamed from: b  reason: collision with root package name */
        public Format f10060b;

        /* renamed from: c  reason: collision with root package name */
        public int f10061c;

        /* renamed from: d  reason: collision with root package name */
        public int f10062d = 0;

        public c(int i) {
            this.f10059a = new k[i];
        }
    }

    static final class d implements C0170b {

        /* renamed from: a  reason: collision with root package name */
        private final int f10063a = this.f10065c.t();

        /* renamed from: b  reason: collision with root package name */
        private final int f10064b = this.f10065c.t();

        /* renamed from: c  reason: collision with root package name */
        private final l f10065c;

        public d(a.b bVar) {
            this.f10065c = bVar.aQ;
            this.f10065c.c(12);
        }

        public int a() {
            return this.f10064b;
        }

        public int b() {
            int i = this.f10063a;
            return i == 0 ? this.f10065c.t() : i;
        }

        public boolean c() {
            return this.f10063a != 0;
        }
    }

    static final class e implements C0170b {

        /* renamed from: a  reason: collision with root package name */
        private final l f10066a;

        /* renamed from: b  reason: collision with root package name */
        private final int f10067b = this.f10066a.t();

        /* renamed from: c  reason: collision with root package name */
        private final int f10068c = (this.f10066a.t() & 255);

        /* renamed from: d  reason: collision with root package name */
        private int f10069d;

        /* renamed from: e  reason: collision with root package name */
        private int f10070e;

        public boolean c() {
            return false;
        }

        public e(a.b bVar) {
            this.f10066a = bVar.aQ;
            this.f10066a.c(12);
        }

        public int a() {
            return this.f10067b;
        }

        public int b() {
            int i = this.f10068c;
            if (i == 8) {
                return this.f10066a.g();
            }
            if (i == 16) {
                return this.f10066a.h();
            }
            int i2 = this.f10069d;
            this.f10069d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.f10070e & 15;
            }
            this.f10070e = this.f10066a.g();
            return (this.f10070e & 240) >> 4;
        }
    }
}
