package com.shopee.feeds.feedlibrary.view.b;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

class b {

    /* renamed from: a  reason: collision with root package name */
    private int f28517a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f28518b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final ScaleGestureDetector f28519c;

    /* renamed from: d  reason: collision with root package name */
    private VelocityTracker f28520d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f28521e;

    /* renamed from: f  reason: collision with root package name */
    private float f28522f;

    /* renamed from: g  reason: collision with root package name */
    private float f28523g;
    private final float h;
    private final float i;
    /* access modifiers changed from: private */
    public c j;

    b(Context context, c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.i = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.h = (float) viewConfiguration.getScaledTouchSlop();
        this.j = cVar;
        this.f28519c = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() {
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }

            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                b.this.j.a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }
        });
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f28518b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f28518b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public boolean a() {
        return this.f28519c.isInProgress();
    }

    public boolean b() {
        return this.f28521e;
    }

    public boolean a(MotionEvent motionEvent) {
        try {
            this.f28519c.onTouchEvent(motionEvent);
            return d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    private boolean d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f28517a = motionEvent.getPointerId(0);
            this.f28520d = VelocityTracker.obtain();
            VelocityTracker velocityTracker = this.f28520d;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            this.f28522f = b(motionEvent);
            this.f28523g = c(motionEvent);
            this.f28521e = false;
        } else if (action == 1) {
            this.f28517a = -1;
            if (this.f28521e && this.f28520d != null) {
                this.f28522f = b(motionEvent);
                this.f28523g = c(motionEvent);
                this.f28520d.addMovement(motionEvent);
                this.f28520d.computeCurrentVelocity(1000);
                float xVelocity = this.f28520d.getXVelocity();
                float yVelocity = this.f28520d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.i) {
                    this.j.a(this.f28522f, this.f28523g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.f28520d;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f28520d = null;
            }
        } else if (action == 2) {
            float b2 = b(motionEvent);
            float c2 = c(motionEvent);
            float f2 = b2 - this.f28522f;
            float f3 = c2 - this.f28523g;
            if (!this.f28521e) {
                this.f28521e = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.h);
            }
            if (this.f28521e) {
                this.j.a(f2, f3);
                this.f28522f = b2;
                this.f28523g = c2;
                VelocityTracker velocityTracker3 = this.f28520d;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f28517a = -1;
            VelocityTracker velocityTracker4 = this.f28520d;
            if (velocityTracker4 != null) {
                velocityTracker4.recycle();
                this.f28520d = null;
            }
        } else if (action == 6) {
            int a2 = m.a(motionEvent.getAction());
            if (motionEvent.getPointerId(a2) == this.f28517a) {
                int i2 = a2 == 0 ? 1 : 0;
                this.f28517a = motionEvent.getPointerId(i2);
                this.f28522f = motionEvent.getX(i2);
                this.f28523g = motionEvent.getY(i2);
            }
        }
        int i3 = this.f28517a;
        if (i3 == -1) {
            i3 = 0;
        }
        this.f28518b = motionEvent.findPointerIndex(i3);
        return true;
    }
}
