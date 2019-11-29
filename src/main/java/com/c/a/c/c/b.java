package com.c.a.c.c;

import com.c.a.c.a.b;
import com.c.a.c.c.n;
import com.c.a.c.j;
import com.c.a.g;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class b<Data> implements n<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    private final C0104b<Data> f5905a;

    /* renamed from: com.c.a.c.c.b$b  reason: collision with other inner class name */
    public interface C0104b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    public boolean a(byte[] bArr) {
        return true;
    }

    public b(C0104b<Data> bVar) {
        this.f5905a = bVar;
    }

    public n.a<Data> a(byte[] bArr, int i, int i2, j jVar) {
        return new n.a<>(com.c.a.h.a.a(), new c(bArr, this.f5905a));
    }

    private static class c<Data> implements com.c.a.c.a.b<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f5907a;

        /* renamed from: b  reason: collision with root package name */
        private final C0104b<Data> f5908b;

        public void a() {
        }

        public void b() {
        }

        public c(byte[] bArr, C0104b<Data> bVar) {
            this.f5907a = bArr;
            this.f5908b = bVar;
        }

        public void a(g gVar, b.a<? super Data> aVar) {
            aVar.a(this.f5908b.b(this.f5907a));
        }

        public Class<Data> d() {
            return this.f5908b.a();
        }

        public com.c.a.c.a c() {
            return com.c.a.c.a.LOCAL;
        }
    }

    public static class a implements o<byte[], ByteBuffer> {
        public n<byte[], ByteBuffer> a(r rVar) {
            return new b(new C0104b<ByteBuffer>() {
                /* renamed from: a */
                public ByteBuffer b(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }

                public Class<ByteBuffer> a() {
                    return ByteBuffer.class;
                }
            });
        }
    }

    public static class d implements o<byte[], InputStream> {
        public n<byte[], InputStream> a(r rVar) {
            return new b(new C0104b<InputStream>() {
                /* renamed from: a */
                public InputStream b(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }

                public Class<InputStream> a() {
                    return InputStream.class;
                }
            });
        }
    }
}
