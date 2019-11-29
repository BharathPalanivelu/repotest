package com.tencent.liteav.basic.util;

import com.appsflyer.share.Constants;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.security.MessageDigest;

public class TXCCommonUtil {
    private static String mAppID = "";
    private static String mStrAppVersion = "";
    public static String pituLicencePath = "YTFaceSDK.licence";

    private static native int nativeGetSDKID();

    private static native String nativeGetSDKVersion();

    static {
        b.f();
    }

    public static int[] getSDKVersion() {
        String[] split = nativeGetSDKVersion().split("\\.");
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                iArr[i] = Integer.parseInt(split[i]);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                iArr[i] = 0;
            }
        }
        return iArr;
    }

    public static String getSDKVersionStr() {
        return nativeGetSDKVersion();
    }

    public static int getSDKID() {
        return nativeGetSDKID();
    }

    public static String getFileExtension(String str) {
        if (str != null && str.length() > 0) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf > -1 && lastIndexOf < str.length() - 1) {
                return str.substring(lastIndexOf + 1);
            }
        }
        return null;
    }

    public static void sleep(int i) {
        try {
            Thread.sleep((long) i);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public static String getStreamIDByStreamUrl(String str) {
        if (!(str == null || str.length() == 0)) {
            int indexOf = str.indexOf("?");
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            if (!(str == null || str.length() == 0)) {
                int lastIndexOf = str.lastIndexOf(Constants.URL_PATH_DELIMITER);
                if (lastIndexOf != -1) {
                    str = str.substring(lastIndexOf + 1);
                }
                if (!(str == null || str.length() == 0)) {
                    int indexOf2 = str.indexOf(".");
                    if (indexOf2 != -1) {
                        str = str.substring(0, indexOf2);
                    }
                    if (str == null || str.length() == 0) {
                        return null;
                    }
                    return str;
                }
            }
        }
        return null;
    }

    public static void setAppVersion(String str) {
        mStrAppVersion = str;
    }

    public static void setPituLicencePath(String str) {
        pituLicencePath = str;
    }

    public static String getAppVersion() {
        return mStrAppVersion;
    }

    public static void setAppID(String str) {
        mAppID = str;
    }

    public static String getAppID() {
        return mAppID;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getMD5(java.lang.String r5) {
        /*
            java.lang.String r0 = "MD5"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch:{ Exception -> 0x0039 }
            byte[] r1 = r5.getBytes()     // Catch:{ Exception -> 0x0039 }
            r0.update(r1)     // Catch:{ Exception -> 0x0039 }
            byte[] r0 = r0.digest()     // Catch:{ Exception -> 0x0039 }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0039 }
            java.lang.String r2 = ""
            r1.<init>(r2)     // Catch:{ Exception -> 0x0039 }
            r2 = 0
        L_0x0019:
            int r3 = r0.length     // Catch:{ Exception -> 0x0039 }
            if (r2 >= r3) goto L_0x0035
            byte r3 = r0[r2]     // Catch:{ Exception -> 0x0039 }
            if (r3 >= 0) goto L_0x0022
            int r3 = r3 + 256
        L_0x0022:
            r4 = 16
            if (r3 >= r4) goto L_0x002b
            java.lang.String r4 = "0"
            r1.append(r4)     // Catch:{ Exception -> 0x0039 }
        L_0x002b:
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ Exception -> 0x0039 }
            r1.append(r3)     // Catch:{ Exception -> 0x0039 }
            int r2 = r2 + 1
            goto L_0x0019
        L_0x0035:
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x0039 }
        L_0x0039:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.util.TXCCommonUtil.getMD5(java.lang.String):java.lang.String");
    }

    public static byte[] getMD5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_MD5);
            instance.update(bArr);
            return instance.digest();
        } catch (Exception unused) {
            return null;
        }
    }
}
