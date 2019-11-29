package com.airbnb.lottie.c.b;

import com.airbnb.lottie.f.b;
import com.airbnb.lottie.f.e;
import com.litesuits.orm.db.assit.SQLBuilder;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f3538a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f3539b;

    public c(float[] fArr, int[] iArr) {
        this.f3538a = fArr;
        this.f3539b = iArr;
    }

    public float[] a() {
        return this.f3538a;
    }

    public int[] b() {
        return this.f3539b;
    }

    public int c() {
        return this.f3539b.length;
    }

    public void a(c cVar, c cVar2, float f2) {
        if (cVar.f3539b.length == cVar2.f3539b.length) {
            for (int i = 0; i < cVar.f3539b.length; i++) {
                this.f3538a[i] = e.a(cVar.f3538a[i], cVar2.f3538a[i], f2);
                this.f3539b[i] = b.a(f2, cVar.f3539b[i], cVar2.f3539b[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f3539b.length + " vs " + cVar2.f3539b.length + SQLBuilder.PARENTHESES_RIGHT);
    }
}
