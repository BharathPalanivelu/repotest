package com.google.android.exoplayer2.i.d;

import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.v;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.IOException;

final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f10117a = {v.g("isom"), v.g("iso2"), v.g("iso3"), v.g("iso4"), v.g("iso5"), v.g("iso6"), v.g("avc1"), v.g("hvc1"), v.g("hev1"), v.g("mp41"), v.g("mp42"), v.g("3g2a"), v.g("3g2b"), v.g("3gr6"), v.g("3gs6"), v.g("3ge6"), v.g("3gg6"), v.g("M4V "), v.g("M4A "), v.g("f4v "), v.g("kddi"), v.g("M4VP"), v.g("qt  "), v.g("MSNV")};

    public static boolean a(f fVar) throws IOException, InterruptedException {
        return a(fVar, true);
    }

    public static boolean b(f fVar) throws IOException, InterruptedException {
        return a(fVar, false);
    }

    private static boolean a(f fVar, boolean z) throws IOException, InterruptedException {
        boolean z2;
        f fVar2 = fVar;
        long d2 = fVar.d();
        if (d2 == -1 || d2 > IjkMediaMeta.AV_CH_TOP_FRONT_LEFT) {
            d2 = 4096;
        }
        int i = (int) d2;
        l lVar = new l(64);
        int i2 = 0;
        boolean z3 = false;
        while (true) {
            if (i2 >= i) {
                break;
            }
            lVar.a(8);
            fVar2.c(lVar.f11422a, 0, 8);
            long l = lVar.l();
            int n = lVar.n();
            int i3 = 16;
            if (l == 1) {
                fVar2.c(lVar.f11422a, 8, 8);
                lVar.b(16);
                l = lVar.v();
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
                    if (n == a.f10038a) {
                        if (i4 < 8) {
                            return false;
                        }
                        lVar.a(i4);
                        fVar2.c(lVar.f11422a, 0, i4);
                        int i5 = i4 / 4;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= i5) {
                                break;
                            }
                            if (i6 == 1) {
                                lVar.d(4);
                            } else if (a(lVar.n())) {
                                z3 = true;
                                break;
                            }
                            i6++;
                        }
                        if (!z3) {
                            return false;
                        }
                    } else if (i4 != 0) {
                        fVar2.c(i4);
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
        if ((i >>> 8) == v.g("3gp")) {
            return true;
        }
        for (int i2 : f10117a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
