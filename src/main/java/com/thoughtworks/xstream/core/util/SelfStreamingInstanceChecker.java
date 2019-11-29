package com.thoughtworks.xstream.core.util;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class SelfStreamingInstanceChecker implements Converter {
    private Converter defaultConverter;
    private final ConverterLookup lookup;
    private final Object self;

    public SelfStreamingInstanceChecker(ConverterLookup converterLookup, Object obj) {
        this.lookup = converterLookup;
        this.self = obj;
    }

    public SelfStreamingInstanceChecker(Converter converter, Object obj) {
        this.defaultConverter = converter;
        this.self = obj;
        this.lookup = null;
    }

    public boolean canConvert(Class cls) {
        return cls == this.self.getClass();
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        if (obj != this.self) {
            getConverter().marshal(obj, hierarchicalStreamWriter, marshallingContext);
            return;
        }
        throw new ConversionException("Cannot marshal the XStream instance in action");
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return getConverter().unmarshal(hierarchicalStreamReader, unmarshallingContext);
    }

    private Converter getConverter() {
        Converter converter = this.defaultConverter;
        return converter != null ? converter : this.lookup.lookupConverterForType(Object.class);
    }
}
