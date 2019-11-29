package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.c.b.n;
import com.airbnb.lottie.c.e;
import java.util.Collections;
import java.util.List;

public class f extends a {

    /* renamed from: e  reason: collision with root package name */
    private final c f3630e;

    f(com.airbnb.lottie.f fVar, d dVar) {
        super(fVar, dVar);
        this.f3630e = new c(fVar, this, new n("__container", dVar.n()));
        this.f3630e.a((List<b>) Collections.emptyList(), (List<b>) Collections.emptyList());
    }

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, Matrix matrix, int i) {
        this.f3630e.a(canvas, matrix, i);
    }

    public void a(RectF rectF, Matrix matrix) {
        super.a(rectF, matrix);
        this.f3630e.a(rectF, this.f3605a);
    }

    /* access modifiers changed from: protected */
    public void b(e eVar, int i, List<e> list, e eVar2) {
        this.f3630e.a(eVar, i, list, eVar2);
    }
}
