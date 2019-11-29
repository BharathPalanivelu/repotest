package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.a.c;
import androidx.core.g.ae;
import androidx.core.g.r;
import androidx.core.g.w;
import com.facebook.common.util.ByteConstants;
import com.google.android.material.a;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.l;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.b;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a  reason: collision with root package name */
    static final Handler f13426a = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ((BaseTransientBottomBar) message.obj).i();
                return true;
            } else if (i != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).c(message.arg1);
                return true;
            }
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f13427d = (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19);

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f13428e = {a.b.snackbarStyle};

    /* renamed from: b  reason: collision with root package name */
    protected final e f13429b;

    /* renamed from: c  reason: collision with root package name */
    final b.a f13430c = new b.a() {
        public void a() {
            BaseTransientBottomBar.f13426a.sendMessage(BaseTransientBottomBar.f13426a.obtainMessage(0, BaseTransientBottomBar.this));
        }

        public void a(int i) {
            BaseTransientBottomBar.f13426a.sendMessage(BaseTransientBottomBar.f13426a.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final ViewGroup f13431f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f13432g;
    /* access modifiers changed from: private */
    public final a h;
    private int i;
    private List<a<B>> j;
    private Behavior k;
    private final AccessibilityManager l;

    public static abstract class a<B> {
        public void a(B b2) {
        }

        public void a(B b2, int i) {
        }
    }

    protected interface c {
        void a(View view);

        void b(View view);
    }

    protected interface d {
        void a(View view, int i, int i2, int i3, int i4);
    }

    protected BaseTransientBottomBar(ViewGroup viewGroup, View view, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (aVar != null) {
            this.f13431f = viewGroup;
            this.h = aVar;
            this.f13432g = viewGroup.getContext();
            l.a(this.f13432g);
            this.f13429b = (e) LayoutInflater.from(this.f13432g).inflate(a(), this.f13431f, false);
            this.f13429b.addView(view);
            w.f(this.f13429b, 1);
            w.d((View) this.f13429b, 1);
            w.b((View) this.f13429b, true);
            w.a((View) this.f13429b, (r) new r() {
                public ae a(View view, ae aeVar) {
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), aeVar.d());
                    return aeVar;
                }
            });
            w.a((View) this.f13429b, (androidx.core.g.a) new androidx.core.g.a() {
                public void onInitializeAccessibilityNodeInfo(View view, androidx.core.g.a.d dVar) {
                    super.onInitializeAccessibilityNodeInfo(view, dVar);
                    dVar.a((int) ByteConstants.MB);
                    dVar.n(true);
                }

                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    if (i != 1048576) {
                        return super.performAccessibilityAction(view, i, bundle);
                    }
                    BaseTransientBottomBar.this.f();
                    return true;
                }
            });
            this.l = (AccessibilityManager) this.f13432g.getSystemService("accessibility");
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    /* access modifiers changed from: protected */
    public int a() {
        return b() ? a.h.mtrl_layout_snackbar : a.h.design_layout_snackbar;
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        TypedArray obtainStyledAttributes = this.f13432g.obtainStyledAttributes(f13428e);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        if (resourceId != -1) {
            return true;
        }
        return false;
    }

    public B a(int i2) {
        this.i = i2;
        return this;
    }

    public int c() {
        return this.i;
    }

    public View d() {
        return this.f13429b;
    }

    public void e() {
        b.a().a(c(), this.f13430c);
    }

    public void f() {
        b(3);
    }

    /* access modifiers changed from: protected */
    public void b(int i2) {
        b.a().a(this.f13430c, i2);
    }

    public boolean g() {
        return b.a().e(this.f13430c);
    }

    /* access modifiers changed from: protected */
    public SwipeDismissBehavior<? extends View> h() {
        return new Behavior();
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        if (this.f13429b.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f13429b.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                CoordinatorLayout.e eVar = (CoordinatorLayout.e) layoutParams;
                SwipeDismissBehavior swipeDismissBehavior = this.k;
                if (swipeDismissBehavior == null) {
                    swipeDismissBehavior = h();
                }
                if (swipeDismissBehavior instanceof Behavior) {
                    ((Behavior) swipeDismissBehavior).a((BaseTransientBottomBar<?>) this);
                }
                swipeDismissBehavior.a((SwipeDismissBehavior.a) new SwipeDismissBehavior.a() {
                    public void a(View view) {
                        view.setVisibility(8);
                        BaseTransientBottomBar.this.b(0);
                    }

                    public void a(int i) {
                        if (i == 0) {
                            b.a().d(BaseTransientBottomBar.this.f13430c);
                        } else if (i == 1 || i == 2) {
                            b.a().c(BaseTransientBottomBar.this.f13430c);
                        }
                    }
                });
                eVar.a((CoordinatorLayout.b) swipeDismissBehavior);
                eVar.f1505g = 80;
            }
            this.f13431f.addView(this.f13429b);
        }
        this.f13429b.setOnAttachStateChangeListener(new c() {
            public void a(View view) {
            }

            public void b(View view) {
                if (BaseTransientBottomBar.this.g()) {
                    BaseTransientBottomBar.f13426a.post(new Runnable() {
                        public void run() {
                            BaseTransientBottomBar.this.d(3);
                        }
                    });
                }
            }
        });
        if (!w.A(this.f13429b)) {
            this.f13429b.setOnLayoutChangeListener(new d() {
                public void a(View view, int i, int i2, int i3, int i4) {
                    BaseTransientBottomBar.this.f13429b.setOnLayoutChangeListener((d) null);
                    if (BaseTransientBottomBar.this.l()) {
                        BaseTransientBottomBar.this.j();
                    } else {
                        BaseTransientBottomBar.this.k();
                    }
                }
            });
        } else if (l()) {
            j();
        } else {
            k();
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        final int n = n();
        if (f13427d) {
            w.h(this.f13429b, n);
        } else {
            this.f13429b.setTranslationY((float) n);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{n, 0});
        valueAnimator.setInterpolator(com.google.android.material.a.a.f13099b);
        valueAnimator.setDuration(250);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.h.a(70, 180);
            }

            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.k();
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            /* renamed from: c  reason: collision with root package name */
            private int f13436c = n;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.f13427d) {
                    w.h(BaseTransientBottomBar.this.f13429b, intValue - this.f13436c);
                } else {
                    BaseTransientBottomBar.this.f13429b.setTranslationY((float) intValue);
                }
                this.f13436c = intValue;
            }
        });
        valueAnimator.start();
    }

    private void e(final int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{0, n()});
        valueAnimator.setInterpolator(com.google.android.material.a.a.f13099b);
        valueAnimator.setDuration(250);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.h.b(0, 180);
            }

            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.d(i2);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            /* renamed from: b  reason: collision with root package name */
            private int f13440b = 0;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.f13427d) {
                    w.h(BaseTransientBottomBar.this.f13429b, intValue - this.f13440b);
                } else {
                    BaseTransientBottomBar.this.f13429b.setTranslationY((float) intValue);
                }
                this.f13440b = intValue;
            }
        });
        valueAnimator.start();
    }

    private int n() {
        int height = this.f13429b.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f13429b.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* access modifiers changed from: package-private */
    public final void c(int i2) {
        if (!l() || this.f13429b.getVisibility() != 0) {
            d(i2);
        } else {
            e(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        b.a().b(this.f13430c);
        List<a<B>> list = this.j;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.j.get(size).a(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        b.a().a(this.f13430c);
        List<a<B>> list = this.j;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.j.get(size).a(this, i2);
            }
        }
        ViewParent parent = this.f13429b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f13429b);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.l.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList == null || !enabledAccessibilityServiceList.isEmpty()) {
            return false;
        }
        return true;
    }

    protected static class e extends FrameLayout {

        /* renamed from: a  reason: collision with root package name */
        private final AccessibilityManager f13450a;

        /* renamed from: b  reason: collision with root package name */
        private final c.a f13451b;

        /* renamed from: c  reason: collision with root package name */
        private d f13452c;

        /* renamed from: d  reason: collision with root package name */
        private c f13453d;

        protected e(Context context) {
            this(context, (AttributeSet) null);
        }

        protected e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(a.k.SnackbarLayout_elevation)) {
                w.b((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(a.k.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            this.f13450a = (AccessibilityManager) context.getSystemService("accessibility");
            this.f13451b = new c.a() {
                public void a(boolean z) {
                    e.this.setClickableOrFocusableBasedOnAccessibility(z);
                }
            };
            androidx.core.g.a.c.a(this.f13450a, this.f13451b);
            setClickableOrFocusableBasedOnAccessibility(this.f13450a.isTouchExplorationEnabled());
        }

        /* access modifiers changed from: private */
        public void setClickableOrFocusableBasedOnAccessibility(boolean z) {
            setClickable(!z);
            setFocusable(z);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            d dVar = this.f13452c;
            if (dVar != null) {
                dVar.a(this, i, i2, i3, i4);
            }
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            c cVar = this.f13453d;
            if (cVar != null) {
                cVar.a(this);
            }
            w.s(this);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            c cVar = this.f13453d;
            if (cVar != null) {
                cVar.b(this);
            }
            androidx.core.g.a.c.b(this.f13450a, this.f13451b);
        }

        /* access modifiers changed from: package-private */
        public void setOnLayoutChangeListener(d dVar) {
            this.f13452c = dVar;
        }

        /* access modifiers changed from: package-private */
        public void setOnAttachStateChangeListener(c cVar) {
            this.f13453d = cVar;
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: g  reason: collision with root package name */
        private final b f13448g = new b(this);

        /* access modifiers changed from: private */
        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f13448g.a(baseTransientBottomBar);
        }

        public boolean a(View view) {
            return this.f13448g.a(view);
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f13448g.a(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private b.a f13449a;

        public b(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.a(0.1f);
            swipeDismissBehavior.b(0.6f);
            swipeDismissBehavior.a(0);
        }

        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f13449a = baseTransientBottomBar.f13430c;
        }

        public boolean a(View view) {
            return view instanceof e;
        }

        public void a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    b.a().d(this.f13449a);
                }
            } else if (coordinatorLayout.a(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                b.a().c(this.f13449a);
            }
        }
    }
}
