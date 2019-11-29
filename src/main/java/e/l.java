package e;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class l implements v {

    /* renamed from: a  reason: collision with root package name */
    private int f32748a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final e f32749b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f32750c;

    /* renamed from: d  reason: collision with root package name */
    private final m f32751d;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f32752e = new CRC32();

    public l(v vVar) {
        if (vVar != null) {
            this.f32750c = new Inflater(true);
            this.f32749b = n.a(vVar);
            this.f32751d = new m(this.f32749b, this.f32750c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long read(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            if (this.f32748a == 0) {
                a();
                this.f32748a = 1;
            }
            if (this.f32748a == 1) {
                long j2 = cVar.f32725b;
                long read = this.f32751d.read(cVar, j);
                if (read != -1) {
                    a(cVar, j2, read);
                    return read;
                }
                this.f32748a = 2;
            }
            if (this.f32748a == 2) {
                b();
                this.f32748a = 3;
                if (!this.f32749b.f()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    private void a() throws IOException {
        this.f32749b.a(10);
        byte c2 = this.f32749b.b().c(3);
        boolean z = ((c2 >> 1) & 1) == 1;
        if (z) {
            a(this.f32749b.b(), 0, 10);
        }
        a("ID1ID2", 8075, (int) this.f32749b.j());
        this.f32749b.i(8);
        if (((c2 >> 2) & 1) == 1) {
            this.f32749b.a(2);
            if (z) {
                a(this.f32749b.b(), 0, 2);
            }
            long m = (long) this.f32749b.b().m();
            this.f32749b.a(m);
            if (z) {
                a(this.f32749b.b(), 0, m);
            }
            this.f32749b.i(m);
        }
        if (((c2 >> 3) & 1) == 1) {
            long a2 = this.f32749b.a((byte) 0);
            if (a2 != -1) {
                if (z) {
                    a(this.f32749b.b(), 0, a2 + 1);
                }
                this.f32749b.i(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((c2 >> 4) & 1) == 1) {
            long a3 = this.f32749b.a((byte) 0);
            if (a3 != -1) {
                if (z) {
                    a(this.f32749b.b(), 0, a3 + 1);
                }
                this.f32749b.i(a3 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", (int) this.f32749b.m(), (int) (short) ((int) this.f32752e.getValue()));
            this.f32752e.reset();
        }
    }

    private void b() throws IOException {
        a("CRC", this.f32749b.n(), (int) this.f32752e.getValue());
        a("ISIZE", this.f32749b.n(), (int) this.f32750c.getBytesWritten());
    }

    public w timeout() {
        return this.f32749b.timeout();
    }

    public void close() throws IOException {
        this.f32751d.close();
    }

    private void a(c cVar, long j, long j2) {
        r rVar = cVar.f32724a;
        while (j >= ((long) (rVar.f32783c - rVar.f32782b))) {
            j -= (long) (rVar.f32783c - rVar.f32782b);
            rVar = rVar.f32786f;
        }
        while (j2 > 0) {
            int i = (int) (((long) rVar.f32782b) + j);
            int min = (int) Math.min((long) (rVar.f32783c - i), j2);
            this.f32752e.update(rVar.f32781a, i, min);
            j2 -= (long) min;
            rVar = rVar.f32786f;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
