package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class f implements c {

    /* renamed from: b  reason: collision with root package name */
    private int f9025b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f9026c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int[] f9027d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9028e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f9029f;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f9030g = f8981a;
    private ByteBuffer h = f8981a;
    private boolean i;

    public int c() {
        return 2;
    }

    public void a(int[] iArr) {
        this.f9027d = iArr;
    }

    public boolean a(int i2, int i3, int i4) throws c.a {
        boolean z = !Arrays.equals(this.f9027d, this.f9029f);
        this.f9029f = this.f9027d;
        if (this.f9029f == null) {
            this.f9028e = false;
            return z;
        } else if (i4 != 2) {
            throw new c.a(i2, i3, i4);
        } else if (!z && this.f9026c == i2 && this.f9025b == i3) {
            return false;
        } else {
            this.f9026c = i2;
            this.f9025b = i3;
            this.f9028e = i3 != this.f9029f.length;
            int i5 = 0;
            while (true) {
                int[] iArr = this.f9029f;
                if (i5 >= iArr.length) {
                    return true;
                }
                int i6 = iArr[i5];
                if (i6 < i3) {
                    this.f9028e = (i6 != i5) | this.f9028e;
                    i5++;
                } else {
                    throw new c.a(i2, i3, i4);
                }
            }
        }
    }

    public boolean a() {
        return this.f9028e;
    }

    public int b() {
        int[] iArr = this.f9029f;
        return iArr == null ? this.f9025b : iArr.length;
    }

    public void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.f9025b * 2)) * this.f9029f.length * 2;
        if (this.f9030g.capacity() < length) {
            this.f9030g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f9030g.clear();
        }
        while (position < limit) {
            for (int i2 : this.f9029f) {
                this.f9030g.putShort(byteBuffer.getShort((i2 * 2) + position));
            }
            position += this.f9025b * 2;
        }
        byteBuffer.position(limit);
        this.f9030g.flip();
        this.h = this.f9030g;
    }

    public void d() {
        this.i = true;
    }

    public ByteBuffer e() {
        ByteBuffer byteBuffer = this.h;
        this.h = f8981a;
        return byteBuffer;
    }

    public boolean f() {
        return this.i && this.h == f8981a;
    }

    public void g() {
        this.h = f8981a;
        this.i = false;
    }

    public void h() {
        g();
        this.f9030g = f8981a;
        this.f9025b = -1;
        this.f9026c = -1;
        this.f9029f = null;
        this.f9028e = false;
    }
}
