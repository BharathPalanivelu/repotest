package com.google.a.b.a;

import com.google.a.a.b;
import com.google.a.b.c;
import com.google.a.c.a;
import com.google.a.f;
import com.google.a.w;
import com.google.a.x;

public final class d implements x {

    /* renamed from: a  reason: collision with root package name */
    private final c f8745a;

    public d(c cVar) {
        this.f8745a = cVar;
    }

    public <T> w<T> create(f fVar, a<T> aVar) {
        b bVar = (b) aVar.getRawType().getAnnotation(b.class);
        if (bVar == null) {
            return null;
        }
        return a(this.f8745a, fVar, aVar, bVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: com.google.a.w<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: com.google.a.w} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.google.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: com.google.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: com.google.a.b.a.l} */
    /* JADX WARNING: type inference failed for: r9v3, types: [com.google.a.w<?>, com.google.a.w] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.a.w<?> a(com.google.a.b.c r9, com.google.a.f r10, com.google.a.c.a<?> r11, com.google.a.a.b r12) {
        /*
            r8 = this;
            java.lang.Class r0 = r12.a()
            com.google.a.c.a r0 = com.google.a.c.a.get(r0)
            com.google.a.b.i r9 = r9.a(r0)
            java.lang.Object r9 = r9.a()
            boolean r0 = r9 instanceof com.google.a.w
            if (r0 == 0) goto L_0x0017
            com.google.a.w r9 = (com.google.a.w) r9
            goto L_0x0075
        L_0x0017:
            boolean r0 = r9 instanceof com.google.a.x
            if (r0 == 0) goto L_0x0022
            com.google.a.x r9 = (com.google.a.x) r9
            com.google.a.w r9 = r9.create(r10, r11)
            goto L_0x0075
        L_0x0022:
            boolean r0 = r9 instanceof com.google.a.t
            if (r0 != 0) goto L_0x005b
            boolean r1 = r9 instanceof com.google.a.k
            if (r1 == 0) goto L_0x002b
            goto L_0x005b
        L_0x002b:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Invalid attempt to bind an instance of "
            r12.append(r0)
            java.lang.Class r9 = r9.getClass()
            java.lang.String r9 = r9.getName()
            r12.append(r9)
            java.lang.String r9 = " as a @JsonAdapter for "
            r12.append(r9)
            java.lang.String r9 = r11.toString()
            r12.append(r9)
            java.lang.String r9 = ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer."
            r12.append(r9)
            java.lang.String r9 = r12.toString()
            r10.<init>(r9)
            throw r10
        L_0x005b:
            r1 = 0
            if (r0 == 0) goto L_0x0063
            r0 = r9
            com.google.a.t r0 = (com.google.a.t) r0
            r3 = r0
            goto L_0x0064
        L_0x0063:
            r3 = r1
        L_0x0064:
            boolean r0 = r9 instanceof com.google.a.k
            if (r0 == 0) goto L_0x006b
            r1 = r9
            com.google.a.k r1 = (com.google.a.k) r1
        L_0x006b:
            r4 = r1
            com.google.a.b.a.l r9 = new com.google.a.b.a.l
            r7 = 0
            r2 = r9
            r5 = r10
            r6 = r11
            r2.<init>(r3, r4, r5, r6, r7)
        L_0x0075:
            if (r9 == 0) goto L_0x0081
            boolean r10 = r12.b()
            if (r10 == 0) goto L_0x0081
            com.google.a.w r9 = r9.nullSafe()
        L_0x0081:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.a.d.a(com.google.a.b.c, com.google.a.f, com.google.a.c.a, com.google.a.a.b):com.google.a.w");
    }
}
