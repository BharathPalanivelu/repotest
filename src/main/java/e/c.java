package e;

import com.facebook.common.time.Clock;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.NativeProtocol;
import com.g.a.a.g;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.path.android.jobqueue.JobManager;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c implements d, e, Cloneable, ByteChannel {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f32723c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a  reason: collision with root package name */
    r f32724a;

    /* renamed from: b  reason: collision with root package name */
    long f32725b;

    public c b() {
        return this;
    }

    public void close() {
    }

    /* renamed from: d */
    public c A() {
        return this;
    }

    public d e() {
        return this;
    }

    public void flush() {
    }

    public boolean isOpen() {
        return true;
    }

    public final long a() {
        return this.f32725b;
    }

    public OutputStream c() {
        return new OutputStream() {
            public void close() {
            }

            public void flush() {
            }

            public void write(int i) {
                c.this.k((int) (byte) i);
            }

            public void write(byte[] bArr, int i, int i2) {
                c.this.c(bArr, i, i2);
            }

            public String toString() {
                return c.this + ".outputStream()";
            }
        };
    }

    public boolean f() {
        return this.f32725b == 0;
    }

    public void a(long j) throws EOFException {
        if (this.f32725b < j) {
            throw new EOFException();
        }
    }

    public boolean b(long j) {
        return this.f32725b >= j;
    }

    public InputStream g() {
        return new InputStream() {
            public void close() {
            }

            public int read() {
                if (c.this.f32725b > 0) {
                    return c.this.i() & 255;
                }
                return -1;
            }

            public int read(byte[] bArr, int i, int i2) {
                return c.this.a(bArr, i, i2);
            }

            public int available() {
                return (int) Math.min(c.this.f32725b, 2147483647L);
            }

            public String toString() {
                return c.this + ".inputStream()";
            }
        };
    }

    public final c a(c cVar, long j, long j2) {
        if (cVar != null) {
            x.a(this.f32725b, j, j2);
            if (j2 == 0) {
                return this;
            }
            cVar.f32725b += j2;
            r rVar = this.f32724a;
            while (j >= ((long) (rVar.f32783c - rVar.f32782b))) {
                j -= (long) (rVar.f32783c - rVar.f32782b);
                rVar = rVar.f32786f;
            }
            while (j2 > 0) {
                r a2 = rVar.a();
                a2.f32782b = (int) (((long) a2.f32782b) + j);
                a2.f32783c = Math.min(a2.f32782b + ((int) j2), a2.f32783c);
                r rVar2 = cVar.f32724a;
                if (rVar2 == null) {
                    a2.f32787g = a2;
                    a2.f32786f = a2;
                    cVar.f32724a = a2;
                } else {
                    rVar2.f32787g.a(a2);
                }
                j2 -= (long) (a2.f32783c - a2.f32782b);
                rVar = rVar.f32786f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final long h() {
        long j = this.f32725b;
        if (j == 0) {
            return 0;
        }
        r rVar = this.f32724a.f32787g;
        return (rVar.f32783c >= 8192 || !rVar.f32785e) ? j : j - ((long) (rVar.f32783c - rVar.f32782b));
    }

    public byte i() {
        if (this.f32725b != 0) {
            r rVar = this.f32724a;
            int i = rVar.f32782b;
            int i2 = rVar.f32783c;
            int i3 = i + 1;
            byte b2 = rVar.f32781a[i];
            this.f32725b--;
            if (i3 == i2) {
                this.f32724a = rVar.c();
                s.a(rVar);
            } else {
                rVar.f32782b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public final byte c(long j) {
        x.a(this.f32725b, j, 1);
        long j2 = this.f32725b;
        if (j2 - j > j) {
            r rVar = this.f32724a;
            while (true) {
                long j3 = (long) (rVar.f32783c - rVar.f32782b);
                if (j < j3) {
                    return rVar.f32781a[rVar.f32782b + ((int) j)];
                }
                j -= j3;
                rVar = rVar.f32786f;
            }
        } else {
            long j4 = j - j2;
            r rVar2 = this.f32724a;
            do {
                rVar2 = rVar2.f32787g;
                j4 += (long) (rVar2.f32783c - rVar2.f32782b);
            } while (j4 < 0);
            return rVar2.f32781a[rVar2.f32782b + ((int) j4)];
        }
    }

    public short j() {
        if (this.f32725b >= 2) {
            r rVar = this.f32724a;
            int i = rVar.f32782b;
            int i2 = rVar.f32783c;
            if (i2 - i < 2) {
                return (short) (((i() & 255) << 8) | (i() & 255));
            }
            byte[] bArr = rVar.f32781a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b2 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.f32725b -= 2;
            if (i4 == i2) {
                this.f32724a = rVar.c();
                s.a(rVar);
            } else {
                rVar.f32782b = i4;
            }
            return (short) b2;
        }
        throw new IllegalStateException("size < 2: " + this.f32725b);
    }

    public int k() {
        if (this.f32725b >= 4) {
            r rVar = this.f32724a;
            int i = rVar.f32782b;
            int i2 = rVar.f32783c;
            if (i2 - i < 4) {
                return ((i() & 255) << 24) | ((i() & 255) << 16) | ((i() & 255) << 8) | (i() & 255);
            }
            byte[] bArr = rVar.f32781a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b2 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i5 = i4 + 1;
            byte b3 = b2 | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b4 = b3 | (bArr[i5] & 255);
            this.f32725b -= 4;
            if (i6 == i2) {
                this.f32724a = rVar.c();
                s.a(rVar);
            } else {
                rVar.f32782b = i6;
            }
            return b4;
        }
        throw new IllegalStateException("size < 4: " + this.f32725b);
    }

    public long l() {
        if (this.f32725b >= 8) {
            r rVar = this.f32724a;
            int i = rVar.f32782b;
            int i2 = rVar.f32783c;
            if (i2 - i < 8) {
                return ((((long) k()) & 4294967295L) << 32) | (4294967295L & ((long) k()));
            }
            byte[] bArr = rVar.f32781a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j2 = (((long) bArr[i9]) & 255) | ((((long) bArr[i8]) & 255) << 8) | j;
            this.f32725b -= 8;
            if (i10 == i2) {
                this.f32724a = rVar.c();
                s.a(rVar);
            } else {
                rVar.f32782b = i10;
            }
            return j2;
        }
        throw new IllegalStateException("size < 8: " + this.f32725b);
    }

    public short m() {
        return x.a(j());
    }

    public int n() {
        return x.a(k());
    }

    public long o() {
        return x.a(l());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        if (r5 != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        r1.i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006b, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r1.s());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long p() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.f32725b
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00b9
            r5 = -7
            r7 = 0
            r8 = r5
            r5 = 0
            r6 = 0
        L_0x0010:
            e.r r10 = r0.f32724a
            byte[] r11 = r10.f32781a
            int r12 = r10.f32782b
            int r13 = r10.f32783c
        L_0x0018:
            if (r12 >= r13) goto L_0x009a
            byte r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L_0x006c
            r1 = 57
            if (r15 > r1) goto L_0x006c
            int r14 = r14 - r15
            r1 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 < 0) goto L_0x003f
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 != 0) goto L_0x0038
            long r1 = (long) r14
            int r16 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r16 >= 0) goto L_0x0038
            goto L_0x003f
        L_0x0038:
            r1 = 10
            long r3 = r3 * r1
            long r1 = (long) r14
            long r3 = r3 + r1
            goto L_0x0076
        L_0x003f:
            e.c r1 = new e.c
            r1.<init>()
            e.c r1 = r1.o(r3)
            e.c r1 = r1.k((int) r15)
            if (r5 != 0) goto L_0x0051
            r1.i()
        L_0x0051:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.s()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x006c:
            r1 = 45
            if (r15 != r1) goto L_0x007b
            if (r7 != 0) goto L_0x007b
            r1 = 1
            long r8 = r8 - r1
            r5 = 1
        L_0x0076:
            int r12 = r12 + 1
            int r7 = r7 + 1
            goto L_0x0018
        L_0x007b:
            if (r7 == 0) goto L_0x007f
            r6 = 1
            goto L_0x009a
        L_0x007f:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r15)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x009a:
            if (r12 != r13) goto L_0x00a6
            e.r r1 = r10.c()
            r0.f32724a = r1
            e.s.a(r10)
            goto L_0x00a8
        L_0x00a6:
            r10.f32782b = r12
        L_0x00a8:
            if (r6 != 0) goto L_0x00ae
            e.r r1 = r0.f32724a
            if (r1 != 0) goto L_0x0010
        L_0x00ae:
            long r1 = r0.f32725b
            long r6 = (long) r7
            long r1 = r1 - r6
            r0.f32725b = r1
            if (r5 == 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            long r3 = -r3
        L_0x00b8:
            return r3
        L_0x00b9:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            goto L_0x00c2
        L_0x00c1:
            throw r1
        L_0x00c2:
            goto L_0x00c1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.p():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r8 != r9) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        r15.f32724a = r6.c();
        e.s.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
        r6.f32782b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009f, code lost:
        if (r0 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0076 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long q() {
        /*
            r15 = this;
            long r0 = r15.f32725b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00ac
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000b:
            e.r r6 = r15.f32724a
            byte[] r7 = r6.f32781a
            int r8 = r6.f32782b
            int r9 = r6.f32783c
        L_0x0013:
            if (r8 >= r9) goto L_0x0091
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x003a
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002f
            int r11 = r10 + -97
        L_0x002c:
            int r11 = r11 + 10
            goto L_0x003a
        L_0x002f:
            r11 = 65
            if (r10 < r11) goto L_0x0072
            r11 = 70
            if (r10 > r11) goto L_0x0072
            int r11 = r10 + -65
            goto L_0x002c
        L_0x003a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L_0x0013
        L_0x004a:
            e.c r0 = new e.c
            r0.<init>()
            e.c r0 = r0.n(r4)
            e.c r0 = r0.k((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.s()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0072:
            if (r1 == 0) goto L_0x0076
            r0 = 1
            goto L_0x0091
        L_0x0076:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0091:
            if (r8 != r9) goto L_0x009d
            e.r r7 = r6.c()
            r15.f32724a = r7
            e.s.a(r6)
            goto L_0x009f
        L_0x009d:
            r6.f32782b = r8
        L_0x009f:
            if (r0 != 0) goto L_0x00a5
            e.r r6 = r15.f32724a
            if (r6 != 0) goto L_0x000b
        L_0x00a5:
            long r2 = r15.f32725b
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f32725b = r2
            return r4
        L_0x00ac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto L_0x00b5
        L_0x00b4:
            throw r0
        L_0x00b5:
            goto L_0x00b4
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.q():long");
    }

    public f r() {
        return new f(v());
    }

    public f d(long j) throws EOFException {
        return new f(h(j));
    }

    public void a(c cVar, long j) throws EOFException {
        long j2 = this.f32725b;
        if (j2 >= j) {
            cVar.write(this, j);
        } else {
            cVar.write(this, j2);
            throw new EOFException();
        }
    }

    public long a(u uVar) throws IOException {
        long j = this.f32725b;
        if (j > 0) {
            uVar.write(this, j);
        }
        return j;
    }

    public String s() {
        try {
            return a(this.f32725b, x.f32792a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String e(long j) throws EOFException {
        return a(j, x.f32792a);
    }

    public String a(Charset charset) {
        try {
            return a(this.f32725b, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String a(long j, Charset charset) throws EOFException {
        x.a(this.f32725b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            r rVar = this.f32724a;
            if (((long) rVar.f32782b) + j > ((long) rVar.f32783c)) {
                return new String(h(j), charset);
            }
            String str = new String(rVar.f32781a, rVar.f32782b, (int) j, charset);
            rVar.f32782b = (int) (((long) rVar.f32782b) + j);
            this.f32725b -= j;
            if (rVar.f32782b == rVar.f32783c) {
                this.f32724a = rVar.c();
                s.a(rVar);
            }
            return str;
        }
    }

    public String t() throws EOFException {
        return f((long) Clock.MAX_TIME);
    }

    public String f(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Clock.MAX_TIME;
            if (j != Clock.MAX_TIME) {
                j2 = j + 1;
            }
            long a2 = a((byte) 10, 0, j2);
            if (a2 != -1) {
                return g(a2);
            }
            if (j2 < a() && c(j2 - 1) == 13 && c(j2) == 10) {
                return g(j2);
            }
            c cVar = new c();
            a(cVar, 0, Math.min(32, a()));
            throw new EOFException("\\n not found: limit=" + Math.min(a(), j) + " content=" + cVar.r().f() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    /* access modifiers changed from: package-private */
    public String g(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (c(j2) == 13) {
                String e2 = e(j2);
                i(2);
                return e2;
            }
        }
        String e3 = e(j);
        i(1);
        return e3;
    }

    public int u() throws EOFException {
        byte b2;
        int i;
        byte b3;
        if (this.f32725b != 0) {
            byte c2 = c(0);
            int i2 = 1;
            if ((c2 & 128) == 0) {
                b3 = c2 & Byte.MAX_VALUE;
                i = 1;
                b2 = 0;
            } else if ((c2 & 224) == 192) {
                b3 = c2 & 31;
                i = 2;
                b2 = 128;
            } else if ((c2 & 240) == 224) {
                b3 = c2 & 15;
                i = 3;
                b2 = g.BYTE;
            } else if ((c2 & 248) == 240) {
                b3 = c2 & 7;
                i = 4;
                b2 = g.BYTE;
            } else {
                i(1);
                return 65533;
            }
            long j = (long) i;
            if (this.f32725b >= j) {
                while (i2 < i) {
                    long j2 = (long) i2;
                    byte c3 = c(j2);
                    if ((c3 & 192) == 128) {
                        b3 = (b3 << 6) | (c3 & 63);
                        i2++;
                    } else {
                        i(j2);
                        return 65533;
                    }
                }
                i(j);
                if (b3 > 1114111) {
                    return 65533;
                }
                if ((b3 < 55296 || b3 > 57343) && b3 >= b2) {
                    return b3;
                }
                return 65533;
            }
            throw new EOFException("size < " + i + ": " + this.f32725b + " (to read code point prefixed 0x" + Integer.toHexString(c2) + SQLBuilder.PARENTHESES_RIGHT);
        }
        throw new EOFException();
    }

    public byte[] v() {
        try {
            return h(this.f32725b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public byte[] h(long j) throws EOFException {
        x.a(this.f32725b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int a2 = a(bArr, i, bArr.length - i);
            if (a2 != -1) {
                i += a2;
            } else {
                throw new EOFException();
            }
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        x.a((long) bArr.length, (long) i, (long) i2);
        r rVar = this.f32724a;
        if (rVar == null) {
            return -1;
        }
        int min = Math.min(i2, rVar.f32783c - rVar.f32782b);
        System.arraycopy(rVar.f32781a, rVar.f32782b, bArr, i, min);
        rVar.f32782b += min;
        this.f32725b -= (long) min;
        if (rVar.f32782b == rVar.f32783c) {
            this.f32724a = rVar.c();
            s.a(rVar);
        }
        return min;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        r rVar = this.f32724a;
        if (rVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), rVar.f32783c - rVar.f32782b);
        byteBuffer.put(rVar.f32781a, rVar.f32782b, min);
        rVar.f32782b += min;
        this.f32725b -= (long) min;
        if (rVar.f32782b == rVar.f32783c) {
            this.f32724a = rVar.c();
            s.a(rVar);
        }
        return min;
    }

    public final void w() {
        try {
            i(this.f32725b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public void i(long j) throws EOFException {
        while (j > 0) {
            r rVar = this.f32724a;
            if (rVar != null) {
                int min = (int) Math.min(j, (long) (rVar.f32783c - this.f32724a.f32782b));
                long j2 = (long) min;
                this.f32725b -= j2;
                j -= j2;
                this.f32724a.f32782b += min;
                if (this.f32724a.f32782b == this.f32724a.f32783c) {
                    r rVar2 = this.f32724a;
                    this.f32724a = rVar2.c();
                    s.a(rVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    /* renamed from: a */
    public c d(f fVar) {
        if (fVar != null) {
            fVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: a */
    public c b(String str) {
        return a(str, 0, str.length());
    }

    public c a(String str, int i, int i2) {
        char c2;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    r f2 = f(1);
                    byte[] bArr = f2.f32781a;
                    int i3 = f2.f32783c - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt;
                    while (i4 < min) {
                        char charAt2 = str.charAt(i4);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i4 + i3] = (byte) charAt2;
                        i4++;
                    }
                    int i5 = (i3 + i4) - f2.f32783c;
                    f2.f32783c += i5;
                    this.f32725b += (long) i5;
                    i = i4;
                } else {
                    if (charAt < 2048) {
                        k((charAt >> 6) | JfifUtil.MARKER_SOFn);
                        k((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        k((charAt >> 12) | 224);
                        k(((charAt >> 6) & 63) | 128);
                        k((int) (charAt & '?') | 128);
                    } else {
                        int i6 = i + 1;
                        if (i6 < i2) {
                            c2 = str.charAt(i6);
                        } else {
                            c2 = 0;
                        }
                        if (charAt > 56319 || c2 < 56320 || c2 > 57343) {
                            k(63);
                            i = i6;
                        } else {
                            int i7 = (((charAt & 10239) << 10) | (9215 & c2)) + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                            k((i7 >> 18) | 240);
                            k(((i7 >> 12) & 63) | 128);
                            k(((i7 >> 6) & 63) | 128);
                            k((i7 & 63) | 128);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
    }

    public c a(int i) {
        if (i < 128) {
            k(i);
        } else if (i < 2048) {
            k((i >> 6) | JfifUtil.MARKER_SOFn);
            k((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                k((i >> 12) | 224);
                k(((i >> 6) & 63) | 128);
                k((i & 63) | 128);
            } else {
                k(63);
            }
        } else if (i <= 1114111) {
            k((i >> 18) | 240);
            k(((i >> 12) & 63) | 128);
            k(((i >> 6) & 63) | 128);
            k((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public c a(String str, Charset charset) {
        return a(str, 0, str.length(), charset);
    }

    public c a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(x.f32792a)) {
            return a(str, i, i2);
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            return c(bytes, 0, bytes.length);
        }
    }

    /* renamed from: b */
    public c c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: b */
    public c c(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            x.a((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                r f2 = f(1);
                int min = Math.min(i3 - i, 8192 - f2.f32783c);
                System.arraycopy(bArr, i, f2.f32781a, f2.f32783c, min);
                i += min;
                f2.f32783c += min;
            }
            this.f32725b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                r f2 = f(1);
                int min = Math.min(i, 8192 - f2.f32783c);
                byteBuffer.get(f2.f32781a, f2.f32783c, min);
                i -= min;
                f2.f32783c += min;
            }
            this.f32725b += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long a(v vVar) throws IOException {
        if (vVar != null) {
            long j = 0;
            while (true) {
                long read = vVar.read(this, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER);
                if (read == -1) {
                    return j;
                }
                j += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public d a(v vVar, long j) throws IOException {
        while (j > 0) {
            long read = vVar.read(this, j);
            if (read != -1) {
                j -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    /* renamed from: b */
    public c k(int i) {
        r f2 = f(1);
        byte[] bArr = f2.f32781a;
        int i2 = f2.f32783c;
        f2.f32783c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f32725b++;
        return this;
    }

    /* renamed from: c */
    public c j(int i) {
        r f2 = f(2);
        byte[] bArr = f2.f32781a;
        int i2 = f2.f32783c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        f2.f32783c = i3 + 1;
        this.f32725b += 2;
        return this;
    }

    /* renamed from: d */
    public c i(int i) {
        r f2 = f(4);
        byte[] bArr = f2.f32781a;
        int i2 = f2.f32783c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        f2.f32783c = i5 + 1;
        this.f32725b += 4;
        return this;
    }

    /* renamed from: e */
    public c h(int i) {
        return i(x.a(i));
    }

    public c j(long j) {
        r f2 = f(8);
        byte[] bArr = f2.f32781a;
        int i = f2.f32783c;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        f2.f32783c = i8 + 1;
        this.f32725b += 8;
        return this;
    }

    /* renamed from: k */
    public c p(long j) {
        return j(x.a(j));
    }

    /* renamed from: l */
    public c o(long j) {
        if (j == 0) {
            return k(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < JobManager.NS_PER_MS ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        r f2 = f(i);
        byte[] bArr = f2.f32781a;
        int i2 = f2.f32783c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = f32723c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        f2.f32783c += i;
        this.f32725b += (long) i;
        return this;
    }

    /* renamed from: m */
    public c n(long j) {
        if (j == 0) {
            return k(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        r f2 = f(numberOfTrailingZeros);
        byte[] bArr = f2.f32781a;
        int i = f2.f32783c;
        for (int i2 = (f2.f32783c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f32723c[(int) (15 & j)];
            j >>>= 4;
        }
        f2.f32783c += numberOfTrailingZeros;
        this.f32725b += (long) numberOfTrailingZeros;
        return this;
    }

    /* access modifiers changed from: package-private */
    public r f(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        r rVar = this.f32724a;
        if (rVar == null) {
            this.f32724a = s.a();
            r rVar2 = this.f32724a;
            rVar2.f32787g = rVar2;
            rVar2.f32786f = rVar2;
            return rVar2;
        }
        r rVar3 = rVar.f32787g;
        return (rVar3.f32783c + i > 8192 || !rVar3.f32785e) ? rVar3.a(s.a()) : rVar3;
    }

    public void write(c cVar, long j) {
        int i;
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (cVar != this) {
            x.a(cVar.f32725b, 0, j);
            while (j > 0) {
                if (j < ((long) (cVar.f32724a.f32783c - cVar.f32724a.f32782b))) {
                    r rVar = this.f32724a;
                    r rVar2 = rVar != null ? rVar.f32787g : null;
                    if (rVar2 != null && rVar2.f32785e) {
                        long j2 = ((long) rVar2.f32783c) + j;
                        if (rVar2.f32784d) {
                            i = 0;
                        } else {
                            i = rVar2.f32782b;
                        }
                        if (j2 - ((long) i) <= IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) {
                            cVar.f32724a.a(rVar2, (int) j);
                            cVar.f32725b -= j;
                            this.f32725b += j;
                            return;
                        }
                    }
                    cVar.f32724a = cVar.f32724a.a((int) j);
                }
                r rVar3 = cVar.f32724a;
                long j3 = (long) (rVar3.f32783c - rVar3.f32782b);
                cVar.f32724a = rVar3.c();
                r rVar4 = this.f32724a;
                if (rVar4 == null) {
                    this.f32724a = rVar3;
                    r rVar5 = this.f32724a;
                    rVar5.f32787g = rVar5;
                    rVar5.f32786f = rVar5;
                } else {
                    rVar4.f32787g.a(rVar3).d();
                }
                cVar.f32725b -= j3;
                this.f32725b += j3;
                j -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public long read(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.f32725b;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            cVar.write(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    public long a(byte b2) {
        return a(b2, 0, (long) Clock.MAX_TIME);
    }

    public long a(byte b2, long j, long j2) {
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f32725b), Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j4 = this.f32725b;
        if (j2 <= j4) {
            j4 = j2;
        }
        if (j == j4) {
            return -1;
        }
        r rVar = this.f32724a;
        if (rVar == null) {
            return -1;
        }
        long j5 = this.f32725b;
        if (j5 - j >= j) {
            while (true) {
                j5 = j3;
                j3 = ((long) (rVar.f32783c - rVar.f32782b)) + j5;
                if (j3 >= j) {
                    break;
                }
                rVar = rVar.f32786f;
            }
        } else {
            while (j5 > j) {
                rVar = rVar.f32787g;
                j5 -= (long) (rVar.f32783c - rVar.f32782b);
            }
        }
        long j6 = j;
        while (j5 < j4) {
            byte[] bArr = rVar.f32781a;
            int min = (int) Math.min((long) rVar.f32783c, (((long) rVar.f32782b) + j4) - j5);
            for (int i = (int) ((((long) rVar.f32782b) + j6) - j5); i < min; i++) {
                if (bArr[i] == b2) {
                    return ((long) (i - rVar.f32782b)) + j5;
                }
            }
            byte b3 = b2;
            j6 = ((long) (rVar.f32783c - rVar.f32782b)) + j5;
            rVar = rVar.f32786f;
            j5 = j6;
        }
        return -1;
    }

    public long b(f fVar) throws IOException {
        return a(fVar, 0);
    }

    public long a(f fVar, long j) throws IOException {
        byte[] bArr;
        r rVar;
        if (fVar.h() != 0) {
            long j2 = 0;
            if (j >= 0) {
                r rVar2 = this.f32724a;
                long j3 = -1;
                if (rVar2 == null) {
                    return -1;
                }
                long j4 = this.f32725b;
                if (j4 - j >= j) {
                    while (true) {
                        j4 = j2;
                        j2 = ((long) (rVar2.f32783c - rVar2.f32782b)) + j4;
                        if (j2 >= j) {
                            break;
                        }
                        rVar2 = rVar2.f32786f;
                    }
                } else {
                    while (j4 > j) {
                        rVar2 = rVar2.f32787g;
                        j4 -= (long) (rVar2.f32783c - rVar2.f32782b);
                    }
                }
                byte a2 = fVar.a(0);
                int h = fVar.h();
                long j5 = 1 + (this.f32725b - ((long) h));
                long j6 = j;
                r rVar3 = rVar2;
                long j7 = j4;
                while (j7 < j5) {
                    byte[] bArr2 = rVar3.f32781a;
                    int min = (int) Math.min((long) rVar3.f32783c, (((long) rVar3.f32782b) + j5) - j7);
                    int i = (int) ((((long) rVar3.f32782b) + j6) - j7);
                    while (i < min) {
                        if (bArr2[i] == a2) {
                            bArr = bArr2;
                            rVar = rVar3;
                            if (a(rVar3, i + 1, fVar, 1, h)) {
                                return ((long) (i - rVar.f32782b)) + j7;
                            }
                        } else {
                            bArr = bArr2;
                            rVar = rVar3;
                        }
                        i++;
                        rVar3 = rVar;
                        bArr2 = bArr;
                    }
                    r rVar4 = rVar3;
                    j6 = ((long) (rVar4.f32783c - rVar4.f32782b)) + j7;
                    rVar3 = rVar4.f32786f;
                    j3 = -1;
                    j7 = j6;
                }
                return j3;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    public long c(f fVar) {
        return b(fVar, 0);
    }

    public long b(f fVar, long j) {
        int i;
        int i2;
        long j2 = 0;
        if (j >= 0) {
            r rVar = this.f32724a;
            if (rVar == null) {
                return -1;
            }
            long j3 = this.f32725b;
            if (j3 - j >= j) {
                while (true) {
                    j3 = j2;
                    j2 = ((long) (rVar.f32783c - rVar.f32782b)) + j3;
                    if (j2 >= j) {
                        break;
                    }
                    rVar = rVar.f32786f;
                }
            } else {
                while (j3 > j) {
                    rVar = rVar.f32787g;
                    j3 -= (long) (rVar.f32783c - rVar.f32782b);
                }
            }
            if (fVar.h() == 2) {
                byte a2 = fVar.a(0);
                byte a3 = fVar.a(1);
                while (j3 < this.f32725b) {
                    byte[] bArr = rVar.f32781a;
                    i = (int) ((((long) rVar.f32782b) + j) - j3);
                    int i3 = rVar.f32783c;
                    while (i < i3) {
                        byte b2 = bArr[i];
                        if (b2 == a2 || b2 == a3) {
                            i2 = rVar.f32782b;
                        } else {
                            i++;
                        }
                    }
                    j = ((long) (rVar.f32783c - rVar.f32782b)) + j3;
                    rVar = rVar.f32786f;
                    j3 = j;
                }
                return -1;
            }
            byte[] j4 = fVar.j();
            while (j3 < this.f32725b) {
                byte[] bArr2 = rVar.f32781a;
                int i4 = (int) ((((long) rVar.f32782b) + j) - j3);
                int i5 = rVar.f32783c;
                while (i < i5) {
                    byte b3 = bArr2[i];
                    int length = j4.length;
                    int i6 = 0;
                    while (i6 < length) {
                        if (b3 == j4[i6]) {
                            i2 = rVar.f32782b;
                        } else {
                            i6++;
                        }
                    }
                    i4 = i + 1;
                }
                j = ((long) (rVar.f32783c - rVar.f32782b)) + j3;
                rVar = rVar.f32786f;
                j3 = j;
            }
            return -1;
            return ((long) (i - i2)) + j3;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    public boolean a(long j, f fVar) {
        return a(j, fVar, 0, fVar.h());
    }

    public boolean a(long j, f fVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f32725b - j < ((long) i2) || fVar.h() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (c(((long) i3) + j) != fVar.a(i + i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean a(r rVar, int i, f fVar, int i2, int i3) {
        int i4 = rVar.f32783c;
        byte[] bArr = rVar.f32781a;
        while (i2 < i3) {
            if (i == i4) {
                rVar = rVar.f32786f;
                byte[] bArr2 = rVar.f32781a;
                int i5 = rVar.f32782b;
                bArr = bArr2;
                i = i5;
                i4 = rVar.f32783c;
            }
            if (bArr[i] != fVar.a(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public w timeout() {
        return w.NONE;
    }

    public final f x() {
        return c(Hash.ALGORITHM_MD5);
    }

    private f c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            if (this.f32724a != null) {
                instance.update(this.f32724a.f32781a, this.f32724a.f32782b, this.f32724a.f32783c - this.f32724a.f32782b);
                r rVar = this.f32724a;
                while (true) {
                    rVar = rVar.f32786f;
                    if (rVar == this.f32724a) {
                        break;
                    }
                    instance.update(rVar.f32781a, rVar.f32782b, rVar.f32783c - rVar.f32782b);
                }
            }
            return f.a(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j = this.f32725b;
        if (j != cVar.f32725b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        r rVar = this.f32724a;
        r rVar2 = cVar.f32724a;
        int i = rVar.f32782b;
        int i2 = rVar2.f32782b;
        while (j2 < this.f32725b) {
            long min = (long) Math.min(rVar.f32783c - i, rVar2.f32783c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (rVar.f32781a[i4] != rVar2.f32781a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == rVar.f32783c) {
                rVar = rVar.f32786f;
                i = rVar.f32782b;
            } else {
                i = i4;
            }
            if (i3 == rVar2.f32783c) {
                rVar2 = rVar2.f32786f;
                i2 = rVar2.f32782b;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    public int hashCode() {
        r rVar = this.f32724a;
        if (rVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = rVar.f32783c;
            for (int i3 = rVar.f32782b; i3 < i2; i3++) {
                i = (i * 31) + rVar.f32781a[i3];
            }
            rVar = rVar.f32786f;
        } while (rVar != this.f32724a);
        return i;
    }

    public String toString() {
        return z().toString();
    }

    /* renamed from: y */
    public c clone() {
        c cVar = new c();
        if (this.f32725b == 0) {
            return cVar;
        }
        cVar.f32724a = this.f32724a.a();
        r rVar = cVar.f32724a;
        rVar.f32787g = rVar;
        rVar.f32786f = rVar;
        r rVar2 = this.f32724a;
        while (true) {
            rVar2 = rVar2.f32786f;
            if (rVar2 != this.f32724a) {
                cVar.f32724a.f32787g.a(rVar2.a());
            } else {
                cVar.f32725b = this.f32725b;
                return cVar;
            }
        }
    }

    public final f z() {
        long j = this.f32725b;
        if (j <= 2147483647L) {
            return g((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f32725b);
    }

    public final f g(int i) {
        if (i == 0) {
            return f.f32736b;
        }
        return new t(this, i);
    }

    public final a a(a aVar) {
        if (aVar.f32728a == null) {
            aVar.f32728a = this;
            aVar.f32729b = true;
            return aVar;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public static final class a implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public c f32728a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f32729b;

        /* renamed from: c  reason: collision with root package name */
        public long f32730c = -1;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f32731d;

        /* renamed from: e  reason: collision with root package name */
        public int f32732e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f32733f = -1;

        /* renamed from: g  reason: collision with root package name */
        private r f32734g;

        public final int a() {
            if (this.f32730c != this.f32728a.f32725b) {
                long j = this.f32730c;
                if (j == -1) {
                    return a(0);
                }
                return a(j + ((long) (this.f32733f - this.f32732e)));
            }
            throw new IllegalStateException();
        }

        public final int a(long j) {
            r rVar;
            long j2;
            if (j < -1 || j > this.f32728a.f32725b) {
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(j), Long.valueOf(this.f32728a.f32725b)}));
            } else if (j == -1 || j == this.f32728a.f32725b) {
                this.f32734g = null;
                this.f32730c = j;
                this.f32731d = null;
                this.f32732e = -1;
                this.f32733f = -1;
                return -1;
            } else {
                long j3 = 0;
                long j4 = this.f32728a.f32725b;
                r rVar2 = this.f32728a.f32724a;
                r rVar3 = this.f32728a.f32724a;
                r rVar4 = this.f32734g;
                if (rVar4 != null) {
                    long j5 = this.f32730c - ((long) (this.f32732e - rVar4.f32782b));
                    if (j5 > j) {
                        rVar3 = this.f32734g;
                        j4 = j5;
                    } else {
                        rVar2 = this.f32734g;
                        j3 = j5;
                    }
                }
                if (j4 - j > j - j3) {
                    while (j >= ((long) (rVar.f32783c - rVar.f32782b)) + j2) {
                        j3 = j2 + ((long) (rVar.f32783c - rVar.f32782b));
                        rVar2 = rVar.f32786f;
                    }
                } else {
                    j2 = j4;
                    rVar = rVar3;
                    while (j2 > j) {
                        rVar = rVar.f32787g;
                        j2 -= (long) (rVar.f32783c - rVar.f32782b);
                    }
                }
                if (this.f32729b && rVar.f32784d) {
                    r b2 = rVar.b();
                    if (this.f32728a.f32724a == rVar) {
                        this.f32728a.f32724a = b2;
                    }
                    rVar = rVar.a(b2);
                    rVar.f32787g.c();
                }
                this.f32734g = rVar;
                this.f32730c = j;
                this.f32731d = rVar.f32781a;
                this.f32732e = rVar.f32782b + ((int) (j - j2));
                this.f32733f = rVar.f32783c;
                return this.f32733f - this.f32732e;
            }
        }

        public void close() {
            if (this.f32728a != null) {
                this.f32728a = null;
                this.f32734g = null;
                this.f32730c = -1;
                this.f32731d = null;
                this.f32732e = -1;
                this.f32733f = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }
    }
}
