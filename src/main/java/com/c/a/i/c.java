package com.c.a.i;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class c extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private static final Queue<c> f6245a = i.a(0);

    /* renamed from: b  reason: collision with root package name */
    private InputStream f6246b;

    /* renamed from: c  reason: collision with root package name */
    private IOException f6247c;

    public static c a(InputStream inputStream) {
        c poll;
        synchronized (f6245a) {
            poll = f6245a.poll();
        }
        if (poll == null) {
            poll = new c();
        }
        poll.b(inputStream);
        return poll;
    }

    c() {
    }

    /* access modifiers changed from: package-private */
    public void b(InputStream inputStream) {
        this.f6246b = inputStream;
    }

    public int available() throws IOException {
        return this.f6246b.available();
    }

    public void close() throws IOException {
        this.f6246b.close();
    }

    public void mark(int i) {
        this.f6246b.mark(i);
    }

    public boolean markSupported() {
        return this.f6246b.markSupported();
    }

    public int read(byte[] bArr) throws IOException {
        try {
            return this.f6246b.read(bArr);
        } catch (IOException e2) {
            this.f6247c = e2;
            return -1;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.f6246b.read(bArr, i, i2);
        } catch (IOException e2) {
            this.f6247c = e2;
            return -1;
        }
    }

    public synchronized void reset() throws IOException {
        this.f6246b.reset();
    }

    public long skip(long j) throws IOException {
        try {
            return this.f6246b.skip(j);
        } catch (IOException e2) {
            this.f6247c = e2;
            return 0;
        }
    }

    public int read() throws IOException {
        try {
            return this.f6246b.read();
        } catch (IOException e2) {
            this.f6247c = e2;
            return -1;
        }
    }

    public IOException a() {
        return this.f6247c;
    }

    public void b() {
        this.f6247c = null;
        this.f6246b = null;
        synchronized (f6245a) {
            f6245a.offer(this);
        }
    }
}
