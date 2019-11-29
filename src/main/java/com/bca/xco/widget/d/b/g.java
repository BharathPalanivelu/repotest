package com.bca.xco.widget.d.b;

import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.NativeProtocol;
import com.path.android.jobqueue.JobManager;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.EOFException;
import java.nio.charset.Charset;

public final class g implements a, b, Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f5213c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a  reason: collision with root package name */
    p f5214a;

    /* renamed from: b  reason: collision with root package name */
    long f5215b;

    public g b() {
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    /* renamed from: n */
    public g c() {
        return this;
    }

    public long m() {
        return this.f5215b;
    }

    public boolean d() {
        return this.f5215b == 0;
    }

    public void c(long j) {
        if (this.f5215b < j) {
            throw new EOFException();
        }
    }

    public g a(g gVar, long j, long j2) {
        if (gVar != null) {
            t.a(this.f5215b, j, j2);
            if (j2 == 0) {
                return this;
            }
            gVar.f5215b += j2;
            p pVar = this.f5214a;
            while (j >= ((long) (pVar.f5246c - pVar.f5245b))) {
                j -= (long) (pVar.f5246c - pVar.f5245b);
                pVar = pVar.f5249f;
            }
            while (j2 > 0) {
                p pVar2 = new p(pVar);
                pVar2.f5245b = (int) (((long) pVar2.f5245b) + j);
                pVar2.f5246c = Math.min(pVar2.f5245b + ((int) j2), pVar2.f5246c);
                p pVar3 = gVar.f5214a;
                if (pVar3 == null) {
                    pVar2.f5250g = pVar2;
                    pVar2.f5249f = pVar2;
                    gVar.f5214a = pVar2;
                } else {
                    pVar3.f5250g.a(pVar2);
                }
                j2 -= (long) (pVar2.f5246c - pVar2.f5245b);
                pVar = pVar.f5249f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public long o() {
        long j = this.f5215b;
        if (j == 0) {
            return 0;
        }
        p pVar = this.f5214a.f5250g;
        return (pVar.f5246c >= 8192 || !pVar.f5248e) ? j : j - ((long) (pVar.f5246c - pVar.f5245b));
    }

    public byte e() {
        if (this.f5215b != 0) {
            p pVar = this.f5214a;
            int i = pVar.f5245b;
            int i2 = pVar.f5246c;
            int i3 = i + 1;
            byte b2 = pVar.f5244a[i];
            this.f5215b--;
            if (i3 == i2) {
                this.f5214a = pVar.a();
                q.a(pVar);
            } else {
                pVar.f5245b = i3;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public byte g(long j) {
        t.a(this.f5215b, j, 1);
        p pVar = this.f5214a;
        while (true) {
            long j2 = (long) (pVar.f5246c - pVar.f5245b);
            if (j < j2) {
                return pVar.f5244a[pVar.f5245b + ((int) j)];
            }
            j -= j2;
            pVar = pVar.f5249f;
        }
    }

    public short f() {
        if (this.f5215b >= 2) {
            p pVar = this.f5214a;
            int i = pVar.f5245b;
            int i2 = pVar.f5246c;
            if (i2 - i < 2) {
                return (short) (((e() & 255) << 8) | (e() & 255));
            }
            byte[] bArr = pVar.f5244a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b2 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.f5215b -= 2;
            if (i4 == i2) {
                this.f5214a = pVar.a();
                q.a(pVar);
            } else {
                pVar.f5245b = i4;
            }
            return (short) b2;
        }
        throw new IllegalStateException("size < 2: " + this.f5215b);
    }

    public int h() {
        if (this.f5215b >= 4) {
            p pVar = this.f5214a;
            int i = pVar.f5245b;
            int i2 = pVar.f5246c;
            if (i2 - i < 4) {
                return ((e() & 255) << 24) | ((e() & 255) << 16) | ((e() & 255) << 8) | (e() & 255);
            }
            byte[] bArr = pVar.f5244a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b2 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i5 = i4 + 1;
            byte b3 = b2 | ((bArr[i4] & 255) << 8);
            int i6 = i5 + 1;
            byte b4 = b3 | (bArr[i5] & 255);
            this.f5215b -= 4;
            if (i6 == i2) {
                this.f5214a = pVar.a();
                q.a(pVar);
            } else {
                pVar.f5245b = i6;
            }
            return b4;
        }
        throw new IllegalStateException("size < 4: " + this.f5215b);
    }

    public short g() {
        return t.a(f());
    }

    public int i() {
        return t.a(h());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        if (r8 != r9) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        r15.f5214a = r6.a();
        com.bca.xco.widget.d.b.q.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
        r6.f5245b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009f, code lost:
        if (r0 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0076 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long j() {
        /*
            r15 = this;
            long r0 = r15.f5215b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00ac
            r0 = 0
            r4 = r2
            r1 = 0
        L_0x000b:
            com.bca.xco.widget.d.b.p r6 = r15.f5214a
            byte[] r7 = r6.f5244a
            int r8 = r6.f5245b
            int r9 = r6.f5246c
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
            com.bca.xco.widget.d.b.g r0 = new com.bca.xco.widget.d.b.g
            r0.<init>()
            com.bca.xco.widget.d.b.g r0 = r0.b(r4)
            com.bca.xco.widget.d.b.g r0 = r0.a((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.q()
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
            com.bca.xco.widget.d.b.p r7 = r6.a()
            r15.f5214a = r7
            com.bca.xco.widget.d.b.q.a(r6)
            goto L_0x009f
        L_0x009d:
            r6.f5245b = r8
        L_0x009f:
            if (r0 != 0) goto L_0x00a5
            com.bca.xco.widget.d.b.p r6 = r15.f5214a
            if (r6 != 0) goto L_0x000b
        L_0x00a5:
            long r2 = r15.f5215b
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f5215b = r2
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
        throw new UnsupportedOperationException("Method not decompiled: com.bca.xco.widget.d.b.g.j():long");
    }

    public h p() {
        return new h(k());
    }

    public h e(long j) {
        return new h(f(j));
    }

    public String q() {
        try {
            return a(this.f5215b, t.f5259a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String h(long j) {
        return a(j, t.f5259a);
    }

    public String a(long j, Charset charset) {
        t.a(this.f5215b, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        } else if (j == 0) {
            return "";
        } else {
            p pVar = this.f5214a;
            if (((long) pVar.f5245b) + j > ((long) pVar.f5246c)) {
                return new String(f(j), charset);
            }
            String str = new String(pVar.f5244a, pVar.f5245b, (int) j, charset);
            pVar.f5245b = (int) (((long) pVar.f5245b) + j);
            this.f5215b -= j;
            if (pVar.f5245b == pVar.f5246c) {
                this.f5214a = pVar.a();
                q.a(pVar);
            }
            return str;
        }
    }

    public String l() {
        long a2 = a((byte) 10);
        if (a2 != -1) {
            return i(a2);
        }
        g gVar = new g();
        a(gVar, 0, Math.min(32, this.f5215b));
        throw new EOFException("\\n not found: size=" + m() + " content=" + gVar.p().c() + "…");
    }

    /* access modifiers changed from: package-private */
    public String i(long j) {
        if (j > 0) {
            long j2 = j - 1;
            if (g(j2) == 13) {
                String h = h(j2);
                d(2);
                return h;
            }
        }
        String h2 = h(j);
        d(1);
        return h2;
    }

    public byte[] k() {
        try {
            return f(this.f5215b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public byte[] f(long j) {
        t.a(this.f5215b, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            b(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public void b(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int b2 = b(bArr, i, bArr.length - i);
            if (b2 != -1) {
                i += b2;
            } else {
                throw new EOFException();
            }
        }
    }

    public int b(byte[] bArr, int i, int i2) {
        t.a((long) bArr.length, (long) i, (long) i2);
        p pVar = this.f5214a;
        if (pVar == null) {
            return -1;
        }
        int min = Math.min(i2, pVar.f5246c - pVar.f5245b);
        System.arraycopy(pVar.f5244a, pVar.f5245b, bArr, i, min);
        pVar.f5245b += min;
        this.f5215b -= (long) min;
        if (pVar.f5245b == pVar.f5246c) {
            this.f5214a = pVar.a();
            q.a(pVar);
        }
        return min;
    }

    public void r() {
        try {
            d(this.f5215b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public void d(long j) {
        while (j > 0) {
            p pVar = this.f5214a;
            if (pVar != null) {
                int min = (int) Math.min(j, (long) (pVar.f5246c - this.f5214a.f5245b));
                long j2 = (long) min;
                this.f5215b -= j2;
                j -= j2;
                this.f5214a.f5245b += min;
                if (this.f5214a.f5245b == this.f5214a.f5246c) {
                    p pVar2 = this.f5214a;
                    this.f5214a = pVar2.a();
                    q.a(pVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public g a(h hVar) {
        if (hVar != null) {
            hVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /* renamed from: b */
    public g a(String str) {
        return a(str, 0, str.length());
    }

    public g a(String str, int i, int i2) {
        char c2;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    p h = h(1);
                    byte[] bArr = h.f5244a;
                    int i3 = h.f5246c - i;
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
                    int i5 = (i3 + i4) - h.f5246c;
                    h.f5246c += i5;
                    this.f5215b += (long) i5;
                    i = i4;
                } else {
                    if (charAt < 2048) {
                        a((charAt >> 6) | JfifUtil.MARKER_SOFn);
                        a((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        a((charAt >> 12) | 224);
                        a(((charAt >> 6) & 63) | 128);
                        a((int) (charAt & '?') | 128);
                    } else {
                        int i6 = i + 1;
                        if (i6 < i2) {
                            c2 = str.charAt(i6);
                        } else {
                            c2 = 0;
                        }
                        if (charAt > 56319 || c2 < 56320 || c2 > 57343) {
                            a(63);
                            i = i6;
                        } else {
                            int i7 = (((charAt & 10239) << 10) | (9215 & c2)) + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                            a((i7 >> 18) | 240);
                            a(((i7 >> 12) & 63) | 128);
                            a(((i7 >> 6) & 63) | 128);
                            a((i7 & 63) | 128);
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

    public g d(int i) {
        if (i < 128) {
            a(i);
        } else if (i < 2048) {
            a((i >> 6) | JfifUtil.MARKER_SOFn);
            a((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                a((i >> 12) | 224);
                a(((i >> 6) & 63) | 128);
                a((i & 63) | 128);
            } else {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
        } else if (i <= 1114111) {
            a((i >> 18) | 240);
            a(((i >> 12) & 63) | 128);
            a(((i >> 6) & 63) | 128);
            a((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    /* renamed from: c */
    public g a(byte[] bArr) {
        if (bArr != null) {
            return a(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    /* renamed from: c */
    public g a(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            t.a((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                p h = h(1);
                int min = Math.min(i3 - i, 8192 - h.f5246c);
                System.arraycopy(bArr, i, h.f5244a, h.f5246c, min);
                i += min;
                h.f5246c += min;
            }
            this.f5215b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long a(d dVar) {
        if (dVar != null) {
            long j = 0;
            while (true) {
                long a2 = dVar.a(this, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER);
                if (a2 == -1) {
                    return j;
                }
                j += a2;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* renamed from: e */
    public g a(int i) {
        p h = h(1);
        byte[] bArr = h.f5244a;
        int i2 = h.f5246c;
        h.f5246c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f5215b++;
        return this;
    }

    /* renamed from: f */
    public g b(int i) {
        p h = h(2);
        byte[] bArr = h.f5244a;
        int i2 = h.f5246c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        h.f5246c = i3 + 1;
        this.f5215b += 2;
        return this;
    }

    /* renamed from: g */
    public g c(int i) {
        p h = h(4);
        byte[] bArr = h.f5244a;
        int i2 = h.f5246c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        h.f5246c = i5 + 1;
        this.f5215b += 4;
        return this;
    }

    /* renamed from: j */
    public g a(long j) {
        if (j == 0) {
            return a(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return a("-9223372036854775808");
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
        p h = h(i);
        byte[] bArr = h.f5244a;
        int i2 = h.f5246c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = f5213c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        h.f5246c += i;
        this.f5215b += (long) i;
        return this;
    }

    /* renamed from: k */
    public g b(long j) {
        if (j == 0) {
            return a(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        p h = h(numberOfTrailingZeros);
        byte[] bArr = h.f5244a;
        int i = h.f5246c;
        for (int i2 = (h.f5246c + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f5213c[(int) (15 & j)];
            j >>>= 4;
        }
        h.f5246c += numberOfTrailingZeros;
        this.f5215b += (long) numberOfTrailingZeros;
        return this;
    }

    /* access modifiers changed from: package-private */
    public p h(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        p pVar = this.f5214a;
        if (pVar == null) {
            this.f5214a = q.a();
            p pVar2 = this.f5214a;
            pVar2.f5250g = pVar2;
            pVar2.f5249f = pVar2;
            return pVar2;
        }
        p pVar3 = pVar.f5250g;
        return (pVar3.f5246c + i > 8192 || !pVar3.f5248e) ? pVar3.a(q.a()) : pVar3;
    }

    public void a_(g gVar, long j) {
        if (gVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (gVar != this) {
            t.a(gVar.f5215b, 0, j);
            while (j > 0) {
                if (j < ((long) (gVar.f5214a.f5246c - gVar.f5214a.f5245b))) {
                    p pVar = this.f5214a;
                    p pVar2 = pVar != null ? pVar.f5250g : null;
                    if (pVar2 != null && pVar2.f5248e) {
                        if ((((long) pVar2.f5246c) + j) - ((long) (pVar2.f5247d ? 0 : pVar2.f5245b)) <= IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) {
                            gVar.f5214a.a(pVar2, (int) j);
                            gVar.f5215b -= j;
                            this.f5215b += j;
                            return;
                        }
                    }
                    gVar.f5214a = gVar.f5214a.a((int) j);
                }
                p pVar3 = gVar.f5214a;
                long j2 = (long) (pVar3.f5246c - pVar3.f5245b);
                gVar.f5214a = pVar3.a();
                p pVar4 = this.f5214a;
                if (pVar4 == null) {
                    this.f5214a = pVar3;
                    p pVar5 = this.f5214a;
                    pVar5.f5250g = pVar5;
                    pVar5.f5249f = pVar5;
                } else {
                    pVar4.f5250g.a(pVar3).b();
                }
                gVar.f5215b -= j2;
                this.f5215b += j2;
                j -= j2;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public long a(g gVar, long j) {
        if (gVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.f5215b;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            gVar.a_(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    public long a(byte b2) {
        return a(b2, 0);
    }

    public long a(byte b2, long j) {
        long j2 = 0;
        if (j >= 0) {
            p pVar = this.f5214a;
            if (pVar == null) {
                return -1;
            }
            long j3 = this.f5215b;
            if (j3 - j >= j) {
                while (true) {
                    j3 = j2;
                    j2 = ((long) (pVar.f5246c - pVar.f5245b)) + j3;
                    if (j2 >= j) {
                        break;
                    }
                    pVar = pVar.f5249f;
                }
            } else {
                while (j3 > j) {
                    pVar = pVar.f5250g;
                    j3 -= (long) (pVar.f5246c - pVar.f5245b);
                }
            }
            while (j3 < this.f5215b) {
                byte[] bArr = pVar.f5244a;
                int i = pVar.f5246c;
                for (int i2 = (int) ((((long) pVar.f5245b) + j) - j3); i2 < i; i2++) {
                    if (bArr[i2] == b2) {
                        return ((long) (i2 - pVar.f5245b)) + j3;
                    }
                }
                j = ((long) (pVar.f5246c - pVar.f5245b)) + j3;
                pVar = pVar.f5249f;
                j3 = j;
            }
            return -1;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    public s a() {
        return s.f5255b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        long j = this.f5215b;
        if (j != gVar.f5215b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        p pVar = this.f5214a;
        p pVar2 = gVar.f5214a;
        int i = pVar.f5245b;
        int i2 = pVar2.f5245b;
        while (j2 < this.f5215b) {
            long min = (long) Math.min(pVar.f5246c - i, pVar2.f5246c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (((long) i5) < min) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (pVar.f5244a[i4] != pVar2.f5244a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == pVar.f5246c) {
                pVar = pVar.f5249f;
                i = pVar.f5245b;
            } else {
                i = i4;
            }
            if (i3 == pVar2.f5246c) {
                pVar2 = pVar2.f5249f;
                i2 = pVar2.f5245b;
            } else {
                i2 = i3;
            }
            j2 += min;
        }
        return true;
    }

    public int hashCode() {
        p pVar = this.f5214a;
        if (pVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = pVar.f5246c;
            for (int i3 = pVar.f5245b; i3 < i2; i3++) {
                i = (i * 31) + pVar.f5244a[i3];
            }
            pVar = pVar.f5249f;
        } while (pVar != this.f5214a);
        return i;
    }

    public String toString() {
        return t().toString();
    }

    /* renamed from: s */
    public g clone() {
        g gVar = new g();
        if (this.f5215b == 0) {
            return gVar;
        }
        gVar.f5214a = new p(this.f5214a);
        p pVar = gVar.f5214a;
        pVar.f5250g = pVar;
        pVar.f5249f = pVar;
        p pVar2 = this.f5214a;
        while (true) {
            pVar2 = pVar2.f5249f;
            if (pVar2 != this.f5214a) {
                gVar.f5214a.f5250g.a(new p(pVar2));
            } else {
                gVar.f5215b = this.f5215b;
                return gVar;
            }
        }
    }

    public h t() {
        long j = this.f5215b;
        if (j <= 2147483647L) {
            return i((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f5215b);
    }

    public h i(int i) {
        if (i == 0) {
            return h.f5217b;
        }
        return new r(this, i);
    }
}
