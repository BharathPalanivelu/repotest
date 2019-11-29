package com.bca.xco.widget.d.b;

import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.EOFException;

final class o implements b {

    /* renamed from: a  reason: collision with root package name */
    public final g f5241a = new g();

    /* renamed from: b  reason: collision with root package name */
    public final d f5242b;

    /* renamed from: c  reason: collision with root package name */
    boolean f5243c;

    o(d dVar) {
        if (dVar != null) {
            this.f5242b = dVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public g b() {
        return this.f5241a;
    }

    public long a(g gVar, long j) {
        if (gVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f5243c) {
            throw new IllegalStateException("closed");
        } else if (this.f5241a.f5215b == 0 && this.f5242b.a(this.f5241a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
            return -1;
        } else {
            return this.f5241a.a(gVar, Math.min(j, this.f5241a.f5215b));
        }
    }

    public boolean d() {
        if (!this.f5243c) {
            return this.f5241a.d() && this.f5242b.a(this.f5241a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public void c(long j) {
        if (!a(j)) {
            throw new EOFException();
        }
    }

    public boolean a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.f5243c) {
            while (this.f5241a.f5215b < j) {
                if (this.f5242b.a(this.f5241a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public byte e() {
        c(1);
        return this.f5241a.e();
    }

    public h e(long j) {
        c(j);
        return this.f5241a.e(j);
    }

    public byte[] k() {
        this.f5241a.a(this.f5242b);
        return this.f5241a.k();
    }

    public byte[] f(long j) {
        c(j);
        return this.f5241a.f(j);
    }

    public String l() {
        long a2 = a((byte) 10);
        if (a2 != -1) {
            return this.f5241a.i(a2);
        }
        g gVar = new g();
        g gVar2 = this.f5241a;
        gVar2.a(gVar, 0, Math.min(32, gVar2.m()));
        throw new EOFException("\\n not found: size=" + this.f5241a.m() + " content=" + gVar.p().c() + "…");
    }

    public short f() {
        c(2);
        return this.f5241a.f();
    }

    public short g() {
        c(2);
        return this.f5241a.g();
    }

    public int h() {
        c(4);
        return this.f5241a.h();
    }

    public int i() {
        c(4);
        return this.f5241a.i();
    }

    public long j() {
        c(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!a((long) i2)) {
                break;
            }
            byte g2 = this.f5241a.g((long) i);
            if ((g2 >= 48 && g2 <= 57) || ((g2 >= 97 && g2 <= 102) || (g2 >= 65 && g2 <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(g2)}));
            }
        }
        return this.f5241a.j();
    }

    public void d(long j) {
        if (!this.f5243c) {
            while (j > 0) {
                if (this.f5241a.f5215b == 0 && this.f5242b.a(this.f5241a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f5241a.m());
                this.f5241a.d(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public long a(byte b2) {
        return a(b2, 0);
    }

    public long a(byte b2, long j) {
        if (!this.f5243c) {
            while (true) {
                long a2 = this.f5241a.a(b2, j);
                if (a2 != -1) {
                    return a2;
                }
                long j2 = this.f5241a.f5215b;
                if (this.f5242b.a(this.f5241a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                    return -1;
                }
                j = Math.max(j, j2);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public void close() {
        if (!this.f5243c) {
            this.f5243c = true;
            this.f5242b.close();
            this.f5241a.r();
        }
    }

    public s a() {
        return this.f5242b.a();
    }

    public String toString() {
        return "buffer(" + this.f5242b + SQLBuilder.PARENTHESES_RIGHT;
    }
}
