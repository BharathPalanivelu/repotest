package com.google.android.libraries.places.internal;

import com.g.a.a.g;
import java.io.IOException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class hz extends ia {
    hz(String str, String str2, @NullableDecl Character ch) {
        this(new hx(str, str2.toCharArray()), ch);
    }

    private hz(hx hxVar, @NullableDecl Character ch) {
        super(hxVar, ch);
        go.a(hxVar.f6737a.length == 64);
    }

    /* access modifiers changed from: package-private */
    public final void a(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        go.a(appendable);
        int i3 = i + i2;
        go.a(i, i3, bArr.length);
        while (i2 >= 3) {
            int i4 = i + 1;
            int i5 = i4 + 1;
            byte b2 = ((bArr[i] & 255) << 16) | ((bArr[i4] & 255) << 8);
            byte b3 = b2 | (bArr[i5] & 255);
            appendable.append(this.f6744b.f6737a[b3 >>> 18]);
            appendable.append(this.f6744b.f6737a[(b3 >>> g.ZERO_TAG) & 63]);
            appendable.append(this.f6744b.f6737a[(b3 >>> 6) & 63]);
            appendable.append(this.f6744b.f6737a[b3 & 63]);
            i2 -= 3;
            i = i5 + 1;
        }
        if (i < i3) {
            b(appendable, bArr, i, i3 - i);
        }
    }
}
