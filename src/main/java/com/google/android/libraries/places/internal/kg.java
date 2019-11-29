package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

final class kg extends kj {
    public static final long serialVersionUID = 1;

    /* renamed from: d  reason: collision with root package name */
    private final int f12868d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12869e;

    kg(byte[] bArr, int i, int i2) {
        super(bArr);
        b(i, i + i2, bArr.length);
        this.f12868d = i;
        this.f12869e = i2;
    }

    public final byte a(int i) {
        int a2 = a();
        if (((a2 - (i + 1)) | i) >= 0) {
            return this.f12870c[this.f12868d + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(a2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: package-private */
    public final byte b(int i) {
        return this.f12870c[this.f12868d + i];
    }

    public final int a() {
        return this.f12869e;
    }

    /* access modifiers changed from: protected */
    public final int e() {
        return this.f12868d;
    }

    /* access modifiers changed from: protected */
    public final void a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f12870c, e(), bArr, 0, i3);
    }

    /* access modifiers changed from: package-private */
    public final Object writeReplace() {
        return kc.a(b());
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }
}
