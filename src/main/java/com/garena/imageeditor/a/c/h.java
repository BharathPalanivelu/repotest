package com.garena.imageeditor.a.c;

import android.content.Context;
import com.garena.cropimage.library.b;
import com.garena.imageeditor.a.a.a;
import com.garena.imageeditor.c;
import jp.co.cyberagent.android.gpuimage.f;

public class h extends f {

    /* renamed from: c  reason: collision with root package name */
    private a f8086c = new a();

    /* renamed from: d  reason: collision with root package name */
    private jp.co.cyberagent.android.gpuimage.h f8087d;

    public h(Context context) {
        this.f8086c.a(b.a(context, c.a.lookup_map_pro));
        this.f8087d = new com.garena.imageeditor.a.a.b(context);
        a(this.f8086c);
        a(this.f8087d);
    }
}
