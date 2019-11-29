package com.otaliastudios.cameraview;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class ad extends u {

    /* renamed from: e  reason: collision with root package name */
    private static final String f15522e = "ad";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final g f15523f = g.a(f15522e);

    /* renamed from: d  reason: collision with root package name */
    float f15524d;

    /* renamed from: g  reason: collision with root package name */
    private GestureDetector f15525g;
    /* access modifiers changed from: private */
    public boolean h;

    public ad(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        super.a(context);
        this.f15679c = new PointF[]{new PointF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED), new PointF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED)};
        this.f15525g = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                boolean z;
                g c2 = ad.f15523f;
                boolean z2 = false;
                c2.b("onScroll:", "distanceX=" + f2, "distanceY=" + f3);
                if (motionEvent == null || motionEvent2 == null) {
                    return false;
                }
                if (motionEvent.getX() == ad.this.f15679c[0].x && motionEvent.getY() == ad.this.f15679c[0].y) {
                    if (ad.this.f15678b == s.SCROLL_HORIZONTAL) {
                        z2 = true;
                    }
                    z = z2;
                } else {
                    z = Math.abs(f2) >= Math.abs(f3);
                    ad.this.f15678b = z ? s.SCROLL_HORIZONTAL : s.SCROLL_VERTICAL;
                    ad.this.f15679c[0].set(motionEvent.getX(), motionEvent.getY());
                }
                ad.this.f15679c[1].set(motionEvent2.getX(), motionEvent2.getY());
                ad adVar = ad.this;
                adVar.f15524d = z ? f2 / ((float) adVar.getWidth()) : f3 / ((float) adVar.getHeight());
                ad adVar2 = ad.this;
                adVar2.f15524d = z ? -adVar2.f15524d : adVar2.f15524d;
                boolean unused = ad.this.h = true;
                return true;
            }
        });
        this.f15525g.setIsLongpressEnabled(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f15677a) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.h = false;
        }
        this.f15525g.onTouchEvent(motionEvent);
        if (this.h) {
            f15523f.b("Notifying a gesture of type", this.f15678b.name());
        }
        return this.h;
    }

    public float a(float f2, float f3, float f4) {
        return a(f2, (this.f15524d * (f4 - f3) * 2.0f) + f2, f3, f4);
    }
}
