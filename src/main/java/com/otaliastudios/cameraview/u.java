package com.otaliastudios.cameraview;

import android.content.Context;
import android.graphics.PointF;
import android.widget.FrameLayout;

abstract class u extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f15677a;

    /* renamed from: b  reason: collision with root package name */
    protected s f15678b;

    /* renamed from: c  reason: collision with root package name */
    protected PointF[] f15679c;

    protected static float a(float f2, float f3, float f4, float f5) {
        if (f3 < f4) {
            f3 = f4;
        }
        if (f3 > f5) {
            f3 = f5;
        }
        float f6 = ((f5 - f4) / 50.0f) / 2.0f;
        return (f3 < f2 - f6 || f3 > f6 + f2) ? f3 : f2;
    }

    public abstract float a(float f2, float f3, float f4);

    /* access modifiers changed from: protected */
    public void a(Context context) {
    }

    public u(Context context) {
        super(context);
        a(context);
    }

    public void a(boolean z) {
        this.f15677a = z;
    }

    public final s a() {
        return this.f15678b;
    }

    public final PointF[] b() {
        return this.f15679c;
    }
}
