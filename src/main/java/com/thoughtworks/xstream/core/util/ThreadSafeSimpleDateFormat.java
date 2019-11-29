package com.thoughtworks.xstream.core.util;

import com.thoughtworks.xstream.core.util.Pool;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ThreadSafeSimpleDateFormat {
    /* access modifiers changed from: private */
    public final String formatString;
    private final Pool pool;
    private final TimeZone timeZone;

    public ThreadSafeSimpleDateFormat(String str, TimeZone timeZone2, int i, int i2, boolean z) {
        this(str, timeZone2, Locale.ENGLISH, i, i2, z);
    }

    public ThreadSafeSimpleDateFormat(String str, TimeZone timeZone2, final Locale locale, int i, int i2, final boolean z) {
        this.formatString = str;
        this.timeZone = timeZone2;
        this.pool = new Pool(i, i2, new Pool.Factory() {
            public Object newInstance() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ThreadSafeSimpleDateFormat.this.formatString, locale);
                simpleDateFormat.setLenient(z);
                return simpleDateFormat;
            }
        });
    }

    public String format(Date date) {
        DateFormat fetchFromPool = fetchFromPool();
        try {
            return fetchFromPool.format(date);
        } finally {
            this.pool.putInPool(fetchFromPool);
        }
    }

    public Date parse(String str) throws ParseException {
        DateFormat fetchFromPool = fetchFromPool();
        try {
            return fetchFromPool.parse(str);
        } finally {
            this.pool.putInPool(fetchFromPool);
        }
    }

    private DateFormat fetchFromPool() {
        DateFormat dateFormat = (DateFormat) this.pool.fetchFromPool();
        TimeZone timeZone2 = this.timeZone;
        if (timeZone2 == null) {
            timeZone2 = TimeZone.getDefault();
        }
        if (!timeZone2.equals(dateFormat.getTimeZone())) {
            dateFormat.setTimeZone(timeZone2);
        }
        return dateFormat;
    }

    public String toString() {
        return this.formatString;
    }
}
