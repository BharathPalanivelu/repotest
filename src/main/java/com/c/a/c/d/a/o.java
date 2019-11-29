package com.c.a.c.d.a;

import android.graphics.Bitmap;
import com.c.a.c.b.a.b;
import com.c.a.c.b.a.e;
import com.c.a.c.b.s;
import com.c.a.c.d.a.h;
import com.c.a.c.j;
import com.c.a.c.k;
import com.c.a.i.c;
import com.c.a.i.f;
import java.io.IOException;
import java.io.InputStream;

public class o implements k<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final h f6037a;

    /* renamed from: b  reason: collision with root package name */
    private final b f6038b;

    public o(h hVar, b bVar) {
        this.f6037a = hVar;
        this.f6038b = bVar;
    }

    public boolean a(InputStream inputStream, j jVar) throws IOException {
        return this.f6037a.a(inputStream);
    }

    public s<Bitmap> a(InputStream inputStream, int i, int i2, j jVar) throws IOException {
        m mVar;
        boolean z;
        if (inputStream instanceof m) {
            mVar = (m) inputStream;
            z = false;
        } else {
            mVar = new m(inputStream, this.f6038b);
            z = true;
        }
        c a2 = c.a(mVar);
        try {
            return this.f6037a.a((InputStream) new f(a2), i, i2, jVar, (h.a) new a(mVar, a2));
        } finally {
            a2.b();
            if (z) {
                mVar.b();
            }
        }
    }

    static class a implements h.a {

        /* renamed from: a  reason: collision with root package name */
        private final m f6039a;

        /* renamed from: b  reason: collision with root package name */
        private final c f6040b;

        public a(m mVar, c cVar) {
            this.f6039a = mVar;
            this.f6040b = cVar;
        }

        public void a() {
            this.f6039a.a();
        }

        public void a(e eVar, Bitmap bitmap) throws IOException {
            IOException a2 = this.f6040b.a();
            if (a2 != null) {
                if (bitmap != null) {
                    eVar.a(bitmap);
                }
                throw a2;
            }
        }
    }
}
