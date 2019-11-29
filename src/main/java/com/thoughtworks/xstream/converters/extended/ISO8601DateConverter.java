package com.thoughtworks.xstream.converters.extended;

import java.util.Calendar;
import java.util.Date;

public class ISO8601DateConverter extends ISO8601GregorianCalendarConverter {
    public boolean canConvert(Class cls) {
        return cls.equals(Date.class);
    }

    public Object fromString(String str) {
        return ((Calendar) super.fromString(str)).getTime();
    }

    public String toString(Object obj) {
        Calendar instance = Calendar.getInstance();
        instance.setTime((Date) obj);
        return super.toString(instance);
    }
}
