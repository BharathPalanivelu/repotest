package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import java.sql.Time;

public class SqlTimeConverter extends AbstractSingleValueConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(Time.class);
    }

    public Object fromString(String str) {
        return Time.valueOf(str);
    }
}
