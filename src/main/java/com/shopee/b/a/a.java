package com.shopee.b.a;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;
import d.d.b.j;
import d.h.k;
import d.h.m;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.TimeZone;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f27078a;

    /* renamed from: b  reason: collision with root package name */
    private final int f27079b = 1;

    /* renamed from: c  reason: collision with root package name */
    private final int f27080c = 2;

    /* renamed from: d  reason: collision with root package name */
    private final int f27081d = 3;

    /* renamed from: e  reason: collision with root package name */
    private final int f27082e = -2;

    /* renamed from: f  reason: collision with root package name */
    private final int f27083f = -1;

    /* renamed from: g  reason: collision with root package name */
    private final long f27084g;
    private final float h;
    private final String i;
    private final String j;
    private final String k;
    private final com.shopee.b.b.a l;
    private final Context m;

    public a(Context context) {
        j.b(context, "context");
        this.m = context;
        int i2 = this.f27083f;
        this.f27084g = (long) i2;
        this.h = (float) i2;
        this.i = String.valueOf(this.f27082e);
        this.j = "";
        this.k = String.valueOf(this.f27083f);
        this.l = new com.shopee.b.b.a(this.m);
    }

    public final String a() {
        String str = Build.MANUFACTURER;
        return str != null ? str : "";
    }

    public final String b() {
        String str = Build.MODEL;
        return str != null ? str : "";
    }

    public final String c() {
        String str = Build.HARDWARE;
        return str != null ? str : "";
    }

    public final String d() {
        String str = Build.PRODUCT;
        return str != null ? str : "";
    }

    public final String e() {
        String str = Build.BRAND;
        return str != null ? str : "";
    }

    public final long f() {
        return Build.TIME;
    }

    public final String g() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            str = "";
        }
        String str2 = Build.MODEL;
        if (str2 == null) {
            str2 = "";
        }
        if ((!j.a((Object) str, (Object) "")) && (!j.a((Object) str2, (Object) "")) && m.a(str2, str, false, 2, (Object) null)) {
            return str2;
        }
        String str3 = str + ' ' + str2;
        if (str3 != null) {
            return m.b(str3).toString();
        }
        throw new d.m("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public final String h() {
        if (!this.l.a("android.permission.ACCESS_WIFI_STATE")) {
            return this.i;
        }
        try {
            Object systemService = this.m.getSystemService("wifi");
            if (systemService != null) {
                WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
                j.a((Object) connectionInfo, "info");
                String macAddress = connectionInfo.getMacAddress();
                if (macAddress != null) {
                    return macAddress;
                }
                return this.j;
            }
            throw new d.m("null cannot be cast to non-null type android.net.wifi.WifiManager");
        } catch (Exception e2) {
            e2.printStackTrace();
            return this.k;
        }
    }

    public final String i() {
        try {
            if (!this.l.a("android.permission.BLUETOOTH")) {
                return this.i;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                String address = defaultAdapter.getAddress();
                if (address != null) {
                    return address;
                }
            }
            return this.j;
        } catch (Exception e2) {
            e2.printStackTrace();
            return this.k;
        }
    }

    public final String j() {
        try {
            String string = Settings.Secure.getString(this.m.getContentResolver(), "android_id");
            if (string != null) {
                return string;
            }
            return this.j;
        } catch (Exception e2) {
            e2.printStackTrace();
            return this.k;
        }
    }

    public final long k() {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                Object systemService = this.m.getSystemService("activity");
                if (systemService != null) {
                    ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
                    return memoryInfo.totalMem;
                }
                throw new d.m("null cannot be cast to non-null type android.app.ActivityManager");
            } catch (Exception e2) {
                e2.printStackTrace();
                return this.f27084g;
            }
        } else {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
                String readLine = randomAccessFile.readLine();
                j.a((Object) readLine, "reader.readLine()");
                long parseInt = (long) Integer.parseInt(new k("\\D+").a((CharSequence) readLine, ""));
                randomAccessFile.close();
                return parseInt;
            } catch (IOException e3) {
                e3.printStackTrace();
                return this.f27084g;
            }
        }
    }

    public final long l() {
        long j2;
        long j3;
        File dataDirectory = Environment.getDataDirectory();
        try {
            j.a((Object) dataDirectory, "path");
            StatFs statFs = new StatFs(dataDirectory.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                j2 = statFs.getBlockSizeLong();
                j3 = statFs.getBlockCountLong();
            } else {
                j2 = (long) statFs.getBlockSize();
                j3 = (long) statFs.getBlockCount();
            }
            return j3 * j2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return this.f27084g;
        }
    }

    public final long m() {
        long j2;
        long j3;
        File dataDirectory = Environment.getDataDirectory();
        try {
            j.a((Object) dataDirectory, "path");
            StatFs statFs = new StatFs(dataDirectory.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                j2 = statFs.getBlockSizeLong();
                j3 = statFs.getAvailableBlocksLong();
            } else {
                j2 = (long) statFs.getBlockSize();
                j3 = (long) statFs.getAvailableBlocks();
            }
            return j3 * j2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return this.f27084g;
        }
    }

    public final long n() {
        try {
            Object systemService = this.m.getSystemService("activity");
            if (systemService != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
                return memoryInfo.availMem;
            }
            throw new d.m("null cannot be cast to non-null type android.app.ActivityManager");
        } catch (Exception e2) {
            e2.printStackTrace();
            return this.f27084g;
        }
    }

    public final int o() {
        try {
            Object systemService = this.m.getSystemService("window");
            if (systemService != null) {
                Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                j.a((Object) defaultDisplay, "display");
                return defaultDisplay.getHeight();
            }
            throw new d.m("null cannot be cast to non-null type android.view.WindowManager");
        } catch (Exception e2) {
            e2.printStackTrace();
            return this.f27083f;
        }
    }

    public final int p() {
        try {
            Object systemService = this.m.getSystemService("window");
            if (systemService != null) {
                Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                j.a((Object) defaultDisplay, "display");
                return defaultDisplay.getWidth();
            }
            throw new d.m("null cannot be cast to non-null type android.view.WindowManager");
        } catch (Exception e2) {
            e2.printStackTrace();
            return this.f27083f;
        }
    }

    public final String q() {
        try {
            Object systemService = this.m.getSystemService("phone");
            if (systemService != null) {
                TelephonyManager telephonyManager = (TelephonyManager) systemService;
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (networkOperatorName == null) {
                    networkOperatorName = telephonyManager.getSimOperatorName();
                }
                if (networkOperatorName != null) {
                    return networkOperatorName;
                }
                return this.j;
            }
            throw new d.m("null cannot be cast to non-null type android.telephony.TelephonyManager");
        } catch (Exception e2) {
            e2.printStackTrace();
            return this.k;
        }
    }

    public final long r() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public final String s() {
        String displayName = TimeZone.getDefault().getDisplayName(false, 0);
        j.a((Object) displayName, "TimeZone.getDefault().ge…me(false, TimeZone.SHORT)");
        return displayName;
    }

    public final boolean t() {
        for (String file : new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"}) {
            if (new File(file).exists()) {
                return true;
            }
        }
        return false;
    }

    public final String u() {
        if (!this.l.a("android.permission.READ_PHONE_STATE") && !this.l.a("android.permission.READ_PHONE_NUMBERS")) {
            return this.i;
        }
        try {
            Object systemService = this.m.getSystemService("phone");
            if (systemService != null) {
                String line1Number = ((TelephonyManager) systemService).getLine1Number();
                if (line1Number != null) {
                    return line1Number;
                }
                return this.j;
            }
            throw new d.m("null cannot be cast to non-null type android.telephony.TelephonyManager");
        } catch (Exception e2) {
            e2.printStackTrace();
            return this.k;
        }
    }

    private final Intent A() {
        return this.m.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public final float v() {
        Intent A = A();
        if (A == null) {
            try {
                j.a();
            } catch (Exception e2) {
                e2.printStackTrace();
                return this.h;
            }
        }
        int intExtra = A.getIntExtra("level", -1);
        int intExtra2 = A.getIntExtra("scale", -1);
        if (intExtra < 0 || intExtra2 <= 0) {
            return -1.0f;
        }
        return (((float) intExtra) * 100.0f) / ((float) intExtra2);
    }

    public final boolean w() {
        Intent A = A();
        if (A == null) {
            try {
                j.a();
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        int intExtra = A.getIntExtra("plugged", 0);
        if (intExtra == 1 || intExtra == 2) {
            return true;
        }
        return false;
    }

    public final float x() {
        Intent A = A();
        if (A == null) {
            try {
                j.a();
            } catch (Exception e2) {
                e2.printStackTrace();
                return this.h;
            }
        }
        double intExtra = (double) A.getIntExtra("temperature", 0);
        Double.isNaN(intExtra);
        return (float) (intExtra / 10.0d);
    }

    public final int y() {
        Intent A = A();
        if (A == null) {
            try {
                j.a();
            } catch (Exception e2) {
                e2.printStackTrace();
                return this.f27083f;
            }
        }
        int intExtra = A.getIntExtra("plugged", 0);
        if (intExtra == 1) {
            return this.f27080c;
        }
        if (intExtra == 2) {
            return this.f27079b;
        }
        if (intExtra != 4) {
            return this.f27078a;
        }
        return this.f27081d;
    }

    public final int z() {
        try {
            return Settings.System.getInt(this.m.getContentResolver(), "screen_brightness");
        } catch (Exception unused) {
            return this.f27083f;
        }
    }
}
