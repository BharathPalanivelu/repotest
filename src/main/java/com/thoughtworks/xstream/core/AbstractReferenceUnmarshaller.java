package com.thoughtworks.xstream.core;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.core.util.FastStack;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.mapper.Mapper;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractReferenceUnmarshaller extends TreeUnmarshaller {
    private static final Object NULL = new Object();
    private FastStack parentStack = new FastStack(16);
    private Map values = new HashMap();

    /* access modifiers changed from: protected */
    public abstract Object getCurrentReferenceKey();

    /* access modifiers changed from: protected */
    public abstract Object getReferenceKey(String str);

    public AbstractReferenceUnmarshaller(Object obj, HierarchicalStreamReader hierarchicalStreamReader, ConverterLookup converterLookup, Mapper mapper) {
        super(obj, hierarchicalStreamReader, converterLookup, mapper);
    }

    /* access modifiers changed from: protected */
    public Object convert(Object obj, Class cls, Converter converter) {
        String str;
        if (this.parentStack.size() > 0) {
            Object peek = this.parentStack.peek();
            if (peek != null && !this.values.containsKey(peek)) {
                this.values.put(peek, obj);
            }
        }
        String aliasForSystemAttribute = getMapper().aliasForSystemAttribute("reference");
        if (aliasForSystemAttribute == null) {
            str = null;
        } else {
            str = this.reader.getAttribute(aliasForSystemAttribute);
        }
        if (str != null) {
            Object obj2 = this.values.get(getReferenceKey(str));
            if (obj2 == null) {
                ConversionException conversionException = new ConversionException("Invalid reference");
                conversionException.add("reference", str);
                throw conversionException;
            } else if (obj2 == NULL) {
                return null;
            } else {
                return obj2;
            }
        } else {
            Object currentReferenceKey = getCurrentReferenceKey();
            this.parentStack.push(currentReferenceKey);
            Object convert = super.convert(obj, cls, converter);
            if (currentReferenceKey != null) {
                this.values.put(currentReferenceKey, convert == null ? NULL : convert);
            }
            this.parentStack.popSilently();
            return convert;
        }
    }
}
