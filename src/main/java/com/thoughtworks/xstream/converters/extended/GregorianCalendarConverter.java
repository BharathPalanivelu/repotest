package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class GregorianCalendarConverter implements Converter {
    public boolean canConvert(Class cls) {
        return cls.equals(GregorianCalendar.class);
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        GregorianCalendar gregorianCalendar = (GregorianCalendar) obj;
        ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, "time", Long.TYPE);
        hierarchicalStreamWriter.setValue(String.valueOf(gregorianCalendar.getTime().getTime()));
        hierarchicalStreamWriter.endNode();
        ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, "timezone", String.class);
        hierarchicalStreamWriter.setValue(gregorianCalendar.getTimeZone().getID());
        hierarchicalStreamWriter.endNode();
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        String str;
        hierarchicalStreamReader.moveDown();
        long parseLong = Long.parseLong(hierarchicalStreamReader.getValue());
        hierarchicalStreamReader.moveUp();
        if (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            str = hierarchicalStreamReader.getValue();
            hierarchicalStreamReader.moveUp();
        } else {
            str = TimeZone.getDefault().getID();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeZone(TimeZone.getTimeZone(str));
        gregorianCalendar.setTime(new Date(parseLong));
        return gregorianCalendar;
    }
}
