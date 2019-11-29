package com.garena.imageeditor.a.b;

import android.graphics.PointF;
import com.facebook.react.uimanager.ViewProps;
import com.garena.imageeditor.ImageEditView;
import com.garena.imageeditor.a.a.c;
import com.garena.imageeditor.a.d;
import com.garena.imageeditor.a.f;
import com.garena.imageeditor.a.g;
import com.garena.imageeditor.b;
import com.garena.imageeditor.view.ImageMaskView;
import jp.co.cyberagent.android.gpuimage.e;

public class a extends f {

    /* renamed from: g  reason: collision with root package name */
    private c f8071g = new c();

    public a(ImageEditView imageEditView, b bVar, com.garena.imageeditor.b.b bVar2) {
        super(imageEditView, bVar, bVar2);
    }

    public void a(g gVar) {
        this.f8066c = gVar;
        this.f8065b.b((com.garena.imageeditor.a.b) this);
        this.f8065b.a();
        this.f8065b.b();
    }

    /* access modifiers changed from: protected */
    public void b(g gVar) {
        this.f8067d = gVar;
        this.f8065b.a((com.garena.imageeditor.a.b) this);
        this.f8095f.d();
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f8066c = this.f8067d;
        ImageMaskView mask = this.f8095f.getMask();
        PointF selectionCenter = mask.getSelectionCenter();
        float selectionRadius = mask.getSelectionRadius();
        float ratio = 1.0f / mask.getRatio();
        selectionCenter.set(selectionCenter.x, ((selectionCenter.y * ratio) + 0.5f) - (0.5f * ratio));
        g gVar = new g();
        gVar.a("blurRadius", Float.valueOf(2.0f));
        gVar.a("excludeCirclePoint", selectionCenter);
        gVar.a("excludeCircleRadius", Float.valueOf(selectionRadius));
        gVar.a("excludeBlurSize", Float.valueOf(selectionRadius * 0.7f));
        gVar.a(ViewProps.ASPECT_RATIO, Float.valueOf(ratio));
        this.f8066c = gVar;
        mask.setVisibility(4);
        this.f8065b.b((com.garena.imageeditor.a.b) this);
        this.f8065b.a();
        this.f8065b.b();
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f8095f.e();
    }

    /* access modifiers changed from: protected */
    public e d(g gVar) {
        this.f8071g.a(this.f8066c.a("blurRadius"));
        this.f8071g.a(this.f8066c.b("excludeCirclePoint"));
        this.f8071g.b(this.f8066c.a("excludeCircleRadius"));
        this.f8071g.c(this.f8066c.a("excludeBlurSize"));
        this.f8071g.d(this.f8066c.a(ViewProps.ASPECT_RATIO));
        return this.f8071g;
    }

    public d g() {
        return d.FOCUS_BLUR;
    }

    public g h() {
        g gVar = new g();
        gVar.a("blurRadius", Float.valueOf(2.0f));
        gVar.a("excludeCirclePoint", new PointF(0.5f, 0.5f));
        gVar.a("excludeCircleRadius", Float.valueOf(0.09375f));
        gVar.a("excludeBlurSize", Float.valueOf(0.03125f));
        gVar.a(ViewProps.ASPECT_RATIO, Float.valueOf(1.0f));
        return gVar;
    }
}
