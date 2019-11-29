package com.salesforce.android.service.common.utilities.logging;

public interface ServiceLogger {
    public static final String PLACEHOLDER = "{}";

    void debug(String str);

    void debug(String str, Object... objArr);

    void error(String str);

    void error(String str, Object... objArr);

    void info(String str);

    void info(String str, Object... objArr);

    void trace(String str);

    void trace(String str, Object... objArr);

    void warn(String str);

    void warn(String str, Object... objArr);
}
