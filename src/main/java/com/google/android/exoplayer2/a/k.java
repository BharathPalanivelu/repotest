package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.c;
import com.google.android.exoplayer2.n.t;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class k implements c {

    /* renamed from: b  reason: collision with root package name */
    private int f9054b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f9055c = -1;

    /* renamed from: d  reason: collision with root package name */
    private j f9056d;

    /* renamed from: e  reason: collision with root package name */
    private float f9057e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f9058f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f9059g = f8981a;
    private ShortBuffer h = this.f9059g.asShortBuffer();
    private ByteBuffer i = f8981a;
    private long j;
    private long k;
    private boolean l;

    public int c() {
        return 2;
    }

    public float a(float f2) {
        this.f9057e = t.a(f2, 0.1f, 8.0f);
        return this.f9057e;
    }

    public float b(float f2) {
        this.f9058f = t.a(f2, 0.1f, 8.0f);
        return f2;
    }

    public long i() {
        return this.j;
    }

    public long j() {
        return this.k;
    }

    public boolean a(int i2, int i3, int i4) throws c.a {
        if (i4 != 2) {
            throw new c.a(i2, i3, i4);
        } else if (this.f9055c == i2 && this.f9054b == i3) {
            return false;
        } else {
            this.f9055c = i2;
            this.f9054b = i3;
            return true;
        }
    }

    public boolean a() {
        return Math.abs(this.f9057e - 1.0f) >= 0.01f || Math.abs(this.f9058f - 1.0f) >= 0.01f;
    }

    public int b() {
        return this.f9054b;
    }

    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.j += (long) remaining;
            this.f9056d.a(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int b2 = this.f9056d.b() * this.f9054b * 2;
        if (b2 > 0) {
            if (this.f9059g.capacity() < b2) {
                this.f9059g = ByteBuffer.allocateDirect(b2).order(ByteOrder.nativeOrder());
                this.h = this.f9059g.asShortBuffer();
            } else {
                this.f9059g.clear();
                this.h.clear();
            }
            this.f9056d.b(this.h);
            this.k += (long) b2;
            this.f9059g.limit(b2);
            this.i = this.f9059g;
        }
    }

    public void d() {
        this.f9056d.a();
        this.l = true;
    }

    public ByteBuffer e() {
        ByteBuffer byteBuffer = this.i;
        this.i = f8981a;
        return byteBuffer;
    }

    public boolean f() {
        if (this.l) {
            j jVar = this.f9056d;
            if (jVar == null || jVar.b() == 0) {
                return true;
            }
        }
        return false;
    }

    public void g() {
        this.f9056d = new j(this.f9055c, this.f9054b);
        this.f9056d.a(this.f9057e);
        this.f9056d.b(this.f9058f);
        this.i = f8981a;
        this.j = 0;
        this.k = 0;
        this.l = false;
    }

    public void h() {
        this.f9056d = null;
        this.f9059g = f8981a;
        this.h = this.f9059g.asShortBuffer();
        this.i = f8981a;
        this.f9054b = -1;
        this.f9055c = -1;
        this.j = 0;
        this.k = 0;
        this.l = false;
    }
}
