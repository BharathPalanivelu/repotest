package e;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class m implements v {

    /* renamed from: a  reason: collision with root package name */
    private final e f32753a;

    /* renamed from: b  reason: collision with root package name */
    private final Inflater f32754b;

    /* renamed from: c  reason: collision with root package name */
    private int f32755c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f32756d;

    m(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f32753a = eVar;
            this.f32754b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public long read(c cVar, long j) throws IOException {
        r f2;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f32756d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            while (true) {
                boolean a2 = a();
                try {
                    f2 = cVar.f(1);
                    int inflate = this.f32754b.inflate(f2.f32781a, f2.f32783c, (int) Math.min(j, (long) (8192 - f2.f32783c)));
                    if (inflate > 0) {
                        f2.f32783c += inflate;
                        long j2 = (long) inflate;
                        cVar.f32725b += j2;
                        return j2;
                    } else if (this.f32754b.finished()) {
                        break;
                    } else if (this.f32754b.needsDictionary()) {
                        break;
                    } else if (a2) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            b();
            if (f2.f32782b != f2.f32783c) {
                return -1;
            }
            cVar.f32724a = f2.c();
            s.a(f2);
            return -1;
        }
    }

    public final boolean a() throws IOException {
        if (!this.f32754b.needsInput()) {
            return false;
        }
        b();
        if (this.f32754b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f32753a.f()) {
            return true;
        } else {
            r rVar = this.f32753a.b().f32724a;
            this.f32755c = rVar.f32783c - rVar.f32782b;
            this.f32754b.setInput(rVar.f32781a, rVar.f32782b, this.f32755c);
            return false;
        }
    }

    private void b() throws IOException {
        int i = this.f32755c;
        if (i != 0) {
            int remaining = i - this.f32754b.getRemaining();
            this.f32755c -= remaining;
            this.f32753a.i((long) remaining);
        }
    }

    public w timeout() {
        return this.f32753a.timeout();
    }

    public void close() throws IOException {
        if (!this.f32756d) {
            this.f32754b.end();
            this.f32756d = true;
            this.f32753a.close();
        }
    }
}
