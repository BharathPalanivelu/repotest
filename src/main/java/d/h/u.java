package d.h;

import com.facebook.internal.FacebookRequestErrorClassification;
import d.d.b.j;
import d.g.b;

class u extends t {
    public static /* synthetic */ String a(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return m.a(str, str2, str3, z);
    }

    public static final String a(String str, String str2, String str3, boolean z) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        j.b(str4, "$this$replace");
        j.b(str5, "oldValue");
        j.b(str6, "newValue");
        return b.a(m.a((CharSequence) str4, new String[]{str5}, z, 0, 4, (Object) null), str6, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (d.d.a.b) null, 62, (Object) null);
    }

    public static /* synthetic */ boolean a(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m.a(str, str2, z);
    }

    public static final boolean a(String str, String str2, boolean z) {
        j.b(str, "$this$startsWith");
        j.b(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return m.a(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean b(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m.b(str, str2, z);
    }

    public static final boolean b(String str, String str2, boolean z) {
        j.b(str, "$this$endsWith");
        j.b(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return m.a(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean a(java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "$this$isBlank"
            d.d.b.j.b(r4, r0)
            int r0 = r4.length()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0040
            d.e.c r0 = d.h.m.c(r4)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0022
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0022
        L_0x0020:
            r4 = 1
            goto L_0x003e
        L_0x0022:
            java.util.Iterator r0 = r0.iterator()
        L_0x0026:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0020
            r3 = r0
            d.a.y r3 = (d.a.y) r3
            int r3 = r3.b()
            char r3 = r4.charAt(r3)
            boolean r3 = d.h.a.a((char) r3)
            if (r3 != 0) goto L_0x0026
            r4 = 0
        L_0x003e:
            if (r4 == 0) goto L_0x0041
        L_0x0040:
            r1 = 1
        L_0x0041:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.h.u.a(java.lang.CharSequence):boolean");
    }

    public static final boolean a(String str, int i, String str2, int i2, int i3, boolean z) {
        j.b(str, "$this$regionMatches");
        j.b(str2, FacebookRequestErrorClassification.KEY_OTHER);
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }
}
