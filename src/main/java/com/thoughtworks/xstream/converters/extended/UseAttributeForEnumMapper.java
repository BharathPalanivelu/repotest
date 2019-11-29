package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.util.DependencyInjectionFactory;
import com.thoughtworks.xstream.mapper.AttributeMapper;
import com.thoughtworks.xstream.mapper.DefaultMapper;
import com.thoughtworks.xstream.mapper.Mapper;

class UseAttributeForEnumMapper extends AttributeMapper {
    public SingleValueConverter getConverterFromAttribute(Class cls, String str, Class cls2) {
        return null;
    }

    public SingleValueConverter getConverterFromItemType(String str, Class cls, Class cls2) {
        return null;
    }

    public UseAttributeForEnumMapper(Mapper mapper) {
        super(mapper, (ConverterLookup) null, (ReflectionProvider) null);
    }

    public static boolean isEnum(Class<? super Object> cls) {
        while (cls != null && cls != Object.class) {
            if (cls.getName().equals("java.lang.Enum")) {
                return true;
            }
            cls = cls.getSuperclass();
        }
        return false;
    }

    public boolean shouldLookForSingleValueConverter(String str, Class cls, Class cls2) {
        return isEnum(cls);
    }

    static Mapper createEnumMapper(Mapper mapper) {
        try {
            return (Mapper) DependencyInjectionFactory.newInstance(Class.forName("com.thoughtworks.xstream.mapper.EnumMapper", true, Mapper.class.getClassLoader()), new Object[]{new UseAttributeForEnumMapper(mapper.lookupMapperOfType(DefaultMapper.class))});
        } catch (Exception unused) {
            return null;
        }
    }
}
