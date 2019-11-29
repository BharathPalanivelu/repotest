package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.math.RoundingMode;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class ia extends hw {

    /* renamed from: b  reason: collision with root package name */
    public final hx f6744b;
    @NullableDecl

    /* renamed from: c  reason: collision with root package name */
    private final Character f6745c;

    ia(String str, String str2, @NullableDecl Character ch) {
        this(new hx(str, str2.toCharArray()), ch);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if ((r2 < r5.f6742f.length && r5.f6742f[r2] != -1) == false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    ia(com.google.android.libraries.places.internal.hx r5, @org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Character r6) {
        /*
            r4 = this;
            r4.<init>()
            java.lang.Object r0 = com.google.android.libraries.places.internal.go.a(r5)
            com.google.android.libraries.places.internal.hx r0 = (com.google.android.libraries.places.internal.hx) r0
            r4.f6744b = r0
            r0 = 0
            r1 = 1
            if (r6 == 0) goto L_0x0024
            char r2 = r6.charValue()
            byte[] r3 = r5.f6742f
            int r3 = r3.length
            if (r2 >= r3) goto L_0x0021
            byte[] r5 = r5.f6742f
            byte r5 = r5[r2]
            r2 = -1
            if (r5 == r2) goto L_0x0021
            r5 = 1
            goto L_0x0022
        L_0x0021:
            r5 = 0
        L_0x0022:
            if (r5 != 0) goto L_0x0025
        L_0x0024:
            r0 = 1
        L_0x0025:
            java.lang.String r5 = "Padding character %s was already in alphabet"
            com.google.android.libraries.places.internal.go.a((boolean) r0, (java.lang.String) r5, (java.lang.Object) r6)
            r4.f6745c = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.ia.<init>(com.google.android.libraries.places.internal.hx, java.lang.Character):void");
    }

    /* access modifiers changed from: package-private */
    public final int a(int i) {
        return this.f6744b.f6740d * jq.a(i, this.f6744b.f6741e, RoundingMode.CEILING);
    }

    /* access modifiers changed from: package-private */
    public void a(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        go.a(appendable);
        go.a(i, i + i2, bArr.length);
        int i3 = 0;
        while (i3 < i2) {
            b(appendable, bArr, i + i3, Math.min(this.f6744b.f6741e, i2 - i3));
            i3 += this.f6744b.f6741e;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        go.a(appendable);
        go.a(i, i + i2, bArr.length);
        int i3 = 0;
        go.a(i2 <= this.f6744b.f6741e);
        long j = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j = (j | ((long) (bArr[i + i4] & 255))) << 8;
        }
        int i5 = ((i2 + 1) << 3) - this.f6744b.f6739c;
        while (i3 < (i2 << 3)) {
            appendable.append(this.f6744b.f6737a[((int) (j >>> (i5 - i3))) & this.f6744b.f6738b]);
            i3 += this.f6744b.f6739c;
        }
        if (this.f6745c != null) {
            while (i3 < (this.f6744b.f6741e << 3)) {
                appendable.append(this.f6745c.charValue());
                i3 += this.f6744b.f6739c;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.f6744b.toString());
        if (8 % this.f6744b.f6739c != 0) {
            if (this.f6745c == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.f6745c);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof ia) {
            ia iaVar = (ia) obj;
            if (!this.f6744b.equals(iaVar.f6744b) || !hj.a((Object) this.f6745c, (Object) iaVar.f6745c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f6744b.hashCode() ^ hj.a(this.f6745c);
    }
}
