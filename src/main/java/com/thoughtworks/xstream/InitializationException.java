package com.thoughtworks.xstream;

import com.thoughtworks.xstream.XStream;

public class InitializationException extends XStream.InitializationException {
    public InitializationException(String str, Throwable th) {
        super(str, th);
    }

    public InitializationException(String str) {
        super(str);
    }
}
