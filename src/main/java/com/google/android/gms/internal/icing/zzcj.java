package com.google.android.gms.internal.icing;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzcj extends zzch<Boolean> implements zzdx<Boolean>, zzfg, RandomAccess {
    private static final zzcj zzfv;
    private int size;
    private boolean[] zzfw;

    public static zzcj zzaj() {
        return zzfv;
    }

    zzcj() {
        this(new boolean[10], 0);
    }

    private zzcj(boolean[] zArr, int i) {
        this.zzfw = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzai();
        if (i2 >= i) {
            boolean[] zArr = this.zzfw;
            System.arraycopy(zArr, i2, zArr, i, this.size - i2);
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
        if (!(obj instanceof zzcj)) {
            return super.equals(obj);
        }
        zzcj zzcj = (zzcj) obj;
        if (this.size != zzcj.size) {
            return false;
        }
        boolean[] zArr = zzcj.zzfw;
        for (int i = 0; i < this.size; i++) {
            if (this.zzfw[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzdq.zzg(this.zzfw[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzai();
        zzdq.checkNotNull(collection);
        if (!(collection instanceof zzcj)) {
            return super.addAll(collection);
        }
        zzcj zzcj = (zzcj) collection;
        int i = zzcj.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zzfw;
            if (i3 > zArr.length) {
                this.zzfw = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zzcj.zzfw, 0, this.zzfw, this.size, zzcj.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzai();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzfw[i]))) {
                boolean[] zArr = this.zzfw;
                System.arraycopy(zArr, i + 1, zArr, i, (this.size - i) - 1);
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzai();
        zzh(i);
        boolean[] zArr = this.zzfw;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i) {
        zzai();
        zzh(i);
        boolean[] zArr = this.zzfw;
        boolean z = zArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzai();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                boolean[] zArr = this.zzfw;
                if (i2 < zArr.length) {
                    System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
                } else {
                    boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(zArr, 0, zArr2, 0, i);
                    System.arraycopy(this.zzfw, i, zArr2, i + 1, this.size - i);
                    this.zzfw = zArr2;
                }
                this.zzfw[i] = booleanValue;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzi(i));
    }

    public final /* synthetic */ zzdx zzj(int i) {
        if (i >= this.size) {
            return new zzcj(Arrays.copyOf(this.zzfw, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Boolean.valueOf(this.zzfw[i]);
    }

    static {
        zzcj zzcj = new zzcj(new boolean[0], 0);
        zzfv = zzcj;
        zzcj.zzah();
    }
}
