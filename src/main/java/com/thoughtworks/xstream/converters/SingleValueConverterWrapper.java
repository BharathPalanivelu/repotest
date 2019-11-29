package com.thoughtworks.xstream.converters;

import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class SingleValueConverterWrapper implements Converter, ErrorReporter, SingleValueConverter {
    private final SingleValueConverter wrapped;

    public SingleValueConverterWrapper(SingleValueConverter singleValueConverter) {
        this.wrapped = singleValueConverter;
    }

    public boolean canConvert(Class cls) {
        return this.wrapped.canConvert(cls);
    }

    public String toString(Object obj) {
        return this.wrapped.toString(obj);
    }

    public Object fromString(String str) {
        return this.wrapped.fromString(str);
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        hierarchicalStreamWriter.setValue(toString(obj));
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return fromString(hierarchicalStreamReader.getValue());
    }

    public void appendErrors(ErrorWriter errorWriter) {
        SingleValueConverter singleValueConverter = this.wrapped;
        errorWriter.add("wrapped-converter", singleValueConverter == null ? "(null)" : singleValueConverter.getClass().getName());
        SingleValueConverter singleValueConverter2 = this.wrapped;
        if (singleValueConverter2 instanceof ErrorReporter) {
            ((ErrorReporter) singleValueConverter2).appendErrors(errorWriter);
        }
    }
}
