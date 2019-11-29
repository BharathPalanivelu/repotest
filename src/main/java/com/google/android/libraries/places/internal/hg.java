package com.google.android.libraries.places.internal;

import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class hg<E> extends gz<E> implements Set<E> {
    @NullableDecl
    @RetainedWith
    @LazyInit

    /* renamed from: a  reason: collision with root package name */
    private transient ha<E> f6717a;

    private static <E> hg<E> a(E e2) {
        return new ht(e2);
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return false;
    }

    private static <E> hg<E> a(int i, Object... objArr) {
        while (i != 0) {
            if (i == 1) {
                return a(objArr[0]);
            }
            int a2 = a(i);
            Object[] objArr2 = new Object[a2];
            int i2 = a2 - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object a3 = go.a(objArr[i5], i5);
                int hashCode = a3.hashCode();
                int b2 = go.b(hashCode);
                while (true) {
                    int i6 = b2 & i2;
                    Object obj = objArr2[i6];
                    if (obj != null) {
                        if (obj.equals(a3)) {
                            break;
                        }
                        b2++;
                    } else {
                        objArr[i4] = a3;
                        objArr2[i6] = a3;
                        i3 += hashCode;
                        i4++;
                        break;
                    }
                }
            }
            Arrays.fill(objArr, i4, i, (Object) null);
            if (i4 == 1) {
                return new ht(objArr[0], i3);
            }
            if (a(i4) < a2 / 2) {
                i = i4;
            } else {
                int length = objArr.length;
                if (i4 < (length >> 1) + (length >> 2)) {
                    objArr = Arrays.copyOf(objArr, i4);
                }
                return new hs(objArr, i3, objArr2, i2, i4);
            }
        }
        return hs.f6728a;
    }

    static int a(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (true) {
                double d2 = (double) highestOneBit;
                Double.isNaN(d2);
                if (d2 * 0.7d >= ((double) max)) {
                    return highestOneBit;
                }
                highestOneBit <<= 1;
            }
        } else {
            if (max >= 1073741824) {
                z = false;
            }
            go.a(z, (Object) "collection too large");
            return 1073741824;
        }
    }

    public static <E> hg<E> a(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return hs.f6728a;
        }
        if (length != 1) {
            return a(eArr.length, (Object[]) eArr.clone());
        }
        return a(eArr[0]);
    }

    hg() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof hg) || !g() || !((hg) obj).g() || hashCode() == obj.hashCode()) {
            return go.a((Set<?>) this, obj);
        }
        return false;
    }

    public int hashCode() {
        return go.a((Set<?>) this);
    }

    public ha<E> e() {
        ha<E> haVar = this.f6717a;
        if (haVar != null) {
            return haVar;
        }
        ha<E> h = h();
        this.f6717a = h;
        return h;
    }

    /* access modifiers changed from: package-private */
    public ha<E> h() {
        return ha.b(toArray());
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new hh(toArray());
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
