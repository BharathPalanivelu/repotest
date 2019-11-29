package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class lp extends jy<Long> implements lb, mk, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final lp f12940b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f12941c;

    /* renamed from: d  reason: collision with root package name */
    private int f12942d;

    lp() {
        this(new long[10], 0);
    }

    private lp(long[] jArr, int i) {
        this.f12941c = jArr;
        this.f12942d = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        c();
        if (i2 >= i) {
            long[] jArr = this.f12941c;
            System.arraycopy(jArr, i2, jArr, i, this.f12942d - i2);
            this.f12942d -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lp)) {
            return super.equals(obj);
        }
        lp lpVar = (lp) obj;
        if (this.f12942d != lpVar.f12942d) {
            return false;
        }
        long[] jArr = lpVar.f12941c;
        for (int i = 0; i < this.f12942d; i++) {
            if (this.f12941c[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f12942d; i2++) {
            i = (i * 31) + kx.a(this.f12941c[i2]);
        }
        return i;
    }

    public final long a(int i) {
        c(i);
        return this.f12941c[i];
    }

    public final int size() {
        return this.f12942d;
    }

    private final void a(int i, long j) {
        c();
        if (i >= 0) {
            int i2 = this.f12942d;
            if (i <= i2) {
                long[] jArr = this.f12941c;
                if (i2 < jArr.length) {
                    System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
                } else {
                    long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(jArr, 0, jArr2, 0, i);
                    System.arraycopy(this.f12941c, i, jArr2, i + 1, this.f12942d - i);
                    this.f12941c = jArr2;
                }
                this.f12941c[i] = j;
                this.f12942d++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(d(i));
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        c();
        kx.a(collection);
        if (!(collection instanceof lp)) {
            return super.addAll(collection);
        }
        lp lpVar = (lp) collection;
        int i = lpVar.f12942d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f12942d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f12941c;
            if (i3 > jArr.length) {
                this.f12941c = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(lpVar.f12941c, 0, this.f12941c, this.f12942d, lpVar.f12942d);
            this.f12942d = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.f12942d; i++) {
            if (obj.equals(Long.valueOf(this.f12941c[i]))) {
                long[] jArr = this.f12941c;
                System.arraycopy(jArr, i + 1, jArr, i, (this.f12942d - i) - 1);
                this.f12942d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void c(int i) {
        if (i < 0 || i >= this.f12942d) {
            throw new IndexOutOfBoundsException(d(i));
        }
    }

    private final String d(int i) {
        int i2 = this.f12942d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        c();
        c(i);
        long[] jArr = this.f12941c;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        c();
        c(i);
        long[] jArr = this.f12941c;
        long j = jArr[i];
        int i2 = this.f12942d;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.f12942d--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Long) obj).longValue());
    }

    public final /* synthetic */ lc b(int i) {
        if (i >= this.f12942d) {
            return new lp(Arrays.copyOf(this.f12941c, i), this.f12942d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(a(i));
    }

    static {
        lp lpVar = new lp(new long[0], 0);
        f12940b = lpVar;
        lpVar.f12858a = false;
    }
}
