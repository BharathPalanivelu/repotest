package com.google.android.libraries.places.internal;

final class lo extends lm {
    lo() {
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj, long j) {
        b(obj, j).b();
    }

    /* access modifiers changed from: package-private */
    public final <E> void a(Object obj, Object obj2, long j) {
        lc b2 = b(obj, j);
        lc b3 = b(obj2, j);
        int size = b2.size();
        int size2 = b3.size();
        if (size > 0 && size2 > 0) {
            if (!b2.a()) {
                b2 = b2.b(size2 + size);
            }
            b2.addAll(b3);
        }
        if (size > 0) {
            b3 = b2;
        }
        nk.a(obj, j, (Object) b3);
    }

    private static <E> lc<E> b(Object obj, long j) {
        return (lc) nk.f(obj, j);
    }
}
