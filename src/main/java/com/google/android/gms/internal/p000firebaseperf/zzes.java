package com.google.android.gms.internal.p000firebaseperf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzes  reason: invalid package */
final class zzes extends zzdk<Integer> implements zzev, zzgj, RandomAccess {
    private static final zzes zzrj;
    private int size;
    private int[] zzrk;

    public static zzes zzhs() {
        return zzrj;
    }

    zzes() {
        this(new int[10], 0);
    }

    private zzes(int[] iArr, int i) {
        this.zzrk = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzgg();
        if (i2 >= i) {
            int[] iArr = this.zzrk;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzes)) {
            return super.equals(obj);
        }
        zzes zzes = (zzes) obj;
        if (this.size != zzes.size) {
            return false;
        }
        int[] iArr = zzes.zzrk;
        for (int i = 0; i < this.size; i++) {
            if (this.zzrk[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzrk[i2];
        }
        return i;
    }

    /* renamed from: zzak */
    public final zzev zzao(int i) {
        if (i >= this.size) {
            return new zzes(Arrays.copyOf(this.zzrk, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final int getInt(int i) {
        zzam(i);
        return this.zzrk[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzal(int i) {
        zzs(this.size, i);
    }

    private final void zzs(int i, int i2) {
        zzgg();
        if (i >= 0) {
            int i3 = this.size;
            if (i <= i3) {
                int[] iArr = this.zzrk;
                if (i3 < iArr.length) {
                    System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
                } else {
                    int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    System.arraycopy(this.zzrk, i, iArr2, i + 1, this.size - i);
                    this.zzrk = iArr2;
                }
                this.zzrk[i] = i2;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzan(i));
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzgg();
        zzer.checkNotNull(collection);
        if (!(collection instanceof zzes)) {
            return super.addAll(collection);
        }
        zzes zzes = (zzes) collection;
        int i = zzes.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzrk;
            if (i3 > iArr.length) {
                this.zzrk = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzes.zzrk, 0, this.zzrk, this.size, zzes.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzgg();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzrk[i]))) {
                int[] iArr = this.zzrk;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzam(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzan(i));
        }
    }

    private final String zzan(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzgg();
        zzam(i);
        int[] iArr = this.zzrk;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzgg();
        zzam(i);
        int[] iArr = this.zzrk;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzs(i, ((Integer) obj).intValue());
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzes zzes = new zzes(new int[0], 0);
        zzrj = zzes;
        zzes.zzgf();
    }
}
