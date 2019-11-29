package com.google.a;

import com.google.a.b.e;
import com.google.a.b.j;
import com.google.a.d.b;
import com.google.a.d.c;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

final class a extends w<Date> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<? extends Date> f8734a;

    /* renamed from: b  reason: collision with root package name */
    private final List<DateFormat> f8735b = new ArrayList();

    a(Class<? extends Date> cls, String str) {
        this.f8734a = a(cls);
        this.f8735b.add(new SimpleDateFormat(str, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f8735b.add(new SimpleDateFormat(str));
        }
    }

    public a(Class<? extends Date> cls, int i, int i2) {
        this.f8734a = a(cls);
        this.f8735b.add(DateFormat.getDateTimeInstance(i, i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f8735b.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (e.b()) {
            this.f8735b.add(j.a(i, i2));
        }
    }

    private static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    /* renamed from: a */
    public void write(c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.f();
            return;
        }
        synchronized (this.f8735b) {
            cVar.b(this.f8735b.get(0).format(date));
        }
    }

    /* renamed from: a */
    public Date read(com.google.a.d.a aVar) throws IOException {
        if (aVar.f() == b.NULL) {
            aVar.j();
            return null;
        }
        Date a2 = a(aVar.h());
        Class<? extends Date> cls = this.f8734a;
        if (cls == Date.class) {
            return a2;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(a2.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(a2.getTime());
        }
        throw new AssertionError();
    }

    private Date a(String str) {
        synchronized (this.f8735b) {
            for (DateFormat parse : this.f8735b) {
                try {
                    Date parse2 = parse.parse(str);
                    return parse2;
                } catch (ParseException unused) {
                }
            }
            try {
                Date a2 = com.google.a.b.a.a.a.a(str, new ParsePosition(0));
                return a2;
            } catch (ParseException e2) {
                throw new u(str, e2);
            }
        }
    }

    public String toString() {
        DateFormat dateFormat = this.f8735b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
