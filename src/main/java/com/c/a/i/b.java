package com.c.a.i;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final long f6243a;

    /* renamed from: b  reason: collision with root package name */
    private int f6244b;

    public static InputStream a(InputStream inputStream, long j) {
        return new b(inputStream, j);
    }

    b(InputStream inputStream, long j) {
        super(inputStream);
        this.f6243a = j;
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.f6243a - ((long) this.f6244b), (long) this.in.available());
    }

    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return a(super.read(bArr, i, i2));
    }

    private int a(int i) throws IOException {
        if (i >= 0) {
            this.f6244b += i;
        } else if (this.f6243a - ((long) this.f6244b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f6243a + ", but read: " + this.f6244b);
        }
        return i;
    }
}
