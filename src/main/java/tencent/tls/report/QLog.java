package tencent.tls.report;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import tencent.tls.tools.util;

public class QLog {
    private static final int DEBUG = 4;
    private static final int ERROR = 1;
    private static final int INFO = 3;
    public static final String TAG = "tls_sdk";
    private static final int WARN = 2;
    private static Method info;
    private static Method log;
    private static Object tim;

    public static void init() {
        try {
            tim = Class.forName("com.tencent.TIMManager").getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
            log = tim.getClass().getMethod("log", new Class[]{Integer.TYPE, String.class, String.class});
        } catch (Exception e2) {
            e(e2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:3|4|5|6|7|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
        e(r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void initQAL() {
        /*
            java.lang.reflect.Method r0 = info
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.String r0 = "com.tencent.qalsdk.util.QLog"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r1 = "i"
            r2 = 3
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0026 }
            r3 = 0
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r2[r3] = r4     // Catch:{ Exception -> 0x0026 }
            r3 = 1
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0026 }
            r2[r3] = r4     // Catch:{ Exception -> 0x0026 }
            r3 = 2
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r2[r3] = r4     // Catch:{ Exception -> 0x0026 }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch:{ Exception -> 0x0026 }
            info = r0     // Catch:{ Exception -> 0x0026 }
            goto L_0x002e
        L_0x0026:
            init()     // Catch:{ Exception -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r0 = move-exception
            e(r0)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tencent.tls.report.QLog.initQAL():void");
    }

    private static void doit(int i, String str) {
        if (i == 1 || util.LOGCAT_OUT) {
            try {
                if (log == null) {
                    info.invoke((Object) null, new Object[]{TAG, 1, str});
                    return;
                }
                log.invoke(tim, new Object[]{Integer.valueOf(i), TAG, str});
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d(String str) {
        _d(wrapMsg(str, 0));
    }

    public static void d(String str, long j) {
        _d(wrapMsg(str, j));
    }

    private static void _d(String str) {
        doit(4, str);
    }

    public static void i(String str) {
        _i(wrapMsg(str, 0));
    }

    public static void i(String str, long j) {
        _i(wrapMsg(str, j));
    }

    private static void _i(String str) {
        doit(3, str);
    }

    public static void w(String str) {
        _w(wrapMsg(str, 0));
    }

    private static void _w(String str) {
        doit(2, str);
    }

    public static void e(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        th.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        doit(1, stringWriter.toString());
    }

    private static String wrapMsg(String str, long j) {
        String str2;
        if (j != 0) {
            str2 = "[" + Long.toHexString(j) + "]";
        } else {
            str2 = "";
        }
        return util.getLineInfo(3) + str2 + str;
    }
}
