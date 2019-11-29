package com.thoughtworks.xstream.io;

import com.thoughtworks.xstream.core.util.Cloneables;
import com.thoughtworks.xstream.io.naming.NameCoder;
import com.thoughtworks.xstream.io.naming.NoNameCoder;

public abstract class AbstractReader implements ExtendedHierarchicalStreamReader {
    private NameCoder nameCoder;

    public HierarchicalStreamReader underlyingReader() {
        return this;
    }

    protected AbstractReader() {
        this(new NoNameCoder());
    }

    protected AbstractReader(NameCoder nameCoder2) {
        this.nameCoder = (NameCoder) Cloneables.cloneIfPossible(nameCoder2);
    }

    public String decodeNode(String str) {
        return this.nameCoder.decodeNode(str);
    }

    public String decodeAttribute(String str) {
        return this.nameCoder.decodeAttribute(str);
    }

    /* access modifiers changed from: protected */
    public String encodeNode(String str) {
        return this.nameCoder.encodeNode(str);
    }

    /* access modifiers changed from: protected */
    public String encodeAttribute(String str) {
        return this.nameCoder.encodeAttribute(str);
    }

    public String peekNextChild() {
        throw new UnsupportedOperationException("peekNextChild");
    }
}
