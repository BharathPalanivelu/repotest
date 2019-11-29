package com.google.android.exoplayer2.e.g;

import android.util.Log;
import com.google.android.exoplayer2.e.g.v;
import com.google.android.exoplayer2.e.h;
import com.google.android.exoplayer2.n.j;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.q;

public final class o implements v {

    /* renamed from: a  reason: collision with root package name */
    private final h f9697a;

    /* renamed from: b  reason: collision with root package name */
    private final j f9698b = new j(new byte[10]);

    /* renamed from: c  reason: collision with root package name */
    private int f9699c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f9700d;

    /* renamed from: e  reason: collision with root package name */
    private q f9701e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9702f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9703g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private long l;

    public o(h hVar) {
        this.f9697a = hVar;
    }

    public void a(q qVar, h hVar, v.d dVar) {
        this.f9701e = qVar;
        this.f9697a.a(hVar, dVar);
    }

    public final void a() {
        this.f9699c = 0;
        this.f9700d = 0;
        this.h = false;
        this.f9697a.a();
    }

    public final void a(k kVar, boolean z) {
        if (z) {
            int i2 = this.f9699c;
            if (!(i2 == 0 || i2 == 1)) {
                if (i2 == 2) {
                    Log.w("PesReader", "Unexpected start indicator reading extended header");
                } else if (i2 == 3) {
                    if (this.j != -1) {
                        Log.w("PesReader", "Unexpected start indicator: expected " + this.j + " more bytes");
                    }
                    this.f9697a.b();
                }
            }
            a(1);
        }
        while (kVar.b() > 0) {
            int i3 = this.f9699c;
            if (i3 != 0) {
                int i4 = 0;
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (a(kVar, this.f9698b.f10944a, Math.min(10, this.i)) && a(kVar, (byte[]) null, this.i)) {
                            c();
                            this.f9697a.a(this.l, this.k);
                            a(3);
                        }
                    } else if (i3 == 3) {
                        int b2 = kVar.b();
                        int i5 = this.j;
                        if (i5 != -1) {
                            i4 = b2 - i5;
                        }
                        if (i4 > 0) {
                            b2 -= i4;
                            kVar.b(kVar.d() + b2);
                        }
                        this.f9697a.a(kVar);
                        int i6 = this.j;
                        if (i6 != -1) {
                            this.j = i6 - b2;
                            if (this.j == 0) {
                                this.f9697a.b();
                                a(1);
                            }
                        }
                    }
                } else if (a(kVar, this.f9698b.f10944a, 9)) {
                    if (b()) {
                        i4 = 2;
                    }
                    a(i4);
                }
            } else {
                kVar.d(kVar.b());
            }
        }
    }

    private void a(int i2) {
        this.f9699c = i2;
        this.f9700d = 0;
    }

    private boolean a(k kVar, byte[] bArr, int i2) {
        int min = Math.min(kVar.b(), i2 - this.f9700d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            kVar.d(min);
        } else {
            kVar.a(bArr, this.f9700d, min);
        }
        this.f9700d += min;
        if (this.f9700d == i2) {
            return true;
        }
        return false;
    }

    private boolean b() {
        this.f9698b.a(0);
        int c2 = this.f9698b.c(24);
        if (c2 != 1) {
            Log.w("PesReader", "Unexpected start code prefix: " + c2);
            this.j = -1;
            return false;
        }
        this.f9698b.b(8);
        int c3 = this.f9698b.c(16);
        this.f9698b.b(5);
        this.k = this.f9698b.d();
        this.f9698b.b(2);
        this.f9702f = this.f9698b.d();
        this.f9703g = this.f9698b.d();
        this.f9698b.b(6);
        this.i = this.f9698b.c(8);
        if (c3 == 0) {
            this.j = -1;
        } else {
            this.j = ((c3 + 6) - 9) - this.i;
        }
        return true;
    }

    private void c() {
        this.f9698b.a(0);
        this.l = -9223372036854775807L;
        if (this.f9702f) {
            this.f9698b.b(4);
            this.f9698b.b(1);
            this.f9698b.b(1);
            long c2 = (((long) this.f9698b.c(3)) << 30) | ((long) (this.f9698b.c(15) << 15)) | ((long) this.f9698b.c(15));
            this.f9698b.b(1);
            if (!this.h && this.f9703g) {
                this.f9698b.b(4);
                this.f9698b.b(1);
                this.f9698b.b(1);
                this.f9698b.b(1);
                this.f9701e.b((((long) this.f9698b.c(3)) << 30) | ((long) (this.f9698b.c(15) << 15)) | ((long) this.f9698b.c(15)));
                this.h = true;
            }
            this.l = this.f9701e.b(c2);
        }
    }
}
