package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.b.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class g implements d {

    /* renamed from: b  reason: collision with root package name */
    private int f9207b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f9208c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int[] f9209d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9210e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f9211f;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f9212g = f9163a;
    private ByteBuffer h = f9163a;
    private boolean i;

    public int c() {
        return 2;
    }

    public void a(int[] iArr) {
        this.f9209d = iArr;
    }

    public boolean a(int i2, int i3, int i4) throws d.a {
        boolean z = !Arrays.equals(this.f9209d, this.f9211f);
        this.f9211f = this.f9209d;
        if (this.f9211f == null) {
            this.f9210e = false;
            return z;
        } else if (i4 != 2) {
            throw new d.a(i2, i3, i4);
        } else if (!z && this.f9208c == i2 && this.f9207b == i3) {
            return false;
        } else {
            this.f9208c = i2;
            this.f9207b = i3;
            this.f9210e = i3 != this.f9211f.length;
            int i5 = 0;
            while (true) {
                int[] iArr = this.f9211f;
                if (i5 >= iArr.length) {
                    return true;
                }
                int i6 = iArr[i5];
                if (i6 < i3) {
                    this.f9210e = (i6 != i5) | this.f9210e;
                    i5++;
                } else {
                    throw new d.a(i2, i3, i4);
                }
            }
        }
    }

    public boolean a() {
        return this.f9210e;
    }

    public int b() {
        int[] iArr = this.f9211f;
        return iArr == null ? this.f9207b : iArr.length;
    }

    public void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.f9207b * 2)) * this.f9211f.length * 2;
        if (this.f9212g.capacity() < length) {
            this.f9212g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f9212g.clear();
        }
        while (position < limit) {
            for (int i2 : this.f9211f) {
                this.f9212g.putShort(byteBuffer.getShort((i2 * 2) + position));
            }
            position += this.f9207b * 2;
        }
        byteBuffer.position(limit);
        this.f9212g.flip();
        this.h = this.f9212g;
    }

    public void d() {
        this.i = true;
    }

    public ByteBuffer e() {
        ByteBuffer byteBuffer = this.h;
        this.h = f9163a;
        return byteBuffer;
    }

    public boolean f() {
        return this.i && this.h == f9163a;
    }

    public void g() {
        this.h = f9163a;
        this.i = false;
    }

    public void h() {
        g();
        this.f9212g = f9163a;
        this.f9207b = -1;
        this.f9208c = -1;
        this.f9211f = null;
        this.f9210e = false;
    }
}
