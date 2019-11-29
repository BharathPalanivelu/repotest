package com.tencent.liteav.basic.datareport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.b;
import java.security.MessageDigest;
import java.util.UUID;

public class TXCDRApi {
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    static final int NETWORK_TYPE_2G = 4;
    static final int NETWORK_TYPE_3G = 3;
    static final int NETWORK_TYPE_4G = 2;
    static final int NETWORK_TYPE_UNKNOWN = 255;
    static final int NETWORK_TYPE_WIFI = 1;
    static boolean initRpt = false;
    private static String mAppName = "";
    private static String mDevId = "";
    private static String mDevType = "";
    private static String mDevUUID = "";
    private static String mMacAddr = "";
    private static String mNetType = "";
    private static String mSysVersion = "";

    public static native int nativeGetStatusReportInterval();

    private static native void nativeInitDataReport();

    private static native void nativeInitEventInternal(String str, int i, int i2, TXCDRExtInfo tXCDRExtInfo);

    public static native void nativeReportAVRoomEvent(int i, long j, String str, int i2, int i3, String str2, String str3);

    private static native void nativeReportDAUInterval(int i, int i2, String str);

    public static native void nativeReportEvent(String str, int i);

    public static native void nativeReportEvent40003(String str, int i, int i2, String str2, String str3);

    public static native void nativeSetCommonValue(String str, String str2);

    private static native void nativeSetEventValueInterval(String str, int i, String str2, String str3);

    private static native void nativeUninitDataReport();

    public static void InitEvent(Context context, String str, int i, int i2, TXCDRExtInfo tXCDRExtInfo) {
        setCommonInfo(context);
        if (str != null) {
            nativeInitEventInternal(str, i, i2, tXCDRExtInfo);
        }
    }

    public static void txSetEventValue(String str, int i, String str2, String str3) {
        nativeSetEventValueInterval(str, i, str2, str3);
    }

    public static void txSetEventIntValue(String str, int i, String str2, long j) {
        nativeSetEventValueInterval(str, i, str2, "" + j);
    }

    public static void txReportDAU(Context context, int i) {
        if (context != null) {
            setCommonInfo(context);
        }
        nativeReportDAUInterval(i, 0, "");
    }

    public static void txReportDAU(Context context, int i, int i2, String str) {
        if (context != null) {
            setCommonInfo(context);
        }
        nativeReportDAUInterval(i, i2, str);
    }

    public static void reportEvent40003(String str, int i, int i2, String str2, String str3) {
        nativeReportEvent40003(str, i, i2, str2, str3);
    }

    public static void reportAVRoomEvent(int i, long j, String str, int i2, int i3, String str2, String str3) {
        nativeReportAVRoomEvent(i, j, str, i2, i3, str2, str3);
    }

    public static int getStatusReportInterval() {
        return nativeGetStatusReportInterval();
    }

    public static void setCommonInfo(Context context) {
        mDevType = Build.MODEL;
        mNetType = Integer.toString(getNetworkType(context));
        if (mDevId.isEmpty()) {
            mDevId = getSimulateIDFA(context);
        }
        if (mDevUUID.isEmpty()) {
            mDevUUID = getDevUUID(context, mDevId);
        }
        String packageName = getPackageName(context);
        mAppName = getApplicationNameByPackageName(context, packageName) + ":" + packageName;
        mSysVersion = String.valueOf(Build.VERSION.SDK_INT);
        mMacAddr = getOrigMacAddr(context);
        txSetCommonInfo();
    }

    public static void txSetCommonInfo() {
        if (mDevType != null) {
            nativeSetCommonValue(a.f31358f, mDevType);
        }
        if (mNetType != null) {
            nativeSetCommonValue(a.f31359g, mNetType);
        }
        if (mDevId != null) {
            nativeSetCommonValue(a.h, mDevId);
        }
        if (mDevUUID != null) {
            nativeSetCommonValue(a.i, mDevUUID);
        }
        if (mAppName != null) {
            nativeSetCommonValue(a.j, mAppName);
        }
        if (mSysVersion != null) {
            nativeSetCommonValue(a.l, mSysVersion);
        }
        if (mMacAddr != null) {
            nativeSetCommonValue(a.m, mMacAddr);
        }
    }

    public static void txSetAppVersion(String str) {
        if (str != null) {
            nativeSetCommonValue(a.k, str);
        }
    }

    public static String txCreateToken() {
        return UUID.randomUUID().toString();
    }

    private static String byteArrayToHexString(byte[] bArr) {
        char[] cArr = new char[(bArr.length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = i + 1;
            char[] cArr2 = DIGITS_LOWER;
            cArr[i] = cArr2[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[bArr[i2] & 15];
        }
        return new String(cArr);
    }

    static {
        b.f();
        nativeInitDataReport();
    }

    public static String string2Md5(String str) {
        String str2;
        if (str == null) {
            return "";
        }
        try {
            str2 = byteArrayToHexString(MessageDigest.getInstance(Hash.ALGORITHM_MD5).digest(str.getBytes("UTF-8")));
        } catch (Exception e2) {
            e2.printStackTrace();
            str2 = "";
        }
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public static String doRead(Context context) {
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String deviceId = telephonyManager != null ? telephonyManager.getDeviceId() : str;
            if (deviceId != null) {
                str = deviceId;
            }
        } catch (Exception unused) {
        }
        TXCLog.d("rtmpsdk", "deviceinfo:" + str);
        return string2Md5(str);
    }

    public static String getOrigAndroidID(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            str = "";
        }
        return string2Md5(str);
    }

    public static String getOrigMacAddr(Context context) {
        String str;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
            str = connectionInfo != null ? connectionInfo.getMacAddress() : null;
            if (str != null) {
                try {
                    str = string2Md5(str.replaceAll(":", "").toUpperCase());
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

    public static String getSimulateIDFA(Context context) {
        return doRead(context) + ";" + getOrigMacAddr(context) + ";" + getOrigAndroidID(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0090 A[SYNTHETIC, Splitter:B:27:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDevUUID(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "/txrtmp/spuid"
            java.lang.String r1 = "com.tencent.liteav.dev_uuid"
            r2 = 0
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r1, r2)
            java.lang.String r1 = ""
            java.lang.String r2 = "com.tencent.liteav.key_dev_uuid"
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
            java.lang.String r8 = string2Md5(r8)
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.datareport.TXCDRApi.getDevUUID(android.content.Context, java.lang.String):java.lang.String");
    }

    public static int getNetworkType(Context context) {
        if (context == null) {
            return 255;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 255;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 1;
        }
        if (activeNetworkInfo.getType() != 0) {
            return 255;
        }
        switch (telephonyManager.getNetworkType()) {
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
            default:
                return 2;
        }
    }

    private static String getPackageName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getApplicationNameByPackageName(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void initCrashReport(Context context) {
        try {
            synchronized (TXCDRApi.class) {
                if (!initRpt && context != null) {
                    String sDKVersionStr = TXCCommonUtil.getSDKVersionStr();
                    if (sDKVersionStr != null) {
                        SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
                        edit.putString("8e50744bf0", sDKVersionStr);
                        edit.commit();
                        initRpt = true;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
