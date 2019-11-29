package com.thoughtworks.xstream.converters.extended;

import java.sql.Timestamp;
import java.util.Date;

public class ISO8601SqlTimestampConverter extends ISO8601DateConverter {
    private static final String PADDING = "000000000";

    public boolean canConvert(Class cls) {
        return cls.equals(Timestamp.class);
    }

    public Object fromString(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        int i = 0;
        if (lastIndexOf > 0) {
            int i2 = lastIndexOf + 1;
            int i3 = i2;
            while (Character.isDigit(str.charAt(i3))) {
                i3++;
            }
            int parseInt = Integer.parseInt(str.substring(i2, i3));
            str = str.substring(0, lastIndexOf) + str.substring(i3);
            i = parseInt;
        }
        Timestamp timestamp = new Timestamp(((Date) super.fromString(str)).getTime());
        timestamp.setNanos(i);
        return timestamp;
    }

    public String toString(Object obj) {
        Timestamp timestamp = (Timestamp) obj;
        String iSO8601DateConverter = super.toString(new Date((timestamp.getTime() / 1000) * 1000));
        String valueOf = String.valueOf(timestamp.getNanos());
        int lastIndexOf = iSO8601DateConverter.lastIndexOf(46);
        return iSO8601DateConverter.substring(0, lastIndexOf + 1) + PADDING.substring(valueOf.length()) + valueOf + iSO8601DateConverter.substring(lastIndexOf + 4);
    }
}
