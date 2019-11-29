package com.thoughtworks.xstream.io;

import com.thoughtworks.xstream.core.util.Cloneables;
import com.thoughtworks.xstream.io.naming.NameCoder;
import com.thoughtworks.xstream.io.naming.NoNameCoder;

public abstract class AbstractWriter implements ExtendedHierarchicalStreamWriter {
    private NameCoder nameCoder;

    public HierarchicalStreamWriter underlyingWriter() {
        return this;
    }

    protected AbstractWriter() {
        this(new NoNameCoder());
    }

    protected AbstractWriter(NameCoder nameCoder2) {
        this.nameCoder = (NameCoder) Cloneables.cloneIfPossible(nameCoder2);
    }

    public void startNode(String str, Class cls) {
        startNode(str);
    }

    public String encodeNode(String str) {
        return this.nameCoder.encodeNode(str);
    }

    public String encodeAttribute(String str) {
        return this.nameCoder.encodeAttribute(str);
    }
}
