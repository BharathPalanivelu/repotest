package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.Proxy;
import android.net.TrafficStats;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import cn.tongdun.android.core.O0o0o0o0o;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.oox0x0x;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.ooxo0o0xxxooxo00;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.ooxoxoooxooo0xx00;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.ox000o0o;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.ox0xxoox0;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.x0000xo0x0oooooo0;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.x0ox00x0oooo0xxx;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.xo00x00xo00;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.xoo0xoo0oxo00x0o0;
import cn.tongdun.android.core.x0000xo0x0oooooo0.o0oo0xx00ooo0oox0xx0;
import cn.tongdun.android.core.xo00x00xo00.o00xxox0x0xoox;
import cn.tongdun.android.core.xo00x00xo00.oo0ooo0o00o0xo;
import cn.tongdun.android.shell.common.HelperJNI;
import cn.tongdun.android.shell.utils.BoxUtil;
import cn.tongdun.android.shell.utils.LogUtil;
import com.garena.android.gpns.utility.CONSTANT;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;

public class o0000xxooooxox00xo0o {
    public static int o00o0o0oo0oo0o000x00 = 0;
    public static final String o00xx0xx0ooooo0xx00 = o00xxox0x0xoox("796c61", 14);
    public static final String o00xxox0x0xoox = o00xxox0x0xoox("68787038", 23);
    private static final String o0oo0xx00ooo0oox0xx0 = o00xxox0x0xoox("791d6b0b760d7b473c4026512d4b77047513681569550556105601410a47164c1f43164117", 125);
    public static final String oo0ooo0o00o0xo = o00xxox0x0xoox("6c1d6f43", 115);
    private static final String[] ooxo0o0xxxooxo00 = {o00xxox0x0xoox("3730253a222b2a69696c622121242a2516171a1a1a1916252d242a33380b161f1e07455a59", 3), o00xxox0x0xoox("3765256f79316d3975135e154d174b", 86), o00xxox0x0xoox("377a257022612a23672860693e7d36656e386c257326", 73), o00xxox0x0xoox("376d2e7e77226b2e6320727b2c6f247735", 73), o00xxox0x0xoox("37332e20777e63767b5c54454d50", 23), o00xxox0x0xoox("377f2e6c77306b3c633272693a6b317c2c", 91), o00xxox0x0xoox("37622e71772d6b21632f72743f772d612a6225681e501c5b0b46", 70), o00xxox0x0xoox("3741254b790078136719610f3d5337593048380a741971433d5038152759345c2748305c6e007e027307740e4c325a35770c631b77", 114)};
    public static String ooxoxoooxooo0xx00 = null;
    public static final String x0000xo0x0oooooo0 = o00xxox0x0xoox("7f236522491450", 91);
    public static final String x0ox00x0oooo0xxx = o00xxox0x0xoox("685d701d1f2f133d0b", 50);
    public static final String xo00x00xo00 = o00xxox0x0xoox("6c336f6d005f0c4d14", 93);
    private static final String xoo0xoo0oxo00x0o0 = o00xxox0x0xoox("4657", 56);

    static String o00xxox0x0xoox() {
        return o00xxox0x0xoox(oo0ooo0o00o0xo.o00xxox0x0xoox, oo0ooo0o00o0xo.oo0ooo0o00o0xo);
    }

    static String o00xxox0x0xoox(Context context) {
        return o00xxox0x0xoox(ooxo0o0xxxooxo00.o00xxox0x0xoox(context), Integer.valueOf(ooxo0o0xxxooxo00.o00xxox0x0xoox()));
    }

    static String oo0ooo0o00o0xo() {
        int i = Build.VERSION.SDK_INT;
        String str = Build.VERSION.RELEASE;
        String str2 = Build.MODEL;
        if (str2 != null && str2.length() > 30) {
            str2 = str2.substring(0, 30);
        }
        String str3 = Build.PRODUCT;
        String str4 = Build.BRAND;
        if (str4 != null && str4.length() > 30) {
            str4 = str4.substring(0, 30);
        }
        String str5 = Build.SERIAL;
        String str6 = Build.DISPLAY;
        String str7 = Build.HOST;
        String str8 = Build.DEVICE;
        String str9 = Build.HARDWARE;
        if (str9 != null && str9.length() > 30) {
            str9 = str9.substring(0, 30);
        }
        return o00xxox0x0xoox(Integer.valueOf(i), str, str2, str3, str4, str5, str6, str7, str8, str9, Build.TAGS, Build.FINGERPRINT);
    }

    static String o00xxox0x0xoox(Context context, TelephonyManager telephonyManager) {
        if (!xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, "android.permission.READ_PHONE_STATE") && ((String) ooxo0o0xxxooxo00.o00xxox0x0xoox(context, o00xxox0x0xoox("6c423d1f251824131e3f192a0c3b", 61), (Object) "")) == "") {
            try {
                Thread.sleep(500);
                ooxo0o0xxxooxo00.o00xxox0x0xoox(context, o00xxox0x0xoox("6c7f3d222525242e1e0219170c06", 0), o00xxox0x0xoox("29", 50));
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        if (!xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, "android.permission.READ_PHONE_STATE")) {
            return null;
        }
        String deviceSoftwareVersion = telephonyManager.getDeviceSoftwareVersion();
        Map o00xxox0x0xoox2 = oo0ooo0x0o.o00xxox0x0xoox(context, telephonyManager);
        return o00xxox0x0xoox(o00xxox0x0xoox2.get(oo0ooo0x0o.oo0ooo0o00o0xo[1]), o00xxox0x0xoox2.get(oo0ooo0x0o.oo0ooo0o00o0xo[2]), o00xxox0x0xoox2.get(oo0ooo0x0o.oo0ooo0o00o0xo[3]), o00xxox0x0xoox2.get(oo0ooo0x0o.oo0ooo0o00o0xo[4]), o00xxox0x0xoox2.get(oo0ooo0x0o.oo0ooo0o00o0xo[5]), o00xxox0x0xoox2.get(oo0ooo0x0o.oo0ooo0o00o0xo[6]), o00xxox0x0xoox2.get(oo0ooo0x0o.oo0ooo0o00o0xo[7]), o00xxox0x0xoox2.get(oo0ooo0x0o.oo0ooo0o00o0xo[8]), o00xxox0x0xoox2.get(oo0ooo0x0o.oo0ooo0o00o0xo[9]), o00xxox0x0xoox2.get(oo0ooo0x0o.oo0ooo0o00o0xo[10]), o00xxox0x0xoox2.get(oo0ooo0x0o.oo0ooo0o00o0xo[11]), o00xxox0x0xoox2.get(oo0ooo0x0o.oo0ooo0o00o0xo[12]), deviceSoftwareVersion);
    }

    static String o00xxox0x0xoox(Context context, WifiManager wifiManager) {
        int i;
        String str;
        int i2;
        String str2;
        String str3;
        String str4;
        String str5 = "";
        if (!xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, "android.permission.ACCESS_WIFI_STATE") || !wifiManager.isWifiEnabled()) {
            str = str5;
            str3 = str;
            str2 = str3;
            i = 0;
            i2 = 0;
        } else {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
            String o00xxox0x0xoox2 = ox000o0o.o00xxox0x0xoox(connectionInfo.getIpAddress());
            if (xoo0xoo0oxo00x0o0.o00xxox0x0xoox(23)) {
                str4 = connectionInfo.getMacAddress();
            } else {
                str4 = xo0xo0x0oox000oxox0.o00xxox0x0xoox(o00xxox0x0xoox2);
            }
            str2 = connectionInfo.getSSID();
            String bssid = connectionInfo.getBSSID();
            i2 = dhcpInfo.gateway;
            i = dhcpInfo.netmask;
            String str6 = str4;
            str3 = bssid;
            str = o00xxox0x0xoox2;
            str5 = str6;
        }
        if (ox000o0o.o00xxox0x0xoox(str5)) {
            String o00xxox0x0xoox3 = o00xxox0x0xoox("377d2577793b7636643638773366683e73337c6d6323662370346634", 78);
            String o00xxox0x0xoox4 = o00xxox0x0xoox("37422548790476096409384833596813790f21106f156f03781578", 113);
            str5 = xo00x00xo00.o00xxox0x0xoox(o00xxox0x0xoox3);
            if (ox000o0o.o00xxox0x0xoox(str5)) {
                str5 = xo00x00xo00.o00xxox0x0xoox(o00xxox0x0xoox4);
            }
        }
        if (TextUtils.isEmpty(str5)) {
            str5 = x0000xo0x0oooooo0.o00xxox0x0xoox();
        }
        return o00xxox0x0xoox(str, str5, str2, str3, Integer.valueOf(i2), Integer.valueOf(i));
    }

    static String oo0ooo0o00o0xo(Context context) {
        String str;
        int i;
        if (xoo0xoo0oxo00x0o0.oo0ooo0o00o0xo(14)) {
            str = System.getProperty(o00xxox0x0xoox("70716875362b3436233712100e17", 2));
            String property = System.getProperty(o00xxox0x0xoox("700f680b3655344823490a761770", 124));
            if (property == null || "".equals(property)) {
                property = o00xxox0x0xoox("355b", 40);
            }
            i = Integer.parseInt(property);
        } else {
            String host = Proxy.getHost(context);
            i = Proxy.getPort(context);
            str = host;
        }
        if (ox000o0o.o00xxox0x0xoox(str)) {
            return "";
        }
        return str + o00xxox0x0xoox("22", 126) + i;
    }

    static String o00xxox0x0xoox(Context context, ConnectivityManager connectivityManager, WifiManager wifiManager) {
        return xo0xo0x0oox000oxox0.o00xxox0x0xoox(context, connectivityManager, wifiManager);
    }

    static cn.tongdun.android.core.x0000xo0x0oooooo0.ox000o0o oo0ooo0o00o0xo(Context context, WifiManager wifiManager) {
        if (!o00xxox0x0xoox.ooxoxoooxooo0xx00) {
            if (xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION")) {
                try {
                    List<ScanResult> scanResults = wifiManager.getScanResults();
                    int size = scanResults.size();
                    if (scanResults == null || size == 0) {
                        return new cn.tongdun.android.core.x0000xo0x0oooooo0.ox000o0o();
                    }
                    if (size > 10) {
                        size = 10;
                    }
                    cn.tongdun.android.core.x0000xo0x0oooooo0.ox000o0o ox000o0o = new cn.tongdun.android.core.x0000xo0x0oooooo0.ox000o0o();
                    for (int i = 0; i < size; i++) {
                        ox000o0o.o00xxox0x0xoox(scanResults.get(i).BSSID, scanResults.get(i).SSID, scanResults.get(i).level);
                    }
                    return ox000o0o;
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    static String o00xx0xx0ooooo0xx00(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        Map o00xxox0x0xoox2 = xo0xo0x0oox000oxox0.o00xxox0x0xoox(context, o00xxox0x0xoox, oo0ooo0o00o0xo);
        String str5 = "";
        if (o00xxox0x0xoox2 == null || o00xxox0x0xoox2.isEmpty()) {
            str2 = str5;
            str = str2;
        } else {
            str2 = (String) o00xxox0x0xoox2.get(o00xxox0x0xoox);
            str = (String) o00xxox0x0xoox2.get(oo0ooo0o00o0xo);
        }
        if (str2 == null && str == null) {
            str3 = str5;
        } else {
            if (ox000o0o.o00xxox0x0xoox(str2)) {
                str2 = str5;
            }
            if (ox000o0o.o00xxox0x0xoox(str2)) {
                if (ox000o0o.o00xxox0x0xoox(str)) {
                    str = str5;
                }
                str3 = str;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                if (ox000o0o.o00xxox0x0xoox(str)) {
                    str4 = str5;
                } else {
                    str4 = o00xxox0x0xoox("34", 47) + str;
                }
                sb.append(str4);
                str3 = sb.toString();
            }
        }
        if (!ox000o0o.o00xxox0x0xoox(str3)) {
            String str6 = (String) o00xxox0x0xoox2.get(x0ox00x0oooo0xxx);
            String str7 = (String) o00xxox0x0xoox2.get(xo00x00xo00);
            if (ox000o0o.o00xxox0x0xoox(str6)) {
                str6 = str5;
            }
            if (ox000o0o.o00xxox0x0xoox(str7)) {
                str7 = str5;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str6);
            if (ox000o0o.o00xxox0x0xoox(str6)) {
                str5 = str7;
            } else if (!ox000o0o.o00xxox0x0xoox(str7)) {
                str5 = o00xxox0x0xoox("34", 64) + str7;
            }
            sb2.append(str5);
            str5 = sb2.toString();
        }
        return o00xxox0x0xoox(str3, str5);
    }

    static String x0000xo0x0oooooo0(Context context) {
        Map o00xxox0x0xoox2 = xo0xo0x0oox000oxox0.o00xxox0x0xoox(context, o00xx0xx0ooooo0xx00);
        return (o00xxox0x0xoox2 == null || o00xxox0x0xoox2.isEmpty()) ? "" : (String) o00xxox0x0xoox2.get(o00xx0xx0ooooo0xx00);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String o00xxox0x0xoox(android.content.Context r5, android.net.ConnectivityManager r6) {
        /*
            android.net.NetworkInfo r6 = r6.getActiveNetworkInfo()
            r0 = 1
            r1 = 0
            java.lang.String r2 = ""
            if (r6 == 0) goto L_0x0064
            int r3 = r6.getType()
            if (r3 != 0) goto L_0x005f
            java.lang.String[] r3 = new java.lang.String[r0]
            java.lang.String r4 = x0000xo0x0oooooo0
            r3[r1] = r4
            java.util.Map r5 = cn.tongdun.android.core.oo0ooo0o00o0xo.xo0xo0x0oox000oxox0.o00xxox0x0xoox((android.content.Context) r5, (java.lang.String[]) r3)
            if (r5 == 0) goto L_0x002b
            boolean r3 = r5.isEmpty()
            if (r3 != 0) goto L_0x002b
            java.lang.String r2 = x0000xo0x0oooooo0
            java.lang.Object r5 = r5.get(r2)
            r2 = r5
            java.lang.String r2 = (java.lang.String) r2
        L_0x002b:
            int r5 = r6.getSubtype()
            switch(r5) {
                case 1: goto L_0x0056;
                case 2: goto L_0x0056;
                case 3: goto L_0x004d;
                case 4: goto L_0x0056;
                case 5: goto L_0x004d;
                case 6: goto L_0x004d;
                case 7: goto L_0x004d;
                case 8: goto L_0x004d;
                case 9: goto L_0x004d;
                case 10: goto L_0x004d;
                case 11: goto L_0x0056;
                case 12: goto L_0x004d;
                case 13: goto L_0x0044;
                case 14: goto L_0x004d;
                case 15: goto L_0x004d;
                case 16: goto L_0x0056;
                case 17: goto L_0x0056;
                case 18: goto L_0x003b;
                default: goto L_0x0032;
            }
        L_0x0032:
            r5 = 69
            java.lang.String r6 = "4d315034512c48"
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r6, (int) r5)
            goto L_0x0065
        L_0x003b:
            r5 = 60
            java.lang.String r6 = "514d52405d"
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r6, (int) r5)
            goto L_0x0065
        L_0x0044:
            r5 = 109(0x6d, float:1.53E-43)
            java.lang.String r6 = "2c71"
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r6, (int) r5)
            goto L_0x0065
        L_0x004d:
            r5 = 16
            java.lang.String r6 = "2b0b"
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r6, (int) r5)
            goto L_0x0065
        L_0x0056:
            r5 = 37
            java.lang.String r6 = "2a3f"
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r6, (int) r5)
            goto L_0x0065
        L_0x005f:
            java.lang.String r5 = r6.getTypeName()
            goto L_0x0065
        L_0x0064:
            r5 = r2
        L_0x0065:
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r1] = r2
            r6[r0] = r5
            java.lang.String r5 = o00xxox0x0xoox((java.lang.Object[]) r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.tongdun.android.core.oo0ooo0o00o0xo.o0000xxooooxox00xo0o.o00xxox0x0xoox(android.content.Context, android.net.ConnectivityManager):java.lang.String");
    }

    static String o00xx0xx0ooooo0xx00() {
        return o00xxox0x0xoox(Long.valueOf(System.currentTimeMillis()), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(SystemClock.uptimeMillis()));
    }

    static boolean x0000xo0x0oooooo0() {
        String[] strArr = {o00xxox0x0xoox("376829", 91), o00xxox0x0xoox("37092953645863193f1f", 58), o00xxox0x0xoox("374a3e4139006506", 121), o00xxox0x0xoox("377f2a6a3f247c2770257d662a7c217b602766", 91), o00xxox0x0xoox("37292a3c3f727c7170737d30303b377a6b7c", 13), o00xxox0x0xoox("37202a353f7b7c78707a7d39213f", 4), o00xxox0x0xoox("3728252222332a717d6b766c373031", 27), o00xxox0x0xoox("3774257e226f2a2d672660673c61", 71), o00xxox0x0xoox("3744254e225f2a1d760a3d5d275620177c11", 119), o00xxox0x0xoox("3761256b227a2a3867336072297521703e623961733d75", 82)};
        for (String file : strArr) {
            File file2 = new File(file);
            if (file2.exists() && !file2.isDirectory() && file2.canExecute()) {
                return true;
            }
        }
        return false;
    }

    static String x0ox00x0oooo0xxx(Context context) {
        String[] strArr = {o00xxox0x0xoox("7b49610a2e062a4160507a4c7c49684c7d5d6a01311d", 42), o00xxox0x0xoox("7b7361302e3c2a7b68767c6d7166746e656878", 16), o00xxox0x0xoox("7b0361402e4c2a0b7701600c671d7d017d176a137519730f", 96), o00xxox0x0xoox("7b2b61682d663476227137733f6b622d652f6d", 72), o00xxox0x0xoox("7b7c613f2d313421222637243f3c62657c6276696e6d7b627e6b766779687f6a68", 31), o00xxox0x0xoox("7b4261012d0f341f2218371a3f02625f744e7453735a67", 33), o00xxox0x0xoox("7b4361002d0e341e2219371b3f03624f6c567c407b55795d6142624e605b7d5d7c437e5e67416a407d", 32), o00xxox0x0xoox("7b7c613f2d313421222637243f3c62737373706561657c627576", 31), o00xxox0x0xoox("7b3361702d7e346e2269376b3f73623f733861316239632e", 80), o00xxox0x0xoox("7b4561062d083418221f371d3f056269536e644266426a4d607942644e625862447f", 38), o00xxox0x0xoox("7b78613b2d353425222237203f3862652327", 27), o00xxox0x0xoox("7b6a61292d273437223037323f2a627774667563", 9), o00xxox0x0xoox("7b09614a24402a5f2f1a2f1b30412d4922533f5b30462651224235", 106), o00xxox0x0xoox("7b3f617c24672e6e73287e2162347525732e693f7e", 92), o00xxox0x0xoox("7b39617a24702a6f2f2a2f2b30712d7922633f6b306c3464", 90), o00xxox0x0xoox("7b1b61582e5724413947340d7e0c6d1f641c7b01730a69214537543749304024", 120), o00xxox0x0xoox("7b5c611f2e1024063900344a7e4b6d58645b7b46734d69", 63), o00xxox0x0xoox("7b3461772e78246e3968342279347f33643165326930643933", 87), o00xxox0x0xoox("7b3d617e2a63336f2e732738683762217f27726d3d7c2466", 94), o00xxox0x0xoox("7b6261212823233437362c2b2a2a6a776c7279657e636874", 1), o00xxox0x0xoox("7b6561262824233337312c2c2a2d6a6065657c777179626f766d6b7a6a", 6), o00xxox0x0xoox("7b1361503a46771077127e4f3b41275a2a543942", 112), o00xxox0x0xoox("7b5761143a02775477567e", 52), o00xxox0x0xoox("7b4461072d0934197f5f624b6d423b44220b24092f13", 39), o00xxox0x0xoox("7b49610a2d0434147f5262466d4f3b49220b2f1f34123f1f28", 42), o00xxox0x0xoox("7b5d611e2d1034007f4662526d5b3b5d221a2612", 62), o00xxox0x0xoox("7b7c613f223b282a35332a282c726560796d78", 31), o00xxox0x0xoox("7b03614022442855354c2a572c0d6f017c187209", 96), o00xxox0x0xoox("7b7761342230282135382a232c796f7167697b6d73", 20), o00xxox0x0xoox("7b1423533e483e4b2116790d3a4f375b2c56275b30", 118), o00xxox0x0xoox("7b5723103e0b3e082155794e3a10380d2f0c", 53), o00xxox0x0xoox("7b1c235b3e403e43211e79053a582651344e3a52215f2f4c39", 126), o00xxox0x0xoox("7b1223553e4e3e4d21106e077c0e701d691378", 112), o00xxox0x0xoox("7b7561363c3c217646724e", 22), o00xxox0x0xoox("7b2261612d6a23632274743b653b3b663c7d216a6a2c66", 65), o00xxox0x0xoox("7b6b61282d23232a223d747f796b6266696b7e", 8), o00xxox0x0xoox("7b5661152d1e23172200744f654f3b112316221d", 53), o00xxox0x0xoox("7b6c612f2d24232d223a747565753b353a2231342630393a3f", 15), o00xxox0x0xoox("7b39617a2e7524633965342f742e632666207d", 90), o00xxox0x0xoox("7b79613a27332f372321352e757070766b", 26), o00xxox0x0xoox("754e26082f002b0c644a69437550735b694a7e", 41), o00xxox0x0xoox("7539267f2f772b7b64346b3e7d237b2e7e3c7e266421", 94), o00xxox0x0xoox("7b0d614e38503f5a29473f107d1d6906640d691a", 110), o00xxox0x0xoox("7b266165387b3f71296c3f3b623d6728702f763961", 69), o00xxox0x0xoox("7b236160387e3f7429693f3e7d33692864236934", 64), o00xxox0x0xoox("7b476104381a3f10290d3f5a785e70", 36), o00xxox0x0xoox("7b7f613c2e33242539233469736e697f7e63716e33243e3e3d22303a677771766a6c6b36203e3827353228342974627c7a397b", 28), o00xxox0x0xoox("7b3a61792e7624603966342c7f24673d6a2871352d68336a37642675307237", 89), o00xxox0x0xoox("7b58611b2819230e370c2c112a106a5968527f4f", 59), o00xxox0x0xoox("7b0c614f24452a5a2f1f2f1e30442d4c22563f5e30593451", 111), o00xxox0x0xoox("7b0d614e3b53335c2941214e61096501", 110), o00xxox0x0xoox("7b7a613922213a39617b6c6f77627c6f6b", 25), o00xxox0x0xoox("7274687c736d7e2f31203b3626302b203a3725", 16), o00xxox0x0xoox("754026022f5f3910361a2007260a231823023905", 39), o00xxox0x0xoox("7b466105371e2402291a7e4c65436857735a78576f", 37), o00xxox0x0xoox("7b5161122e1d241d2f17394a7b476f5c62576f40", 50), o00xxox0x0xoox("771a7a533346244231502557394a63056c0f71583e493e543c553b482055", 104), o00xxox0x0xoox("77217a68337d2479316b256c3971633e6c34716336673e", 83)};
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        for (int i = 0; i < strArr.length; i++) {
            try {
                packageManager.getInstallerPackageName(strArr[i]);
                arrayList.add(Integer.valueOf(i));
            } catch (IllegalArgumentException unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return "";
        }
        if (arrayList.size() <= 10) {
            return arrayList.toString();
        }
        o00o0o0oo0oo0o000x00 |= 1;
        return "";
    }

    static String xo00x00xo00(Context context) {
        return context.getFilesDir().getAbsolutePath();
    }

    static int ooxoxoooxooo0xx00(Context context) {
        int o00xx0xx0ooooo0xx002 = xo0xo0x0oox000oxox0.o00xx0xx0ooooo0xx00();
        if ((o00o0o0oo0oo0o000x00 & 1) == 1) {
            return o00xx0xx0ooooo0xx002 | 0;
        }
        int x0000xo0x0oooooo02 = xo0xo0x0oox000oxox0.x0000xo0x0oooooo0(context);
        return x0000xo0x0oooooo02 | 0 | xo0xo0x0oox000oxox0.o00xxox0x0xoox() | xo0xo0x0oox000oxox0.oo0ooo0o00o0xo() | o00xx0xx0ooooo0xx002;
    }

    static String x0ox00x0oooo0xxx() {
        return O0o0o0o0o.o0o0oO;
    }

    static String xo00x00xo00() {
        return O0o0o0o0o.o0o0ooOo0;
    }

    static String ooxoxoooxooo0xx00() {
        return O0o0o0o0o.o0o0oO0;
    }

    static String o00o0o0oo0oo0o000x00() {
        HelperJNI.exprot(5, 1);
        return O0o0o0o0o.o0o0oooo;
    }

    static String xoo0xoo0oxo00x0o0() {
        HelperJNI.exprot(6, 1);
        return O0o0o0o0o.o0ooo;
    }

    static String o0oo0xx00ooo0oox0xx0() throws Throwable {
        String str;
        Field field;
        boolean z;
        Method method;
        Class<?> cls;
        Object[] objArr;
        try {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(o00xxox0x0xoox("7c5e2f02320f26576958634e7e487302250a3a162c1766614e7e5268534e63556e566c", 48));
            Field[] declaredFields = loadClass.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    field = null;
                    break;
                }
                Field field2 = declaredFields[i];
                if (o00xxox0x0xoox("6b5a545a5054517d796c656b6e4c4c414c4f4f4d4755", 14).equals(field2.getName())) {
                    field = loadClass.getDeclaredField(o00xxox0x0xoox("6b0c540c5002512b793a653d6e1a4c174c194f1b4703", 88));
                    break;
                } else if (o00xxox0x0xoox("702f682b662a4f025e1e59157e3773377d347f3c67", 71).equals(field2.getName())) {
                    field = loadClass.getDeclaredField(o00xxox0x0xoox("7040684466454f6d5e71597a7e5873587d5b7f5367", 40));
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            z = false;
            if (field != null) {
                field.setAccessible(true);
            }
            Map map = (Map) field.get((Object) null);
            if (!z) {
                cls = ClassLoader.getSystemClassLoader().loadClass(o00xxox0x0xoox("7c172f4b3246261e691163077e01734b25433a5f2c5e66284e3752215307631c6e1f6c5e0b72147b225a1b7f006211542d492b582a6f1c7e", 121));
                method = cls.getDeclaredMethod(o00xxox0x0xoox("7f4e76694b665a6541625a", 35), new Class[0]);
            } else {
                cls = null;
                method = null;
            }
            o0oo0xx00ooo0oox0xx0 o0oo0xx00ooo0oox0xx02 = new o0oo0xx00ooo0oox0xx0();
            o0oo0xx00ooo0oox0xx02.o00xxox0x0xoox();
            for (Map.Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                int o00xxox0x0xoox2 = o0oo0xx00ooo0oox0xx0.o00xxox0x0xoox(((Member) entry.getKey()).toString());
                if (o00xxox0x0xoox2 != -1) {
                    if (cls == null || !cls.isInstance(value)) {
                        objArr = TreeSet.class.isInstance(value) ? ((TreeSet) value).toArray() : null;
                    } else {
                        objArr = (Object[]) method.invoke(value, new Object[0]);
                    }
                    for (Object obj : objArr) {
                        obj.getClass().getName();
                        String obj2 = obj.getClass().getClassLoader().toString();
                        String str2 = "\"";
                        if (obj2.split(str2).length > 1) {
                            String str3 = obj2.split(str2)[1];
                            String str4 = str3.split(o00xxox0x0xoox("37", 33))[str3.split(o00xxox0x0xoox("37", 51)).length - 1];
                            o0oo0xx00ooo0oox0xx02.o00xxox0x0xoox(str3, o00xxox0x0xoox2);
                        }
                    }
                }
            }
            str = o0oo0xx00ooo0oox0xx02.toString();
        } catch (Exception unused) {
            str = "";
        }
        if (str == null || "".equals(str)) {
            o0oo0xx00ooo0oox0xx0.oo0ooo0o00o0xo();
        }
        return str;
    }

    static String o00o0o0oo0oo0o000x00(Context context) {
        return o00xxox0x0xoox(xo0xo0x0oox000oxox0.o00xxox0x0xoox(context), xo0xo0x0oox000oxox0.oo0ooo0o00o0xo(context), xo0xo0x0oox000oxox0.o00xx0xx0ooooo0xx00(context));
    }

    static Integer ooxo0o0xxxooxo00() {
        HelperJNI.exprot(8, 0);
        int parseInt = O0o0o0o0o.oooo0ooo != null ? Integer.parseInt(O0o0o0o0o.oooo0ooo) : 0;
        if (Debug.isDebuggerConnected()) {
            parseInt |= 32;
        }
        if (o00xxox0x0xoox.o00o0o0oo0oo0o000x00 && parseInt != 0) {
            HelperJNI.exprot(9, 0);
            int myPid = Process.myPid();
            LogUtil.err(o00xxox0x0xoox("5c0443135113530462286328682e7f3f7e7b7e307c357c792c7b317737613749", 74) + myPid + o00xxox0x0xoox("45", 53));
            Process.killProcess(myPid);
            System.exit(0);
        }
        return Integer.valueOf(parseInt);
    }

    static String xoo0xoo0oxo00x0o0(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter(o0oo0xx00ooo0oox0xx0));
        int intExtra = registerReceiver.getIntExtra(o00xxox0x0xoox("6b29663c673a", 65), 0);
        int intExtra2 = registerReceiver.getIntExtra(o00xxox0x0xoox("74567f4576", 48), 0);
        int intExtra3 = registerReceiver.getIntExtra(o00xxox0x0xoox("6c1b7c0669117a047b036c", 101), 0);
        String o00xxox0x0xoox2 = o00xxox0x0xoox("6d727077716f68", 6);
        if (intExtra == 1) {
            o00xxox0x0xoox2 = o00xxox0x0xoox("6d69706c717468", 29);
        } else if (intExtra == 2) {
            o00xxox0x0xoox2 = o00xxox0x0xoox("7b286a3b7f35783c", 76);
        } else if (intExtra == 3) {
            o00xxox0x0xoox2 = o00xxox0x0xoox("7c0e7e1e75176602680561", 108);
        } else if (intExtra == 4) {
            o00xxox0x0xoox2 = o00xxox0x0xoox("764d751936123f012a0f2d06", 35);
        } else if (intExtra == 5) {
            o00xxox0x0xoox2 = o00xxox0x0xoox("7e787f78", 4);
        }
        return o00xxox0x0xoox(Integer.valueOf(intExtra2), o00xxox0x0xoox2, Integer.valueOf(intExtra3));
    }

    static String o0oo0xx00ooo0oox0xx0(Context context) {
        String str;
        int i;
        TimeZone timeZone = TimeZone.getDefault();
        if (timeZone != null) {
            int rawOffset = timeZone.getRawOffset() / CONSTANT.TIME.MIN_1;
            str = o00xxox0x0xoox("7c7e634e4e414e1a", 6) + (timeZone.getDSTSavings() / CONSTANT.TIME.MIN_1) + o00xxox0x0xoox("3421262a0f030f16190750", 5) + rawOffset;
        } else {
            str = "";
        }
        String language = Locale.getDefault().getLanguage();
        try {
            i = Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException unused) {
            i = 0;
        }
        if (i < 0) {
            i = -1;
        } else if (i > 255) {
            i = 256;
        }
        return o00xxox0x0xoox(str, language, Integer.valueOf(i));
    }

    static String o00xxox0x0xoox(Context context, SensorManager sensorManager, WindowManager windowManager) {
        StringBuilder sb = new StringBuilder();
        new Date().getTime();
        for (Sensor next : sensorManager.getSensorList(-1)) {
            if (sb.length() > 0) {
                sb.append(o00xxox0x0xoox("34", 21));
            }
            sb.append(String.valueOf(next.getType()));
        }
        String sb2 = sb.toString();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        String str = null;
        Resources resources = context.getResources();
        if (o00xxox0x0xoox(context, defaultDisplay)) {
            int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier(o00xxox0x0xoox("765c7943774562586459556456777b40764c784364", 60), o00xxox0x0xoox("7c2d60256b", 79), o00xxox0x0xoox("79246b3276347b", 68)));
            if (dimensionPixelSize > 0) {
                str = defaultDisplay.getWidth() + o00xxox0x0xoox("60", 118) + (defaultDisplay.getHeight() + dimensionPixelSize);
            }
        } else {
            str = defaultDisplay.getWidth() + o00xxox0x0xoox("60", 94) + defaultDisplay.getHeight();
        }
        return o00xxox0x0xoox(sb2, str, xo0xo0x0oox000oxox0.x0000xo0x0oooooo0(), xo0xo0x0oox000oxox0.x0ox00x0oooo0xxx(context), Settings.Secure.getString(context.getContentResolver(), "android_id"), xo0xo0x0oox000oxox0.x0ox00x0oooo0xxx(), xo00x00xo00.o00xxox0x0xoox(o00xxox0x0xoox("37702d6d212178326f33753574", 64)));
    }

    public static boolean o00xxox0x0xoox(Context context, Display display) {
        if (Build.VERSION.SDK_INT >= 17) {
            Point point = new Point();
            Point point2 = new Point();
            display.getSize(point);
            display.getRealSize(point2);
            if (point2.y != point.y) {
                return true;
            }
            return false;
        }
        return !ViewConfiguration.get(context).hasPermanentMenuKey() && !KeyCharacterMap.deviceHasKey(4);
    }

    static String ox000o0o() {
        String[] strArr = {o00xxox0x0xoox("48724d7e4b684b7456", 63), o00xxox0x0xoox("50695b7f48695b7e", 47)};
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, strArr);
        Map o00xxox0x0xoox2 = xo00x00xo00.o00xxox0x0xoox(o00xxox0x0xoox("377a2d67212b6d3868246f2c66", 74), arrayList, o00xxox0x0xoox("22", 86));
        String o00xxox0x0xoox3 = xo00x00xo00.o00xxox0x0xoox(o00xxox0x0xoox("3743254979027811671b610d3d51375b304a3808741b71413d523817275b345e274a305e6e127d1761106919592b5532720b661c72", 112));
        if (o00xxox0x0xoox2.isEmpty() || o00xxox0x0xoox2.size() != 2) {
            return o00xxox0x0xoox(o00xxox0x0xoox3, null, null);
        }
        return o00xxox0x0xoox(o00xxox0x0xoox3, o00xxox0x0xoox2.get(strArr[0]), o00xxox0x0xoox2.get(strArr[1]));
    }

    static String o00xxox0x0xoox(Context context, ActivityManager activityManager) {
        long j;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j2 = memoryInfo.availMem;
        if (xoo0xoo0oxo00x0o0.oo0ooo0o00o0xo(16)) {
            j = memoryInfo.totalMem;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(o00xxox0x0xoox("5546457f7e646b69", 1));
            Map o00xxox0x0xoox2 = xo00x00xo00.o00xxox0x0xoox(o00xxox0x0xoox("37582d45210963016b056c0d65", 104), arrayList, o00xxox0x0xoox("22", 85));
            j = !o00xxox0x0xoox2.isEmpty() ? (o00xxox0x0xoox2.get("MemTotal") == null || "".equals(o00xxox0x0xoox2.get("MemTotal"))) ? -1 : Long.parseLong(((String) o00xxox0x0xoox2.get("MemTotal")).replaceAll("\\D+", "")) * IjkMediaMeta.AV_CH_SIDE_RIGHT : 0;
        }
        return o00xxox0x0xoox(Long.valueOf(j), Long.valueOf(j2));
    }

    static String ox0xxoox0() {
        long j;
        long j2;
        long j3;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (xoo0xoo0oxo00x0o0.o00xxox0x0xoox(18)) {
            j2 = (long) statFs.getBlockSize();
            j = (long) statFs.getAvailableBlocks();
            j3 = (long) statFs.getBlockCount();
        } else {
            j2 = statFs.getBlockSizeLong();
            j = statFs.getAvailableBlocksLong();
            j3 = statFs.getBlockCountLong();
        }
        return o00xxox0x0xoox(Long.valueOf(j3 * j2), Long.valueOf(j * j2));
    }

    private static String o00xxox0x0xoox(Object... objArr) {
        Object obj;
        int length = objArr.length;
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (objArr[i] == null) {
                obj = "";
            } else {
                obj = objArr[i];
            }
            if (i == 0) {
                sb.append(obj);
            } else {
                sb.append(xoo0xoo0oxo00x0o0);
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    public static String ooxo0o0xxxooxo00(Context context) {
        return oox0x0x.o00xxox0x0xoox().o00xxox0x0xoox(context.getPackageManager());
    }

    static String o00xxox0x0xoox(Context context, LocationManager locationManager) {
        Context context2 = context;
        LocationManager locationManager2 = locationManager;
        if (!o00xxox0x0xoox.ooxoxoooxooo0xx00) {
            xx0x000xxx0o0xox0ooxx[] xx0x000xxx0o0xox0ooxxArr = {new xx0x000xxx0o0xox0ooxx((xxx00xo0xoxxooxo) null), new xx0x000xxx0o0xox0ooxx((xxx00xo0xoxxooxo) null)};
            Looper.prepare();
            if (xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context2, "android.permission.ACCESS_FINE_LOCATION")) {
                List<String> allProviders = locationManager.getAllProviders();
                if (allProviders != null) {
                    if (allProviders.contains("gps")) {
                        locationManager.requestLocationUpdates("gps", 1000, 1000.0f, xx0x000xxx0o0xox0ooxxArr[0]);
                    }
                    if (allProviders.contains("network")) {
                        locationManager.requestLocationUpdates("network", 1000, 1.0f, xx0x000xxx0o0xox0ooxxArr[1]);
                    }
                }
            }
            if (xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context2, "android.permission.ACCESS_FINE_LOCATION")) {
                JSONObject jSONObject = new JSONObject();
                if (locationManager2.isProviderEnabled("gps")) {
                    Location lastKnownLocation = locationManager2.getLastKnownLocation("gps");
                    if (lastKnownLocation != null) {
                        try {
                            jSONObject.put(o00xxox0x0xoox("6c227d37", 64), o00xxox0x0xoox("7f6e64", 22));
                            jSONObject.put(o00xxox0x0xoox("740179", 99), lastKnownLocation.getLatitude());
                            jSONObject.put(o00xxox0x0xoox("744f6d46", 35), lastKnownLocation.getLongitude());
                            jSONObject.put(o00xxox0x0xoox("791a61", 119), (double) lastKnownLocation.getAccuracy());
                        } catch (JSONException unused) {
                        }
                    }
                }
                if (jSONObject.length() == 0 && locationManager2.isProviderEnabled("network")) {
                    Location lastKnownLocation2 = locationManager2.getLastKnownLocation("network");
                    if (lastKnownLocation2 != null) {
                        try {
                            jSONObject.put(o00xxox0x0xoox("6c507d45", 50), o00xxox0x0xoox("76487f4b67567e", 44));
                            jSONObject.put(o00xxox0x0xoox("746f79", 13), lastKnownLocation2.getLatitude());
                            jSONObject.put(o00xxox0x0xoox("74786d71", 20), lastKnownLocation2.getLongitude());
                            jSONObject.put(o00xxox0x0xoox("794461", 41), (double) lastKnownLocation2.getAccuracy());
                        } catch (JSONException unused2) {
                        }
                    }
                }
                if (jSONObject.length() == 0 && locationManager2.isProviderEnabled("passive")) {
                    Location lastKnownLocation3 = locationManager2.getLastKnownLocation("passive");
                    if (lastKnownLocation3 != null) {
                        try {
                            jSONObject.put(o00xxox0x0xoox("6c7e7d6b", 28), o00xxox0x0xoox("6876627678696b", 8));
                            jSONObject.put(o00xxox0x0xoox("741579", 119), lastKnownLocation3.getLatitude());
                            jSONObject.put(o00xxox0x0xoox("74066d0f", 106), lastKnownLocation3.getLongitude());
                            jSONObject.put(o00xxox0x0xoox("795361", 62), (double) lastKnownLocation3.getAccuracy());
                        } catch (JSONException unused3) {
                        }
                    }
                }
                locationManager2.removeUpdates(xx0x000xxx0o0xox0ooxxArr[0]);
                locationManager2.removeUpdates(xx0x000xxx0o0xox0ooxxArr[1]);
                if (jSONObject.length() == 0) {
                    return "";
                }
                return jSONObject.toString();
            }
        }
        return "";
    }

    static String ox000o0o(Context context) {
        return xo0xo0x0oox000oxox0.xo00x00xo00(context);
    }

    static String oox0x0x() {
        Object obj;
        Object obj2;
        String str = "";
        int i = 0;
        while (true) {
            String[] strArr = ooxo0o0xxxooxo00;
            if (i >= strArr.length) {
                return str;
            }
            if (new File(strArr[i]).exists()) {
                if (i != 7) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (str.length() > 0) {
                        obj2 = o00xxox0x0xoox("34", 41) + i;
                    } else {
                        obj2 = Integer.valueOf(i);
                    }
                    sb.append(obj2);
                    str = sb.toString();
                }
            } else if (i == 7) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                if (str.length() > 0) {
                    obj = o00xxox0x0xoox("34", 40) + i;
                } else {
                    obj = Integer.valueOf(i);
                }
                sb2.append(obj);
                str = sb2.toString();
            }
            i++;
        }
    }

    static Boolean ox0xxoox0(Context context) {
        boolean z = false;
        if (Settings.Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return r4.substring(0, r4.length() - 1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String x0xx00ooxx0oo000xxo() {
        /*
            java.lang.String r0 = ""
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00a7 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r3 = "374b2d56211a6011714a3f593d"
            r4 = 123(0x7b, float:1.72E-43)
            java.lang.String r3 = o00xxox0x0xoox((java.lang.String) r3, (int) r4)     // Catch:{ Exception -> 0x00a7 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00a7 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00a7 }
            r2 = 0
            r4 = r0
            r3 = 0
        L_0x0017:
            java.lang.String r5 = r1.readLine()     // Catch:{ Exception -> 0x00a7 }
            if (r5 == 0) goto L_0x009a
            java.lang.String r5 = r5.trim()     // Catch:{ Exception -> 0x0017 }
            int r6 = r5.length()     // Catch:{ Exception -> 0x0017 }
            r7 = 63
            if (r6 >= r7) goto L_0x002a
            goto L_0x0017
        L_0x002a:
            java.util.Locale r6 = java.util.Locale.US     // Catch:{ Exception -> 0x0017 }
            java.lang.String r6 = r5.toUpperCase(r6)     // Catch:{ Exception -> 0x0017 }
            java.lang.String r8 = "5107"
            r9 = 113(0x71, float:1.58E-43)
            java.lang.String r8 = o00xxox0x0xoox((java.lang.String) r8, (int) r9)     // Catch:{ Exception -> 0x0017 }
            boolean r6 = r6.contains(r8)     // Catch:{ Exception -> 0x0017 }
            if (r6 == 0) goto L_0x003f
            goto L_0x0017
        L_0x003f:
            r6 = 17
            java.lang.String r6 = r5.substring(r2, r6)     // Catch:{ Exception -> 0x0017 }
            java.lang.String r6 = r6.trim()     // Catch:{ Exception -> 0x0017 }
            r8 = 29
            r9 = 32
            java.lang.String r8 = r5.substring(r8, r9)     // Catch:{ Exception -> 0x0017 }
            r8.trim()     // Catch:{ Exception -> 0x0017 }
            r8 = 41
            java.lang.String r5 = r5.substring(r8, r7)     // Catch:{ Exception -> 0x0017 }
            java.lang.String r5 = r5.trim()     // Catch:{ Exception -> 0x0017 }
            java.lang.String r7 = "28373a3d3a3730373a3d3a3730373a3d3a"
            r8 = 88
            java.lang.String r7 = o00xxox0x0xoox((java.lang.String) r7, (int) r8)     // Catch:{ Exception -> 0x0017 }
            boolean r7 = r5.contains(r7)     // Catch:{ Exception -> 0x0017 }
            if (r7 == 0) goto L_0x006d
            goto L_0x0017
        L_0x006d:
            int r3 = r3 + 1
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0017 }
            r7.<init>()     // Catch:{ Exception -> 0x0017 }
            r7.append(r4)     // Catch:{ Exception -> 0x0017 }
            java.lang.String r8 = "22"
            r9 = 20
            java.lang.String r8 = o00xxox0x0xoox((java.lang.String) r8, (int) r9)     // Catch:{ Exception -> 0x0017 }
            java.lang.String r5 = r5.replace(r8, r0)     // Catch:{ Exception -> 0x0017 }
            r7.append(r5)     // Catch:{ Exception -> 0x0017 }
            r7.append(r6)     // Catch:{ Exception -> 0x0017 }
            java.lang.String r5 = "47"
            r6 = 38
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r5, (int) r6)     // Catch:{ Exception -> 0x0017 }
            r7.append(r5)     // Catch:{ Exception -> 0x0017 }
            java.lang.String r4 = r7.toString()     // Catch:{ Exception -> 0x0017 }
            if (r3 < r9) goto L_0x0017
        L_0x009a:
            r1.close()     // Catch:{ Exception -> 0x00a7 }
            int r1 = r4.length()     // Catch:{ Exception -> 0x00a7 }
            int r1 = r1 + -1
            java.lang.String r0 = r4.substring(r2, r1)     // Catch:{ Exception -> 0x00a7 }
        L_0x00a7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.tongdun.android.core.oo0ooo0o00o0xo.o0000xxooooxox00xo0o.x0xx00ooxx0oo000xxo():java.lang.String");
    }

    static String xoxx0xx() {
        String o00xxox0x0xoox2 = o0o0xxox.o00xxox0x0xoox();
        return o00xxox0x0xoox2 == null ? o00xxox0x0xoox("4374", 29) : o00xxox0x0xoox2;
    }

    static String o0000xxooooxox00xo0o() {
        String box7 = BoxUtil.box7();
        return (box7 == null || box7.length() <= 0) ? "" : box7.substring(0, box7.length() - 1);
    }

    static String xxx00xo0xoxxooxo() {
        long mobileRxBytes = TrafficStats.getMobileRxBytes();
        long mobileTxBytes = TrafficStats.getMobileTxBytes();
        long totalTxBytes = TrafficStats.getTotalTxBytes();
        long totalRxBytes = TrafficStats.getTotalRxBytes();
        return String.format(o00xxox0x0xoox("3d3b0857497a253b085749", 21), new Object[]{Long.valueOf(mobileRxBytes), Long.valueOf(mobileTxBytes), Long.valueOf(totalTxBytes), Long.valueOf(totalRxBytes)});
    }

    static Integer o00xx0xx0ooooo0xx00(Context context, WifiManager wifiManager) {
        Integer num = new Integer(-1);
        String ssid = wifiManager.getConnectionInfo().getSSID();
        PackageManager packageManager = context.getPackageManager();
        if (x0000xo0x0oooooo0.o00xxox0x0xoox(packageManager, o00xxox0x0xoox("7b7a23203236352b326b75766460637d64", 24)) != null) {
            return 1;
        }
        if (!TextUtils.isEmpty(ssid) && ssid.contains(o00xxox0x0xoox("771a7a11781c7b", 106))) {
            return 2;
        }
        if (x0000xo0x0oooooo0.o00xxox0x0xoox(packageManager, o00xxox0x0xoox("7b0461473b56305b36502c0a75186409720e", 103)) != null || x0000xo0x0oooooo0.o00xxox0x0xoox(packageManager, o00xxox0x0xoox("7b19615a3b4b3046364d2c17750564147213284e34472658284433493d5a2b", 122)) != null) {
            return 3;
        }
        if (cn.tongdun.android.core.ooxoxoooxooo0xx00.o00xxox0x0xoox.o00xxox0x0xoox(packageManager, ssid)) {
            return 4;
        }
        if (cn.tongdun.android.core.ooxoxoooxooo0xx00.oo0ooo0o00o0xo.o00xxox0x0xoox(packageManager)) {
            return 5;
        }
        if (ox0xxoox0.o00xxox0x0xoox(ssid)) {
            return 6;
        }
        if (cn.tongdun.android.core.ooxoxoooxooo0xx00.o0oo0xx00ooo0oox0xx0.o00xxox0x0xoox(context, ssid)) {
            return 7;
        }
        if (ooxoxoooxooo0xx00.o00xxox0x0xoox()) {
            return 8;
        }
        return num;
    }

    static String oox0x0x(Context context) {
        String o00xxox0x0xoox2 = oxxx0x0ooooxxooooo000.o00xxox0x0xoox().o00xxox0x0xoox(context);
        if (o00xxox0x0xoox2 == null || o00xxox0x0xoox2.length() > 70) {
            return o00xxox0x0xoox2;
        }
        return null;
    }

    static String x0xx00ooxx0oo000xxo(Context context) {
        String o00xxox0x0xoox2 = x00oxo0xx.o00xxox0x0xoox().o00xxox0x0xoox(context);
        if (o00xxox0x0xoox2 != null) {
            return null;
        }
        return o00xxox0x0xoox2;
    }

    static String xoxx0xx(Context context) {
        return x0ox00x0oooo0xxx.o00xxox0x0xoox().o00xxox0x0xoox(context);
    }

    static String o0000xxooooxox00xo0o(Context context) {
        return HelperJNI.fpic5(context);
    }

    static String xxx00xo0xoxxooxo(Context context) {
        String str = "";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (true) {
                if (!networkInterfaces.hasMoreElements()) {
                    break;
                }
                String name = networkInterfaces.nextElement().getName();
                if (name != null && o00xxox0x0xoox("6f197a1624", 109).equals(name)) {
                    NetworkInterface byName = NetworkInterface.getByName(name);
                    if (byName != null) {
                        Enumeration<InetAddress> inetAddresses = byName.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            if (nextElement instanceof Inet6Address) {
                                String hostAddress = nextElement.getHostAddress();
                                if (hostAddress.contains(o00xxox0x0xoox("3d4f3e42311c", 114))) {
                                    str = hostAddress.substring(0, hostAddress.length() - 6);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    static Integer oo0ooo0o00o0xo(Context context, LocationManager locationManager) {
        boolean z;
        boolean o00xxox0x0xoox2 = xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, "android.permission.ACCESS_FINE_LOCATION");
        boolean z2 = false;
        Integer num = 0;
        if (o00xxox0x0xoox2) {
            z2 = locationManager.isProviderEnabled("gps");
            z = locationManager.isProviderEnabled("network");
        } else {
            z = false;
        }
        if (z2 || z) {
            num = Integer.valueOf(num.intValue() | 1);
        }
        if (Build.VERSION.SDK_INT < 23) {
            return Integer.valueOf(num.intValue() | 2);
        }
        if (o00xxox0x0xoox2) {
            num = Integer.valueOf(num.intValue() | 2);
        }
        return (Build.VERSION.SDK_INT <= 28 || !xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, o00xxox0x0xoox("79056b1376157b5f254a3255364f36553054703b723b742d742169226b2a673f7a25612f7a3c79307b25662367", 101))) ? num : Integer.valueOf(num.intValue() | 4);
    }

    @TargetApi(14)
    static String xx0x000xxx0o0xox0ooxx(Context context) {
        String str;
        new ArrayList();
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        PackageManager packageManager = context.getPackageManager();
        if (accessibilityManager == null) {
            return "";
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1);
        if (enabledAccessibilityServiceList == null || enabledAccessibilityServiceList.size() == 0) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (AccessibilityServiceInfo resolveInfo : enabledAccessibilityServiceList) {
            ResolveInfo resolveInfo2 = resolveInfo.getResolveInfo();
            if (!(resolveInfo2 == null || resolveInfo2.serviceInfo == null)) {
                String str2 = resolveInfo2.serviceInfo.packageName;
                String str3 = resolveInfo2.serviceInfo.name;
                if (!TextUtils.isEmpty(str3) && !hashSet.contains(str3)) {
                    hashSet.add(str3);
                    if (packageManager != null) {
                        str = resolveInfo2.loadLabel(packageManager).toString();
                    } else {
                        str = "";
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str2);
                    arrayList2.add(str3);
                    arrayList2.add(str);
                    arrayList.add(arrayList2.toString());
                }
            }
        }
        return arrayList.toString();
    }

    static String oxxx0x0ooooxxooooo000(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
        return string == null ? "" : string;
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
            byte b2 = (byte) (i ^ 111);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 24);
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
