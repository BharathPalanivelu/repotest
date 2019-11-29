package e;

import com.facebook.common.time.Clock;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

final class q implements e {

    /* renamed from: a  reason: collision with root package name */
    public final c f32777a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final v f32778b;

    /* renamed from: c  reason: collision with root package name */
    boolean f32779c;

    q(v vVar) {
        if (vVar != null) {
            this.f32778b = vVar;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public c b() {
        return this.f32777a;
    }

    public long read(c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f32779c) {
            throw new IllegalStateException("closed");
        } else if (this.f32777a.f32725b == 0 && this.f32778b.read(this.f32777a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
            return -1;
        } else {
            return this.f32777a.read(cVar, Math.min(j, this.f32777a.f32725b));
        }
    }

    public boolean f() throws IOException {
        if (!this.f32779c) {
            return this.f32777a.f() && this.f32778b.read(this.f32777a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1;
        }
        throw new IllegalStateException("closed");
    }

    public void a(long j) throws IOException {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    public boolean b(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.f32779c) {
            while (this.f32777a.f32725b < j) {
                if (this.f32778b.read(this.f32777a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public byte i() throws IOException {
        a(1);
        return this.f32777a.i();
    }

    public f d(long j) throws IOException {
        a(j);
        return this.f32777a.d(j);
    }

    public byte[] v() throws IOException {
        this.f32777a.a(this.f32778b);
        return this.f32777a.v();
    }

    public byte[] h(long j) throws IOException {
        a(j);
        return this.f32777a.h(j);
    }

    public void a(byte[] bArr) throws IOException {
        try {
            a((long) bArr.length);
            this.f32777a.a(bArr);
        } catch (EOFException e2) {
            int i = 0;
            while (this.f32777a.f32725b > 0) {
                c cVar = this.f32777a;
                int a2 = cVar.a(bArr, i, (int) cVar.f32725b);
                if (a2 != -1) {
                    i += a2;
                } else {
                    throw new AssertionError();
                }
            }
            throw e2;
        }
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.f32777a.f32725b == 0 && this.f32778b.read(this.f32777a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
            return -1;
        }
        return this.f32777a.read(byteBuffer);
    }

    public void a(c cVar, long j) throws IOException {
        try {
            a(j);
            this.f32777a.a(cVar, j);
        } catch (EOFException e2) {
            cVar.a((v) this.f32777a);
            throw e2;
        }
    }

    public long a(u uVar) throws IOException {
        if (uVar != null) {
            long j = 0;
            while (this.f32778b.read(this.f32777a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) != -1) {
                long h = this.f32777a.h();
                if (h > 0) {
                    j += h;
                    uVar.write(this.f32777a, h);
                }
            }
            if (this.f32777a.a() <= 0) {
                return j;
            }
            long a2 = j + this.f32777a.a();
            c cVar = this.f32777a;
            uVar.write(cVar, cVar.a());
            return a2;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public String s() throws IOException {
        this.f32777a.a(this.f32778b);
        return this.f32777a.s();
    }

    public String e(long j) throws IOException {
        a(j);
        return this.f32777a.e(j);
    }

    public String a(Charset charset) throws IOException {
        if (charset != null) {
            this.f32777a.a(this.f32778b);
            return this.f32777a.a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String a(long j, Charset charset) throws IOException {
        a(j);
        if (charset != null) {
            return this.f32777a.a(j, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String t() throws IOException {
        return f(Clock.MAX_TIME);
    }

    public String f(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Clock.MAX_TIME ? Long.MAX_VALUE : j + 1;
            long a2 = a((byte) 10, 0, j2);
            if (a2 != -1) {
                return this.f32777a.g(a2);
            }
            if (j2 < Clock.MAX_TIME && b(j2) && this.f32777a.c(j2 - 1) == 13 && b(1 + j2) && this.f32777a.c(j2) == 10) {
                return this.f32777a.g(j2);
            }
            c cVar = new c();
            c cVar2 = this.f32777a;
            cVar2.a(cVar, 0, Math.min(32, cVar2.a()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f32777a.a(), j) + " content=" + cVar.r().f() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    public short j() throws IOException {
        a(2);
        return this.f32777a.j();
    }

    public short m() throws IOException {
        a(2);
        return this.f32777a.m();
    }

    public int k() throws IOException {
        a(4);
        return this.f32777a.k();
    }

    public int n() throws IOException {
        a(4);
        return this.f32777a.n();
    }

    public long l() throws IOException {
        a(8);
        return this.f32777a.l();
    }

    public long o() throws IOException {
        a(8);
        return this.f32777a.o();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long p() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.a((long) r0)
            r0 = 0
            r1 = 0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.b(r3)
            if (r3 == 0) goto L_0x0040
            e.c r3 = r6.f32777a
            long r4 = (long) r1
            byte r3 = r3.c((long) r4)
            r4 = 48
            if (r3 < r4) goto L_0x001f
            r4 = 57
            if (r3 <= r4) goto L_0x0026
        L_0x001f:
            if (r1 != 0) goto L_0x0028
            r4 = 45
            if (r3 == r4) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = r2
            goto L_0x0007
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            goto L_0x0040
        L_0x002b:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9] or '-' character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L_0x0040:
            e.c r0 = r6.f32777a
            long r0 = r0.p()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.q.p():long");
    }

    public long q() throws IOException {
        a(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!b((long) i2)) {
                break;
            }
            byte c2 = this.f32777a.c((long) i);
            if ((c2 >= 48 && c2 <= 57) || ((c2 >= 97 && c2 <= 102) || (c2 >= 65 && c2 <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(c2)}));
            }
        }
        return this.f32777a.q();
    }

    public void i(long j) throws IOException {
        if (!this.f32779c) {
            while (j > 0) {
                if (this.f32777a.f32725b == 0 && this.f32778b.read(this.f32777a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f32777a.a());
                this.f32777a.i(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public long a(byte b2) throws IOException {
        return a(b2, 0, Clock.MAX_TIME);
    }

    public long a(byte b2, long j, long j2) throws IOException {
        if (this.f32779c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long a2 = this.f32777a.a(b2, j, j2);
                if (a2 == -1) {
                    long j3 = this.f32777a.f32725b;
                    if (j3 >= j2 || this.f32778b.read(this.f32777a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                        break;
                    }
                    j = Math.max(j, j3);
                } else {
                    return a2;
                }
            }
            return -1;
        }
    }

    public boolean a(long j, f fVar) throws IOException {
        return a(j, fVar, 0, fVar.h());
    }

    public boolean a(long j, f fVar, int i, int i2) throws IOException {
        if (this.f32779c) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || i < 0 || i2 < 0 || fVar.h() - i < i2) {
            return false;
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = ((long) i3) + j;
                if (!b(1 + j2) || this.f32777a.c(j2) != fVar.a(i + i3)) {
                    return false;
                }
            }
            return true;
        }
    }

    public InputStream g() {
        return new InputStream() {
            public int read() throws IOException {
                if (q.this.f32779c) {
                    throw new IOException("closed");
                } else if (q.this.f32777a.f32725b == 0 && q.this.f32778b.read(q.this.f32777a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                    return -1;
                } else {
                    return q.this.f32777a.i() & 255;
                }
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (!q.this.f32779c) {
                    x.a((long) bArr.length, (long) i, (long) i2);
                    if (q.this.f32777a.f32725b == 0 && q.this.f32778b.read(q.this.f32777a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) == -1) {
                        return -1;
                    }
                    return q.this.f32777a.a(bArr, i, i2);
                }
                throw new IOException("closed");
            }

            public int available() throws IOException {
                if (!q.this.f32779c) {
                    return (int) Math.min(q.this.f32777a.f32725b, 2147483647L);
                }
                throw new IOException("closed");
            }

            public void close() throws IOException {
                q.this.close();
            }

            public String toString() {
                return q.this + ".inputStream()";
            }
        };
    }

    public boolean isOpen() {
        return !this.f32779c;
    }

    public void close() throws IOException {
        if (!this.f32779c) {
            this.f32779c = true;
            this.f32778b.close();
            this.f32777a.w();
        }
    }

    public w timeout() {
        return this.f32778b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f32778b + SQLBuilder.PARENTHESES_RIGHT;
    }
}
