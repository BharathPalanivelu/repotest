package com.thoughtworks.xstream.converters.basic;

import com.thoughtworks.xstream.converters.ConversionException;
import java.util.UUID;

public class UUIDConverter extends AbstractSingleValueConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(UUID.class);
    }

    public Object fromString(String str) {
        try {
            return UUID.fromString(str);
        } catch (IllegalArgumentException e2) {
            throw new ConversionException("Cannot create UUID instance", e2);
        }
    }
}
