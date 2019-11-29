package com.thoughtworks.xstream.converters.basic;

public class FloatConverter extends AbstractSingleValueConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(Float.TYPE) || cls.equals(Float.class);
    }

    public Object fromString(String str) {
        return Float.valueOf(str);
    }
}
