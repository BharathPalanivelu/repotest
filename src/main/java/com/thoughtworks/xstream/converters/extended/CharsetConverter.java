package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import java.nio.charset.Charset;

public class CharsetConverter extends AbstractSingleValueConverter {
    public boolean canConvert(Class cls) {
        return Charset.class.isAssignableFrom(cls);
    }

    public String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return ((Charset) obj).name();
    }

    public Object fromString(String str) {
        return Charset.forName(str);
    }
}
