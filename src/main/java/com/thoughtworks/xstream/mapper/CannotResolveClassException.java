package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.XStreamException;

public class CannotResolveClassException extends XStreamException {
    public CannotResolveClassException(String str) {
        super(str);
    }

    public CannotResolveClassException(String str, Throwable th) {
        super(str, th);
    }
}
