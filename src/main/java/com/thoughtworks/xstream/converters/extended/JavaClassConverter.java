package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.mapper.DefaultMapper;
import com.thoughtworks.xstream.mapper.Mapper;

public class JavaClassConverter extends AbstractSingleValueConverter {
    private Mapper mapper;

    public JavaClassConverter(ClassLoaderReference classLoaderReference) {
        this((Mapper) new DefaultMapper(classLoaderReference));
    }

    public JavaClassConverter(ClassLoader classLoader) {
        this(new ClassLoaderReference(classLoader));
    }

    protected JavaClassConverter(Mapper mapper2) {
        this.mapper = mapper2;
    }

    public boolean canConvert(Class cls) {
        return Class.class.equals(cls);
    }

    public String toString(Object obj) {
        return this.mapper.serializedClass((Class) obj);
    }

    public Object fromString(String str) {
        try {
            return this.mapper.realClass(str);
        } catch (CannotResolveClassException e2) {
            throw new ConversionException("Cannot load java class " + str, e2.getCause());
        }
    }
}
