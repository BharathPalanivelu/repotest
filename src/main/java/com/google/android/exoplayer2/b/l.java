package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.s.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class l implements d {

    /* renamed from: b  reason: collision with root package name */
    private int f9236b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f9237c = -1;

    /* renamed from: d  reason: collision with root package name */
    private k f9238d;

    /* renamed from: e  reason: collision with root package name */
    private float f9239e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f9240f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f9241g = f9163a;
    private ShortBuffer h = this.f9241g.asShortBuffer();
    private ByteBuffer i = f9163a;
    private long j;
    private long k;
    private boolean l;

    public int c() {
        return 2;
    }

    public float a(float f2) {
        this.f9239e = v.a(f2, 0.1f, 8.0f);
        return this.f9239e;
    }

    public float b(float f2) {
        this.f9240f = v.a(f2, 0.1f, 8.0f);
        return f2;
    }

    public long i() {
        return this.j;
    }

    public long j() {
        return this.k;
    }

    public boolean a(int i2, int i3, int i4) throws d.a {
        if (i4 != 2) {
            throw new d.a(i2, i3, i4);
        } else if (this.f9237c == i2 && this.f9236b == i3) {
            return false;
        } else {
            this.f9237c = i2;
            this.f9236b = i3;
            return true;
        }
    }

    public boolean a() {
        return Math.abs(this.f9239e - 1.0f) >= 0.01f || Math.abs(this.f9240f - 1.0f) >= 0.01f;
    }

    public int b() {
        return this.f9236b;
    }

    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.j += (long) remaining;
            this.f9238d.a(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int b2 = this.f9238d.b() * this.f9236b * 2;
        if (b2 > 0) {
            if (this.f9241g.capacity() < b2) {
                this.f9241g = ByteBuffer.allocateDirect(b2).order(ByteOrder.nativeOrder());
                this.h = this.f9241g.asShortBuffer();
            } else {
                this.f9241g.clear();
                this.h.clear();
            }
            this.f9238d.b(this.h);
            this.k += (long) b2;
            this.f9241g.limit(b2);
            this.i = this.f9241g;
        }
    }

    public void d() {
        this.f9238d.a();
        this.l = true;
    }

    public ByteBuffer e() {
        ByteBuffer byteBuffer = this.i;
        this.i = f9163a;
        return byteBuffer;
    }

    public boolean f() {
        if (this.l) {
            k kVar = this.f9238d;
            if (kVar == null || kVar.b() == 0) {
                return true;
            }
        }
        return false;
    }

    public void g() {
        this.f9238d = new k(this.f9237c, this.f9236b);
        this.f9238d.a(this.f9239e);
        this.f9238d.b(this.f9240f);
        this.i = f9163a;
        this.j = 0;
        this.k = 0;
        this.l = false;
    }

    public void h() {
        this.f9238d = null;
        this.f9241g = f9163a;
        this.h = this.f9241g.asShortBuffer();
        this.i = f9163a;
        this.f9236b = -1;
        this.f9237c = -1;
        this.j = 0;
        this.k = 0;
        this.l = false;
    }
}
