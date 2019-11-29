package com.google.android.exoplayer2.i;

import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.r.f;
import com.google.android.exoplayer2.s.v;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f9969a = new byte[4096];

    /* renamed from: b  reason: collision with root package name */
    private final f f9970b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9971c;

    /* renamed from: d  reason: collision with root package name */
    private long f9972d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f9973e = new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];

    /* renamed from: f  reason: collision with root package name */
    private int f9974f;

    /* renamed from: g  reason: collision with root package name */
    private int f9975g;

    public b(f fVar, long j, long j2) {
        this.f9970b = fVar;
        this.f9972d = j;
        this.f9971c = j2;
    }

    public int a(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int d2 = d(bArr, i, i2);
        if (d2 == 0) {
            d2 = a(bArr, i, i2, 0, true);
        }
        g(d2);
        return d2;
    }

    public boolean a(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int d2 = d(bArr, i, i2);
        while (d2 < i2 && d2 != -1) {
            d2 = a(bArr, i, i2, d2, z);
        }
        g(d2);
        return d2 != -1;
    }

    public void b(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        a(bArr, i, i2, false);
    }

    public int a(int i) throws IOException, InterruptedException {
        int e2 = e(i);
        if (e2 == 0) {
            byte[] bArr = f9969a;
            e2 = a(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        g(e2);
        return e2;
    }

    public boolean a(int i, boolean z) throws IOException, InterruptedException {
        int e2 = e(i);
        while (e2 < i && e2 != -1) {
            byte[] bArr = f9969a;
            e2 = a(bArr, -e2, Math.min(i, bArr.length + e2), e2, z);
        }
        g(e2);
        return e2 != -1;
    }

    public void b(int i) throws IOException, InterruptedException {
        a(i, false);
    }

    public boolean b(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        if (!b(i2, z)) {
            return false;
        }
        System.arraycopy(this.f9973e, this.f9974f - i2, bArr, i, i2);
        return true;
    }

    public void c(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        b(bArr, i, i2, false);
    }

    public boolean b(int i, boolean z) throws IOException, InterruptedException {
        d(i);
        int min = Math.min(this.f9975g - this.f9974f, i);
        while (min < i) {
            min = a(this.f9973e, this.f9974f, i, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.f9974f += i;
        this.f9975g = Math.max(this.f9975g, this.f9974f);
        return true;
    }

    public void c(int i) throws IOException, InterruptedException {
        b(i, false);
    }

    public void a() {
        this.f9974f = 0;
    }

    public long b() {
        return this.f9972d + ((long) this.f9974f);
    }

    public long c() {
        return this.f9972d;
    }

    public long d() {
        return this.f9971c;
    }

    private void d(int i) {
        int i2 = this.f9974f + i;
        byte[] bArr = this.f9973e;
        if (i2 > bArr.length) {
            this.f9973e = Arrays.copyOf(this.f9973e, v.a(bArr.length * 2, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + i2, i2 + 524288));
        }
    }

    private int e(int i) {
        int min = Math.min(this.f9975g, i);
        f(min);
        return min;
    }

    private int d(byte[] bArr, int i, int i2) {
        int i3 = this.f9975g;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.f9973e, 0, bArr, i, min);
        f(min);
        return min;
    }

    private void f(int i) {
        this.f9975g -= i;
        this.f9974f = 0;
        byte[] bArr = this.f9973e;
        int i2 = this.f9975g;
        if (i2 < bArr.length - 524288) {
            bArr = new byte[(i2 + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)];
        }
        System.arraycopy(this.f9973e, i, bArr, 0, this.f9975g);
        this.f9973e = bArr;
    }

    private int a(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int a2 = this.f9970b.a(bArr, i + i3, i2 - i3);
            if (a2 != -1) {
                return i3 + a2;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    private void g(int i) {
        if (i != -1) {
            this.f9972d += (long) i;
        }
    }
}
