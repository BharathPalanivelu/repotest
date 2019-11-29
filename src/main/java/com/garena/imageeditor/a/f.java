package com.garena.imageeditor.a;

import com.garena.imageeditor.ImageEditView;
import com.garena.imageeditor.b;
import jp.co.cyberagent.android.gpuimage.e;

public abstract class f extends b {
    /* access modifiers changed from: protected */

    /* renamed from: f  reason: collision with root package name */
    public final ImageEditView f8095f;

    public int i() {
        return 0;
    }

    public f(ImageEditView imageEditView, b bVar, com.garena.imageeditor.b.b bVar2) {
        super(bVar, bVar2);
        this.f8095f = imageEditView;
    }

    /* access modifiers changed from: protected */
    public e d(g gVar) {
        return new e();
    }

    public g a(int i) {
        return new g();
    }
}
