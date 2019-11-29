package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AttributeMapper extends MapperWrapper {
    private ConverterLookup converterLookup;
    private final Map fieldNameToTypeMap;
    private final Set fieldToUseAsAttribute;
    private ReflectionProvider reflectionProvider;
    private final Set typeSet;

    public AttributeMapper(Mapper mapper) {
        this(mapper, (ConverterLookup) null, (ReflectionProvider) null);
    }

    public AttributeMapper(Mapper mapper, ConverterLookup converterLookup2, ReflectionProvider reflectionProvider2) {
        super(mapper);
        this.fieldNameToTypeMap = new HashMap();
        this.typeSet = new HashSet();
        this.fieldToUseAsAttribute = new HashSet();
        this.converterLookup = converterLookup2;
        this.reflectionProvider = reflectionProvider2;
    }

    public void setConverterLookup(ConverterLookup converterLookup2) {
        this.converterLookup = converterLookup2;
    }

    public void addAttributeFor(String str, Class cls) {
        this.fieldNameToTypeMap.put(str, cls);
    }

    public void addAttributeFor(Class cls) {
        this.typeSet.add(cls);
    }

    private SingleValueConverter getLocalConverterFromItemType(Class cls) {
        Converter lookupConverterForType = this.converterLookup.lookupConverterForType(cls);
        if (lookupConverterForType == null || !(lookupConverterForType instanceof SingleValueConverter)) {
            return null;
        }
        return (SingleValueConverter) lookupConverterForType;
    }

    public SingleValueConverter getConverterFromItemType(String str, Class cls) {
        if (this.fieldNameToTypeMap.get(str) == cls) {
            return getLocalConverterFromItemType(cls);
        }
        return null;
    }

    public SingleValueConverter getConverterFromItemType(String str, Class cls, Class cls2) {
        if (shouldLookForSingleValueConverter(str, cls, cls2)) {
            SingleValueConverter localConverterFromItemType = getLocalConverterFromItemType(cls);
            if (localConverterFromItemType != null) {
                return localConverterFromItemType;
            }
        }
        return super.getConverterFromItemType(str, cls, cls2);
    }

    public boolean shouldLookForSingleValueConverter(String str, Class cls, Class cls2) {
        if (this.typeSet.contains(cls) || this.fieldNameToTypeMap.get(str) == cls) {
            return true;
        }
        if (str == null || cls2 == null) {
            return false;
        }
        return this.fieldToUseAsAttribute.contains(this.reflectionProvider.getField(cls2, str));
    }

    public SingleValueConverter getConverterFromItemType(Class cls) {
        if (this.typeSet.contains(cls)) {
            return getLocalConverterFromItemType(cls);
        }
        return null;
    }

    public SingleValueConverter getConverterFromAttribute(String str) {
        Class cls = (Class) this.fieldNameToTypeMap.get(str);
        if (cls != null) {
            return getLocalConverterFromItemType(cls);
        }
        return null;
    }

    public SingleValueConverter getConverterFromAttribute(Class cls, String str) {
        return getConverterFromAttribute(cls, str, this.reflectionProvider.getField(cls, str).getType());
    }

    public SingleValueConverter getConverterFromAttribute(Class cls, String str, Class cls2) {
        if (shouldLookForSingleValueConverter(str, cls2, cls)) {
            SingleValueConverter localConverterFromItemType = getLocalConverterFromItemType(cls2);
            if (localConverterFromItemType != null) {
                return localConverterFromItemType;
            }
        }
        return super.getConverterFromAttribute(cls, str, cls2);
    }

    public void addAttributeFor(Field field) {
        this.fieldToUseAsAttribute.add(field);
    }

    public void addAttributeFor(Class cls, String str) {
        this.fieldToUseAsAttribute.add(this.reflectionProvider.getField(cls, str));
    }
}
