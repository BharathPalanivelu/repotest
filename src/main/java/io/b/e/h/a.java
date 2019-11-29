package io.b.e.h;

import io.b.d.j;
import io.b.o;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f33553a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f33554b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f33555c = this.f33554b;

    /* renamed from: d  reason: collision with root package name */
    int f33556d;

    /* renamed from: io.b.e.h.a$a  reason: collision with other inner class name */
    public interface C0523a<T> extends j<T> {
        boolean a(T t);
    }

    public a(int i) {
        this.f33553a = i;
        this.f33554b = new Object[(i + 1)];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(T r4) {
        /*
            r3 = this;
            int r0 = r3.f33553a
            int r1 = r3.f33556d
            if (r1 != r0) goto L_0x0011
            int r1 = r0 + 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object[] r2 = r3.f33555c
            r2[r0] = r1
            r3.f33555c = r1
            r1 = 0
        L_0x0011:
            java.lang.Object[] r0 = r3.f33555c
            r0[r1] = r4
            int r1 = r1 + 1
            r3.f33556d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.b.e.h.a.a(java.lang.Object):void");
    }

    public void b(T t) {
        this.f33554b[0] = t;
    }

    public void a(C0523a<? super T> aVar) {
        int i = this.f33553a;
        for (Object[] objArr = this.f33554b; objArr != null; objArr = objArr[i]) {
            int i2 = 0;
            while (i2 < i) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (!aVar.a(objArr2)) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public <U> boolean a(o<? super U> oVar) {
        Object[] objArr = this.f33554b;
        int i = this.f33553a;
        while (true) {
            int i2 = 0;
            if (objArr == null) {
                return false;
            }
            while (i2 < i) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (g.acceptFull((Object) objArr2, oVar)) {
                    return true;
                } else {
                    i2++;
                }
            }
            objArr = objArr[i];
        }
    }
}
