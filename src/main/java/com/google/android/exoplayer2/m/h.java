package com.google.android.exoplayer2.m;

import com.google.android.exoplayer2.n.a;
import java.io.IOException;
import java.io.InputStream;

public final class h extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final f f10758a;

    /* renamed from: b  reason: collision with root package name */
    private final i f10759b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f10760c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10761d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10762e = false;

    /* renamed from: f  reason: collision with root package name */
    private long f10763f;

    public h(f fVar, i iVar) {
        this.f10758a = fVar;
        this.f10759b = iVar;
        this.f10760c = new byte[1];
    }

    public long a() {
        return this.f10763f;
    }

    public void b() throws IOException {
        c();
    }

    public int read() throws IOException {
        if (read(this.f10760c) == -1) {
            return -1;
        }
        return this.f10760c[0] & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        a.b(!this.f10762e);
        c();
        int a2 = this.f10758a.a(bArr, i, i2);
        if (a2 == -1) {
            return -1;
        }
        this.f10763f += (long) a2;
        return a2;
    }

    public void close() throws IOException {
        if (!this.f10762e) {
            this.f10758a.b();
            this.f10762e = true;
        }
    }

    private void c() throws IOException {
        if (!this.f10761d) {
            this.f10758a.a(this.f10759b);
            this.f10761d = true;
        }
    }
}
