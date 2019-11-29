package com.google.android.gms.internal.icing;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzch<E> extends AbstractList<E> implements zzdx<E> {
    private boolean zzfu = true;

    zzch() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public boolean add(E e2) {
        zzai();
        return super.add(e2);
    }

    public void add(int i, E e2) {
        zzai();
        super.add(i, e2);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzai();
        return super.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzai();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzai();
        super.clear();
    }

    public boolean zzag() {
        return this.zzfu;
    }

    public final void zzah() {
        this.zzfu = false;
    }

    public E remove(int i) {
        zzai();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        zzai();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        zzai();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzai();
        return super.retainAll(collection);
    }

    public E set(int i, E e2) {
        zzai();
        return super.set(i, e2);
    }

    /* access modifiers changed from: protected */
    public final void zzai() {
        if (!this.zzfu) {
            throw new UnsupportedOperationException();
        }
    }
}
