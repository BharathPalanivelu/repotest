package com.google.android.exoplayer2.i.e;

import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.l;
import com.tencent.imsdk.BaseConstants;
import java.io.EOFException;
import java.io.IOException;

final class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final e f10143a = new e();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f10144b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10145c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final h f10146d;

    /* renamed from: e  reason: collision with root package name */
    private int f10147e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f10148f;

    /* renamed from: g  reason: collision with root package name */
    private long f10149g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;

    public a(long j2, long j3, h hVar, int i2, long j4) {
        com.google.android.exoplayer2.s.a.a(j2 >= 0 && j3 > j2);
        this.f10146d = hVar;
        this.f10144b = j2;
        this.f10145c = j3;
        if (((long) i2) == j3 - j2) {
            this.f10148f = j4;
            this.f10147e = 3;
            return;
        }
        this.f10147e = 0;
    }

    public long a(f fVar) throws IOException, InterruptedException {
        int i2 = this.f10147e;
        if (i2 == 0) {
            this.f10149g = fVar.c();
            this.f10147e = 1;
            long j2 = this.f10145c - 65307;
            if (j2 > this.f10149g) {
                return j2;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                long j3 = this.h;
                long j4 = 0;
                if (j3 != 0) {
                    long a2 = a(j3, fVar);
                    if (a2 >= 0) {
                        return a2;
                    }
                    j4 = a(fVar, this.h, -(a2 + 2));
                }
                this.f10147e = 3;
                return -(j4 + 2);
            } else if (i2 == 3) {
                return -1;
            } else {
                throw new IllegalStateException();
            }
        }
        this.f10148f = c(fVar);
        this.f10147e = 3;
        return this.f10149g;
    }

    public long a(long j2) {
        int i2 = this.f10147e;
        com.google.android.exoplayer2.s.a.a(i2 == 3 || i2 == 2);
        long j3 = 0;
        if (j2 != 0) {
            j3 = this.f10146d.b(j2);
        }
        this.h = j3;
        this.f10147e = 2;
        b();
        return this.h;
    }

    /* renamed from: a */
    public C0171a c() {
        if (this.f10148f != 0) {
            return new C0171a();
        }
        return null;
    }

    public void b() {
        this.i = this.f10144b;
        this.j = this.f10145c;
        this.k = 0;
        this.l = this.f10148f;
    }

    public long a(long j2, f fVar) throws IOException, InterruptedException {
        f fVar2 = fVar;
        if (this.i == this.j) {
            return -(this.k + 2);
        }
        long c2 = fVar.c();
        if (!a(fVar2, this.j)) {
            long j3 = this.i;
            if (j3 != c2) {
                return j3;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f10143a.a(fVar2, false);
        fVar.a();
        long j4 = j2 - this.f10143a.f10169c;
        int i2 = this.f10143a.h + this.f10143a.i;
        if (j4 < 0 || j4 > 72000) {
            if (j4 < 0) {
                this.j = c2;
                this.l = this.f10143a.f10169c;
            } else {
                long j5 = (long) i2;
                this.i = fVar.c() + j5;
                this.k = this.f10143a.f10169c;
                if ((this.j - this.i) + j5 < 100000) {
                    fVar2.b(i2);
                    return -(this.k + 2);
                }
            }
            long j6 = this.j;
            long j7 = this.i;
            if (j6 - j7 < 100000) {
                this.j = j7;
                return j7;
            }
            int i3 = j4 <= 0 ? 2 : 1;
            long c3 = fVar.c();
            long j8 = this.j;
            long j9 = this.i;
            return Math.min(Math.max((c3 - ((long) (i2 * i3))) + ((j4 * (j8 - j9)) / (this.l - this.k)), j9), this.j - 1);
        }
        fVar2.b(i2);
        return -(this.f10143a.f10169c + 2);
    }

    /* access modifiers changed from: private */
    public long a(long j2, long j3, long j4) {
        long j5 = this.f10145c;
        long j6 = this.f10144b;
        long j7 = j2 + (((j3 * (j5 - j6)) / this.f10148f) - j4);
        if (j7 < j6) {
            j7 = j6;
        }
        long j8 = this.f10145c;
        return j7 >= j8 ? j8 - 1 : j7;
    }

    /* renamed from: com.google.android.exoplayer2.i.e.a$a  reason: collision with other inner class name */
    private class C0171a implements l {
        public boolean a() {
            return true;
        }

        private C0171a() {
        }

        public long b(long j) {
            if (j == 0) {
                return a.this.f10144b;
            }
            long b2 = a.this.f10146d.b(j);
            a aVar = a.this;
            return aVar.a(aVar.f10144b, b2, (long) BaseConstants.DEFAULT_MSG_TIMEOUT);
        }

        public long b() {
            return a.this.f10146d.a(a.this.f10148f);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(f fVar) throws IOException, InterruptedException {
        if (!a(fVar, this.f10145c)) {
            throw new EOFException();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(f fVar, long j2) throws IOException, InterruptedException {
        int i2;
        long min = Math.min(j2 + 3, this.f10145c);
        byte[] bArr = new byte[2048];
        int length = bArr.length;
        while (true) {
            int i3 = 0;
            if (fVar.c() + ((long) length) > min) {
                int c2 = (int) (min - fVar.c());
                if (c2 < 4) {
                    return false;
                }
                length = c2;
            }
            fVar.b(bArr, 0, length, false);
            while (true) {
                i2 = length - 3;
                if (i3 >= i2) {
                    break;
                } else if (bArr[i3] == 79 && bArr[i3 + 1] == 103 && bArr[i3 + 2] == 103 && bArr[i3 + 3] == 83) {
                    fVar.b(i3);
                    return true;
                } else {
                    i3++;
                }
            }
            fVar.b(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public long c(f fVar) throws IOException, InterruptedException {
        b(fVar);
        this.f10143a.a();
        while ((this.f10143a.f10168b & 4) != 4 && fVar.c() < this.f10145c) {
            this.f10143a.a(fVar, false);
            fVar.b(this.f10143a.h + this.f10143a.i);
        }
        return this.f10143a.f10169c;
    }

    /* access modifiers changed from: package-private */
    public long a(f fVar, long j2, long j3) throws IOException, InterruptedException {
        this.f10143a.a(fVar, false);
        while (this.f10143a.f10169c < j2) {
            fVar.b(this.f10143a.h + this.f10143a.i);
            j3 = this.f10143a.f10169c;
            this.f10143a.a(fVar, false);
        }
        fVar.a();
        return j3;
    }
}
