package com.garena.android.appkit.d;

import android.text.TextUtils;
import android.util.Log;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Locale;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f6688a = "default";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f6689b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f6690c = false;

    public static void a(String str, Object... objArr) {
        if (!f6689b) {
            try {
                String f2 = f(str, objArr);
                Log.e(f6688a, f2);
                if (f2.contains("UnknownFormatConversionException")) {
                    a("OK", new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void b(String str, Object... objArr) {
        if (!f6689b) {
            try {
                String f2 = f(str, objArr);
                Log.d(f6688a, f2);
                if (f2.contains("UnknownFormatConversionException")) {
                    b("OK", new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void c(String str, Object... objArr) {
        if (!f6689b) {
            try {
                String f2 = f(str, objArr);
                Log.w(f6688a, f2);
                if (f2.contains("UnknownFormatConversionException")) {
                    c("OK", new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void d(String str, Object... objArr) {
        if (!f6689b) {
            try {
                String f2 = f(str, objArr);
                Log.v(f6688a, f2);
                if (f2.contains("UnknownFormatConversionException")) {
                    d("OK", new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void e(String str, Object... objArr) {
        if (!f6689b) {
            try {
                if (!f6690c) {
                    a();
                }
                Log.i(f6688a, f(str, objArr));
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Throwable th) {
        if (!f6689b) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= stackTrace.length) {
                    break;
                } else if (stackTrace[i2].getMethodName().compareTo("e") == 0) {
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            if (i >= 0) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(".") + 1);
                String methodName = stackTrace[i].getMethodName();
                String valueOf = String.valueOf(stackTrace[i].getLineNumber());
                Log.e(f6688a, String.format(Locale.US, "position at %s.%s(%s.java:%s)", new Object[]{className, methodName, substring, valueOf}));
                return;
            }
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            Log.e(f6688a, stringWriter.toString());
        }
    }

    private static void a() {
        int i;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i2 = 0;
        while (true) {
            if (i2 >= stackTrace.length) {
                i = -1;
                break;
            } else if (stackTrace[i2].getMethodName().compareTo("i") == 0) {
                i = i2 + 1;
                break;
            } else {
                i2++;
            }
        }
        if (i == -1) {
            Log.i(f6688a, "CANNOT GENERATE DEBUG");
            return;
        }
        String className = stackTrace[i].getClassName();
        String substring = className.substring(className.lastIndexOf(".") + 1);
        String methodName = stackTrace[i].getMethodName();
        String valueOf = String.valueOf(stackTrace[i].getLineNumber());
        Log.i(f6688a, String.format(Locale.US, "position at %s.%s(%s.java:%s)", new Object[]{className, methodName, substring, valueOf}));
    }

    private static String b() {
        return String.format(Locale.ENGLISH, "[thread_id:%d name=%s] ", new Object[]{Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName()});
    }

    private static String f(String str, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (objArr == null || objArr.length <= 0) {
            return c() + b() + str;
        }
        try {
            return c() + b() + String.format(Locale.ENGLISH, str, objArr);
        } catch (Exception e2) {
            a(e2);
            return c() + b() + str;
        }
    }

    private static String c() {
        int i;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i2 = 0;
        while (true) {
            if (i2 >= stackTrace.length) {
                i = -1;
                break;
            }
            if (stackTrace[i2].getClassName().equals(a.class.getName())) {
                String methodName = stackTrace[i2].getMethodName();
                if (methodName.equals("e") || methodName.equals("w") || methodName.equals("i") || methodName.equals("d") || methodName.equals("v")) {
                    i = i2 + 1;
                }
            }
            i2++;
        }
        i = i2 + 1;
        if (i == -1) {
            Log.v(f6688a, "CANNOT GENERATE LINE INFO");
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[i];
        String className = stackTraceElement.getClassName();
        String substring = className.substring(className.lastIndexOf(".") + 1);
        return stackTraceElement.getMethodName() + SQLBuilder.PARENTHESES_LEFT + substring + ".java:" + stackTraceElement.getLineNumber() + "): ";
    }
}
