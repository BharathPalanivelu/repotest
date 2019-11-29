package androidx.k.a.a;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<Charset> f2405a = new ThreadLocal<Charset>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Charset initialValue() {
            return Charset.forName("UTF-8");
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<CharsetDecoder> f2406d = new ThreadLocal<CharsetDecoder>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public CharsetDecoder initialValue() {
            return Charset.forName("UTF-8").newDecoder();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadLocal<CharBuffer> f2407e = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    protected int f2408b;

    /* renamed from: c  reason: collision with root package name */
    protected ByteBuffer f2409c;

    /* access modifiers changed from: protected */
    public int b(int i) {
        int i2 = this.f2408b;
        int i3 = i2 - this.f2409c.getInt(i2);
        if (i < this.f2409c.getShort(i3)) {
            return this.f2409c.getShort(i3 + i);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int c(int i) {
        return i + this.f2409c.getInt(i);
    }

    /* access modifiers changed from: protected */
    public int d(int i) {
        int i2 = i + this.f2408b;
        return this.f2409c.getInt(i2 + this.f2409c.getInt(i2));
    }

    /* access modifiers changed from: protected */
    public int e(int i) {
        int i2 = i + this.f2408b;
        return i2 + this.f2409c.getInt(i2) + 4;
    }
}
