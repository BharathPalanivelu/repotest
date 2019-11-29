package com.salesforce.android.chat.core.internal.logging;

import java.io.PrintWriter;
import java.io.StringWriter;

class ErrorEventUtil {
    ErrorEventUtil() {
    }

    static String parseStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
