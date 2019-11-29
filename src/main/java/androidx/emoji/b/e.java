package androidx.emoji.b;

import com.litesuits.orm.db.assit.SQLStatement;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class e {

    private interface c {
        int a() throws IOException;

        void a(int i) throws IOException;

        long b() throws IOException;

        int c() throws IOException;

        long d();
    }

    static int a(short s) {
        return s & SQLStatement.NONE;
    }

    static long a(int i) {
        return ((long) i) & 4294967295L;
    }

    static androidx.k.a.a.b a(InputStream inputStream) throws IOException {
        a aVar = new a(inputStream);
        b a2 = a((c) aVar);
        aVar.a((int) (a2.a() - aVar.d()));
        ByteBuffer allocate = ByteBuffer.allocate((int) a2.b());
        int read = inputStream.read(allocate.array());
        if (((long) read) == a2.b()) {
            return androidx.k.a.a.b.a(allocate);
        }
        throw new IOException("Needed " + a2.b() + " bytes, got " + read);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r0 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.k.a.a.b a(android.content.res.AssetManager r1, java.lang.String r2) throws java.io.IOException {
        /*
            java.io.InputStream r1 = r1.open(r2)
            androidx.k.a.a.b r2 = a((java.io.InputStream) r1)     // Catch:{ Throwable -> 0x0011, all -> 0x000e }
            if (r1 == 0) goto L_0x000d
            r1.close()
        L_0x000d:
            return r2
        L_0x000e:
            r2 = move-exception
            r0 = 0
            goto L_0x0014
        L_0x0011:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0013 }
        L_0x0013:
            r2 = move-exception
        L_0x0014:
            if (r1 == 0) goto L_0x001f
            if (r0 == 0) goto L_0x001c
            r1.close()     // Catch:{ Throwable -> 0x001f }
            goto L_0x001f
        L_0x001c:
            r1.close()
        L_0x001f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji.b.e.a(android.content.res.AssetManager, java.lang.String):androidx.k.a.a.b");
    }

    private static b a(c cVar) throws IOException {
        long j;
        cVar.a(4);
        int a2 = cVar.a();
        if (a2 <= 100) {
            cVar.a(6);
            int i = 0;
            while (true) {
                if (i >= a2) {
                    j = -1;
                    break;
                }
                int c2 = cVar.c();
                cVar.a(4);
                j = cVar.b();
                cVar.a(4);
                if (1835365473 == c2) {
                    break;
                }
                i++;
            }
            if (j != -1) {
                cVar.a((int) (j - cVar.d()));
                cVar.a(12);
                long b2 = cVar.b();
                for (int i2 = 0; ((long) i2) < b2; i2++) {
                    int c3 = cVar.c();
                    long b3 = cVar.b();
                    long b4 = cVar.b();
                    if (1164798569 == c3 || 1701669481 == c3) {
                        return new b(b3 + j, b4);
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final long f2074a;

        /* renamed from: b  reason: collision with root package name */
        private final long f2075b;

        b(long j, long j2) {
            this.f2074a = j;
            this.f2075b = j2;
        }

        /* access modifiers changed from: package-private */
        public long a() {
            return this.f2074a;
        }

        /* access modifiers changed from: package-private */
        public long b() {
            return this.f2075b;
        }
    }

    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f2070a;

        /* renamed from: b  reason: collision with root package name */
        private final ByteBuffer f2071b;

        /* renamed from: c  reason: collision with root package name */
        private final InputStream f2072c;

        /* renamed from: d  reason: collision with root package name */
        private long f2073d = 0;

        a(InputStream inputStream) {
            this.f2072c = inputStream;
            this.f2070a = new byte[4];
            this.f2071b = ByteBuffer.wrap(this.f2070a);
            this.f2071b.order(ByteOrder.BIG_ENDIAN);
        }

        public int a() throws IOException {
            this.f2071b.position(0);
            b(2);
            return e.a(this.f2071b.getShort());
        }

        public long b() throws IOException {
            this.f2071b.position(0);
            b(4);
            return e.a(this.f2071b.getInt());
        }

        public int c() throws IOException {
            this.f2071b.position(0);
            b(4);
            return this.f2071b.getInt();
        }

        public void a(int i) throws IOException {
            while (i > 0) {
                int skip = (int) this.f2072c.skip((long) i);
                if (skip >= 1) {
                    i -= skip;
                    this.f2073d += (long) skip;
                } else {
                    throw new IOException("Skip didn't move at least 1 byte forward");
                }
            }
        }

        public long d() {
            return this.f2073d;
        }

        private void b(int i) throws IOException {
            if (this.f2072c.read(this.f2070a, 0, i) == i) {
                this.f2073d += (long) i;
                return;
            }
            throw new IOException("read failed");
        }
    }
}
