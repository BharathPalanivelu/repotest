package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.DataHolder;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.core.util.ObjectIdDictionary;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.util.Iterator;

public class TreeMarshaller implements MarshallingContext {
    protected ConverterLookup converterLookup;
    private DataHolder dataHolder;
    private Mapper mapper;
    private ObjectIdDictionary parentObjects = new ObjectIdDictionary();
    protected HierarchicalStreamWriter writer;

    public TreeMarshaller(HierarchicalStreamWriter hierarchicalStreamWriter, ConverterLookup converterLookup2, Mapper mapper2) {
        this.writer = hierarchicalStreamWriter;
        this.converterLookup = converterLookup2;
        this.mapper = mapper2;
    }

    public void convertAnother(Object obj) {
        convertAnother(obj, (Converter) null);
    }

    public void convertAnother(Object obj, Converter converter) {
        if (converter == null) {
            converter = this.converterLookup.lookupConverterForType(obj.getClass());
        } else if (!converter.canConvert(obj.getClass())) {
            ConversionException conversionException = new ConversionException("Explicit selected converter cannot handle item");
            conversionException.add("item-type", obj.getClass().getName());
            conversionException.add("converter-type", converter.getClass().getName());
            throw conversionException;
        }
        convert(obj, converter);
    }

    /* access modifiers changed from: protected */
    public void convert(Object obj, Converter converter) {
        if (!this.parentObjects.containsId(obj)) {
            this.parentObjects.associateId(obj, "");
            converter.marshal(obj, this.writer, this);
            this.parentObjects.removeId(obj);
            return;
        }
        CircularReferenceException circularReferenceException = new CircularReferenceException("Recursive reference to parent object");
        circularReferenceException.add("item-type", obj.getClass().getName());
        circularReferenceException.add("converter-type", converter.getClass().getName());
        throw circularReferenceException;
    }

    public void start(Object obj, DataHolder dataHolder2) {
        this.dataHolder = dataHolder2;
        if (obj == null) {
            this.writer.startNode(this.mapper.serializedClass((Class) null));
            this.writer.endNode();
            return;
        }
        ExtendedHierarchicalStreamWriterHelper.startNode(this.writer, this.mapper.serializedClass(obj.getClass()), obj.getClass());
        convertAnother(obj);
        this.writer.endNode();
    }

    public Object get(Object obj) {
        lazilyCreateDataHolder();
        return this.dataHolder.get(obj);
    }

    public void put(Object obj, Object obj2) {
        lazilyCreateDataHolder();
        this.dataHolder.put(obj, obj2);
    }

    public Iterator keys() {
        lazilyCreateDataHolder();
        return this.dataHolder.keys();
    }

    private void lazilyCreateDataHolder() {
        if (this.dataHolder == null) {
            this.dataHolder = new MapBackedDataHolder();
        }
    }

    /* access modifiers changed from: protected */
    public Mapper getMapper() {
        return this.mapper;
    }

    public static class CircularReferenceException extends ConversionException {
        public CircularReferenceException(String str) {
            super(str);
        }
    }
}
