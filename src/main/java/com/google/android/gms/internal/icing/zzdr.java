package com.google.android.gms.internal.icing;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdr extends zzch<Integer> implements zzdx<Integer>, zzfg, RandomAccess {
    private static final zzdr zzks;
    private int size;
    private int[] zzkt;

    zzdr() {
        this(new int[10], 0);
    }

    private zzdr(int[] iArr, int i) {
        this.zzkt = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzai();
        if (i2 >= i) {
            int[] iArr = this.zzkt;
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
        if (!(obj instanceof zzdr)) {
            return super.equals(obj);
        }
        zzdr zzdr = (zzdr) obj;
        if (this.size != zzdr.size) {
            return false;
        }
        int[] iArr = zzdr.zzkt;
        for (int i = 0; i < this.size; i++) {
            if (this.zzkt[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzkt[i2];
        }
        return i;
    }

    public final int getInt(int i) {
        zzh(i);
        return this.zzkt[i];
    }

    public final int size() {
        return this.size;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzai();
        zzdq.checkNotNull(collection);
        if (!(collection instanceof zzdr)) {
            return super.addAll(collection);
        }
        zzdr zzdr = (zzdr) collection;
        int i = zzdr.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzkt;
            if (i3 > iArr.length) {
                this.zzkt = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzdr.zzkt, 0, this.zzkt, this.size, zzdr.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzai();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzkt[i]))) {
                int[] iArr = this.zzkt;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzh(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
    }

    private final String zzi(int i) {
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
        zzai();
        zzh(i);
        int[] iArr = this.zzkt;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzai();
        zzh(i);
        int[] iArr = this.zzkt;
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
        int intValue = ((Integer) obj).intValue();
        zzai();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                int[] iArr = this.zzkt;
                if (i2 < iArr.length) {
                    System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
                } else {
                    int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    System.arraycopy(this.zzkt, i, iArr2, i + 1, this.size - i);
                    this.zzkt = iArr2;
                }
                this.zzkt[i] = intValue;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzi(i));
    }

    public final /* synthetic */ zzdx zzj(int i) {
        if (i >= this.size) {
            return new zzdr(Arrays.copyOf(this.zzkt, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzdr zzdr = new zzdr(new int[0], 0);
        zzks = zzdr;
        zzdr.zzah();
    }
}
