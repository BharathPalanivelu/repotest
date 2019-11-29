package com.thoughtworks.xstream.converters.enums;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.util.Fields;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.Iterator;

public class EnumSetConverter implements Converter {
    private static final Field typeField = Fields.locate(EnumSet.class, Class.class, false);
    private final Mapper mapper;

    public EnumSetConverter(Mapper mapper2) {
        this.mapper = mapper2;
    }

    public boolean canConvert(Class cls) {
        return typeField != null && EnumSet.class.isAssignableFrom(cls);
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        EnumSet enumSet = (EnumSet) obj;
        Class cls = (Class) Fields.read(typeField, enumSet);
        String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("enum-type");
        if (aliasForSystemAttribute != null) {
            hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, this.mapper.serializedClass(cls));
        }
        hierarchicalStreamWriter.setValue(joinEnumValues(enumSet));
    }

    private String joinEnumValues(EnumSet enumSet) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = enumSet.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Enum enumR = (Enum) it.next();
            if (z) {
                stringBuffer.append(',');
            } else {
                z = true;
            }
            stringBuffer.append(enumR.name());
        }
        return stringBuffer.toString();
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("enum-type");
        if (aliasForSystemAttribute != null) {
            Class realClass = this.mapper.realClass(hierarchicalStreamReader.getAttribute(aliasForSystemAttribute));
            EnumSet noneOf = EnumSet.noneOf(realClass);
            String[] split = hierarchicalStreamReader.getValue().split(",");
            for (String str : split) {
                if (str.length() > 0) {
                    noneOf.add(Enum.valueOf(realClass, str));
                }
            }
            return noneOf;
        }
        throw new ConversionException("No EnumType specified for EnumSet");
    }
}
