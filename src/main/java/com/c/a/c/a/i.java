package com.c.a.c.a;

import com.c.a.c.a.c;
import com.c.a.c.b.a.b;
import com.c.a.c.d.a.m;
import java.io.IOException;
import java.io.InputStream;

public final class i implements c<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final m f5670a;

    i(InputStream inputStream, b bVar) {
        this.f5670a = new m(inputStream, bVar);
        this.f5670a.mark(5242880);
    }

    /* renamed from: c */
    public InputStream a() throws IOException {
        this.f5670a.reset();
        return this.f5670a;
    }

    public void b() {
        this.f5670a.b();
    }

    public static final class a implements c.a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final b f5671a;

        public a(b bVar) {
            this.f5671a = bVar;
        }

        public c<InputStream> a(InputStream inputStream) {
            return new i(inputStream, this.f5671a);
        }

        public Class<InputStream> a() {
            return InputStream.class;
        }
    }
}
