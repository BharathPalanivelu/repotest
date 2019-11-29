package com.google.a.d;

import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class c implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f8906a = new String[128];

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f8907b;

    /* renamed from: c  reason: collision with root package name */
    private final Writer f8908c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f8909d = new int[32];

    /* renamed from: e  reason: collision with root package name */
    private int f8910e = 0;

    /* renamed from: f  reason: collision with root package name */
    private String f8911f;

    /* renamed from: g  reason: collision with root package name */
    private String f8912g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f8906a[i2] = String.format("\\u%04x", new Object[]{Integer.valueOf(i2)});
        }
        String[] strArr = f8906a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f8907b = (String[]) strArr.clone();
        String[] strArr2 = f8907b;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.f8912g = ":";
        this.k = true;
        if (writer != null) {
            this.f8908c = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    public final void c(String str) {
        if (str.length() == 0) {
            this.f8911f = null;
            this.f8912g = ":";
            return;
        }
        this.f8911f = str;
        this.f8912g = ": ";
    }

    public final void b(boolean z) {
        this.h = z;
    }

    public boolean g() {
        return this.h;
    }

    public final void c(boolean z) {
        this.i = z;
    }

    public final boolean h() {
        return this.i;
    }

    public final void d(boolean z) {
        this.k = z;
    }

    public final boolean i() {
        return this.k;
    }

    public c b() throws IOException {
        j();
        return a(1, "[");
    }

    public c c() throws IOException {
        return a(1, 2, "]");
    }

    public c d() throws IOException {
        j();
        return a(3, "{");
    }

    public c e() throws IOException {
        return a(3, 5, "}");
    }

    private c a(int i2, String str) throws IOException {
        m();
        a(i2);
        this.f8908c.write(str);
        return this;
    }

    private c a(int i2, int i3, String str) throws IOException {
        int a2 = a();
        if (a2 != i3 && a2 != i2) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.j == null) {
            this.f8910e--;
            if (a2 == i3) {
                k();
            }
            this.f8908c.write(str);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.j);
        }
    }

    private void a(int i2) {
        int i3 = this.f8910e;
        int[] iArr = this.f8909d;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(i3 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f8909d = iArr2;
        }
        int[] iArr3 = this.f8909d;
        int i4 = this.f8910e;
        this.f8910e = i4 + 1;
        iArr3[i4] = i2;
    }

    private int a() {
        int i2 = this.f8910e;
        if (i2 != 0) {
            return this.f8909d[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void b(int i2) {
        this.f8909d[this.f8910e - 1] = i2;
    }

    public c a(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.j != null) {
            throw new IllegalStateException();
        } else if (this.f8910e != 0) {
            this.j = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    private void j() throws IOException {
        if (this.j != null) {
            l();
            d(this.j);
            this.j = null;
        }
    }

    public c b(String str) throws IOException {
        if (str == null) {
            return f();
        }
        j();
        m();
        d(str);
        return this;
    }

    public c f() throws IOException {
        if (this.j != null) {
            if (this.k) {
                j();
            } else {
                this.j = null;
                return this;
            }
        }
        m();
        this.f8908c.write("null");
        return this;
    }

    public c a(boolean z) throws IOException {
        j();
        m();
        this.f8908c.write(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public c a(Boolean bool) throws IOException {
        if (bool == null) {
            return f();
        }
        j();
        m();
        this.f8908c.write(bool.booleanValue() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public c a(double d2) throws IOException {
        j();
        if (this.h || (!Double.isNaN(d2) && !Double.isInfinite(d2))) {
            m();
            this.f8908c.append(Double.toString(d2));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
    }

    public c a(long j2) throws IOException {
        j();
        m();
        this.f8908c.write(Long.toString(j2));
        return this;
    }

    public c a(Number number) throws IOException {
        if (number == null) {
            return f();
        }
        j();
        String obj = number.toString();
        if (this.h || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            m();
            this.f8908c.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public void flush() throws IOException {
        if (this.f8910e != 0) {
            this.f8908c.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public void close() throws IOException {
        this.f8908c.close();
        int i2 = this.f8910e;
        if (i2 > 1 || (i2 == 1 && this.f8909d[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f8910e = 0;
    }

    private void d(String str) throws IOException {
        String str2;
        String[] strArr = this.i ? f8907b : f8906a;
        this.f8908c.write("\"");
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i2 < i3) {
                this.f8908c.write(str, i2, i3 - i2);
            }
            this.f8908c.write(str2);
            i2 = i3 + 1;
        }
        if (i2 < length) {
            this.f8908c.write(str, i2, length - i2);
        }
        this.f8908c.write("\"");
    }

    private void k() throws IOException {
        if (this.f8911f != null) {
            this.f8908c.write("\n");
            int i2 = this.f8910e;
            for (int i3 = 1; i3 < i2; i3++) {
                this.f8908c.write(this.f8911f);
            }
        }
    }

    private void l() throws IOException {
        int a2 = a();
        if (a2 == 5) {
            this.f8908c.write(44);
        } else if (a2 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        k();
        b(4);
    }

    private void m() throws IOException {
        int a2 = a();
        if (a2 == 1) {
            b(2);
            k();
        } else if (a2 == 2) {
            this.f8908c.append(',');
            k();
        } else if (a2 != 4) {
            if (a2 != 6) {
                if (a2 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            b(7);
        } else {
            this.f8908c.append(this.f8912g);
            b(5);
        }
    }
}
