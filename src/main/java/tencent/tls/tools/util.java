package tencent.tls.tools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.appsflyer.share.Constants;
import com.tencent.qcloud.core.http.HttpMetric;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.zip.DeflaterOutputStream;
import tencent.tls.request.req_global;

public class util {
    public static final long BUILD_TIME = 1518069590;
    public static final int D = 2;
    private static SimpleDateFormat DAYFORMAT = null;
    public static final int I = 1;
    public static String LIBWT = "wtcrypto";
    public static boolean LOGCAT_OUT = true;
    private static final String LOG_DIR = "tencent/tls";
    private static int LOG_LEVEL = 1;
    static final int MAX_CONTENT_SIZE = 4096;
    private static final int MAX_FILE_SIZE = 102400;
    public static int MAX_NAME_LEN = 128;
    @SuppressLint({"NewApi"})
    private static int MODE_MULTI_PROCESS = (Build.VERSION.SDK_INT > 9 ? 4 : 0);
    public static final String SDK_VERSION = "1.1.2259";
    private static String SPFileName = "TLS_DEVICE_INFO";
    public static final int SSO_VERSION = 1;
    public static final long SVN_VER = 2259;
    public static final int S_ROLL_BACK = 180;
    private static final String TAG = "tls_sdk";
    public static final int W = 0;
    static final char[] base64_encode_chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};
    static final char base64_pad_url = '_';
    static final short[] base64_reverse_table_url = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    public static int connRetryTimes = 4;
    private static boolean libwtecdh_loaded = false;
    public static String soLoadPath = "";

    public static final class APNName {
        public static final String NAME_3GWAP = "3gwap";
        public static final String NAME_CMWAP = "cmwap";
        public static final String NAME_CTWAP = "ctwap";
        public static final String NAME_UNIWAP = "uniwap";
    }

    public static String getSdkVersion() {
        return "[1]";
    }

    public static byte get_char(byte b2) {
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

    public static String get_release_time() {
        return "2018/02/08 13:59:50";
    }

    public static byte[] get_os_type() {
        return "android".getBytes();
    }

    public static byte[] get_os_version() {
        return Build.VERSION.RELEASE.getBytes();
    }

    public static void int8_to_buf(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
    }

    public static void int16_to_buf(byte[] bArr, int i, int i2) {
        bArr[i + 1] = (byte) (i2 >> 0);
        bArr[i + 0] = (byte) (i2 >> 8);
    }

    public static void int32_to_buf(byte[] bArr, int i, int i2) {
        bArr[i + 3] = (byte) (i2 >> 0);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 0] = (byte) (i2 >> 24);
    }

    public static void int64_to_buf(byte[] bArr, int i, long j) {
        bArr[i + 7] = (byte) ((int) (j >> 0));
        bArr[i + 6] = (byte) ((int) (j >> 8));
        bArr[i + 5] = (byte) ((int) (j >> 16));
        bArr[i + 4] = (byte) ((int) (j >> 24));
        bArr[i + 3] = (byte) ((int) (j >> 32));
        bArr[i + 2] = (byte) ((int) (j >> 40));
        bArr[i + 1] = (byte) ((int) (j >> 48));
        bArr[i + 0] = (byte) ((int) (j >> 56));
    }

    public static void int64_to_buf32(byte[] bArr, int i, long j) {
        bArr[i + 3] = (byte) ((int) (j >> 0));
        bArr[i + 2] = (byte) ((int) (j >> 8));
        bArr[i + 1] = (byte) ((int) (j >> 16));
        bArr[i + 0] = (byte) ((int) (j >> 24));
    }

    public static int buf_to_int8(byte[] bArr, int i) {
        return bArr[i] & 255;
    }

    public static int buf_to_int16(byte[] bArr, int i) {
        return ((bArr[i] << 8) & 65280) + ((bArr[i + 1] << 0) & 255);
    }

    public static int buf_to_int32(byte[] bArr, int i) {
        return ((bArr[i] << 24) & -16777216) + ((bArr[i + 1] << 16) & 16711680) + ((bArr[i + 2] << 8) & 65280) + ((bArr[i + 3] << 0) & 255);
    }

    public static long buf_to_int64(byte[] bArr, int i) {
        return ((((long) bArr[i]) << 56) & -72057594037927936L) + 0 + ((((long) bArr[i + 1]) << 48) & 71776119061217280L) + ((((long) bArr[i + 2]) << 40) & 280375465082880L) + ((((long) bArr[i + 3]) << 32) & 1095216660480L) + ((((long) bArr[i + 4]) << 24) & 4278190080L) + ((((long) bArr[i + 5]) << 16) & 16711680) + ((((long) bArr[i + 6]) << 8) & 65280) + ((((long) bArr[i + 7]) << 0) & 255);
    }

    public static int get_rand_32() {
        return (int) (Math.random() * 2.147483647E9d);
    }

    public static byte[] get_rand_16byte(byte[] bArr) {
        try {
            byte[] seed = SecureRandom.getSeed(16);
            byte[] bArr2 = new byte[(seed.length + bArr.length)];
            System.arraycopy(seed, 0, bArr2, 0, seed.length);
            System.arraycopy(bArr, 0, bArr2, seed.length, bArr.length);
            return MD5.toMD5Byte(bArr2);
        } catch (Throwable unused) {
            return get_prand_16byte();
        }
    }

    public static byte[] get_prand_16byte() {
        try {
            byte[] bArr = new byte[16];
            int32_to_buf(bArr, 0, (int) (Math.random() * 2.147483647E9d));
            int32_to_buf(bArr, 4, (int) (Math.random() * 2.147483647E9d));
            int32_to_buf(bArr, 8, (int) (Math.random() * 2.147483647E9d));
            int32_to_buf(bArr, 12, (int) (Math.random() * 2.147483647E9d));
            return MD5.toMD5Byte(bArr);
        } catch (Throwable unused) {
            return new byte[16];
        }
    }

    public static String get_mpasswd() {
        try {
            byte[] seed = SecureRandom.getSeed(16);
            String str = "";
            for (byte b2 : seed) {
                int abs = Math.abs(b2 % 26) + (new Random().nextBoolean() ? 97 : 65);
                str = str + String.valueOf((char) abs);
            }
            return str;
        } catch (Throwable unused) {
            return "1234567890123456";
        }
    }

    public static byte[] getS2(byte[] bArr, long j) {
        byte[] bArr2 = new byte[24];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        int64_to_buf(bArr2, 16, j);
        return MD5.toMD5Byte(bArr2);
    }

    public static long get_server_cur_time() {
        return req_global.get_server_cur_time();
    }

    public static String buf_to_string(byte[] bArr) {
        String str = "";
        if (bArr == null) {
            return str;
        }
        for (int i = 0; i < bArr.length; i++) {
            str = (str + Integer.toHexString((bArr[i] >> 4) & 15)) + Integer.toHexString(bArr[i] & 15);
        }
        return str;
    }

    public static String buf_to_string(byte[] bArr, int i) {
        String str = "";
        if (bArr == null) {
            return str;
        }
        if (i > bArr.length) {
            i = bArr.length;
        }
        for (int i2 = 0; i2 < i; i2++) {
            str = (str + Integer.toHexString((bArr[i2] >> 4) & 15)) + Integer.toHexString(bArr[i2] & 15);
        }
        return str;
    }

    public static long buf_len(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return (long) bArr.length;
    }

    public static byte[] string_to_buf(String str) {
        if (str == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((get_char((byte) str.charAt(i2)) << 4) + get_char((byte) str.charAt(i2 + 1)));
        }
        return bArr;
    }

    public static byte[] get_mac_addr(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    String macAddress = connectionInfo.getMacAddress();
                    if (macAddress != null) {
                        return macAddress.getBytes();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return new byte[0];
    }

    public static byte[] get_imei_id(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String deviceId = telephonyManager.getDeviceId();
                if (deviceId != null) {
                    return deviceId.getBytes();
                }
            }
        } catch (Throwable unused) {
        }
        return new byte[0];
    }

    @SuppressLint({"NewApi"})
    public static byte[] get_android_id(Context context) {
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string != null) {
                return string.getBytes();
            }
        } catch (Throwable unused) {
        }
        return new byte[0];
    }

    public static byte[] get_IMSI(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String subscriberId = telephonyManager.getSubscriberId();
                if (subscriberId != null) {
                    return subscriberId.getBytes();
                }
            }
        } catch (Throwable unused) {
        }
        return new byte[0];
    }

    public static byte[] get_IMEI(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String str = null;
            String deviceId = telephonyManager != null ? telephonyManager.getDeviceId() : null;
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    str = connectionInfo.getMacAddress();
                }
            }
            String str2 = "";
            if (deviceId != null) {
                str2 = str2 + deviceId;
            }
            if (str != null) {
                str2 = str2 + str;
            }
            if (str2.length() <= 0) {
                return new byte[0];
            }
            return MD5.toMD5Byte(str2.getBytes());
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] get_sim_operator_name(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager.getSimState() == 5) {
                return telephonyManager.getSimOperatorName().getBytes();
            }
        } catch (Throwable unused) {
        }
        return new byte[0];
    }

    public static int get_network_type(Context context) {
        int i;
        try {
            i = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType();
        } catch (Throwable unused) {
            i = 0;
        }
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        return 0;
    }

    public static int get_saved_network_type(Context context) {
        try {
            return context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).getInt("network_type", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static void save_network_type(Context context, int i) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).edit();
            edit.putInt("network_type", i);
            edit.commit();
        }
    }

    public static void set_server_host(Context context, byte[] bArr, String str) {
        if (context != null && bArr != null && bArr.length > 0) {
            SharedPreferences.Editor edit = context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).edit();
            edit.putString(str, new String(bArr));
            edit.commit();
        }
    }

    public static String get_server_host(Context context, String str) {
        try {
            return context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).getString(str, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void set_net_retry_type(Context context, int i) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).edit();
            edit.putInt("netretry_type", i);
            edit.commit();
        }
    }

    public static int get_net_retry_type(Context context) {
        try {
            return context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).getInt("netretry_type", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean is_wap_retry(Context context) {
        return get_net_retry_type(context) != 0;
    }

    public static String get_apn_string(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 0) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo != null) {
                    return extraInfo;
                }
            }
        } catch (Throwable unused) {
        }
        return "wifi";
    }

    public static boolean is_wap_proxy_retry(Context context) {
        try {
            String str = get_apn_string(context);
            if (str == null) {
                return false;
            }
            if (!str.equalsIgnoreCase(APNName.NAME_CMWAP) && !str.equalsIgnoreCase(APNName.NAME_UNIWAP) && !str.equalsIgnoreCase(APNName.NAME_CTWAP) && !str.equalsIgnoreCase(APNName.NAME_3GWAP)) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void chg_retry_type(Context context) {
        if (get_net_retry_type(context) == 0) {
            set_net_retry_type(context, 1);
        } else {
            set_net_retry_type(context, 0);
        }
    }

    public static String get_proxy_ip() {
        return System.getProperty("http.proxyHost");
    }

    public static int get_proxy_port() {
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static void save_imei(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            SharedPreferences.Editor edit = context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).edit();
            edit.putString("imei", buf_to_string(bArr));
            edit.commit();
        }
    }

    public static byte[] get_saved_imei(Context context) {
        byte[] bArr = new byte[0];
        try {
            return string_to_buf(context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).getString("imei", ""));
        } catch (Throwable th) {
            printThrowable(th, "");
            return bArr;
        }
    }

    public static void save_cur_flag(Context context, int i) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).edit();
            edit.putInt("last_flag", i);
            edit.commit();
        }
    }

    public static int get_last_flag(Context context) {
        try {
            return context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).getInt("last_flag", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static void save_cur_mac(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            SharedPreferences.Editor edit = context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).edit();
            edit.putString("last_mac", buf_to_string(bArr));
            edit.commit();
        }
    }

    public static byte[] get_last_mac(Context context) {
        byte[] bArr = new byte[0];
        try {
            bArr = string_to_buf(context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).getString("last_mac", ""));
        } catch (Throwable unused) {
        }
        return (bArr == null || bArr.length <= 0) ? new byte[0] : bArr;
    }

    public static void save_cur_imei(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            SharedPreferences.Editor edit = context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).edit();
            edit.putString("last_imei", buf_to_string(bArr));
            edit.commit();
        }
    }

    public static byte[] get_last_imei(Context context) {
        byte[] bArr = new byte[0];
        try {
            bArr = string_to_buf(context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).getString("last_imei", ""));
        } catch (Throwable unused) {
        }
        return (bArr == null || bArr.length <= 0) ? new byte[0] : bArr;
    }

    public static void save_cur_guid(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            SharedPreferences.Editor edit = context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).edit();
            edit.putString("last_guid", buf_to_string(bArr));
            edit.commit();
        }
    }

    public static byte[] get_last_guid(Context context) {
        byte[] bArr = new byte[0];
        try {
            bArr = string_to_buf(context.getSharedPreferences(SPFileName, MODE_MULTI_PROCESS).getString("last_guid", ""));
        } catch (Throwable unused) {
        }
        return (bArr == null || bArr.length <= 0) ? new byte[0] : bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005f A[SYNTHETIC, Splitter:B:32:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006a A[SYNTHETIC, Splitter:B:37:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void save_file_imei(android.content.Context r5, byte[] r6) {
        /*
            java.lang.String r0 = ""
            if (r5 == 0) goto L_0x0073
            if (r6 == 0) goto L_0x0073
            int r1 = r6.length
            if (r1 <= 0) goto L_0x0073
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0059 }
            r2.<init>()     // Catch:{ Exception -> 0x0059 }
            java.io.File r3 = r5.getFilesDir()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x0059 }
            r2.append(r3)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r3 = "/tls_device.dat"
            r2.append(r3)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0059 }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0059 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0059 }
            boolean r2 = r3.exists()     // Catch:{ Exception -> 0x0059 }
            if (r2 != 0) goto L_0x0031
            r3.createNewFile()     // Catch:{ Exception -> 0x0059 }
        L_0x0031:
            boolean r2 = r3.exists()     // Catch:{ Exception -> 0x0059 }
            if (r2 == 0) goto L_0x004e
            boolean r2 = r3.canWrite()     // Catch:{ Exception -> 0x0059 }
            if (r2 == 0) goto L_0x004e
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0059 }
            r4 = 0
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0059 }
            r2.write(r6)     // Catch:{ Exception -> 0x004b, all -> 0x0048 }
            r1 = r2
            goto L_0x004e
        L_0x0048:
            r5 = move-exception
            r1 = r2
            goto L_0x0068
        L_0x004b:
            r5 = move-exception
            r1 = r2
            goto L_0x005a
        L_0x004e:
            save_imei(r5, r6)     // Catch:{ Exception -> 0x0059 }
            if (r1 == 0) goto L_0x0073
            r1.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0073
        L_0x0057:
            r5 = move-exception
            goto L_0x0068
        L_0x0059:
            r5 = move-exception
        L_0x005a:
            printException(r5, r0)     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0073
            r1.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0073
        L_0x0063:
            r5 = move-exception
            printException(r5, r0)
            goto L_0x0073
        L_0x0068:
            if (r1 == 0) goto L_0x0072
            r1.close()     // Catch:{ IOException -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r6 = move-exception
            printException(r6, r0)
        L_0x0072:
            throw r5
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tencent.tls.tools.util.save_file_imei(android.content.Context, byte[]):void");
    }

    public static byte[] get_apk_id(Context context) {
        try {
            return context.getPackageName().getBytes();
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static byte[] get_apk_v(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName.getBytes();
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static String getLineInfo(int i) {
        if (i < 0) {
            return "";
        }
        try {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i];
            return "[" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void LOGI(String str) {
        try {
            if (LOG_LEVEL >= 1 && LOGCAT_OUT) {
                Log.i("tls_sdk" + getLineInfo(2), str);
            }
        } catch (Exception unused) {
        }
    }

    public static void LOGI(String str, String str2) {
        try {
            if (LOG_LEVEL >= 1) {
                if (LOGCAT_OUT) {
                    Log.i("tls_sdk" + getLineInfo(2), str);
                }
                FileTracer.writeLog(req_global._context, str2, str);
            }
        } catch (Exception unused) {
        }
    }

    public static void LOGW(String str, String str2, String str3) {
        try {
            if (LOG_LEVEL >= 0) {
                if (LOGCAT_OUT) {
                    Log.w("tls_sdk" + getLineInfo(2), str + ":" + str2);
                }
                FileTracer.writeLog(req_global._context, str3, str + ":" + str2);
            }
        } catch (Exception unused) {
        }
    }

    public static String base64_encode(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            byte b2 = bArr[i] & 255;
            if (i2 == length) {
                stringBuffer.append(base64_encode_chars[b2 >>> 2]);
                stringBuffer.append(base64_encode_chars[(b2 & 3) << 4]);
                break;
            }
            int i3 = i2 + 1;
            byte b3 = bArr[i2] & 255;
            if (i3 == length) {
                stringBuffer.append(base64_encode_chars[b2 >>> 2]);
                stringBuffer.append(base64_encode_chars[((b2 & 3) << 4) | ((b3 & 240) >>> 4)]);
                stringBuffer.append(base64_encode_chars[(b3 & 15) << 2]);
                break;
            }
            int i4 = i3 + 1;
            byte b4 = bArr[i3] & 255;
            stringBuffer.append(base64_encode_chars[b2 >>> 2]);
            stringBuffer.append(base64_encode_chars[((b2 & 3) << 4) | ((b3 & 240) >>> 4)]);
            stringBuffer.append(base64_encode_chars[((b3 & 15) << 2) | ((b4 & 192) >>> 6)]);
            stringBuffer.append(base64_encode_chars[b4 & 63]);
            i = i4;
        }
        return stringBuffer.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [byte, short], vars: [r3v0 ?, r3v1 ?, r3v2 ?, r3v3 ?, r3v4 ?, r3v6 ?, r3v5 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public static byte[] base64_decode_url(byte[] r11, int r12) {
        /*
            r0 = 24
            byte[] r0 = new byte[r0]
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0009:
            int r6 = r12 + -1
            r7 = 95
            r8 = 3
            r9 = 2
            r10 = 1
            if (r12 <= 0) goto L_0x006b
            int r12 = r2 + 1
            byte r3 = r11[r2]
            if (r3 == 0) goto L_0x006b
            if (r3 != r7) goto L_0x001b
            goto L_0x006b
        L_0x001b:
            r2 = 32
            if (r3 != r2) goto L_0x0021
            r3 = 42
        L_0x0021:
            short[] r2 = base64_reverse_table_url
            short r3 = r2[r3]
            if (r3 >= 0) goto L_0x002a
        L_0x0027:
            r2 = r12
            r12 = r6
            goto L_0x0009
        L_0x002a:
            int r2 = r4 % 4
            if (r2 == 0) goto L_0x0063
            if (r2 == r10) goto L_0x0050
            if (r2 == r9) goto L_0x003e
            if (r2 == r8) goto L_0x0035
            goto L_0x0068
        L_0x0035:
            int r2 = r5 + 1
            byte r7 = r0[r5]
            r7 = r7 | r3
            byte r7 = (byte) r7
            r0[r5] = r7
            goto L_0x0061
        L_0x003e:
            int r2 = r5 + 1
            byte r7 = r0[r5]
            int r8 = r3 >> 2
            r7 = r7 | r8
            byte r7 = (byte) r7
            r0[r5] = r7
            r5 = r3 & 3
            int r5 = r5 << 6
            byte r5 = (byte) r5
            r0[r2] = r5
            goto L_0x0061
        L_0x0050:
            int r2 = r5 + 1
            byte r7 = r0[r5]
            int r8 = r3 >> 4
            r7 = r7 | r8
            byte r7 = (byte) r7
            r0[r5] = r7
            r5 = r3 & 15
            int r5 = r5 << 4
            byte r5 = (byte) r5
            r0[r2] = r5
        L_0x0061:
            r5 = r2
            goto L_0x0068
        L_0x0063:
            int r2 = r3 << 2
            byte r2 = (byte) r2
            r0[r5] = r2
        L_0x0068:
            int r4 = r4 + 1
            goto L_0x0027
        L_0x006b:
            if (r3 != r7) goto L_0x007f
            int r4 = r4 % 4
            if (r4 == 0) goto L_0x007d
            if (r4 == r10) goto L_0x007d
            if (r4 == r9) goto L_0x0078
            if (r4 == r8) goto L_0x007a
            goto L_0x007f
        L_0x0078:
            int r5 = r5 + 1
        L_0x007a:
            r0[r5] = r1
            goto L_0x007f
        L_0x007d:
            r11 = 0
            return r11
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tencent.tls.tools.util.base64_decode_url(byte[], int):byte[]");
    }

    public static void printException(Exception exc, String str) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        exc.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        LOGW(HttpMetric.ATTR_EXCEPTION, stringWriter.toString(), str);
    }

    public static void printThrowable(Throwable th, String str) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        th.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        LOGW("throwable", stringWriter.toString(), str);
    }

    public static byte[] getPkgSigFromApkName(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                if (packageInfo.signatures[0] != null) {
                    return MD5.toMD5Byte(packageInfo.signatures[0].toByteArray());
                }
            }
            return new byte[0];
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static String getDate() {
        try {
            return "[" + System.currentTimeMillis() + "]";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getThreadId() {
        return "[" + Thread.currentThread().getId() + "]";
    }

    public static String getUser(String str) {
        if (str == null) {
            return "[]";
        }
        return "[" + str + "]";
    }

    public static boolean ExistSDCard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String getCurrentDay() {
        try {
            if (DAYFORMAT == null) {
                DAYFORMAT = new SimpleDateFormat("yyyyMMdd");
            }
            return DAYFORMAT.format(new Date());
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isFileExist(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static int getFileSize(String str) {
        try {
            File file = new File(str);
            if (!file.exists() || !file.isFile()) {
                return 0;
            }
            return (int) file.length();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static byte[] compress(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            return new byte[0];
        }
    }

    public static String getLogFileName(Context context, String str) {
        String str2;
        if (context == null || str == null || str.length() == 0) {
            return null;
        }
        try {
            if (ExistSDCard()) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                str2 = externalStorageDirectory.getAbsolutePath() + Constants.URL_PATH_DELIMITER + LOG_DIR + Constants.URL_PATH_DELIMITER + context.getPackageName() + Constants.URL_PATH_DELIMITER + base64_encode(str.getBytes());
            } else {
                str2 = context.getFilesDir().getPath() + Constants.URL_PATH_DELIMITER + LOG_DIR + Constants.URL_PATH_DELIMITER + base64_encode(str.getBytes());
            }
            return str2;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void writeFile(java.lang.String r4, byte[] r5) {
        /*
            java.lang.Class<tencent.tls.tools.util> r0 = tencent.tls.tools.util.class
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0045
            int r1 = r4.length()     // Catch:{ all -> 0x0042 }
            if (r1 != 0) goto L_0x000c
            goto L_0x0045
        L_0x000c:
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0040 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0040 }
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x0040 }
            if (r2 != 0) goto L_0x002b
            java.io.File r2 = r1.getParentFile()     // Catch:{ Exception -> 0x0040 }
            if (r2 == 0) goto L_0x0029
            boolean r3 = r2.mkdirs()     // Catch:{ Exception -> 0x0040 }
            if (r3 != 0) goto L_0x002b
            boolean r2 = r2.isDirectory()     // Catch:{ Exception -> 0x0040 }
            if (r2 != 0) goto L_0x002b
        L_0x0029:
            monitor-exit(r0)
            return
        L_0x002b:
            int r4 = getFileSize(r4)     // Catch:{ Exception -> 0x0040 }
            r2 = 102400(0x19000, float:1.43493E-40)
            if (r4 >= r2) goto L_0x0040
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0040 }
            r2 = 1
            r4.<init>(r1, r2)     // Catch:{ Exception -> 0x0040 }
            r4.write(r5)     // Catch:{ Exception -> 0x0040 }
            r4.close()     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            monitor-exit(r0)
            return
        L_0x0042:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L_0x0045:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tencent.tls.tools.util.writeFile(java.lang.String, byte[]):void");
    }

    public static void deleteExpireFile(String str, int i) {
        if (str != null && str.length() != 0) {
            LOGI("file path:" + str);
            try {
                File file = new File(str);
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        int length = listFiles.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (!listFiles[i2].isDirectory() && (System.currentTimeMillis() - listFiles[i2].lastModified()) / 1000 > ((long) i)) {
                                listFiles[i2].delete();
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void deleteExpireLog(Context context) {
        if (context != null) {
            try {
                if (ExistSDCard()) {
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    deleteExpireFile(externalStorageDirectory.getAbsolutePath() + Constants.URL_PATH_DELIMITER + LOG_DIR + Constants.URL_PATH_DELIMITER + context.getPackageName(), 691200);
                    return;
                }
                String path = context.getFilesDir().getPath();
                deleteExpireFile(path + Constants.URL_PATH_DELIMITER + LOG_DIR, 259200);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:10|11|12|13|(2:18|19)|20|21|22|(2:27|28)|29|30|33|34) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x004c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0081 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean loadLibrary(java.lang.String r7, android.content.Context r8) {
        /*
            java.lang.String r0 = ".so"
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 0
            r3 = 23
            if (r1 < r3) goto L_0x000a
            return r2
        L_0x000a:
            boolean r1 = libwtecdh_loaded
            r3 = 1
            if (r1 == 0) goto L_0x0010
            return r3
        L_0x0010:
            if (r8 == 0) goto L_0x009f
            if (r7 == 0) goto L_0x009f
            int r1 = r7.length()
            if (r1 != 0) goto L_0x001c
            goto L_0x009f
        L_0x001c:
            r1 = 0
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x003c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003c }
            r5.<init>()     // Catch:{ Exception -> 0x003c }
            java.lang.String r6 = soLoadPath     // Catch:{ Exception -> 0x003c }
            r5.append(r6)     // Catch:{ Exception -> 0x003c }
            java.lang.String r6 = "/lib"
            r5.append(r6)     // Catch:{ Exception -> 0x003c }
            r5.append(r7)     // Catch:{ Exception -> 0x003c }
            r5.append(r0)     // Catch:{ Exception -> 0x003c }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x003c }
            r4.<init>(r5)     // Catch:{ Exception -> 0x003c }
            r1 = r4
        L_0x003c:
            if (r1 == 0) goto L_0x004c
            boolean r4 = r1.exists()
            if (r4 == 0) goto L_0x004c
            java.lang.String r4 = r1.getAbsolutePath()     // Catch:{ UnsatisfiedLinkError -> 0x004c }
            java.lang.System.load(r4)     // Catch:{ UnsatisfiedLinkError -> 0x004c }
            goto L_0x0086
        L_0x004c:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0071 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0071 }
            r5.<init>()     // Catch:{ Exception -> 0x0071 }
            java.io.File r8 = r8.getFilesDir()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r8 = r8.getParent()     // Catch:{ Exception -> 0x0071 }
            r5.append(r8)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r8 = "/lib/lib"
            r5.append(r8)     // Catch:{ Exception -> 0x0071 }
            r5.append(r7)     // Catch:{ Exception -> 0x0071 }
            r5.append(r0)     // Catch:{ Exception -> 0x0071 }
            java.lang.String r8 = r5.toString()     // Catch:{ Exception -> 0x0071 }
            r4.<init>(r8)     // Catch:{ Exception -> 0x0071 }
            r1 = r4
        L_0x0071:
            if (r1 == 0) goto L_0x0081
            boolean r8 = r1.exists()
            if (r8 == 0) goto L_0x0081
            java.lang.String r8 = r1.getAbsolutePath()     // Catch:{ UnsatisfiedLinkError -> 0x0081 }
            java.lang.System.load(r8)     // Catch:{ UnsatisfiedLinkError -> 0x0081 }
            goto L_0x0086
        L_0x0081:
            java.lang.System.loadLibrary(r7)     // Catch:{ UnsatisfiedLinkError -> 0x0085 }
            goto L_0x0086
        L_0x0085:
            r3 = 0
        L_0x0086:
            libwtecdh_loaded = r3
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "libwtcrypto loaded "
            r7.append(r8)
            boolean r8 = libwtecdh_loaded
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            tencent.tls.report.QLog.i(r7)
            return r3
        L_0x009f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: tencent.tls.tools.util.loadLibrary(java.lang.String, android.content.Context):boolean");
    }

    public static boolean checkInvalid(String str) {
        return str == null || str.length() <= 0;
    }
}
