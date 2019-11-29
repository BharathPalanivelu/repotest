package com.squareup.a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class p extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f30570a;

    /* renamed from: b  reason: collision with root package name */
    private long f30571b;

    /* renamed from: c  reason: collision with root package name */
    private long f30572c;

    /* renamed from: d  reason: collision with root package name */
    private long f30573d;

    /* renamed from: e  reason: collision with root package name */
    private long f30574e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f30575f;

    /* renamed from: g  reason: collision with root package name */
    private int f30576g;

    public p(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public p(InputStream inputStream, int i) {
        this(inputStream, i, 1024);
    }

    private p(InputStream inputStream, int i, int i2) {
        this.f30574e = -1;
        this.f30575f = true;
        this.f30576g = -1;
        this.f30570a = !inputStream.markSupported() ? new BufferedInputStream(inputStream, i) : inputStream;
        this.f30576g = i2;
    }

    public void mark(int i) {
        this.f30574e = a(i);
    }

    public long a(int i) {
        long j = this.f30571b + ((long) i);
        if (this.f30573d < j) {
            b(j);
        }
        return this.f30571b;
    }

    public void a(boolean z) {
        this.f30575f = z;
    }

    private void b(long j) {
        try {
            if (this.f30572c >= this.f30571b || this.f30571b > this.f30573d) {
                this.f30572c = this.f30571b;
                this.f30570a.mark((int) (j - this.f30571b));
            } else {
                this.f30570a.reset();
                this.f30570a.mark((int) (j - this.f30572c));
                a(this.f30572c, this.f30571b);
            }
            this.f30573d = j;
        } catch (IOException e2) {
            throw new IllegalStateException("Unable to mark: " + e2);
        }
    }

    public void reset() throws IOException {
        a(this.f30574e);
    }

    public void a(long j) throws IOException {
        if (this.f30571b > this.f30573d || j < this.f30572c) {
            throw new IOException("Cannot reset");
        }
        this.f30570a.reset();
        a(this.f30572c, j);
        this.f30571b = j;
    }

    private void a(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.f30570a.skip(j2 - j);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j += skip;
        }
    }

    public int read() throws IOException {
        if (!this.f30575f) {
            long j = this.f30573d;
            if (this.f30571b + 1 > j) {
                b(j + ((long) this.f30576g));
            }
        }
        int read = this.f30570a.read();
        if (read != -1) {
            this.f30571b++;
        }
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        if (!this.f30575f) {
            long j = this.f30571b;
            if (((long) bArr.length) + j > this.f30573d) {
                b(j + ((long) bArr.length) + ((long) this.f30576g));
            }
        }
        int read = this.f30570a.read(bArr);
        if (read != -1) {
            this.f30571b += (long) read;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f30575f) {
            long j = this.f30571b;
            long j2 = (long) i2;
            if (j + j2 > this.f30573d) {
                b(j + j2 + ((long) this.f30576g));
            }
        }
        int read = this.f30570a.read(bArr, i, i2);
        if (read != -1) {
            this.f30571b += (long) read;
        }
        return read;
    }

    public long skip(long j) throws IOException {
        if (!this.f30575f) {
            long j2 = this.f30571b;
            if (j2 + j > this.f30573d) {
                b(j2 + j + ((long) this.f30576g));
            }
        }
        long skip = this.f30570a.skip(j);
        this.f30571b += skip;
        return skip;
    }

    public int available() throws IOException {
        return this.f30570a.available();
    }

    public void close() throws IOException {
        this.f30570a.close();
    }

    public boolean markSupported() {
        return this.f30570a.markSupported();
    }
}
