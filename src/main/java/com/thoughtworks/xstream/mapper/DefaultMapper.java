package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.core.util.Primitives;
import com.thoughtworks.xstream.mapper.Mapper;

public class DefaultMapper implements Mapper {
    private static String XSTREAM_PACKAGE_ROOT;
    private final ClassLoaderReference classLoaderReference;

    public String aliasForAttribute(Class cls, String str) {
        return str;
    }

    public String aliasForAttribute(String str) {
        return str;
    }

    public String aliasForSystemAttribute(String str) {
        return str;
    }

    public String attributeForAlias(Class cls, String str) {
        return str;
    }

    public String attributeForAlias(String str) {
        return str;
    }

    public Class defaultImplementationOf(Class cls) {
        return cls;
    }

    public SingleValueConverter getConverterFromAttribute(Class cls, String str) {
        return null;
    }

    public SingleValueConverter getConverterFromAttribute(Class cls, String str, Class cls2) {
        return null;
    }

    public SingleValueConverter getConverterFromAttribute(String str) {
        return null;
    }

    public SingleValueConverter getConverterFromItemType(Class cls) {
        return null;
    }

    public SingleValueConverter getConverterFromItemType(String str, Class cls) {
        return null;
    }

    public SingleValueConverter getConverterFromItemType(String str, Class cls, Class cls2) {
        return null;
    }

    public String getFieldNameForItemTypeAndName(Class cls, Class cls2, String str) {
        return null;
    }

    public Mapper.ImplicitCollectionMapping getImplicitCollectionDefForFieldName(Class cls, String str) {
        return null;
    }

    public Class getItemTypeForItemFieldName(Class cls, String str) {
        return null;
    }

    public Converter getLocalConverter(Class cls, String str) {
        return null;
    }

    public boolean isImmutableValueType(Class cls) {
        return false;
    }

    public Mapper lookupMapperOfType(Class cls) {
        return null;
    }

    public String realMember(Class cls, String str) {
        return str;
    }

    public String serializedMember(Class cls, String str) {
        return str;
    }

    public boolean shouldSerializeMember(Class cls, String str) {
        return true;
    }

    static {
        String name = DefaultMapper.class.getName();
        int indexOf = name.indexOf(".xstream.");
        XSTREAM_PACKAGE_ROOT = indexOf > 0 ? name.substring(0, indexOf + 9) : ".N/A";
    }

    public DefaultMapper(ClassLoaderReference classLoaderReference2) {
        this.classLoaderReference = classLoaderReference2;
    }

    public DefaultMapper(ClassLoader classLoader) {
        this(new ClassLoaderReference(classLoader));
    }

    public String serializedClass(Class cls) {
        return cls.getName();
    }

    public Class realClass(String str) {
        ClassLoader classLoader;
        Class primitiveType = Primitives.primitiveType(str);
        if (primitiveType != null) {
            return primitiveType;
        }
        try {
            boolean z = true;
            if (str.startsWith(XSTREAM_PACKAGE_ROOT)) {
                classLoader = DefaultMapper.class.getClassLoader();
            } else {
                classLoader = this.classLoaderReference.getReference();
                if (str.charAt(0) != '[') {
                    z = false;
                }
            }
            return Class.forName(str, z, classLoader);
        } catch (ClassNotFoundException unused) {
            throw new CannotResolveClassException(str);
        }
    }

    public String lookupName(Class cls) {
        return serializedClass(cls);
    }

    public Class lookupType(String str) {
        return realClass(str);
    }
}
