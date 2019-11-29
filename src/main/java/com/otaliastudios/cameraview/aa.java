package com.otaliastudios.cameraview;

import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class aa extends u {

    /* renamed from: d  reason: collision with root package name */
    ScaleGestureDetector f15518d;

    /* renamed from: e  reason: collision with root package name */
    float f15519e = BitmapDescriptorFactory.HUE_RED;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f15520f;

    public aa(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        super.a(context);
        this.f15679c = new PointF[]{new PointF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED), new PointF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED)};
        this.f15518d = new ScaleGestureDetector(context, new ScaleGestureDetector.SimpleOnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                boolean unused = aa.this.f15520f = true;
                aa.this.f15519e = (scaleGestureDetector.getScaleFactor() - 1.0f) * 2.0f;
                return true;
            }
        });
        if (Build.VERSION.SDK_INT >= 19) {
            this.f15518d.setQuickScaleEnabled(false);
        }
        this.f15678b = s.PINCH;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.f15677a) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f15520f = false;
        }
        this.f15518d.onTouchEvent(motionEvent);
        if (this.f15520f) {
            this.f15679c[0].x = motionEvent.getX(0);
            this.f15679c[0].y = motionEvent.getY(0);
            z = true;
            if (motionEvent.getPointerCount() > 1) {
                this.f15679c[1].x = motionEvent.getX(1);
                this.f15679c[1].y = motionEvent.getY(1);
            }
        }
        return z;
    }

    public float a(float f2, float f3, float f4) {
        return a(f2, (this.f15519e * (f4 - f3)) + f2, f3, f4);
    }
}
