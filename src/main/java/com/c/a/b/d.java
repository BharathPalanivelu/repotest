package com.c.a.b;

import android.util.Log;
import com.g.a.a.g;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f5621a = new byte[256];

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f5622b;

    /* renamed from: c  reason: collision with root package name */
    private c f5623c;

    /* renamed from: d  reason: collision with root package name */
    private int f5624d = 0;

    public d a(ByteBuffer byteBuffer) {
        c();
        this.f5622b = byteBuffer.asReadOnlyBuffer();
        this.f5622b.position(0);
        this.f5622b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public void a() {
        this.f5622b = null;
        this.f5623c = null;
    }

    private void c() {
        this.f5622b = null;
        Arrays.fill(this.f5621a, (byte) 0);
        this.f5623c = new c();
        this.f5624d = 0;
    }

    public c b() {
        if (this.f5622b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (o()) {
            return this.f5623c;
        } else {
            h();
            if (!o()) {
                d();
                if (this.f5623c.f5616c < 0) {
                    this.f5623c.f5615b = 1;
                }
            }
            return this.f5623c;
        }
    }

    private void d() {
        a(Integer.MAX_VALUE);
    }

    private void a(int i) {
        boolean z = false;
        while (!z && !o() && this.f5623c.f5616c <= i) {
            int m = m();
            if (m == 33) {
                int m2 = m();
                if (m2 == 1) {
                    k();
                } else if (m2 == 249) {
                    this.f5623c.f5617d = new b();
                    e();
                } else if (m2 == 254) {
                    k();
                } else if (m2 != 255) {
                    k();
                } else {
                    l();
                    String str = "";
                    for (int i2 = 0; i2 < 11; i2++) {
                        str = str + ((char) this.f5621a[i2]);
                    }
                    if (str.equals("NETSCAPE2.0")) {
                        g();
                    } else {
                        k();
                    }
                }
            } else if (m == 44) {
                if (this.f5623c.f5617d == null) {
                    this.f5623c.f5617d = new b();
                }
                f();
            } else if (m != 59) {
                this.f5623c.f5615b = 1;
            } else {
                z = true;
            }
        }
    }

    private void e() {
        m();
        int m = m();
        this.f5623c.f5617d.f5613g = (m & 28) >> 2;
        boolean z = true;
        if (this.f5623c.f5617d.f5613g == 0) {
            this.f5623c.f5617d.f5613g = 1;
        }
        b bVar = this.f5623c.f5617d;
        if ((m & 1) == 0) {
            z = false;
        }
        bVar.f5612f = z;
        int n = n();
        if (n < 2) {
            n = 10;
        }
        this.f5623c.f5617d.i = n * 10;
        this.f5623c.f5617d.h = m();
        m();
    }

    private void f() {
        this.f5623c.f5617d.f5607a = n();
        this.f5623c.f5617d.f5608b = n();
        this.f5623c.f5617d.f5609c = n();
        this.f5623c.f5617d.f5610d = n();
        int m = m();
        boolean z = false;
        boolean z2 = (m & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((m & 7) + 1));
        b bVar = this.f5623c.f5617d;
        if ((m & 64) != 0) {
            z = true;
        }
        bVar.f5611e = z;
        if (z2) {
            this.f5623c.f5617d.k = b(pow);
        } else {
            this.f5623c.f5617d.k = null;
        }
        this.f5623c.f5617d.j = this.f5622b.position();
        j();
        if (!o()) {
            this.f5623c.f5616c++;
            this.f5623c.f5618e.add(this.f5623c.f5617d);
        }
    }

    private void g() {
        do {
            l();
            byte[] bArr = this.f5621a;
            if (bArr[0] == 1) {
                this.f5623c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f5624d <= 0) {
                return;
            }
        } while (!o());
    }

    private void h() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) m());
        }
        if (!str.startsWith("GIF")) {
            this.f5623c.f5615b = 1;
            return;
        }
        i();
        if (this.f5623c.h && !o()) {
            c cVar = this.f5623c;
            cVar.f5614a = b(cVar.i);
            c cVar2 = this.f5623c;
            cVar2.l = cVar2.f5614a[this.f5623c.j];
        }
    }

    private void i() {
        this.f5623c.f5619f = n();
        this.f5623c.f5620g = n();
        int m = m();
        this.f5623c.h = (m & 128) != 0;
        this.f5623c.i = (int) Math.pow(2.0d, (double) ((m & 7) + 1));
        this.f5623c.j = m();
        this.f5623c.k = m();
    }

    private int[] b(int i) {
        byte[] bArr = new byte[(i * 3)];
        int[] iArr = null;
        try {
            this.f5622b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | g.BYTE | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.f5623c.f5615b = 1;
        }
        return iArr;
    }

    private void j() {
        m();
        k();
    }

    private void k() {
        int m;
        do {
            m = m();
            this.f5622b.position(Math.min(this.f5622b.position() + m, this.f5622b.limit()));
        } while (m > 0);
    }

    private int l() {
        this.f5624d = m();
        int i = 0;
        if (this.f5624d > 0) {
            int i2 = 0;
            while (i < this.f5624d) {
                try {
                    i2 = this.f5624d - i;
                    this.f5622b.get(this.f5621a, i, i2);
                    i += i2;
                } catch (Exception e2) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f5624d, e2);
                    }
                    this.f5623c.f5615b = 1;
                }
            }
        }
        return i;
    }

    private int m() {
        try {
            return this.f5622b.get() & 255;
        } catch (Exception unused) {
            this.f5623c.f5615b = 1;
            return 0;
        }
    }

    private int n() {
        return this.f5622b.getShort();
    }

    private boolean o() {
        return this.f5623c.f5615b != 0;
    }
}
