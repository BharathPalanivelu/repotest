package com.thoughtworks.xstream.converters.basic;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public abstract class AbstractSingleValueConverter implements SingleValueConverter {
    public abstract boolean canConvert(Class cls);

    public abstract Object fromString(String str);

    public String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }
}
