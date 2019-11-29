package com.shopee.scanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.core.content.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.scanner.c;
import d.d.b.j;
import d.m;

public class ViewfinderView extends View {

    /* renamed from: a  reason: collision with root package name */
    private d f30266a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f30267b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f30268c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f30269d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f30270e;

    public ViewfinderView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewfinderView(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewfinderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.e.ViewfinderView);
        int resourceId = obtainStyledAttributes.getResourceId(c.e.ViewfinderView_drawableTopLeft, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(c.e.ViewfinderView_drawableTopRight, -1);
        int resourceId3 = obtainStyledAttributes.getResourceId(c.e.ViewfinderView_drawableBottomLeft, -1);
        int resourceId4 = obtainStyledAttributes.getResourceId(c.e.ViewfinderView_drawableBottomRight, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            this.f30267b = b.a(context, resourceId);
        }
        if (resourceId2 != -1) {
            this.f30268c = b.a(context, resourceId2);
        }
        if (resourceId3 != -1) {
            this.f30269d = b.a(context, resourceId3);
        }
        if (resourceId4 != -1) {
            this.f30270e = b.a(context, resourceId4);
        }
    }

    public final d getScannerView() {
        return this.f30266a;
    }

    public final void setScannerView(d dVar) {
        this.f30266a = dVar;
    }

    public final float getRelativeX() {
        try {
            View view = this;
            float f2 = BitmapDescriptorFactory.HUE_RED;
            while (!j.a((Object) view, (Object) this.f30266a)) {
                f2 += view.getX();
                ViewParent parent = view.getParent();
                if (parent != null) {
                    view = (View) parent;
                } else {
                    throw new m("null cannot be cast to non-null type android.view.View");
                }
            }
            return f2;
        } catch (RuntimeException e2) {
            throw new IllegalStateException("The ViewfinderView is not a descendant of the ScannerView", e2);
        }
    }

    public final float getRelativeY() {
        try {
            View view = this;
            float f2 = BitmapDescriptorFactory.HUE_RED;
            while (!j.a((Object) view, (Object) this.f30266a)) {
                f2 += view.getY();
                ViewParent parent = view.getParent();
                if (parent != null) {
                    view = (View) parent;
                } else {
                    throw new m("null cannot be cast to non-null type android.view.View");
                }
            }
            return f2;
        } catch (RuntimeException e2) {
            throw new IllegalStateException("The ViewfinderView is not a descendant of the ScannerView", e2);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = this.f30267b;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        Drawable drawable2 = this.f30268c;
        if (drawable2 != null) {
            drawable2.setBounds(i - drawable2.getMinimumWidth(), 0, i, drawable2.getMinimumHeight());
        }
        Drawable drawable3 = this.f30269d;
        if (drawable3 != null) {
            drawable3.setBounds(0, i2 - drawable3.getMinimumHeight(), drawable3.getMinimumWidth(), i2);
        }
        Drawable drawable4 = this.f30270e;
        if (drawable4 != null) {
            drawable4.setBounds(i - drawable4.getMinimumWidth(), i2 - drawable4.getMinimumHeight(), i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        j.b(canvas, "canvas");
        Drawable drawable = this.f30267b;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f30268c;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Drawable drawable3 = this.f30269d;
        if (drawable3 != null) {
            drawable3.draw(canvas);
        }
        Drawable drawable4 = this.f30270e;
        if (drawable4 != null) {
            drawable4.draw(canvas);
        }
    }
}
