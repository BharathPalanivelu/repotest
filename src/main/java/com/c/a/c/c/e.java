package com.c.a.c.c;

import android.util.Base64;
import com.c.a.c.a.b;
import com.c.a.c.c.n;
import com.c.a.c.j;
import com.c.a.g;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e<Data> implements n<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Data> f5911a;

    public interface a<Data> {
        Class<Data> a();

        Data a(String str) throws IllegalArgumentException;

        void a(Data data) throws IOException;
    }

    public e(a<Data> aVar) {
        this.f5911a = aVar;
    }

    public n.a<Data> a(String str, int i, int i2, j jVar) {
        return new n.a<>(new com.c.a.h.b(str), new b(str, this.f5911a));
    }

    public boolean a(String str) {
        return str.startsWith("data:image");
    }

    private static final class b<Data> implements com.c.a.c.a.b<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final String f5912a;

        /* renamed from: b  reason: collision with root package name */
        private final a<Data> f5913b;

        /* renamed from: c  reason: collision with root package name */
        private Data f5914c;

        public void b() {
        }

        public b(String str, a<Data> aVar) {
            this.f5912a = str;
            this.f5913b = aVar;
        }

        public void a(g gVar, b.a<? super Data> aVar) {
            try {
                this.f5914c = this.f5913b.a(this.f5912a);
                aVar.a(this.f5914c);
            } catch (IllegalArgumentException e2) {
                aVar.a((Exception) e2);
            }
        }

        public void a() {
            try {
                this.f5913b.a(this.f5914c);
            } catch (IOException unused) {
            }
        }

        public Class<Data> d() {
            return this.f5913b.a();
        }

        public com.c.a.c.a c() {
            return com.c.a.c.a.LOCAL;
        }
    }

    public static final class c implements o<String, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final a<InputStream> f5915a = new a<InputStream>() {
            /* renamed from: b */
            public InputStream a(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }

            public void a(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            public Class<InputStream> a() {
                return InputStream.class;
            }
        };

        public final n<String, InputStream> a(r rVar) {
            return new e(this.f5915a);
        }
    }
}
