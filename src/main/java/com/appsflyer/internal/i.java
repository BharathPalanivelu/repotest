package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFExecutor;

public final class i {

    static final class b {

        /* renamed from: ॱ  reason: contains not printable characters */
        static final i f175 = new i();
    }

    i() {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static i m152() {
        return b.f175;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean m153(Context context, String[] strArr) {
        for (String r3 : strArr) {
            if (AFExecutor.AnonymousClass2.m25(context, r3)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        if (r8 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        if (60000 >= (r3.getTime() - r8.getTime())) goto L_0x0056;
     */
    /* renamed from: ˊ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.location.Location m151(android.content.Context r8) {
        /*
            java.lang.String r0 = "android.permission.ACCESS_FINE_LOCATION"
            r1 = 0
            java.lang.String r2 = "location"
            java.lang.Object r2 = r8.getSystemService(r2)     // Catch:{ Throwable -> 0x0059 }
            android.location.LocationManager r2 = (android.location.LocationManager) r2     // Catch:{ Throwable -> 0x0059 }
            java.lang.String r3 = "network"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ Throwable -> 0x0059 }
            r5 = 0
            r4[r5] = r0     // Catch:{ Throwable -> 0x0059 }
            java.lang.String r6 = "android.permission.ACCESS_COARSE_LOCATION"
            r7 = 1
            r4[r7] = r6     // Catch:{ Throwable -> 0x0059 }
            boolean r4 = m153(r8, r4)     // Catch:{ Throwable -> 0x0059 }
            if (r4 == 0) goto L_0x0023
            android.location.Location r3 = r2.getLastKnownLocation(r3)     // Catch:{ Throwable -> 0x0059 }
            goto L_0x0024
        L_0x0023:
            r3 = r1
        L_0x0024:
            java.lang.String r4 = "gps"
            java.lang.String[] r6 = new java.lang.String[r7]     // Catch:{ Throwable -> 0x0059 }
            r6[r5] = r0     // Catch:{ Throwable -> 0x0059 }
            boolean r8 = m153(r8, r6)     // Catch:{ Throwable -> 0x0059 }
            if (r8 == 0) goto L_0x0035
            android.location.Location r8 = r2.getLastKnownLocation(r4)     // Catch:{ Throwable -> 0x0059 }
            goto L_0x0036
        L_0x0035:
            r8 = r1
        L_0x0036:
            if (r8 != 0) goto L_0x003c
            if (r3 != 0) goto L_0x003c
            r8 = r1
            goto L_0x0056
        L_0x003c:
            if (r8 != 0) goto L_0x0041
            if (r3 == 0) goto L_0x0041
            goto L_0x0055
        L_0x0041:
            if (r3 != 0) goto L_0x0045
            if (r8 != 0) goto L_0x0056
        L_0x0045:
            long r4 = r3.getTime()     // Catch:{ Throwable -> 0x0059 }
            long r6 = r8.getTime()     // Catch:{ Throwable -> 0x0059 }
            long r4 = r4 - r6
            r6 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0056
        L_0x0055:
            r8 = r3
        L_0x0056:
            if (r8 == 0) goto L_0x0059
            r1 = r8
        L_0x0059:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.i.m151(android.content.Context):android.location.Location");
    }
}
