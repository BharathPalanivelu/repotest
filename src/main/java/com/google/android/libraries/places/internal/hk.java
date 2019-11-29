package com.google.android.libraries.places.internal;

import java.io.Serializable;
import java.lang.Comparable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class hk<C extends Comparable> extends hl implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final hk<Comparable> f6719a = new hk<>(gx.f12639b, gv.f12638b);
    public static final long serialVersionUID = 0;

    /* renamed from: b  reason: collision with root package name */
    private final gu<C> f6720b;

    /* renamed from: c  reason: collision with root package name */
    private final gu<C> f6721c;

    private static <C extends Comparable<?>> hk<C> a(gu<C> guVar, gu<C> guVar2) {
        return new hk<>(guVar, guVar2);
    }

    public static <C extends Comparable<?>> hk<C> a(C c2, C c3) {
        return a(gu.b(c2), (gu) new gw(c3));
    }

    public static <C extends Comparable<?>> hk<C> a(C c2) {
        return a(gu.b(c2), (gu) gv.f12638b);
    }

    private hk(gu<C> guVar, gu<C> guVar2) {
        this.f6720b = (gu) go.a(guVar);
        this.f6721c = (gu) go.a(guVar2);
        if (guVar.compareTo(guVar2) > 0 || guVar == gv.f12638b || guVar2 == gx.f12639b) {
            String valueOf = String.valueOf(b((gu<?>) guVar, (gu<?>) guVar2));
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid range: ".concat(valueOf) : new String("Invalid range: "));
        }
    }

    public final boolean b(C c2) {
        go.a(c2);
        return this.f6720b.a(c2) && !this.f6721c.a(c2);
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof hk) {
            hk hkVar = (hk) obj;
            if (!this.f6720b.equals(hkVar.f6720b) || !this.f6721c.equals(hkVar.f6721c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f6720b.hashCode() * 31) + this.f6721c.hashCode();
    }

    public final String toString() {
        return b((gu<?>) this.f6720b, (gu<?>) this.f6721c);
    }

    private static String b(gu<?> guVar, gu<?> guVar2) {
        StringBuilder sb = new StringBuilder(16);
        guVar.a(sb);
        sb.append("..");
        guVar2.b(sb);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final Object readResolve() {
        return equals(f6719a) ? f6719a : this;
    }

    static int b(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }
}
