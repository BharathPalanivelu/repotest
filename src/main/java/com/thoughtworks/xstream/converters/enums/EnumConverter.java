package com.thoughtworks.xstream.converters.enums;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class EnumConverter implements Converter {
    public boolean canConvert(Class cls) {
        return cls.isEnum() || Enum.class.isAssignableFrom(cls);
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        hierarchicalStreamWriter.setValue(((Enum) obj).name());
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Class requiredType = unmarshallingContext.getRequiredType();
        if (requiredType.getSuperclass() != Enum.class) {
            requiredType = requiredType.getSuperclass();
        }
        String value = hierarchicalStreamReader.getValue();
        try {
            return Enum.valueOf(requiredType, value);
        } catch (IllegalArgumentException e2) {
            for (Enum enumR : (Enum[]) requiredType.getEnumConstants()) {
                if (enumR.name().equalsIgnoreCase(value)) {
                    return enumR;
                }
            }
            throw e2;
        }
    }
}
