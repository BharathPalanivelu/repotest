package com.google.android.libraries.places.internal;

import com.g.a.a.g;
import java.io.IOException;

final class hy extends ia {

    /* renamed from: c  reason: collision with root package name */
    private final char[] f12664c;

    hy(String str, String str2) {
        this(new hx(str, str2.toCharArray()));
    }

    private hy(hx hxVar) {
        super(hxVar, (Character) null);
        this.f12664c = new char[512];
        go.a(hxVar.f6737a.length == 16);
        for (int i = 0; i < 256; i++) {
            this.f12664c[i] = hxVar.f6737a[i >>> 4];
            this.f12664c[i | 256] = hxVar.f6737a[i & 15];
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        go.a(appendable);
        go.a(i, i + i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            byte b2 = bArr[i + i3] & 255;
            appendable.append(this.f12664c[b2]);
            appendable.append(this.f12664c[b2 | g.BYTE]);
        }
    }
}
