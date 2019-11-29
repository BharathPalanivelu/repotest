package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class af {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32554a = "com.threatmetrix.TrustDefenderMobile.af";

    af() {
    }

    static Method a(Class cls, String str, Class... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Exception | NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0092 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0093 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> T a(java.lang.Object r4, java.lang.reflect.Method r5, java.lang.Object... r6) {
        /*
            java.lang.String r0 = " invoke failed: "
            r1 = 0
            if (r5 == 0) goto L_0x0093
            r2 = 0
            r3 = 1
            java.lang.Object r4 = r5.invoke(r4, r6)     // Catch:{ ClassCastException -> 0x0076, IllegalAccessException -> 0x005c, IllegalArgumentException -> 0x0042, InvocationTargetException -> 0x0028, Exception -> 0x000e }
            r3 = 0
            goto L_0x0090
        L_0x000e:
            r4 = move-exception
            java.lang.String r6 = f32554a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = r5.getName()
            r2.append(r5)
            r2.append(r0)
            java.lang.String r5 = r2.toString()
            android.util.Log.e(r6, r5, r4)
            goto L_0x008f
        L_0x0028:
            r4 = move-exception
            java.lang.String r6 = f32554a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = r5.getName()
            r2.append(r5)
            r2.append(r0)
            java.lang.String r5 = r2.toString()
            android.util.Log.e(r6, r5, r4)
            goto L_0x008f
        L_0x0042:
            r4 = move-exception
            java.lang.String r6 = f32554a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = r5.getName()
            r2.append(r5)
            r2.append(r0)
            java.lang.String r5 = r2.toString()
            android.util.Log.e(r6, r5, r4)
            goto L_0x008f
        L_0x005c:
            r4 = move-exception
            java.lang.String r6 = f32554a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = r5.getName()
            r2.append(r5)
            r2.append(r0)
            java.lang.String r5 = r2.toString()
            android.util.Log.e(r6, r5, r4)
            goto L_0x008f
        L_0x0076:
            r4 = move-exception
            java.lang.String r6 = f32554a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = r5.getName()
            r2.append(r5)
            r2.append(r0)
            java.lang.String r5 = r2.toString()
            android.util.Log.e(r6, r5, r4)
        L_0x008f:
            r4 = r1
        L_0x0090:
            if (r3 != 0) goto L_0x0093
            return r4
        L_0x0093:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefenderMobile.af.a(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }

    static Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            Log.d(f32554a, "getClass failed:", e2);
            return null;
        } catch (Exception e3) {
            String str2 = f32554a;
            Log.e(str2, str + " getClass failed: ", e3);
            return null;
        }
    }

    static Field a(Class cls, String str) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getDeclaredField(str);
        } catch (Exception | NoSuchFieldException unused) {
            return null;
        }
    }

    static Object a(Object obj, Field field) {
        if (obj == null || field == null) {
            return null;
        }
        try {
            return field.get(obj);
        } catch (Exception | IllegalAccessException | IllegalArgumentException unused) {
            return null;
        }
    }
}
