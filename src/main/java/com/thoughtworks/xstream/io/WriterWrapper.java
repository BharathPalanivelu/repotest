package com.thoughtworks.xstream.io;

public abstract class WriterWrapper implements ExtendedHierarchicalStreamWriter {
    protected HierarchicalStreamWriter wrapped;

    protected WriterWrapper(HierarchicalStreamWriter hierarchicalStreamWriter) {
        this.wrapped = hierarchicalStreamWriter;
    }

    public void startNode(String str) {
        this.wrapped.startNode(str);
    }

    public void startNode(String str, Class cls) {
        ((ExtendedHierarchicalStreamWriter) this.wrapped).startNode(str, cls);
    }

    public void endNode() {
        this.wrapped.endNode();
    }

    public void addAttribute(String str, String str2) {
        this.wrapped.addAttribute(str, str2);
    }

    public void setValue(String str) {
        this.wrapped.setValue(str);
    }

    public void flush() {
        this.wrapped.flush();
    }

    public void close() {
        this.wrapped.close();
    }

    public HierarchicalStreamWriter underlyingWriter() {
        return this.wrapped.underlyingWriter();
    }
}
