package com.tencent.qcloud.core.logger;

public interface LogAdapter {
    boolean isLoggable(int i, String str);

    void log(int i, String str, String str2, Throwable th);
}
