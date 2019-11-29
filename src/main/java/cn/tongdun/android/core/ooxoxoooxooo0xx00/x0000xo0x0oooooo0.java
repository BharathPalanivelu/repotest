package cn.tongdun.android.core.ooxoxoooxooo0xx00;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;

public class x0000xo0x0oooooo0 {
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004b, code lost:
        if (r1 != null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (r1 == null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r1.waitFor();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        r1.destroy();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String o00xxox0x0xoox(java.lang.String r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r1 = cn.tongdun.android.core.ooxoxoooxooo0xx00.ox000o0o.o00xxox0x0xoox((java.lang.String) r6)
            if (r1 != 0) goto L_0x0062
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0059, all -> 0x004e }
            java.lang.Process r1 = r2.exec(r6)     // Catch:{ IOException -> 0x0059, all -> 0x004e }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0059, all -> 0x004e }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0059, all -> 0x004e }
            java.io.InputStream r3 = r1.getInputStream()     // Catch:{ IOException -> 0x0059, all -> 0x004e }
            java.lang.String r4 = "341a675172"
            r5 = 40
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r4, (int) r5)     // Catch:{ IOException -> 0x0059, all -> 0x004e }
            r2.<init>(r3, r4)     // Catch:{ IOException -> 0x0059, all -> 0x004e }
            r6.<init>(r2)     // Catch:{ IOException -> 0x0059, all -> 0x004e }
        L_0x002a:
            java.lang.String r2 = r6.readLine()     // Catch:{ IOException -> 0x0059, all -> 0x004e }
            if (r2 == 0) goto L_0x004b
            boolean r3 = cn.tongdun.android.core.ooxoxoooxooo0xx00.ox000o0o.o00xxox0x0xoox((java.lang.String) r2)     // Catch:{ IOException -> 0x0059, all -> 0x004e }
            if (r3 != 0) goto L_0x002a
            int r3 = r0.length()     // Catch:{ IOException -> 0x0059, all -> 0x004e }
            if (r3 <= 0) goto L_0x0047
            java.lang.String r3 = "6d"
            r4 = 93
            java.lang.String r3 = o00xxox0x0xoox((java.lang.String) r3, (int) r4)     // Catch:{ IOException -> 0x0059, all -> 0x004e }
            r0.append(r3)     // Catch:{ IOException -> 0x0059, all -> 0x004e }
        L_0x0047:
            r0.append(r2)     // Catch:{ IOException -> 0x0059, all -> 0x004e }
            goto L_0x002a
        L_0x004b:
            if (r1 == 0) goto L_0x0062
            goto L_0x005b
        L_0x004e:
            r6 = move-exception
            if (r1 == 0) goto L_0x0058
            r1.waitFor()     // Catch:{ InterruptedException -> 0x0055 }
            goto L_0x0058
        L_0x0055:
            r1.destroy()
        L_0x0058:
            throw r6
        L_0x0059:
            if (r1 == 0) goto L_0x0062
        L_0x005b:
            r1.waitFor()     // Catch:{ InterruptedException -> 0x005f }
            goto L_0x0062
        L_0x005f:
            r1.destroy()
        L_0x0062:
            java.lang.String r6 = r0.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.tongdun.android.core.ooxoxoooxooo0xx00.x0000xo0x0oooooo0.o00xxox0x0xoox(java.lang.String):java.lang.String");
    }

    public static PackageInfo o00xxox0x0xoox(PackageManager packageManager, String str) {
        try {
            return packageManager.getPackageInfo(str, 0);
        } catch (Exception unused) {
            return null;
        }
    }

    @TargetApi(23)
    public static String o00xxox0x0xoox() {
        if (Build.VERSION.SDK_INT > 23) {
            try {
                Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                while (it.hasNext()) {
                    NetworkInterface networkInterface = (NetworkInterface) it.next();
                    if (networkInterface.getName().equalsIgnoreCase(o00xxox0x0xoox("366d7a6224", 69))) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            return "";
                        }
                        StringBuilder sb = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            sb.append(String.format(o00xxox0x0xoox("645c273645", 122), new Object[]{Byte.valueOf(hardwareAddress[i])}));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString().toLowerCase();
                    }
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static boolean o00xxox0x0xoox(Context context) {
        return (context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    public static String o00xxox0x0xoox(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b2 = (byte) (i ^ 51);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 65);
            byte b3 = bArr[0];
            int i4 = 1;
            while (i4 < length2) {
                byte b4 = bArr[i4];
                bArr[i4] = (byte) ((b3 ^ bArr[i4]) ^ b2);
                i4++;
                b3 = b4;
            }
            return new String(bArr, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
