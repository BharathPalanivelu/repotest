package com.thoughtworks.xstream.converters.extended;

class StackTraceElementFactory15 extends StackTraceElementFactory {
    StackTraceElementFactory15() {
    }

    /* access modifiers changed from: protected */
    public StackTraceElement create(String str, String str2, String str3, int i) {
        return new StackTraceElement(str, str2, str3, i);
    }
}
