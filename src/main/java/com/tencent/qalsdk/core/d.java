package com.tencent.qalsdk.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import com.tencent.qalsdk.util.QLog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f32176a = new byte[0];

    private static byte a(byte b2) {
        int i;
        if (b2 < 48 || b2 > 57) {
            byte b3 = 97;
            if (b2 < 97 || b2 > 102) {
                b3 = 65;
                if (b2 < 65 || b2 > 70) {
                    return 0;
                }
            }
            i = (b2 - b3) + 10;
        } else {
            i = b2 - 48;
        }
        return (byte) i;
    }

    public static void a(Context context) {
        byte[] d2 = d(context);
        byte[] b2 = b(context);
        if (d2 == null || d2.length <= 0) {
            if (b2 == null || b2.length <= 0) {
                d2 = new String("%4;7t>;28<fc.5*6").getBytes();
            } else {
                d2 = b2;
            }
            b(context, d2);
        } else {
            if (b2 == null || b2.length <= 0) {
                b2 = new String("%4;7t>;28<fc.5*6").getBytes();
            }
            Arrays.equals(b2, d2);
        }
        f32176a = (byte[]) d2.clone();
    }

    public static byte[] a() {
        byte[] bArr = f32176a;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a A[Catch:{ Throwable -> 0x006a }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038 A[Catch:{ Throwable -> 0x006a }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049 A[Catch:{ Throwable -> 0x006a }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005e A[Catch:{ Throwable -> 0x006a }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061 A[Catch:{ Throwable -> 0x006a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] b(android.content.Context r4) {
        /*
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Throwable -> 0x006a }
            r2 = 23
            r3 = 0
            if (r1 < r2) goto L_0x0010
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            int r1 = r4.checkCallingOrSelfPermission(r1)     // Catch:{ Throwable -> 0x006a }
            if (r1 != 0) goto L_0x001f
        L_0x0010:
            java.lang.String r1 = "phone"
            java.lang.Object r1 = r4.getSystemService(r1)     // Catch:{ Throwable -> 0x006a }
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch:{ Throwable -> 0x006a }
            if (r1 == 0) goto L_0x001f
            java.lang.String r1 = r1.getDeviceId()     // Catch:{ Throwable -> 0x006a }
            goto L_0x0020
        L_0x001f:
            r1 = r3
        L_0x0020:
            java.lang.String r2 = "wifi"
            java.lang.Object r4 = r4.getSystemService(r2)     // Catch:{ Throwable -> 0x006a }
            android.net.wifi.WifiManager r4 = (android.net.wifi.WifiManager) r4     // Catch:{ Throwable -> 0x006a }
            if (r4 == 0) goto L_0x0034
            android.net.wifi.WifiInfo r4 = r4.getConnectionInfo()     // Catch:{ Throwable -> 0x006a }
            if (r4 == 0) goto L_0x0034
            java.lang.String r3 = r4.getMacAddress()     // Catch:{ Throwable -> 0x006a }
        L_0x0034:
            java.lang.String r4 = ""
            if (r1 == 0) goto L_0x0047
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x006a }
            r2.<init>()     // Catch:{ Throwable -> 0x006a }
            r2.append(r4)     // Catch:{ Throwable -> 0x006a }
            r2.append(r1)     // Catch:{ Throwable -> 0x006a }
            java.lang.String r4 = r2.toString()     // Catch:{ Throwable -> 0x006a }
        L_0x0047:
            if (r3 == 0) goto L_0x0058
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x006a }
            r1.<init>()     // Catch:{ Throwable -> 0x006a }
            r1.append(r4)     // Catch:{ Throwable -> 0x006a }
            r1.append(r3)     // Catch:{ Throwable -> 0x006a }
            java.lang.String r4 = r1.toString()     // Catch:{ Throwable -> 0x006a }
        L_0x0058:
            int r1 = r4.length()     // Catch:{ Throwable -> 0x006a }
            if (r1 > 0) goto L_0x0061
            byte[] r4 = new byte[r0]     // Catch:{ Throwable -> 0x006a }
            return r4
        L_0x0061:
            byte[] r4 = r4.getBytes()     // Catch:{ Throwable -> 0x006a }
            byte[] r4 = a((byte[]) r4)     // Catch:{ Throwable -> 0x006a }
            return r4
        L_0x006a:
            byte[] r4 = new byte[r0]
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.core.d.b(android.content.Context):byte[]");
    }

    private static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance(Hash.ALGORITHM_MD5).digest(bArr);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] a(String str) {
        if (str == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((a((byte) str.charAt(i2)) << 4) + a((byte) str.charAt(i2 + 1)));
        }
        return bArr;
    }

    private static byte[] c(Context context) {
        byte[] bArr = new byte[0];
        try {
            return a(context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("imei", new String("")));
        } catch (Throwable th) {
            QLog.e("imsdk.GuidUtil", 1, "exception: " + th.toString());
            return bArr;
        }
    }

    private static void a(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            SharedPreferences.Editor edit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
            String str = "";
            if (bArr != null) {
                for (int i = 0; i < bArr.length; i++) {
                    str = (str + Integer.toHexString((bArr[i] >> 4) & 15)) + Integer.toHexString(bArr[i] & 15);
                }
            }
            edit.putString("imei", str);
            edit.commit();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0087 A[SYNTHETIC, Splitter:B:37:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0094 A[SYNTHETIC, Splitter:B:43:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(android.content.Context r7, byte[] r8) {
        /*
            java.lang.String r0 = "exception: "
            java.lang.String r1 = "imsdk.GuidUtil"
            if (r7 == 0) goto L_0x00ad
            if (r8 == 0) goto L_0x00ad
            int r2 = r8.length
            if (r2 <= 0) goto L_0x00ad
            r2 = 0
            r3 = 1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0071 }
            r4.<init>()     // Catch:{ Exception -> 0x0071 }
            java.io.File r5 = r7.getFilesDir()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ Exception -> 0x0071 }
            r4.append(r5)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r5 = "/wlogin_device.dat"
            r4.append(r5)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0071 }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0071 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0071 }
            boolean r4 = r5.exists()     // Catch:{ Exception -> 0x0071 }
            if (r4 != 0) goto L_0x0034
            r5.createNewFile()     // Catch:{ Exception -> 0x0071 }
        L_0x0034:
            boolean r4 = r5.exists()     // Catch:{ Exception -> 0x0071 }
            if (r4 == 0) goto L_0x0051
            boolean r4 = r5.canWrite()     // Catch:{ Exception -> 0x0071 }
            if (r4 == 0) goto L_0x0051
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0071 }
            r6 = 0
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x0071 }
            r4.write(r8)     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            r2 = r4
            goto L_0x0051
        L_0x004b:
            r7 = move-exception
            r2 = r4
            goto L_0x0092
        L_0x004e:
            r7 = move-exception
            r2 = r4
            goto L_0x0072
        L_0x0051:
            a(r7, r8)     // Catch:{ Exception -> 0x0071 }
            if (r2 == 0) goto L_0x00ad
            r2.close()     // Catch:{ IOException -> 0x005a }
            return
        L_0x005a:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r0)
        L_0x0060:
            java.lang.String r7 = r7.toString()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.tencent.qalsdk.util.QLog.e(r1, r3, r7)
            return
        L_0x006f:
            r7 = move-exception
            goto L_0x0092
        L_0x0071:
            r7 = move-exception
        L_0x0072:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r8.<init>(r0)     // Catch:{ all -> 0x006f }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x006f }
            r8.append(r7)     // Catch:{ all -> 0x006f }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x006f }
            com.tencent.qalsdk.util.QLog.e(r1, r3, r7)     // Catch:{ all -> 0x006f }
            if (r2 == 0) goto L_0x00ad
            r2.close()     // Catch:{ IOException -> 0x008b }
            return
        L_0x008b:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r0)
            goto L_0x0060
        L_0x0092:
            if (r2 == 0) goto L_0x00ac
            r2.close()     // Catch:{ IOException -> 0x0098 }
            goto L_0x00ac
        L_0x0098:
            r8 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r8 = r8.toString()
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            com.tencent.qalsdk.util.QLog.e(r1, r3, r8)
        L_0x00ac:
            throw r7
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.core.d.b(android.content.Context, byte[]):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007f A[SYNTHETIC, Splitter:B:28:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009c A[SYNTHETIC, Splitter:B:41:0x009c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] d(android.content.Context r8) {
        /*
            java.lang.String r0 = "exception: "
            java.lang.String r1 = "imsdk.GuidUtil"
            r2 = 0
            if (r8 != 0) goto L_0x0008
            return r2
        L_0x0008:
            r3 = 0
            byte[] r3 = new byte[r3]
            r4 = 1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0069 }
            r5.<init>()     // Catch:{ Exception -> 0x0069 }
            java.io.File r6 = r8.getFilesDir()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x0069 }
            r5.append(r6)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r6 = "/wlogin_device.dat"
            r5.append(r6)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0069 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0069 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x0069 }
            boolean r5 = r6.exists()     // Catch:{ Exception -> 0x0069 }
            if (r5 == 0) goto L_0x004b
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0069 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0069 }
            int r2 = r5.available()     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r6 = 1024(0x400, float:1.435E-42)
            if (r2 >= r6) goto L_0x004c
            byte[] r3 = new byte[r2]     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            r5.read(r3)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            goto L_0x004c
        L_0x0043:
            r8 = move-exception
            r2 = r5
            goto L_0x009a
        L_0x0046:
            r2 = move-exception
            r7 = r5
            r5 = r2
            r2 = r7
            goto L_0x006a
        L_0x004b:
            r5 = r2
        L_0x004c:
            if (r5 == 0) goto L_0x008a
            r5.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x008a
        L_0x0052:
            r2 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r0)
        L_0x0058:
            java.lang.String r0 = r2.toString()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            com.tencent.qalsdk.util.QLog.e(r1, r4, r0)
            goto L_0x008a
        L_0x0067:
            r8 = move-exception
            goto L_0x009a
        L_0x0069:
            r5 = move-exception
        L_0x006a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0067 }
            r6.<init>(r0)     // Catch:{ all -> 0x0067 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0067 }
            r6.append(r5)     // Catch:{ all -> 0x0067 }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x0067 }
            com.tencent.qalsdk.util.QLog.e(r1, r4, r5)     // Catch:{ all -> 0x0067 }
            if (r2 == 0) goto L_0x008a
            r2.close()     // Catch:{ IOException -> 0x0083 }
            goto L_0x008a
        L_0x0083:
            r2 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r0)
            goto L_0x0058
        L_0x008a:
            int r0 = r3.length
            if (r0 > 0) goto L_0x0099
            byte[] r3 = c(r8)
            if (r3 == 0) goto L_0x0099
            int r0 = r3.length
            if (r0 <= 0) goto L_0x0099
            b(r8, r3)
        L_0x0099:
            return r3
        L_0x009a:
            if (r2 == 0) goto L_0x00b4
            r2.close()     // Catch:{ IOException -> 0x00a0 }
            goto L_0x00b4
        L_0x00a0:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = r2.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.tencent.qalsdk.util.QLog.e(r1, r4, r0)
        L_0x00b4:
            goto L_0x00b6
        L_0x00b5:
            throw r8
        L_0x00b6:
            goto L_0x00b5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.core.d.d(android.content.Context):byte[]");
    }
}
