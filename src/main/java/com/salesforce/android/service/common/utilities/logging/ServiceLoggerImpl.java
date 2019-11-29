package com.salesforce.android.service.common.utilities.logging;

class ServiceLoggerImpl implements ServiceLogger {
    private final String mChannel;
    private final String mTag;

    static ServiceLoggerImpl create(String str, String str2) {
        return new ServiceLoggerImpl(str, str2);
    }

    private ServiceLoggerImpl(String str, String str2) {
        this.mTag = str;
        this.mChannel = str2;
    }

    public void trace(String str) {
        log(1, str);
    }

    public void trace(String str, Object... objArr) {
        log(1, str, objArr);
    }

    public void debug(String str) {
        log(2, str);
    }

    public void debug(String str, Object... objArr) {
        log(2, str, objArr);
    }

    public void info(String str) {
        log(3, str);
    }

    public void info(String str, Object... objArr) {
        log(3, str, objArr);
    }

    public void warn(String str) {
        log(4, str);
    }

    public void warn(String str, Object... objArr) {
        log(4, str, objArr);
    }

    public void error(String str) {
        log(5, str);
    }

    public void error(String str, Object... objArr) {
        log(5, str, objArr);
    }

    private void log(int i, String str) {
        if (shouldLog(i)) {
            sendToSink(i, str);
        }
    }

    private void log(int i, String str, Object[] objArr) {
        if (shouldLog(i)) {
            sendToSink(i, formatMessage(str, objArr));
        }
    }

    private boolean shouldLog(int i) {
        if (ServiceLogging.getLogLevel() <= i && !ServiceLogging.getSinks().isEmpty()) {
            String str = this.mChannel;
            if (str == null || ServiceLogging.isChannelEnabled(str)) {
                return true;
            }
        }
        return false;
    }

    private String formatMessage(String str, Object[] objArr) {
        if (objArr == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : objArr) {
            int indexOf = str.indexOf(ServiceLogger.PLACEHOLDER, i);
            if (indexOf < 0) {
                break;
            }
            sb.append(str, i, indexOf);
            sb.append(obj);
            i = indexOf + 2;
        }
        sb.append(str, i, str.length());
        return sb.toString();
    }

    private void sendToSink(int i, String str) {
        for (ServiceLoggingSink handleMessage : ServiceLogging.getSinks()) {
            handleMessage.handleMessage(i, this.mTag, str);
        }
    }
}
