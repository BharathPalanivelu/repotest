package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.mapper.Mapper;

public class ReferenceByIdUnmarshaller extends AbstractReferenceUnmarshaller {
    /* access modifiers changed from: protected */
    public Object getReferenceKey(String str) {
        return str;
    }

    public ReferenceByIdUnmarshaller(Object obj, HierarchicalStreamReader hierarchicalStreamReader, ConverterLookup converterLookup, Mapper mapper) {
        super(obj, hierarchicalStreamReader, converterLookup, mapper);
    }

    /* access modifiers changed from: protected */
    public Object getCurrentReferenceKey() {
        String aliasForSystemAttribute = getMapper().aliasForSystemAttribute("id");
        if (aliasForSystemAttribute == null) {
            return null;
        }
        return this.reader.getAttribute(aliasForSystemAttribute);
    }
}
