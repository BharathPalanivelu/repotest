package com.google.a.b.a;

import com.google.a.b.e;
import com.google.a.b.j;
import com.google.a.c.a;
import com.google.a.d.b;
import com.google.a.f;
import com.google.a.u;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class c extends w<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final x f8743a = new x() {
        public <T> w<T> create(f fVar, a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new c();
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final List<DateFormat> f8744b = new ArrayList();

    public c() {
        this.f8744b.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f8744b.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (e.b()) {
            this.f8744b.add(j.a(2, 2));
        }
    }

    /* renamed from: a */
    public Date read(com.google.a.d.a aVar) throws IOException {
        if (aVar.f() != b.NULL) {
            return a(aVar.h());
        }
        aVar.j();
        return null;
    }

    private synchronized Date a(String str) {
        for (DateFormat parse : this.f8744b) {
            try {
                return parse.parse(str);
            } catch (ParseException unused) {
            }
        }
        try {
            return com.google.a.b.a.a.a.a(str, new ParsePosition(0));
        } catch (ParseException e2) {
            throw new u(str, e2);
        }
    }

    /* renamed from: a */
    public synchronized void write(com.google.a.d.c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.f();
        } else {
            cVar.b(this.f8744b.get(0).format(date));
        }
    }
}
