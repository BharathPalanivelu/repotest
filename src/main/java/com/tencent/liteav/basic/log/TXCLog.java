package com.tencent.liteav.basic.log;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.liteav.basic.util.b;

public class TXCLog {
    public static final int LOG_ASYNC = 0;
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 4;
    public static final int LOG_FATAL = 5;
    public static final int LOG_INFO = 2;
    public static final int LOG_NONE = 6;
    public static final int LOG_SYNC = 1;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARNING = 3;
    private static boolean mEnableCallback = false;
    private static boolean mEnableCompress = true;
    private static boolean mEnableConsole = true;
    private static boolean mHasInit = false;
    private static a mListener = null;
    public static String mLogDir = "";
    private static int mLogLevel = 0;
    private static final Object mLogLock = new Object();

    public interface a {
        void a(int i, String str, String str2);
    }

    private static native void nativeEnableCallback(boolean z);

    private static native String nativeGetLogFilePath();

    private static native void nativeLog(int i, String str, String str2, int i2, String str3, String str4);

    private static native void nativeLogClose();

    private static native void nativeLogInit();

    private static native void nativeLogOpen(int i, String str, String str2, boolean z);

    private static native void nativeLogSetConsole(boolean z);

    private static native void nativeLogSetLevel(int i);

    public static boolean init() {
        synchronized (mLogLock) {
            if (!mHasInit) {
                if (TextUtils.isEmpty(mLogDir)) {
                    mLogDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/log/tencent/liteav";
                }
                if (b.f()) {
                    nativeLogInit();
                    nativeLogSetLevel(mLogLevel);
                    nativeLogSetConsole(mEnableConsole);
                    nativeLogOpen(0, mLogDir, "LiteAV", mEnableCompress);
                    nativeEnableCallback(mEnableCallback);
                    mHasInit = true;
                }
            }
        }
        return mHasInit;
    }

    public static void log(int i, String str, String str2) {
        if (mLogLevel <= i) {
            if (init()) {
                nativeLog(i, str, "", 0, "", str2);
            }
            log_callback(i, str, str2);
        }
    }

    public static void setLevel(int i) {
        mLogLevel = i;
        synchronized (mLogLock) {
            if (mHasInit) {
                nativeLogSetLevel(mLogLevel);
            }
        }
    }

    public static void setLogDirPath(String str) {
        if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase(mLogDir)) {
            mLogDir = str;
            synchronized (mLogLock) {
                if (mHasInit) {
                    nativeLogClose();
                    mHasInit = false;
                    init();
                }
            }
            a.a().b();
        }
    }

    public static void setLogCompressEnabled(boolean z) {
        if (mEnableCompress != z) {
            mEnableCompress = z;
            synchronized (mLogLock) {
                if (mHasInit) {
                    nativeLogClose();
                    mHasInit = false;
                    init();
                }
            }
        }
    }

    public static void setConsoleEnabled(boolean z) {
        mEnableConsole = z;
        synchronized (mLogLock) {
            if (mHasInit) {
                nativeLogSetConsole(mEnableConsole);
            }
        }
    }

    public static void setListener(a aVar) {
        mListener = aVar;
        mEnableCallback = mListener != null;
        synchronized (mLogLock) {
            if (mHasInit) {
                nativeEnableCallback(mEnableCallback);
            }
        }
    }

    public static String getLogFilePath() {
        return nativeGetLogFilePath();
    }

    public static void v(String str, String str2) {
        log(0, str, str2);
    }

    public static void d(String str, String str2) {
        log(1, str, str2);
    }

    public static void i(String str, String str2) {
        log(2, str, str2);
    }

    public static void w(String str, String str2) {
        log(3, str, str2);
    }

    public static void e(String str, String str2) {
        log(4, str, str2);
    }

    private static void log_callback(int i, String str, String str2) {
        a aVar = mListener;
        if (aVar != null) {
            aVar.a(i, str, str2);
        }
    }
}
