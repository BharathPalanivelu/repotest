package com.google.android.exoplayer2.e.e;

import com.google.android.exoplayer2.e.g;
import com.google.android.exoplayer2.e.m;
import com.tencent.imsdk.BaseConstants;
import java.io.EOFException;
import java.io.IOException;

final class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final e f9511a = new e();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final long f9512b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9513c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final h f9514d;

    /* renamed from: e  reason: collision with root package name */
    private int f9515e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f9516f;

    /* renamed from: g  reason: collision with root package name */
    private long f9517g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;

    public a(long j2, long j3, h hVar, int i2, long j4) {
        com.google.android.exoplayer2.n.a.a(j2 >= 0 && j3 > j2);
        this.f9514d = hVar;
        this.f9512b = j2;
        this.f9513c = j3;
        if (((long) i2) == j3 - j2) {
            this.f9516f = j4;
            this.f9515e = 3;
            return;
        }
        this.f9515e = 0;
    }

    public long a(g gVar) throws IOException, InterruptedException {
        int i2 = this.f9515e;
        if (i2 == 0) {
            this.f9517g = gVar.c();
            this.f9515e = 1;
            long j2 = this.f9513c - 65307;
            if (j2 > this.f9517g) {
                return j2;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                long j3 = this.h;
                long j4 = 0;
                if (j3 != 0) {
                    long a2 = a(j3, gVar);
                    if (a2 >= 0) {
                        return a2;
                    }
                    j4 = a(gVar, this.h, -(a2 + 2));
                }
                this.f9515e = 3;
                return -(j4 + 2);
            } else if (i2 == 3) {
                return -1;
            } else {
                throw new IllegalStateException();
            }
        }
        this.f9516f = c(gVar);
        this.f9515e = 3;
        return this.f9517g;
    }

    public long a(long j2) {
        int i2 = this.f9515e;
        com.google.android.exoplayer2.n.a.a(i2 == 3 || i2 == 2);
        long j3 = 0;
        if (j2 != 0) {
            j3 = this.f9514d.b(j2);
        }
        this.h = j3;
        this.f9515e = 2;
        b();
        return this.h;
    }

    /* renamed from: a */
    public C0164a c() {
        if (this.f9516f != 0) {
            return new C0164a();
        }
        return null;
    }

    public void b() {
        this.i = this.f9512b;
        this.j = this.f9513c;
        this.k = 0;
        this.l = this.f9516f;
    }

    public long a(long j2, g gVar) throws IOException, InterruptedException {
        g gVar2 = gVar;
        if (this.i == this.j) {
            return -(this.k + 2);
        }
        long c2 = gVar.c();
        if (!a(gVar2, this.j)) {
            long j3 = this.i;
            if (j3 != c2) {
                return j3;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f9511a.a(gVar2, false);
        gVar.a();
        long j4 = j2 - this.f9511a.f9535c;
        int i2 = this.f9511a.h + this.f9511a.i;
        if (j4 < 0 || j4 > 72000) {
            if (j4 < 0) {
                this.j = c2;
                this.l = this.f9511a.f9535c;
            } else {
                long j5 = (long) i2;
                this.i = gVar.c() + j5;
                this.k = this.f9511a.f9535c;
                if ((this.j - this.i) + j5 < 100000) {
                    gVar2.b(i2);
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
            long c3 = gVar.c();
            long j8 = this.j;
            long j9 = this.i;
            return Math.min(Math.max((c3 - ((long) (i2 * i3))) + ((j4 * (j8 - j9)) / (this.l - this.k)), j9), this.j - 1);
        }
        gVar2.b(i2);
        return -(this.f9511a.f9535c + 2);
    }

    /* access modifiers changed from: private */
    public long a(long j2, long j3, long j4) {
        long j5 = this.f9513c;
        long j6 = this.f9512b;
        long j7 = j2 + (((j3 * (j5 - j6)) / this.f9516f) - j4);
        if (j7 < j6) {
            j7 = j6;
        }
        long j8 = this.f9513c;
        return j7 >= j8 ? j8 - 1 : j7;
    }

    /* renamed from: com.google.android.exoplayer2.e.e.a$a  reason: collision with other inner class name */
    private class C0164a implements m {
        public boolean a() {
            return true;
        }

        private C0164a() {
        }

        public long b(long j) {
            if (j == 0) {
                return a.this.f9512b;
            }
            long b2 = a.this.f9514d.b(j);
            a aVar = a.this;
            return aVar.a(aVar.f9512b, b2, (long) BaseConstants.DEFAULT_MSG_TIMEOUT);
        }

        public long b() {
            return a.this.f9514d.a(a.this.f9516f);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(g gVar) throws IOException, InterruptedException {
        if (!a(gVar, this.f9513c)) {
            throw new EOFException();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(g gVar, long j2) throws IOException, InterruptedException {
        int i2;
        long min = Math.min(j2 + 3, this.f9513c);
        byte[] bArr = new byte[2048];
        int length = bArr.length;
        while (true) {
            int i3 = 0;
            if (gVar.c() + ((long) length) > min) {
                int c2 = (int) (min - gVar.c());
                if (c2 < 4) {
                    return false;
                }
                length = c2;
            }
            gVar.b(bArr, 0, length, false);
            while (true) {
                i2 = length - 3;
                if (i3 >= i2) {
                    break;
                } else if (bArr[i3] == 79 && bArr[i3 + 1] == 103 && bArr[i3 + 2] == 103 && bArr[i3 + 3] == 83) {
                    gVar.b(i3);
                    return true;
                } else {
                    i3++;
                }
            }
            gVar.b(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public long c(g gVar) throws IOException, InterruptedException {
        b(gVar);
        this.f9511a.a();
        while ((this.f9511a.f9534b & 4) != 4 && gVar.c() < this.f9513c) {
            this.f9511a.a(gVar, false);
            gVar.b(this.f9511a.h + this.f9511a.i);
        }
        return this.f9511a.f9535c;
    }

    /* access modifiers changed from: package-private */
    public long a(g gVar, long j2, long j3) throws IOException, InterruptedException {
        this.f9511a.a(gVar, false);
        while (this.f9511a.f9535c < j2) {
            gVar.b(this.f9511a.h + this.f9511a.i);
            j3 = this.f9511a.f9535c;
            this.f9511a.a(gVar, false);
        }
        gVar.a();
        return j3;
    }
}
