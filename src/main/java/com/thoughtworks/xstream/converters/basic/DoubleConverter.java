package com.thoughtworks.xstream.converters.basic;

public class DoubleConverter extends AbstractSingleValueConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(Double.TYPE) || cls.equals(Double.class);
    }

    public Object fromString(String str) {
        return Double.valueOf(str);
    }
}
