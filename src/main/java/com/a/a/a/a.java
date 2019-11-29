package com.a.a.a;

import android.text.SpannedString;
import java.util.Locale;
import java.util.regex.Pattern;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f3096a = Pattern.compile("%([0-9]+\\$|<?)([^a-zA-z%]*)([[a-zA-Z%]&&[^tT]]|[tT][a-zA-Z])");

    private static SpannedString a(String str, Object... objArr) {
        return null;
    }

    public static SpannedString a(Locale locale, String str, Object... objArr) {
        if (a(str)) {
            return b(locale, str, objArr);
        }
        return a(str, objArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.text.SpannedString b(java.util.Locale r11, java.lang.String r12, java.lang.Object... r13) {
        /*
            android.text.SpannableStringBuilder r0 = new android.text.SpannableStringBuilder
            r0.<init>(r12)
            r12 = 0
            r1 = -1
            r1 = 0
            r2 = -1
        L_0x0009:
            int r3 = r0.length()
            if (r1 >= r3) goto L_0x00a2
            java.util.regex.Pattern r3 = f3096a
            java.util.regex.Matcher r3 = r3.matcher(r0)
            boolean r1 = r3.find(r1)
            if (r1 != 0) goto L_0x001d
            goto L_0x00a2
        L_0x001d:
            int r1 = r3.start()
            int r4 = r3.end()
            r5 = 1
            java.lang.String r6 = r3.group(r5)
            r7 = 2
            java.lang.String r7 = r3.group(r7)
            r8 = 3
            java.lang.String r3 = r3.group(r8)
            java.lang.String r8 = "%"
            boolean r9 = r3.equals(r8)
            if (r9 == 0) goto L_0x003d
            goto L_0x0098
        L_0x003d:
            boolean r9 = r3.equals(r8)
            if (r9 == 0) goto L_0x0046
            java.lang.String r8 = "\n"
            goto L_0x0098
        L_0x0046:
            java.lang.String r9 = ""
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto L_0x0052
            int r2 = r2 + 1
        L_0x0050:
            r6 = r2
            goto L_0x006c
        L_0x0052:
            java.lang.String r9 = "<"
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto L_0x005b
            goto L_0x0050
        L_0x005b:
            int r9 = r6.length()
            int r9 = r9 - r5
            java.lang.String r6 = r6.substring(r12, r9)
            int r6 = java.lang.Integer.parseInt(r6)
            int r6 = r6 - r5
            r10 = r6
            r6 = r2
            r2 = r10
        L_0x006c:
            r2 = r13[r2]
            com.a.a.b r2 = (com.a.a.b) r2
            java.lang.String r9 = "s"
            boolean r9 = r3.equals(r9)
            if (r9 == 0) goto L_0x007d
            android.text.SpannableString r8 = r2.a()
            goto L_0x0097
        L_0x007d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r8)
            r9.append(r7)
            r9.append(r3)
            java.lang.String r3 = r9.toString()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r12] = r2
            java.lang.String r8 = java.lang.String.format(r11, r3, r5)
        L_0x0097:
            r2 = r6
        L_0x0098:
            r0.replace(r1, r4, r8)
            int r3 = r8.length()
            int r1 = r1 + r3
            goto L_0x0009
        L_0x00a2:
            android.text.SpannedString r11 = new android.text.SpannedString
            r11.<init>(r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.a.a.b(java.util.Locale, java.lang.String, java.lang.Object[]):android.text.SpannedString");
    }

    private static boolean a(String str) {
        return f3096a.matcher(str).find();
    }
}
