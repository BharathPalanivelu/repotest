package com.google.a.b.a;

import com.google.a.d.a;
import com.google.a.d.b;
import com.google.a.i;
import com.google.a.l;
import com.google.a.n;
import com.google.a.o;
import com.google.a.r;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;

public final class e extends a {

    /* renamed from: b  reason: collision with root package name */
    private static final Reader f8746b = new Reader() {
        public int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }

        public void close() throws IOException {
            throw new AssertionError();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final Object f8747c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private Object[] f8748d = new Object[32];

    /* renamed from: e  reason: collision with root package name */
    private int f8749e = 0;

    /* renamed from: f  reason: collision with root package name */
    private String[] f8750f = new String[32];

    /* renamed from: g  reason: collision with root package name */
    private int[] f8751g = new int[32];

    public e(l lVar) {
        super(f8746b);
        a((Object) lVar);
    }

    public void a() throws IOException {
        a(b.BEGIN_ARRAY);
        a((Object) ((i) t()).iterator());
        this.f8751g[this.f8749e - 1] = 0;
    }

    public void b() throws IOException {
        a(b.END_ARRAY);
        u();
        u();
        int i = this.f8749e;
        if (i > 0) {
            int[] iArr = this.f8751g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public void c() throws IOException {
        a(b.BEGIN_OBJECT);
        a((Object) ((o) t()).a().iterator());
    }

    public void d() throws IOException {
        a(b.END_OBJECT);
        u();
        u();
        int i = this.f8749e;
        if (i > 0) {
            int[] iArr = this.f8751g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public boolean e() throws IOException {
        b f2 = f();
        return (f2 == b.END_OBJECT || f2 == b.END_ARRAY) ? false : true;
    }

    public b f() throws IOException {
        if (this.f8749e == 0) {
            return b.END_DOCUMENT;
        }
        Object t = t();
        if (t instanceof Iterator) {
            boolean z = this.f8748d[this.f8749e - 2] instanceof o;
            Iterator it = (Iterator) t;
            if (!it.hasNext()) {
                return z ? b.END_OBJECT : b.END_ARRAY;
            }
            if (z) {
                return b.NAME;
            }
            a(it.next());
            return f();
        } else if (t instanceof o) {
            return b.BEGIN_OBJECT;
        } else {
            if (t instanceof i) {
                return b.BEGIN_ARRAY;
            }
            if (t instanceof r) {
                r rVar = (r) t;
                if (rVar.r()) {
                    return b.STRING;
                }
                if (rVar.a()) {
                    return b.BOOLEAN;
                }
                if (rVar.q()) {
                    return b.NUMBER;
                }
                throw new AssertionError();
            } else if (t instanceof n) {
                return b.NULL;
            } else {
                if (t == f8747c) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    private Object t() {
        return this.f8748d[this.f8749e - 1];
    }

    private Object u() {
        Object[] objArr = this.f8748d;
        int i = this.f8749e - 1;
        this.f8749e = i;
        Object obj = objArr[i];
        objArr[this.f8749e] = null;
        return obj;
    }

    private void a(b bVar) throws IOException {
        if (f() != bVar) {
            throw new IllegalStateException("Expected " + bVar + " but was " + f() + v());
        }
    }

    public String g() throws IOException {
        a(b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
        String str = (String) entry.getKey();
        this.f8750f[this.f8749e - 1] = str;
        a(entry.getValue());
        return str;
    }

    public String h() throws IOException {
        b f2 = f();
        if (f2 == b.STRING || f2 == b.NUMBER) {
            String c2 = ((r) u()).c();
            int i = this.f8749e;
            if (i > 0) {
                int[] iArr = this.f8751g;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return c2;
        }
        throw new IllegalStateException("Expected " + b.STRING + " but was " + f2 + v());
    }

    public boolean i() throws IOException {
        a(b.BOOLEAN);
        boolean h = ((r) u()).h();
        int i = this.f8749e;
        if (i > 0) {
            int[] iArr = this.f8751g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return h;
    }

    public void j() throws IOException {
        a(b.NULL);
        u();
        int i = this.f8749e;
        if (i > 0) {
            int[] iArr = this.f8751g;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public double k() throws IOException {
        b f2 = f();
        if (f2 == b.NUMBER || f2 == b.STRING) {
            double d2 = ((r) t()).d();
            if (q() || (!Double.isNaN(d2) && !Double.isInfinite(d2))) {
                u();
                int i = this.f8749e;
                if (i > 0) {
                    int[] iArr = this.f8751g;
                    int i2 = i - 1;
                    iArr[i2] = iArr[i2] + 1;
                }
                return d2;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + d2);
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f2 + v());
    }

    public long l() throws IOException {
        b f2 = f();
        if (f2 == b.NUMBER || f2 == b.STRING) {
            long f3 = ((r) t()).f();
            u();
            int i = this.f8749e;
            if (i > 0) {
                int[] iArr = this.f8751g;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return f3;
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f2 + v());
    }

    public int m() throws IOException {
        b f2 = f();
        if (f2 == b.NUMBER || f2 == b.STRING) {
            int g2 = ((r) t()).g();
            u();
            int i = this.f8749e;
            if (i > 0) {
                int[] iArr = this.f8751g;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return g2;
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f2 + v());
    }

    public void close() throws IOException {
        this.f8748d = new Object[]{f8747c};
        this.f8749e = 1;
    }

    public void n() throws IOException {
        if (f() == b.NAME) {
            g();
            this.f8750f[this.f8749e - 2] = "null";
        } else {
            u();
            int i = this.f8749e;
            if (i > 0) {
                this.f8750f[i - 1] = "null";
            }
        }
        int i2 = this.f8749e;
        if (i2 > 0) {
            int[] iArr = this.f8751g;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void o() throws IOException {
        a(b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
        a(entry.getValue());
        a((Object) new r((String) entry.getKey()));
    }

    private void a(Object obj) {
        int i = this.f8749e;
        Object[] objArr = this.f8748d;
        if (i == objArr.length) {
            Object[] objArr2 = new Object[(i * 2)];
            int[] iArr = new int[(i * 2)];
            String[] strArr = new String[(i * 2)];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.f8751g, 0, iArr, 0, this.f8749e);
            System.arraycopy(this.f8750f, 0, strArr, 0, this.f8749e);
            this.f8748d = objArr2;
            this.f8751g = iArr;
            this.f8750f = strArr;
        }
        Object[] objArr3 = this.f8748d;
        int i2 = this.f8749e;
        this.f8749e = i2 + 1;
        objArr3[i2] = obj;
    }

    public String p() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (i < this.f8749e) {
            Object[] objArr = this.f8748d;
            if (objArr[i] instanceof i) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.f8751g[i]);
                    sb.append(']');
                }
            } else if (objArr[i] instanceof o) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.f8750f;
                    if (strArr[i] != null) {
                        sb.append(strArr[i]);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    private String v() {
        return " at path " + p();
    }
}
