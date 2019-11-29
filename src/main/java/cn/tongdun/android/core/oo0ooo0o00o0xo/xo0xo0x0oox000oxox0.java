package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.ox000o0o;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.x0000xo0x0oooooo0;
import cn.tongdun.android.core.ooxoxoooxooo0xx00.xoo0xoo0oxo00x0o0;
import cn.tongdun.android.shell.common.HelperJNI;
import cn.tongdun.android.shell.utils.BoxUtil;
import java.io.File;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class xo0xo0x0oox000oxox0 {
    static String oo0ooo0o00o0xo(Context context) {
        return "";
    }

    @TargetApi(9)
    static String o00xxox0x0xoox(String str) {
        try {
            NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(InetAddress.getByName(str));
            if (byInetAddress != null) {
                return ox000o0o.o00xxox0x0xoox(byInetAddress.getHardwareAddress());
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    static String o00xxox0x0xoox(Context context, ConnectivityManager connectivityManager, WifiManager wifiManager) {
        String str = "";
        if (xoo0xoo0oxo00x0o0.oo0ooo0o00o0xo(21) && xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return str;
            }
            for (Network network : connectivityManager.getAllNetworks()) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                if (networkInfo != null && networkInfo.getType() == activeNetworkInfo.getType()) {
                    for (InetAddress next : connectivityManager.getLinkProperties(network).getDnsServers()) {
                        if (str.length() > 0) {
                            str = str + o00xxox0x0xoox("37", 32);
                        }
                        str = str + next.getHostAddress();
                    }
                }
            }
            return str;
        } else if (!xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, "android.permission.ACCESS_WIFI_STATE") || !wifiManager.isWifiEnabled()) {
            return (str + x0000xo0x0oooooo0.o00xxox0x0xoox(o00xxox0x0xoox("7c5d765974446b14251f34457e4f630d", 112))) + o00xxox0x0xoox("37", 26) + x0000xo0x0oooooo0.o00xxox0x0xoox(o00xxox0x0xoox("7c047600741d6b4d2546341c7e166357", 41));
        } else {
            DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
            return (str + ox000o0o.o00xxox0x0xoox(dhcpInfo.dns1)) + o00xxox0x0xoox("37", 61) + ox000o0o.o00xxox0x0xoox(dhcpInfo.dns2);
        }
    }

    static Map o00xxox0x0xoox(Context context, String... strArr) {
        HashMap hashMap = new HashMap();
        if (xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, "android.permission.INTERNET")) {
            ArrayList arrayList = new ArrayList();
            try {
                String str = "";
                String str2 = str;
                String str3 = str2;
                for (T t : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    String name = t.getName();
                    arrayList.add(name);
                    for (T t2 : Collections.list(t.getInetAddresses())) {
                        if (!t2.isLoopbackAddress()) {
                            str3 = t2.getHostAddress();
                            if (ox000o0o.oo0ooo0o00o0xo(str3)) {
                                str2 = str2 + str3 + o00xxox0x0xoox("37", 84);
                            }
                        }
                    }
                    if (o0000xxooooxox00xo0o.o00xxox0x0xoox.equals(name)) {
                        hashMap.put(o0000xxooooxox00xo0o.x0ox00x0oooo0xxx, o00xxox0x0xoox((NetworkInterface) t));
                        hashMap.put(o0000xxooooxox00xo0o.o00xxox0x0xoox, str3);
                    } else if (o0000xxooooxox00xo0o.oo0ooo0o00o0xo.equals(name)) {
                        hashMap.put(o0000xxooooxox00xo0o.xo00x00xo00, o00xxox0x0xoox((NetworkInterface) t));
                        hashMap.put(o0000xxooooxox00xo0o.oo0ooo0o00o0xo, str3);
                    }
                }
                if (o0000xxooooxox00xo0o.x0000xo0x0oooooo0.equals(strArr[0])) {
                    if (!ox000o0o.o00xxox0x0xoox(str2)) {
                        str = str2.substring(0, str2.length() - 1);
                    }
                    hashMap.put(o0000xxooooxox00xo0o.x0000xo0x0oooooo0, str);
                    return hashMap;
                } else if (o0000xxooooxox00xo0o.o00xx0xx0ooooo0xx00.equals(strArr[0])) {
                    String obj = arrayList.toString();
                    hashMap.put(o0000xxooooxox00xo0o.o00xx0xx0ooooo0xx00, obj.substring(1, obj.length() - 1));
                }
            } catch (SocketException unused) {
            }
        }
        return hashMap;
    }

    @TargetApi(9)
    private static String o00xxox0x0xoox(NetworkInterface networkInterface) {
        String str = "";
        for (InterfaceAddress next : networkInterface.getInterfaceAddresses()) {
            if (ox000o0o.oo0ooo0o00o0xo(next.getAddress().getHostAddress())) {
                short networkPrefixLength = next.getNetworkPrefixLength();
                str = str + ox000o0o.oo0ooo0o00o0xo((int) networkPrefixLength) + o00xxox0x0xoox("37", 123);
            }
        }
        return str.length() > 1 ? str.substring(0, str.length() - 1) : str;
    }

    static String o00xxox0x0xoox(Context context) {
        try {
            return HelperJNI.simplemd5(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a A[SYNTHETIC, Splitter:B:17:0x003a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String o00xx0xx0ooooo0xx00(android.content.Context r7) {
        /*
            java.lang.String r0 = ""
            java.lang.System.currentTimeMillis()
            java.lang.String r7 = r7.getPackageResourcePath()
            r1 = 256(0x100, float:3.59E-43)
            r2 = 0
            byte[] r3 = new byte[r1]     // Catch:{ Exception -> 0x0037 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0037 }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0037 }
            r5.<init>(r7)     // Catch:{ Exception -> 0x0037 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0037 }
            int r7 = r4.available()     // Catch:{ Exception -> 0x0038 }
            if (r7 >= r1) goto L_0x001f
            r1 = r7
        L_0x001f:
            int r7 = r7 - r1
            long r5 = (long) r7     // Catch:{ Exception -> 0x0038 }
            r4.skip(r5)     // Catch:{ Exception -> 0x0038 }
            r7 = 0
            int r7 = r4.read(r3, r7, r1)     // Catch:{ Exception -> 0x0038 }
            if (r1 != r7) goto L_0x0033
            java.lang.String r7 = cn.tongdun.android.shell.common.HelperJNI.simplemd5(r3)     // Catch:{ Exception -> 0x0038 }
            r4.close()     // Catch:{ Exception -> 0x0038 }
            return r7
        L_0x0033:
            r4.close()     // Catch:{ Exception -> 0x0038 }
            return r0
        L_0x0037:
            r4 = r2
        L_0x0038:
            if (r4 == 0) goto L_0x003d
            r4.close()     // Catch:{ Exception -> 0x003d }
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.tongdun.android.core.oo0ooo0o00o0xo.xo0xo0x0oox000oxox0.o00xx0xx0ooooo0xx00(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int x0000xo0x0oooooo0(android.content.Context r4) {
        /*
            java.lang.String r0 = "7f462f1a3217264f694063567e50731a25123a0e2c0f6648615566406b406257"
            r1 = 104(0x68, float:1.46E-43)
            java.lang.String r0 = o00xxox0x0xoox((java.lang.String) r0, (int) r1)
            java.lang.String r1 = "781c615f3c4d284a334876157002610567167207"
            r2 = 63
            java.lang.String r1 = o00xxox0x0xoox((java.lang.String) r1, (int) r2)
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            r2 = 0
            android.content.pm.PackageInfo r3 = r4.getPackageInfo(r0, r2)     // Catch:{ NameNotFoundException -> 0x0023 }
            java.lang.String r3 = r3.packageName     // Catch:{ NameNotFoundException -> 0x0023 }
            boolean r0 = r0.equals(r3)     // Catch:{ NameNotFoundException -> 0x0023 }
            if (r0 == 0) goto L_0x0023
            r0 = 1
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r1, r2)     // Catch:{ NameNotFoundException -> 0x0033 }
            java.lang.String r4 = r4.packageName     // Catch:{ NameNotFoundException -> 0x0033 }
            boolean r4 = r1.equals(r4)     // Catch:{ NameNotFoundException -> 0x0033 }
            if (r4 == 0) goto L_0x0033
            r4 = r0 | 256(0x100, float:3.59E-43)
            r0 = r4
        L_0x0033:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.tongdun.android.core.oo0ooo0o00o0xo.xo0xo0x0oox000oxox0.x0000xo0x0oooooo0(android.content.Context):int");
    }

    static int o00xxox0x0xoox() {
        try {
            throw new Exception(o00xxox0x0xoox("7f0575147303274b204b24", 43));
        } catch (Exception e2) {
            int i = 0;
            int i2 = 0;
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (o00xxox0x0xoox("7f192f4532482610691f63097e0f7345254d3a512c5066264e39522f530963126e116c", 55).equals(stackTraceElement.getClassName()) && o00xxox0x0xoox("765e6559", 125).equals(stackTraceElement.getMethodName())) {
                    i |= 2;
                }
                if (o00xxox0x0xoox("7f0c2f50325d2605690a631c7e1a735025583a442c4566334e2c523a531c63076e046c", 34).equals(stackTraceElement.getClassName()) && o00xxox0x0xoox("7326672c6f25420242064c07652f74337338", 0).equals(stackTraceElement.getMethodName())) {
                    i |= 4;
                }
                if (o00xxox0x0xoox("782161622e6d247b397d3437733069217e3d713033712f2c5b0f45075e167231752c", 2).equals(stackTraceElement.getClassName())) {
                    i2++;
                    if (i2 == 2) {
                        i |= 512;
                    }
                }
                if (o00xxox0x0xoox("7838617b3c69286e336c763170266121673272233940273731", 27).equals(stackTraceElement.getClassName()) && o00xxox0x0xoox("7247715e755074", 111).equals(stackTraceElement.getMethodName())) {
                    i |= 1024;
                }
            }
            return i;
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int oo0ooo0o00o0xo() {
        /*
            r0 = 0
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            r1.<init>()     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            r2.<init>()     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            java.lang.String r3 = "34302d2d2161"
            r4 = 64
            java.lang.String r3 = o00xxox0x0xoox((java.lang.String) r3, (int) r4)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            r2.append(r3)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            int r3 = android.os.Process.myPid()     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            r2.append(r3)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            java.lang.String r3 = "3451234020"
            r4 = 60
            java.lang.String r3 = o00xxox0x0xoox((java.lang.String) r3, (int) r4)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            r2.append(r3)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            java.lang.String r2 = "6e51671a72"
            r6 = 127(0x7f, float:1.78E-43)
            java.lang.String r2 = o00xxox0x0xoox((java.lang.String) r2, (int) r6)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            r4.<init>(r5, r2)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
        L_0x0043:
            java.lang.String r2 = r3.readLine()     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            if (r2 == 0) goto L_0x007b
            java.lang.String r4 = "350c32"
            r5 = 126(0x7e, float:1.77E-43)
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r4, (int) r5)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            boolean r4 = r2.endsWith(r4)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            if (r4 != 0) goto L_0x0065
            java.lang.String r4 = "35422551"
            r5 = 41
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r4, (int) r5)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            boolean r4 = r2.endsWith(r4)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            if (r4 == 0) goto L_0x0043
        L_0x0065:
            java.lang.String r4 = "3b"
            r5 = 12
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r4, (int) r5)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            int r4 = r2.lastIndexOf(r4)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            int r4 = r4 + 1
            java.lang.String r2 = r2.substring(r4)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            r1.add(r2)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            goto L_0x0043
        L_0x007b:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
        L_0x007f:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            if (r2 == 0) goto L_0x00b0
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            java.lang.String r4 = r2.toLowerCase()     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            java.lang.String r5 = "631c6700710177116c1c6f1e"
            r6 = 59
            java.lang.String r5 = o00xxox0x0xoox((java.lang.String) r5, (int) r6)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            boolean r4 = r4.contains(r5)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            if (r4 == 0) goto L_0x009f
            r0 = r0 | 8
        L_0x009f:
            java.lang.String r4 = "785661153c0728003302765f7048614f675c724d"
            r5 = 117(0x75, float:1.64E-43)
            java.lang.String r4 = o00xxox0x0xoox((java.lang.String) r4, (int) r5)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            boolean r2 = r2.contains(r4)     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            if (r2 == 0) goto L_0x007f
            r0 = r0 | 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x00b0:
            r3.close()     // Catch:{ Exception -> 0x00b6, all -> 0x00b4 }
            goto L_0x00b6
        L_0x00b4:
            r0 = move-exception
            throw r0
        L_0x00b6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.tongdun.android.core.oo0ooo0o00o0xo.xo0xo0x0oox000oxox0.oo0ooo0o00o0xo():int");
    }

    static int o00xx0xx0ooooo0xx00() {
        return BoxUtil.box3(2333);
    }

    static String x0000xo0x0oooooo0() {
        StringBuilder sb = new StringBuilder();
        File file = new File(o00xxox0x0xoox("3460256a227b2a396330622a6576", 19));
        String o00xxox0x0xoox = o00xxox0x0xoox("353c2e2e", 73);
        String[] list = file.list();
        if (list == null) {
            return sb.toString();
        }
        for (String str : list) {
            if (str != null && str.endsWith(o00xxox0x0xoox)) {
                String str2 = new String(str);
                if (sb.length() > 0) {
                    sb.append(o00xxox0x0xoox("37", 69));
                }
                sb.append(str2.substring(0, str2.length() - 4));
            }
        }
        return HelperJNI.simplemd5(sb.toString().getBytes());
    }

    static String x0ox00x0oooo0xxx() {
        try {
            String[] split = HelperJNI.getBaseBand().split(o00xxox0x0xoox("37", 17));
            if (split.length == 1) {
                return split[0];
            }
            if (split.length < 2) {
                return "";
            }
            if (split[0].equals(split[1])) {
                return split[0];
            }
            return split[0] + o00xxox0x0xoox("37", 87) + split[1];
        } catch (Exception unused) {
            return "";
        }
    }

    static String x0ox00x0oooo0xxx(Context context) {
        if (!xoo0xoo0oxo00x0o0.o00xxox0x0xoox(context, "android.permission.BLUETOOTH")) {
            return "";
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            return "";
        }
        return defaultAdapter.getAddress();
    }

    public static String xo00x00xo00(Context context) {
        try {
            String packageName = context.getPackageName();
            String str = context.getPackageManager().getPackageInfo(packageName, 0).versionName;
            return packageName + o00xxox0x0xoox("3135", 22) + str;
        } catch (Exception unused) {
            return null;
        }
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
            byte b2 = (byte) (i ^ 47);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 27);
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
