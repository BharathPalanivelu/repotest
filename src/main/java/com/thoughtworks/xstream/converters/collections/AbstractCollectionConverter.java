package com.thoughtworks.xstream.converters.collections;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

public abstract class AbstractCollectionConverter implements Converter {
    private final Mapper mapper;

    public abstract boolean canConvert(Class cls);

    public abstract void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext);

    public abstract Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext);

    public AbstractCollectionConverter(Mapper mapper2) {
        this.mapper = mapper2;
    }

    /* access modifiers changed from: protected */
    public Mapper mapper() {
        return this.mapper;
    }

    /* access modifiers changed from: protected */
    public void writeItem(Object obj, MarshallingContext marshallingContext, HierarchicalStreamWriter hierarchicalStreamWriter) {
        if (obj == null) {
            ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, mapper().serializedClass((Class) null), Mapper.Null.class);
            hierarchicalStreamWriter.endNode();
            return;
        }
        ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, mapper().serializedClass(obj.getClass()), obj.getClass());
        marshallingContext.convertAnother(obj);
        hierarchicalStreamWriter.endNode();
    }

    /* access modifiers changed from: protected */
    public Object readItem(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext, Object obj) {
        return unmarshallingContext.convertAnother(obj, HierarchicalStreams.readClassType(hierarchicalStreamReader, mapper()));
    }

    /* access modifiers changed from: protected */
    public Object createCollection(Class cls) {
        Class defaultImplementationOf = mapper().defaultImplementationOf(cls);
        try {
            return defaultImplementationOf.newInstance();
        } catch (InstantiationException e2) {
            throw new ConversionException("Cannot instantiate " + defaultImplementationOf.getName(), e2);
        } catch (IllegalAccessException e3) {
            throw new ConversionException("Cannot instantiate " + defaultImplementationOf.getName(), e3);
        }
    }
}
