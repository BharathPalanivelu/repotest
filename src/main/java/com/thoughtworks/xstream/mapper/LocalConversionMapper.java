package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.core.util.FastField;
import java.util.HashMap;
import java.util.Map;

public class LocalConversionMapper extends MapperWrapper {
    private transient AttributeMapper attributeMapper;
    private final Map localConverters = new HashMap();

    public LocalConversionMapper(Mapper mapper) {
        super(mapper);
        readResolve();
    }

    public void registerLocalConverter(Class cls, String str, Converter converter) {
        this.localConverters.put(new FastField(cls, str), converter);
    }

    public Converter getLocalConverter(Class cls, String str) {
        return (Converter) this.localConverters.get(new FastField(cls, str));
    }

    public SingleValueConverter getConverterFromAttribute(Class cls, String str, Class cls2) {
        SingleValueConverter localSingleValueConverter = getLocalSingleValueConverter(cls, str, cls2);
        return localSingleValueConverter == null ? super.getConverterFromAttribute(cls, str, cls2) : localSingleValueConverter;
    }

    public SingleValueConverter getConverterFromItemType(String str, Class cls, Class cls2) {
        SingleValueConverter localSingleValueConverter = getLocalSingleValueConverter(cls2, str, cls);
        return localSingleValueConverter == null ? super.getConverterFromItemType(str, cls, cls2) : localSingleValueConverter;
    }

    private SingleValueConverter getLocalSingleValueConverter(Class cls, String str, Class cls2) {
        AttributeMapper attributeMapper2 = this.attributeMapper;
        if (attributeMapper2 == null || !attributeMapper2.shouldLookForSingleValueConverter(str, cls2, cls)) {
            return null;
        }
        Converter localConverter = getLocalConverter(cls, str);
        if (localConverter == null || !(localConverter instanceof SingleValueConverter)) {
            return null;
        }
        return (SingleValueConverter) localConverter;
    }

    private Object readResolve() {
        this.attributeMapper = (AttributeMapper) lookupMapperOfType(AttributeMapper.class);
        return this;
    }
}
