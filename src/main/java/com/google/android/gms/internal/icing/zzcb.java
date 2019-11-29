package com.google.android.gms.internal.icing;

import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzcb<T> implements zzbx<T>, Serializable {
    @NullableDecl
    private final T zzdu;

    zzcb(@NullableDecl T t) {
        this.zzdu = t;
    }

    public final T get() {
        return this.zzdu;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof zzcb)) {
            return false;
        }
        T t = this.zzdu;
        T t2 = ((zzcb) obj).zzdu;
        if (t == t2) {
            return true;
        }
        if (t == null || !t.equals(t2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzdu});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzdu);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(valueOf);
        sb.append(SQLBuilder.PARENTHESES_RIGHT);
        return sb.toString();
    }
}
