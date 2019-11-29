package com.android.b.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class k extends ByteArrayOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final b f4581a;

    public k(b bVar, int i) {
        this.f4581a = bVar;
        this.buf = this.f4581a.a(Math.max(i, 256));
    }

    public void close() throws IOException {
        this.f4581a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f4581a.a(this.buf);
    }

    private void a(int i) {
        if (this.count + i > this.buf.length) {
            byte[] a2 = this.f4581a.a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a2, 0, this.count);
            this.f4581a.a(this.buf);
            this.buf = a2;
        }
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }

    public synchronized void write(int i) {
        a(1);
        super.write(i);
    }
}
