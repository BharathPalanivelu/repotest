package com.thoughtworks.xstream.converters.basic;

public class LongConverter extends AbstractSingleValueConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(Long.TYPE) || cls.equals(Long.class);
    }

    public Object fromString(String str) {
        long j;
        long j2;
        int length = str.length();
        if (length == 0) {
            throw new NumberFormatException("For input string: \"\"");
        } else if (length < 17) {
            return Long.decode(str);
        } else {
            char charAt = str.charAt(0);
            if (charAt != '0' && charAt != '#') {
                return Long.decode(str);
            }
            char charAt2 = str.charAt(1);
            if (charAt == '#' && length == 17) {
                j = Long.parseLong(str.substring(1, 9), 16) << 32;
                j2 = Long.parseLong(str.substring(9, 17), 16);
            } else if ((charAt2 == 'x' || charAt2 == 'X') && length == 18) {
                j2 = Long.parseLong(str.substring(10, 18), 16);
                j = Long.parseLong(str.substring(2, 10), 16) << 32;
            } else if (length != 23 || charAt2 != '1') {
                return Long.decode(str);
            } else {
                j2 = Long.parseLong(str.substring(12, 23), 8);
                j = Long.parseLong(str.substring(1, 12), 8) << 33;
            }
            return new Long(j2 | j);
        }
    }
}
