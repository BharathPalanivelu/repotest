package com.shopee.d.a.c;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    static int f27131a = -100;

    /* renamed from: b  reason: collision with root package name */
    static long f27132b = -100;

    /* renamed from: c  reason: collision with root package name */
    static int f27133c = -100;

    /* renamed from: d  reason: collision with root package name */
    static String f27134d = String.valueOf(-100);

    /* renamed from: e  reason: collision with root package name */
    private static final FileFilter f27135e = new FileFilter() {
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    };

    /* JADX WARNING: Can't wrap try/catch for region: R(5:(8:11|12|13|14|15|16|17|18)|26|27|29|30) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0047 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0049 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x004e */
    @android.annotation.TargetApi(16)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long a(android.content.Context r8) {
        /*
            long r0 = f27132b
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0009
            return r0
        L_0x0009:
            r4 = -100
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0054
            java.lang.Class<com.shopee.d.a.c.a> r0 = com.shopee.d.a.c.a.class
            monitor-enter(r0)
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x004e }
            r4 = 16
            if (r1 < r4) goto L_0x002d
            android.app.ActivityManager$MemoryInfo r1 = new android.app.ActivityManager$MemoryInfo     // Catch:{ Throwable -> 0x004e }
            r1.<init>()     // Catch:{ Throwable -> 0x004e }
            java.lang.String r4 = "activity"
            java.lang.Object r8 = r8.getSystemService(r4)     // Catch:{ Throwable -> 0x004e }
            android.app.ActivityManager r8 = (android.app.ActivityManager) r8     // Catch:{ Throwable -> 0x004e }
            r8.getMemoryInfo(r1)     // Catch:{ Throwable -> 0x004e }
            long r4 = r1.totalMem     // Catch:{ Throwable -> 0x004e }
            f27132b = r4     // Catch:{ Throwable -> 0x004e }
            goto L_0x0050
        L_0x002d:
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0048 }
            java.lang.String r1 = "/proc/meminfo"
            r8.<init>(r1)     // Catch:{ IOException -> 0x0048 }
            java.lang.String r1 = "MemTotal"
            int r1 = a((java.lang.String) r1, (java.io.FileInputStream) r8)     // Catch:{ all -> 0x0043 }
            long r4 = (long) r1
            r6 = 1024(0x400, double:5.06E-321)
            long r4 = r4 * r6
            r8.close()     // Catch:{ IOException | Throwable -> 0x0049 }
            goto L_0x0049
        L_0x0043:
            r1 = move-exception
            r8.close()     // Catch:{ Throwable -> 0x0047 }
        L_0x0047:
            throw r1     // Catch:{ IOException -> 0x0048 }
        L_0x0048:
            r4 = r2
        L_0x0049:
            f27132b = r4     // Catch:{ Throwable -> 0x004e }
            goto L_0x0050
        L_0x004c:
            r8 = move-exception
            goto L_0x0052
        L_0x004e:
            f27132b = r2     // Catch:{ all -> 0x004c }
        L_0x0050:
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            goto L_0x0054
        L_0x0052:
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            throw r8
        L_0x0054:
            long r0 = f27132b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.d.a.c.a.a(android.content.Context):long");
    }

    private static int a(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == 10 || i == 0) {
                    if (bArr[i] == 10) {
                        i++;
                    }
                    int i2 = i;
                    while (true) {
                        if (i2 >= read) {
                            continue;
                            break;
                        }
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            break;
                        } else if (i3 == str.length() - 1) {
                            return a(bArr, i2);
                        } else {
                            i2++;
                        }
                    }
                }
                i++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }

    private static int a(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            if (Character.isDigit(bArr[i])) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }
}
