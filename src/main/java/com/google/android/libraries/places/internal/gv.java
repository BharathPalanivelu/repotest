package com.google.android.libraries.places.internal;

final class gv extends gu<Comparable<?>> {

    /* renamed from: b  reason: collision with root package name */
    public static final gv f12638b = new gv();
    public static final long serialVersionUID = 0;

    private gv() {
        super(null);
    }

    public final int a(gu<Comparable<?>> guVar) {
        return guVar == this ? 0 : 1;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Comparable<?> comparable) {
        return false;
    }

    public final String toString() {
        return "+∞";
    }

    /* access modifiers changed from: package-private */
    public final void a(StringBuilder sb) {
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public final void b(StringBuilder sb) {
        sb.append("+∞)");
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    private final Object readResolve() {
        return f12638b;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return compareTo((gu) obj);
    }
}
