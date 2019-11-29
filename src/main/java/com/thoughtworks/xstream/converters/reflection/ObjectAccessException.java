package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.XStreamException;

public class ObjectAccessException extends XStreamException {
    public ObjectAccessException(String str) {
        super(str);
    }

    public ObjectAccessException(String str, Throwable th) {
        super(str, th);
    }
}
