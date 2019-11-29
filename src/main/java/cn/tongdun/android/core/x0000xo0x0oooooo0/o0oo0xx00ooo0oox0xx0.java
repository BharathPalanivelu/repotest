package cn.tongdun.android.core.x0000xo0x0oooooo0;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.Display;
import java.io.File;
import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

public class o0oo0xx00ooo0oox0xx0 {
    public static String x0ox00x0oooo0xxx = "";
    public static final List xo00x00xo00 = new ArrayList();
    public String o00xx0xx0ooooo0xx00;
    public int o00xxox0x0xoox;
    public String oo0ooo0o00o0xo;
    private Map ooxoxoooxooo0xx00 = new HashMap();
    public Class[] x0000xo0x0oooooo0;

    public o0oo0xx00ooo0oox0xx0(int i, String str, String str2, Class[] clsArr) {
        this.o00xxox0x0xoox = i;
        this.oo0ooo0o00o0xo = str;
        this.o00xx0xx0ooooo0xx00 = str2;
        this.x0000xo0x0oooooo0 = clsArr;
    }

    public o0oo0xx00ooo0oox0xx0() {
    }

    static {
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(0, Settings.System.class.getName(), oo0ooo0o00o0xo("0d5d767a517c4a7b43", 30), new Class[]{ContentResolver.class, String.class}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(1, SharedPreferences.Editor.class.getName(), oo0ooo0o00o0xo("1a34711356154d1244", 112), new Class[]{String.class, String.class}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(3, TelephonyManager.class.getName(), oo0ooo0o00o0xo("0d76765150464156504d5b4a4c7161", 53), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(4, TelephonyManager.class.getName(), oo0ooo0o00o0xo("0d16762e5329587d27463f49385e", 85), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(5, TelephonyManager.class.getName(), oo0ooo0o00o0xo("0d3376035710481a4e3663", 112), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(6, TelephonyManager.class.getName(), oo0ooo0o00o0xo("0d4176634f6545636d4f654a47715f7e5869", 2), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(7, TelephonyManager.class.getName(), oo0ooo0o00o0xo("0d5d767a4c7e724865536d5e4f65576a507d", 30), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(8, TelephonyManager.class.getName(), oo0ooo0o00o0xo("0d61765b5d4a5e52434b6b67717c6b7a604a5a56", 34), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(9, TelephonyManager.class.getName(), oo0ooo0o00o0xo("0d5e76645d755e6d4374674b725c61497a54467b4a73", 29), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(10, TelephonyManager.class.getName(), oo0ooo0o00o0xo("0d39761e4c1a6e257b326827733a4f15431d", 122), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(11, TelephonyManager.class.getName(), oo0ooo0o00o0xo("0d0176254e224f297e047711", 66), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(12, TelephonyManager.class.getName(), oo0ooo0o00o0xo("0d16762c5d3d5e25433c7c117504", 85), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(13, TelephonyManager.class.getName(), oo0ooo0o00o0xo("0d347603500a502a732671336c356d", 119), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(14, TelephonyManager.class.getName(), oo0ooo0o00o0xo("0d787648575b48514e67726e606d767e614d525a53405541", 59), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(15, WifiInfo.class.getName(), oo0ooo0o00o0xo("0d6a76535a51787478626f746f", 41), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(16, WifiInfo.class.getName(), oo0ooo0o00o0xo("0d03763e4f0f6a0f7c186a18", 64), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(17, WifiInfo.class.getName(), oo0ooo0o00o0xo("0d58767f76657b", 27), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(18, WifiInfo.class.getName(), oo0ooo0o00o0xo("0d1c762a672a7d27", 95), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(19, WifiManager.class.getName(), oo0ooo0o00o0xo("0d6076575a565a5d5c4a414c406b67636e", 35), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(20, WifiManager.class.getName(), oo0ooo0o00o0xo("0d1e762e5a25491c6e1467", 93), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(21, WifiManager.class.getName(), oo0ooo0o00o0xo("0d5f7678467a49467e507849604e", 28), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(22, NetworkInterface.class.getName(), oo0ooo0o00o0xo("0d3e76045d155e0d431461337b226c366b346d22", 125), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(23, Proxy.class.getName(), oo0ooo0o00o0xo("0d387604511856", 123), new Class[]{Context.class}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(24, Proxy.class.getName(), oo0ooo0o00o0xo("0d3f761b49064f", 124), new Class[]{Context.class}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(25, System.class.getName(), oo0ooo0o00o0xo("0d627646545b4b4e5c4851", 33), new Class[]{String.class}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(26, PackageManager.class.getName(), oo0ooo0o00o0xo("0d447679516456715b7152667057725f78597a72557e5d", 7), new Class[]{String.class}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(27, PackageManager.class.getName(), oo0ooo0o00o0xo("0d78765c475e4f54495665716d78", 59), new Class[]{String.class, Integer.TYPE}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(28, PackageManager.class.getName(), oo0ooo0o00o0xo("0d67765a514756525b5252536662646a6e6c6c7a", 36), new Class[]{Integer.TYPE}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(29, File.class.getName(), oo0ooo0o00o0xo("0d047631552049235022411770026c", 71), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(30, ActivityManager.class.getName(), oo0ooo0o00o0xo("0d69764f51545153565a656f77776f", 42), new Class[]{Integer.TYPE}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(31, ComponentName.class.getName(), oo0ooo0o00o0xo("0d7e765a47584f524950627f6e77", 61), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(32, Modifier.class.getName(), oo0ooo0o00o0xo("036e5441415c5e4f", 53), new Class[]{Integer.TYPE}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(33, Debug.class.getName(), oo0ooo0o00o0xo("03025e2359344b344923780f790f7209651864", 89), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(34, Process.class.getName(), oo0ooo0o00o0xo("071a442349", 79), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(35, TimeZone.class.getName(), oo0ooo0o00o0xo("0d61764745517d787d6d6b7c", 34), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(36, TimeZone.class.getName(), oo0ooo0o00o0xo("0d797649614e667c7163766a62", 58), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(37, Locale.class.getName(), oo0ooo0o00o0xo("0d4f76775b78526a466c44", 12), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(38, Intent.class.getName(), oo0ooo0o00o0xo("0d187625513f40345a", 91), new Class[]{String.class}));
        if (Build.VERSION.SDK_INT < 28 && !Build.VERSION.RELEASE.equals(oo0ooo0o00o0xo("3a", 111))) {
            xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(39, Intent.class.getName(), oo0ooo0o00o0xo("0d2576144b184d0b", 102), new Class[]{String.class}));
            xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(2, oo0ooo0o00o0xo("0b1a6b0c760a7b403a5c67214d2b4a3a4207601a7f0f6809750563", 84), oo0ooo0o00o0xo("0d0876", 75), new Class[]{String.class, String.class}));
            xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(63, oo0ooo0o00o0xo("0b0d6b1b761d7b573a4b67364d3c4a2d4210600d7f18681e751263", 67), oo0ooo0o00o0xo("0d1f76", 92), new Class[]{String.class}));
        }
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(40, Intent.class.getName(), oo0ooo0o00o0xo("0d4376755b75587c5c73774e7b4868", 0), new Class[]{String.class, Boolean.TYPE}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(41, Intent.class.getName(), oo0ooo0o00o0xo("0d4576734d7e5c5e61526741", 6), new Class[]{String.class, Byte.TYPE}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(42, Intent.class.getName(), oo0ooo0o00o0xo("0d2776004d075001613c6d3a7e", 100), new Class[]{String.class, Short.TYPE}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(43, Intent.class.getName(), oo0ooo0o00o0xo("0d2776105d194e2e73227531", 100), new Class[]{String.class, Character.TYPE}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(44, Intent.class.getName(), oo0ooo0o00o0xo("0d12762f513560086c0e7f", 81), new Class[]{String.class, Integer.TYPE}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(45, Intent.class.getName(), oo0ooo0o00o0xo("0d20761855195c3b61376724", 99), new Class[]{String.class, Long.TYPE}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(46, Intent.class.getName(), oo0ooo0o00o0xo("0d7a76485c4b525e63636f657c", 57), new Class[]{String.class, Float.TYPE}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(47, Intent.class.getName(), oo0ooo0o00o0xo("0d7576455d5f4a5143717e7d786e", 54), new Class[]{String.class, Double.TYPE}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(48, Intent.class.getName(), oo0ooo0o00o0xo("0d51767651704a7743557e59784a", 18), new Class[]{String.class}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(49, Display.class.getName(), oo0ooo0o00o0xo("0d6e764d4840585c", 45), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(50, Display.class.getName(), oo0ooo0o00o0xo("0d37760b5b07550849", 116), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(51, BluetoothAdapter.class.getName(), oo0ooo0o00o0xo("0d79764c534c455b535b", 58), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(52, Settings.Secure.class.getName(), oo0ooo0o00o0xo("0d65764251444a4343", 38), new Class[]{ContentResolver.class, String.class}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(53, ActivityManager.class.getName(), oo0ooo0o00o0xo("0d57766e5e665c7b574b704379", 20), new Class[]{ActivityManager.MemoryInfo.class}));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(54, StatFs.class.getName(), oo0ooo0o00o0xo("0d0376355836543e6c047f1b", 64), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(55, StatFs.class.getName(), oo0ooo0o00o0xo("0d4076765875547d6c477f58567b5772", 3), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(56, StatFs.class.getName(), oo0ooo0o00o0xo("0d3f7609580a54027c2e66357c", 124), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(57, StatFs.class.getName(), oo0ooo0o00o0xo("0d4b767d587e54767c5a66417c795f7856", 8), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(58, StatFs.class.getName(), oo0ooo0o00o0xo("0d5776624175497044734a7a6d546e586640", 20), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(59, StatFs.class.getName(), oo0ooo0o00o0xo("0d7276474150495544564a5f6d716e7d66655946584f", 49), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(60, Location.class.getName(), oo0ooo0o00o0xo("0d73764b5b5e4643475246", 48), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(61, Location.class.getName(), oo0ooo0o00o0xo("0d0f763755365c3841395038", 76), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(62, InetAddress.class.getName(), oo0ooo0o00o0xo("037b565856474444464c6c696c7f7b697b", 32), new Class[0]));
        xo00x00xo00.add(new o0oo0xx00ooo0oox0xx0(64, LocationManager.class.getName(), oo0ooo0o00o0xo("0d6d76555b475c787979616043434f415a5c5c5d", 46), new Class[]{String.class}));
    }

    public void o00xxox0x0xoox() {
        this.ooxoxoooxooo0xx00.clear();
    }

    public void o00xxox0x0xoox(String str, int i) {
        if (this.ooxoxoooxooo0xx00.containsKey(str)) {
            ((List) this.ooxoxoooxooo0xx00.get(str)).add(Integer.valueOf(i));
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i));
        this.ooxoxoooxooo0xx00.put(str, arrayList);
    }

    public String toString() {
        return new JSONObject(this.ooxoxoooxooo0xx00).toString();
    }

    public static int o00xxox0x0xoox(String str) {
        for (o0oo0xx00ooo0oox0xx0 o0oo0xx00ooo0oox0xx0 : xo00x00xo00) {
            if (str.contains(o0oo0xx00ooo0oox0xx0.oo0ooo0o00o0xo) && str.contains(o0oo0xx00ooo0oox0xx0.o00xx0xx0ooooo0xx00) && str.contains(o00xxox0x0xoox(o0oo0xx00ooo0oox0xx0.x0000xo0x0oooooo0))) {
                return o0oo0xx00ooo0oox0xx0.o00xxox0x0xoox;
            }
        }
        return -1;
    }

    public static void oo0ooo0o00o0xo() {
        try {
            for (o0oo0xx00ooo0oox0xx0 o0oo0xx00ooo0oox0xx0 : xo00x00xo00) {
                if ((Class.forName(o0oo0xx00ooo0oox0xx0.oo0ooo0o00o0xo).getDeclaredMethod(o0oo0xx00ooo0oox0xx0.o00xx0xx0ooooo0xx00, o0oo0xx00ooo0oox0xx0.x0000xo0x0oooooo0).getModifiers() & 256) != 0 && !oo0ooo0o00o0xo("0774444d49", 33).equals(o0oo0xx00ooo0oox0xx0.o00xx0xx0ooooo0xx00)) {
                    x0ox00x0oooo0xxx += o0oo0xx00ooo0oox0xx0.o00xx0xx0ooooo0xx00 + ':';
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void o00xx0xx0ooooo0xx00() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace != null) {
            for (int i = 0; i < stackTrace.length - 1; i++) {
                String methodName = stackTrace[i].getMethodName();
                String className = stackTrace[i].getClassName();
                if (methodName != null) {
                    int i2 = i + 1;
                    if (methodName.equals(stackTrace[i2].getMethodName()) && className.equals(stackTrace[i2].getClassName()) && stackTrace[i2].isNativeMethod() && !className.contains(oo0ooo0o00o0xo("1227673b713a", 110))) {
                        x0ox00x0oooo0xxx += oo0ooo0o00o0xo("35", 39) + className + oo0ooo0o00o0xo("44", 65) + methodName;
                    }
                }
            }
        }
    }

    private static String o00xxox0x0xoox(Class[] clsArr) {
        StringBuilder sb = new StringBuilder();
        for (Class cls : clsArr) {
            if (sb.length() > 0) {
                sb.append(oo0ooo0o00o0xo("46", 83));
            }
            sb.append(cls.getName());
        }
        return sb.toString();
    }

    public static String oo0ooo0o00o0xo(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b2 = (byte) (i ^ 65);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 106);
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
