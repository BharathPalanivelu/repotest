package com.modiface.mfemakeupkit.utils;

import android.util.Log;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15388a = "MFEJNIUtil";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f15389b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String f15390c;

    public static void a(String str) {
        b();
        b(str);
    }

    private static boolean b() {
        if (f15389b) {
            return true;
        }
        boolean c2 = c("gnustl_shared");
        if (!c2) {
            c2 = c("c++_shared");
        }
        f15389b = c2;
        if (!c2) {
            Log.e(f15388a, "could not load any default c++ libraries");
        }
        return c2;
    }

    private static boolean c(String str) {
        try {
            b(str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00ea, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00eb, code lost:
        r7 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00ef, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00f0, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00f2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00f3, code lost:
        r5 = null;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0116, code lost:
        f15390c = f15390c.substring(0, 200) + "..." + f15390c.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0142, code lost:
        f15390c = "FileNotFoundException";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a3 A[Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[ExcHandler: FileNotFoundException (unused java.io.FileNotFoundException), SYNTHETIC, Splitter:B:4:0x0018] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0029 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a() {
        /*
            java.lang.String r0 = "mips"
            java.lang.String r1 = "armv6"
            java.lang.String r2 = "MFEJNIUtil"
            java.lang.String r3 = "x86"
            java.lang.String r4 = "armv7"
            java.lang.String r5 = f15390c
            if (r5 == 0) goto L_0x000f
            return r5
        L_0x000f:
            java.io.File r5 = new java.io.File
            java.lang.String r6 = "/proc/cpuinfo"
            r5.<init>(r6)
            r6 = 0
            r7 = 0
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00f2 }
            r8.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00f2 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ef }
            r5.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ef }
            java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ed }
            r10 = 1024(0x400, float:1.435E-42)
            r9.<init>(r5, r10)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ed }
        L_0x0029:
            java.lang.String r7 = r9.readLine()     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            if (r7 == 0) goto L_0x00d8
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            r10.<init>()     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            java.lang.String r11 = "read: "
            r10.append(r11)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            r10.append(r7)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            java.lang.String r10 = r10.toString()     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            android.util.Log.d(r2, r10)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            java.util.Locale r10 = java.util.Locale.US     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            java.lang.String r7 = r7.toLowerCase(r10)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            java.lang.String r10 = ":"
            int r10 = r7.indexOf(r10)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            if (r10 > 0) goto L_0x0052
            goto L_0x0029
        L_0x0052:
            int r10 = r10 + 1
            java.lang.String r7 = r7.substring(r10)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            boolean r10 = r7.contains(r4)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            if (r10 != 0) goto L_0x0099
            java.lang.String r10 = "cortex"
            boolean r10 = r7.contains(r10)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            if (r10 == 0) goto L_0x0067
            goto L_0x0099
        L_0x0067:
            boolean r10 = r7.contains(r3)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            if (r10 == 0) goto L_0x0070
            f15390c = r3     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            goto L_0x009b
        L_0x0070:
            java.lang.String r10 = "intel"
            boolean r10 = r7.contains(r10)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            if (r10 == 0) goto L_0x007b
            f15390c = r3     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            goto L_0x009b
        L_0x007b:
            boolean r10 = r7.contains(r1)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            if (r10 == 0) goto L_0x0090
            java.lang.String r10 = f15390c     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            if (r10 == 0) goto L_0x008d
            java.lang.String r10 = f15390c     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            boolean r10 = r10.equals(r4)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            if (r10 != 0) goto L_0x009b
        L_0x008d:
            f15390c = r1     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            goto L_0x009b
        L_0x0090:
            boolean r10 = r7.contains(r0)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            if (r10 == 0) goto L_0x009b
            f15390c = r0     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            goto L_0x009b
        L_0x0099:
            f15390c = r4     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
        L_0x009b:
            java.lang.String r10 = "armv"
            int r10 = r7.indexOf(r10)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            if (r10 < 0) goto L_0x0029
            java.lang.String r7 = r7.substring(r10)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            r10 = 4
            r11 = 4
        L_0x00a9:
            int r12 = r7.length()     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            if (r11 >= r12) goto L_0x00c3
            char r12 = r7.charAt(r11)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            r13 = 48
            if (r12 < r13) goto L_0x00c3
            char r12 = r7.charAt(r11)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            r13 = 57
            if (r12 <= r13) goto L_0x00c0
            goto L_0x00c3
        L_0x00c0:
            int r11 = r11 + 1
            goto L_0x00a9
        L_0x00c3:
            java.lang.String r7 = r7.substring(r6, r11)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            java.lang.String r7 = r7.substring(r10)     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x00d0 }
            goto L_0x00d1
        L_0x00d0:
            r7 = 0
        L_0x00d1:
            r10 = 7
            if (r7 < r10) goto L_0x0029
            f15390c = r4     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            goto L_0x0029
        L_0x00d8:
            java.lang.String r0 = f15390c     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            if (r0 != 0) goto L_0x00e0
            java.lang.String r0 = "not detected"
            f15390c = r0     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
        L_0x00e0:
            r9.close()     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            r5.close()     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            r8.close()     // Catch:{ FileNotFoundException -> 0x0142, IOException -> 0x00ea }
            goto L_0x0146
        L_0x00ea:
            r0 = move-exception
            r7 = r9
            goto L_0x00f5
        L_0x00ed:
            r0 = move-exception
            goto L_0x00f5
        L_0x00ef:
            r0 = move-exception
            r5 = r7
            goto L_0x00f5
        L_0x00f2:
            r0 = move-exception
            r5 = r7
            r8 = r5
        L_0x00f5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "exception: "
            r1.append(r3)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            f15390c = r0
            java.lang.String r0 = f15390c
            int r0 = r0.length()
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 <= r1) goto L_0x0138
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = f15390c
            java.lang.String r1 = r3.substring(r6, r1)
            r0.append(r1)
            java.lang.String r1 = "..."
            r0.append(r1)
            java.lang.String r1 = f15390c
            int r1 = r1.length()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            f15390c = r0
        L_0x0138:
            r7.close()     // Catch:{ IOException -> 0x0146 }
            r5.close()     // Catch:{ IOException -> 0x0146 }
            r8.close()     // Catch:{ IOException -> 0x0146 }
            goto L_0x0146
        L_0x0142:
            java.lang.String r0 = "FileNotFoundException"
            f15390c = r0
        L_0x0146:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "CPU arch = "
            r0.append(r1)
            java.lang.String r1 = f15390c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r2, r0)
            java.lang.String r0 = f15390c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.modiface.mfemakeupkit.utils.q.a():java.lang.String");
    }

    private static void b(String str) {
        String a2 = a();
        try {
            System.loadLibrary(str + "-" + a2);
        } catch (UnsatisfiedLinkError unused) {
            System.loadLibrary(str);
        }
    }
}
