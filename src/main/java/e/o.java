package e;

import java.io.IOException;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    final long f32763a;

    /* renamed from: b  reason: collision with root package name */
    final c f32764b = new c();

    /* renamed from: c  reason: collision with root package name */
    boolean f32765c;

    /* renamed from: d  reason: collision with root package name */
    boolean f32766d;

    /* renamed from: e  reason: collision with root package name */
    private final u f32767e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final v f32768f = new b();

    public o(long j) {
        if (j >= 1) {
            this.f32763a = j;
            return;
        }
        throw new IllegalArgumentException("maxBufferSize < 1: " + j);
    }

    public final v a() {
        return this.f32768f;
    }

    public final u b() {
        return this.f32767e;
    }

    final class a implements u {

        /* renamed from: a  reason: collision with root package name */
        final w f32769a = new w();

        a() {
        }

        public void write(c cVar, long j) throws IOException {
            synchronized (o.this.f32764b) {
                if (!o.this.f32765c) {
                    while (j > 0) {
                        if (!o.this.f32766d) {
                            long a2 = o.this.f32763a - o.this.f32764b.a();
                            if (a2 == 0) {
                                this.f32769a.waitUntilNotified(o.this.f32764b);
                            } else {
                                long min = Math.min(a2, j);
                                o.this.f32764b.write(cVar, min);
                                j -= min;
                                o.this.f32764b.notifyAll();
                            }
                        } else {
                            throw new IOException("source is closed");
                        }
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
        }

        public void flush() throws IOException {
            synchronized (o.this.f32764b) {
                if (o.this.f32765c) {
                    throw new IllegalStateException("closed");
                } else if (o.this.f32766d) {
                    if (o.this.f32764b.a() > 0) {
                        throw new IOException("source is closed");
                    }
                }
            }
        }

        public void close() throws IOException {
            synchronized (o.this.f32764b) {
                if (!o.this.f32765c) {
                    if (o.this.f32766d) {
                        if (o.this.f32764b.a() > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                    o.this.f32765c = true;
                    o.this.f32764b.notifyAll();
                }
            }
        }

        public w timeout() {
            return this.f32769a;
        }
    }

    final class b implements v {

        /* renamed from: a  reason: collision with root package name */
        final w f32771a = new w();

        b() {
        }

        public long read(c cVar, long j) throws IOException {
            synchronized (o.this.f32764b) {
                if (!o.this.f32766d) {
                    while (o.this.f32764b.a() == 0) {
                        if (o.this.f32765c) {
                            return -1;
                        }
                        this.f32771a.waitUntilNotified(o.this.f32764b);
                    }
                    long read = o.this.f32764b.read(cVar, j);
                    o.this.f32764b.notifyAll();
                    return read;
                }
                throw new IllegalStateException("closed");
            }
        }

        public void close() throws IOException {
            synchronized (o.this.f32764b) {
                o.this.f32766d = true;
                o.this.f32764b.notifyAll();
            }
        }

        public w timeout() {
            return this.f32771a;
        }
    }
}
