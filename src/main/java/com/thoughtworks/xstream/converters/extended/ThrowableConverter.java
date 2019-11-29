package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ThrowableConverter implements Converter {
    private Converter defaultConverter;
    private final ConverterLookup lookup;

    public ThrowableConverter(Converter converter) {
        this.defaultConverter = converter;
        this.lookup = null;
    }

    public ThrowableConverter(ConverterLookup converterLookup) {
        this.lookup = converterLookup;
    }

    public boolean canConvert(Class cls) {
        return Throwable.class.isAssignableFrom(cls);
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Throwable th = (Throwable) obj;
        if (th.getCause() == null) {
            try {
                th.initCause((Throwable) null);
            } catch (IllegalStateException unused) {
            }
        }
        th.getStackTrace();
        getConverter().marshal(th, hierarchicalStreamWriter, marshallingContext);
    }

    private Converter getConverter() {
        Converter converter = this.defaultConverter;
        return converter != null ? converter : this.lookup.lookupConverterForType(Object.class);
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return getConverter().unmarshal(hierarchicalStreamReader, unmarshallingContext);
    }
}
