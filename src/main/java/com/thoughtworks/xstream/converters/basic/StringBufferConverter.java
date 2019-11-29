package com.thoughtworks.xstream.converters.basic;

public class StringBufferConverter extends AbstractSingleValueConverter {
    public Object fromString(String str) {
        return new StringBuffer(str);
    }

    public boolean canConvert(Class cls) {
        return cls.equals(StringBuffer.class);
    }
}
