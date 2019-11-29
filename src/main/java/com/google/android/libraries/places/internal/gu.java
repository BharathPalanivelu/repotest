package com.google.android.libraries.places.internal;

import java.io.Serializable;
import java.lang.Comparable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class gu<C extends Comparable> implements Serializable, Comparable<gu<C>> {
    public static final long serialVersionUID = 0;
    @NullableDecl

    /* renamed from: a  reason: collision with root package name */
    public final C f6711a;

    gu(@NullableDecl C c2) {
        this.f6711a = c2;
    }

    /* access modifiers changed from: package-private */
    public abstract void a(StringBuilder sb);

    /* access modifiers changed from: package-private */
    public abstract boolean a(C c2);

    /* access modifiers changed from: package-private */
    public abstract void b(StringBuilder sb);

    public abstract int hashCode();

    /* renamed from: a */
    public int compareTo(gu<C> guVar) {
        if (guVar == gx.f12639b) {
            return 1;
        }
        if (guVar == gv.f12638b) {
            return -1;
        }
        int b2 = hk.b((Comparable) this.f6711a, (Comparable) guVar.f6711a);
        if (b2 != 0) {
            return b2;
        }
        boolean z = this instanceof gw;
        if (z == (guVar instanceof gw)) {
            return 0;
        }
        if (z) {
            return 1;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof gu) {
            try {
                if (compareTo((gu) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    static <C extends Comparable> gu<C> b(C c2) {
        return new gy(c2);
    }
}
