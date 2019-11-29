package com.thoughtworks.xstream.converters.basic;

public class IntConverter extends AbstractSingleValueConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(Integer.TYPE) || cls.equals(Integer.class);
    }

    public Object fromString(String str) {
        long longValue = Long.decode(str).longValue();
        if (longValue >= -2147483648L && longValue <= 4294967295L) {
            return new Integer((int) longValue);
        }
        throw new NumberFormatException("For input string: \"" + str + '\"');
    }
}
