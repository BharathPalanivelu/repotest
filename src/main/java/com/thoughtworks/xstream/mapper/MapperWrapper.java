package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.mapper.Mapper;

public abstract class MapperWrapper implements Mapper {
    private final Mapper wrapped;

    public MapperWrapper(Mapper mapper) {
        this.wrapped = mapper;
    }

    public String serializedClass(Class cls) {
        return this.wrapped.serializedClass(cls);
    }

    public Class realClass(String str) {
        return this.wrapped.realClass(str);
    }

    public String serializedMember(Class cls, String str) {
        return this.wrapped.serializedMember(cls, str);
    }

    public String realMember(Class cls, String str) {
        return this.wrapped.realMember(cls, str);
    }

    public boolean isImmutableValueType(Class cls) {
        return this.wrapped.isImmutableValueType(cls);
    }

    public Class defaultImplementationOf(Class cls) {
        return this.wrapped.defaultImplementationOf(cls);
    }

    public String aliasForAttribute(String str) {
        return this.wrapped.aliasForAttribute(str);
    }

    public String attributeForAlias(String str) {
        return this.wrapped.attributeForAlias(str);
    }

    public String aliasForSystemAttribute(String str) {
        return this.wrapped.aliasForSystemAttribute(str);
    }

    public String getFieldNameForItemTypeAndName(Class cls, Class cls2, String str) {
        return this.wrapped.getFieldNameForItemTypeAndName(cls, cls2, str);
    }

    public Class getItemTypeForItemFieldName(Class cls, String str) {
        return this.wrapped.getItemTypeForItemFieldName(cls, str);
    }

    public Mapper.ImplicitCollectionMapping getImplicitCollectionDefForFieldName(Class cls, String str) {
        return this.wrapped.getImplicitCollectionDefForFieldName(cls, str);
    }

    public boolean shouldSerializeMember(Class cls, String str) {
        return this.wrapped.shouldSerializeMember(cls, str);
    }

    public SingleValueConverter getConverterFromItemType(String str, Class cls) {
        return this.wrapped.getConverterFromItemType(str, cls);
    }

    public SingleValueConverter getConverterFromItemType(Class cls) {
        return this.wrapped.getConverterFromItemType(cls);
    }

    public SingleValueConverter getConverterFromAttribute(String str) {
        return this.wrapped.getConverterFromAttribute(str);
    }

    public Converter getLocalConverter(Class cls, String str) {
        return this.wrapped.getLocalConverter(cls, str);
    }

    public Mapper lookupMapperOfType(Class cls) {
        return cls.isAssignableFrom(getClass()) ? this : this.wrapped.lookupMapperOfType(cls);
    }

    public SingleValueConverter getConverterFromItemType(String str, Class cls, Class cls2) {
        return this.wrapped.getConverterFromItemType(str, cls, cls2);
    }

    public String aliasForAttribute(Class cls, String str) {
        return this.wrapped.aliasForAttribute(cls, str);
    }

    public String attributeForAlias(Class cls, String str) {
        return this.wrapped.attributeForAlias(cls, str);
    }

    public SingleValueConverter getConverterFromAttribute(Class cls, String str) {
        return this.wrapped.getConverterFromAttribute(cls, str);
    }

    public SingleValueConverter getConverterFromAttribute(Class cls, String str, Class cls2) {
        return this.wrapped.getConverterFromAttribute(cls, str, cls2);
    }
}
