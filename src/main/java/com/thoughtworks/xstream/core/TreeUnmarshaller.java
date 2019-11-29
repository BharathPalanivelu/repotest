package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.DataHolder;
import com.thoughtworks.xstream.converters.ErrorReporter;
import com.thoughtworks.xstream.converters.ErrorWriter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.util.FastStack;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.core.util.PrioritizedList;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.mapper.Mapper;
import java.util.Iterator;

public class TreeUnmarshaller implements UnmarshallingContext {
    private ConverterLookup converterLookup;
    private DataHolder dataHolder;
    private Mapper mapper;
    protected HierarchicalStreamReader reader;
    private Object root;
    private FastStack types = new FastStack(16);
    private final PrioritizedList validationList = new PrioritizedList();

    public TreeUnmarshaller(Object obj, HierarchicalStreamReader hierarchicalStreamReader, ConverterLookup converterLookup2, Mapper mapper2) {
        this.root = obj;
        this.reader = hierarchicalStreamReader;
        this.converterLookup = converterLookup2;
        this.mapper = mapper2;
    }

    public Object convertAnother(Object obj, Class cls) {
        return convertAnother(obj, cls, (Converter) null);
    }

    public Object convertAnother(Object obj, Class cls, Converter converter) {
        Class defaultImplementationOf = this.mapper.defaultImplementationOf(cls);
        if (converter == null) {
            converter = this.converterLookup.lookupConverterForType(defaultImplementationOf);
        } else if (!converter.canConvert(defaultImplementationOf)) {
            ConversionException conversionException = new ConversionException("Explicit selected converter cannot handle type");
            conversionException.add("item-type", defaultImplementationOf.getName());
            conversionException.add("converter-type", converter.getClass().getName());
            throw conversionException;
        }
        return convert(obj, defaultImplementationOf, converter);
    }

    /* access modifiers changed from: protected */
    public Object convert(Object obj, Class cls, Converter converter) {
        try {
            this.types.push(cls);
            Object unmarshal = converter.unmarshal(this.reader, this);
            this.types.popSilently();
            return unmarshal;
        } catch (ConversionException e2) {
            addInformationTo(e2, cls, converter, obj);
            throw e2;
        } catch (RuntimeException e3) {
            ConversionException conversionException = new ConversionException((Throwable) e3);
            addInformationTo(conversionException, cls, converter, obj);
            throw conversionException;
        }
    }

    private void addInformationTo(ErrorWriter errorWriter, Class cls, Converter converter, Object obj) {
        errorWriter.add("class", cls.getName());
        errorWriter.add("required-type", getRequiredType().getName());
        errorWriter.add("converter-type", converter.getClass().getName());
        if (converter instanceof ErrorReporter) {
            ((ErrorReporter) converter).appendErrors(errorWriter);
        }
        if (obj instanceof ErrorReporter) {
            ((ErrorReporter) obj).appendErrors(errorWriter);
        }
        this.reader.appendErrors(errorWriter);
    }

    public void addCompletionCallback(Runnable runnable, int i) {
        this.validationList.add(runnable, i);
    }

    public Object currentObject() {
        if (this.types.size() == 1) {
            return this.root;
        }
        return null;
    }

    public Class getRequiredType() {
        return (Class) this.types.peek();
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

    public Object start(DataHolder dataHolder2) {
        this.dataHolder = dataHolder2;
        Object convertAnother = convertAnother((Object) null, HierarchicalStreams.readClassType(this.reader, this.mapper));
        Iterator it = this.validationList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        return convertAnother;
    }

    /* access modifiers changed from: protected */
    public Mapper getMapper() {
        return this.mapper;
    }
}
