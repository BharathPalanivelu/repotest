package com.bca.xco.widget.d.b;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class k implements d {

    /* renamed from: a  reason: collision with root package name */
    private int f5223a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final b f5224b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f5225c;

    /* renamed from: d  reason: collision with root package name */
    private final l f5226d;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f5227e = new CRC32();

    public k(d dVar) {
        if (dVar != null) {
            this.f5225c = new Inflater(true);
            this.f5224b = m.a(dVar);
            this.f5226d = new l(this.f5224b, this.f5225c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long a(g gVar, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            if (this.f5223a == 0) {
                b();
                this.f5223a = 1;
            }
            if (this.f5223a == 1) {
                long j2 = gVar.f5215b;
                long a2 = this.f5226d.a(gVar, j);
                if (a2 != -1) {
                    a(gVar, j2, a2);
                    return a2;
                }
                this.f5223a = 2;
            }
            if (this.f5223a == 2) {
                c();
                this.f5223a = 3;
                if (!this.f5224b.d()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    private void b() {
        this.f5224b.c(10);
        byte g2 = this.f5224b.b().g(3);
        boolean z = ((g2 >> 1) & 1) == 1;
        if (z) {
            a(this.f5224b.b(), 0, 10);
        }
        a("ID1ID2", 8075, (int) this.f5224b.f());
        this.f5224b.d(8);
        if (((g2 >> 2) & 1) == 1) {
            this.f5224b.c(2);
            if (z) {
                a(this.f5224b.b(), 0, 2);
            }
            long g3 = (long) this.f5224b.b().g();
            this.f5224b.c(g3);
            if (z) {
                a(this.f5224b.b(), 0, g3);
            }
            this.f5224b.d(g3);
        }
        if (((g2 >> 3) & 1) == 1) {
            long a2 = this.f5224b.a((byte) 0);
            if (a2 != -1) {
                if (z) {
                    a(this.f5224b.b(), 0, a2 + 1);
                }
                this.f5224b.d(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((g2 >> 4) & 1) == 1) {
            long a3 = this.f5224b.a((byte) 0);
            if (a3 != -1) {
                if (z) {
                    a(this.f5224b.b(), 0, a3 + 1);
                }
                this.f5224b.d(a3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", (int) this.f5224b.g(), (int) (short) ((int) this.f5227e.getValue()));
            this.f5227e.reset();
        }
    }

    private void c() {
        a("CRC", this.f5224b.i(), (int) this.f5227e.getValue());
        a("ISIZE", this.f5224b.i(), this.f5225c.getTotalOut());
    }

    public s a() {
        return this.f5224b.a();
    }

    public void close() {
        this.f5226d.close();
    }

    private void a(g gVar, long j, long j2) {
        p pVar = gVar.f5214a;
        while (j >= ((long) (pVar.f5246c - pVar.f5245b))) {
            j -= (long) (pVar.f5246c - pVar.f5245b);
            pVar = pVar.f5249f;
        }
        while (j2 > 0) {
            int i = (int) (((long) pVar.f5245b) + j);
            int min = (int) Math.min((long) (pVar.f5246c - i), j2);
            this.f5227e.update(pVar.f5244a, i, min);
            j2 -= (long) min;
            pVar = pVar.f5249f;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
