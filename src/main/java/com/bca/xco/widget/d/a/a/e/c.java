package com.bca.xco.widget.d.a.a.e;

import com.facebook.imageutils.JfifUtil;
import javax.security.auth.x500.X500Principal;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f4859a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4860b = this.f4859a.length();

    /* renamed from: c  reason: collision with root package name */
    private int f4861c;

    /* renamed from: d  reason: collision with root package name */
    private int f4862d;

    /* renamed from: e  reason: collision with root package name */
    private int f4863e;

    /* renamed from: f  reason: collision with root package name */
    private int f4864f;

    /* renamed from: g  reason: collision with root package name */
    private char[] f4865g;

    public c(X500Principal x500Principal) {
        this.f4859a = x500Principal.getName("RFC2253");
    }

    private String a() {
        while (true) {
            int i = this.f4861c;
            if (i >= this.f4860b || this.f4865g[i] != ' ') {
                int i2 = this.f4861c;
            } else {
                this.f4861c = i + 1;
            }
        }
        int i22 = this.f4861c;
        if (i22 == this.f4860b) {
            return null;
        }
        this.f4862d = i22;
        this.f4861c = i22 + 1;
        while (true) {
            int i3 = this.f4861c;
            if (i3 >= this.f4860b) {
                break;
            }
            char[] cArr = this.f4865g;
            if (cArr[i3] == '=' || cArr[i3] == ' ') {
                break;
            }
            this.f4861c = i3 + 1;
        }
        int i4 = this.f4861c;
        if (i4 < this.f4860b) {
            this.f4863e = i4;
            if (this.f4865g[i4] == ' ') {
                while (true) {
                    int i5 = this.f4861c;
                    if (i5 >= this.f4860b) {
                        break;
                    }
                    char[] cArr2 = this.f4865g;
                    if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                        break;
                    }
                    this.f4861c = i5 + 1;
                }
                char[] cArr3 = this.f4865g;
                int i6 = this.f4861c;
                if (cArr3[i6] != '=' || i6 == this.f4860b) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.f4859a);
                }
            }
            this.f4861c++;
            while (true) {
                int i7 = this.f4861c;
                if (i7 >= this.f4860b || this.f4865g[i7] != ' ') {
                    int i8 = this.f4863e;
                    int i9 = this.f4862d;
                } else {
                    this.f4861c = i7 + 1;
                }
            }
            int i82 = this.f4863e;
            int i92 = this.f4862d;
            if (i82 - i92 > 4) {
                char[] cArr4 = this.f4865g;
                if (cArr4[i92 + 3] == '.' && (cArr4[i92] == 'O' || cArr4[i92] == 'o')) {
                    char[] cArr5 = this.f4865g;
                    int i10 = this.f4862d;
                    if (cArr5[i10 + 1] == 'I' || cArr5[i10 + 1] == 'i') {
                        char[] cArr6 = this.f4865g;
                        int i11 = this.f4862d;
                        if (cArr6[i11 + 2] == 'D' || cArr6[i11 + 2] == 'd') {
                            this.f4862d += 4;
                        }
                    }
                }
            }
            char[] cArr7 = this.f4865g;
            int i12 = this.f4862d;
            return new String(cArr7, i12, this.f4863e - i12);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f4859a);
    }

    private String b() {
        this.f4861c++;
        this.f4862d = this.f4861c;
        this.f4863e = this.f4862d;
        while (true) {
            int i = this.f4861c;
            if (i != this.f4860b) {
                char[] cArr = this.f4865g;
                if (cArr[i] == '\"') {
                    this.f4861c = i + 1;
                    while (true) {
                        int i2 = this.f4861c;
                        if (i2 >= this.f4860b || this.f4865g[i2] != ' ') {
                            char[] cArr2 = this.f4865g;
                            int i3 = this.f4862d;
                        } else {
                            this.f4861c = i2 + 1;
                        }
                    }
                    char[] cArr22 = this.f4865g;
                    int i32 = this.f4862d;
                    return new String(cArr22, i32, this.f4863e - i32);
                }
                if (cArr[i] == '\\') {
                    cArr[this.f4863e] = e();
                } else {
                    cArr[this.f4863e] = cArr[i];
                }
                this.f4861c++;
                this.f4863e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.f4859a);
            }
        }
    }

    private String c() {
        int i = this.f4861c;
        if (i + 4 < this.f4860b) {
            this.f4862d = i;
            this.f4861c = i + 1;
            while (true) {
                int i2 = this.f4861c;
                if (i2 == this.f4860b) {
                    break;
                }
                char[] cArr = this.f4865g;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.f4863e = i2;
                    this.f4861c = i2 + 1;
                    while (true) {
                        int i3 = this.f4861c;
                        if (i3 >= this.f4860b || this.f4865g[i3] != ' ') {
                            break;
                        }
                        this.f4861c = i3 + 1;
                    }
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    this.f4861c++;
                }
            }
            this.f4863e = this.f4861c;
            int i4 = this.f4863e;
            int i5 = this.f4862d;
            int i6 = i4 - i5;
            if (i6 < 5 || (i6 & 1) == 0) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f4859a);
            }
            byte[] bArr = new byte[(i6 / 2)];
            int i7 = i5 + 1;
            for (int i8 = 0; i8 < bArr.length; i8++) {
                bArr[i8] = (byte) a(i7);
                i7 += 2;
            }
            return new String(this.f4865g, this.f4862d, i6);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f4859a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
        r1 = r8.f4865g;
        r2 = r8.f4862d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a7, code lost:
        return new java.lang.String(r1, r2, r8.f4864f - r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String d() {
        /*
            r8 = this;
            int r0 = r8.f4861c
            r8.f4862d = r0
            r8.f4863e = r0
        L_0x0006:
            int r0 = r8.f4861c
            int r1 = r8.f4860b
            if (r0 < r1) goto L_0x0019
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f4865g
            int r2 = r8.f4862d
            int r3 = r8.f4863e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0019:
            char[] r1 = r8.f4865g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L_0x0060
            if (r2 == r5) goto L_0x0053
            r5 = 92
            if (r2 == r5) goto L_0x0040
            if (r2 == r4) goto L_0x0053
            if (r2 == r3) goto L_0x0053
            int r2 = r8.f4863e
            int r3 = r2 + 1
            r8.f4863e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f4861c = r0
            goto L_0x0006
        L_0x0040:
            int r0 = r8.f4863e
            int r2 = r0 + 1
            r8.f4863e = r2
            char r2 = r8.e()
            r1[r0] = r2
            int r0 = r8.f4861c
            int r0 = r0 + 1
            r8.f4861c = r0
            goto L_0x0006
        L_0x0053:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f4865g
            int r2 = r8.f4862d
            int r3 = r8.f4863e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0060:
            int r2 = r8.f4863e
            r8.f4864f = r2
            int r0 = r0 + 1
            r8.f4861c = r0
            int r0 = r2 + 1
            r8.f4863e = r0
            r1[r2] = r6
        L_0x006e:
            int r0 = r8.f4861c
            int r1 = r8.f4860b
            if (r0 >= r1) goto L_0x0087
            char[] r1 = r8.f4865g
            char r2 = r1[r0]
            if (r2 != r6) goto L_0x0087
            int r2 = r8.f4863e
            int r7 = r2 + 1
            r8.f4863e = r7
            r1[r2] = r6
            int r0 = r0 + 1
            r8.f4861c = r0
            goto L_0x006e
        L_0x0087:
            int r0 = r8.f4861c
            int r1 = r8.f4860b
            if (r0 == r1) goto L_0x009b
            char[] r1 = r8.f4865g
            char r2 = r1[r0]
            if (r2 == r3) goto L_0x009b
            char r2 = r1[r0]
            if (r2 == r4) goto L_0x009b
            char r0 = r1[r0]
            if (r0 != r5) goto L_0x0006
        L_0x009b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f4865g
            int r2 = r8.f4862d
            int r3 = r8.f4864f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.a.a.e.c.d():java.lang.String");
    }

    private char e() {
        this.f4861c++;
        int i = this.f4861c;
        if (i != this.f4860b) {
            char c2 = this.f4865g[i];
            if (!(c2 == ' ' || c2 == '%' || c2 == '\\' || c2 == '_' || c2 == '\"' || c2 == '#')) {
                switch (c2) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c2) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                return f();
                        }
                }
            }
            return this.f4865g[this.f4861c];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.f4859a);
    }

    private char f() {
        int i;
        int i2;
        int a2 = a(this.f4861c);
        this.f4861c++;
        if (a2 < 128) {
            return (char) a2;
        }
        if (a2 < 192 || a2 > 247) {
            return '?';
        }
        if (a2 <= 223) {
            i2 = a2 & 31;
            i = 1;
        } else if (a2 <= 239) {
            i = 2;
            i2 = a2 & 15;
        } else {
            i = 3;
            i2 = a2 & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.f4861c++;
            int i4 = this.f4861c;
            if (i4 == this.f4860b || this.f4865g[i4] != '\\') {
                return '?';
            }
            this.f4861c = i4 + 1;
            int a3 = a(this.f4861c);
            this.f4861c++;
            if ((a3 & JfifUtil.MARKER_SOFn) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a3 & 63);
        }
        return (char) i2;
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.f4860b) {
            char c2 = this.f4865g[i];
            if (c2 >= '0' && c2 <= '9') {
                i2 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i2 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f4859a);
            } else {
                i2 = c2 - '7';
            }
            char c3 = this.f4865g[i4];
            if (c3 >= '0' && c3 <= '9') {
                i3 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i3 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f4859a);
            } else {
                i3 = c3 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.f4859a);
    }

    public String a(String str) {
        String str2;
        this.f4861c = 0;
        this.f4862d = 0;
        this.f4863e = 0;
        this.f4864f = 0;
        this.f4865g = this.f4859a.toCharArray();
        String a2 = a();
        if (a2 == null) {
            return null;
        }
        do {
            int i = this.f4861c;
            if (i == this.f4860b) {
                return null;
            }
            char c2 = this.f4865g[i];
            if (c2 != '\"') {
                str2 = c2 != '#' ? (c2 == '+' || c2 == ',' || c2 == ';') ? "" : d() : c();
            } else {
                str2 = b();
            }
            if (str.equalsIgnoreCase(a2)) {
                return str2;
            }
            int i2 = this.f4861c;
            if (i2 >= this.f4860b) {
                return null;
            }
            char[] cArr = this.f4865g;
            if (cArr[i2] == ',' || cArr[i2] == ';' || cArr[i2] == '+') {
                this.f4861c++;
                a2 = a();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.f4859a);
            }
        } while (a2 != null);
        throw new IllegalStateException("Malformed DN: " + this.f4859a);
    }
}
