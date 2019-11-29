package com.google.android.exoplayer2.i.b;

import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.p;
import java.io.IOException;
import java.util.Stack;

final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f9976a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private final Stack<C0168a> f9977b = new Stack<>();

    /* renamed from: c  reason: collision with root package name */
    private final f f9978c = new f();

    /* renamed from: d  reason: collision with root package name */
    private c f9979d;

    /* renamed from: e  reason: collision with root package name */
    private int f9980e;

    /* renamed from: f  reason: collision with root package name */
    private int f9981f;

    /* renamed from: g  reason: collision with root package name */
    private long f9982g;

    a() {
    }

    public void a(c cVar) {
        this.f9979d = cVar;
    }

    public void a() {
        this.f9980e = 0;
        this.f9977b.clear();
        this.f9978c.a();
    }

    public boolean a(f fVar) throws IOException, InterruptedException {
        com.google.android.exoplayer2.s.a.b(this.f9979d != null);
        while (true) {
            if (this.f9977b.isEmpty() || fVar.c() < this.f9977b.peek().f9984b) {
                if (this.f9980e == 0) {
                    long a2 = this.f9978c.a(fVar, true, false, 4);
                    if (a2 == -2) {
                        a2 = b(fVar);
                    }
                    if (a2 == -1) {
                        return false;
                    }
                    this.f9981f = (int) a2;
                    this.f9980e = 1;
                }
                if (this.f9980e == 1) {
                    this.f9982g = this.f9978c.a(fVar, false, true, 8);
                    this.f9980e = 2;
                }
                int a3 = this.f9979d.a(this.f9981f);
                if (a3 == 0) {
                    fVar.b((int) this.f9982g);
                    this.f9980e = 0;
                } else if (a3 == 1) {
                    long c2 = fVar.c();
                    this.f9977b.add(new C0168a(this.f9981f, this.f9982g + c2));
                    this.f9979d.a(this.f9981f, c2, this.f9982g);
                    this.f9980e = 0;
                    return true;
                } else if (a3 == 2) {
                    long j = this.f9982g;
                    if (j <= 8) {
                        this.f9979d.a(this.f9981f, a(fVar, (int) j));
                        this.f9980e = 0;
                        return true;
                    }
                    throw new p("Invalid integer size: " + this.f9982g);
                } else if (a3 == 3) {
                    long j2 = this.f9982g;
                    if (j2 <= 2147483647L) {
                        this.f9979d.a(this.f9981f, c(fVar, (int) j2));
                        this.f9980e = 0;
                        return true;
                    }
                    throw new p("String element size: " + this.f9982g);
                } else if (a3 == 4) {
                    this.f9979d.a(this.f9981f, (int) this.f9982g, fVar);
                    this.f9980e = 0;
                    return true;
                } else if (a3 == 5) {
                    long j3 = this.f9982g;
                    if (j3 == 4 || j3 == 8) {
                        this.f9979d.a(this.f9981f, b(fVar, (int) this.f9982g));
                        this.f9980e = 0;
                        return true;
                    }
                    throw new p("Invalid float size: " + this.f9982g);
                } else {
                    throw new p("Invalid element type " + a3);
                }
            } else {
                this.f9979d.c(this.f9977b.pop().f9983a);
                return true;
            }
        }
    }

    private long b(f fVar) throws IOException, InterruptedException {
        fVar.a();
        while (true) {
            fVar.c(this.f9976a, 0, 4);
            int a2 = f.a(this.f9976a[0]);
            if (a2 != -1 && a2 <= 4) {
                int a3 = (int) f.a(this.f9976a, a2, false);
                if (this.f9979d.b(a3)) {
                    fVar.b(a2);
                    return (long) a3;
                }
            }
            fVar.b(1);
        }
    }

    private long a(f fVar, int i) throws IOException, InterruptedException {
        fVar.b(this.f9976a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.f9976a[i2] & 255));
        }
        return j;
    }

    private double b(f fVar, int i) throws IOException, InterruptedException {
        long a2 = a(fVar, i);
        if (i == 4) {
            return (double) Float.intBitsToFloat((int) a2);
        }
        return Double.longBitsToDouble(a2);
    }

    private String c(f fVar, int i) throws IOException, InterruptedException {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        fVar.b(bArr, 0, i);
        return new String(bArr);
    }

    /* renamed from: com.google.android.exoplayer2.i.b.a$a  reason: collision with other inner class name */
    private static final class C0168a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f9983a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f9984b;

        private C0168a(int i, long j) {
            this.f9983a = i;
            this.f9984b = j;
        }
    }
}
