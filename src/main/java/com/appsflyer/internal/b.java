package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.appsflyer.AFLogger;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.imageutils.JfifUtil;
import com.tencent.qcloud.core.util.IOUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static char[] f140 = {4084, 15594, 27091, 38612, 50110, 61609, 15767, 27340, 38761, 50281, 61779, 15947, 27433, 38944, 50452, 61956, 16124, 27546, 39155, 50611, 62125, 16277, 27795, 39290, 50786, 62290, 8278, 27923, 39464, 50966, 62474, 8445, 28112, 39638, '1', 30933, 23662, 28543, 14924, 50525, 36990, 41743, 28220, 14669, 50427, 38890, 41698, 28132, 14483, 52135, 38548, 41371, 28020, 14444, 'b', 13168, 26176, 39254, 52261, 65328, 12886, 25922, 39089, 52221, 65183, 12680, 25773, 38847, 51927, 64972, 12580, 25671, 38662, 51750, 64864, 12288, 25410, 38583, 51708, 64656, 12171, 25261, 38382, 51421, 64463, 12094, 34870, 47912, 60945, 4374, 17532, 30571, 47701, 60686, 4272, 17341, 30419, 47534, 60666, 8190, 17101, 30157, 47413, 60431, 7976, 17013, 30061, 47187, 60230, 7861, 16829, 39744, 43102, 64871, 608, 22282, 25629, 43299, 65144, 961, 20697, 26105, 43774, 65434, 3229, 20925, 26299, 43551, 65363, 3190, 20748, 26118, 43819, 63525, 54849, 58719, 45158, 20321, 6667, 10524, 58402, 45945, 20167, 7626, 10404, 59354, 45727, 16772, 7328, 11196, 59236, 45664, 16737, 7176, 1986, 13532, 25061, 40674, 52104, 63647, 13729, 25338, 40773, 52319, 63869, 13878, 25402, 36876, 52516, '.', IOUtils.DIR_SEPARATOR_WINDOWS, 13119, 'j', 13168, 26196, 39250, 52330, 65340, 12809, 25945, 39164, 52212, 65242, 12767, 25765, 38831, 34298, 46759, 58262, 7301, 18937, 31461, '.', 13115, 26125, 39279, 52279, 65407, 12878, 25945, 39074, 52144, 'C', 13177, 26183, 39248, 52271, 65318, 12819, 25882, 39117, 52193, 65225, 12766, 25788, 38825, 51847, 64912, 12670, 22982, 27376, 16331, 49375, 38305, 42673, 27590, 15491, 49511, 37433, 42829, 26718, 15672, 52861, 37645, 42014, 26867, 15817, 52951, 37859, 42148, 27012, 14978, 53103, 36920, 42334, 30291, 15167, 52276, 37197, 41499, 30455, 15299, 52436, 37298, 41639, 30605, 14490, 52584, 40493, 41736, 'g', 13172, 26198, 39290, 52266, 65318, 12818, 25878, 39140, 52213, 65231, 12767, 25741, 38829, 51870, 64915, 12665, 25666, 38739, 51767, 64829, 12298, 25368, 38644, 9653, 5775, 17329, 48294, 59865, 56016, 6117, 16620, 48428, 60938, 56122, 5153, 16735, 45640, 61292, 55372, 5278, 16820, 45729, 61381, 55510, 5626, 18159, 45855, 13547, 2013, 21222, 44530, 63628, 52124, 1771, 20915, 44107, 65346, 51816, 1405, 20484, 41808, 65073, 51511, 1499, 20704, 41978, 65165, 51597, 1197, 22463, 41482, 64856, 51297, 7011, 22030, 41246, 64548, 53107, 7125, 22244, 41448, 64647, 53214, 6828, 21920, 41032, 62303, 52853, 6496, 21518, 42777, 61999, 52586, 6531};

    /* renamed from: ˋ  reason: contains not printable characters */
    private static long f141 = -6045079932512685295L;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f142 = 0;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int f143 = 1;

    b() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0129, code lost:
        if (r7 != '\"') goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0144, code lost:
        if ((!m134(m127(25, 86, 34903).intern())) != false) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0146, code lost:
        r5 = m127(1, 35, 30949).intern();
     */
    /* renamed from: ˎ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m132(android.content.Context r16, long r17) {
        /*
            r0 = r17
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 3989(0xf95, float:5.59E-42)
            r6 = 34
            r7 = 0
            java.lang.String r5 = m127(r6, r7, r5)
            java.lang.String r5 = r5.intern()
            boolean r5 = m134(r5)
            r8 = 2
            r9 = 35
            r10 = 30949(0x78e5, float:4.3369E-41)
            r11 = 1
            if (r5 == 0) goto L_0x0038
            int r5 = f142
            int r5 = r5 + 91
            int r12 = r5 % 128
            f143 = r12
            int r5 = r5 % r8
            java.lang.String r5 = m127(r11, r6, r7)
            goto L_0x003c
        L_0x0038:
            java.lang.String r5 = m127(r11, r9, r10)
        L_0x003c:
            java.lang.String r5 = r5.intern()
            r3.append(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r12 = r16.getPackageName()
            java.lang.String r13 = m130((java.lang.String) r12)
            java.lang.String r14 = m127(r11, r6, r7)
            java.lang.String r14 = r14.intern()
            r3.append(r14)
            r5.append(r13)
            java.lang.String r13 = m133(r16)
            r14 = 15
            if (r13 != 0) goto L_0x0075
            java.lang.String r13 = m127(r11, r9, r10)
            java.lang.String r13 = r13.intern()
            r3.append(r13)
            r5.append(r12)
            goto L_0x008b
        L_0x0075:
            java.lang.String r13 = m127(r11, r6, r7)
            java.lang.String r13 = r13.intern()
            r3.append(r13)
            r5.append(r12)
            int r13 = f142
            int r13 = r13 + r14
            int r15 = r13 % 128
            f143 = r15
            int r13 = r13 % r8
        L_0x008b:
            java.lang.String r13 = m128((android.content.Context) r16)
            if (r13 != 0) goto L_0x00b2
            int r13 = f142
            int r13 = r13 + 101
            int r15 = r13 % 128
            f143 = r15
            int r13 = r13 % r8
            if (r13 != 0) goto L_0x00a3
            r13 = 47
            java.lang.String r13 = m127(r11, r13, r10)
            goto L_0x00a7
        L_0x00a3:
            java.lang.String r13 = m127(r11, r9, r10)
        L_0x00a7:
            java.lang.String r13 = r13.intern()
            r3.append(r13)
            r5.append(r12)
            goto L_0x00c0
        L_0x00b2:
            java.lang.String r15 = m127(r11, r6, r7)
            java.lang.String r15 = r15.intern()
            r3.append(r15)
            r5.append(r13)
        L_0x00c0:
            r13 = r16
            java.lang.String r12 = m129((android.content.Context) r13, (java.lang.String) r12)
            r5.append(r12)
            java.lang.String r5 = r5.toString()
            r2.append(r5)
            android.content.pm.PackageManager r5 = r16.getPackageManager()     // Catch:{ NameNotFoundException -> 0x022b }
            java.lang.String r12 = r16.getPackageName()     // Catch:{ NameNotFoundException -> 0x022b }
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r12, r7)     // Catch:{ NameNotFoundException -> 0x022b }
            long r12 = r5.firstInstallTime     // Catch:{ NameNotFoundException -> 0x022b }
            r5 = 36
            r15 = 23575(0x5c17, float:3.3036E-41)
            r14 = 18
            java.lang.String r5 = m127(r14, r5, r15)     // Catch:{ NameNotFoundException -> 0x022b }
            java.lang.String r5 = r5.intern()     // Catch:{ NameNotFoundException -> 0x022b }
            java.text.SimpleDateFormat r15 = new java.text.SimpleDateFormat     // Catch:{ NameNotFoundException -> 0x022b }
            java.util.Locale r7 = java.util.Locale.US     // Catch:{ NameNotFoundException -> 0x022b }
            r15.<init>(r5, r7)     // Catch:{ NameNotFoundException -> 0x022b }
            java.util.Date r5 = new java.util.Date     // Catch:{ NameNotFoundException -> 0x022b }
            r5.<init>(r12)     // Catch:{ NameNotFoundException -> 0x022b }
            java.lang.String r5 = r15.format(r5)     // Catch:{ NameNotFoundException -> 0x022b }
            r2.append(r5)     // Catch:{ NameNotFoundException -> 0x022b }
            int r5 = f142
            int r5 = r5 + 71
            int r7 = r5 % 128
            f143 = r7
            int r5 = r5 % r8
            if (r5 != 0) goto L_0x010c
            r5 = 1
            goto L_0x010d
        L_0x010c:
            r5 = 0
        L_0x010d:
            r7 = 25
            r12 = 34903(0x8857, float:4.891E-41)
            if (r5 == 0) goto L_0x012e
            r2.append(r0)
            r5 = 61
            java.lang.String r5 = m127(r5, r14, r12)
            java.lang.String r5 = r5.intern()
            boolean r5 = m134(r5)
            if (r5 == 0) goto L_0x0129
            r7 = 34
        L_0x0129:
            if (r7 == r6) goto L_0x012c
            goto L_0x0146
        L_0x012c:
            r5 = 0
            goto L_0x014f
        L_0x012e:
            r2.append(r0)
            r5 = 86
            java.lang.String r5 = m127(r7, r5, r12)
            java.lang.String r5 = r5.intern()
            boolean r5 = m134(r5)
            if (r5 == 0) goto L_0x0143
            r5 = 0
            goto L_0x0144
        L_0x0143:
            r5 = 1
        L_0x0144:
            if (r5 == 0) goto L_0x012c
        L_0x0146:
            java.lang.String r5 = m127(r11, r9, r10)
            java.lang.String r5 = r5.intern()
            goto L_0x0157
        L_0x014f:
            java.lang.String r7 = m127(r11, r6, r5)
            java.lang.String r5 = r7.intern()
        L_0x0157:
            r4.append(r5)
            r5 = 23
            r7 = 111(0x6f, float:1.56E-43)
            r12 = 39713(0x9b21, float:5.565E-41)
            java.lang.String r5 = m127(r5, r7, r12)
            java.lang.String r5 = r5.intern()
            boolean r5 = m134(r5)
            if (r5 == 0) goto L_0x0179
            r5 = 0
            java.lang.String r7 = m127(r11, r6, r5)
            java.lang.String r5 = r7.intern()
            goto L_0x0181
        L_0x0179:
            java.lang.String r5 = m127(r11, r9, r10)
            java.lang.String r5 = r5.intern()
        L_0x0181:
            r4.append(r5)
            r5 = 20
            r7 = 134(0x86, float:1.88E-43)
            r12 = 54816(0xd620, float:7.6814E-41)
            java.lang.String r5 = m127(r5, r7, r12)
            java.lang.String r5 = r5.intern()
            boolean r5 = m134(r5)
            if (r5 == 0) goto L_0x01a3
            r5 = 0
            java.lang.String r7 = m127(r11, r6, r5)
            java.lang.String r5 = r7.intern()
            goto L_0x01ab
        L_0x01a3:
            java.lang.String r5 = m127(r11, r9, r10)
            java.lang.String r5 = r5.intern()
        L_0x01ab:
            r4.append(r5)
            r5 = 154(0x9a, float:2.16E-43)
            r7 = 1955(0x7a3, float:2.74E-42)
            r12 = 15
            java.lang.String r5 = m127(r12, r5, r7)
            java.lang.String r5 = r5.intern()
            boolean r5 = m134(r5)
            if (r5 == 0) goto L_0x01cc
            r5 = 0
            java.lang.String r6 = m127(r11, r6, r5)
            java.lang.String r5 = r6.intern()
            goto L_0x01d4
        L_0x01cc:
            java.lang.String r5 = m127(r11, r9, r10)
            java.lang.String r5 = r5.intern()
        L_0x01d4:
            r4.append(r5)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = com.appsflyer.internal.y.m211((java.lang.String) r2)
            java.lang.String r2 = com.appsflyer.internal.y.m210(r2)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r2)
            r2 = 17
            int r3 = java.lang.Integer.parseInt(r3, r8)
            r6 = 16
            java.lang.String r3 = java.lang.Integer.toString(r3, r6)
            r7 = 0
            char r3 = r3.charAt(r7)
            r5.setCharAt(r2, r3)
            java.lang.String r2 = r5.toString()
            java.lang.String r3 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r2)
            r2 = 27
            int r3 = java.lang.Integer.parseInt(r3, r8)
            java.lang.String r3 = java.lang.Integer.toString(r3, r6)
            char r3 = r3.charAt(r7)
            r4.setCharAt(r2, r3)
            java.lang.String r2 = r4.toString()
            java.lang.Long r0 = java.lang.Long.valueOf(r17)
            java.lang.String r0 = m131((java.lang.String) r2, (java.lang.Long) r0)
            return r0
        L_0x022b:
            r0 = 32
            r1 = 54
            r2 = 0
            java.lang.String r0 = m127(r0, r1, r2)
            java.lang.String r0 = r0.intern()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.b.m132(android.content.Context, long):java.lang.String");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m131(String str, Long l) {
        long j;
        int i;
        boolean z = false;
        if (!(str == null) && l != null && str.length() == 32) {
            StringBuilder sb = new StringBuilder(str);
            String obj = l.toString();
            long j2 = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= obj.length()) {
                    break;
                }
                int i4 = f143 + 113;
                f142 = i4 % 128;
                if (!(i4 % 2 != 0)) {
                    i3 += Character.getNumericValue(obj.charAt(i2));
                    i2++;
                } else {
                    i3 -= Character.getNumericValue(obj.charAt(i2));
                    i2 += 87;
                }
            }
            String hexString = Integer.toHexString(i3);
            sb.replace(7, hexString.length() + 7, hexString);
            for (int i5 = 0; i5 < sb.length(); i5++) {
                j2 = j + ((long) Character.getNumericValue(sb.charAt(i5)));
            }
            while (true) {
                if ((j > 100 ? (char) 29 : 9) == 9) {
                    break;
                }
                int i6 = f143 + 3;
                f142 = i6 % 128;
                j = (i6 % 2 != 0 ? '2' : 'Z') != '2' ? j % 100 : j - 100;
            }
            int i7 = 23;
            sb.insert(23, (int) j);
            if (j < 10) {
                int i8 = f143 + 11;
                f142 = i8 % 128;
                if (i8 % 2 != 0) {
                    z = true;
                }
                if (!z) {
                    i = 35;
                } else {
                    i7 = 100;
                    i = 37;
                }
                sb.insert(i7, m127(1, i, 30949).intern());
            }
            return sb.toString();
        }
        String intern = m127(32, 54, 0).intern();
        int i9 = f142 + 39;
        f143 = i9 % 128;
        int i10 = i9 % 2;
        return intern;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean m134(String str) {
        int i = f142 + 51;
        f143 = i % 128;
        int i2 = i % 2;
        try {
            Class.forName(str);
            int i3 = f143 + 117;
            f142 = i3 % 128;
            int i4 = i3 % 2;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m130(String str) {
        if (!str.contains(m127(1, 169, 0).intern())) {
            int i = f142 + 31;
            f143 = i % 128;
            int i2 = i % 2;
            return str;
        }
        String[] split = str.split(m127(2, 170, 0).intern());
        int length = split.length;
        StringBuilder sb = new StringBuilder();
        int i3 = length - 1;
        sb.append(split[i3]);
        sb.append(m127(1, 169, 0).intern());
        int i4 = 1;
        while (true) {
            if (i4 >= i3) {
                sb.append(split[0]);
                return sb.toString();
            }
            int i5 = f143 + 107;
            f142 = i5 % 128;
            if (!(i5 % 2 != 0)) {
                sb.append(split[i4]);
                sb.append(m127(1, 169, 0).intern());
                i4++;
            } else {
                sb.append(split[i4]);
                sb.append(m127(0, 23060, 0).intern());
                i4 += 40;
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static String m133(Context context) {
        int i = f143 + 17;
        f142 = i % 128;
        int i2 = i % 2;
        if (!(System.getProperties().containsKey(m127(14, 172, 0).intern()))) {
            return null;
        }
        try {
            Matcher matcher = Pattern.compile(m127(10, JfifUtil.MARKER_SOFn, 0).intern()).matcher(context.getCacheDir().getPath().replace(m127(6, 186, 34261).intern(), ""));
            if ((matcher.find() ? (char) 1 : 27) == 27) {
                return null;
            }
            int i3 = f143 + 73;
            f142 = i3 % 128;
            int i4 = i3 % 2;
            return matcher.group(1);
        } catch (Exception e2) {
            if (x.f258 == null) {
                x.f258 = new x();
                int i5 = f142 + 57;
                f143 = i5 % 128;
                int i6 = i5 % 2;
            }
            x xVar = x.f258;
            String intern = m127(17, 202, 0).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m127(41, 219, 22912).intern());
            sb.append(e2);
            xVar.m205((String) null, intern, sb.toString());
            return null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m128(Context context) {
        PackageInfo packageInfo;
        int i = f143 + 75;
        f142 = i % 128;
        char c2 = 1;
        if ((i % 2 != 0 ? 'a' : 5) != 'a') {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        } else {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
        }
        String str = packageInfo.packageName;
        int i2 = f142 + 95;
        f143 = i2 % 128;
        if (i2 % 2 == 0) {
            c2 = '4';
        }
        if (c2 != '4') {
            return str;
        }
        int i3 = 28 / 0;
        return str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m129(Context context, String str) {
        int i = f143 + 105;
        f142 = i % 128;
        int i2 = i % 2;
        try {
            Iterator it = ((List) PackageManager.class.getDeclaredMethod(m127(24, 260, 0).intern(), new Class[]{Integer.TYPE}).invoke(context.getPackageManager(), new Object[]{0})).iterator();
            while (true) {
                if (!(it.hasNext())) {
                    break;
                }
                int i3 = f143 + 11;
                f142 = i3 % 128;
                int i4 = i3 % 2;
                if (!(!((ApplicationInfo) it.next()).packageName.equals(str))) {
                    return Boolean.TRUE.toString();
                }
            }
        } catch (IllegalAccessException e2) {
            if (x.f258 == null) {
                x.f258 = new x();
            }
            x xVar = x.f258;
            String intern = m127(24, 284, 9718).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m127(47, 308, 13485).intern());
            sb.append(e2);
            xVar.m205((String) null, intern, sb.toString());
            int i5 = f143 + 1;
            f142 = i5 % 128;
            int i6 = i5 % 2;
        } catch (NoSuchMethodException e3) {
            if (x.f258 == null) {
                x.f258 = new x();
            }
            x xVar2 = x.f258;
            String intern2 = m127(24, 284, 9718).intern();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m127(47, 308, 13485).intern());
            sb2.append(e3);
            xVar2.m205((String) null, intern2, sb2.toString());
        } catch (InvocationTargetException e4) {
            if (x.f258 == null) {
                x.f258 = new x();
            }
            x xVar3 = x.f258;
            String intern3 = m127(24, 284, 9718).intern();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(m127(47, 308, 13485).intern());
            sb3.append(e4);
            xVar3.m205((String) null, intern3, sb3.toString());
        }
        return Boolean.FALSE.toString();
    }

    /* renamed from: com.appsflyer.internal.b$b  reason: collision with other inner class name */
    public static class C0090b extends HashMap<String, Object> {

        /* renamed from: ʻ  reason: contains not printable characters */
        private static int f144 = 1;

        /* renamed from: ˋ  reason: contains not printable characters */
        private static char[] f145 = {2324, 21955, 45194, 8049, 31324, 55560, 9712, 32950, 61313, 19012, 43320, 62965, 'b', 23714, 47553, 5662, 29476, 'N', 23711, 47615, 5682, 29458, 53329, 11438, 35316, 'k', 23733, 47558, 'f', 23729, 47561, 5660, 29477, 53364, 11456, 35287, 59109, 17214, 41029, 64642, 22945, 46820, 4873, 28766, 52583, 10736, 34507, 58133, 16422, 40240, 63883, 22229, 46073, 4208, 27991, 51609, 9908, 33784, 57408, 15701, 39544, 63155, 21445, 45056, 3380, 27257, 50831, 9182, 32954, 56688, 'k', 23733, 47558, 5705, 29561, 53289, 11481, 8538, 32133, 39150, 14143, 21000, 61792, 3517, 43257, 51154, 25103, 33140, 56712, 30877, 38872, 12857, 15666, 25080, 33943, 11078, 20072, 60710, '-', 23714, 47555, 5726, 29546, 62731, 43484, 19620, 58225, 34376, 9497, 55725, 31930, 5000, 46675, 21800, 2543, 44236, 17289, 58980, 34099, 14346, 56477, 29606, 5752, 46411, 26717, 3323, 41916, 18049, 58696, 38952, 15549, 54234, 30356, 5497, 51253, 28493, 984, 42677, 17790, 63560, 40717, 13305, 54964, 30082, 10323, 53111, 25533, 'b', 23729, 47554, 5653, 29473, 53365, 11472, 35205, 59060, 17248, 41028, 64713, 23025, 46838, 4946, 28672, 52529, 10728, 59718, 46489, 20707, 65317, 39432, 14686, 50595, 24761, 4046, 43545, 18803, 5554, 45193, 24515, 64105, 39286, 9284, 49283, 28654, 2616, 43273, 29721, 4229, 49110, 23283, 63779, 33858, 8325, 53182, 27368, 2308, 54367, 29542, 8121, 47808, 22802, 58403, 't', 23733, 47565, 5632, 29477, 53346, 11393, 35268, 59125, 17186, 41029, 11481, 28745, 38199, 's', 23733, 47566, 5635, 29487, 53346, 15560, '&', 23720, 21328, 4053, 58790, 47392, 32155, 8477, 50220, 27581, 3788, 44508, 20845, 62588, 39693, 16031, 56815, 33134, 9301, 51993, 28412, 3488};

        /* renamed from: ˏ  reason: contains not printable characters */
        private static int f146;

        /* renamed from: ॱ  reason: contains not printable characters */
        private static long f147 = -6827154810379412272L;

        /* renamed from: ˊ  reason: contains not printable characters */
        private final Context f148;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final Map<String, Object> f149;

        public C0090b(Map<String, Object> map, Context context) {
            this.f149 = map;
            this.f148 = context;
            put(m136(), m135());
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.Object[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.lang.Integer} */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0073, code lost:
            if (r7 == null) goto L_0x008f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0087, code lost:
            if ((r7 == null ? ')' : 'T') != ')') goto L_0x0089;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x008f, code lost:
            r7 = r8;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: ˏ  reason: contains not printable characters */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.StringBuilder m137(java.lang.String... r11) throws java.lang.Exception {
            /*
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                int r1 = f146
                int r1 = r1 + 125
                int r2 = r1 % 128
                f144 = r2
                int r1 = r1 % 2
                r1 = 0
                r2 = 0
            L_0x0011:
                r3 = 3
                if (r2 >= r3) goto L_0x0046
                int r3 = f144
                int r3 = r3 + 79
                int r4 = r3 % 128
                f146 = r4
                int r3 = r3 % 2
                r4 = 1
                if (r3 == 0) goto L_0x0023
                r3 = 0
                goto L_0x0024
            L_0x0023:
                r3 = 1
            L_0x0024:
                if (r3 == r4) goto L_0x0036
                r3 = r11[r2]
                int r3 = r3.length()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r0.add(r3)
                int r2 = r2 + 100
                goto L_0x0011
            L_0x0036:
                r3 = r11[r2]
                int r3 = r3.length()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r0.add(r3)
                int r2 = r2 + 1
                goto L_0x0011
            L_0x0046:
                java.util.Collections.sort(r0)
                java.lang.Object r0 = r0.get(r1)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r4 = 0
            L_0x0059:
                if (r4 >= r0) goto L_0x00a5
                r5 = 0
                r7 = r5
                r6 = 0
            L_0x005e:
                if (r6 >= r3) goto L_0x0097
                int r8 = f146
                int r8 = r8 + 79
                int r9 = r8 % 128
                f144 = r9
                int r8 = r8 % 2
                if (r8 != 0) goto L_0x0078
                r8 = r11[r6]
                char r8 = r8.charAt(r4)
                int r9 = r5.length     // Catch:{ all -> 0x0076 }
                if (r7 != 0) goto L_0x0089
                goto L_0x008f
            L_0x0076:
                r11 = move-exception
                throw r11
            L_0x0078:
                r8 = r11[r6]
                char r8 = r8.charAt(r4)
                r9 = 41
                if (r7 != 0) goto L_0x0085
                r10 = 41
                goto L_0x0087
            L_0x0085:
                r10 = 84
            L_0x0087:
                if (r10 == r9) goto L_0x008f
            L_0x0089:
                int r7 = r7.intValue()
                r7 = r7 ^ r8
                goto L_0x0090
            L_0x008f:
                r7 = r8
            L_0x0090:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                int r6 = r6 + 1
                goto L_0x005e
            L_0x0097:
                int r5 = r7.intValue()
                java.lang.String r5 = java.lang.Integer.toHexString(r5)
                r2.append(r5)
                int r4 = r4 + 1
                goto L_0x0059
            L_0x00a5:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.b.C0090b.m137(java.lang.String[]):java.lang.StringBuilder");
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private String m136() {
            int i = f146 + 81;
            f144 = i % 128;
            int i2 = i % 2;
            try {
                String num = Integer.toString(Build.VERSION.SDK_INT);
                String obj = this.f149.get(m138(12, 0, 2421).intern()).toString();
                String obj2 = this.f149.get(m138(5, 12, 0).intern()).toString();
                if (!(obj2 != null)) {
                    int i3 = f144 + 123;
                    f146 = i3 % 128;
                    int i4 = i3 % 2;
                    obj2 = m138(8, 17, 0).intern();
                }
                StringBuilder sb = new StringBuilder(obj);
                sb.reverse();
                StringBuilder r1 = m137(num, obj2, sb.toString());
                int length = r1.length();
                if ((length > 4 ? 'J' : 'G') != 'J') {
                    while (true) {
                        if ((length < 4 ? 'X' : ':') != 'X') {
                            break;
                        }
                        length++;
                        r1.append('1');
                    }
                } else {
                    r1.delete(4, length);
                }
                r1.insert(0, m138(3, 25, 0).intern());
                return r1.toString();
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m138(42, 28, 0).intern());
                sb2.append(e2);
                AFLogger.afRDLog(sb2.toString());
                return m138(7, 70, 0).intern();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:34:0x014a, code lost:
            if (r7.contains(m138(2, 12373, 11425).intern()) != false) goto L_0x014c;
         */
        /* renamed from: ˋ  reason: contains not printable characters */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String m135() {
            /*
                r14 = this;
                java.lang.String r0 = ""
                r1 = 16
                r2 = 62829(0xf56d, float:8.8042E-41)
                r3 = 103(0x67, float:1.44E-43)
                r4 = 44
                r5 = 6
                r6 = 0
                java.util.Map<java.lang.String, java.lang.Object> r7 = r14.f149     // Catch:{ Exception -> 0x0080 }
                r8 = 12
                r9 = 2421(0x975, float:3.393E-42)
                java.lang.String r8 = m138(r8, r6, r9)     // Catch:{ Exception -> 0x0080 }
                java.lang.String r8 = r8.intern()     // Catch:{ Exception -> 0x0080 }
                java.lang.Object r7 = r7.get(r8)     // Catch:{ Exception -> 0x0080 }
                java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0080 }
                java.util.Map<java.lang.String, java.lang.Object> r8 = r14.f149     // Catch:{ Exception -> 0x0080 }
                r9 = 15
                r10 = 77
                r11 = 8508(0x213c, float:1.1922E-41)
                java.lang.String r9 = m138(r9, r10, r11)     // Catch:{ Exception -> 0x0080 }
                java.lang.String r9 = r9.intern()     // Catch:{ Exception -> 0x0080 }
                java.lang.Object r8 = r8.get(r9)     // Catch:{ Exception -> 0x0080 }
                java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0080 }
                r9 = 92
                r10 = 15622(0x3d06, float:2.1891E-41)
                java.lang.String r9 = m138(r5, r9, r10)     // Catch:{ Exception -> 0x0080 }
                java.lang.String r9 = r9.intern()     // Catch:{ Exception -> 0x0080 }
                r10 = 5
                r11 = 98
                java.lang.String r10 = m138(r10, r11, r6)     // Catch:{ Exception -> 0x0080 }
                java.lang.String r10 = r10.intern()     // Catch:{ Exception -> 0x0080 }
                java.lang.String r9 = r9.replaceAll(r10, r0)     // Catch:{ Exception -> 0x0080 }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0080 }
                r10.<init>()     // Catch:{ Exception -> 0x0080 }
                r10.append(r7)     // Catch:{ Exception -> 0x0080 }
                r10.append(r8)     // Catch:{ Exception -> 0x0080 }
                r10.append(r9)     // Catch:{ Exception -> 0x0080 }
                java.lang.String r7 = r10.toString()     // Catch:{ Exception -> 0x0080 }
                java.lang.String r7 = com.appsflyer.internal.y.m211((java.lang.String) r7)     // Catch:{ Exception -> 0x0080 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0080 }
                r8.<init>()     // Catch:{ Exception -> 0x0080 }
                r8.append(r0)     // Catch:{ Exception -> 0x0080 }
                java.lang.String r7 = r7.substring(r6, r1)     // Catch:{ Exception -> 0x0080 }
                r8.append(r7)     // Catch:{ Exception -> 0x0080 }
                java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x0080 }
                goto L_0x00b6
            L_0x0080:
                r7 = move-exception
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = m138(r4, r3, r2)
                java.lang.String r9 = r9.intern()
                r8.append(r9)
                r8.append(r7)
                java.lang.String r7 = r8.toString()
                com.appsflyer.AFLogger.afRDLog(r7)
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                r7.append(r0)
                r0 = 18
                r8 = 147(0x93, float:2.06E-43)
                java.lang.String r0 = m138(r0, r8, r6)
                java.lang.String r0 = r0.intern()
                r7.append(r0)
                java.lang.String r0 = r7.toString()
            L_0x00b6:
                android.content.Context r7 = r14.f148     // Catch:{ Exception -> 0x01f3 }
                r8 = 0
                android.content.IntentFilter r9 = new android.content.IntentFilter     // Catch:{ Exception -> 0x01f3 }
                r10 = 37
                r11 = 165(0xa5, float:2.31E-43)
                r12 = 59687(0xe927, float:8.364E-41)
                java.lang.String r10 = m138(r10, r11, r12)     // Catch:{ Exception -> 0x01f3 }
                java.lang.String r10 = r10.intern()     // Catch:{ Exception -> 0x01f3 }
                r9.<init>(r10)     // Catch:{ Exception -> 0x01f3 }
                android.content.Intent r7 = r7.registerReceiver(r8, r9)     // Catch:{ Exception -> 0x01f3 }
                r8 = -2700(0xfffffffffffff574, float:NaN)
                r9 = 2
                if (r7 == 0) goto L_0x0105
                int r10 = f146
                int r10 = r10 + 19
                int r11 = r10 % 128
                f144 = r11
                int r10 = r10 % r9
                if (r10 != 0) goto L_0x00f4
                r8 = 51
                r10 = 10134(0x2796, float:1.4201E-41)
                java.lang.String r8 = m138(r8, r10, r6)     // Catch:{ Exception -> 0x01f3 }
                java.lang.String r8 = r8.intern()     // Catch:{ Exception -> 0x01f3 }
                r10 = 20931(0x51c3, float:2.933E-41)
                int r7 = r7.getIntExtra(r8, r10)     // Catch:{ Exception -> 0x01f3 }
                goto L_0x0104
            L_0x00f4:
                r10 = 11
                r11 = 202(0xca, float:2.83E-43)
                java.lang.String r10 = m138(r10, r11, r6)     // Catch:{ Exception -> 0x01f3 }
                java.lang.String r10 = r10.intern()     // Catch:{ Exception -> 0x01f3 }
                int r7 = r7.getIntExtra(r10, r8)     // Catch:{ Exception -> 0x01f3 }
            L_0x0104:
                r8 = r7
            L_0x0105:
                android.content.Context r7 = r14.f148     // Catch:{ Exception -> 0x01f3 }
                android.content.pm.ApplicationInfo r7 = r7.getApplicationInfo()     // Catch:{ Exception -> 0x01f3 }
                java.lang.String r7 = r7.nativeLibraryDir     // Catch:{ Exception -> 0x01f3 }
                r10 = 1
                if (r7 == 0) goto L_0x0157
                int r11 = f146
                int r11 = r11 + 73
                int r12 = r11 % 128
                f144 = r12
                int r11 = r11 % r9
                if (r11 != 0) goto L_0x011d
                r11 = 1
                goto L_0x011e
            L_0x011d:
                r11 = 0
            L_0x011e:
                r12 = 11425(0x2ca1, float:1.601E-41)
                if (r11 == r10) goto L_0x013c
                r11 = 3
                r13 = 213(0xd5, float:2.98E-43)
                java.lang.String r11 = m138(r11, r13, r12)     // Catch:{ Exception -> 0x01f3 }
                java.lang.String r11 = r11.intern()     // Catch:{ Exception -> 0x01f3 }
                boolean r7 = r7.contains(r11)     // Catch:{ Exception -> 0x01f3 }
                r11 = 66
                if (r7 == 0) goto L_0x0137
                r7 = 6
                goto L_0x0139
            L_0x0137:
                r7 = 66
            L_0x0139:
                if (r7 == r11) goto L_0x0157
                goto L_0x014c
            L_0x013c:
                r11 = 12373(0x3055, float:1.7338E-41)
                java.lang.String r11 = m138(r9, r11, r12)     // Catch:{ Exception -> 0x01f3 }
                java.lang.String r11 = r11.intern()     // Catch:{ Exception -> 0x01f3 }
                boolean r7 = r7.contains(r11)     // Catch:{ Exception -> 0x01f3 }
                if (r7 == 0) goto L_0x0157
            L_0x014c:
                int r7 = f144
                int r7 = r7 + 119
                int r11 = r7 % 128
                f146 = r11
                int r7 = r7 % r9
                r7 = 1
                goto L_0x0166
            L_0x0157:
                int r7 = f146
                int r7 = r7 + 71
                int r11 = r7 % 128
                f144 = r11
                int r7 = r7 % r9
                if (r7 != 0) goto L_0x0164
                r7 = 0
                goto L_0x0165
            L_0x0164:
                r7 = 1
            L_0x0165:
                r7 = 0
            L_0x0166:
                android.content.Context r11 = r14.f148     // Catch:{ Exception -> 0x01f3 }
                r12 = 216(0xd8, float:3.03E-43)
                java.lang.String r5 = m138(r5, r12, r6)     // Catch:{ Exception -> 0x01f3 }
                java.lang.String r5 = r5.intern()     // Catch:{ Exception -> 0x01f3 }
                java.lang.Object r5 = r11.getSystemService(r5)     // Catch:{ Exception -> 0x01f3 }
                android.hardware.SensorManager r5 = (android.hardware.SensorManager) r5     // Catch:{ Exception -> 0x01f3 }
                r11 = -1
                java.util.List r5 = r5.getSensorList(r11)     // Catch:{ Exception -> 0x01f3 }
                int r5 = r5.size()     // Catch:{ Exception -> 0x01f3 }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f3 }
                r11.<init>()     // Catch:{ Exception -> 0x01f3 }
                r12 = 222(0xde, float:3.11E-43)
                r13 = 15530(0x3caa, float:2.1762E-41)
                java.lang.String r10 = m138(r10, r12, r13)     // Catch:{ Exception -> 0x01f3 }
                java.lang.String r10 = r10.intern()     // Catch:{ Exception -> 0x01f3 }
                r11.append(r10)     // Catch:{ Exception -> 0x01f3 }
                r11.append(r8)     // Catch:{ Exception -> 0x01f3 }
                r8 = 223(0xdf, float:3.12E-43)
                java.lang.String r6 = m138(r9, r8, r6)     // Catch:{ Exception -> 0x01f3 }
                java.lang.String r6 = r6.intern()     // Catch:{ Exception -> 0x01f3 }
                r11.append(r6)     // Catch:{ Exception -> 0x01f3 }
                r11.append(r7)     // Catch:{ Exception -> 0x01f3 }
                r6 = 225(0xe1, float:3.15E-43)
                r7 = 21366(0x5376, float:2.994E-41)
                java.lang.String r6 = m138(r9, r6, r7)     // Catch:{ Exception -> 0x01f3 }
                java.lang.String r6 = r6.intern()     // Catch:{ Exception -> 0x01f3 }
                r11.append(r6)     // Catch:{ Exception -> 0x01f3 }
                r11.append(r5)     // Catch:{ Exception -> 0x01f3 }
                r5 = 227(0xe3, float:3.18E-43)
                r6 = 58752(0xe580, float:8.2329E-41)
                java.lang.String r5 = m138(r9, r5, r6)     // Catch:{ Exception -> 0x01f3 }
                java.lang.String r5 = r5.intern()     // Catch:{ Exception -> 0x01f3 }
                r11.append(r5)     // Catch:{ Exception -> 0x01f3 }
                java.util.Map<java.lang.String, java.lang.Object> r5 = r14.f149     // Catch:{ Exception -> 0x01f3 }
                int r5 = r5.size()     // Catch:{ Exception -> 0x01f3 }
                r11.append(r5)     // Catch:{ Exception -> 0x01f3 }
                java.lang.String r5 = r11.toString()     // Catch:{ Exception -> 0x01f3 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01f3 }
                r6.<init>()     // Catch:{ Exception -> 0x01f3 }
                r6.append(r0)     // Catch:{ Exception -> 0x01f3 }
                byte[] r5 = r5.getBytes()     // Catch:{ Exception -> 0x01f3 }
                byte[] r5 = com.appsflyer.internal.b.C0090b.a.m139(r5)     // Catch:{ Exception -> 0x01f3 }
                java.lang.String r5 = com.appsflyer.internal.b.C0090b.a.m141((byte[]) r5)     // Catch:{ Exception -> 0x01f3 }
                r6.append(r5)     // Catch:{ Exception -> 0x01f3 }
                java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x01f3 }
                goto L_0x0229
            L_0x01f3:
                r5 = move-exception
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r2 = m138(r4, r3, r2)
                java.lang.String r2 = r2.intern()
                r6.append(r2)
                r6.append(r5)
                java.lang.String r2 = r6.toString()
                com.appsflyer.AFLogger.afRDLog(r2)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r0)
                r0 = 229(0xe5, float:3.21E-43)
                r3 = 32253(0x7dfd, float:4.5196E-41)
                java.lang.String r0 = m138(r1, r0, r3)
                java.lang.String r0 = r0.intern()
                r2.append(r0)
                java.lang.String r0 = r2.toString()
            L_0x0229:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.b.C0090b.m135():java.lang.String");
        }

        /* renamed from: com.appsflyer.internal.b$b$a */
        public static class a {

            /* renamed from: ˊ  reason: contains not printable characters */
            private final Object f150;

            /* renamed from: ˎ  reason: contains not printable characters */
            public String f151;

            /* renamed from: ˏ  reason: contains not printable characters */
            public long f152;

            a() {
            }

            /* renamed from: ˋ  reason: contains not printable characters */
            static byte[] m139(byte[] bArr) throws Exception {
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = (byte) (bArr[i] ^ ((i % 2) + 42));
                }
                return bArr;
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            static String m141(byte[] bArr) throws Exception {
                StringBuilder sb = new StringBuilder();
                for (byte hexString : bArr) {
                    String hexString2 = Integer.toHexString(hexString);
                    if (hexString2.length() == 1) {
                        hexString2 = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(hexString2));
                    }
                    sb.append(hexString2);
                }
                return sb.toString();
            }

            public a(long j, String str) {
                this.f150 = new Object();
                this.f152 = 0;
                this.f151 = "";
                this.f152 = j;
                this.f151 = str;
            }

            public a(String str) {
                this(System.currentTimeMillis(), str);
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public static a m140(String str) {
                if (str == null) {
                    return new a(0, "");
                }
                String[] split = str.split(",");
                return split.length < 2 ? new a(0, "") : new a(Long.parseLong(split[0]), split[1]);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
                return false;
             */
            /* renamed from: ˊ  reason: contains not printable characters */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean m142(long r9, java.lang.String r11) {
                /*
                    r8 = this;
                    java.lang.Object r0 = r8.f150
                    monitor-enter(r0)
                    r1 = 0
                    if (r11 == 0) goto L_0x0027
                    java.lang.String r2 = r8.f151     // Catch:{ all -> 0x0024 }
                    boolean r2 = r11.equals(r2)     // Catch:{ all -> 0x0024 }
                    if (r2 != 0) goto L_0x0027
                    long r2 = r8.f152     // Catch:{ all -> 0x0024 }
                    long r2 = r9 - r2
                    r4 = 2000(0x7d0, double:9.88E-321)
                    r6 = 1
                    int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                    if (r7 <= 0) goto L_0x001b
                    r2 = 1
                    goto L_0x001c
                L_0x001b:
                    r2 = 0
                L_0x001c:
                    if (r2 == 0) goto L_0x0027
                    r8.f152 = r9     // Catch:{ all -> 0x0024 }
                    r8.f151 = r11     // Catch:{ all -> 0x0024 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0024 }
                    return r6
                L_0x0024:
                    r9 = move-exception
                    monitor-exit(r0)
                    throw r9
                L_0x0027:
                    monitor-exit(r0)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.b.C0090b.a.m142(long, java.lang.String):boolean");
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f152);
                sb.append(",");
                sb.append(this.f151);
                return sb.toString();
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private static String m138(int i, int i2, char c2) {
            char[] cArr;
            int i3;
            int i4 = f146 + 113;
            f144 = i4 % 128;
            if (i4 % 2 == 0) {
                cArr = new char[i];
                i3 = 1;
            } else {
                cArr = new char[i];
                i3 = 0;
            }
            while (i3 < i) {
                int i5 = f144 + 119;
                f146 = i5 % 128;
                int i6 = i5 % 2;
                cArr[i3] = (char) ((int) ((((long) f145[i2 + i3]) ^ (((long) i3) * f147)) ^ ((long) c2)));
                i3++;
                int i7 = f144 + 73;
                f146 = i7 % 128;
                if (i7 % 2 != 0) {
                }
            }
            return new String(cArr);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m127(int i, int i2, char c2) {
        char[] cArr;
        int i3 = f143 + 57;
        f142 = i3 % 128;
        int i4 = 0;
        if (!(i3 % 2 == 0)) {
            cArr = new char[i];
            i4 = 1;
        } else {
            cArr = new char[i];
        }
        while (true) {
            if ((i4 < i ? (char) 14 : 10) != 14) {
                return new String(cArr);
            }
            int i5 = f142 + 29;
            f143 = i5 % 128;
            int i6 = i5 % 2;
            cArr[i4] = (char) ((int) ((((long) f140[i2 + i4]) ^ (((long) i4) * f141)) ^ ((long) c2)));
            i4++;
        }
    }
}
