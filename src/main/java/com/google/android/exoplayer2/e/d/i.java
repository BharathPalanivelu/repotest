package com.google.android.exoplayer2.e.d;

import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.IOException;

final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f9487a = {t.g("isom"), t.g("iso2"), t.g("iso3"), t.g("iso4"), t.g("iso5"), t.g("iso6"), t.g("avc1"), t.g("hvc1"), t.g("hev1"), t.g("mp41"), t.g("mp42"), t.g("3g2a"), t.g("3g2b"), t.g("3gr6"), t.g("3gs6"), t.g("3ge6"), t.g("3gg6"), t.g("M4V "), t.g("M4A "), t.g("f4v "), t.g("kddi"), t.g("M4VP"), t.g("qt  "), t.g("MSNV")};

    public static boolean a(g gVar) throws IOException, InterruptedException {
        return a(gVar, true);
    }

    public static boolean b(g gVar) throws IOException, InterruptedException {
        return a(gVar, false);
    }

    private static boolean a(g gVar, boolean z) throws IOException, InterruptedException {
        boolean z2;
        g gVar2 = gVar;
        long d2 = gVar.d();
        if (d2 == -1 || d2 > IjkMediaMeta.AV_CH_TOP_FRONT_LEFT) {
            d2 = 4096;
        }
        int i = (int) d2;
        k kVar = new k(64);
        int i2 = 0;
        boolean z3 = false;
        while (true) {
            if (i2 >= i) {
                break;
            }
            kVar.a(8);
            gVar2.c(kVar.f10948a, 0, 8);
            long l = kVar.l();
            int n = kVar.n();
            int i3 = 16;
            if (l == 1) {
                gVar2.c(kVar.f10948a, 8, 8);
                kVar.b(16);
                l = kVar.v();
            } else {
                i3 = 8;
            }
            long j = (long) i3;
            if (l < j) {
                return false;
            }
            i2 += i3;
            if (n != a.B) {
                if (n == a.K || n == a.M) {
                    z2 = true;
                } else if ((((long) i2) + l) - j >= ((long) i)) {
                    break;
                } else {
                    int i4 = (int) (l - j);
                    i2 += i4;
                    if (n == a.f9401a) {
                        if (i4 < 8) {
                            return false;
                        }
                        kVar.a(i4);
                        gVar2.c(kVar.f10948a, 0, i4);
                        int i5 = i4 / 4;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= i5) {
                                break;
                            }
                            if (i6 == 1) {
                                kVar.d(4);
                            } else if (a(kVar.n())) {
                                z3 = true;
                                break;
                            }
                            i6++;
                        }
                        if (!z3) {
                            return false;
                        }
                    } else if (i4 != 0) {
                        gVar2.c(i4);
                    }
                }
            }
        }
        z2 = false;
        if (!z3 || z != z2) {
            return false;
        }
        return true;
    }

    private static boolean a(int i) {
        if ((i >>> 8) == t.g("3gp")) {
            return true;
        }
        for (int i2 : f9487a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
