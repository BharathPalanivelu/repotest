package e;

import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class g implements u {

    /* renamed from: a  reason: collision with root package name */
    private final d f32739a;

    /* renamed from: b  reason: collision with root package name */
    private final Deflater f32740b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f32741c;

    g(d dVar, Deflater deflater) {
        if (dVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater != null) {
            this.f32739a = dVar;
            this.f32740b = deflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public void write(c cVar, long j) throws IOException {
        x.a(cVar.f32725b, 0, j);
        while (j > 0) {
            r rVar = cVar.f32724a;
            int min = (int) Math.min(j, (long) (rVar.f32783c - rVar.f32782b));
            this.f32740b.setInput(rVar.f32781a, rVar.f32782b, min);
            a(false);
            long j2 = (long) min;
            cVar.f32725b -= j2;
            rVar.f32782b += min;
            if (rVar.f32782b == rVar.f32783c) {
                cVar.f32724a = rVar.c();
                s.a(rVar);
            }
            j -= j2;
        }
    }

    @IgnoreJRERequirement
    private void a(boolean z) throws IOException {
        r f2;
        int i;
        c b2 = this.f32739a.b();
        while (true) {
            f2 = b2.f(1);
            if (z) {
                i = this.f32740b.deflate(f2.f32781a, f2.f32783c, 8192 - f2.f32783c, 2);
            } else {
                i = this.f32740b.deflate(f2.f32781a, f2.f32783c, 8192 - f2.f32783c);
            }
            if (i > 0) {
                f2.f32783c += i;
                b2.f32725b += (long) i;
                this.f32739a.A();
            } else if (this.f32740b.needsInput()) {
                break;
            }
        }
        if (f2.f32782b == f2.f32783c) {
            b2.f32724a = f2.c();
            s.a(f2);
        }
    }

    public void flush() throws IOException {
        a(true);
        this.f32739a.flush();
    }

    /* access modifiers changed from: package-private */
    public void a() throws IOException {
        this.f32740b.finish();
        a(false);
    }

    public void close() throws IOException {
        if (!this.f32741c) {
            Throwable th = null;
            try {
                a();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f32740b.end();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            try {
                this.f32739a.close();
            } catch (Throwable th4) {
                if (th == null) {
                    th = th4;
                }
            }
            this.f32741c = true;
            if (th != null) {
                x.a(th);
            }
        }
    }

    public w timeout() {
        return this.f32739a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f32739a + SQLBuilder.PARENTHESES_RIGHT;
    }
}
