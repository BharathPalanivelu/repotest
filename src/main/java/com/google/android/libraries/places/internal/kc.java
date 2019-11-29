package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

public abstract class kc implements Serializable, Iterable<Byte> {

    /* renamed from: a  reason: collision with root package name */
    public static final kc f12862a = new kj(kx.f12919b);

    /* renamed from: c  reason: collision with root package name */
    private static final kh f12863c = (jz.a() ? new mi((byte) 0) : new lt((byte) 0));

    /* renamed from: b  reason: collision with root package name */
    public int f12864b;

    kc() {
        this.f12864b = 0;
    }

    static int a(byte b2) {
        return b2 & 255;
    }

    public abstract byte a(int i);

    public abstract int a();

    /* access modifiers changed from: protected */
    public abstract int a(int i, int i2, int i3);

    public abstract kc a(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String a(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void a(kb kbVar) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr, int i, int i2, int i3);

    /* access modifiers changed from: package-private */
    public abstract boolean a(kc kcVar, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract byte b(int i);

    public abstract boolean d();

    public abstract boolean equals(Object obj);

    static kc a(byte[] bArr) {
        return new kj(bArr);
    }

    public static kc a(String str) {
        return new kj(str.getBytes(kx.f12918a));
    }

    public final byte[] b() {
        int a2 = a();
        if (a2 == 0) {
            return kx.f12919b;
        }
        byte[] bArr = new byte[a2];
        a(bArr, 0, 0, a2);
        return bArr;
    }

    public final String c() {
        return a() == 0 ? "" : a(kx.f12918a);
    }

    public final int hashCode() {
        int i = this.f12864b;
        if (i == 0) {
            int a2 = a();
            i = a(a2, 0, a2);
            if (i == 0) {
                i = 1;
            }
            this.f12864b = i;
        }
        return i;
    }

    static lu c(int i) {
        return new lu(i, (byte) 0);
    }

    static int b(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(a())});
    }

    public /* synthetic */ Iterator iterator() {
        return new kd(this);
    }

    static {
        new ke();
    }

    kc(byte b2) {
        this();
    }
}
