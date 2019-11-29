package com.google.c;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class f implements Serializable, Iterable<Byte> {

    /* renamed from: a  reason: collision with root package name */
    public static final f f13707a = new g(u.f14060c);

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f13708b = (!f.class.desiredAssertionStatus());

    /* renamed from: c  reason: collision with root package name */
    private static final c f13709c;
    private int hash = 0;

    private interface c {
        byte[] a(byte[] bArr, int i, int i2);
    }

    public interface d extends Iterator<Byte> {
    }

    public abstract byte a(int i);

    /* access modifiers changed from: protected */
    public abstract int a(int i, int i2, int i3);

    public abstract f a(int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void a(e eVar) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr, int i, int i2, int i3);

    public abstract int b();

    /* access modifiers changed from: protected */
    public abstract String b(Charset charset);

    public abstract boolean e();

    public abstract boolean equals(Object obj);

    public abstract g f();

    static {
        boolean z = true;
        try {
            Class.forName("android.content.Context");
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        f13709c = z ? new h() : new a();
    }

    private static final class h implements c {
        private h() {
        }

        public byte[] a(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }
    }

    private static final class a implements c {
        private a() {
        }

        public byte[] a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }
    }

    f() {
    }

    /* renamed from: a */
    public final d iterator() {
        return new d() {

            /* renamed from: b  reason: collision with root package name */
            private int f13711b = 0;

            /* renamed from: c  reason: collision with root package name */
            private final int f13712c = f.this.b();

            public boolean hasNext() {
                return this.f13711b < this.f13712c;
            }

            /* renamed from: a */
            public Byte next() {
                return Byte.valueOf(b());
            }

            public byte b() {
                try {
                    f fVar = f.this;
                    int i = this.f13711b;
                    this.f13711b = i + 1;
                    return fVar.a(i);
                } catch (IndexOutOfBoundsException e2) {
                    throw new NoSuchElementException(e2.getMessage());
                }
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static f a(byte[] bArr, int i, int i2) {
        return new g(f13709c.a(bArr, i, i2));
    }

    public static f a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    static f b(byte[] bArr) {
        return new g(bArr);
    }

    static f b(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    public static f a(String str) {
        return new g(str.getBytes(u.f14058a));
    }

    public final byte[] c() {
        int b2 = b();
        if (b2 == 0) {
            return u.f14060c;
        }
        byte[] bArr = new byte[b2];
        a(bArr, 0, 0, b2);
        return bArr;
    }

    public final String a(Charset charset) {
        return b() == 0 ? "" : b(charset);
    }

    public final String d() {
        return a(u.f14058a);
    }

    /* renamed from: com.google.c.f$f  reason: collision with other inner class name */
    static abstract class C0226f extends f {
        /* access modifiers changed from: package-private */
        public abstract boolean a(f fVar, int i, int i2);

        C0226f() {
        }

        public /* synthetic */ Iterator iterator() {
            return f.super.iterator();
        }
    }

    public final int hashCode() {
        int i = this.hash;
        if (i == 0) {
            int b2 = b();
            i = a(b2, 0, b2);
            if (i == 0) {
                i = 1;
            }
            this.hash = i;
        }
        return i;
    }

    static e b(int i) {
        return new e(i);
    }

    static final class e {

        /* renamed from: a  reason: collision with root package name */
        private final h f13713a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f13714b;

        private e(int i) {
            this.f13714b = new byte[i];
            this.f13713a = h.a(this.f13714b);
        }

        public f a() {
            this.f13713a.b();
            return new g(this.f13714b);
        }

        public h b() {
            return this.f13713a;
        }
    }

    /* access modifiers changed from: protected */
    public final int g() {
        return this.hash;
    }

    static void b(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }

    static int b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
        }
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(b())});
    }

    private static class g extends C0226f {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        /* access modifiers changed from: protected */
        public int h() {
            return 0;
        }

        g(byte[] bArr) {
            this.bytes = bArr;
        }

        public byte a(int i) {
            return this.bytes[i];
        }

        public int b() {
            return this.bytes.length;
        }

        public final f a(int i, int i2) {
            int b2 = b(i, i2, b());
            if (b2 == 0) {
                return f.f13707a;
            }
            return new b(this.bytes, h() + i, b2);
        }

        /* access modifiers changed from: protected */
        public void a(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.bytes, i, bArr, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public final void a(e eVar) throws IOException {
            eVar.a(this.bytes, h(), b());
        }

        /* access modifiers changed from: protected */
        public final String b(Charset charset) {
            return new String(this.bytes, h(), b(), charset);
        }

        public final boolean e() {
            int h = h();
            return ax.a(this.bytes, h, b() + h);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof f) || b() != ((f) obj).b()) {
                return false;
            }
            if (b() == 0) {
                return true;
            }
            if (!(obj instanceof g)) {
                return obj.equals(this);
            }
            g gVar = (g) obj;
            int g2 = g();
            int g3 = gVar.g();
            if (g2 == 0 || g3 == 0 || g2 == g3) {
                return a((f) gVar, 0, b());
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(f fVar, int i, int i2) {
            if (i2 <= fVar.b()) {
                int i3 = i + i2;
                if (i3 > fVar.b()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + fVar.b());
                } else if (!(fVar instanceof g)) {
                    return fVar.a(i, i3).equals(a(0, i2));
                } else {
                    g gVar = (g) fVar;
                    byte[] bArr = this.bytes;
                    byte[] bArr2 = gVar.bytes;
                    int h = h() + i2;
                    int h2 = h();
                    int h3 = gVar.h() + i;
                    while (h2 < h) {
                        if (bArr[h2] != bArr2[h3]) {
                            return false;
                        }
                        h2++;
                        h3++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i2 + b());
            }
        }

        /* access modifiers changed from: protected */
        public final int a(int i, int i2, int i3) {
            return u.a(i, this.bytes, h() + i2, i3);
        }

        public final g f() {
            return g.a(this.bytes, h(), b(), true);
        }
    }

    private static final class b extends g {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        b(byte[] bArr, int i, int i2) {
            super(bArr);
            b(i, i + i2, bArr.length);
            this.bytesOffset = i;
            this.bytesLength = i2;
        }

        public byte a(int i) {
            b(i, b());
            return this.bytes[this.bytesOffset + i];
        }

        public int b() {
            return this.bytesLength;
        }

        /* access modifiers changed from: protected */
        public int h() {
            return this.bytesOffset;
        }

        /* access modifiers changed from: protected */
        public void a(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.bytes, h() + i, bArr, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            return f.b(c());
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }
    }
}
