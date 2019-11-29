package com.garena.imageeditor.a.c;

import android.content.Context;
import com.garena.cropimage.library.b;
import com.garena.imageeditor.a.a.a;
import com.garena.imageeditor.c;
import jp.co.cyberagent.android.gpuimage.f;
import jp.co.cyberagent.android.gpuimage.h;

public class m extends f {

    /* renamed from: c  reason: collision with root package name */
    private a f8090c = new a();

    /* renamed from: d  reason: collision with root package name */
    private h f8091d;

    public m(Context context) {
        this.f8090c.a(b.a(context, c.a.lookup_map_tokyo));
        this.f8091d = new com.garena.imageeditor.a.a.b(context);
        a(this.f8090c);
        a(this.f8091d);
    }
}
