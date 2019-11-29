package com.google.android.gms.internal.icing;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdd extends zzch<Double> implements zzdx<Double>, zzfg, RandomAccess {
    private static final zzdd zzgq;
    private int size;
    private double[] zzgr;

    public static zzdd zzax() {
        return zzgq;
    }

    zzdd() {
        this(new double[10], 0);
    }

    private zzdd(double[] dArr, int i) {
        this.zzgr = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzai();
        if (i2 >= i) {
            double[] dArr = this.zzgr;
            System.arraycopy(dArr, i2, dArr, i, this.size - i2);
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
        if (!(obj instanceof zzdd)) {
            return super.equals(obj);
        }
        zzdd zzdd = (zzdd) obj;
        if (this.size != zzdd.size) {
            return false;
        }
        double[] dArr = zzdd.zzgr;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzgr[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzdq.zzk(Double.doubleToLongBits(this.zzgr[i2]));
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzai();
        zzdq.checkNotNull(collection);
        if (!(collection instanceof zzdd)) {
            return super.addAll(collection);
        }
        zzdd zzdd = (zzdd) collection;
        int i = zzdd.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.zzgr;
            if (i3 > dArr.length) {
                this.zzgr = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(zzdd.zzgr, 0, this.zzgr, this.size, zzdd.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzai();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzgr[i]))) {
                double[] dArr = this.zzgr;
                System.arraycopy(dArr, i + 1, dArr, i, (this.size - i) - 1);
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
        double doubleValue = ((Double) obj).doubleValue();
        zzai();
        zzh(i);
        double[] dArr = this.zzgr;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzai();
        zzh(i);
        double[] dArr = this.zzgr;
        double d2 = dArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzai();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                double[] dArr = this.zzgr;
                if (i2 < dArr.length) {
                    System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
                } else {
                    double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(dArr, 0, dArr2, 0, i);
                    System.arraycopy(this.zzgr, i, dArr2, i + 1, this.size - i);
                    this.zzgr = dArr2;
                }
                this.zzgr[i] = doubleValue;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzi(i));
    }

    public final /* synthetic */ zzdx zzj(int i) {
        if (i >= this.size) {
            return new zzdd(Arrays.copyOf(this.zzgr, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Double.valueOf(this.zzgr[i]);
    }

    static {
        zzdd zzdd = new zzdd(new double[0], 0);
        zzgq = zzdd;
        zzdd.zzah();
    }
}
