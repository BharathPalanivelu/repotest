package com.thoughtworks.xstream.io.naming;

public class NameCoderWrapper implements NameCoder {
    private final NameCoder wrapped;

    public NameCoderWrapper(NameCoder nameCoder) {
        this.wrapped = nameCoder;
    }

    public String decodeAttribute(String str) {
        return this.wrapped.decodeAttribute(str);
    }

    public String decodeNode(String str) {
        return this.wrapped.decodeNode(str);
    }

    public String encodeAttribute(String str) {
        return this.wrapped.encodeAttribute(str);
    }

    public String encodeNode(String str) {
        return this.wrapped.encodeNode(str);
    }
}
