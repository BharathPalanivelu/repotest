package com.google.android.libraries.places.internal;

final class gx extends gu<Comparable<?>> {

    /* renamed from: b  reason: collision with root package name */
    public static final gx f12639b = new gx();
    public static final long serialVersionUID = 0;

    private gx() {
        super(null);
    }

    public final int a(gu<Comparable<?>> guVar) {
        return guVar == this ? 0 : -1;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(Comparable<?> comparable) {
        return true;
    }

    public final String toString() {
        return "-∞";
    }

    /* access modifiers changed from: package-private */
    public final void a(StringBuilder sb) {
        sb.append("(-∞");
    }

    /* access modifiers changed from: package-private */
    public final void b(StringBuilder sb) {
        throw new AssertionError();
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    private final Object readResolve() {
        return f12639b;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return compareTo((gu) obj);
    }
}
