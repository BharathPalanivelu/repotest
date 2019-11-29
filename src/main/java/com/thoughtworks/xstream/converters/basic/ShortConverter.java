package com.thoughtworks.xstream.converters.basic;

public class ShortConverter extends AbstractSingleValueConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(Short.TYPE) || cls.equals(Short.class);
    }

    public Object fromString(String str) {
        int intValue = Integer.decode(str).intValue();
        if (intValue >= -32768 && intValue <= 65535) {
            return new Short((short) intValue);
        }
        throw new NumberFormatException("For input string: \"" + str + '\"');
    }
}
