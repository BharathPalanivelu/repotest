package com.salesforce.android.service.common.utilities.logging;

import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;

public class ServiceLogging {
    public static final int LEVEL_DEBUG = 2;
    public static final int LEVEL_ERROR = 5;
    public static final int LEVEL_INFO = 3;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_TRACE = 1;
    public static final int LEVEL_WARN = 4;
    public static final ServiceLoggingSink LOG_CAT_SINK = new LogCatSink();
    private static final Set<String> sDisabledChannels = new HashSet();
    private static int sLogLevel = 6;
    private static final Set<ServiceLoggingSink> sSinks = new HashSet();

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    private ServiceLogging() {
    }

    public static ServiceLogger getLogger(Class<?> cls) {
        return getLogger(cls, (String) null);
    }

    public static ServiceLogger getLogger(Class<?> cls, String str) {
        return ServiceLoggerImpl.create(cls.getSimpleName(), str);
    }

    public static void addSink(ServiceLoggingSink serviceLoggingSink) {
        sSinks.add(serviceLoggingSink);
    }

    public static void setLogLevel(int i) {
        sLogLevel = i;
    }

    public static int getLogLevel() {
        return sLogLevel;
    }

    public static void setChannelEnabled(String str, boolean z) {
        if (z) {
            sDisabledChannels.remove(str);
        } else {
            sDisabledChannels.add(str);
        }
    }

    static Set<ServiceLoggingSink> getSinks() {
        return sSinks;
    }

    static boolean isChannelEnabled(String str) {
        return !sDisabledChannels.contains(str);
    }

    private static class LogCatSink implements ServiceLoggingSink {
        LogCatSink() {
        }

        public void handleMessage(int i, String str, String str2) {
            if (i == 1) {
                Log.v(str, str2);
            } else if (i == 2) {
                Log.d(str, str2);
            } else if (i == 3) {
                Log.i(str, str2);
            } else if (i == 4) {
                Log.w(str, str2);
            } else if (i == 5) {
                Log.e(str, str2);
            }
        }
    }
}
