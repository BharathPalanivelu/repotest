package com.bca.xco.widget.d.a;

import com.bca.xco.widget.d.a.a.c;
import com.bca.xco.widget.d.b.b;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class aa implements Closeable {
    public abstract u a();

    public abstract long b();

    public abstract b c();

    /* JADX INFO: finally extract failed */
    public final byte[] d() {
        long b2 = b();
        if (b2 <= 2147483647L) {
            b c2 = c();
            try {
                byte[] k = c2.k();
                c.a((Closeable) c2);
                if (b2 == -1 || b2 == ((long) k.length)) {
                    return k;
                }
                throw new IOException("Content-Length and stream length disagree");
            } catch (Throwable th) {
                c.a((Closeable) c2);
                throw th;
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + b2);
        }
    }

    public final String e() {
        return new String(d(), f().name());
    }

    private Charset f() {
        u a2 = a();
        return a2 != null ? a2.a(c.f4797c) : c.f4797c;
    }

    public void close() {
        c.a((Closeable) c());
    }
}
