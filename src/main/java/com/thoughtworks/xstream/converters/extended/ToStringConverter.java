package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ToStringConverter extends AbstractSingleValueConverter {
    private final Class clazz;
    private final Constructor ctor;

    public ToStringConverter(Class cls) throws NoSuchMethodException {
        this.clazz = cls;
        this.ctor = cls.getConstructor(new Class[]{String.class});
    }

    public boolean canConvert(Class cls) {
        return cls.equals(this.clazz);
    }

    public String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public Object fromString(String str) {
        try {
            return this.ctor.newInstance(new Object[]{str});
        } catch (InstantiationException e2) {
            throw new ConversionException("Unable to instantiate single String param constructor", e2);
        } catch (IllegalAccessException e3) {
            throw new ConversionException("Unable to access single String param constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new ConversionException("Unable to target single String param constructor", e4.getTargetException());
        }
    }
}
