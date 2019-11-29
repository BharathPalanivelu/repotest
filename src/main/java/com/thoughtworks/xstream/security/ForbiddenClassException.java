package com.thoughtworks.xstream.security;

import com.thoughtworks.xstream.XStreamException;

public class ForbiddenClassException extends XStreamException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ForbiddenClassException(Class cls) {
        super(cls == null ? "null" : cls.getName());
    }
}
