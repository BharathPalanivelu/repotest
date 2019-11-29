package com.bca.xco.widget.d.b;

import com.litesuits.orm.db.assit.SQLBuilder;

final class n implements a {

    /* renamed from: a  reason: collision with root package name */
    public final g f5238a = new g();

    /* renamed from: b  reason: collision with root package name */
    public final c f5239b;

    /* renamed from: c  reason: collision with root package name */
    boolean f5240c;

    n(c cVar) {
        if (cVar != null) {
            this.f5239b = cVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public g b() {
        return this.f5238a;
    }

    public void a_(g gVar, long j) {
        if (!this.f5240c) {
            this.f5238a.a_(gVar, j);
            c();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public a a(String str) {
        if (!this.f5240c) {
            this.f5238a.a(str);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public a a(byte[] bArr) {
        if (!this.f5240c) {
            this.f5238a.a(bArr);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public a a(byte[] bArr, int i, int i2) {
        if (!this.f5240c) {
            this.f5238a.a(bArr, i, i2);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public a a(int i) {
        if (!this.f5240c) {
            this.f5238a.a(i);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public a b(int i) {
        if (!this.f5240c) {
            this.f5238a.b(i);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public a c(int i) {
        if (!this.f5240c) {
            this.f5238a.c(i);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public a a(long j) {
        if (!this.f5240c) {
            this.f5238a.a(j);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public a b(long j) {
        if (!this.f5240c) {
            this.f5238a.b(j);
            return c();
        }
        throw new IllegalStateException("closed");
    }

    public a c() {
        if (!this.f5240c) {
            long o = this.f5238a.o();
            if (o > 0) {
                this.f5239b.a_(this.f5238a, o);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void flush() {
        if (!this.f5240c) {
            if (this.f5238a.f5215b > 0) {
                c cVar = this.f5239b;
                g gVar = this.f5238a;
                cVar.a_(gVar, gVar.f5215b);
            }
            this.f5239b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public void close() {
        if (!this.f5240c) {
            Throwable th = null;
            try {
                if (this.f5238a.f5215b > 0) {
                    this.f5239b.a_(this.f5238a, this.f5238a.f5215b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f5239b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f5240c = true;
            if (th != null) {
                t.a(th);
            }
        }
    }

    public s a() {
        return this.f5239b.a();
    }

    public String toString() {
        return "buffer(" + this.f5239b + SQLBuilder.PARENTHESES_RIGHT;
    }
}
