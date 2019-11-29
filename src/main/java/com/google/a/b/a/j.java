package com.google.a.b.a;

import com.google.a.c.a;
import com.google.a.d.b;
import com.google.a.d.c;
import com.google.a.f;
import com.google.a.u;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class j extends w<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final x f8780a = new x() {
        public <T> w<T> create(f fVar, a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new j();
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f8781b = new SimpleDateFormat("MMM d, yyyy");

    /* renamed from: a */
    public synchronized Date read(com.google.a.d.a aVar) throws IOException {
        if (aVar.f() == b.NULL) {
            aVar.j();
            return null;
        }
        try {
            return new Date(this.f8781b.parse(aVar.h()).getTime());
        } catch (ParseException e2) {
            throw new u((Throwable) e2);
        }
    }

    /* renamed from: a */
    public synchronized void write(c cVar, Date date) throws IOException {
        cVar.b(date == null ? null : this.f8781b.format(date));
    }
}
