package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.ae;
import androidx.core.g.j;
import androidx.core.g.r;
import androidx.core.g.w;
import androidx.core.util.c;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.a;
import com.google.android.material.internal.l;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;
import java.lang.ref.WeakReference;
import java.util.List;

@CoordinatorLayout.c(a = Behavior.class)
public class AppBarLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f13120a;

    /* renamed from: b  reason: collision with root package name */
    private int f13121b;

    /* renamed from: c  reason: collision with root package name */
    private int f13122c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13123d;

    /* renamed from: e  reason: collision with root package name */
    private int f13124e;

    /* renamed from: f  reason: collision with root package name */
    private ae f13125f;

    /* renamed from: g  reason: collision with root package name */
    private List<a> f13126g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int[] l;

    public interface a<T extends AppBarLayout> {
        void a(T t, int i);
    }

    @Deprecated
    public float getTargetElevation() {
        return BitmapDescriptorFactory.HUE_RED;
    }

    public AppBarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13120a = -1;
        this.f13121b = -1;
        this.f13122c = -1;
        this.f13124e = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            e.a(this);
            e.a(this, attributeSet, 0, a.j.Widget_Design_AppBarLayout);
        }
        TypedArray a2 = l.a(context, attributeSet, a.k.AppBarLayout, 0, a.j.Widget_Design_AppBarLayout, new int[0]);
        w.a((View) this, a2.getDrawable(a.k.AppBarLayout_android_background));
        if (a2.hasValue(a.k.AppBarLayout_expanded)) {
            a(a2.getBoolean(a.k.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && a2.hasValue(a.k.AppBarLayout_elevation)) {
            e.a(this, (float) a2.getDimensionPixelSize(a.k.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (a2.hasValue(a.k.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(a2.getBoolean(a.k.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (a2.hasValue(a.k.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(a2.getBoolean(a.k.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.k = a2.getBoolean(a.k.AppBarLayout_liftOnScroll, false);
        a2.recycle();
        w.a((View) this, (r) new r() {
            public ae a(View view, ae aeVar) {
                return AppBarLayout.this.a(aeVar);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        g();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        g();
        boolean z2 = false;
        this.f13123d = false;
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            } else if (((b) getChildAt(i6).getLayoutParams()).b() != null) {
                this.f13123d = true;
                break;
            } else {
                i6++;
            }
        }
        if (!this.h) {
            if (this.k || f()) {
                z2 = true;
            }
            b(z2);
        }
    }

    private boolean f() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((b) getChildAt(i2).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void g() {
        this.f13120a = -1;
        this.f13121b = -1;
        this.f13122c = -1;
    }

    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setExpanded(boolean z) {
        a(z, w.A(this));
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, true);
    }

    private void a(boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        int i3 = (z ? 1 : 2) | (z2 ? 4 : 0);
        if (z3) {
            i2 = 8;
        }
        this.f13124e = i3 | i2;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public b generateDefaultLayoutParams() {
        return new b(-1, -2);
    }

    /* renamed from: a */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new b((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f13123d;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f13120a;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = bVar.f13140a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight + bVar.topMargin + bVar.bottomMargin;
            if ((i5 & 2) != 0) {
                i4 -= w.m(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4 - getTopInset());
        this.f13120a = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return getTotalScrollRange() != 0;
    }

    /* access modifiers changed from: package-private */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedPreScrollRange() {
        int i2;
        int i3 = this.f13121b;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = bVar.f13140a;
            if ((i5 & 5) == 5) {
                int i6 = i4 + bVar.topMargin + bVar.bottomMargin;
                if ((i5 & 8) != 0) {
                    i4 = i6 + w.m(childAt);
                } else {
                    if ((i5 & 2) != 0) {
                        i2 = w.m(childAt);
                    } else {
                        i2 = getTopInset();
                    }
                    i4 = i6 + (measuredHeight - i2);
                }
            } else if (i4 > 0) {
                break;
            }
        }
        int max = Math.max(0, i4);
        this.f13121b = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedScrollRange() {
        int i2 = this.f13122c;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + bVar.topMargin + bVar.bottomMargin;
            int i5 = bVar.f13140a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i4 -= w.m(childAt) + getTopInset();
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f13122c = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        List<a> list = this.f13126g;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.f13126g.get(i3);
                if (aVar != null) {
                    aVar.a(this, i2);
                }
            }
        }
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int m = w.m(this);
        if (m == 0) {
            int childCount = getChildCount();
            m = childCount >= 1 ? w.m(getChildAt(childCount - 1)) : 0;
            if (m == 0) {
                return getHeight() / 3;
            }
        }
        return (m * 2) + topInset;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        if (this.l == null) {
            this.l = new int[4];
        }
        int[] iArr = this.l;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        iArr[0] = this.i ? a.b.state_liftable : -a.b.state_liftable;
        iArr[1] = (!this.i || !this.j) ? -a.b.state_lifted : a.b.state_lifted;
        iArr[2] = this.i ? a.b.state_collapsible : -a.b.state_collapsible;
        iArr[3] = (!this.i || !this.j) ? -a.b.state_collapsed : a.b.state_collapsed;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    private boolean b(boolean z) {
        if (this.i == z) {
            return false;
        }
        this.i = z;
        refreshDrawableState();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(boolean z) {
        if (this.j == z) {
            return false;
        }
        this.j = z;
        refreshDrawableState();
        return true;
    }

    public void setLiftOnScroll(boolean z) {
        this.k = z;
    }

    public boolean d() {
        return this.k;
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            e.a(this, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.f13124e;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f13124e = 0;
    }

    /* access modifiers changed from: package-private */
    public final int getTopInset() {
        ae aeVar = this.f13125f;
        if (aeVar != null) {
            return aeVar.b();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public ae a(ae aeVar) {
        ae aeVar2 = w.t(this) ? aeVar : null;
        if (!c.a(this.f13125f, aeVar2)) {
            this.f13125f = aeVar2;
            g();
        }
        return aeVar;
    }

    public static class b extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f13140a = 1;

        /* renamed from: b  reason: collision with root package name */
        Interpolator f13141b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.AppBarLayout_Layout);
            this.f13140a = obtainStyledAttributes.getInt(a.k.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(a.k.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f13141b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(a.k.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int a() {
            return this.f13140a;
        }

        public Interpolator b() {
            return this.f13141b;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            int i = this.f13140a;
            return (i & 1) == 1 && (i & 10) != 0;
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }

        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.onMeasureChild(coordinatorLayout, appBarLayout, i, i2, i3, i4);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
        }

        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public /* bridge */ /* synthetic */ Parcelable b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, appBarLayout);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    protected static class BaseBehavior<T extends AppBarLayout> extends a<T> {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f13128b;

        /* renamed from: c  reason: collision with root package name */
        private int f13129c;

        /* renamed from: d  reason: collision with root package name */
        private ValueAnimator f13130d;

        /* renamed from: e  reason: collision with root package name */
        private int f13131e = -1;

        /* renamed from: f  reason: collision with root package name */
        private boolean f13132f;

        /* renamed from: g  reason: collision with root package name */
        private float f13133g;
        private WeakReference<View> h;
        private a i;

        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean a(T t);
        }

        private static boolean a(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* renamed from: a */
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i2, int i3) {
            boolean z = (i2 & 2) != 0 && (t.d() || a(coordinatorLayout, t, view));
            if (z) {
                ValueAnimator valueAnimator = this.f13130d;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
            }
            this.h = null;
            this.f13129c = i3;
            return z;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.c() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        /* renamed from: a */
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int i6;
            if (i3 != 0) {
                if (i3 < 0) {
                    int i7 = -t.getTotalScrollRange();
                    i6 = i7;
                    i5 = t.getDownNestedPreScrollRange() + i7;
                } else {
                    i6 = -t.getUpNestedPreScrollRange();
                    i5 = 0;
                }
                if (i6 != i5) {
                    iArr[1] = b(coordinatorLayout, t, i3, i6, i5);
                    a(i3, t, view, i4);
                }
            }
        }

        /* renamed from: a */
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int i4, int i5, int i6) {
            if (i5 < 0) {
                b(coordinatorLayout, t, i5, -t.getDownNestedScrollRange(), 0);
                a(i5, t, view, i6);
            }
            if (t.d()) {
                t.a(view.getScrollY() > 0);
            }
        }

        private void a(int i2, T t, View view, int i3) {
            if (i3 == 1) {
                int a2 = a();
                if ((i2 < 0 && a2 == 0) || (i2 > 0 && a2 == (-t.getDownNestedScrollRange()))) {
                    w.g(view, 1);
                }
            }
        }

        /* renamed from: a */
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, T t, View view, int i2) {
            if (this.f13129c == 0 || i2 == 1) {
                c(coordinatorLayout, t);
            }
            this.h = new WeakReference<>(view);
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i2, float f2) {
            int i3;
            int abs = Math.abs(a() - i2);
            float abs2 = Math.abs(f2);
            if (abs2 > BitmapDescriptorFactory.HUE_RED) {
                i3 = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                i3 = (int) (((((float) abs) / ((float) t.getHeight())) + 1.0f) * 150.0f);
            }
            a(coordinatorLayout, t, i2, i3);
        }

        private void a(final CoordinatorLayout coordinatorLayout, final T t, int i2, int i3) {
            int a2 = a();
            if (a2 == i2) {
                ValueAnimator valueAnimator = this.f13130d;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f13130d.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.f13130d;
            if (valueAnimator2 == null) {
                this.f13130d = new ValueAnimator();
                this.f13130d.setInterpolator(com.google.android.material.a.a.f13102e);
                this.f13130d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BaseBehavior.this.a_(coordinatorLayout, t, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.f13130d.setDuration((long) Math.min(i3, IjkMediaCodecInfo.RANK_LAST_CHANCE));
            this.f13130d.setIntValues(new int[]{a2, i2});
            this.f13130d.start();
        }

        private int a(T t, int i2) {
            int childCount = t.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t.getChildAt(i3);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                b bVar = (b) childAt.getLayoutParams();
                if (a(bVar.a(), 32)) {
                    top -= bVar.topMargin;
                    bottom += bVar.bottomMargin;
                }
                int i4 = -i2;
                if (top <= i4 && bottom >= i4) {
                    return i3;
                }
            }
            return -1;
        }

        private void c(CoordinatorLayout coordinatorLayout, T t) {
            int a2 = a();
            int a3 = a(t, a2);
            if (a3 >= 0) {
                View childAt = t.getChildAt(a3);
                b bVar = (b) childAt.getLayoutParams();
                int a4 = bVar.a();
                if ((a4 & 17) == 17) {
                    int i2 = -childAt.getTop();
                    int i3 = -childAt.getBottom();
                    if (a3 == t.getChildCount() - 1) {
                        i3 += t.getTopInset();
                    }
                    if (a(a4, 2)) {
                        i3 += w.m(childAt);
                    } else if (a(a4, 5)) {
                        int m = w.m(childAt) + i3;
                        if (a2 < m) {
                            i2 = m;
                        } else {
                            i3 = m;
                        }
                    }
                    if (a(a4, 32)) {
                        i2 += bVar.topMargin;
                        i3 -= bVar.bottomMargin;
                    }
                    if (a2 < (i3 + i2) / 2) {
                        i2 = i3;
                    }
                    a(coordinatorLayout, t, androidx.core.b.a.a(i2, -t.getTotalScrollRange(), 0), (float) BitmapDescriptorFactory.HUE_RED);
                }
            }
        }

        /* renamed from: a */
        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4, int i5) {
            if (((CoordinatorLayout.e) t.getLayoutParams()).height != -2) {
                return super.onMeasureChild(coordinatorLayout, t, i2, i3, i4, i5);
            }
            coordinatorLayout.a((View) t, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
            return true;
        }

        /* renamed from: a */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, T t, int i2) {
            int i3;
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, t, i2);
            int pendingAction = t.getPendingAction();
            int i4 = this.f13131e;
            if (i4 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i4);
                int i5 = -childAt.getBottom();
                if (this.f13132f) {
                    i3 = w.m(childAt) + t.getTopInset();
                } else {
                    i3 = Math.round(((float) childAt.getHeight()) * this.f13133g);
                }
                a_(coordinatorLayout, t, i5 + i3);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i6 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, t, i6, (float) BitmapDescriptorFactory.HUE_RED);
                    } else {
                        a_(coordinatorLayout, t, i6);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, t, 0, (float) BitmapDescriptorFactory.HUE_RED);
                    } else {
                        a_(coordinatorLayout, t, 0);
                    }
                }
            }
            t.e();
            this.f13131e = -1;
            a(androidx.core.b.a.a(b(), -t.getTotalScrollRange(), 0));
            a(coordinatorLayout, t, b(), 0, true);
            t.a(b());
            return onLayoutChild;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean c(T t) {
            a aVar = this.i;
            if (aVar != null) {
                return aVar.a(t);
            }
            WeakReference<View> weakReference = this.h;
            if (weakReference == null) {
                return true;
            }
            View view = (View) weakReference.get();
            if (view == null || !view.isShown() || view.canScrollVertically(-1)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void a(CoordinatorLayout coordinatorLayout, T t) {
            c(coordinatorLayout, t);
        }

        /* access modifiers changed from: package-private */
        public int b(T t) {
            return -t.getDownNestedScrollRange();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public int a(T t) {
            return t.getTotalScrollRange();
        }

        /* access modifiers changed from: package-private */
        public int a(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4) {
            int a2 = a();
            int i5 = 0;
            if (i3 == 0 || a2 < i3 || a2 > i4) {
                this.f13128b = 0;
            } else {
                int a3 = androidx.core.b.a.a(i2, i3, i4);
                if (a2 != a3) {
                    int b2 = t.b() ? b(t, a3) : a3;
                    boolean a4 = a(b2);
                    i5 = a2 - a3;
                    this.f13128b = a3 - b2;
                    if (!a4 && t.b()) {
                        coordinatorLayout.b((View) t);
                    }
                    t.a(b());
                    a(coordinatorLayout, t, a3, a3 < a2 ? -1 : 1, false);
                }
            }
            return i5;
        }

        private int b(T t, int i2) {
            int abs = Math.abs(i2);
            int childCount = t.getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i4);
                b bVar = (b) childAt.getLayoutParams();
                Interpolator b2 = bVar.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i4++;
                } else if (b2 != null) {
                    int a2 = bVar.a();
                    if ((a2 & 1) != 0) {
                        i3 = 0 + childAt.getHeight() + bVar.topMargin + bVar.bottomMargin;
                        if ((a2 & 2) != 0) {
                            i3 -= w.m(childAt);
                        }
                    }
                    if (w.t(childAt)) {
                        i3 -= t.getTopInset();
                    }
                    if (i3 > 0) {
                        float f2 = (float) i3;
                        return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * b2.getInterpolation(((float) (abs - childAt.getTop())) / f2)));
                    }
                }
            }
            return i2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(androidx.coordinatorlayout.widget.CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            /*
                r5 = this;
                android.view.View r0 = c((com.google.android.material.appbar.AppBarLayout) r7, (int) r8)
                if (r0 == 0) goto L_0x006e
                android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$b r1 = (com.google.android.material.appbar.AppBarLayout.b) r1
                int r1 = r1.a()
                r2 = r1 & 1
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L_0x0041
                int r2 = androidx.core.g.w.m(r0)
                if (r9 <= 0) goto L_0x002f
                r9 = r1 & 12
                if (r9 == 0) goto L_0x002f
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L_0x0041
            L_0x002d:
                r8 = 1
                goto L_0x0042
            L_0x002f:
                r9 = r1 & 2
                if (r9 == 0) goto L_0x0041
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L_0x0041
                goto L_0x002d
            L_0x0041:
                r8 = 0
            L_0x0042:
                boolean r9 = r7.d()
                if (r9 == 0) goto L_0x0057
                android.view.View r9 = r5.a((androidx.coordinatorlayout.widget.CoordinatorLayout) r6)
                if (r9 == 0) goto L_0x0057
                int r8 = r9.getScrollY()
                if (r8 <= 0) goto L_0x0056
                r8 = 1
                goto L_0x0057
            L_0x0056:
                r8 = 0
            L_0x0057:
                boolean r8 = r7.a((boolean) r8)
                int r9 = android.os.Build.VERSION.SDK_INT
                r0 = 11
                if (r9 < r0) goto L_0x006e
                if (r10 != 0) goto L_0x006b
                if (r8 == 0) goto L_0x006e
                boolean r6 = r5.d(r6, r7)
                if (r6 == 0) goto L_0x006e
            L_0x006b:
                r7.jumpDrawablesToCurrentState()
            L_0x006e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        private boolean d(CoordinatorLayout coordinatorLayout, T t) {
            List<View> d2 = coordinatorLayout.d((View) t);
            int size = d2.size();
            int i2 = 0;
            while (i2 < size) {
                CoordinatorLayout.b b2 = ((CoordinatorLayout.e) d2.get(i2).getLayoutParams()).b();
                if (!(b2 instanceof ScrollingViewBehavior)) {
                    i2++;
                } else if (((ScrollingViewBehavior) b2).c() != 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private static View c(AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private View a(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt instanceof j) {
                    return childAt;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return b() + this.f13128b;
        }

        /* renamed from: b */
        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, t);
            int b2 = b();
            int childCount = t.getChildCount();
            boolean z = false;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = t.getChildAt(i2);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 > 0 || bottom < 0) {
                    i2++;
                } else {
                    SavedState savedState = new SavedState(onSaveInstanceState);
                    savedState.f13137a = i2;
                    if (bottom == w.m(childAt) + t.getTopInset()) {
                        z = true;
                    }
                    savedState.f13139d = z;
                    savedState.f13138b = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return onSaveInstanceState;
        }

        /* renamed from: a */
        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.onRestoreInstanceState(coordinatorLayout, t, savedState.a());
                this.f13131e = savedState.f13137a;
                this.f13133g = savedState.f13138b;
                this.f13132f = savedState.f13139d;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, t, parcelable);
            this.f13131e = -1;
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
            int f13137a;

            /* renamed from: b  reason: collision with root package name */
            float f13138b;

            /* renamed from: d  reason: collision with root package name */
            boolean f13139d;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f13137a = parcel.readInt();
                this.f13138b = parcel.readFloat();
                this.f13139d = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f13137a);
                parcel.writeFloat(this.f13138b);
                parcel.writeByte(this.f13139d ? (byte) 1 : 0);
            }
        }
    }

    public static class ScrollingViewBehavior extends b {
        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }

        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.onLayoutChild(coordinatorLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.onMeasureChild(coordinatorLayout, view, i, i2, i3, i4);
        }

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.ScrollingViewBehavior_Layout);
            b(obtainStyledAttributes.getDimensionPixelSize(a.k.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            a(view, view2);
            b(view, view2);
            return false;
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a2 = b(coordinatorLayout.c(view));
            if (a2 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f13152a;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a2.a(false, !z);
                    return true;
                }
            }
            return false;
        }

        private void a(View view, View view2) {
            CoordinatorLayout.b b2 = ((CoordinatorLayout.e) view2.getLayoutParams()).b();
            if (b2 instanceof BaseBehavior) {
                w.h(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) b2).f13128b) + a()) - c(view2));
            }
        }

        /* access modifiers changed from: package-private */
        public float a(View view) {
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int a2 = a(appBarLayout);
                if (downNestedPreScrollRange != 0 && totalScrollRange + a2 <= downNestedPreScrollRange) {
                    return BitmapDescriptorFactory.HUE_RED;
                }
                int i = totalScrollRange - downNestedPreScrollRange;
                if (i != 0) {
                    return (((float) a2) / ((float) i)) + 1.0f;
                }
            }
            return BitmapDescriptorFactory.HUE_RED;
        }

        private static int a(AppBarLayout appBarLayout) {
            CoordinatorLayout.b b2 = ((CoordinatorLayout.e) appBarLayout.getLayoutParams()).b();
            if (b2 instanceof BaseBehavior) {
                return ((BaseBehavior) b2).a();
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public AppBarLayout b(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int b(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.b(view);
        }

        private void b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.d()) {
                    appBarLayout.a(view.getScrollY() > 0);
                }
            }
        }
    }
}
