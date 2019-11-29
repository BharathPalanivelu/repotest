package e;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class k implements u {

    /* renamed from: a  reason: collision with root package name */
    private final d f32743a;

    /* renamed from: b  reason: collision with root package name */
    private final Deflater f32744b;

    /* renamed from: c  reason: collision with root package name */
    private final g f32745c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f32746d;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f32747e = new CRC32();

    public k(u uVar) {
        if (uVar != null) {
            this.f32744b = new Deflater(-1, true);
            this.f32743a = n.a(uVar);
            this.f32745c = new g(this.f32743a, this.f32744b);
            a();
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public void write(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j != 0) {
            a(cVar, j);
            this.f32745c.write(cVar, j);
        }
    }

    public void flush() throws IOException {
        this.f32745c.flush();
    }

    public w timeout() {
        return this.f32743a.timeout();
    }

    public void close() throws IOException {
        if (!this.f32746d) {
            Throwable th = null;
            try {
                this.f32745c.a();
                b();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f32744b.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.f32743a.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.f32746d = true;
            if (th != null) {
                x.a(th);
            }
        }
    }

    private void a() {
        c b2 = this.f32743a.b();
        b2.j(8075);
        b2.k(8);
        b2.k(0);
        b2.i(0);
        b2.k(0);
        b2.k(0);
    }

    private void b() throws IOException {
        this.f32743a.h((int) this.f32747e.getValue());
        this.f32743a.h((int) this.f32744b.getBytesRead());
    }

    private void a(c cVar, long j) {
        r rVar = cVar.f32724a;
        while (j > 0) {
            int min = (int) Math.min(j, (long) (rVar.f32783c - rVar.f32782b));
            this.f32747e.update(rVar.f32781a, rVar.f32782b, min);
            j -= (long) min;
            rVar = rVar.f32786f;
        }
    }
}
