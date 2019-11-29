package com.scottyab.rootbeer;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.scottyab.rootbeer.a.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15731a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f15732b = true;

    public b(Context context) {
        this.f15731a = context;
    }

    public boolean a() {
        return c() || d() || a("su") || a("busybox") || f() || g() || b() || h() || j() || e();
    }

    public boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public boolean c() {
        return a((String[]) null);
    }

    public boolean a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(a.f15725a));
        if (strArr != null && strArr.length > 0) {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return a((List<String>) arrayList);
    }

    public boolean d() {
        return b((String[]) null);
    }

    public boolean b(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(a.f15726b));
        if (strArr != null && strArr.length > 0) {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return a((List<String>) arrayList);
    }

    public boolean e() {
        return a("magisk");
    }

    public boolean a(String str) {
        boolean z = false;
        for (String str2 : a.f15728d) {
            String str3 = str2 + str;
            if (new File(str2, str).exists()) {
                a.b(str3 + " binary detected!");
                z = true;
            }
        }
        return z;
    }

    private String[] k() {
        try {
            InputStream inputStream = Runtime.getRuntime().exec("getprop").getInputStream();
            if (inputStream == null) {
                return null;
            }
            return new Scanner(inputStream).useDelimiter("\\A").next().split("\n");
        } catch (IOException | NoSuchElementException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private String[] l() {
        try {
            InputStream inputStream = Runtime.getRuntime().exec("mount").getInputStream();
            if (inputStream == null) {
                return null;
            }
            return new Scanner(inputStream).useDelimiter("\\A").next().split("\n");
        } catch (IOException | NoSuchElementException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private boolean a(List<String> list) {
        PackageManager packageManager = this.f15731a.getPackageManager();
        boolean z = false;
        for (String next : list) {
            try {
                packageManager.getPackageInfo(next, 0);
                a.a(next + " ROOT management app detected!");
                z = true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return z;
    }

    public boolean f() {
        HashMap hashMap = new HashMap();
        hashMap.put("ro.debuggable", "1");
        hashMap.put("ro.secure", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String[] k = k();
        if (k == null) {
            return false;
        }
        boolean z = false;
        for (String str : k) {
            for (String str2 : hashMap.keySet()) {
                if (str.contains(str2)) {
                    String str3 = "[" + ((String) hashMap.get(str2)) + "]";
                    if (str.contains(str3)) {
                        a.b(str2 + " = " + str3 + " detected!");
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public boolean g() {
        String[] l = l();
        if (l == null) {
            return false;
        }
        boolean z = false;
        for (String str : l) {
            String[] split = str.split(SQLBuilder.BLANK);
            if (split.length < 4) {
                a.a("Error formatting mount line: " + str);
            } else {
                String str2 = split[1];
                String str3 = split[3];
                boolean z2 = z;
                for (String str4 : a.f15729e) {
                    if (str2.equalsIgnoreCase(str4)) {
                        String[] split2 = str3.split(",");
                        int length = split2.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            } else if (split2[i].equalsIgnoreCase("rw")) {
                                a.b(str4 + " path is mounted with rw permissions! " + str);
                                z2 = true;
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                z = z2;
            }
        }
        return z;
    }

    public boolean h() {
        boolean z = false;
        Process process = null;
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"which", "su"});
            if (new BufferedReader(new InputStreamReader(exec.getInputStream())).readLine() != null) {
                z = true;
            }
            if (exec != null) {
                exec.destroy();
            }
            return z;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    public boolean i() {
        return new RootBeerNative().a();
    }

    public boolean j() {
        if (!i()) {
            a.a("We could not load the native library to test for root");
            return false;
        }
        String[] strArr = new String[a.f15728d.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = a.f15728d[i] + "su";
        }
        RootBeerNative rootBeerNative = new RootBeerNative();
        try {
            rootBeerNative.setLogDebugMessages(this.f15732b);
            if (rootBeerNative.checkForRoot(strArr) > 0) {
                return true;
            }
            return false;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        }
    }
}
