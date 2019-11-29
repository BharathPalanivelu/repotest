package com.thoughtworks.xstream.converters.basic;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.ErrorReporter;
import com.thoughtworks.xstream.converters.ErrorWriter;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.util.ThreadSafeSimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateConverter extends AbstractSingleValueConverter implements ErrorReporter {
    private static final String[] DEFAULT_ACCEPTABLE_FORMATS;
    private static final String DEFAULT_ERA_PATTERN;
    private static final String DEFAULT_PATTERN;
    private static final long ERA_START;
    private static final TimeZone UTC = TimeZone.getTimeZone("UTC");
    private final ThreadSafeSimpleDateFormat[] acceptableFormats;
    private final ThreadSafeSimpleDateFormat defaultEraFormat;
    private final ThreadSafeSimpleDateFormat defaultFormat;

    static {
        ArrayList arrayList = new ArrayList();
        boolean canParseUTCDateFormat = JVM.canParseUTCDateFormat();
        DEFAULT_PATTERN = canParseUTCDateFormat ? "yyyy-MM-dd HH:mm:ss.S z" : "yyyy-MM-dd HH:mm:ss.S 'UTC'";
        DEFAULT_ERA_PATTERN = canParseUTCDateFormat ? "yyyy-MM-dd G HH:mm:ss.S z" : "yyyy-MM-dd G HH:mm:ss.S 'UTC'";
        arrayList.add("yyyy-MM-dd HH:mm:ss.S z");
        if (!canParseUTCDateFormat) {
            arrayList.add("yyyy-MM-dd HH:mm:ss.S z");
        }
        arrayList.add("yyyy-MM-dd HH:mm:ss.S a");
        arrayList.add("yyyy-MM-dd HH:mm:ssz");
        arrayList.add("yyyy-MM-dd HH:mm:ss z");
        if (!canParseUTCDateFormat) {
            arrayList.add("yyyy-MM-dd HH:mm:ss 'UTC'");
        }
        if (JVM.canParseISO8601TimeZoneInDateFormat()) {
            arrayList.add("yyyy-MM-dd'T'HH:mm:ss.SX");
            arrayList.add("yyyy-MM-dd'T'HH:mm:ssX");
            arrayList.add("yyyy-MM-dd'T'HH:mmX");
        }
        arrayList.add("yyyy-MM-dd HH:mm:ssa");
        DEFAULT_ACCEPTABLE_FORMATS = (String[]) arrayList.toArray(new String[arrayList.size()]);
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(UTC);
        instance.clear();
        instance.set(1, 0, 1);
        ERA_START = instance.getTime().getTime();
    }

    public DateConverter() {
        this(false);
    }

    public DateConverter(TimeZone timeZone) {
        this(DEFAULT_PATTERN, DEFAULT_ACCEPTABLE_FORMATS, timeZone);
    }

    public DateConverter(boolean z) {
        this(DEFAULT_PATTERN, DEFAULT_ACCEPTABLE_FORMATS, z);
    }

    public DateConverter(String str, String[] strArr) {
        this(str, strArr, false);
    }

    public DateConverter(String str, String[] strArr, TimeZone timeZone) {
        this(str, strArr, timeZone, false);
    }

    public DateConverter(String str, String[] strArr, boolean z) {
        this(str, strArr, UTC, z);
    }

    public DateConverter(String str, String[] strArr, TimeZone timeZone, boolean z) {
        this(DEFAULT_ERA_PATTERN, str, strArr, Locale.ENGLISH, timeZone, z);
    }

    public DateConverter(String str, String str2, String[] strArr, Locale locale, TimeZone timeZone, boolean z) {
        if (str != null) {
            this.defaultEraFormat = new ThreadSafeSimpleDateFormat(str, timeZone, locale, 4, 20, z);
        } else {
            this.defaultEraFormat = null;
        }
        this.defaultFormat = new ThreadSafeSimpleDateFormat(str2, timeZone, locale, 4, 20, z);
        int i = 0;
        this.acceptableFormats = strArr != null ? new ThreadSafeSimpleDateFormat[strArr.length] : new ThreadSafeSimpleDateFormat[0];
        while (true) {
            ThreadSafeSimpleDateFormat[] threadSafeSimpleDateFormatArr = this.acceptableFormats;
            if (i < threadSafeSimpleDateFormatArr.length) {
                threadSafeSimpleDateFormatArr[i] = new ThreadSafeSimpleDateFormat(strArr[i], timeZone, locale, 1, 20, z);
                i++;
            } else {
                return;
            }
        }
    }

    public boolean canConvert(Class cls) {
        return cls.equals(Date.class);
    }

    public Object fromString(String str) {
        ThreadSafeSimpleDateFormat threadSafeSimpleDateFormat = this.defaultEraFormat;
        if (threadSafeSimpleDateFormat != null) {
            try {
                return threadSafeSimpleDateFormat.parse(str);
            } catch (ParseException unused) {
            }
        }
        ThreadSafeSimpleDateFormat threadSafeSimpleDateFormat2 = this.defaultEraFormat;
        ThreadSafeSimpleDateFormat threadSafeSimpleDateFormat3 = this.defaultFormat;
        if (threadSafeSimpleDateFormat2 != threadSafeSimpleDateFormat3) {
            try {
                return threadSafeSimpleDateFormat3.parse(str);
            } catch (ParseException unused2) {
            }
        }
        int i = 0;
        while (true) {
            ThreadSafeSimpleDateFormat[] threadSafeSimpleDateFormatArr = this.acceptableFormats;
            if (i < threadSafeSimpleDateFormatArr.length) {
                try {
                    return threadSafeSimpleDateFormatArr[i].parse(str);
                } catch (ParseException unused3) {
                    i++;
                }
            } else {
                throw new ConversionException("Cannot parse date " + str);
            }
        }
    }

    public String toString(Object obj) {
        Date date = (Date) obj;
        if (date.getTime() < ERA_START) {
            ThreadSafeSimpleDateFormat threadSafeSimpleDateFormat = this.defaultEraFormat;
            if (threadSafeSimpleDateFormat != null) {
                return threadSafeSimpleDateFormat.format(date);
            }
        }
        return this.defaultFormat.format(date);
    }

    public void appendErrors(ErrorWriter errorWriter) {
        errorWriter.add("Default date pattern", this.defaultFormat.toString());
        ThreadSafeSimpleDateFormat threadSafeSimpleDateFormat = this.defaultEraFormat;
        if (threadSafeSimpleDateFormat != null) {
            errorWriter.add("Default era date pattern", threadSafeSimpleDateFormat.toString());
        }
        int i = 0;
        while (true) {
            ThreadSafeSimpleDateFormat[] threadSafeSimpleDateFormatArr = this.acceptableFormats;
            if (i < threadSafeSimpleDateFormatArr.length) {
                errorWriter.add("Alternative date pattern", threadSafeSimpleDateFormatArr[i].toString());
                i++;
            } else {
                return;
            }
        }
    }
}
