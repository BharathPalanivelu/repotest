package com.beetalk.sdk.e;

import android.content.Context;
import android.util.Log;
import com.appsflyer.share.Constants;
import com.beetalk.sdk.f;
import com.beetalk.sdk.f.b;
import com.beetalk.sdk.g;
import com.beetalk.sdk.l;
import com.garena.e.h;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.PrintWriter;
import java.io.StringWriter;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f5401a = ("com.garena.msdk[" + g.c() + "]");

    /* renamed from: b  reason: collision with root package name */
    private static String f5402b = "";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f5403c = (l.a() == l.a.PRODUCTION);

    public static void a(Context context, String str, String str2) {
    }

    private static void a(String str, String str2, String str3) {
        try {
            String str4 = str + Constants.URL_PATH_DELIMITER + str2 + "[" + f5402b + "]";
            if (g.a() != null && g.a().a().booleanValue()) {
                h.a(str4, str3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, Object... objArr) {
        if (!l.f5466d) {
            String str2 = a() + a(String.format(str, objArr));
            Log.e(f5401a, str2);
            a("E", f5401a, str2);
        }
        if (String.format(str, objArr).contains("UnknownFormatConversionException")) {
            c("OK", new Object[0]);
        }
    }

    private static String a() {
        return String.format("[thread_id:%d name=%s] ", new Object[]{Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName()});
    }

    public static void b(String str, Object... objArr) {
        if (!l.f5466d) {
            String str2 = a() + a(String.format(str, objArr));
            Log.d(f5401a, str2);
            a("D", f5401a, str2);
        }
        if (String.format(str, objArr).contains("UnknownFormatConversionException")) {
            c("OK", new Object[0]);
        }
    }

    public static void c(String str, Object... objArr) {
        if (!l.f5466d) {
            if (!l.f5464b) {
                b();
            }
            String a2 = a(String.format(str, objArr));
            Log.i(f5401a, a2);
            a("I", f5401a, a2);
        }
    }

    private static String a(String str) {
        return f5403c ? str.replaceAll("token=\\S*", "token=ACCESS_TOKEN_REMOVED ").replaceAll("client_secret=\\S*", "client_secret=CLIENT_SECRET_REMOVED ").replaceAll("app_key=\\S*", "appKey=APP_SECRET_REMOVED ").replaceAll("access_token=\\S*", "access_token=ACCESS_TOKEN_REMOVED ").replaceAll("code=\\S*", "code=SOME_CODE_REMOVED ") : str;
    }

    public static void a(Exception exc) {
        if (!l.f5466d && exc != null) {
            StackTraceElement[] stackTrace = exc.getStackTrace();
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
                String str = "at " + className + "." + stackTrace[i].getMethodName() + SQLBuilder.PARENTHESES_LEFT + substring + ".java:" + String.valueOf(stackTrace[i].getLineNumber()) + SQLBuilder.PARENTHESES_RIGHT;
                Log.e(f5401a + " position", str);
                a("E", f5401a + " position", str);
                return;
            }
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            Log.e(f5401a, stringWriter.toString());
            a("E", f5401a, stringWriter.toString());
        }
    }

    private static void b() {
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
            Log.i(f5401a, "CANNOT GENERATE DEBUG");
            return;
        }
        String className = stackTrace[i].getClassName();
        String substring = className.substring(className.lastIndexOf(".") + 1);
        String methodName = stackTrace[i].getMethodName();
        String valueOf = String.valueOf(stackTrace[i].getLineNumber());
        Log.i(f5401a + " position", "at " + className + "." + methodName + SQLBuilder.PARENTHESES_LEFT + substring + ".java:" + valueOf + SQLBuilder.PARENTHESES_RIGHT);
    }

    public static void a(Context context, String str, String str2, Object... objArr) {
        if (context != null) {
            try {
                if (g.a() != null && g.a().a().booleanValue()) {
                    b bVar = new b(context);
                    a(context, String.format(str2, objArr) + "|ua:" + bVar.toString(), str);
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        c("not record remote log due to non-context or client log disabled on server", new Object[0]);
    }

    public static void a(String str, String str2, Object... objArr) {
        if (f.a() != null) {
            a(f.a(), str, str2, objArr);
        }
    }
}
