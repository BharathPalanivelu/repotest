package com.thoughtworks.xstream.converters.basic;

public class ByteConverter extends AbstractSingleValueConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(Byte.TYPE) || cls.equals(Byte.class);
    }

    public Object fromString(String str) {
        int intValue = Integer.decode(str).intValue();
        if (intValue >= -128 && intValue <= 255) {
            return new Byte((byte) intValue);
        }
        throw new NumberFormatException("For input string: \"" + str + '\"');
    }
}
