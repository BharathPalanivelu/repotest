package com.thoughtworks.xstream.converters.basic;

import com.thoughtworks.xstream.converters.ConversionException;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConverter extends AbstractSingleValueConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(URL.class);
    }

    public Object fromString(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new ConversionException((Throwable) e2);
        }
    }
}
