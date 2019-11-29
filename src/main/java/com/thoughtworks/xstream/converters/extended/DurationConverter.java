package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

public class DurationConverter extends AbstractSingleValueConverter {
    private final DatatypeFactory factory;

    public DurationConverter() {
        this(new Object() {
            /* access modifiers changed from: package-private */
            public DatatypeFactory getFactory() {
                try {
                    return DatatypeFactory.newInstance();
                } catch (DatatypeConfigurationException unused) {
                    return null;
                }
            }
        }.getFactory());
    }

    public DurationConverter(DatatypeFactory datatypeFactory) {
        this.factory = datatypeFactory;
    }

    public boolean canConvert(Class cls) {
        return this.factory != null && Duration.class.isAssignableFrom(cls);
    }

    public Object fromString(String str) {
        return this.factory.newDuration(str);
    }
}
