package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

public class TreeMarshallingStrategy extends AbstractTreeMarshallingStrategy {
    /* access modifiers changed from: protected */
    public TreeUnmarshaller createUnmarshallingContext(Object obj, HierarchicalStreamReader hierarchicalStreamReader, ConverterLookup converterLookup, Mapper mapper) {
        return new TreeUnmarshaller(obj, hierarchicalStreamReader, converterLookup, mapper);
    }

    /* access modifiers changed from: protected */
    public TreeMarshaller createMarshallingContext(HierarchicalStreamWriter hierarchicalStreamWriter, ConverterLookup converterLookup, Mapper mapper) {
        return new TreeMarshaller(hierarchicalStreamWriter, converterLookup, mapper);
    }
}
