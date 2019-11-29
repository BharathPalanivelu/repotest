package com.crashlytics.android.c;

import android.app.ActivityManager;
import com.facebook.appevents.AppEventsConstants;
import io.a.a.a.a.b.p;
import io.a.a.a.c;
import java.util.List;
import java.util.Map;

class ao {

    /* renamed from: a  reason: collision with root package name */
    private static final c f6437a = c.a(AppEventsConstants.EVENT_PARAM_VALUE_NO);

    /* renamed from: b  reason: collision with root package name */
    private static final c f6438b = c.a("Unity");

    public static void a(f fVar, String str, String str2, long j) throws Exception {
        fVar.a(1, c.a(str2));
        fVar.a(2, c.a(str));
        fVar.a(3, j);
    }

    public static void a(f fVar, String str, String str2, String str3, String str4, String str5, int i, String str6) throws Exception {
        c a2 = c.a(str);
        c a3 = c.a(str2);
        c a4 = c.a(str3);
        c a5 = c.a(str4);
        c a6 = c.a(str5);
        c a7 = str6 != null ? c.a(str6) : null;
        fVar.g(7, 2);
        fVar.k(a(a2, a3, a4, a5, a6, i, a7));
        fVar.a(1, a2);
        fVar.a(2, a4);
        fVar.a(3, a5);
        fVar.g(5, 2);
        fVar.k(a(a3));
        fVar.a(1, a3);
        fVar.a(6, a6);
        if (a7 != null) {
            fVar.a(8, f6438b);
            fVar.a(9, a7);
        }
        fVar.b(10, i);
    }

    public static void a(f fVar, String str, String str2, boolean z) throws Exception {
        c a2 = c.a(str);
        c a3 = c.a(str2);
        fVar.g(8, 2);
        fVar.k(a(a2, a3, z));
        fVar.b(1, 3);
        fVar.a(2, a2);
        fVar.a(3, a3);
        fVar.a(4, z);
    }

    public static void a(f fVar, int i, String str, int i2, long j, long j2, boolean z, Map<p.a, String> map, int i3, String str2, String str3) throws Exception {
        f fVar2 = fVar;
        c a2 = a(str);
        c a3 = a(str3);
        c a4 = a(str2);
        fVar2.g(9, 2);
        c cVar = a4;
        fVar2.k(a(i, a2, i2, j, j2, z, map, i3, a4, a3));
        fVar2.b(3, i);
        fVar2.a(4, a2);
        fVar2.a(5, i2);
        fVar2.a(6, j);
        fVar2.a(7, j2);
        fVar2.a(10, z);
        for (Map.Entry next : map.entrySet()) {
            fVar2.g(11, 2);
            fVar2.k(a((p.a) next.getKey(), (String) next.getValue()));
            fVar2.b(1, ((p.a) next.getKey()).protobufIndex);
            fVar2.a(2, c.a((String) next.getValue()));
        }
        fVar2.a(12, i3);
        if (cVar != null) {
            fVar2.a(13, cVar);
        }
        if (a3 != null) {
            fVar2.a(14, a3);
        }
    }

    public static void a(f fVar, String str, String str2, String str3) throws Exception {
        if (str == null) {
            str = "";
        }
        c a2 = c.a(str);
        c a3 = a(str2);
        c a4 = a(str3);
        int b2 = f.b(1, a2) + 0;
        if (str2 != null) {
            b2 += f.b(2, a3);
        }
        if (str3 != null) {
            b2 += f.b(3, a4);
        }
        fVar.g(6, 2);
        fVar.k(b2);
        fVar.a(1, a2);
        if (str2 != null) {
            fVar.a(2, a3);
        }
        if (str3 != null) {
            fVar.a(3, a4);
        }
    }

    public static void a(f fVar, long j, String str, as asVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, Map<String, String> map, y yVar, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i, String str2, String str3, Float f2, int i2, boolean z, long j2, long j3) throws Exception {
        c cVar;
        f fVar2 = fVar;
        String str4 = str3;
        c a2 = c.a(str2);
        if (str4 == null) {
            cVar = null;
        } else {
            cVar = c.a(str4.replace("-", ""));
        }
        c cVar2 = cVar;
        c a3 = yVar.a();
        if (a3 == null) {
            c.h().a("CrashlyticsCore", "No log data to include with this event.");
        }
        yVar.c();
        fVar2.g(10, 2);
        fVar2.k(a(j, str, asVar, thread, stackTraceElementArr, threadArr, list, 8, map, runningAppProcessInfo, i, a2, cVar2, f2, i2, z, j2, j3, a3));
        fVar2.a(1, j);
        fVar2.a(2, c.a(str));
        a(fVar, asVar, thread, stackTraceElementArr, threadArr, list, 8, a2, cVar2, map, runningAppProcessInfo, i);
        a(fVar, f2, i2, z, i, j2, j3);
        a(fVar2, a3);
    }

    private static void a(f fVar, as asVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, c cVar, c cVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) throws Exception {
        fVar.g(3, 2);
        fVar.k(a(asVar, thread, stackTraceElementArr, threadArr, list, i, cVar, cVar2, map, runningAppProcessInfo, i2));
        a(fVar, asVar, thread, stackTraceElementArr, threadArr, list, i, cVar, cVar2);
        if (map != null && !map.isEmpty()) {
            a(fVar, map);
        }
        if (runningAppProcessInfo != null) {
            fVar.a(3, runningAppProcessInfo.importance != 100);
        }
        fVar.a(4, i2);
    }

    private static void a(f fVar, as asVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, c cVar, c cVar2) throws Exception {
        fVar.g(1, 2);
        fVar.k(a(asVar, thread, stackTraceElementArr, threadArr, list, i, cVar, cVar2));
        a(fVar, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            a(fVar, threadArr[i2], list.get(i2), 0, false);
        }
        a(fVar, asVar, 1, i, 2);
        fVar.g(3, 2);
        fVar.k(a());
        fVar.a(1, f6437a);
        fVar.a(2, f6437a);
        fVar.a(3, 0);
        fVar.g(4, 2);
        fVar.k(a(cVar, cVar2));
        fVar.a(1, 0);
        fVar.a(2, 0);
        fVar.a(3, cVar);
        if (cVar2 != null) {
            fVar.a(4, cVar2);
        }
    }

    private static void a(f fVar, Map<String, String> map) throws Exception {
        for (Map.Entry next : map.entrySet()) {
            fVar.g(2, 2);
            fVar.k(a((String) next.getKey(), (String) next.getValue()));
            fVar.a(1, c.a((String) next.getKey()));
            String str = (String) next.getValue();
            if (str == null) {
                str = "";
            }
            fVar.a(2, c.a(str));
        }
    }

    private static void a(f fVar, as asVar, int i, int i2, int i3) throws Exception {
        fVar.g(i3, 2);
        fVar.k(a(asVar, 1, i2));
        fVar.a(1, c.a(asVar.f6443b));
        String str = asVar.f6442a;
        if (str != null) {
            fVar.a(3, c.a(str));
        }
        int i4 = 0;
        for (StackTraceElement a2 : asVar.f6444c) {
            a(fVar, 4, a2, true);
        }
        as asVar2 = asVar.f6445d;
        if (asVar2 == null) {
            return;
        }
        if (i < i2) {
            a(fVar, asVar2, i + 1, i2, 6);
            return;
        }
        while (asVar2 != null) {
            asVar2 = asVar2.f6445d;
            i4++;
        }
        fVar.a(7, i4);
    }

    private static void a(f fVar, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) throws Exception {
        fVar.g(1, 2);
        fVar.k(a(thread, stackTraceElementArr, i, z));
        fVar.a(1, c.a(thread.getName()));
        fVar.a(2, i);
        for (StackTraceElement a2 : stackTraceElementArr) {
            a(fVar, 3, a2, z);
        }
    }

    private static void a(f fVar, int i, StackTraceElement stackTraceElement, boolean z) throws Exception {
        fVar.g(i, 2);
        fVar.k(a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            fVar.a(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            fVar.a(1, 0);
        }
        fVar.a(2, c.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            fVar.a(3, c.a(stackTraceElement.getFileName()));
        }
        int i2 = 4;
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            fVar.a(4, (long) stackTraceElement.getLineNumber());
        }
        if (!z) {
            i2 = 0;
        }
        fVar.a(5, i2);
    }

    private static void a(f fVar, Float f2, int i, boolean z, int i2, long j, long j2) throws Exception {
        fVar.g(5, 2);
        fVar.k(a(f2, i, z, i2, j, j2));
        if (f2 != null) {
            fVar.a(1, f2.floatValue());
        }
        fVar.c(2, i);
        fVar.a(3, z);
        fVar.a(4, i2);
        fVar.a(5, j);
        fVar.a(6, j2);
    }

    private static void a(f fVar, c cVar) throws Exception {
        if (cVar != null) {
            fVar.g(6, 2);
            fVar.k(b(cVar));
            fVar.a(1, cVar);
        }
    }

    private static int a(c cVar, c cVar2, c cVar3, c cVar4, c cVar5, int i, c cVar6) {
        int a2 = a(cVar2);
        int b2 = f.b(1, cVar) + 0 + f.b(2, cVar3) + f.b(3, cVar4) + f.j(5) + f.l(a2) + a2 + f.b(6, cVar5);
        if (cVar6 != null) {
            b2 = b2 + f.b(8, f6438b) + f.b(9, cVar6);
        }
        return b2 + f.e(10, i);
    }

    private static int a(c cVar) {
        return f.b(1, cVar) + 0;
    }

    private static int a(c cVar, c cVar2, boolean z) {
        return f.e(1, 3) + 0 + f.b(2, cVar) + f.b(3, cVar2) + f.b(4, z);
    }

    private static int a(p.a aVar, String str) {
        return f.e(1, aVar.protobufIndex) + f.b(2, c.a(str));
    }

    private static int a(int i, c cVar, int i2, long j, long j2, boolean z, Map<p.a, String> map, int i3, c cVar2, c cVar3) {
        int i4;
        int i5;
        int i6 = 0;
        int e2 = f.e(3, i) + 0;
        if (cVar == null) {
            i4 = 0;
        } else {
            i4 = f.b(4, cVar);
        }
        int d2 = e2 + i4 + f.d(5, i2) + f.b(6, j) + f.b(7, j2) + f.b(10, z);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                int a2 = a((p.a) next.getKey(), (String) next.getValue());
                d2 += f.j(11) + f.l(a2) + a2;
            }
        }
        int d3 = d2 + f.d(12, i3);
        if (cVar2 == null) {
            i5 = 0;
        } else {
            i5 = f.b(13, cVar2);
        }
        int i7 = d3 + i5;
        if (cVar3 != null) {
            i6 = f.b(14, cVar3);
        }
        return i7 + i6;
    }

    private static int a(c cVar, c cVar2) {
        int b2 = f.b(1, 0) + 0 + f.b(2, 0) + f.b(3, cVar);
        return cVar2 != null ? b2 + f.b(4, cVar2) : b2;
    }

    private static int a(long j, String str, as asVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2, c cVar, c cVar2, Float f2, int i3, boolean z, long j2, long j3, c cVar3) {
        long j4 = j;
        int b2 = f.b(1, j) + 0 + f.b(2, c.a(str));
        int a2 = a(asVar, thread, stackTraceElementArr, threadArr, list, i, cVar, cVar2, map, runningAppProcessInfo, i2);
        int a3 = a(f2, i3, z, i2, j2, j3);
        int j5 = b2 + f.j(3) + f.l(a2) + a2 + f.j(5) + f.l(a3) + a3;
        if (cVar3 == null) {
            return j5;
        }
        int b3 = b(cVar3);
        return j5 + f.j(6) + f.l(b3) + b3;
    }

    private static int a(as asVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, c cVar, c cVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int a2 = a(asVar, thread, stackTraceElementArr, threadArr, list, i, cVar, cVar2);
        int j = f.j(1) + f.l(a2) + a2;
        boolean z = false;
        int i3 = j + 0;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                int a3 = a((String) next.getKey(), (String) next.getValue());
                i3 += f.j(2) + f.l(a3) + a3;
            }
        }
        if (runningAppProcessInfo != null) {
            if (runningAppProcessInfo.importance != 100) {
                z = true;
            }
            i3 += f.b(3, z);
        }
        return i3 + f.d(4, i2);
    }

    private static int a(as asVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, c cVar, c cVar2) {
        int a2 = a(thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        int j = f.j(1) + f.l(a2) + a2 + 0;
        for (int i2 = 0; i2 < length; i2++) {
            int a3 = a(threadArr[i2], list.get(i2), 0, false);
            j += f.j(1) + f.l(a3) + a3;
        }
        int a4 = a(asVar, 1, i);
        int a5 = a();
        int a6 = a(cVar, cVar2);
        return j + f.j(2) + f.l(a4) + a4 + f.j(3) + f.l(a5) + a5 + f.j(3) + f.l(a6) + a6;
    }

    private static int a(String str, String str2) {
        int b2 = f.b(1, c.a(str));
        if (str2 == null) {
            str2 = "";
        }
        return b2 + f.b(2, c.a(str2));
    }

    private static int a(Float f2, int i, boolean z, int i2, long j, long j2) {
        int i3 = 0;
        if (f2 != null) {
            i3 = 0 + f.b(1, f2.floatValue());
        }
        return i3 + f.f(2, i) + f.b(3, z) + f.d(4, i2) + f.b(5, j) + f.b(6, j2);
    }

    private static int b(c cVar) {
        return f.b(1, cVar);
    }

    private static int a(as asVar, int i, int i2) {
        int i3 = 0;
        int b2 = f.b(1, c.a(asVar.f6443b)) + 0;
        String str = asVar.f6442a;
        if (str != null) {
            b2 += f.b(3, c.a(str));
        }
        int i4 = b2;
        for (StackTraceElement a2 : asVar.f6444c) {
            int a3 = a(a2, true);
            i4 += f.j(4) + f.l(a3) + a3;
        }
        as asVar2 = asVar.f6445d;
        if (asVar2 == null) {
            return i4;
        }
        if (i < i2) {
            int a4 = a(asVar2, i + 1, i2);
            return i4 + f.j(6) + f.l(a4) + a4;
        }
        while (asVar2 != null) {
            asVar2 = asVar2.f6445d;
            i3++;
        }
        return i4 + f.d(7, i3);
    }

    private static int a() {
        return f.b(1, f6437a) + 0 + f.b(2, f6437a) + f.b(3, 0);
    }

    private static int a(StackTraceElement stackTraceElement, boolean z) {
        int i;
        int i2 = 0;
        if (stackTraceElement.isNativeMethod()) {
            i = f.b(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            i = f.b(1, 0);
        }
        int b2 = i + 0 + f.b(2, c.a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            b2 += f.b(3, c.a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            b2 += f.b(4, (long) stackTraceElement.getLineNumber());
        }
        if (z) {
            i2 = 2;
        }
        return b2 + f.d(5, i2);
    }

    private static int a(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int b2 = f.b(1, c.a(thread.getName())) + f.d(2, i);
        for (StackTraceElement a2 : stackTraceElementArr) {
            int a3 = a(a2, z);
            b2 += f.j(3) + f.l(a3) + a3;
        }
        return b2;
    }

    private static c a(String str) {
        if (str == null) {
            return null;
        }
        return c.a(str);
    }
}
