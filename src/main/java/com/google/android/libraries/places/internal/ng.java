package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Arrays;

public final class ng {

    /* renamed from: a  reason: collision with root package name */
    public static final ng f13014a = new ng(0, new int[0], new Object[0], false);

    /* renamed from: b  reason: collision with root package name */
    public int f13015b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f13016c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f13017d;

    /* renamed from: e  reason: collision with root package name */
    public int f13018e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13019f;

    static ng a(ng ngVar, ng ngVar2) {
        int i = ngVar.f13015b + ngVar2.f13015b;
        int[] copyOf = Arrays.copyOf(ngVar.f13016c, i);
        System.arraycopy(ngVar2.f13016c, 0, copyOf, ngVar.f13015b, ngVar2.f13015b);
        Object[] copyOf2 = Arrays.copyOf(ngVar.f13017d, i);
        System.arraycopy(ngVar2.f13017d, 0, copyOf2, ngVar.f13015b, ngVar2.f13015b);
        return new ng(i, copyOf, copyOf2, true);
    }

    ng() {
        this(0, new int[8], new Object[8], true);
    }

    private ng(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f13018e = -1;
        this.f13015b = i;
        this.f13016c = iArr;
        this.f13017d = objArr;
        this.f13019f = z;
    }

    public final void a(nt ntVar) throws IOException {
        if (this.f13015b != 0) {
            if (ntVar.a() == nu.ASCENDING) {
                for (int i = 0; i < this.f13015b; i++) {
                    a(this.f13016c[i], this.f13017d[i], ntVar);
                }
                return;
            }
            for (int i2 = this.f13015b - 1; i2 >= 0; i2--) {
                a(this.f13016c[i2], this.f13017d[i2], ntVar);
            }
        }
    }

    private static void a(int i, Object obj, nt ntVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            ntVar.a(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            ntVar.d(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            ntVar.a(i2, (kc) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                ntVar.d(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(ld.c());
        } else if (ntVar.a() == nu.ASCENDING) {
            ntVar.a(i2);
            ((ng) obj).a(ntVar);
            ntVar.b(i2);
        } else {
            ntVar.b(i2);
            ((ng) obj).a(ntVar);
            ntVar.a(i2);
        }
    }

    public final int a() {
        int i;
        int i2 = this.f13018e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f13015b; i4++) {
            int i5 = this.f13016c[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = kk.e(i6, ((Long) this.f13017d[i4]).longValue());
            } else if (i7 == 1) {
                i = kk.g(i6, ((Long) this.f13017d[i4]).longValue());
            } else if (i7 == 2) {
                i = kk.c(i6, (kc) this.f13017d[i4]);
            } else if (i7 == 3) {
                i = (kk.e(i6) << 1) + ((ng) this.f13017d[i4]).a();
            } else if (i7 == 5) {
                i = kk.i(i6, ((Integer) this.f13017d[i4]).intValue());
            } else {
                throw new IllegalStateException(ld.c());
            }
            i3 += i;
        }
        this.f13018e = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ng)) {
            return false;
        }
        ng ngVar = (ng) obj;
        int i = this.f13015b;
        if (i == ngVar.f13015b) {
            int[] iArr = this.f13016c;
            int[] iArr2 = ngVar.f13016c;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.f13017d;
                Object[] objArr2 = ngVar.f13017d;
                int i3 = this.f13015b;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.f13015b;
        int i2 = (i + 527) * 31;
        int[] iArr = this.f13016c;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.f13017d;
        int i7 = this.f13015b;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }
}
