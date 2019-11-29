package com.thoughtworks.xstream.converters.enums;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

public class EnumSingleValueConverter extends AbstractSingleValueConverter {
    private final Class<? extends Enum> enumType;

    public EnumSingleValueConverter(Class<? extends Enum> cls) {
        if (Enum.class.isAssignableFrom(cls) || cls == Enum.class) {
            this.enumType = cls;
            return;
        }
        throw new IllegalArgumentException("Converter can only handle defined enums");
    }

    public boolean canConvert(Class cls) {
        return this.enumType.isAssignableFrom(cls);
    }

    public String toString(Object obj) {
        return Enum.class.cast(obj).name();
    }

    public Object fromString(String str) {
        return Enum.valueOf(this.enumType, str);
    }
}
