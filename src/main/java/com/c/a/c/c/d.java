package com.c.a.c.c;

import android.util.Log;
import com.c.a.c.a.b;
import com.c.a.c.c.n;
import com.c.a.c.j;
import com.c.a.g;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class d implements n<File, ByteBuffer> {
    public boolean a(File file) {
        return true;
    }

    public n.a<ByteBuffer> a(File file, int i, int i2, j jVar) {
        return new n.a<>(new com.c.a.h.b(file), new a(file));
    }

    public static class b implements o<File, ByteBuffer> {
        public n<File, ByteBuffer> a(r rVar) {
            return new d();
        }
    }

    private static class a implements com.c.a.c.a.b<ByteBuffer> {

        /* renamed from: a  reason: collision with root package name */
        private final File f5910a;

        public void a() {
        }

        public void b() {
        }

        public a(File file) {
            this.f5910a = file;
        }

        public void a(g gVar, b.a<? super ByteBuffer> aVar) {
            try {
                aVar.a(com.c.a.i.a.a(this.f5910a));
            } catch (IOException e2) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e2);
                }
                aVar.a((Exception) e2);
            }
        }

        public Class<ByteBuffer> d() {
            return ByteBuffer.class;
        }

        public com.c.a.c.a c() {
            return com.c.a.c.a.LOCAL;
        }
    }
}
