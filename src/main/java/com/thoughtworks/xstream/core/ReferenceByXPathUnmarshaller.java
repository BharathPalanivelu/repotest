package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.io.AbstractReader;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.path.Path;
import com.thoughtworks.xstream.io.path.PathTracker;
import com.thoughtworks.xstream.io.path.PathTrackingReader;
import com.thoughtworks.xstream.mapper.Mapper;

public class ReferenceByXPathUnmarshaller extends AbstractReferenceUnmarshaller {
    protected boolean isNameEncoding;
    private PathTracker pathTracker = new PathTracker();

    public ReferenceByXPathUnmarshaller(Object obj, HierarchicalStreamReader hierarchicalStreamReader, ConverterLookup converterLookup, Mapper mapper) {
        super(obj, hierarchicalStreamReader, converterLookup, mapper);
        this.reader = new PathTrackingReader(hierarchicalStreamReader, this.pathTracker);
        this.isNameEncoding = hierarchicalStreamReader.underlyingReader() instanceof AbstractReader;
    }

    /* access modifiers changed from: protected */
    public Object getReferenceKey(String str) {
        Path path = new Path(this.isNameEncoding ? ((AbstractReader) this.reader.underlyingReader()).decodeNode(str) : str);
        return str.charAt(0) != '/' ? this.pathTracker.getPath().apply(path) : path;
    }

    /* access modifiers changed from: protected */
    public Object getCurrentReferenceKey() {
        return this.pathTracker.getPath();
    }
}
