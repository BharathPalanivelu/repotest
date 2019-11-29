package com.thoughtworks.xstream.converters.basic;

import com.thoughtworks.xstream.converters.ConversionException;
import java.net.URI;
import java.net.URISyntaxException;

public class URIConverter extends AbstractSingleValueConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(URI.class);
    }

    public Object fromString(String str) {
        try {
            return new URI(str);
        } catch (URISyntaxException e2) {
            throw new ConversionException((Throwable) e2);
        }
    }
}
