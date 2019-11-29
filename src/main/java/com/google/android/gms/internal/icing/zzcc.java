package com.google.android.gms.internal.icing;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.litesuits.orm.db.assit.SQLBuilder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzcc<T> implements zzbx<T> {
    @NullableDecl
    private T value;
    private volatile zzbx<T> zzds;
    private volatile boolean zzdt;

    zzcc(zzbx<T> zzbx) {
        this.zzds = (zzbx) zzbv.checkNotNull(zzbx);
    }

    public final T get() {
        if (!this.zzdt) {
            synchronized (this) {
                if (!this.zzdt) {
                    T t = this.zzds.get();
                    this.value = t;
                    this.zzdt = true;
                    this.zzds = null;
                    return t;
                }
            }
        }
        return this.value;
    }

    public final String toString() {
        Object obj = this.zzds;
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
