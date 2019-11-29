package com.thoughtworks.xstream.io;

import com.thoughtworks.xstream.converters.ErrorWriter;
import java.util.Iterator;

public abstract class ReaderWrapper implements ExtendedHierarchicalStreamReader {
    protected HierarchicalStreamReader wrapped;

    protected ReaderWrapper(HierarchicalStreamReader hierarchicalStreamReader) {
        this.wrapped = hierarchicalStreamReader;
    }

    public boolean hasMoreChildren() {
        return this.wrapped.hasMoreChildren();
    }

    public void moveDown() {
        this.wrapped.moveDown();
    }

    public void moveUp() {
        this.wrapped.moveUp();
    }

    public String getNodeName() {
        return this.wrapped.getNodeName();
    }

    public String getValue() {
        return this.wrapped.getValue();
    }

    public String getAttribute(String str) {
        return this.wrapped.getAttribute(str);
    }

    public String getAttribute(int i) {
        return this.wrapped.getAttribute(i);
    }

    public int getAttributeCount() {
        return this.wrapped.getAttributeCount();
    }

    public String getAttributeName(int i) {
        return this.wrapped.getAttributeName(i);
    }

    public Iterator getAttributeNames() {
        return this.wrapped.getAttributeNames();
    }

    public void appendErrors(ErrorWriter errorWriter) {
        this.wrapped.appendErrors(errorWriter);
    }

    public void close() {
        this.wrapped.close();
    }

    public String peekNextChild() {
        HierarchicalStreamReader hierarchicalStreamReader = this.wrapped;
        if (hierarchicalStreamReader instanceof ExtendedHierarchicalStreamReader) {
            return ((ExtendedHierarchicalStreamReader) hierarchicalStreamReader).peekNextChild();
        }
        throw new UnsupportedOperationException("peekNextChild");
    }

    public HierarchicalStreamReader underlyingReader() {
        return this.wrapped.underlyingReader();
    }
}
