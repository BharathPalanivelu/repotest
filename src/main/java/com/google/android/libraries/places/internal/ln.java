package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.List;

final class ln extends lm {

    /* renamed from: c  reason: collision with root package name */
    private static final Class<?> f12939c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    ln() {
    }

    /* access modifiers changed from: package-private */
    public final void a(Object obj, long j) {
        Object obj2;
        List list = (List) nk.f(obj, j);
        if (list instanceof ll) {
            obj2 = ((ll) list).e();
        } else if (!f12939c.isAssignableFrom(list.getClass())) {
            if (!(list instanceof mk) || !(list instanceof lc)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                lc lcVar = (lc) list;
                if (lcVar.a()) {
                    lcVar.b();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        nk.a(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.libraries.places.internal.lk} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.libraries.places.internal.lk} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.libraries.places.internal.lk} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <L> java.util.List<L> a(java.lang.Object r3, long r4, int r6) {
        /*
            java.util.List r0 = b(r3, r4)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002d
            boolean r1 = r0 instanceof com.google.android.libraries.places.internal.ll
            if (r1 == 0) goto L_0x0014
            com.google.android.libraries.places.internal.lk r0 = new com.google.android.libraries.places.internal.lk
            r0.<init>((int) r6)
            goto L_0x0029
        L_0x0014:
            boolean r1 = r0 instanceof com.google.android.libraries.places.internal.mk
            if (r1 == 0) goto L_0x0024
            boolean r1 = r0 instanceof com.google.android.libraries.places.internal.lc
            if (r1 == 0) goto L_0x0024
            com.google.android.libraries.places.internal.lc r0 = (com.google.android.libraries.places.internal.lc) r0
            com.google.android.libraries.places.internal.lc r6 = r0.b(r6)
            r0 = r6
            goto L_0x0029
        L_0x0024:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x0029:
            com.google.android.libraries.places.internal.nk.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
            goto L_0x007f
        L_0x002d:
            java.lang.Class<?> r1 = f12939c
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004b
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
            com.google.android.libraries.places.internal.nk.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
        L_0x0049:
            r0 = r1
            goto L_0x007f
        L_0x004b:
            boolean r1 = r0 instanceof com.google.android.libraries.places.internal.nh
            if (r1 == 0) goto L_0x0062
            com.google.android.libraries.places.internal.lk r1 = new com.google.android.libraries.places.internal.lk
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>((int) r2)
            com.google.android.libraries.places.internal.nh r0 = (com.google.android.libraries.places.internal.nh) r0
            r1.addAll(r0)
            com.google.android.libraries.places.internal.nk.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
            goto L_0x0049
        L_0x0062:
            boolean r1 = r0 instanceof com.google.android.libraries.places.internal.mk
            if (r1 == 0) goto L_0x007f
            boolean r1 = r0 instanceof com.google.android.libraries.places.internal.lc
            if (r1 == 0) goto L_0x007f
            r1 = r0
            com.google.android.libraries.places.internal.lc r1 = (com.google.android.libraries.places.internal.lc) r1
            boolean r2 = r1.a()
            if (r2 != 0) goto L_0x007f
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.android.libraries.places.internal.lc r0 = r1.b(r0)
            com.google.android.libraries.places.internal.nk.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.ln.a(java.lang.Object, long, int):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final <E> void a(Object obj, Object obj2, long j) {
        List b2 = b(obj2, j);
        List a2 = a(obj, j, b2.size());
        int size = a2.size();
        int size2 = b2.size();
        if (size > 0 && size2 > 0) {
            a2.addAll(b2);
        }
        if (size > 0) {
            b2 = a2;
        }
        nk.a(obj, j, (Object) b2);
    }

    private static <E> List<E> b(Object obj, long j) {
        return (List) nk.f(obj, j);
    }
}
