package com.google.firebase.perf.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.internal.p000firebaseperf.zzah;
import com.google.android.gms.internal.p000firebaseperf.zzak;
import com.google.android.gms.internal.p000firebaseperf.zzba;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class p {

    /* renamed from: a  reason: collision with root package name */
    private final Runtime f14265a;

    /* renamed from: b  reason: collision with root package name */
    private final ActivityManager f14266b;

    /* renamed from: c  reason: collision with root package name */
    private final ActivityManager.MemoryInfo f14267c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14268d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f14269e;

    p(Context context) {
        this(Runtime.getRuntime(), context);
    }

    private p(Runtime runtime, Context context) {
        String str;
        this.f14265a = runtime;
        this.f14269e = context;
        this.f14266b = (ActivityManager) context.getSystemService("activity");
        this.f14267c = new ActivityManager.MemoryInfo();
        this.f14266b.getMemoryInfo(this.f14267c);
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.f14266b.getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    str = next.processName;
                    break;
                }
            }
            this.f14268d = str;
        }
        str = this.f14269e.getPackageName();
        this.f14268d = str;
    }

    public final String a() {
        return this.f14268d;
    }

    public final int b() {
        return zzah.zza(zzba.BYTES.zzp(this.f14265a.maxMemory()));
    }

    public final int c() {
        return zzah.zza(zzba.MEGABYTES.zzp((long) this.f14266b.getMemoryClass()));
    }

    public final int d() {
        if (Build.VERSION.SDK_INT >= 16) {
            return zzah.zza(zzba.BYTES.zzp(this.f14267c.totalMem));
        }
        return a("/proc/meminfo");
    }

    private static int a(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                if (readLine.startsWith("MemTotal")) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(readLine);
                    int parseInt = matcher.find() ? Integer.parseInt(matcher.group()) : 0;
                    bufferedReader.close();
                    return parseInt;
                }
            }
            bufferedReader.close();
        } catch (IOException e2) {
            String message = e2.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(message).length());
            sb.append("Unable to read '");
            sb.append(str);
            sb.append("' file: ");
            sb.append(message);
            Log.w("FirebasePerformance", sb.toString());
        } catch (NumberFormatException e3) {
            String message2 = e3.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(message2).length());
            sb2.append("Unable to parse '");
            sb2.append(str);
            sb2.append("' file: ");
            sb2.append(message2);
            Log.w("FirebasePerformance", sb2.toString());
        } catch (Throwable th) {
            zzak.zza(r4, th);
        }
        return 0;
        throw th;
    }
}
