package com.thoughtworks.xstream.converters.reflection;

public class MissingFieldException extends ObjectAccessException {
    private final String className;
    private final String fieldName;

    public MissingFieldException(String str, String str2) {
        super("No field '" + str2 + "' found in class '" + str + "'");
        this.className = str;
        this.fieldName = str2;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    /* access modifiers changed from: protected */
    public String getClassName() {
        return this.className;
    }
}
