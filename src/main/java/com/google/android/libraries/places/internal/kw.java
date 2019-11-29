package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class kw extends jy<Integer> implements la, mk, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final kw f12915b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f12916c;

    /* renamed from: d  reason: collision with root package name */
    private int f12917d;

    kw() {
        this(new int[10], 0);
    }

    private kw(int[] iArr, int i) {
        this.f12916c = iArr;
        this.f12917d = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        c();
        if (i2 >= i) {
            int[] iArr = this.f12916c;
            System.arraycopy(iArr, i2, iArr, i, this.f12917d - i2);
            this.f12917d -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kw)) {
            return super.equals(obj);
        }
        kw kwVar = (kw) obj;
        if (this.f12917d != kwVar.f12917d) {
            return false;
        }
        int[] iArr = kwVar.f12916c;
        for (int i = 0; i < this.f12917d; i++) {
            if (this.f12916c[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f12917d; i2++) {
            i = (i * 31) + this.f12916c[i2];
        }
        return i;
    }

    public final int a(int i) {
        c(i);
        return this.f12916c[i];
    }

    public final int size() {
        return this.f12917d;
    }

    private final void a(int i, int i2) {
        c();
        if (i >= 0) {
            int i3 = this.f12917d;
            if (i <= i3) {
                int[] iArr = this.f12916c;
                if (i3 < iArr.length) {
                    System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
                } else {
                    int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    System.arraycopy(this.f12916c, i, iArr2, i + 1, this.f12917d - i);
                    this.f12916c = iArr2;
                }
                this.f12916c[i] = i2;
                this.f12917d++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(d(i));
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        c();
        kx.a(collection);
        if (!(collection instanceof kw)) {
            return super.addAll(collection);
        }
        kw kwVar = (kw) collection;
        int i = kwVar.f12917d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f12917d;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f12916c;
            if (i3 > iArr.length) {
                this.f12916c = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(kwVar.f12916c, 0, this.f12916c, this.f12917d, kwVar.f12917d);
            this.f12917d = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.f12917d; i++) {
            if (obj.equals(Integer.valueOf(this.f12916c[i]))) {
                int[] iArr = this.f12916c;
                System.arraycopy(iArr, i + 1, iArr, i, (this.f12917d - i) - 1);
                this.f12917d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void c(int i) {
        if (i < 0 || i >= this.f12917d) {
            throw new IndexOutOfBoundsException(d(i));
        }
    }

    private final String d(int i) {
        int i2 = this.f12917d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        c();
        c(i);
        int[] iArr = this.f12916c;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        c();
        c(i);
        int[] iArr = this.f12916c;
        int i2 = iArr[i];
        int i3 = this.f12917d;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.f12917d--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Integer) obj).intValue());
    }

    public final /* synthetic */ lc b(int i) {
        if (i >= this.f12917d) {
            return new kw(Arrays.copyOf(this.f12916c, i), this.f12917d);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(a(i));
    }

    static {
        kw kwVar = new kw(new int[0], 0);
        f12915b = kwVar;
        kwVar.f12858a = false;
    }
}
