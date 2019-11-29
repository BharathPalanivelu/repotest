package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.w;
import androidx.customview.a.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.b<V> {

    /* renamed from: a  reason: collision with root package name */
    androidx.customview.a.a f13182a;

    /* renamed from: b  reason: collision with root package name */
    a f13183b;

    /* renamed from: c  reason: collision with root package name */
    int f13184c = 2;

    /* renamed from: d  reason: collision with root package name */
    float f13185d = 0.5f;

    /* renamed from: e  reason: collision with root package name */
    float f13186e = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: f  reason: collision with root package name */
    float f13187f = 0.5f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13188g;
    private float h = BitmapDescriptorFactory.HUE_RED;
    private boolean i;
    private final a.C0039a j = new a.C0039a() {

        /* renamed from: b  reason: collision with root package name */
        private int f13190b;

        /* renamed from: c  reason: collision with root package name */
        private int f13191c = -1;

        public boolean b(View view, int i) {
            return this.f13191c == -1 && SwipeDismissBehavior.this.a(view);
        }

        public void a(View view, int i) {
            this.f13191c = i;
            this.f13190b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public void a(int i) {
            if (SwipeDismissBehavior.this.f13183b != null) {
                SwipeDismissBehavior.this.f13183b.a(i);
            }
        }

        public void a(View view, float f2, float f3) {
            boolean z;
            int i;
            this.f13191c = -1;
            int width = view.getWidth();
            if (a(view, f2)) {
                int left = view.getLeft();
                int i2 = this.f13190b;
                i = left < i2 ? i2 - width : i2 + width;
                z = true;
            } else {
                i = this.f13190b;
                z = false;
            }
            if (SwipeDismissBehavior.this.f13182a.a(i, view.getTop())) {
                w.a(view, (Runnable) new b(view, z));
            } else if (z && SwipeDismissBehavior.this.f13183b != null) {
                SwipeDismissBehavior.this.f13183b.a(view);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0029 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x003c A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean a(android.view.View r6, float r7) {
            /*
                r5 = this;
                r0 = 0
                r1 = 0
                r2 = 1
                int r3 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r3 == 0) goto L_0x003e
                int r6 = androidx.core.g.w.g(r6)
                if (r6 != r2) goto L_0x000f
                r6 = 1
                goto L_0x0010
            L_0x000f:
                r6 = 0
            L_0x0010:
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r3 = r3.f13184c
                r4 = 2
                if (r3 != r4) goto L_0x0018
                return r2
            L_0x0018:
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r3 = r3.f13184c
                if (r3 != 0) goto L_0x002b
                if (r6 == 0) goto L_0x0025
                int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r6 >= 0) goto L_0x002a
                goto L_0x0029
            L_0x0025:
                int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r6 <= 0) goto L_0x002a
            L_0x0029:
                r1 = 1
            L_0x002a:
                return r1
            L_0x002b:
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r3 = r3.f13184c
                if (r3 != r2) goto L_0x003d
                if (r6 == 0) goto L_0x0038
                int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r6 <= 0) goto L_0x003d
                goto L_0x003c
            L_0x0038:
                int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r6 >= 0) goto L_0x003d
            L_0x003c:
                r1 = 1
            L_0x003d:
                return r1
            L_0x003e:
                int r7 = r6.getLeft()
                int r0 = r5.f13190b
                int r7 = r7 - r0
                int r6 = r6.getWidth()
                float r6 = (float) r6
                com.google.android.material.behavior.SwipeDismissBehavior r0 = com.google.android.material.behavior.SwipeDismissBehavior.this
                float r0 = r0.f13185d
                float r6 = r6 * r0
                int r6 = java.lang.Math.round(r6)
                int r7 = java.lang.Math.abs(r7)
                if (r7 < r6) goto L_0x005b
                r1 = 1
            L_0x005b:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1.a(android.view.View, float):boolean");
        }

        public int a(View view) {
            return view.getWidth();
        }

        public int a(View view, int i, int i2) {
            int i3;
            int i4;
            int width;
            boolean z = w.g(view) == 1;
            if (SwipeDismissBehavior.this.f13184c != 0) {
                if (SwipeDismissBehavior.this.f13184c != 1) {
                    i3 = this.f13190b - view.getWidth();
                    i4 = view.getWidth() + this.f13190b;
                } else if (z) {
                    i3 = this.f13190b;
                    width = view.getWidth();
                } else {
                    i3 = this.f13190b - view.getWidth();
                    i4 = this.f13190b;
                }
                return SwipeDismissBehavior.a(i3, i, i4);
            } else if (z) {
                i3 = this.f13190b - view.getWidth();
                i4 = this.f13190b;
                return SwipeDismissBehavior.a(i3, i, i4);
            } else {
                i3 = this.f13190b;
                width = view.getWidth();
            }
            i4 = width + i3;
            return SwipeDismissBehavior.a(i3, i, i4);
        }

        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            float width = ((float) this.f13190b) + (((float) view.getWidth()) * SwipeDismissBehavior.this.f13186e);
            float width2 = ((float) this.f13190b) + (((float) view.getWidth()) * SwipeDismissBehavior.this.f13187f);
            float f2 = (float) i;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(BitmapDescriptorFactory.HUE_RED);
            } else {
                view.setAlpha(SwipeDismissBehavior.a((float) BitmapDescriptorFactory.HUE_RED, 1.0f - SwipeDismissBehavior.b(width, width2, f2), 1.0f));
            }
        }
    };

    public interface a {
        void a(int i);

        void a(View view);
    }

    static float b(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    public boolean a(View view) {
        return true;
    }

    public void a(a aVar) {
        this.f13183b = aVar;
    }

    public void a(int i2) {
        this.f13184c = i2;
    }

    public void a(float f2) {
        this.f13186e = a((float) BitmapDescriptorFactory.HUE_RED, f2, 1.0f);
    }

    public void b(float f2) {
        this.f13187f = a((float) BitmapDescriptorFactory.HUE_RED, f2, 1.0f);
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f13188g;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f13188g = coordinatorLayout.a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
            z = this.f13188g;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f13188g = false;
        }
        if (!z) {
            return false;
        }
        a((ViewGroup) coordinatorLayout);
        return this.f13182a.a(motionEvent);
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        androidx.customview.a.a aVar = this.f13182a;
        if (aVar == null) {
            return false;
        }
        aVar.b(motionEvent);
        return true;
    }

    private void a(ViewGroup viewGroup) {
        androidx.customview.a.a aVar;
        if (this.f13182a == null) {
            if (this.i) {
                aVar = androidx.customview.a.a.a(viewGroup, this.h, this.j);
            } else {
                aVar = androidx.customview.a.a.a(viewGroup, this.j);
            }
            this.f13182a = aVar;
        }
    }

    private class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final View f13193b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f13194c;

        b(View view, boolean z) {
            this.f13193b = view;
            this.f13194c = z;
        }

        public void run() {
            if (SwipeDismissBehavior.this.f13182a != null && SwipeDismissBehavior.this.f13182a.a(true)) {
                w.a(this.f13193b, (Runnable) this);
            } else if (this.f13194c && SwipeDismissBehavior.this.f13183b != null) {
                SwipeDismissBehavior.this.f13183b.a(this.f13193b);
            }
        }
    }

    static float a(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static int a(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }
}
