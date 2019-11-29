package com.google.android.exoplayer2.p.a;

import android.util.Log;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.l;

public final class g {
    public static void a(long j, l lVar, m[] mVarArr) {
        while (lVar.b() > 1) {
            int a2 = a(lVar);
            int a3 = a(lVar);
            if (a3 == -1 || a3 > lVar.b()) {
                Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                lVar.c(lVar.c());
            } else if (a(a2, a3, lVar)) {
                lVar.d(8);
                lVar.d(1);
                int g2 = (lVar.g() & 31) * 3;
                int d2 = lVar.d();
                for (m mVar : mVarArr) {
                    lVar.c(d2);
                    mVar.a(lVar, g2);
                    mVar.a(j, 1, g2, 0, (m.a) null);
                }
                lVar.d(a3 - (g2 + 10));
            } else {
                lVar.d(a3);
            }
        }
    }

    private static int a(l lVar) {
        int i = 0;
        while (lVar.b() != 0) {
            int g2 = lVar.g();
            i += g2;
            if (g2 != 255) {
                return i;
            }
        }
        return -1;
    }

    private static boolean a(int i, int i2, l lVar) {
        if (i != 4 || i2 < 8) {
            return false;
        }
        int d2 = lVar.d();
        int g2 = lVar.g();
        int h = lVar.h();
        int n = lVar.n();
        int g3 = lVar.g();
        lVar.c(d2);
        if (g2 == 181 && h == 49 && n == 1195456820 && g3 == 3) {
            return true;
        }
        return false;
    }
}
