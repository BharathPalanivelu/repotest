package com.google.android.exoplayer2.r;

import com.google.android.exoplayer2.s.a;
import java.io.IOException;
import java.io.InputStream;

public final class h extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final f f11307a;

    /* renamed from: b  reason: collision with root package name */
    private final i f11308b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f11309c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11310d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11311e = false;

    /* renamed from: f  reason: collision with root package name */
    private long f11312f;

    public h(f fVar, i iVar) {
        this.f11307a = fVar;
        this.f11308b = iVar;
        this.f11309c = new byte[1];
    }

    public long a() {
        return this.f11312f;
    }

    public void b() throws IOException {
        c();
    }

    public int read() throws IOException {
        if (read(this.f11309c) == -1) {
            return -1;
        }
        return this.f11309c[0] & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        a.b(!this.f11311e);
        c();
        int a2 = this.f11307a.a(bArr, i, i2);
        if (a2 == -1) {
            return -1;
        }
        this.f11312f += (long) a2;
        return a2;
    }

    public void close() throws IOException {
        if (!this.f11311e) {
            this.f11307a.a();
            this.f11311e = true;
        }
    }

    private void c() throws IOException {
        if (!this.f11310d) {
            this.f11307a.a(this.f11308b);
            this.f11310d = true;
        }
    }
}
