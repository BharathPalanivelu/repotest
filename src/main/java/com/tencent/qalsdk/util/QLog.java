package com.tencent.qalsdk.util;

import android.content.Context;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.tencent.qalsdk.QALLogListener;
import com.tencent.qalsdk.sdk.m;

public class QLog {
    public static final int CLR = 2;
    public static final int DEV = 4;
    public static final int LOG_DEBUG = 5;
    public static final int LOG_ERROR = 2;
    public static final int LOG_INFO = 4;
    public static final int LOG_ITEM_MAX_CACHE_SIZE = 50;
    public static final int LOG_OFF = 1;
    public static final int LOG_WARN = 3;
    public static final int USR = 1;
    public static final int defaultLogLevel = 5;
    static m helper = new m();
    private static int outputLogLevel = 5;
    public static String sBuildNumber = "";
    private static QALLogListener sdkLogLister;

    public static boolean isColorLevel() {
        return true;
    }

    public static boolean isDevelopLevel() {
        return false;
    }

    public static void init(Context context) {
        helper.a(context, ServerProtocol.DIALOG_PARAM_SDK_VERSION);
    }

    public static int getOutputLogLevel() {
        return outputLogLevel;
    }

    public static void setOutputLogLevel(int i) {
        i("QLog", "set service log level:" + i);
        outputLogLevel = i;
    }

    public static String getLogFileName(long j) {
        m mVar = helper;
        return mVar.a(mVar.a(j));
    }

    public static String getLogBasePath() {
        return helper.a();
    }

    public static void setSdkLogListener(QALLogListener qALLogListener) {
        sdkLogLister = qALLogListener;
    }

    public static String getFilePath() {
        return helper.b();
    }

    public static String getStackTraceString(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static void e(String str, String str2) {
        e(str, 0, str2, (Throwable) null);
    }

    public static void w(String str, String str2) {
        w(str, 0, str2, (Throwable) null);
    }

    public static void i(String str, String str2) {
        i(str, 0, str2, (Throwable) null);
    }

    public static void d(String str, String str2) {
        d(str, 0, str2, (Throwable) null);
    }

    public static void e(String str, int i, String str2) {
        e(str, i, str2, (Throwable) null);
    }

    public static void w(String str, int i, String str2) {
        w(str, i, str2, (Throwable) null);
    }

    public static void i(String str, int i, String str2) {
        i(str, i, str2, (Throwable) null);
    }

    public static void d(String str, int i, String str2) {
        d(str, i, str2, (Throwable) null);
    }

    public static void e(String str, int i, String str2, Throwable th) {
        if (outputLogLevel >= 2) {
            if (th == null) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, th);
            }
            m mVar = helper;
            mVar.a(str, "[E] " + str2, th);
            QALLogListener qALLogListener = sdkLogLister;
            if (qALLogListener != null) {
                qALLogListener.log(2, str, str2);
            }
        }
    }

    public static void w(String str, int i, String str2, Throwable th) {
        if (outputLogLevel >= 3) {
            if (th == null) {
                Log.w(str, str2);
            } else {
                Log.w(str, str2, th);
            }
            m mVar = helper;
            mVar.a(str, "[W] " + str2, th);
            QALLogListener qALLogListener = sdkLogLister;
            if (qALLogListener != null) {
                qALLogListener.log(3, str, str2);
            }
        }
    }

    public static void i(String str, int i, String str2, Throwable th) {
        if (outputLogLevel >= 4) {
            if (th == null) {
                Log.i(str, str2);
            } else {
                Log.i(str, str2, th);
            }
            m mVar = helper;
            mVar.a(str, "[I] " + str2, th);
            QALLogListener qALLogListener = sdkLogLister;
            if (qALLogListener != null) {
                qALLogListener.log(4, str, str2);
            }
        }
    }

    public static void d(String str, int i, String str2, Throwable th) {
        if (outputLogLevel >= 5) {
            if (th == null) {
                Log.d(str, str2);
            } else {
                Log.d(str, str2, th);
            }
        }
        if (outputLogLevel >= 2 && i == 1) {
            helper.a(str, str2, th);
            QALLogListener qALLogListener = sdkLogLister;
            if (qALLogListener != null) {
                qALLogListener.log(5, str, str2);
            }
        }
    }
}
