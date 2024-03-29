package com.tencent.imsdk.log;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import com.tencent.imcore.IMCore;
import com.tencent.imcore.LogLevel;
import com.tencent.imsdk.IMCoreWrapper;
import com.tencent.imsdk.IMMsfCoreProxy;
import com.tencent.imsdk.TIMLogLevel;
import com.tencent.imsdk.TIMLogListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class QLog {
    public static final int CLR = 2;
    public static final int DEV = 4;
    public static final String ERR_KEY = "imsdk_error|";
    public static final int LOG_ITEM_MAX_CACHE_SIZE = 50;
    public static final int USR = 1;
    /* access modifiers changed from: private */
    public static Lock lock = new ReentrantLock();
    private static String logDate = "";
    public static String sBuildNumber = "";
    /* access modifiers changed from: private */
    public static FileWriter writer;

    public static void d(String str, int i, String str2) {
        try {
            if (IMMsfCoreProxy.get().getMode() != 1 || !IMCoreWrapper.get().isIMCoreInited()) {
                writeInitLogToFile(str, TIMLogLevel.DEBUG, str2);
                QLogImpl.d(str, i, str2, (Throwable) null);
                return;
            }
            IMCore.get().lOGGERLOG(LogLevel.kDebug.swigValue(), "", 0, "", str, str2);
        } catch (Throwable th) {
            QLogImpl.e(str, i, getStackTraceString(th));
        }
    }

    public static void d(String str, int i, String str2, Throwable th) {
        QLogImpl.d(str, i, str2, th);
    }

    public static void dfile(String str, int i, String str2) {
        try {
            if (IMMsfCoreProxy.get().getMode() != 1 || !IMCoreWrapper.get().isIMCoreInited()) {
                writeInitLogToFile(str, TIMLogLevel.DEBUG, str2);
                QLogImpl.dfile(str, i, str2);
                return;
            }
            IMCore.get().lOGGERLOG(LogLevel.kDebug.swigValue(), "", 0, "", str, str2);
        } catch (Throwable th) {
            QLogImpl.e(str, i, getStackTraceString(th));
        }
    }

    public static void e(String str, int i, String str2) {
        try {
            if (IMMsfCoreProxy.get().getMode() != 1 || !IMCoreWrapper.get().isIMCoreInited()) {
                writeInitLogToFile(str, TIMLogLevel.ERROR, str2);
                QLogImpl.e(str, i, str2, (Throwable) null);
                return;
            }
            IMCore.get().lOGGERLOG(LogLevel.kError.swigValue(), "", 0, "", str, str2);
        } catch (Throwable th) {
            QLogImpl.e(str, i, getStackTraceString(th));
        }
    }

    public static void e(String str, int i, String str2, Throwable th) {
        QLogImpl.e(str, i, str2, th);
    }

    public static void efile(String str, int i, String str2) {
        try {
            if (IMMsfCoreProxy.get().getMode() != 1 || !IMCoreWrapper.get().isIMCoreInited()) {
                writeInitLogToFile(str, TIMLogLevel.ERROR, str2);
                QLogImpl.efile(str, i, str2);
                return;
            }
            IMCore.get().lOGGERLOG(LogLevel.kError.swigValue(), "", 0, "", str, str2);
        } catch (Throwable th) {
            QLogImpl.e(str, i, getStackTraceString(th));
        }
    }

    public static String getStackTraceString(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static void i(String str, int i, String str2) {
        try {
            if (IMMsfCoreProxy.get().getMode() != 1 || !IMCoreWrapper.get().isIMCoreInited()) {
                writeInitLogToFile(str, TIMLogLevel.INFO, str2);
                QLogImpl.i(str, i, str2, (Throwable) null);
                return;
            }
            IMCore.get().lOGGERLOG(LogLevel.kInfo.swigValue(), "", 0, "", str, str2);
        } catch (Throwable th) {
            QLogImpl.e(str, i, getStackTraceString(th));
        }
    }

    public static void i(String str, int i, String str2, Throwable th) {
        QLogImpl.i(str, i, str2, th);
    }

    public static void ifile(String str, int i, String str2) {
        try {
            if (IMMsfCoreProxy.get().getMode() != 1 || !IMCoreWrapper.get().isIMCoreInited()) {
                writeInitLogToFile(str, TIMLogLevel.INFO, str2);
                QLogImpl.ifile(str, i, str2);
                return;
            }
            IMCore.get().lOGGERLOG(LogLevel.kInfo.swigValue(), "", 0, "", str, str2);
        } catch (Throwable th) {
            QLogImpl.e(str, i, getStackTraceString(th));
        }
    }

    public static void init(Context context) {
        QLogImpl.init(context);
    }

    /* access modifiers changed from: private */
    public static void initLogFile(long j) throws IOException {
        String charSequence = DateFormat.format("yyyyMMdd", j).toString();
        if (logDate.isEmpty() || !charSequence.equals(logDate) || writer == null) {
            logDate = charSequence;
            String logPath = IMMsfCoreProxy.get().getSdkConfig().getLogPath();
            if (TextUtils.isEmpty(logPath)) {
                logPath = IMMsfCoreProxy.get().initLogPath(logPath);
            }
            writer = new FileWriter(logPath + "imsdk_" + logDate + ".log", true);
        }
    }

    public static boolean isColorLevel() {
        return QLogImpl.isColorUser();
    }

    public static boolean isDevelopLevel() {
        return QLogImpl.isDEVELOPER();
    }

    public static void p(String str, String str2) {
        QLogImpl.p(str, str2);
    }

    public static void setSdkLogListener(TIMLogListener tIMLogListener) {
        QLogImpl.setSdkLogListener(tIMLogListener);
    }

    public static void w(String str, int i, String str2) {
        try {
            if (IMMsfCoreProxy.get().getMode() != 1 || !IMCoreWrapper.get().isIMCoreInited()) {
                writeInitLogToFile(str, TIMLogLevel.WARN, str2);
                QLogImpl.w(str, i, str2, (Throwable) null);
                return;
            }
            IMCore.get().lOGGERLOG(LogLevel.kWarn.swigValue(), "", 0, "", str, str2);
        } catch (Throwable th) {
            QLogImpl.e(str, i, getStackTraceString(th));
        }
    }

    public static void w(String str, int i, String str2, Throwable th) {
        QLogImpl.w(str, i, str2, th);
    }

    public static void wfile(String str, int i, String str2) {
        try {
            if (IMMsfCoreProxy.get().getMode() != 1 || !IMCoreWrapper.get().isIMCoreInited()) {
                writeInitLogToFile(str, TIMLogLevel.WARN, str2);
                QLogImpl.wfile(str, i, str2);
                return;
            }
            IMCore.get().lOGGERLOG(LogLevel.kWarn.swigValue(), "", 0, "", str, str2);
        } catch (Throwable th) {
            QLogImpl.e(str, i, getStackTraceString(th));
        }
    }

    private static void writeInitLogToFile(String str, TIMLogLevel tIMLogLevel, String str2) {
        new Thread(new ad(tIMLogLevel, str, str2), "LogThread").start();
    }
}
