package com.thoughtworks.xstream.io.path;

import com.thoughtworks.xstream.io.AbstractWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.WriterWrapper;

public class PathTrackingWriter extends WriterWrapper {
    private final boolean isNameEncoding;
    private final PathTracker pathTracker;

    public PathTrackingWriter(HierarchicalStreamWriter hierarchicalStreamWriter, PathTracker pathTracker2) {
        super(hierarchicalStreamWriter);
        this.isNameEncoding = hierarchicalStreamWriter.underlyingWriter() instanceof AbstractWriter;
        this.pathTracker = pathTracker2;
    }

    public void startNode(String str) {
        this.pathTracker.pushElement(this.isNameEncoding ? ((AbstractWriter) this.wrapped.underlyingWriter()).encodeNode(str) : str);
        super.startNode(str);
    }

    public void startNode(String str, Class cls) {
        this.pathTracker.pushElement(this.isNameEncoding ? ((AbstractWriter) this.wrapped.underlyingWriter()).encodeNode(str) : str);
        super.startNode(str, cls);
    }

    public void endNode() {
        super.endNode();
        this.pathTracker.popElement();
    }
}
