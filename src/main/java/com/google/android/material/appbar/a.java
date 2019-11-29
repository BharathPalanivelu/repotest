package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.w;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

abstract class a<V extends View> extends c<V> {

    /* renamed from: a  reason: collision with root package name */
    OverScroller f13142a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f13143b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13144c;

    /* renamed from: d  reason: collision with root package name */
    private int f13145d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f13146e;

    /* renamed from: f  reason: collision with root package name */
    private int f13147f = -1;

    /* renamed from: g  reason: collision with root package name */
    private VelocityTracker f13148g;

    /* access modifiers changed from: package-private */
    public void a(CoordinatorLayout coordinatorLayout, V v) {
    }

    /* access modifiers changed from: package-private */
    public boolean c(V v) {
        return false;
    }

    public a() {
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r0 != 3) goto L_0x0083;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r5, V r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            int r0 = r4.f13147f
            if (r0 >= 0) goto L_0x0012
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r4.f13147f = r0
        L_0x0012:
            int r0 = r7.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L_0x001f
            boolean r0 = r4.f13144c
            if (r0 == 0) goto L_0x001f
            return r2
        L_0x001f:
            int r0 = r7.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L_0x0060
            r5 = -1
            if (r0 == r2) goto L_0x0051
            if (r0 == r1) goto L_0x002f
            r6 = 3
            if (r0 == r6) goto L_0x0051
            goto L_0x0083
        L_0x002f:
            int r6 = r4.f13145d
            if (r6 != r5) goto L_0x0034
            goto L_0x0083
        L_0x0034:
            int r6 = r7.findPointerIndex(r6)
            if (r6 != r5) goto L_0x003b
            goto L_0x0083
        L_0x003b:
            float r5 = r7.getY(r6)
            int r5 = (int) r5
            int r6 = r4.f13146e
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r0 = r4.f13147f
            if (r6 <= r0) goto L_0x0083
            r4.f13144c = r2
            r4.f13146e = r5
            goto L_0x0083
        L_0x0051:
            r4.f13144c = r3
            r4.f13145d = r5
            android.view.VelocityTracker r5 = r4.f13148g
            if (r5 == 0) goto L_0x0083
            r5.recycle()
            r5 = 0
            r4.f13148g = r5
            goto L_0x0083
        L_0x0060:
            r4.f13144c = r3
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r2 = r4.c(r6)
            if (r2 == 0) goto L_0x0083
            boolean r5 = r5.a((android.view.View) r6, (int) r0, (int) r1)
            if (r5 == 0) goto L_0x0083
            r4.f13146e = r1
            int r5 = r7.getPointerId(r3)
            r4.f13145d = r5
            r4.c()
        L_0x0083:
            android.view.VelocityTracker r5 = r4.f13148g
            if (r5 == 0) goto L_0x008a
            r5.addMovement(r7)
        L_0x008a:
            boolean r5 = r4.f13144c
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.a.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        if (r0 != 3) goto L_0x00ae;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r11.f13147f
            if (r0 >= 0) goto L_0x0012
            android.content.Context r0 = r12.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r11.f13147f = r0
        L_0x0012:
            int r0 = r14.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x008d
            r3 = -1
            if (r0 == r1) goto L_0x005c
            r4 = 2
            if (r0 == r4) goto L_0x0025
            r12 = 3
            if (r0 == r12) goto L_0x007e
            goto L_0x00ae
        L_0x0025:
            int r0 = r11.f13145d
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r3) goto L_0x002e
            return r2
        L_0x002e:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r2 = r11.f13146e
            int r2 = r2 - r0
            boolean r3 = r11.f13144c
            if (r3 != 0) goto L_0x0049
            int r3 = java.lang.Math.abs(r2)
            int r4 = r11.f13147f
            if (r3 <= r4) goto L_0x0049
            r11.f13144c = r1
            if (r2 <= 0) goto L_0x0048
            int r2 = r2 - r4
            goto L_0x0049
        L_0x0048:
            int r2 = r2 + r4
        L_0x0049:
            r6 = r2
            boolean r2 = r11.f13144c
            if (r2 == 0) goto L_0x00ae
            r11.f13146e = r0
            int r7 = r11.b(r13)
            r8 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r3.b(r4, r5, r6, r7, r8)
            goto L_0x00ae
        L_0x005c:
            android.view.VelocityTracker r0 = r11.f13148g
            if (r0 == 0) goto L_0x007e
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f13148g
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f13148g
            int r4 = r11.f13145d
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.a(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.a((androidx.coordinatorlayout.widget.CoordinatorLayout) r6, r7, (int) r8, (int) r9, (float) r10)
        L_0x007e:
            r11.f13144c = r2
            r11.f13145d = r3
            android.view.VelocityTracker r12 = r11.f13148g
            if (r12 == 0) goto L_0x00ae
            r12.recycle()
            r12 = 0
            r11.f13148g = r12
            goto L_0x00ae
        L_0x008d:
            float r0 = r14.getX()
            int r0 = (int) r0
            float r3 = r14.getY()
            int r3 = (int) r3
            boolean r12 = r12.a((android.view.View) r13, (int) r0, (int) r3)
            if (r12 == 0) goto L_0x00b6
            boolean r12 = r11.c(r13)
            if (r12 == 0) goto L_0x00b6
            r11.f13146e = r3
            int r12 = r14.getPointerId(r2)
            r11.f13145d = r12
            r11.c()
        L_0x00ae:
            android.view.VelocityTracker r12 = r11.f13148g
            if (r12 == 0) goto L_0x00b5
            r12.addMovement(r14)
        L_0x00b5:
            return r1
        L_0x00b6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.a.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public int a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return a(coordinatorLayout, v, i, (int) RNCartPanelDataEntity.NULL_VALUE, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    public int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int b2 = b();
        if (i2 != 0 && b2 >= i2 && b2 <= i3) {
            int a2 = androidx.core.b.a.a(i, i2, i3);
            if (b2 != a2) {
                a(a2);
                return b2 - a2;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return b();
    }

    /* access modifiers changed from: package-private */
    public final int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return a(coordinatorLayout, v, a() - i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f2) {
        V v2 = v;
        Runnable runnable = this.f13143b;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f13143b = null;
        }
        if (this.f13142a == null) {
            this.f13142a = new OverScroller(v.getContext());
        }
        this.f13142a.fling(0, b(), 0, Math.round(f2), 0, 0, i, i2);
        if (this.f13142a.computeScrollOffset()) {
            CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
            this.f13143b = new C0215a(coordinatorLayout, v);
            w.a((View) v, this.f13143b);
            return true;
        }
        CoordinatorLayout coordinatorLayout3 = coordinatorLayout;
        a(coordinatorLayout, v);
        return false;
    }

    /* access modifiers changed from: package-private */
    public int b(V v) {
        return -v.getHeight();
    }

    /* access modifiers changed from: package-private */
    public int a(V v) {
        return v.getHeight();
    }

    private void c() {
        if (this.f13148g == null) {
            this.f13148g = VelocityTracker.obtain();
        }
    }

    /* renamed from: com.google.android.material.appbar.a$a  reason: collision with other inner class name */
    private class C0215a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final CoordinatorLayout f13150b;

        /* renamed from: c  reason: collision with root package name */
        private final V f13151c;

        C0215a(CoordinatorLayout coordinatorLayout, V v) {
            this.f13150b = coordinatorLayout;
            this.f13151c = v;
        }

        public void run() {
            if (this.f13151c != null && a.this.f13142a != null) {
                if (a.this.f13142a.computeScrollOffset()) {
                    a aVar = a.this;
                    aVar.a_(this.f13150b, this.f13151c, aVar.f13142a.getCurrY());
                    w.a((View) this.f13151c, (Runnable) this);
                    return;
                }
                a.this.a(this.f13150b, this.f13151c);
            }
        }
    }
}
