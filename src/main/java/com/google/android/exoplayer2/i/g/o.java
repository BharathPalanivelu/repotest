package com.google.android.exoplayer2.i.g;

import android.util.Log;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.g.v;
import com.google.android.exoplayer2.s.k;
import com.google.android.exoplayer2.s.l;
import com.google.android.exoplayer2.s.s;

public final class o implements v {

    /* renamed from: a  reason: collision with root package name */
    private final h f10332a;

    /* renamed from: b  reason: collision with root package name */
    private final k f10333b = new k(new byte[10]);

    /* renamed from: c  reason: collision with root package name */
    private int f10334c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f10335d;

    /* renamed from: e  reason: collision with root package name */
    private s f10336e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10337f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10338g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private long l;

    public o(h hVar) {
        this.f10332a = hVar;
    }

    public void a(s sVar, g gVar, v.d dVar) {
        this.f10336e = sVar;
        this.f10332a.a(gVar, dVar);
    }

    public final void a() {
        this.f10334c = 0;
        this.f10335d = 0;
        this.h = false;
        this.f10332a.a();
    }

    public final void a(l lVar, boolean z) {
        if (z) {
            int i2 = this.f10334c;
            if (!(i2 == 0 || i2 == 1)) {
                if (i2 == 2) {
                    Log.w("PesReader", "Unexpected start indicator reading extended header");
                } else if (i2 == 3) {
                    if (this.j != -1) {
                        Log.w("PesReader", "Unexpected start indicator: expected " + this.j + " more bytes");
                    }
                    this.f10332a.b();
                }
            }
            a(1);
        }
        while (lVar.b() > 0) {
            int i3 = this.f10334c;
            if (i3 != 0) {
                int i4 = 0;
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (a(lVar, this.f10333b.f11418a, Math.min(10, this.i)) && a(lVar, (byte[]) null, this.i)) {
                            c();
                            this.f10332a.a(this.l, this.k);
                            a(3);
                        }
                    } else if (i3 == 3) {
                        int b2 = lVar.b();
                        int i5 = this.j;
                        if (i5 != -1) {
                            i4 = b2 - i5;
                        }
                        if (i4 > 0) {
                            b2 -= i4;
                            lVar.b(lVar.d() + b2);
                        }
                        this.f10332a.a(lVar);
                        int i6 = this.j;
                        if (i6 != -1) {
                            this.j = i6 - b2;
                            if (this.j == 0) {
                                this.f10332a.b();
                                a(1);
                            }
                        }
                    }
                } else if (a(lVar, this.f10333b.f11418a, 9)) {
                    if (b()) {
                        i4 = 2;
                    }
                    a(i4);
                }
            } else {
                lVar.d(lVar.b());
            }
        }
    }

    private void a(int i2) {
        this.f10334c = i2;
        this.f10335d = 0;
    }

    private boolean a(l lVar, byte[] bArr, int i2) {
        int min = Math.min(lVar.b(), i2 - this.f10335d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            lVar.d(min);
        } else {
            lVar.a(bArr, this.f10335d, min);
        }
        this.f10335d += min;
        if (this.f10335d == i2) {
            return true;
        }
        return false;
    }

    private boolean b() {
        this.f10333b.a(0);
        int c2 = this.f10333b.c(24);
        if (c2 != 1) {
            Log.w("PesReader", "Unexpected start code prefix: " + c2);
            this.j = -1;
            return false;
        }
        this.f10333b.b(8);
        int c3 = this.f10333b.c(16);
        this.f10333b.b(5);
        this.k = this.f10333b.e();
        this.f10333b.b(2);
        this.f10337f = this.f10333b.e();
        this.f10338g = this.f10333b.e();
        this.f10333b.b(6);
        this.i = this.f10333b.c(8);
        if (c3 == 0) {
            this.j = -1;
        } else {
            this.j = ((c3 + 6) - 9) - this.i;
        }
        return true;
    }

    private void c() {
        this.f10333b.a(0);
        this.l = -9223372036854775807L;
        if (this.f10337f) {
            this.f10333b.b(4);
            this.f10333b.b(1);
            this.f10333b.b(1);
            long c2 = (((long) this.f10333b.c(3)) << 30) | ((long) (this.f10333b.c(15) << 15)) | ((long) this.f10333b.c(15));
            this.f10333b.b(1);
            if (!this.h && this.f10338g) {
                this.f10333b.b(4);
                this.f10333b.b(1);
                this.f10333b.b(1);
                this.f10333b.b(1);
                this.f10336e.b((((long) this.f10333b.c(3)) << 30) | ((long) (this.f10333b.c(15) << 15)) | ((long) this.f10333b.c(15)));
                this.h = true;
            }
            this.l = this.f10336e.b(c2);
        }
    }
}
