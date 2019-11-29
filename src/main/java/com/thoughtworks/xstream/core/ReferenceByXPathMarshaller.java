package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.path.Path;
import com.thoughtworks.xstream.mapper.Mapper;

public class ReferenceByXPathMarshaller extends AbstractReferenceMarshaller {
    private final int mode;

    /* access modifiers changed from: protected */
    public Object createReferenceKey(Path path, Object obj) {
        return path;
    }

    /* access modifiers changed from: protected */
    public void fireValidReference(Object obj) {
    }

    public ReferenceByXPathMarshaller(HierarchicalStreamWriter hierarchicalStreamWriter, ConverterLookup converterLookup, Mapper mapper, int i) {
        super(hierarchicalStreamWriter, converterLookup, mapper);
        this.mode = i;
    }

    /* access modifiers changed from: protected */
    public String createReference(Path path, Object obj) {
        Path path2 = (Path) obj;
        if ((this.mode & ReferenceByXPathMarshallingStrategy.ABSOLUTE) <= 0) {
            path2 = path.relativeTo(path2);
        }
        return (this.mode & ReferenceByXPathMarshallingStrategy.SINGLE_NODE) > 0 ? path2.explicit() : path2.toString();
    }
}
