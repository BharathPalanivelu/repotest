package com.google.android.exoplayer2.e.b;

import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.e.g;
import java.io.IOException;
import java.util.Stack;

final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f9335a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private final Stack<C0161a> f9336b = new Stack<>();

    /* renamed from: c  reason: collision with root package name */
    private final f f9337c = new f();

    /* renamed from: d  reason: collision with root package name */
    private c f9338d;

    /* renamed from: e  reason: collision with root package name */
    private int f9339e;

    /* renamed from: f  reason: collision with root package name */
    private int f9340f;

    /* renamed from: g  reason: collision with root package name */
    private long f9341g;

    a() {
    }

    public void a(c cVar) {
        this.f9338d = cVar;
    }

    public void a() {
        this.f9339e = 0;
        this.f9336b.clear();
        this.f9337c.a();
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.n.a.b(this.f9338d != null);
        while (true) {
            if (this.f9336b.isEmpty() || gVar.c() < this.f9336b.peek().f9343b) {
                if (this.f9339e == 0) {
                    long a2 = this.f9337c.a(gVar, true, false, 4);
                    if (a2 == -2) {
                        a2 = b(gVar);
                    }
                    if (a2 == -1) {
                        return false;
                    }
                    this.f9340f = (int) a2;
                    this.f9339e = 1;
                }
                if (this.f9339e == 1) {
                    this.f9341g = this.f9337c.a(gVar, false, true, 8);
                    this.f9339e = 2;
                }
                int a3 = this.f9338d.a(this.f9340f);
                if (a3 == 0) {
                    gVar.b((int) this.f9341g);
                    this.f9339e = 0;
                } else if (a3 == 1) {
                    long c2 = gVar.c();
                    this.f9336b.add(new C0161a(this.f9340f, this.f9341g + c2));
                    this.f9338d.a(this.f9340f, c2, this.f9341g);
                    this.f9339e = 0;
                    return true;
                } else if (a3 == 2) {
                    long j = this.f9341g;
                    if (j <= 8) {
                        this.f9338d.a(this.f9340f, a(gVar, (int) j));
                        this.f9339e = 0;
                        return true;
                    }
                    throw new ak("Invalid integer size: " + this.f9341g);
                } else if (a3 == 3) {
                    long j2 = this.f9341g;
                    if (j2 <= 2147483647L) {
                        this.f9338d.a(this.f9340f, c(gVar, (int) j2));
                        this.f9339e = 0;
                        return true;
                    }
                    throw new ak("String element size: " + this.f9341g);
                } else if (a3 == 4) {
                    this.f9338d.a(this.f9340f, (int) this.f9341g, gVar);
                    this.f9339e = 0;
                    return true;
                } else if (a3 == 5) {
                    long j3 = this.f9341g;
                    if (j3 == 4 || j3 == 8) {
                        this.f9338d.a(this.f9340f, b(gVar, (int) this.f9341g));
                        this.f9339e = 0;
                        return true;
                    }
                    throw new ak("Invalid float size: " + this.f9341g);
                } else {
                    throw new ak("Invalid element type " + a3);
                }
            } else {
                this.f9338d.c(this.f9336b.pop().f9342a);
                return true;
            }
        }
    }

    private long b(g gVar) throws IOException, InterruptedException {
        gVar.a();
        while (true) {
            gVar.c(this.f9335a, 0, 4);
            int a2 = f.a(this.f9335a[0]);
            if (a2 != -1 && a2 <= 4) {
                int a3 = (int) f.a(this.f9335a, a2, false);
                if (this.f9338d.b(a3)) {
                    gVar.b(a2);
                    return (long) a3;
                }
            }
            gVar.b(1);
        }
    }

    private long a(g gVar, int i) throws IOException, InterruptedException {
        gVar.b(this.f9335a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.f9335a[i2] & 255));
        }
        return j;
    }

    private double b(g gVar, int i) throws IOException, InterruptedException {
        long a2 = a(gVar, i);
        if (i == 4) {
            return (double) Float.intBitsToFloat((int) a2);
        }
        return Double.longBitsToDouble(a2);
    }

    private String c(g gVar, int i) throws IOException, InterruptedException {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        gVar.b(bArr, 0, i);
        return new String(bArr);
    }

    /* renamed from: com.google.android.exoplayer2.e.b.a$a  reason: collision with other inner class name */
    private static final class C0161a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f9342a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f9343b;

        private C0161a(int i, long j) {
            this.f9342a = i;
            this.f9343b = j;
        }
    }
}
