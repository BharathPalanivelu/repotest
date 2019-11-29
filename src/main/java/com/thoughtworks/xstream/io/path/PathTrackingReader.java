package com.thoughtworks.xstream.io.path;

import com.thoughtworks.xstream.converters.ErrorWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.ReaderWrapper;

public class PathTrackingReader extends ReaderWrapper {
    private final PathTracker pathTracker;

    public PathTrackingReader(HierarchicalStreamReader hierarchicalStreamReader, PathTracker pathTracker2) {
        super(hierarchicalStreamReader);
        this.pathTracker = pathTracker2;
        pathTracker2.pushElement(getNodeName());
    }

    public void moveDown() {
        super.moveDown();
        this.pathTracker.pushElement(getNodeName());
    }

    public void moveUp() {
        super.moveUp();
        this.pathTracker.popElement();
    }

    public void appendErrors(ErrorWriter errorWriter) {
        errorWriter.add("path", this.pathTracker.getPath().toString());
        super.appendErrors(errorWriter);
    }
}
