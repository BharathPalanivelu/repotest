package com.bca.xco.widget.d.b;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class l implements d {

    /* renamed from: a  reason: collision with root package name */
    private final b f5228a;

    /* renamed from: b  reason: collision with root package name */
    private final Inflater f5229b;

    /* renamed from: c  reason: collision with root package name */
    private int f5230c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5231d;

    l(b bVar, Inflater inflater) {
        if (bVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f5228a = bVar;
            this.f5229b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public long a(g gVar, long j) {
        p h;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f5231d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            while (true) {
                boolean b2 = b();
                try {
                    h = gVar.h(1);
                    int inflate = this.f5229b.inflate(h.f5244a, h.f5246c, 8192 - h.f5246c);
                    if (inflate > 0) {
                        h.f5246c += inflate;
                        long j2 = (long) inflate;
                        gVar.f5215b += j2;
                        return j2;
                    } else if (this.f5229b.finished()) {
                        break;
                    } else if (this.f5229b.needsDictionary()) {
                        break;
                    } else if (b2) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            c();
            if (h.f5245b != h.f5246c) {
                return -1;
            }
            gVar.f5214a = h.a();
            q.a(h);
            return -1;
        }
    }

    public boolean b() {
        if (!this.f5229b.needsInput()) {
            return false;
        }
        c();
        if (this.f5229b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f5228a.d()) {
            return true;
        } else {
            p pVar = this.f5228a.b().f5214a;
            this.f5230c = pVar.f5246c - pVar.f5245b;
            this.f5229b.setInput(pVar.f5244a, pVar.f5245b, this.f5230c);
            return false;
        }
    }

    private void c() {
        int i = this.f5230c;
        if (i != 0) {
            int remaining = i - this.f5229b.getRemaining();
            this.f5230c -= remaining;
            this.f5228a.d((long) remaining);
        }
    }

    public s a() {
        return this.f5228a.a();
    }

    public void close() {
        if (!this.f5231d) {
            this.f5229b.end();
            this.f5231d = true;
            this.f5228a.close();
        }
    }
}
