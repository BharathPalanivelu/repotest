package com.shopee.feeds.feedlibrary.view.b;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;

public class k extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private l f28525a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView.ScaleType f28526b;

    public k(Context context) {
        this(context, (AttributeSet) null);
    }

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public k(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f28525a = new l(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f28526b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f28526b = null;
        }
    }

    public l getAttacher() {
        return this.f28525a;
    }

    public ImageView.ScaleType getScaleType() {
        return this.f28525a.f();
    }

    public Matrix getImageMatrix() {
        return this.f28525a.h();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f28525a.a(onLongClickListener);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f28525a.a(onClickListener);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        l lVar = this.f28525a;
        if (lVar == null) {
            this.f28526b = scaleType;
        } else {
            lVar.a(scaleType);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        l lVar = this.f28525a;
        if (lVar != null) {
            lVar.g();
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        l lVar = this.f28525a;
        if (lVar != null) {
            lVar.g();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        l lVar = this.f28525a;
        if (lVar != null) {
            lVar.g();
        }
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.f28525a.g();
        }
        return frame;
    }

    public void setRotationTo(float f2) {
        this.f28525a.a(f2);
    }

    public void setRotationBy(float f2) {
        this.f28525a.b(f2);
    }

    public void setZoomable(boolean z) {
        this.f28525a.b(z);
    }

    public RectF getDisplayRect() {
        return this.f28525a.a();
    }

    public float getMinimumScale() {
        return this.f28525a.b();
    }

    public float getMediumScale() {
        return this.f28525a.c();
    }

    public float getMaximumScale() {
        return this.f28525a.d();
    }

    public float getScale() {
        return this.f28525a.e();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f28525a.a(z);
    }

    public void setMinimumScale(float f2) {
        this.f28525a.c(f2);
    }

    public void setMediumScale(float f2) {
        this.f28525a.d(f2);
    }

    public void setMaximumScale(float f2) {
        this.f28525a.e(f2);
    }

    public void setOnMatrixChangeListener(d dVar) {
        this.f28525a.a(dVar);
    }

    public void setOnPhotoTapListener(f fVar) {
        this.f28525a.a(fVar);
    }

    public void setOnOutsidePhotoTapListener(e eVar) {
        this.f28525a.a(eVar);
    }

    public void setOnViewTapListener(j jVar) {
        this.f28525a.a(jVar);
    }

    public void setOnViewDragListener(i iVar) {
        this.f28525a.a(iVar);
    }

    public void setScale(float f2) {
        this.f28525a.f(f2);
    }

    public void setZoomTransitionDuration(int i) {
        this.f28525a.a(i);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f28525a.a(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(g gVar) {
        this.f28525a.a(gVar);
    }

    public void setOnSingleFlingListener(h hVar) {
        this.f28525a.a(hVar);
    }
}
