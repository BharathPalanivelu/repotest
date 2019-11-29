package com.google.a.d;

import com.facebook.internal.ServerProtocol;
import com.google.a.b.a.e;
import com.google.a.b.f;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class a implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f8899b = ")]}'\n".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    int f8900a = 0;

    /* renamed from: c  reason: collision with root package name */
    private final Reader f8901c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8902d = false;

    /* renamed from: e  reason: collision with root package name */
    private final char[] f8903e = new char[1024];

    /* renamed from: f  reason: collision with root package name */
    private int f8904f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f8905g = 0;
    private int h = 0;
    private int i = 0;
    private long j;
    private int k;
    private String l;
    private int[] m = new int[32];
    private int n = 0;
    private String[] o;
    private int[] p;

    static {
        f.f8870a = new f() {
            public void a(a aVar) throws IOException {
                if (aVar instanceof e) {
                    ((e) aVar).o();
                    return;
                }
                int i = aVar.f8900a;
                if (i == 0) {
                    i = aVar.r();
                }
                if (i == 13) {
                    aVar.f8900a = 9;
                } else if (i == 12) {
                    aVar.f8900a = 8;
                } else if (i == 14) {
                    aVar.f8900a = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.f() + aVar.s());
                }
            }
        };
    }

    public a(Reader reader) {
        int[] iArr = this.m;
        int i2 = this.n;
        this.n = i2 + 1;
        iArr[i2] = 6;
        this.o = new String[32];
        this.p = new int[32];
        if (reader != null) {
            this.f8901c = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    public final void a(boolean z) {
        this.f8902d = z;
    }

    public final boolean q() {
        return this.f8902d;
    }

    public void a() throws IOException {
        int i2 = this.f8900a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 3) {
            a(1);
            this.p[this.n - 1] = 0;
            this.f8900a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + s());
    }

    public void b() throws IOException {
        int i2 = this.f8900a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 4) {
            this.n--;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            this.f8900a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + f() + s());
    }

    public void c() throws IOException {
        int i2 = this.f8900a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 1) {
            a(3);
            this.f8900a = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + s());
    }

    public void d() throws IOException {
        int i2 = this.f8900a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 2) {
            this.n--;
            String[] strArr = this.o;
            int i3 = this.n;
            strArr[i3] = null;
            int[] iArr = this.p;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f8900a = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + f() + s());
    }

    public boolean e() throws IOException {
        int i2 = this.f8900a;
        if (i2 == 0) {
            i2 = r();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public b f() throws IOException {
        int i2 = this.f8900a;
        if (i2 == 0) {
            i2 = r();
        }
        switch (i2) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public int r() throws IOException {
        int[] iArr = this.m;
        int i2 = this.n;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int b2 = b(true);
            if (b2 != 44) {
                if (b2 == 59) {
                    w();
                } else if (b2 == 93) {
                    this.f8900a = 4;
                    return 4;
                } else {
                    throw b("Unterminated array");
                }
            }
        } else if (i3 == 3 || i3 == 5) {
            this.m[this.n - 1] = 4;
            if (i3 == 5) {
                int b3 = b(true);
                if (b3 != 44) {
                    if (b3 == 59) {
                        w();
                    } else if (b3 == 125) {
                        this.f8900a = 2;
                        return 2;
                    } else {
                        throw b("Unterminated object");
                    }
                }
            }
            int b4 = b(true);
            if (b4 == 34) {
                this.f8900a = 13;
                return 13;
            } else if (b4 == 39) {
                w();
                this.f8900a = 12;
                return 12;
            } else if (b4 != 125) {
                w();
                this.f8904f--;
                if (a((char) b4)) {
                    this.f8900a = 14;
                    return 14;
                }
                throw b("Expected name");
            } else if (i3 != 5) {
                this.f8900a = 2;
                return 2;
            } else {
                throw b("Expected name");
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int b5 = b(true);
            if (b5 != 58) {
                if (b5 == 61) {
                    w();
                    if (this.f8904f < this.f8905g || b(1)) {
                        char[] cArr = this.f8903e;
                        int i4 = this.f8904f;
                        if (cArr[i4] == '>') {
                            this.f8904f = i4 + 1;
                        }
                    }
                } else {
                    throw b("Expected ':'");
                }
            }
        } else if (i3 == 6) {
            if (this.f8902d) {
                z();
            }
            this.m[this.n - 1] = 7;
        } else if (i3 == 7) {
            if (b(false) == -1) {
                this.f8900a = 17;
                return 17;
            }
            w();
            this.f8904f--;
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int b6 = b(true);
        if (b6 == 34) {
            this.f8900a = 9;
            return 9;
        } else if (b6 != 39) {
            if (!(b6 == 44 || b6 == 59)) {
                if (b6 == 91) {
                    this.f8900a = 3;
                    return 3;
                } else if (b6 != 93) {
                    if (b6 != 123) {
                        this.f8904f--;
                        int o2 = o();
                        if (o2 != 0) {
                            return o2;
                        }
                        int t = t();
                        if (t != 0) {
                            return t;
                        }
                        if (a(this.f8903e[this.f8904f])) {
                            w();
                            this.f8900a = 10;
                            return 10;
                        }
                        throw b("Expected value");
                    }
                    this.f8900a = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.f8900a = 4;
                    return 4;
                }
            }
            if (i3 == 1 || i3 == 2) {
                w();
                this.f8904f--;
                this.f8900a = 7;
                return 7;
            }
            throw b("Unexpected value");
        } else {
            w();
            this.f8900a = 8;
            return 8;
        }
    }

    private int o() throws IOException {
        String str;
        String str2;
        int i2;
        char c2 = this.f8903e[this.f8904f];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str2 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            str = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str2 = "false";
            str = "FALSE";
        } else if (c2 != 'n' && c2 != 'N') {
            return 0;
        } else {
            i2 = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f8904f + i3 >= this.f8905g && !b(i3 + 1)) {
                return 0;
            }
            char c3 = this.f8903e[this.f8904f + i3];
            if (c3 != str2.charAt(i3) && c3 != str.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f8904f + length < this.f8905g || b(length + 1)) && a(this.f8903e[this.f8904f + length])) {
            return 0;
        }
        this.f8904f += length;
        this.f8900a = i2;
        return i2;
    }

    private int t() throws IOException {
        char c2;
        char[] cArr = this.f8903e;
        int i2 = this.f8904f;
        int i3 = 0;
        int i4 = this.f8905g;
        int i5 = 0;
        char c3 = 0;
        boolean z = true;
        long j2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 + i5 == i4) {
                if (i5 == cArr.length) {
                    return i3;
                }
                if (!b(i5 + 1)) {
                    break;
                }
                i2 = this.f8904f;
                i4 = this.f8905g;
            }
            c2 = cArr[i2 + i5];
            if (c2 == '+') {
                i3 = 0;
                if (c3 != 5) {
                    return 0;
                }
            } else if (c2 == 'E' || c2 == 'e') {
                i3 = 0;
                if (c3 != 2 && c3 != 4) {
                    return 0;
                }
                c3 = 5;
                i5++;
            } else {
                if (c2 == '-') {
                    i3 = 0;
                    if (c3 == 0) {
                        c3 = 1;
                        z2 = true;
                    } else if (c3 != 5) {
                        return 0;
                    }
                } else if (c2 == '.') {
                    i3 = 0;
                    if (c3 != 2) {
                        return 0;
                    }
                    c3 = 3;
                } else if (c2 >= '0' && c2 <= '9') {
                    if (c3 == 1 || c3 == 0) {
                        j2 = (long) (-(c2 - '0'));
                        i3 = 0;
                        c3 = 2;
                    } else {
                        if (c3 == 2) {
                            if (j2 == 0) {
                                return 0;
                            }
                            long j3 = (10 * j2) - ((long) (c2 - '0'));
                            boolean z3 = j2 > -922337203685477580L || (j2 == -922337203685477580L && j3 < j2);
                            j2 = j3;
                            z = z3 & z;
                        } else if (c3 == 3) {
                            i3 = 0;
                            c3 = 4;
                        } else if (c3 == 5 || c3 == 6) {
                            i3 = 0;
                            c3 = 7;
                        }
                        i3 = 0;
                    }
                }
                i5++;
            }
            c3 = 6;
            i5++;
        }
        if (a(c2)) {
            return 0;
        }
        if (c3 == 2 && z && ((j2 != Long.MIN_VALUE || z2) && (j2 != 0 || !z2))) {
            if (!z2) {
                j2 = -j2;
            }
            this.j = j2;
            this.f8904f += i5;
            this.f8900a = 15;
            return 15;
        } else if (c3 != 2 && c3 != 4 && c3 != 7) {
            return 0;
        } else {
            this.k = i5;
            this.f8900a = 16;
            return 16;
        }
    }

    private boolean a(char c2) throws IOException {
        if (c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (!(c2 == '/' || c2 == '=')) {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        w();
        return false;
    }

    public String g() throws IOException {
        String str;
        int i2 = this.f8900a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 14) {
            str = u();
        } else if (i2 == 12) {
            str = b('\'');
        } else if (i2 == 13) {
            str = b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + f() + s());
        }
        this.f8900a = 0;
        this.o[this.n - 1] = str;
        return str;
    }

    public String h() throws IOException {
        String str;
        int i2 = this.f8900a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 10) {
            str = u();
        } else if (i2 == 8) {
            str = b('\'');
        } else if (i2 == 9) {
            str = b('\"');
        } else if (i2 == 11) {
            str = this.l;
            this.l = null;
        } else if (i2 == 15) {
            str = Long.toString(this.j);
        } else if (i2 == 16) {
            str = new String(this.f8903e, this.f8904f, this.k);
            this.f8904f += this.k;
        } else {
            throw new IllegalStateException("Expected a string but was " + f() + s());
        }
        this.f8900a = 0;
        int[] iArr = this.p;
        int i3 = this.n - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public boolean i() throws IOException {
        int i2 = this.f8900a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 5) {
            this.f8900a = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.f8900a = 0;
            int[] iArr2 = this.p;
            int i4 = this.n - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + f() + s());
        }
    }

    public void j() throws IOException {
        int i2 = this.f8900a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 7) {
            this.f8900a = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + f() + s());
    }

    public double k() throws IOException {
        int i2 = this.f8900a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 15) {
            this.f8900a = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return (double) this.j;
        }
        if (i2 == 16) {
            this.l = new String(this.f8903e, this.f8904f, this.k);
            this.f8904f += this.k;
        } else if (i2 == 8 || i2 == 9) {
            this.l = b(i2 == 8 ? '\'' : '\"');
        } else if (i2 == 10) {
            this.l = u();
        } else if (i2 != 11) {
            throw new IllegalStateException("Expected a double but was " + f() + s());
        }
        this.f8900a = 11;
        double parseDouble = Double.parseDouble(this.l);
        if (this.f8902d || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.l = null;
            this.f8900a = 0;
            int[] iArr2 = this.p;
            int i4 = this.n - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        }
        throw new d("JSON forbids NaN and infinities: " + parseDouble + s());
    }

    public long l() throws IOException {
        int i2 = this.f8900a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 15) {
            this.f8900a = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.j;
        }
        if (i2 == 16) {
            this.l = new String(this.f8903e, this.f8904f, this.k);
            this.f8904f += this.k;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                this.l = u();
            } else {
                this.l = b(i2 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.l);
                this.f8900a = 0;
                int[] iArr2 = this.p;
                int i4 = this.n - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + f() + s());
        }
        this.f8900a = 11;
        double parseDouble = Double.parseDouble(this.l);
        long j2 = (long) parseDouble;
        if (((double) j2) == parseDouble) {
            this.l = null;
            this.f8900a = 0;
            int[] iArr3 = this.p;
            int i5 = this.n - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.l + s());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        if (r1 != null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r4) * 2, 16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006b, code lost:
        r1.append(r0, r4, r2 - r4);
        r9.f8904f = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.f8903e
            r1 = 0
        L_0x0003:
            int r2 = r9.f8904f
            int r3 = r9.f8905g
        L_0x0007:
            r4 = r2
        L_0x0008:
            r5 = 16
            r6 = 1
            if (r2 >= r3) goto L_0x005b
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L_0x0027
            r9.f8904f = r7
            int r7 = r7 - r4
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x001f
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r4, r7)
            return r10
        L_0x001f:
            r1.append(r0, r4, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L_0x0027:
            r8 = 92
            if (r2 != r8) goto L_0x004e
            r9.f8904f = r7
            int r7 = r7 - r4
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x003f
            int r1 = r7 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L_0x003f:
            r1.append(r0, r4, r7)
            char r2 = r9.y()
            r1.append(r2)
            int r2 = r9.f8904f
            int r3 = r9.f8905g
            goto L_0x0007
        L_0x004e:
            r5 = 10
            if (r2 != r5) goto L_0x0059
            int r2 = r9.h
            int r2 = r2 + r6
            r9.h = r2
            r9.i = r7
        L_0x0059:
            r2 = r7
            goto L_0x0008
        L_0x005b:
            if (r1 != 0) goto L_0x006b
            int r1 = r2 - r4
            int r1 = r1 * 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r3.<init>(r1)
            r1 = r3
        L_0x006b:
            int r3 = r2 - r4
            r1.append(r0, r4, r3)
            r9.f8904f = r2
            boolean r2 = r9.b((int) r6)
            if (r2 == 0) goto L_0x0079
            goto L_0x0003
        L_0x0079:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.b((java.lang.String) r10)
            goto L_0x0081
        L_0x0080:
            throw r10
        L_0x0081:
            goto L_0x0080
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.a.b(char):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004b, code lost:
        w();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String u() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            r2 = r1
        L_0x0003:
            r1 = 0
        L_0x0004:
            int r3 = r6.f8904f
            int r4 = r3 + r1
            int r5 = r6.f8905g
            if (r4 >= r5) goto L_0x004f
            char[] r4 = r6.f8903e
            int r3 = r3 + r1
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005d
            r4 = 10
            if (r3 == r4) goto L_0x005d
            r4 = 12
            if (r3 == r4) goto L_0x005d
            r4 = 13
            if (r3 == r4) goto L_0x005d
            r4 = 32
            if (r3 == r4) goto L_0x005d
            r4 = 35
            if (r3 == r4) goto L_0x004b
            r4 = 44
            if (r3 == r4) goto L_0x005d
            r4 = 47
            if (r3 == r4) goto L_0x004b
            r4 = 61
            if (r3 == r4) goto L_0x004b
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005d
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005d
            r4 = 58
            if (r3 == r4) goto L_0x005d
            r4 = 59
            if (r3 == r4) goto L_0x004b
            switch(r3) {
                case 91: goto L_0x005d;
                case 92: goto L_0x004b;
                case 93: goto L_0x005d;
                default: goto L_0x0048;
            }
        L_0x0048:
            int r1 = r1 + 1
            goto L_0x0004
        L_0x004b:
            r6.w()
            goto L_0x005d
        L_0x004f:
            char[] r3 = r6.f8903e
            int r3 = r3.length
            if (r1 >= r3) goto L_0x005f
            int r3 = r1 + 1
            boolean r3 = r6.b((int) r3)
            if (r3 == 0) goto L_0x005d
            goto L_0x0004
        L_0x005d:
            r0 = r1
            goto L_0x007f
        L_0x005f:
            if (r2 != 0) goto L_0x006c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r1, r3)
            r2.<init>(r3)
        L_0x006c:
            char[] r3 = r6.f8903e
            int r4 = r6.f8904f
            r2.append(r3, r4, r1)
            int r3 = r6.f8904f
            int r3 = r3 + r1
            r6.f8904f = r3
            r1 = 1
            boolean r1 = r6.b((int) r1)
            if (r1 != 0) goto L_0x0003
        L_0x007f:
            if (r2 != 0) goto L_0x008b
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f8903e
            int r3 = r6.f8904f
            r1.<init>(r2, r3, r0)
            goto L_0x0096
        L_0x008b:
            char[] r1 = r6.f8903e
            int r3 = r6.f8904f
            r2.append(r1, r3, r0)
            java.lang.String r1 = r2.toString()
        L_0x0096:
            int r2 = r6.f8904f
            int r2 = r2 + r0
            r6.f8904f = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.a.u():java.lang.String");
    }

    private void c(char c2) throws IOException {
        char[] cArr = this.f8903e;
        do {
            int i2 = this.f8904f;
            int i3 = this.f8905g;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f8904f = i4;
                    return;
                } else if (c3 == '\\') {
                    this.f8904f = i4;
                    y();
                    i2 = this.f8904f;
                    i3 = this.f8905g;
                } else {
                    if (c3 == 10) {
                        this.h++;
                        this.i = i4;
                    }
                    i2 = i4;
                }
            }
            this.f8904f = i2;
        } while (b(1));
        throw b("Unterminated string");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        w();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void v() throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            r0 = 0
        L_0x0001:
            int r1 = r4.f8904f
            int r2 = r1 + r0
            int r3 = r4.f8905g
            if (r2 >= r3) goto L_0x0051
            char[] r2 = r4.f8903e
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L_0x004b
            r2 = 10
            if (r1 == r2) goto L_0x004b
            r2 = 12
            if (r1 == r2) goto L_0x004b
            r2 = 13
            if (r1 == r2) goto L_0x004b
            r2 = 32
            if (r1 == r2) goto L_0x004b
            r2 = 35
            if (r1 == r2) goto L_0x0048
            r2 = 44
            if (r1 == r2) goto L_0x004b
            r2 = 47
            if (r1 == r2) goto L_0x0048
            r2 = 61
            if (r1 == r2) goto L_0x0048
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 58
            if (r1 == r2) goto L_0x004b
            r2 = 59
            if (r1 == r2) goto L_0x0048
            switch(r1) {
                case 91: goto L_0x004b;
                case 92: goto L_0x0048;
                case 93: goto L_0x004b;
                default: goto L_0x0045;
            }
        L_0x0045:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0048:
            r4.w()
        L_0x004b:
            int r1 = r4.f8904f
            int r1 = r1 + r0
            r4.f8904f = r1
            return
        L_0x0051:
            int r1 = r1 + r0
            r4.f8904f = r1
            r0 = 1
            boolean r0 = r4.b((int) r0)
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.d.a.v():void");
    }

    public int m() throws IOException {
        int i2 = this.f8900a;
        if (i2 == 0) {
            i2 = r();
        }
        if (i2 == 15) {
            long j2 = this.j;
            int i3 = (int) j2;
            if (j2 == ((long) i3)) {
                this.f8900a = 0;
                int[] iArr = this.p;
                int i4 = this.n - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.j + s());
        }
        if (i2 == 16) {
            this.l = new String(this.f8903e, this.f8904f, this.k);
            this.f8904f += this.k;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                this.l = u();
            } else {
                this.l = b(i2 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.l);
                this.f8900a = 0;
                int[] iArr2 = this.p;
                int i5 = this.n - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + f() + s());
        }
        this.f8900a = 11;
        double parseDouble = Double.parseDouble(this.l);
        int i6 = (int) parseDouble;
        if (((double) i6) == parseDouble) {
            this.l = null;
            this.f8900a = 0;
            int[] iArr3 = this.p;
            int i7 = this.n - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        throw new NumberFormatException("Expected an int but was " + this.l + s());
    }

    public void close() throws IOException {
        this.f8900a = 0;
        this.m[0] = 8;
        this.n = 1;
        this.f8901c.close();
    }

    public void n() throws IOException {
        int i2 = 0;
        do {
            int i3 = this.f8900a;
            if (i3 == 0) {
                i3 = r();
            }
            if (i3 == 3) {
                a(1);
            } else if (i3 == 1) {
                a(3);
            } else {
                if (i3 == 4) {
                    this.n--;
                } else if (i3 == 2) {
                    this.n--;
                } else if (i3 == 14 || i3 == 10) {
                    v();
                    this.f8900a = 0;
                } else if (i3 == 8 || i3 == 12) {
                    c('\'');
                    this.f8900a = 0;
                } else if (i3 == 9 || i3 == 13) {
                    c('\"');
                    this.f8900a = 0;
                } else {
                    if (i3 == 16) {
                        this.f8904f += this.k;
                    }
                    this.f8900a = 0;
                }
                i2--;
                this.f8900a = 0;
            }
            i2++;
            this.f8900a = 0;
        } while (i2 != 0);
        int[] iArr = this.p;
        int i4 = this.n;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.o[i4 - 1] = "null";
    }

    private void a(int i2) {
        int i3 = this.n;
        int[] iArr = this.m;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(i3 * 2)];
            int[] iArr3 = new int[(i3 * 2)];
            String[] strArr = new String[(i3 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.p, 0, iArr3, 0, this.n);
            System.arraycopy(this.o, 0, strArr, 0, this.n);
            this.m = iArr2;
            this.p = iArr3;
            this.o = strArr;
        }
        int[] iArr4 = this.m;
        int i4 = this.n;
        this.n = i4 + 1;
        iArr4[i4] = i2;
    }

    private boolean b(int i2) throws IOException {
        char[] cArr = this.f8903e;
        int i3 = this.i;
        int i4 = this.f8904f;
        this.i = i3 - i4;
        int i5 = this.f8905g;
        if (i5 != i4) {
            this.f8905g = i5 - i4;
            System.arraycopy(cArr, i4, cArr, 0, this.f8905g);
        } else {
            this.f8905g = 0;
        }
        this.f8904f = 0;
        do {
            Reader reader = this.f8901c;
            int i6 = this.f8905g;
            int read = reader.read(cArr, i6, cArr.length - i6);
            if (read == -1) {
                return false;
            }
            this.f8905g += read;
            if (this.h == 0) {
                int i7 = this.i;
                if (i7 == 0 && this.f8905g > 0 && cArr[0] == 65279) {
                    this.f8904f++;
                    this.i = i7 + 1;
                    i2++;
                }
            }
        } while (this.f8905g < i2);
        return true;
    }

    private int b(boolean z) throws IOException {
        char[] cArr = this.f8903e;
        int i2 = this.f8904f;
        int i3 = this.f8905g;
        while (true) {
            if (i2 == i3) {
                this.f8904f = i2;
                if (b(1)) {
                    i2 = this.f8904f;
                    i3 = this.f8905g;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + s());
                }
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == 10) {
                this.h++;
                this.i = i4;
            } else if (!(c2 == ' ' || c2 == 13 || c2 == 9)) {
                if (c2 == '/') {
                    this.f8904f = i4;
                    if (i4 == i3) {
                        this.f8904f--;
                        boolean b2 = b(2);
                        this.f8904f++;
                        if (!b2) {
                            return c2;
                        }
                    }
                    w();
                    int i5 = this.f8904f;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f8904f = i5 + 1;
                        if (a("*/")) {
                            i2 = this.f8904f + 2;
                            i3 = this.f8905g;
                        } else {
                            throw b("Unterminated comment");
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.f8904f = i5 + 1;
                        x();
                        i2 = this.f8904f;
                        i3 = this.f8905g;
                    }
                } else if (c2 == '#') {
                    this.f8904f = i4;
                    w();
                    x();
                    i2 = this.f8904f;
                    i3 = this.f8905g;
                } else {
                    this.f8904f = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    private void w() throws IOException {
        if (!this.f8902d) {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void x() throws IOException {
        char c2;
        do {
            if (this.f8904f < this.f8905g || b(1)) {
                char[] cArr = this.f8903e;
                int i2 = this.f8904f;
                this.f8904f = i2 + 1;
                c2 = cArr[i2];
                if (c2 == 10) {
                    this.h++;
                    this.i = this.f8904f;
                    return;
                }
            } else {
                return;
            }
        } while (c2 != 13);
    }

    private boolean a(String str) throws IOException {
        int length = str.length();
        while (true) {
            int i2 = 0;
            if (this.f8904f + length > this.f8905g && !b(length)) {
                return false;
            }
            char[] cArr = this.f8903e;
            int i3 = this.f8904f;
            if (cArr[i3] == 10) {
                this.h++;
                this.i = i3 + 1;
            } else {
                while (i2 < length) {
                    if (this.f8903e[this.f8904f + i2] == str.charAt(i2)) {
                        i2++;
                    }
                }
                return true;
            }
            this.f8904f++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + s();
    }

    /* access modifiers changed from: package-private */
    public String s() {
        return " at line " + (this.h + 1) + " column " + ((this.f8904f - this.i) + 1) + " path " + p();
    }

    public String p() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = this.n;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.m[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.p[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.o;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    private char y() throws IOException {
        int i2;
        int i3;
        if (this.f8904f != this.f8905g || b(1)) {
            char[] cArr = this.f8903e;
            int i4 = this.f8904f;
            this.f8904f = i4 + 1;
            char c2 = cArr[i4];
            if (c2 == 10) {
                this.h++;
                this.i = this.f8904f;
            } else if (!(c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '\\')) {
                if (c2 == 'b') {
                    return 8;
                }
                if (c2 == 'f') {
                    return 12;
                }
                if (c2 == 'n') {
                    return 10;
                }
                if (c2 == 'r') {
                    return 13;
                }
                if (c2 == 't') {
                    return 9;
                }
                if (c2 != 'u') {
                    throw b("Invalid escape sequence");
                } else if (this.f8904f + 4 <= this.f8905g || b(4)) {
                    char c3 = 0;
                    int i5 = this.f8904f;
                    int i6 = i5 + 4;
                    while (i5 < i6) {
                        char c4 = this.f8903e[i5];
                        char c5 = (char) (c3 << 4);
                        if (c4 < '0' || c4 > '9') {
                            if (c4 >= 'a' && c4 <= 'f') {
                                i2 = c4 - 'a';
                            } else if (c4 < 'A' || c4 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.f8903e, this.f8904f, 4));
                            } else {
                                i2 = c4 - 'A';
                            }
                            i3 = i2 + 10;
                        } else {
                            i3 = c4 - '0';
                        }
                        c3 = (char) (c5 + i3);
                        i5++;
                    }
                    this.f8904f += 4;
                    return c3;
                } else {
                    throw b("Unterminated escape sequence");
                }
            }
            return c2;
        }
        throw b("Unterminated escape sequence");
    }

    private IOException b(String str) throws IOException {
        throw new d(str + s());
    }

    private void z() throws IOException {
        b(true);
        this.f8904f--;
        int i2 = this.f8904f;
        char[] cArr = f8899b;
        if (i2 + cArr.length <= this.f8905g || b(cArr.length)) {
            int i3 = 0;
            while (true) {
                char[] cArr2 = f8899b;
                if (i3 >= cArr2.length) {
                    this.f8904f += cArr2.length;
                    return;
                } else if (this.f8903e[this.f8904f + i3] == cArr2[i3]) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }
}
