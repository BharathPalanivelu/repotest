package com.c.a.c.d.b;

import com.c.a.c.a.c;
import java.io.IOException;
import java.nio.ByteBuffer;

public class a implements c<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f6055a;

    public void b() {
    }

    public a(ByteBuffer byteBuffer) {
        this.f6055a = byteBuffer;
    }

    /* renamed from: c */
    public ByteBuffer a() throws IOException {
        this.f6055a.position(0);
        return this.f6055a;
    }

    /* renamed from: com.c.a.c.d.b.a$a  reason: collision with other inner class name */
    public static class C0107a implements c.a<ByteBuffer> {
        public c<ByteBuffer> a(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }
}
