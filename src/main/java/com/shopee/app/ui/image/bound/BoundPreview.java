package com.shopee.app.ui.image.bound;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.shopee.app.ui.image.bound.a;
import com.shopee.app.ui.image.editor.d.d;
import com.shopee.id.R;
import d.d.b.j;

public final class BoundPreview extends View implements a.C0355a {

    /* renamed from: a  reason: collision with root package name */
    private final int f22737a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22738b = e.b();

    /* renamed from: c  reason: collision with root package name */
    private d f22739c;

    /* renamed from: d  reason: collision with root package name */
    private h f22740d;

    /* renamed from: e  reason: collision with root package name */
    private a f22741e = new a(this);

    /* renamed from: f  reason: collision with root package name */
    private boolean f22742f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22743g;
    private i h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoundPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.b(context, "context");
        j.b(attributeSet, "attributeSet");
        this.f22737a = d.a(4, context);
        c cVar = new c();
        cVar.a(getResources().getDrawable(R.drawable.bound_box));
        cVar.a(e.d());
        this.f22739c = new d(context, cVar, this);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        d dVar = this.f22739c;
        if (dVar != null) {
            g.a((g) dVar, canvas, (Rect) null, 2, (Object) null);
        }
    }

    private final void a(Canvas canvas) {
        if (canvas != null) {
            canvas.save();
        }
        Rect boundBoxRect = getBoundBoxRect();
        if (Build.VERSION.SDK_INT >= 26) {
            if (canvas != null) {
                if (boundBoxRect == null) {
                    j.a();
                }
                canvas.clipOutRect(boundBoxRect.left + this.f22737a, boundBoxRect.top + this.f22737a, boundBoxRect.right - this.f22737a, boundBoxRect.bottom - this.f22737a);
            }
        } else if (canvas != null) {
            if (boundBoxRect == null) {
                j.a();
            }
            canvas.clipRect((float) (boundBoxRect.left + this.f22737a), (float) (boundBoxRect.top + this.f22737a), (float) (boundBoxRect.right - this.f22737a), (float) (boundBoxRect.bottom - this.f22737a), Region.Op.DIFFERENCE);
        }
        if (canvas != null) {
            Context context = getContext();
            j.a((Object) context, "context");
            canvas.drawColor(context.getResources().getColor(R.color.black50));
        }
        if (canvas != null) {
            canvas.restore();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f22742f) {
            return false;
        }
        this.f22741e.a(motionEvent);
        return true;
    }

    public b a(a.b bVar) {
        d dVar = this.f22739c;
        if (dVar == null) {
            return null;
        }
        Float valueOf = bVar != null ? Float.valueOf(bVar.g()) : null;
        if (valueOf == null) {
            j.a();
        }
        double floatValue = (double) valueOf.floatValue();
        Float valueOf2 = bVar != null ? Float.valueOf(bVar.h()) : null;
        if (valueOf2 == null) {
            j.a();
        }
        if (dVar.a(floatValue, (double) valueOf2.floatValue())) {
            return this.f22739c;
        }
        return null;
    }

    public void a(b bVar, a.c cVar) {
        j.b(cVar, "objPosAndScaleOut");
        if (bVar != null) {
            double a2 = bVar.a();
            double b2 = bVar.b();
            boolean z = (this.f22738b & e.b()) == 0;
            double c2 = bVar.c() + bVar.d();
            double d2 = (double) 2;
            Double.isNaN(d2);
            cVar.a(a2, b2, z, c2 / d2, (this.f22738b & e.b()) != 0, bVar.c(), bVar.d(), (this.f22738b & e.a()) != 0, bVar.e());
        }
    }

    public boolean a(b bVar, a.c cVar, a.b bVar2) {
        if (!j.a((Object) bVar != null ? Boolean.valueOf(bVar.a(cVar, this.f22738b)) : null, (Object) true)) {
            return false;
        }
        invalidate();
        h hVar = this.f22740d;
        if (hVar != null) {
            hVar.a(true);
        }
        if (!this.f22743g) {
            i iVar = this.h;
            if (iVar != null) {
                iVar.a();
            }
        }
        this.f22743g = true;
        return true;
    }

    public void a(b bVar, a.b bVar2) {
        if (bVar != null) {
            invalidate();
        }
    }

    public final Rect getBoundBoxRect() {
        d dVar = this.f22739c;
        if (dVar != null) {
            return dVar.f();
        }
        return null;
    }

    public final void a(double d2, double d3, double d4, double d5) {
        d dVar = this.f22739c;
        if (dVar != null) {
            dVar.a(d2, d3, d4, d5);
        }
        invalidate();
    }

    public final boolean a() {
        return this.f22743g;
    }

    public final void setOnBoundBoxChangedCallback(i iVar) {
        this.h = iVar;
    }

    public final void setTouchDragMode(boolean z) {
        this.f22742f = z;
    }
}
