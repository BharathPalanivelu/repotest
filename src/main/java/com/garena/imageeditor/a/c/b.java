package com.garena.imageeditor.a.c;

import android.content.Context;
import com.garena.imageeditor.a.a.a;
import com.garena.imageeditor.c;
import jp.co.cyberagent.android.gpuimage.f;
import jp.co.cyberagent.android.gpuimage.h;

public class b extends f {

    /* renamed from: c  reason: collision with root package name */
    private a f8082c = new a();

    /* renamed from: d  reason: collision with root package name */
    private h f8083d;

    public b(Context context) {
        this.f8082c.a(com.garena.cropimage.library.b.a(context, c.a.lookup_map_caprice));
        this.f8083d = new h();
        this.f8083d.a(com.garena.cropimage.library.b.a(context, c.a.caprice_darkcorner));
        a(this.f8082c);
        a(this.f8083d);
    }
}
