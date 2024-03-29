package com.google.a.b.a;

import com.google.a.d.c;
import com.google.a.i;
import com.google.a.l;
import com.google.a.n;
import com.google.a.o;
import com.google.a.r;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class f extends c {

    /* renamed from: a  reason: collision with root package name */
    private static final Writer f8752a = new Writer() {
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        public void flush() throws IOException {
            throw new AssertionError();
        }

        public void close() throws IOException {
            throw new AssertionError();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final r f8753b = new r("closed");

    /* renamed from: c  reason: collision with root package name */
    private final List<l> f8754c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private String f8755d;

    /* renamed from: e  reason: collision with root package name */
    private l f8756e = n.f8933a;

    public void flush() throws IOException {
    }

    public f() {
        super(f8752a);
    }

    public l a() {
        if (this.f8754c.isEmpty()) {
            return this.f8756e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f8754c);
    }

    private l j() {
        List<l> list = this.f8754c;
        return list.get(list.size() - 1);
    }

    private void a(l lVar) {
        if (this.f8755d != null) {
            if (!lVar.l() || i()) {
                ((o) j()).a(this.f8755d, lVar);
            }
            this.f8755d = null;
        } else if (this.f8754c.isEmpty()) {
            this.f8756e = lVar;
        } else {
            l j = j();
            if (j instanceof i) {
                ((i) j).a(lVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public c b() throws IOException {
        i iVar = new i();
        a((l) iVar);
        this.f8754c.add(iVar);
        return this;
    }

    public c c() throws IOException {
        if (this.f8754c.isEmpty() || this.f8755d != null) {
            throw new IllegalStateException();
        } else if (j() instanceof i) {
            List<l> list = this.f8754c;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public c d() throws IOException {
        o oVar = new o();
        a((l) oVar);
        this.f8754c.add(oVar);
        return this;
    }

    public c e() throws IOException {
        if (this.f8754c.isEmpty() || this.f8755d != null) {
            throw new IllegalStateException();
        } else if (j() instanceof o) {
            List<l> list = this.f8754c;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public c a(String str) throws IOException {
        if (this.f8754c.isEmpty() || this.f8755d != null) {
            throw new IllegalStateException();
        } else if (j() instanceof o) {
            this.f8755d = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public c b(String str) throws IOException {
        if (str == null) {
            return f();
        }
        a((l) new r(str));
        return this;
    }

    public c f() throws IOException {
        a((l) n.f8933a);
        return this;
    }

    public c a(boolean z) throws IOException {
        a((l) new r(Boolean.valueOf(z)));
        return this;
    }

    public c a(Boolean bool) throws IOException {
        if (bool == null) {
            return f();
        }
        a((l) new r(bool));
        return this;
    }

    public c a(double d2) throws IOException {
        if (g() || (!Double.isNaN(d2) && !Double.isInfinite(d2))) {
            a((l) new r((Number) Double.valueOf(d2)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d2);
    }

    public c a(long j) throws IOException {
        a((l) new r((Number) Long.valueOf(j)));
        return this;
    }

    public c a(Number number) throws IOException {
        if (number == null) {
            return f();
        }
        if (!g()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a((l) new r(number));
        return this;
    }

    public void close() throws IOException {
        if (this.f8754c.isEmpty()) {
            this.f8754c.add(f8753b);
            return;
        }
        throw new IOException("Incomplete document");
    }
}
