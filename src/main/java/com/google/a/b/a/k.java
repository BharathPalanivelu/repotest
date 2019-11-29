package com.google.a.b.a;

import com.google.a.c.a;
import com.google.a.d.b;
import com.google.a.d.c;
import com.google.a.f;
import com.google.a.u;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class k extends w<Time> {

    /* renamed from: a  reason: collision with root package name */
    public static final x f8782a = new x() {
        public <T> w<T> create(f fVar, a<T> aVar) {
            if (aVar.getRawType() == Time.class) {
                return new k();
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f8783b = new SimpleDateFormat("hh:mm:ss a");

    /* renamed from: a */
    public synchronized Time read(com.google.a.d.a aVar) throws IOException {
        if (aVar.f() == b.NULL) {
            aVar.j();
            return null;
        }
        try {
            return new Time(this.f8783b.parse(aVar.h()).getTime());
        } catch (ParseException e2) {
            throw new u((Throwable) e2);
        }
    }

    /* renamed from: a */
    public synchronized void write(c cVar, Time time) throws IOException {
        cVar.b(time == null ? null : this.f8783b.format(time));
    }
}
