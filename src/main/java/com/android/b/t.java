package com.android.b;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class t {

    /* renamed from: a  reason: collision with root package name */
    public static String f4630a = "Volley";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f4631b = Log.isLoggable(f4630a, 2);

    public static void a(String str, Object... objArr) {
        if (f4631b) {
            Log.v(f4630a, e(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        Log.d(f4630a, e(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f4630a, e(str, objArr));
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f4630a, e(str, objArr), th);
    }

    public static void d(String str, Object... objArr) {
        Log.wtf(f4630a, e(str, objArr));
    }

    private static String e(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClass().equals(t.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f4632a = t.f4631b;

        /* renamed from: b  reason: collision with root package name */
        private final List<C0088a> f4633b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private boolean f4634c = false;

        a() {
        }

        /* renamed from: com.android.b.t$a$a  reason: collision with other inner class name */
        private static class C0088a {

            /* renamed from: a  reason: collision with root package name */
            public final String f4635a;

            /* renamed from: b  reason: collision with root package name */
            public final long f4636b;

            /* renamed from: c  reason: collision with root package name */
            public final long f4637c;

            public C0088a(String str, long j, long j2) {
                this.f4635a = str;
                this.f4636b = j;
                this.f4637c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (!this.f4634c) {
                this.f4633b.add(new C0088a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public synchronized void a(String str) {
            this.f4634c = true;
            long a2 = a();
            if (a2 > 0) {
                long j = this.f4633b.get(0).f4637c;
                t.b("(%-4d ms) %s", Long.valueOf(a2), str);
                for (C0088a next : this.f4633b) {
                    long j2 = next.f4637c;
                    t.b("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(next.f4636b), next.f4635a);
                    j = j2;
                }
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            if (!this.f4634c) {
                a("Request on the loose");
                t.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        private long a() {
            if (this.f4633b.size() == 0) {
                return 0;
            }
            long j = this.f4633b.get(0).f4637c;
            List<C0088a> list = this.f4633b;
            return list.get(list.size() - 1).f4637c - j;
        }
    }
}
