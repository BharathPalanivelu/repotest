package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import java.sql.Date;

public class SqlDateConverter extends AbstractSingleValueConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(Date.class);
    }

    public Object fromString(String str) {
        return Date.valueOf(str);
    }
}
