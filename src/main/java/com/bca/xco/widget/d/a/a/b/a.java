package com.bca.xco.widget.d.a.a.b;

import com.bca.xco.widget.d.a.a.a.g;
import com.bca.xco.widget.d.a.a.f.i;
import com.bca.xco.widget.d.a.a.f.j;
import com.bca.xco.widget.d.a.a.f.l;
import com.bca.xco.widget.d.a.aa;
import com.bca.xco.widget.d.a.r;
import com.bca.xco.widget.d.a.s;
import com.bca.xco.widget.d.a.t;
import com.bca.xco.widget.d.a.x;
import com.bca.xco.widget.d.a.z;
import com.bca.xco.widget.d.b.m;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

public final class a implements com.bca.xco.widget.d.a.a.f.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final s f4772a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final g f4773b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final com.bca.xco.widget.d.b.b f4774c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final com.bca.xco.widget.d.b.a f4775d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f4776e = 0;

    public a(s sVar, g gVar, com.bca.xco.widget.d.b.b bVar, com.bca.xco.widget.d.b.a aVar) {
        this.f4772a = sVar;
        this.f4773b = gVar;
        this.f4774c = bVar;
        this.f4775d = aVar;
    }

    public com.bca.xco.widget.d.b.c a(x xVar, long j) {
        if ("chunked".equalsIgnoreCase(xVar.a(HttpConstants.Header.TRANSFER_ENCODING))) {
            return e();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void a(x xVar) {
        a(xVar.c(), j.a(xVar, this.f4773b.b().a().b().type()));
    }

    public z.a a() {
        return c();
    }

    public aa a(z zVar) {
        return new i(zVar.d(), m.a(b(zVar)));
    }

    private com.bca.xco.widget.d.b.d b(z zVar) {
        if (!com.bca.xco.widget.d.a.a.f.f.b(zVar)) {
            return b(0);
        }
        if ("chunked".equalsIgnoreCase(zVar.a(HttpConstants.Header.TRANSFER_ENCODING))) {
            return a(zVar.a().a());
        }
        long a2 = com.bca.xco.widget.d.a.a.f.f.a(zVar);
        if (a2 != -1) {
            return b(a2);
        }
        return f();
    }

    public void b() {
        this.f4775d.flush();
    }

    public void a(r rVar, String str) {
        if (this.f4776e == 0) {
            this.f4775d.a(str).a(IOUtils.LINE_SEPARATOR_WINDOWS);
            int a2 = rVar.a();
            for (int i = 0; i < a2; i++) {
                this.f4775d.a(rVar.a(i)).a(": ").a(rVar.b(i)).a(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
            this.f4775d.a(IOUtils.LINE_SEPARATOR_WINDOWS);
            this.f4776e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f4776e);
    }

    public z.a c() {
        l a2;
        z.a a3;
        int i = this.f4776e;
        if (i == 1 || i == 3) {
            do {
                try {
                    a2 = l.a(this.f4774c.l());
                    a3 = new z.a().a(a2.f4888a).a(a2.f4889b).a(a2.f4890c).a(d());
                } catch (EOFException e2) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.f4773b);
                    iOException.initCause(e2);
                    throw iOException;
                }
            } while (a2.f4889b == 100);
            this.f4776e = 4;
            return a3;
        }
        throw new IllegalStateException("state: " + this.f4776e);
    }

    public r d() {
        r.a aVar = new r.a();
        while (true) {
            String l = this.f4774c.l();
            if (l.length() == 0) {
                return aVar.a();
            }
            com.bca.xco.widget.d.a.a.a.f4741a.a(aVar, l);
        }
    }

    public com.bca.xco.widget.d.b.c e() {
        if (this.f4776e == 1) {
            this.f4776e = 2;
            return new b();
        }
        throw new IllegalStateException("state: " + this.f4776e);
    }

    public com.bca.xco.widget.d.b.c a(long j) {
        if (this.f4776e == 1) {
            this.f4776e = 2;
            return new d(j);
        }
        throw new IllegalStateException("state: " + this.f4776e);
    }

    public com.bca.xco.widget.d.b.d b(long j) {
        if (this.f4776e == 4) {
            this.f4776e = 5;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.f4776e);
    }

    public com.bca.xco.widget.d.b.d a(t tVar) {
        if (this.f4776e == 4) {
            this.f4776e = 5;
            return new c(tVar);
        }
        throw new IllegalStateException("state: " + this.f4776e);
    }

    public com.bca.xco.widget.d.b.d f() {
        if (this.f4776e == 4) {
            g gVar = this.f4773b;
            if (gVar != null) {
                this.f4776e = 5;
                gVar.d();
                return new f();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f4776e);
    }

    /* access modifiers changed from: private */
    public void a(com.bca.xco.widget.d.b.j jVar) {
        com.bca.xco.widget.d.b.s a2 = jVar.a();
        jVar.a(com.bca.xco.widget.d.b.s.f5255b);
        a2.f();
        a2.e();
    }

    private final class d implements com.bca.xco.widget.d.b.c {

        /* renamed from: b  reason: collision with root package name */
        private final com.bca.xco.widget.d.b.j f4788b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4789c;

        /* renamed from: d  reason: collision with root package name */
        private long f4790d;

        private d(long j) {
            this.f4788b = new com.bca.xco.widget.d.b.j(a.this.f4775d.a());
            this.f4790d = j;
        }

        public com.bca.xco.widget.d.b.s a() {
            return this.f4788b;
        }

        public void a_(com.bca.xco.widget.d.b.g gVar, long j) {
            if (!this.f4789c) {
                com.bca.xco.widget.d.a.a.c.a(gVar.m(), 0, j);
                if (j <= this.f4790d) {
                    a.this.f4775d.a_(gVar, j);
                    this.f4790d -= j;
                    return;
                }
                throw new ProtocolException("expected " + this.f4790d + " bytes but received " + j);
            }
            throw new IllegalStateException("closed");
        }

        public void flush() {
            if (!this.f4789c) {
                a.this.f4775d.flush();
            }
        }

        public void close() {
            if (!this.f4789c) {
                this.f4789c = true;
                if (this.f4790d <= 0) {
                    a.this.a(this.f4788b);
                    int unused = a.this.f4776e = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    private final class b implements com.bca.xco.widget.d.b.c {

        /* renamed from: b  reason: collision with root package name */
        private final com.bca.xco.widget.d.b.j f4781b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4782c;

        private b() {
            this.f4781b = new com.bca.xco.widget.d.b.j(a.this.f4775d.a());
        }

        public com.bca.xco.widget.d.b.s a() {
            return this.f4781b;
        }

        public void a_(com.bca.xco.widget.d.b.g gVar, long j) {
            if (this.f4782c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                a.this.f4775d.b(j);
                a.this.f4775d.a(IOUtils.LINE_SEPARATOR_WINDOWS);
                a.this.f4775d.a_(gVar, j);
                a.this.f4775d.a(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
        }

        public synchronized void flush() {
            if (!this.f4782c) {
                a.this.f4775d.flush();
            }
        }

        public synchronized void close() {
            if (!this.f4782c) {
                this.f4782c = true;
                a.this.f4775d.a("0\r\n\r\n");
                a.this.a(this.f4781b);
                int unused = a.this.f4776e = 3;
            }
        }
    }

    /* renamed from: com.bca.xco.widget.d.a.a.b.a$a  reason: collision with other inner class name */
    private abstract class C0091a implements com.bca.xco.widget.d.b.d {

        /* renamed from: a  reason: collision with root package name */
        protected final com.bca.xco.widget.d.b.j f4777a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f4778b;

        private C0091a() {
            this.f4777a = new com.bca.xco.widget.d.b.j(a.this.f4774c.a());
        }

        public com.bca.xco.widget.d.b.s a() {
            return this.f4777a;
        }

        /* access modifiers changed from: protected */
        public final void a(boolean z) {
            if (a.this.f4776e != 6) {
                if (a.this.f4776e == 5) {
                    a.this.a(this.f4777a);
                    int unused = a.this.f4776e = 6;
                    if (a.this.f4773b != null) {
                        a.this.f4773b.a(!z, (com.bca.xco.widget.d.a.a.f.a) a.this);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("state: " + a.this.f4776e);
            }
        }
    }

    private class e extends C0091a {

        /* renamed from: e  reason: collision with root package name */
        private long f4792e;

        public e(long j) {
            super();
            this.f4792e = j;
            if (this.f4792e == 0) {
                a(true);
            }
        }

        public long a(com.bca.xco.widget.d.b.g gVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f4778b) {
                throw new IllegalStateException("closed");
            } else if (this.f4792e == 0) {
                return -1;
            } else {
                long a2 = a.this.f4774c.a(gVar, Math.min(this.f4792e, j));
                if (a2 != -1) {
                    this.f4792e -= a2;
                    if (this.f4792e == 0) {
                        a(true);
                    }
                    return a2;
                }
                a(false);
                throw new ProtocolException("unexpected end of stream");
            }
        }

        public void close() {
            if (!this.f4778b) {
                if (this.f4792e != 0 && !com.bca.xco.widget.d.a.a.c.a((com.bca.xco.widget.d.b.d) this, 100, TimeUnit.MILLISECONDS)) {
                    a(false);
                }
                this.f4778b = true;
            }
        }
    }

    private class c extends C0091a {

        /* renamed from: e  reason: collision with root package name */
        private final t f4784e;

        /* renamed from: f  reason: collision with root package name */
        private long f4785f = -1;

        /* renamed from: g  reason: collision with root package name */
        private boolean f4786g = true;

        c(t tVar) {
            super();
            this.f4784e = tVar;
        }

        public long a(com.bca.xco.widget.d.b.g gVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f4778b) {
                throw new IllegalStateException("closed");
            } else if (!this.f4786g) {
                return -1;
            } else {
                long j2 = this.f4785f;
                if (j2 == 0 || j2 == -1) {
                    b();
                    if (!this.f4786g) {
                        return -1;
                    }
                }
                long a2 = a.this.f4774c.a(gVar, Math.min(j, this.f4785f));
                if (a2 != -1) {
                    this.f4785f -= a2;
                    return a2;
                }
                a(false);
                throw new ProtocolException("unexpected end of stream");
            }
        }

        private void b() {
            if (this.f4785f != -1) {
                a.this.f4774c.l();
            }
            try {
                this.f4785f = a.this.f4774c.j();
                String trim = a.this.f4774c.l().trim();
                if (this.f4785f < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f4785f + trim + "\"");
                } else if (this.f4785f == 0) {
                    this.f4786g = false;
                    com.bca.xco.widget.d.a.a.f.f.a(a.this.f4772a.f(), this.f4784e, a.this.d());
                    a(true);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        public void close() {
            if (!this.f4778b) {
                if (this.f4786g && !com.bca.xco.widget.d.a.a.c.a((com.bca.xco.widget.d.b.d) this, 100, TimeUnit.MILLISECONDS)) {
                    a(false);
                }
                this.f4778b = true;
            }
        }
    }

    private class f extends C0091a {

        /* renamed from: e  reason: collision with root package name */
        private boolean f4794e;

        private f() {
            super();
        }

        public long a(com.bca.xco.widget.d.b.g gVar, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f4778b) {
                throw new IllegalStateException("closed");
            } else if (this.f4794e) {
                return -1;
            } else {
                long a2 = a.this.f4774c.a(gVar, j);
                if (a2 != -1) {
                    return a2;
                }
                this.f4794e = true;
                a(true);
                return -1;
            }
        }

        public void close() {
            if (!this.f4778b) {
                if (!this.f4794e) {
                    a(false);
                }
                this.f4778b = true;
            }
        }
    }
}
