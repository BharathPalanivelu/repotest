package com.garena.android.appkit.btmsheet;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.g.i;
import androidx.core.g.w;
import androidx.customview.a.a;

public class ClosableSlidingLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    View f7631a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final float f7632b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public androidx.customview.a.a f7633c;

    /* renamed from: d  reason: collision with root package name */
    private a f7634d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f7635e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f7636f;

    /* renamed from: g  reason: collision with root package name */
    private int f7637g;
    private boolean h;
    private float i;

    interface a {
        void a();
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
    }

    public ClosableSlidingLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ClosableSlidingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @TargetApi(11)
    public ClosableSlidingLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7633c = androidx.customview.a.a.a((ViewGroup) this, 0.8f, (a.C0039a) new b());
        this.f7632b = getResources().getDisplayMetrics().density * 400.0f;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int a2 = i.a(motionEvent);
        if (isEnabled() && !a()) {
            if (a2 == 3 || a2 == 1) {
                this.f7633c.e();
                this.f7637g = -1;
                this.h = false;
            } else {
                if (a2 == 0) {
                    this.f7635e = getChildAt(0).getHeight();
                    this.f7636f = getChildAt(0).getTop();
                    this.f7637g = i.b(motionEvent, 0);
                    this.h = false;
                    float a3 = a(motionEvent, this.f7637g);
                    if (a3 == -1.0f) {
                        return false;
                    }
                    this.i = a3;
                } else if (a2 == 2) {
                    int i2 = this.f7637g;
                    if (i2 == -1) {
                        return false;
                    }
                    float a4 = a(motionEvent, i2);
                    if (a4 == -1.0f) {
                        return false;
                    }
                    if (a4 - this.i > ((float) this.f7633c.d()) && !this.h) {
                        this.h = true;
                        this.f7633c.a(getChildAt(0), 0);
                    }
                }
                this.f7633c.a(motionEvent);
                return this.h;
            }
        }
        return false;
    }

    private boolean a() {
        if (this.f7631a == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            return w.b(this.f7631a, -1);
        }
        View view = this.f7631a;
        if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            if (absListView.getChildCount() <= 0) {
                return false;
            }
            if (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop()) {
                return true;
            }
            return false;
        } else if (view.getScrollY() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private float a(MotionEvent motionEvent, int i2) {
        int a2 = i.a(motionEvent, i2);
        if (a2 < 0) {
            return -1.0f;
        }
        return i.d(motionEvent, a2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || a()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            this.f7633c.b(motionEvent);
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public void computeScroll() {
        if (this.f7633c.a(true)) {
            w.e(this);
        }
    }

    public void setSlideListener(a aVar) {
        this.f7634d = aVar;
    }

    private class b extends a.C0039a {
        public void a(int i) {
        }

        public boolean b(View view, int i) {
            return true;
        }

        private b() {
        }

        public void a(View view, float f2, float f3) {
            if (f3 > ClosableSlidingLayout.this.f7632b) {
                ClosableSlidingLayout.this.a(view);
            } else if (f3 >= (-ClosableSlidingLayout.this.f7632b)) {
                if (view.getTop() >= ClosableSlidingLayout.this.f7636f + (ClosableSlidingLayout.this.f7635e / 2)) {
                    ClosableSlidingLayout.this.a(view);
                } else {
                    ClosableSlidingLayout.this.f7633c.a(view, 0, ClosableSlidingLayout.this.f7636f);
                }
            }
            w.e(ClosableSlidingLayout.this);
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            if (Build.VERSION.SDK_INT < 11) {
                ClosableSlidingLayout.this.invalidate();
            }
        }

        public int b(View view, int i, int i2) {
            return Math.max(i, ClosableSlidingLayout.this.f7636f);
        }
    }

    /* access modifiers changed from: private */
    public void a(View view) {
        a aVar = this.f7634d;
        if (aVar != null) {
            aVar.a();
        }
        this.f7633c.f();
        w.e(this);
    }
}
