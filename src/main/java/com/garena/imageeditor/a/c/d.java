package com.garena.imageeditor.a.c;

import android.content.Context;
import com.garena.cropimage.library.b;
import com.garena.imageeditor.a.a.a;
import com.garena.imageeditor.c;
import jp.co.cyberagent.android.gpuimage.f;
import jp.co.cyberagent.android.gpuimage.h;

public class d extends f {

    /* renamed from: c  reason: collision with root package name */
    private a f8084c = new a();

    /* renamed from: d  reason: collision with root package name */
    private h f8085d;

    public d(Context context) {
        this.f8084c.a(b.a(context, c.a.lookup_map_instant));
        this.f8085d = new h();
        this.f8085d.a(b.a(context, c.a.instant_darkcorner));
        a(this.f8084c);
        a(this.f8085d);
    }
}
