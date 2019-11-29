package com.google.android.gms.internal.p000firebaseperf;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.litesuits.orm.db.assit.SQLBuilder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzm  reason: invalid package */
final class zzm<T> implements zzh<T> {
    private volatile boolean initialized;
    @NullableDecl
    private T value;
    private volatile zzh<T> zzn;

    zzm(zzh<T> zzh) {
        this.zzn = (zzh) zzf.checkNotNull(zzh);
    }

    public final T get() {
        if (!this.initialized) {
            synchronized (this) {
                if (!this.initialized) {
                    T t = this.zzn.get();
                    this.value = t;
                    this.initialized = true;
                    this.zzn = null;
                    return t;
                }
            }
        }
        return this.value;
    }

    public final String toString() {
        Object obj = this.zzn;
        if (obj == null) {
            String valueOf = String.valueOf(this.value);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            obj = sb.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(SQLBuilder.PARENTHESES_RIGHT);
        return sb2.toString();
    }
}
