package com.shopee.feeds.feedlibrary.editor.multitouch;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f27961a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f27962b;

    /* renamed from: c  reason: collision with root package name */
    private MotionEvent f27963c;

    /* renamed from: d  reason: collision with root package name */
    private MotionEvent f27964d;

    /* renamed from: e  reason: collision with root package name */
    private Vector2D f27965e = new Vector2D();

    /* renamed from: f  reason: collision with root package name */
    private float f27966f;

    /* renamed from: g  reason: collision with root package name */
    private float f27967g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private long q;
    private boolean r;
    private int s;
    private int t;
    private boolean u;

    interface a {
        boolean a(View view, b bVar);

        boolean b(View view, b bVar);

        void c(View view, b bVar);
    }

    /* renamed from: com.shopee.feeds.feedlibrary.editor.multitouch.b$b  reason: collision with other inner class name */
    public static class C0431b implements a {
        public boolean a(View view, b bVar) {
            return true;
        }

        public boolean b(View view, b bVar) {
            return false;
        }

        public void c(View view, b bVar) {
        }
    }

    public b(a aVar) {
        this.f27961a = aVar;
    }

    public boolean a(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            f();
        }
        boolean z = false;
        if (this.r) {
            return false;
        }
        if (!this.f27962b) {
            if (actionMasked == 0) {
                this.s = motionEvent.getPointerId(0);
                this.u = true;
            } else if (actionMasked == 1) {
                f();
            } else if (actionMasked == 5) {
                MotionEvent motionEvent2 = this.f27963c;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                this.f27963c = MotionEvent.obtain(motionEvent);
                this.q = 0;
                int actionIndex = motionEvent.getActionIndex();
                int findPointerIndex = motionEvent.findPointerIndex(this.s);
                this.t = motionEvent.getPointerId(actionIndex);
                if (findPointerIndex < 0 || findPointerIndex == actionIndex) {
                    this.s = motionEvent.getPointerId(a(motionEvent, this.t, -1));
                }
                this.u = false;
                b(view, motionEvent);
                this.f27962b = this.f27961a.a(view, this);
            }
        } else if (actionMasked == 1) {
            f();
        } else if (actionMasked == 2) {
            b(view, motionEvent);
            if (this.o / this.p > 0.67f && this.f27961a.b(view, this)) {
                this.f27963c.recycle();
                this.f27963c = MotionEvent.obtain(motionEvent);
            }
        } else if (actionMasked == 3) {
            this.f27961a.c(view, this);
            f();
        } else if (actionMasked == 5) {
            this.f27961a.c(view, this);
            int i2 = this.s;
            int i3 = this.t;
            f();
            this.f27963c = MotionEvent.obtain(motionEvent);
            if (!this.u) {
                i2 = i3;
            }
            this.s = i2;
            this.t = motionEvent.getPointerId(motionEvent.getActionIndex());
            this.u = false;
            if (motionEvent.findPointerIndex(this.s) < 0 || this.s == this.t) {
                this.s = motionEvent.getPointerId(a(motionEvent, this.t, -1));
            }
            b(view, motionEvent);
            this.f27962b = this.f27961a.a(view, this);
        } else if (actionMasked == 6) {
            int pointerCount = motionEvent.getPointerCount();
            int actionIndex2 = motionEvent.getActionIndex();
            int pointerId = motionEvent.getPointerId(actionIndex2);
            if (pointerCount > 2) {
                int i4 = this.s;
                if (pointerId == i4) {
                    int a2 = a(motionEvent, this.t, actionIndex2);
                    if (a2 >= 0) {
                        this.f27961a.c(view, this);
                        this.s = motionEvent.getPointerId(a2);
                        this.u = true;
                        this.f27963c = MotionEvent.obtain(motionEvent);
                        b(view, motionEvent);
                        this.f27962b = this.f27961a.a(view, this);
                        this.f27963c.recycle();
                        this.f27963c = MotionEvent.obtain(motionEvent);
                        b(view, motionEvent);
                    }
                } else {
                    if (pointerId == this.t) {
                        int a3 = a(motionEvent, i4, actionIndex2);
                        if (a3 >= 0) {
                            this.f27961a.c(view, this);
                            this.t = motionEvent.getPointerId(a3);
                            this.u = false;
                            this.f27963c = MotionEvent.obtain(motionEvent);
                            b(view, motionEvent);
                            this.f27962b = this.f27961a.a(view, this);
                        }
                    }
                    this.f27963c.recycle();
                    this.f27963c = MotionEvent.obtain(motionEvent);
                    b(view, motionEvent);
                }
                z = true;
                this.f27963c.recycle();
                this.f27963c = MotionEvent.obtain(motionEvent);
                b(view, motionEvent);
            } else {
                z = true;
            }
            if (z) {
                b(view, motionEvent);
                int i5 = this.s;
                if (pointerId == i5) {
                    i5 = this.t;
                }
                int findPointerIndex2 = motionEvent.findPointerIndex(i5);
                this.f27966f = motionEvent.getX(findPointerIndex2);
                this.f27967g = motionEvent.getY(findPointerIndex2);
                this.f27961a.c(view, this);
                f();
                this.s = i5;
                this.u = true;
            }
        }
        return true;
    }

    private int a(MotionEvent motionEvent, int i2, int i3) {
        int pointerCount = motionEvent.getPointerCount();
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        for (int i4 = 0; i4 < pointerCount; i4++) {
            if (i4 != i3 && i4 != findPointerIndex) {
                return i4;
            }
        }
        return -1;
    }

    private void b(View view, MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f27964d;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.f27964d = MotionEvent.obtain(motionEvent);
        this.l = -1.0f;
        this.m = -1.0f;
        this.n = -1.0f;
        this.f27965e.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        MotionEvent motionEvent3 = this.f27963c;
        int findPointerIndex = motionEvent3.findPointerIndex(this.s);
        int findPointerIndex2 = motionEvent3.findPointerIndex(this.t);
        int findPointerIndex3 = motionEvent.findPointerIndex(this.s);
        int findPointerIndex4 = motionEvent.findPointerIndex(this.t);
        if (findPointerIndex < 0 || findPointerIndex2 < 0 || findPointerIndex3 < 0 || findPointerIndex4 < 0) {
            this.r = true;
            Log.e("ScaleGestureDetector", "Invalid MotionEvent stream detected.", new Throwable());
            if (this.f27962b) {
                this.f27961a.c(view, this);
                return;
            }
            return;
        }
        float x = motionEvent3.getX(findPointerIndex);
        float y = motionEvent3.getY(findPointerIndex);
        float x2 = motionEvent3.getX(findPointerIndex2);
        float y2 = motionEvent3.getY(findPointerIndex2);
        float x3 = motionEvent.getX(findPointerIndex3);
        float y3 = motionEvent.getY(findPointerIndex3);
        float x4 = motionEvent.getX(findPointerIndex4) - x3;
        float y4 = motionEvent.getY(findPointerIndex4) - y3;
        this.f27965e.set(x4, y4);
        this.h = x2 - x;
        this.i = y2 - y;
        this.j = x4;
        this.k = y4;
        this.f27966f = x3 + (x4 * 0.5f);
        this.f27967g = y3 + (y4 * 0.5f);
        this.q = motionEvent.getEventTime() - motionEvent3.getEventTime();
        this.o = motionEvent.getPressure(findPointerIndex3) + motionEvent.getPressure(findPointerIndex4);
        this.p = motionEvent3.getPressure(findPointerIndex) + motionEvent3.getPressure(findPointerIndex2);
    }

    private void f() {
        MotionEvent motionEvent = this.f27963c;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f27963c = null;
        }
        MotionEvent motionEvent2 = this.f27964d;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f27964d = null;
        }
        this.f27962b = false;
        this.s = -1;
        this.t = -1;
        this.r = false;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f27962b;
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.f27966f;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f27967g;
    }

    private float g() {
        if (this.l == -1.0f) {
            float f2 = this.j;
            float f3 = this.k;
            this.l = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
        }
        return this.l;
    }

    public Vector2D d() {
        return this.f27965e;
    }

    private float h() {
        if (this.m == -1.0f) {
            float f2 = this.h;
            float f3 = this.i;
            this.m = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
        }
        return this.m;
    }

    public float e() {
        if (this.n == -1.0f) {
            this.n = g() / h();
        }
        return this.n;
    }
}
