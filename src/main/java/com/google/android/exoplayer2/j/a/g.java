package com.google.android.exoplayer2.j.a;

import android.util.Log;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.n.k;

public final class g {
    public static void a(long j, k kVar, n[] nVarArr) {
        while (kVar.b() > 1) {
            int a2 = a(kVar);
            int a3 = a(kVar);
            if (a3 == -1 || a3 > kVar.b()) {
                Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                kVar.c(kVar.c());
            } else if (a(a2, a3, kVar)) {
                kVar.d(8);
                kVar.d(1);
                int g2 = (kVar.g() & 31) * 3;
                int d2 = kVar.d();
                for (n nVar : nVarArr) {
                    kVar.c(d2);
                    nVar.a(kVar, g2);
                    nVar.a(j, 1, g2, 0, (byte[]) null);
                }
                kVar.d(a3 - (g2 + 10));
            } else {
                kVar.d(a3);
            }
        }
    }

    private static int a(k kVar) {
        int i = 0;
        while (kVar.b() != 0) {
            int g2 = kVar.g();
            i += g2;
            if (g2 != 255) {
                return i;
            }
        }
        return -1;
    }

    private static boolean a(int i, int i2, k kVar) {
        if (i != 4 || i2 < 8) {
            return false;
        }
        int d2 = kVar.d();
        int g2 = kVar.g();
        int h = kVar.h();
        int n = kVar.n();
        int g3 = kVar.g();
        kVar.c(d2);
        if (g2 == 181 && h == 49 && n == 1195456820 && g3 == 3) {
            return true;
        }
        return false;
    }
}
