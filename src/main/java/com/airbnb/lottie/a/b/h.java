package com.airbnb.lottie.a.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f.f;
import com.airbnb.lottie.g.a;

public class h extends a<PointF> {
    private Path h;

    public h(d dVar, a<PointF> aVar) {
        super(dVar, aVar.f3734a, aVar.f3735b, aVar.f3736c, aVar.f3737d, aVar.f3738e);
        boolean z = (this.f3735b == null || this.f3734a == null || !((PointF) this.f3734a).equals(((PointF) this.f3735b).x, ((PointF) this.f3735b).y)) ? false : true;
        if (this.f3735b != null && !z) {
            this.h = f.a((PointF) this.f3734a, (PointF) this.f3735b, aVar.f3739f, aVar.f3740g);
        }
    }

    /* access modifiers changed from: package-private */
    public Path a() {
        return this.h;
    }
}
