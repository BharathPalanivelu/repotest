package e;

import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

final class p implements d {

    /* renamed from: a  reason: collision with root package name */
    public final c f32773a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final u f32774b;

    /* renamed from: c  reason: collision with root package name */
    boolean f32775c;

    p(u uVar) {
        if (uVar != null) {
            this.f32774b = uVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public c b() {
        return this.f32773a;
    }

    public void write(c cVar, long j) throws IOException {
        if (!this.f32775c) {
            this.f32773a.write(cVar, j);
            A();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public d d(f fVar) throws IOException {
        if (!this.f32775c) {
            this.f32773a.d(fVar);
            return A();
        }
        throw new IllegalStateException("closed");
    }

    public d b(String str) throws IOException {
        if (!this.f32775c) {
            this.f32773a.b(str);
            return A();
        }
        throw new IllegalStateException("closed");
    }

    public d c(byte[] bArr) throws IOException {
        if (!this.f32775c) {
            this.f32773a.c(bArr);
            return A();
        }
        throw new IllegalStateException("closed");
    }

    public d c(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f32775c) {
            this.f32773a.c(bArr, i, i2);
            return A();
        }
        throw new IllegalStateException("closed");
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f32775c) {
            int write = this.f32773a.write(byteBuffer);
            A();
            return write;
        }
        throw new IllegalStateException("closed");
    }

    public long a(v vVar) throws IOException {
        if (vVar != null) {
            long j = 0;
            while (true) {
                long read = vVar.read(this.f32773a, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER);
                if (read == -1) {
                    return j;
                }
                j += read;
                A();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public d a(v vVar, long j) throws IOException {
        while (j > 0) {
            long read = vVar.read(this.f32773a, j);
            if (read != -1) {
                j -= read;
                A();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public d k(int i) throws IOException {
        if (!this.f32775c) {
            this.f32773a.k(i);
            return A();
        }
        throw new IllegalStateException("closed");
    }

    public d j(int i) throws IOException {
        if (!this.f32775c) {
            this.f32773a.j(i);
            return A();
        }
        throw new IllegalStateException("closed");
    }

    public d i(int i) throws IOException {
        if (!this.f32775c) {
            this.f32773a.i(i);
            return A();
        }
        throw new IllegalStateException("closed");
    }

    public d h(int i) throws IOException {
        if (!this.f32775c) {
            this.f32773a.h(i);
            return A();
        }
        throw new IllegalStateException("closed");
    }

    public d p(long j) throws IOException {
        if (!this.f32775c) {
            this.f32773a.p(j);
            return A();
        }
        throw new IllegalStateException("closed");
    }

    public d o(long j) throws IOException {
        if (!this.f32775c) {
            this.f32773a.o(j);
            return A();
        }
        throw new IllegalStateException("closed");
    }

    public d n(long j) throws IOException {
        if (!this.f32775c) {
            this.f32773a.n(j);
            return A();
        }
        throw new IllegalStateException("closed");
    }

    public d A() throws IOException {
        if (!this.f32775c) {
            long h = this.f32773a.h();
            if (h > 0) {
                this.f32774b.write(this.f32773a, h);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public d e() throws IOException {
        if (!this.f32775c) {
            long a2 = this.f32773a.a();
            if (a2 > 0) {
                this.f32774b.write(this.f32773a, a2);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public OutputStream c() {
        return new OutputStream() {
            public void write(int i) throws IOException {
                if (!p.this.f32775c) {
                    p.this.f32773a.k((int) (byte) i);
                    p.this.A();
                    return;
                }
                throw new IOException("closed");
            }

            public void write(byte[] bArr, int i, int i2) throws IOException {
                if (!p.this.f32775c) {
                    p.this.f32773a.c(bArr, i, i2);
                    p.this.A();
                    return;
                }
                throw new IOException("closed");
            }

            public void flush() throws IOException {
                if (!p.this.f32775c) {
                    p.this.flush();
                }
            }

            public void close() throws IOException {
                p.this.close();
            }

            public String toString() {
                return p.this + ".outputStream()";
            }
        };
    }

    public void flush() throws IOException {
        if (!this.f32775c) {
            if (this.f32773a.f32725b > 0) {
                u uVar = this.f32774b;
                c cVar = this.f32773a;
                uVar.write(cVar, cVar.f32725b);
            }
            this.f32774b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public boolean isOpen() {
        return !this.f32775c;
    }

    public void close() throws IOException {
        if (!this.f32775c) {
            Throwable th = null;
            try {
                if (this.f32773a.f32725b > 0) {
                    this.f32774b.write(this.f32773a, this.f32773a.f32725b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f32774b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f32775c = true;
            if (th != null) {
                x.a(th);
            }
        }
    }

    public w timeout() {
        return this.f32774b.timeout();
    }

    public String toString() {
        return "buffer(" + this.f32774b + SQLBuilder.PARENTHESES_RIGHT;
    }
}
