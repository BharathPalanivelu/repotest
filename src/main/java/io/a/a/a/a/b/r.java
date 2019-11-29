package io.a.a.a.a.b;

import com.facebook.cache.disk.DefaultDiskStorage;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class r implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f33093b = Logger.getLogger(r.class.getName());

    /* renamed from: a  reason: collision with root package name */
    int f33094a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final RandomAccessFile f33095c;

    /* renamed from: d  reason: collision with root package name */
    private int f33096d;

    /* renamed from: e  reason: collision with root package name */
    private a f33097e;

    /* renamed from: f  reason: collision with root package name */
    private a f33098f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f33099g = new byte[16];

    public interface c {
        void a(InputStream inputStream, int i) throws IOException;
    }

    public r(File file) throws IOException {
        if (!file.exists()) {
            a(file);
        }
        this.f33095c = b(file);
        e();
    }

    private static void b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void a(byte[] bArr, int... iArr) {
        int i = 0;
        for (int b2 : iArr) {
            b(bArr, i, b2);
            i += 4;
        }
    }

    private static int a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    private void e() throws IOException {
        this.f33095c.seek(0);
        this.f33095c.readFully(this.f33099g);
        this.f33094a = a(this.f33099g, 0);
        if (((long) this.f33094a) <= this.f33095c.length()) {
            this.f33096d = a(this.f33099g, 4);
            int a2 = a(this.f33099g, 8);
            int a3 = a(this.f33099g, 12);
            this.f33097e = a(a2);
            this.f33098f = a(a3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f33094a + ", Actual length: " + this.f33095c.length());
    }

    private void a(int i, int i2, int i3, int i4) throws IOException {
        a(this.f33099g, i, i2, i3, i4);
        this.f33095c.seek(0);
        this.f33095c.write(this.f33099g);
    }

    private a a(int i) throws IOException {
        if (i == 0) {
            return a.f33103a;
        }
        this.f33095c.seek((long) i);
        return new a(i, this.f33095c.readInt());
    }

    /* JADX INFO: finally extract failed */
    private static void a(File file) throws IOException {
        File file2 = new File(file.getPath() + DefaultDiskStorage.FileType.TEMP);
        RandomAccessFile b2 = b(file2);
        try {
            b2.setLength(IjkMediaMeta.AV_CH_TOP_FRONT_LEFT);
            b2.seek(0);
            byte[] bArr = new byte[16];
            a(bArr, 4096, 0, 0, 0);
            b2.write(bArr);
            b2.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            b2.close();
            throw th;
        }
    }

    private static RandomAccessFile b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    /* access modifiers changed from: private */
    public int b(int i) {
        int i2 = this.f33094a;
        return i < i2 ? i : (i + 16) - i2;
    }

    private void a(int i, byte[] bArr, int i2, int i3) throws IOException {
        int b2 = b(i);
        int i4 = b2 + i3;
        int i5 = this.f33094a;
        if (i4 <= i5) {
            this.f33095c.seek((long) b2);
            this.f33095c.write(bArr, i2, i3);
            return;
        }
        int i6 = i5 - b2;
        this.f33095c.seek((long) b2);
        this.f33095c.write(bArr, i2, i6);
        this.f33095c.seek(16);
        this.f33095c.write(bArr, i2 + i6, i3 - i6);
    }

    /* access modifiers changed from: private */
    public void b(int i, byte[] bArr, int i2, int i3) throws IOException {
        int b2 = b(i);
        int i4 = b2 + i3;
        int i5 = this.f33094a;
        if (i4 <= i5) {
            this.f33095c.seek((long) b2);
            this.f33095c.readFully(bArr, i2, i3);
            return;
        }
        int i6 = i5 - b2;
        this.f33095c.seek((long) b2);
        this.f33095c.readFully(bArr, i2, i6);
        this.f33095c.seek(16);
        this.f33095c.readFully(bArr, i2 + i6, i3 - i6);
    }

    public void a(byte[] bArr) throws IOException {
        a(bArr, 0, bArr.length);
    }

    public synchronized void a(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        c(i2);
        boolean b2 = b();
        if (b2) {
            i3 = 16;
        } else {
            i3 = b(this.f33098f.f33104b + 4 + this.f33098f.f33105c);
        }
        a aVar = new a(i3, i2);
        b(this.f33099g, 0, i2);
        a(aVar.f33104b, this.f33099g, 0, 4);
        a(aVar.f33104b + 4, bArr, i, i2);
        a(this.f33094a, this.f33096d + 1, b2 ? aVar.f33104b : this.f33097e.f33104b, aVar.f33104b);
        this.f33098f = aVar;
        this.f33096d++;
        if (b2) {
            this.f33097e = this.f33098f;
        }
    }

    public int a() {
        if (this.f33096d == 0) {
            return 16;
        }
        if (this.f33098f.f33104b >= this.f33097e.f33104b) {
            return (this.f33098f.f33104b - this.f33097e.f33104b) + 4 + this.f33098f.f33105c + 16;
        }
        return (((this.f33098f.f33104b + 4) + this.f33098f.f33105c) + this.f33094a) - this.f33097e.f33104b;
    }

    private int f() {
        return this.f33094a - a();
    }

    public synchronized boolean b() {
        return this.f33096d == 0;
    }

    private void c(int i) throws IOException {
        int i2 = i + 4;
        int f2 = f();
        if (f2 < i2) {
            int i3 = this.f33094a;
            do {
                f2 += i3;
                i3 <<= 1;
            } while (f2 < i2);
            d(i3);
            int b2 = b(this.f33098f.f33104b + 4 + this.f33098f.f33105c);
            if (b2 < this.f33097e.f33104b) {
                FileChannel channel = this.f33095c.getChannel();
                channel.position((long) this.f33094a);
                long j = (long) (b2 - 4);
                if (channel.transferTo(16, j, channel) != j) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f33098f.f33104b < this.f33097e.f33104b) {
                int i4 = (this.f33094a + this.f33098f.f33104b) - 16;
                a(i3, this.f33096d, this.f33097e.f33104b, i4);
                this.f33098f = new a(i4, this.f33098f.f33105c);
            } else {
                a(i3, this.f33096d, this.f33097e.f33104b, this.f33098f.f33104b);
            }
            this.f33094a = i3;
        }
    }

    private void d(int i) throws IOException {
        this.f33095c.setLength((long) i);
        this.f33095c.getChannel().force(true);
    }

    public synchronized void a(c cVar) throws IOException {
        int i = this.f33097e.f33104b;
        for (int i2 = 0; i2 < this.f33096d; i2++) {
            a a2 = a(i);
            cVar.a(new b(a2), a2.f33105c);
            i = b(a2.f33104b + 4 + a2.f33105c);
        }
    }

    /* access modifiers changed from: private */
    public static <T> T b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    private final class b extends InputStream {

        /* renamed from: b  reason: collision with root package name */
        private int f33107b;

        /* renamed from: c  reason: collision with root package name */
        private int f33108c;

        private b(a aVar) {
            this.f33107b = r.this.b(aVar.f33104b + 4);
            this.f33108c = aVar.f33105c;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            Object unused = r.b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.f33108c;
            if (i3 <= 0) {
                return -1;
            }
            if (i2 > i3) {
                i2 = i3;
            }
            r.this.b(this.f33107b, bArr, i, i2);
            this.f33107b = r.this.b(this.f33107b + i2);
            this.f33108c -= i2;
            return i2;
        }

        public int read() throws IOException {
            if (this.f33108c == 0) {
                return -1;
            }
            r.this.f33095c.seek((long) this.f33107b);
            int read = r.this.f33095c.read();
            this.f33107b = r.this.b(this.f33107b + 1);
            this.f33108c--;
            return read;
        }
    }

    public synchronized void c() throws IOException {
        if (b()) {
            throw new NoSuchElementException();
        } else if (this.f33096d == 1) {
            d();
        } else {
            int b2 = b(this.f33097e.f33104b + 4 + this.f33097e.f33105c);
            b(b2, this.f33099g, 0, 4);
            int a2 = a(this.f33099g, 0);
            a(this.f33094a, this.f33096d - 1, b2, this.f33098f.f33104b);
            this.f33096d--;
            this.f33097e = new a(b2, a2);
        }
    }

    public synchronized void d() throws IOException {
        a(4096, 0, 0, 0);
        this.f33096d = 0;
        this.f33097e = a.f33103a;
        this.f33098f = a.f33103a;
        if (this.f33094a > 4096) {
            d(4096);
        }
        this.f33094a = 4096;
    }

    public synchronized void close() throws IOException {
        this.f33095c.close();
    }

    public boolean a(int i, int i2) {
        return (a() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f33094a);
        sb.append(", size=");
        sb.append(this.f33096d);
        sb.append(", first=");
        sb.append(this.f33097e);
        sb.append(", last=");
        sb.append(this.f33098f);
        sb.append(", element lengths=[");
        try {
            a((c) new c() {

                /* renamed from: a  reason: collision with root package name */
                boolean f33100a = true;

                public void a(InputStream inputStream, int i) throws IOException {
                    if (this.f33100a) {
                        this.f33100a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i);
                }
            });
        } catch (IOException e2) {
            f33093b.log(Level.WARNING, "read error", e2);
        }
        sb.append("]]");
        return sb.toString();
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final a f33103a = new a(0, 0);

        /* renamed from: b  reason: collision with root package name */
        final int f33104b;

        /* renamed from: c  reason: collision with root package name */
        final int f33105c;

        a(int i, int i2) {
            this.f33104b = i;
            this.f33105c = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f33104b + ", length = " + this.f33105c + "]";
        }
    }
}
