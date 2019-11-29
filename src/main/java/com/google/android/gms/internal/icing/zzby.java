package com.google.android.gms.internal.icing;

import com.litesuits.orm.db.assit.SQLBuilder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzby<T> extends zzbw<T> {
    private final T zzdr;

    zzby(T t) {
        this.zzdr = t;
    }

    public final boolean isPresent() {
        return true;
    }

    public final T get() {
        return this.zzdr;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzby) {
            return this.zzdr.equals(((zzby) obj).zzdr);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzdr.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzdr);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(SQLBuilder.PARENTHESES_RIGHT);
        return sb.toString();
    }
}
