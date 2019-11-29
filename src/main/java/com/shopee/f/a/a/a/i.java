package com.shopee.f.a.a.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.salesforce.android.service.common.liveagentlogging.event.ConnectivityEvent;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.security.MessageDigest;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f27219a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String a(byte[] bArr) {
        char[] cArr = new char[(bArr.length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i + 1;
            char[] cArr2 = f27219a;
            cArr[i] = cArr2[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & 15];
        }
        return new String(cArr);
    }

    public static String a(String str) {
        String str2;
        if (str == null) {
            return "";
        }
        try {
            str2 = a(MessageDigest.getInstance(Hash.ALGORITHM_MD5).digest(str.getBytes("UTF-8")));
        } catch (Exception e2) {
            e2.printStackTrace();
            str2 = "";
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public static String a(Context context) {
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String deviceId = telephonyManager != null ? telephonyManager.getDeviceId() : str;
            if (deviceId != null) {
                str = deviceId;
            }
        } catch (Exception unused) {
        }
        return a(str);
    }

    public static String b(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            str = "";
        }
        return a(str);
    }

    public static String c(Context context) {
        String str;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
            str = connectionInfo != null ? connectionInfo.getMacAddress() : null;
            if (str != null) {
                try {
                    str = a(str.replaceAll(":", "").toUpperCase());
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            str = "";
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String d(Context context) {
        return a(context) + ";" + c(context) + ";" + b(context);
    }

    public static String e(Context context) {
        return a(context, d(context));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0090 A[SYNTHETIC, Splitter:B:27:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "/txrtmp/spuid"
            java.lang.String r1 = "com.tencent.ugcpublish.dev_uuid"
            r2 = 0
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r1, r2)
            java.lang.String r1 = ""
            java.lang.String r2 = "com.tencent.ugcpublish.key_dev_uuid"
            java.lang.String r2 = r7.getString(r2, r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0054 }
            r3.<init>()     // Catch:{ Exception -> 0x0054 }
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0054 }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x0054 }
            r3.append(r4)     // Catch:{ Exception -> 0x0054 }
            r3.append(r0)     // Catch:{ Exception -> 0x0054 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0054 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0054 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0054 }
            boolean r3 = r4.exists()     // Catch:{ Exception -> 0x0054 }
            if (r3 == 0) goto L_0x0052
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0054 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0054 }
            int r4 = r3.available()     // Catch:{ Exception -> 0x0054 }
            if (r4 <= 0) goto L_0x004b
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0054 }
            r3.read(r4)     // Catch:{ Exception -> 0x0054 }
            java.lang.String r5 = new java.lang.String     // Catch:{ Exception -> 0x0054 }
            java.lang.String r6 = "UTF-8"
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x0054 }
            goto L_0x004c
        L_0x004b:
            r5 = r1
        L_0x004c:
            r3.close()     // Catch:{ Exception -> 0x0050 }
            goto L_0x0059
        L_0x0050:
            r3 = move-exception
            goto L_0x0056
        L_0x0052:
            r5 = r1
            goto L_0x0059
        L_0x0054:
            r3 = move-exception
            r5 = r1
        L_0x0056:
            r3.printStackTrace()
        L_0x0059:
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0060
            r1 = r2
        L_0x0060:
            boolean r3 = r5.isEmpty()
            if (r3 != 0) goto L_0x0067
            r1 = r5
        L_0x0067:
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L_0x0089
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r8)
            java.util.UUID r8 = java.util.UUID.randomUUID()
            java.lang.String r8 = r8.toString()
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            java.lang.String r8 = a((java.lang.String) r8)
            goto L_0x008a
        L_0x0089:
            r8 = r1
        L_0x008a:
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L_0x00f1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ec }
            r1.<init>()     // Catch:{ Exception -> 0x00ec }
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00ec }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x00ec }
            r1.append(r3)     // Catch:{ Exception -> 0x00ec }
            java.lang.String r3 = "/txrtmp"
            r1.append(r3)     // Catch:{ Exception -> 0x00ec }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00ec }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00ec }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00ec }
            boolean r1 = r3.exists()     // Catch:{ Exception -> 0x00ec }
            if (r1 != 0) goto L_0x00b7
            r3.mkdir()     // Catch:{ Exception -> 0x00ec }
        L_0x00b7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ec }
            r1.<init>()     // Catch:{ Exception -> 0x00ec }
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00ec }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x00ec }
            r1.append(r3)     // Catch:{ Exception -> 0x00ec }
            r1.append(r0)     // Catch:{ Exception -> 0x00ec }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x00ec }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x00ec }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00ec }
            boolean r0 = r1.exists()     // Catch:{ Exception -> 0x00ec }
            if (r0 != 0) goto L_0x00dc
            r1.createNewFile()     // Catch:{ Exception -> 0x00ec }
        L_0x00dc:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00ec }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00ec }
            byte[] r1 = r8.getBytes()     // Catch:{ Exception -> 0x00ec }
            r0.write(r1)     // Catch:{ Exception -> 0x00ec }
            r0.close()     // Catch:{ Exception -> 0x00ec }
            goto L_0x00f0
        L_0x00ec:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00f0:
            r5 = r8
        L_0x00f1:
            boolean r0 = r2.equals(r5)
            if (r0 != 0) goto L_0x0103
            android.content.SharedPreferences$Editor r7 = r7.edit()
            java.lang.String r0 = "key_user_id"
            r7.putString(r0, r8)
            r7.commit()
        L_0x0103:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.f.a.a.a.i.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static boolean f(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    public static int g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            String typeName = activeNetworkInfo.getTypeName();
            if (typeName.equalsIgnoreCase(ConnectivityEvent.TECHNOLOGY_WIFI)) {
                return 1;
            }
            if (typeName.equalsIgnoreCase("MOBILE")) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                if (networkInfo != null && networkInfo.getType() == 0) {
                    switch (networkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 4;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 3;
                        case 13:
                            return 2;
                        default:
                            return 0;
                    }
                }
            }
        }
        return 0;
    }

    public static String h(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static String i(Context context) {
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }
}
