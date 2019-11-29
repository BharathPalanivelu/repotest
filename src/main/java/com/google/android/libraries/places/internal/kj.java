package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.nio.charset.Charset;

class kj extends kc {
    public static final long serialVersionUID = 1;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f12870c;

    kj(byte[] bArr) {
        super((byte) 0);
        if (bArr != null) {
            this.f12870c = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int e() {
        return 0;
    }

    public byte a(int i) {
        return this.f12870c[i];
    }

    /* access modifiers changed from: package-private */
    public byte b(int i) {
        return this.f12870c[i];
    }

    public int a() {
        return this.f12870c.length;
    }

    public final kc a(int i, int i2) {
        int b2 = b(i, i2, a());
        if (b2 == 0) {
            return kc.f12862a;
        }
        return new kg(this.f12870c, e() + i, b2);
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f12870c, 0, bArr, 0, i3);
    }

    /* access modifiers changed from: package-private */
    public final void a(kb kbVar) throws IOException {
        kbVar.a(this.f12870c, e(), a());
    }

    /* access modifiers changed from: protected */
    public final String a(Charset charset) {
        return new String(this.f12870c, e(), a(), charset);
    }

    public final boolean d() {
        int e2 = e();
        return nm.a(this.f12870c, e2, a() + e2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kc) || a() != ((kc) obj).a()) {
            return false;
        }
        if (a() == 0) {
            return true;
        }
        if (!(obj instanceof kj)) {
            return obj.equals(this);
        }
        kj kjVar = (kj) obj;
        int i = this.f12864b;
        int i2 = kjVar.f12864b;
        if (i == 0 || i2 == 0 || i == i2) {
            return a((kc) kjVar, 0, a());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(kc kcVar, int i, int i2) {
        if (i2 <= kcVar.a()) {
            int i3 = i2 + 0;
            if (i3 > kcVar.a()) {
                int a2 = kcVar.a();
                StringBuilder sb = new StringBuilder(59);
                sb.append("Ran off end of other: 0");
                sb.append(", ");
                sb.append(i2);
                sb.append(", ");
                sb.append(a2);
                throw new IllegalArgumentException(sb.toString());
            } else if (!(kcVar instanceof kj)) {
                return kcVar.a(0, i3).equals(a(0, i2));
            } else {
                kj kjVar = (kj) kcVar;
                if (nk.a(this.f12870c, e(), kjVar.f12870c, kjVar.e(), i2) == -1) {
                    return true;
                }
                return false;
            }
        } else {
            int a3 = a();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i2);
            sb2.append(a3);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    public final int a(int i, int i2, int i3) {
        return kx.a(i, this.f12870c, e(), i3);
    }
}
