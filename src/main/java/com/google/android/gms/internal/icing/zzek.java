package com.google.android.gms.internal.icing;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzek extends zzch<Long> implements zzdx<Long>, zzfg, RandomAccess {
    private static final zzek zzlu;
    private int size;
    private long[] zzlv;

    public static zzek zzch() {
        return zzlu;
    }

    zzek() {
        this(new long[10], 0);
    }

    private zzek(long[] jArr, int i) {
        this.zzlv = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzai();
        if (i2 >= i) {
            long[] jArr = this.zzlv;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
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
        if (!(obj instanceof zzek)) {
            return super.equals(obj);
        }
        zzek zzek = (zzek) obj;
        if (this.size != zzek.size) {
            return false;
        }
        long[] jArr = zzek.zzlv;
        for (int i = 0; i < this.size; i++) {
            if (this.zzlv[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzdq.zzk(this.zzlv[i2]);
        }
        return i;
    }

    public final long getLong(int i) {
        zzh(i);
        return this.zzlv[i];
    }

    public final int size() {
        return this.size;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzai();
        zzdq.checkNotNull(collection);
        if (!(collection instanceof zzek)) {
            return super.addAll(collection);
        }
        zzek zzek = (zzek) collection;
        int i = zzek.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzlv;
            if (i3 > jArr.length) {
                this.zzlv = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzek.zzlv, 0, this.zzlv, this.size, zzek.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzai();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzlv[i]))) {
                long[] jArr = this.zzlv;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
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
        long longValue = ((Long) obj).longValue();
        zzai();
        zzh(i);
        long[] jArr = this.zzlv;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        zzai();
        zzh(i);
        long[] jArr = this.zzlv;
        long j = jArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzai();
        if (i >= 0) {
            int i2 = this.size;
            if (i <= i2) {
                long[] jArr = this.zzlv;
                if (i2 < jArr.length) {
                    System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
                } else {
                    long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
                    System.arraycopy(jArr, 0, jArr2, 0, i);
                    System.arraycopy(this.zzlv, i, jArr2, i + 1, this.size - i);
                    this.zzlv = jArr2;
                }
                this.zzlv[i] = longValue;
                this.size++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(zzi(i));
    }

    public final /* synthetic */ zzdx zzj(int i) {
        if (i >= this.size) {
            return new zzek(Arrays.copyOf(this.zzlv, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzek zzek = new zzek(new long[0], 0);
        zzlu = zzek;
        zzek.zzah();
    }
}
