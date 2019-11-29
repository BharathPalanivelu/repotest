package com.appsflyer;

import android.util.Log;
import com.appsflyer.internal.x;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.qcloud.core.http.HttpMetric;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class AFLogger {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static long f25 = System.currentTimeMillis();

    public static void afInfoLog(String str, boolean z) {
        if (LogLevel.INFO.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            Log.i(AppsFlyerLibCore.LOG_TAG, m38(str, false));
        }
        if (z) {
            if (x.f258 == null) {
                x.f258 = new x();
            }
            x.f258.m205((String) null, "I", m38(str, true));
        }
    }

    public static void resetDeltaTime() {
        f25 = System.currentTimeMillis();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static String m38(String str, boolean z) {
        if (!z && LogLevel.VERBOSE.getLevel() > AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            return str;
        }
        StringBuilder sb = new StringBuilder(SQLBuilder.PARENTHESES_LEFT);
        sb.append(m37(System.currentTimeMillis() - f25));
        sb.append(") [");
        sb.append(Thread.currentThread().getName());
        sb.append("] ");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m35(String str, Throwable th, boolean z) {
        String[] strArr;
        if ((LogLevel.ERROR.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) && z) {
            Log.e(AppsFlyerLibCore.LOG_TAG, m38(str, false), th);
        }
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x xVar = x.f258;
        Throwable cause = th.getCause();
        String simpleName = th.getClass().getSimpleName();
        String message = cause == null ? th.getMessage() : cause.getMessage();
        StackTraceElement[] stackTrace = cause == null ? th.getStackTrace() : cause.getStackTrace();
        if (stackTrace == null) {
            strArr = new String[]{message};
        } else {
            String[] strArr2 = new String[(stackTrace.length + 1)];
            strArr2[0] = message;
            for (int i = 1; i < stackTrace.length; i++) {
                strArr2[i] = stackTrace[i].toString();
            }
            strArr = strArr2;
        }
        xVar.m205(HttpMetric.ATTR_EXCEPTION, simpleName, strArr);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static void m36(String str) {
        if (LogLevel.WARNING.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            Log.w(AppsFlyerLibCore.LOG_TAG, m38(str, false));
        }
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205((String) null, "W", m38(str, true));
    }

    public static void afRDLog(String str) {
        if (LogLevel.VERBOSE.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            Log.v(AppsFlyerLibCore.LOG_TAG, m38(str, false));
        }
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205((String) null, "V", m38(str, true));
    }

    public static void afInfoLog(String str) {
        afInfoLog(str, true);
    }

    public static void afErrorLog(String str, Throwable th) {
        m35(str, th, false);
    }

    public static void afErrorLog(String str, Throwable th, boolean z) {
        m35(str, th, z);
    }

    public static void afWarnLog(String str) {
        m36(str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static String m37(long j) {
        long hours = TimeUnit.MILLISECONDS.toHours(j);
        long millis = j - TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        long millis2 = millis - TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis2);
        long millis3 = TimeUnit.MILLISECONDS.toMillis(millis2 - TimeUnit.SECONDS.toMillis(seconds));
        return String.format(Locale.getDefault(), "%02d:%02d:%02d:%03d", new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(millis3)});
    }

    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);
        

        /* renamed from: ˏ  reason: contains not printable characters */
        private int f27;

        private LogLevel(int i) {
            this.f27 = i;
        }

        public final int getLevel() {
            return this.f27;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static void m34(String str) {
        if (!AppsFlyerProperties.getInstance().isLogsDisabledCompletely()) {
            Log.d(AppsFlyerLibCore.LOG_TAG, m38(str, false));
        }
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205((String) null, "F", str);
    }

    public static void afDebugLog(String str) {
        if (LogLevel.DEBUG.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            Log.d(AppsFlyerLibCore.LOG_TAG, m38(str, false));
        }
        if (x.f258 == null) {
            x.f258 = new x();
        }
        x.f258.m205((String) null, "D", m38(str, true));
    }
}
