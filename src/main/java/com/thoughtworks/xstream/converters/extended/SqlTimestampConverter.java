package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import com.thoughtworks.xstream.core.util.ThreadSafeSimpleDateFormat;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.TimeZone;

public class SqlTimestampConverter extends AbstractSingleValueConverter {
    private final ThreadSafeSimpleDateFormat format = new ThreadSafeSimpleDateFormat("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("UTC"), 0, 5, false);

    public boolean canConvert(Class cls) {
        return cls.equals(Timestamp.class);
    }

    public String toString(Object obj) {
        Timestamp timestamp = (Timestamp) obj;
        StringBuffer stringBuffer = new StringBuffer(this.format.format(timestamp));
        stringBuffer.append('.');
        if (timestamp.getNanos() == 0) {
            stringBuffer.append('0');
        } else {
            String valueOf = String.valueOf(timestamp.getNanos() + 1000000000);
            int i = 10;
            while (i > 2 && valueOf.charAt(i - 1) == '0') {
                i--;
            }
            stringBuffer.append(valueOf.subSequence(1, i));
        }
        return stringBuffer.toString();
    }

    public Object fromString(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || str.length() - lastIndexOf < 2 || str.length() - lastIndexOf > 10) {
            throw new ConversionException("Timestamp format must be yyyy-mm-dd hh:mm:ss[.fffffffff]");
        }
        try {
            Timestamp timestamp = new Timestamp(this.format.parse(str.substring(0, lastIndexOf)).getTime());
            StringBuffer stringBuffer = new StringBuffer(str.substring(lastIndexOf + 1));
            while (stringBuffer.length() != 9) {
                stringBuffer.append('0');
            }
            timestamp.setNanos(Integer.parseInt(stringBuffer.toString()));
            return timestamp;
        } catch (NumberFormatException e2) {
            throw new ConversionException("Timestamp format must be yyyy-mm-dd hh:mm:ss[.fffffffff]", e2);
        } catch (ParseException e3) {
            throw new ConversionException("Timestamp format must be yyyy-mm-dd hh:mm:ss[.fffffffff]", e3);
        }
    }
}
