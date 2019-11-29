package com.tencent.imcore;

public enum LogLevel {
    kOff((String) 0),
    kError,
    kWarn,
    kInfo,
    kDebug;
    
    private final int swigValue;

    private static class aa {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static int f30648a;

        static /* synthetic */ int a() {
            int i = f30648a;
            f30648a = i + 1;
            return i;
        }
    }

    private LogLevel(int i) {
        this.swigValue = i;
        int unused = aa.f30648a = i + 1;
    }

    private LogLevel(LogLevel logLevel) {
        this.swigValue = logLevel.swigValue;
        int unused = aa.f30648a = this.swigValue + 1;
    }

    public static LogLevel swigToEnum(int i) {
        LogLevel[] logLevelArr = (LogLevel[]) LogLevel.class.getEnumConstants();
        if (i < logLevelArr.length && i >= 0 && logLevelArr[i].swigValue == i) {
            return logLevelArr[i];
        }
        for (LogLevel logLevel : logLevelArr) {
            if (logLevel.swigValue == i) {
                return logLevel;
            }
        }
        throw new IllegalArgumentException("No enum " + LogLevel.class + " with value " + i);
    }

    public final int swigValue() {
        return this.swigValue;
    }
}
