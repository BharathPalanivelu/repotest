package com.thoughtworks.xstream.converters.basic;

import java.math.BigInteger;

public class BigIntegerConverter extends AbstractSingleValueConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(BigInteger.class);
    }

    public Object fromString(String str) {
        return new BigInteger(str);
    }
}
