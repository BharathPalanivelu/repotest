package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.w;
import androidx.customview.a.a;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.b<V> {

    /* renamed from: a  reason: collision with root package name */
    int f13244a;

    /* renamed from: b  reason: collision with root package name */
    int f13245b;

    /* renamed from: c  reason: collision with root package name */
    int f13246c;

    /* renamed from: d  reason: collision with root package name */
    boolean f13247d;

    /* renamed from: e  reason: collision with root package name */
    int f13248e = 4;

    /* renamed from: f  reason: collision with root package name */
    androidx.customview.a.a f13249f;

    /* renamed from: g  reason: collision with root package name */
    int f13250g;
    WeakReference<V> h;
    WeakReference<View> i;
    int j;
    boolean k;
    /* access modifiers changed from: private */
    public boolean l = true;
    private float m;
    private int n;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private a v;
    private VelocityTracker w;
    private int x;
    private Map<View, Integer> y;
    private final a.C0039a z = new a.C0039a() {
        public boolean b(View view, int i) {
            if (BottomSheetBehavior.this.f13248e == 1 || BottomSheetBehavior.this.k) {
                return false;
            }
            if (BottomSheetBehavior.this.f13248e == 3 && BottomSheetBehavior.this.j == i) {
                View view2 = (View) BottomSheetBehavior.this.i.get();
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            if (BottomSheetBehavior.this.h == null || BottomSheetBehavior.this.h.get() != view) {
                return false;
            }
            return true;
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.d(i2);
        }

        public void a(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.c(1);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x00e2  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00f3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.view.View r8, float r9, float r10) {
            /*
                r7 = this;
                r0 = 0
                r1 = 0
                r2 = 4
                r3 = 6
                r4 = 3
                int r5 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
                if (r5 >= 0) goto L_0x002c
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.l
                if (r9 == 0) goto L_0x0018
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r9 = r9.f13244a
            L_0x0015:
                r2 = 3
                goto L_0x00d4
            L_0x0018:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.f13245b
                if (r9 <= r10) goto L_0x002a
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r9.f13245b
            L_0x0026:
                r9 = r0
                r2 = 6
                goto L_0x00d4
            L_0x002a:
                r9 = 0
                goto L_0x0015
            L_0x002c:
                com.google.android.material.bottomsheet.BottomSheetBehavior r5 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r5 = r5.f13247d
                if (r5 == 0) goto L_0x0057
                com.google.android.material.bottomsheet.BottomSheetBehavior r5 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r5 = r5.a((android.view.View) r8, (float) r10)
                if (r5 == 0) goto L_0x0057
                int r5 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = r6.f13246c
                if (r5 > r6) goto L_0x0050
                float r5 = java.lang.Math.abs(r9)
                float r6 = java.lang.Math.abs(r10)
                int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                if (r5 >= 0) goto L_0x0057
            L_0x0050:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r9 = r9.f13250g
                r2 = 5
                goto L_0x00d4
            L_0x0057:
                int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
                if (r1 == 0) goto L_0x006d
                float r9 = java.lang.Math.abs(r9)
                float r10 = java.lang.Math.abs(r10)
                int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
                if (r9 <= 0) goto L_0x0068
                goto L_0x006d
            L_0x0068:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r9 = r9.f13246c
                goto L_0x00d4
            L_0x006d:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r10.l
                if (r10 == 0) goto L_0x009a
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.f13244a
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.f13246c
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x0094
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r9.f13244a
                r9 = r0
                goto L_0x0015
            L_0x0094:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r9.f13246c
            L_0x0098:
                r9 = r0
                goto L_0x00d4
            L_0x009a:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.f13245b
                if (r9 >= r10) goto L_0x00b4
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.f13246c
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                if (r9 >= r10) goto L_0x00ae
                goto L_0x002a
            L_0x00ae:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r9.f13245b
                goto L_0x0026
            L_0x00b4:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.f13245b
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.f13246c
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00cf
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r9.f13245b
                goto L_0x0026
            L_0x00cf:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r9.f13246c
                goto L_0x0098
            L_0x00d4:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                androidx.customview.a.a r10 = r10.f13249f
                int r0 = r8.getLeft()
                boolean r9 = r10.a((int) r0, (int) r9)
                if (r9 == 0) goto L_0x00f3
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                r10 = 2
                r9.c((int) r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior$b r9 = new com.google.android.material.bottomsheet.BottomSheetBehavior$b
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                r9.<init>(r8, r2)
                androidx.core.g.w.a((android.view.View) r8, (java.lang.Runnable) r9)
                goto L_0x00f8
            L_0x00f3:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                r8.c((int) r2)
            L_0x00f8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass2.a(android.view.View, float, float):void");
        }

        public int b(View view, int i, int i2) {
            return androidx.core.b.a.a(i, BottomSheetBehavior.this.f(), BottomSheetBehavior.this.f13247d ? BottomSheetBehavior.this.f13250g : BottomSheetBehavior.this.f13246c);
        }

        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        public int b(View view) {
            if (BottomSheetBehavior.this.f13247d) {
                return BottomSheetBehavior.this.f13250g;
            }
            return BottomSheetBehavior.this.f13246c;
        }
    };

    public static abstract class a {
        public abstract void onSlide(View view, float f2);

        public abstract void onStateChanged(View view, int i);
    }

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(a.k.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            a(obtainStyledAttributes.getDimensionPixelSize(a.k.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            a(peekValue.data);
        }
        b(obtainStyledAttributes.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_hideable, false));
        a(obtainStyledAttributes.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        c(obtainStyledAttributes.getBoolean(a.k.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.m = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v2) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v2), this.f13248e);
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v2, savedState.a());
        if (savedState.f13255a == 1 || savedState.f13255a == 2) {
            this.f13248e = 4;
        } else {
            this.f13248e = savedState.f13255a;
        }
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        if (w.t(coordinatorLayout) && !w.t(v2)) {
            v2.setFitsSystemWindows(true);
        }
        int top = v2.getTop();
        coordinatorLayout.b((View) v2, i2);
        this.f13250g = coordinatorLayout.getHeight();
        if (this.o) {
            if (this.p == 0) {
                this.p = coordinatorLayout.getResources().getDimensionPixelSize(a.d.design_bottom_sheet_peek_height_min);
            }
            this.q = Math.max(this.p, this.f13250g - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.q = this.n;
        }
        this.f13244a = Math.max(0, this.f13250g - v2.getHeight());
        this.f13245b = this.f13250g / 2;
        c();
        int i3 = this.f13248e;
        if (i3 == 3) {
            w.h(v2, f());
        } else if (i3 == 6) {
            w.h(v2, this.f13245b);
        } else if (!this.f13247d || i3 != 5) {
            int i4 = this.f13248e;
            if (i4 == 4) {
                w.h(v2, this.f13246c);
            } else if (i4 == 1 || i4 == 2) {
                w.h(v2, top - v2.getTop());
            }
        } else {
            w.h(v2, this.f13250g);
        }
        if (this.f13249f == null) {
            this.f13249f = androidx.customview.a.a.a((ViewGroup) coordinatorLayout, this.z);
        }
        this.h = new WeakReference<>(v2);
        this.i = new WeakReference<>(a((View) v2));
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r9, V r10, android.view.MotionEvent r11) {
        /*
            r8 = this;
            boolean r0 = r10.isShown()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000b
            r8.s = r2
            return r1
        L_0x000b:
            int r0 = r11.getActionMasked()
            if (r0 != 0) goto L_0x0014
            r8.d()
        L_0x0014:
            android.view.VelocityTracker r3 = r8.w
            if (r3 != 0) goto L_0x001e
            android.view.VelocityTracker r3 = android.view.VelocityTracker.obtain()
            r8.w = r3
        L_0x001e:
            android.view.VelocityTracker r3 = r8.w
            r3.addMovement(r11)
            r3 = 0
            r4 = -1
            if (r0 == 0) goto L_0x0038
            if (r0 == r2) goto L_0x002d
            r10 = 3
            if (r0 == r10) goto L_0x002d
            goto L_0x0077
        L_0x002d:
            r8.k = r1
            r8.j = r4
            boolean r10 = r8.s
            if (r10 == 0) goto L_0x0077
            r8.s = r1
            return r1
        L_0x0038:
            float r5 = r11.getX()
            int r5 = (int) r5
            float r6 = r11.getY()
            int r6 = (int) r6
            r8.x = r6
            java.lang.ref.WeakReference<android.view.View> r6 = r8.i
            if (r6 == 0) goto L_0x004f
            java.lang.Object r6 = r6.get()
            android.view.View r6 = (android.view.View) r6
            goto L_0x0050
        L_0x004f:
            r6 = r3
        L_0x0050:
            if (r6 == 0) goto L_0x0066
            int r7 = r8.x
            boolean r6 = r9.a((android.view.View) r6, (int) r5, (int) r7)
            if (r6 == 0) goto L_0x0066
            int r6 = r11.getActionIndex()
            int r6 = r11.getPointerId(r6)
            r8.j = r6
            r8.k = r2
        L_0x0066:
            int r6 = r8.j
            if (r6 != r4) goto L_0x0074
            int r4 = r8.x
            boolean r10 = r9.a((android.view.View) r10, (int) r5, (int) r4)
            if (r10 != 0) goto L_0x0074
            r10 = 1
            goto L_0x0075
        L_0x0074:
            r10 = 0
        L_0x0075:
            r8.s = r10
        L_0x0077:
            boolean r10 = r8.s
            if (r10 != 0) goto L_0x0086
            androidx.customview.a.a r10 = r8.f13249f
            if (r10 == 0) goto L_0x0086
            boolean r10 = r10.a((android.view.MotionEvent) r11)
            if (r10 == 0) goto L_0x0086
            return r2
        L_0x0086:
            java.lang.ref.WeakReference<android.view.View> r10 = r8.i
            if (r10 == 0) goto L_0x0091
            java.lang.Object r10 = r10.get()
            r3 = r10
            android.view.View r3 = (android.view.View) r3
        L_0x0091:
            r10 = 2
            if (r0 != r10) goto L_0x00ca
            if (r3 == 0) goto L_0x00ca
            boolean r10 = r8.s
            if (r10 != 0) goto L_0x00ca
            int r10 = r8.f13248e
            if (r10 == r2) goto L_0x00ca
            float r10 = r11.getX()
            int r10 = (int) r10
            float r0 = r11.getY()
            int r0 = (int) r0
            boolean r9 = r9.a((android.view.View) r3, (int) r10, (int) r0)
            if (r9 != 0) goto L_0x00ca
            androidx.customview.a.a r9 = r8.f13249f
            if (r9 == 0) goto L_0x00ca
            int r9 = r8.x
            float r9 = (float) r9
            float r10 = r11.getY()
            float r9 = r9 - r10
            float r9 = java.lang.Math.abs(r9)
            androidx.customview.a.a r10 = r8.f13249f
            int r10 = r10.d()
            float r10 = (float) r10
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x00ca
            r1 = 1
        L_0x00ca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f13248e == 1 && actionMasked == 0) {
            return true;
        }
        androidx.customview.a.a aVar = this.f13249f;
        if (aVar != null) {
            aVar.b(motionEvent);
        }
        if (actionMasked == 0) {
            d();
        }
        if (this.w == null) {
            this.w = VelocityTracker.obtain();
        }
        this.w.addMovement(motionEvent);
        if (actionMasked == 2 && !this.s && Math.abs(((float) this.x) - motionEvent.getY()) > ((float) this.f13249f.d())) {
            this.f13249f.a((View) v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.s;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
        this.t = 0;
        this.u = false;
        if ((i2 & 2) != 0) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 != 1 && view == ((View) this.i.get())) {
            int top = v2.getTop();
            int i5 = top - i3;
            if (i3 > 0) {
                if (i5 < f()) {
                    iArr[1] = top - f();
                    w.h(v2, -iArr[1]);
                    c(3);
                } else {
                    iArr[1] = i3;
                    w.h(v2, -i3);
                    c(1);
                }
            } else if (i3 < 0 && !view.canScrollVertically(-1)) {
                int i6 = this.f13246c;
                if (i5 <= i6 || this.f13247d) {
                    iArr[1] = i3;
                    w.h(v2, -i3);
                    c(1);
                } else {
                    iArr[1] = top - i6;
                    w.h(v2, -iArr[1]);
                    c(4);
                }
            }
            d(v2.getTop());
            this.t = i3;
            this.u = true;
        }
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View view, int i2) {
        int i3;
        int i4;
        int i5 = 3;
        if (v2.getTop() == f()) {
            c(3);
        } else if (view == this.i.get() && this.u) {
            if (this.t > 0) {
                i3 = f();
            } else if (!this.f13247d || !a((View) v2, e())) {
                if (this.t == 0) {
                    int top = v2.getTop();
                    if (!this.l) {
                        int i6 = this.f13245b;
                        if (top < i6) {
                            if (top < Math.abs(top - this.f13246c)) {
                                i3 = 0;
                            } else {
                                i3 = this.f13245b;
                            }
                        } else if (Math.abs(top - i6) < Math.abs(top - this.f13246c)) {
                            i3 = this.f13245b;
                        } else {
                            i4 = this.f13246c;
                        }
                        i5 = 6;
                    } else if (Math.abs(top - this.f13244a) < Math.abs(top - this.f13246c)) {
                        i3 = this.f13244a;
                    } else {
                        i4 = this.f13246c;
                    }
                } else {
                    i4 = this.f13246c;
                }
                i5 = 4;
            } else {
                i3 = this.f13250g;
                i5 = 5;
            }
            if (this.f13249f.a((View) v2, v2.getLeft(), i3)) {
                c(2);
                w.a((View) v2, (Runnable) new b(v2, i5));
            } else {
                c(i5);
            }
            this.u = false;
        }
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
        return view == this.i.get() && (this.f13248e != 3 || super.onNestedPreFling(coordinatorLayout, v2, view, f2, f3));
    }

    public void a(boolean z2) {
        if (this.l != z2) {
            this.l = z2;
            if (this.h != null) {
                c();
            }
            c((!this.l || this.f13248e != 6) ? this.f13248e : 3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto L_0x000c
            boolean r4 = r3.o
            if (r4 != 0) goto L_0x0015
            r3.o = r0
            goto L_0x0024
        L_0x000c:
            boolean r2 = r3.o
            if (r2 != 0) goto L_0x0017
            int r2 = r3.n
            if (r2 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x0024
        L_0x0017:
            r3.o = r1
            int r1 = java.lang.Math.max(r1, r4)
            r3.n = r1
            int r1 = r3.f13250g
            int r1 = r1 - r4
            r3.f13246c = r1
        L_0x0024:
            if (r0 == 0) goto L_0x003a
            int r4 = r3.f13248e
            r0 = 4
            if (r4 != r0) goto L_0x003a
            java.lang.ref.WeakReference<V> r4 = r3.h
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x003a
            r4.requestLayout()
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.a(int):void");
    }

    public final int a() {
        if (this.o) {
            return -1;
        }
        return this.n;
    }

    public void b(boolean z2) {
        this.f13247d = z2;
    }

    public void c(boolean z2) {
        this.r = z2;
    }

    public void a(a aVar) {
        this.v = aVar;
    }

    public final void b(final int i2) {
        if (i2 != this.f13248e) {
            WeakReference<V> weakReference = this.h;
            if (weakReference != null) {
                final View view = (View) weakReference.get();
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent == null || !parent.isLayoutRequested() || !w.D(view)) {
                        a(view, i2);
                    } else {
                        view.post(new Runnable() {
                            public void run() {
                                BottomSheetBehavior.this.a(view, i2);
                            }
                        });
                    }
                }
            } else if (i2 == 4 || i2 == 3 || i2 == 6 || (this.f13247d && i2 == 5)) {
                this.f13248e = i2;
            }
        }
    }

    public final int b() {
        return this.f13248e;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        if (this.f13248e != i2) {
            this.f13248e = i2;
            if (i2 == 6 || i2 == 3) {
                d(true);
            } else if (i2 == 5 || i2 == 4) {
                d(false);
            }
            View view = (View) this.h.get();
            if (view != null) {
                a aVar = this.v;
                if (aVar != null) {
                    aVar.onStateChanged(view, i2);
                }
            }
        }
    }

    private void c() {
        if (this.l) {
            this.f13246c = Math.max(this.f13250g - this.q, this.f13244a);
        } else {
            this.f13246c = this.f13250g - this.q;
        }
    }

    private void d() {
        this.j = -1;
        VelocityTracker velocityTracker = this.w;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.w = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view, float f2) {
        if (this.r) {
            return true;
        }
        if (view.getTop() >= this.f13246c && Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.f13246c)) / ((float) this.n) > 0.5f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public View a(View view) {
        if (w.y(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View a2 = a(viewGroup.getChildAt(i2));
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    private float e() {
        VelocityTracker velocityTracker = this.w;
        if (velocityTracker == null) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        velocityTracker.computeCurrentVelocity(1000, this.m);
        return this.w.getYVelocity(this.j);
    }

    /* access modifiers changed from: private */
    public int f() {
        if (this.l) {
            return this.f13244a;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i2) {
        int i3;
        if (i2 == 4) {
            i3 = this.f13246c;
        } else if (i2 == 6) {
            int i4 = this.f13245b;
            if (this.l) {
                int i5 = this.f13244a;
                if (i4 <= i5) {
                    i3 = i5;
                    i2 = 3;
                }
            }
            i3 = i4;
        } else if (i2 == 3) {
            i3 = f();
        } else if (!this.f13247d || i2 != 5) {
            throw new IllegalArgumentException("Illegal state argument: " + i2);
        } else {
            i3 = this.f13250g;
        }
        if (this.f13249f.a(view, view.getLeft(), i3)) {
            c(2);
            w.a(view, (Runnable) new b(view, i2));
            return;
        }
        c(i2);
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        View view = (View) this.h.get();
        if (view != null) {
            a aVar = this.v;
            if (aVar != null) {
                int i3 = this.f13246c;
                if (i2 > i3) {
                    aVar.onSlide(view, ((float) (i3 - i2)) / ((float) (this.f13250g - i3)));
                } else {
                    aVar.onSlide(view, ((float) (i3 - i2)) / ((float) (i3 - f())));
                }
            }
        }
    }

    private class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final View f13257b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13258c;

        b(View view, int i) {
            this.f13257b = view;
            this.f13258c = i;
        }

        public void run() {
            if (BottomSheetBehavior.this.f13249f == null || !BottomSheetBehavior.this.f13249f.a(true)) {
                BottomSheetBehavior.this.c(this.f13258c);
            } else {
                w.a(this.f13257b, (Runnable) this);
            }
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        final int f13255a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13255a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.f13255a = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f13255a);
        }
    }

    public static <V extends View> BottomSheetBehavior<V> b(V v2) {
        ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.e) {
            CoordinatorLayout.b b2 = ((CoordinatorLayout.e) layoutParams).b();
            if (b2 instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) b2;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private void d(boolean z2) {
        WeakReference<V> weakReference = this.h;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (Build.VERSION.SDK_INT >= 16 && z2) {
                    if (this.y == null) {
                        this.y = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.h.get()) {
                        if (!z2) {
                            Map<View, Integer> map = this.y;
                            if (map != null && map.containsKey(childAt)) {
                                w.d(childAt, this.y.get(childAt).intValue());
                            }
                        } else {
                            if (Build.VERSION.SDK_INT >= 16) {
                                this.y.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            }
                            w.d(childAt, 4);
                        }
                    }
                }
                if (!z2) {
                    this.y = null;
                }
            }
        }
    }
}
