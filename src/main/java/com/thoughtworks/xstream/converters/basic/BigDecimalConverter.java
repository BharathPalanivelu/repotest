package com.thoughtworks.xstream.converters.basic;

import java.math.BigDecimal;

public class BigDecimalConverter extends AbstractSingleValueConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(BigDecimal.class);
    }

    public Object fromString(String str) {
        return new BigDecimal(str);
    }
}
