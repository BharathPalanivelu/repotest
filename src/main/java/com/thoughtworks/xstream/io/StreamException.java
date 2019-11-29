package com.thoughtworks.xstream.io;

import com.thoughtworks.xstream.XStreamException;

public class StreamException extends XStreamException {
    public StreamException(Throwable th) {
        super(th);
    }

    public StreamException(String str) {
        super(str);
    }

    public StreamException(String str, Throwable th) {
        super(str, th);
    }
}
