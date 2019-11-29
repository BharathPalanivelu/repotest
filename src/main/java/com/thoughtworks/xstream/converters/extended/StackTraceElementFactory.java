package com.thoughtworks.xstream.converters.extended;

import com.facebook.react.devsupport.StackTraceHelper;
import com.thoughtworks.xstream.converters.ConversionException;
import java.lang.reflect.Field;

public class StackTraceElementFactory {
    public StackTraceElement nativeMethodElement(String str, String str2) {
        return create(str, str2, "Native Method", -2);
    }

    public StackTraceElement unknownSourceElement(String str, String str2) {
        return create(str, str2, "Unknown Source", -1);
    }

    public StackTraceElement element(String str, String str2, String str3) {
        return create(str, str2, str3, -1);
    }

    public StackTraceElement element(String str, String str2, String str3, int i) {
        return create(str, str2, str3, i);
    }

    /* access modifiers changed from: protected */
    public StackTraceElement create(String str, String str2, String str3, int i) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[0];
        setField(stackTraceElement, "declaringClass", str);
        setField(stackTraceElement, "methodName", str2);
        setField(stackTraceElement, "fileName", str3);
        setField(stackTraceElement, StackTraceHelper.LINE_NUMBER_KEY, new Integer(i));
        return stackTraceElement;
    }

    private void setField(StackTraceElement stackTraceElement, String str, Object obj) {
        try {
            Field declaredField = StackTraceElement.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(stackTraceElement, obj);
        } catch (Exception e2) {
            throw new ConversionException((Throwable) e2);
        }
    }
}
