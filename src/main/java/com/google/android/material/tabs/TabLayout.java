package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.at;
import androidx.core.g.t;
import androidx.core.g.w;
import androidx.core.util.Pools;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.a;
import com.google.android.material.internal.l;
import com.google.android.material.internal.m;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.a
public class TabLayout extends HorizontalScrollView {
    private static final Pools.a<f> w = new Pools.b(16);
    private final e A;
    private final int B;
    private final int C;
    private final int D;
    private int E;
    private b F;
    private final ArrayList<b> G;
    private b H;
    private ValueAnimator I;
    private androidx.viewpager.widget.a J;
    private DataSetObserver K;
    private g L;
    private a M;
    private boolean N;
    private final Pools.a<h> O;

    /* renamed from: a  reason: collision with root package name */
    int f13472a;

    /* renamed from: b  reason: collision with root package name */
    int f13473b;

    /* renamed from: c  reason: collision with root package name */
    int f13474c;

    /* renamed from: d  reason: collision with root package name */
    int f13475d;

    /* renamed from: e  reason: collision with root package name */
    int f13476e;

    /* renamed from: f  reason: collision with root package name */
    ColorStateList f13477f;

    /* renamed from: g  reason: collision with root package name */
    ColorStateList f13478g;
    ColorStateList h;
    Drawable i;
    PorterDuff.Mode j;
    float k;
    float l;
    final int m;
    int n;
    int o;
    int p;
    int q;
    int r;
    boolean s;
    boolean t;
    boolean u;
    ViewPager v;
    private final ArrayList<f> x;
    private f y;
    /* access modifiers changed from: private */
    public final RectF z;

    public interface b<T extends f> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    public interface c extends b {
    }

    public TabLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.tabStyle);
    }

    /* JADX INFO: finally extract failed */
    public TabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x = new ArrayList<>();
        this.z = new RectF();
        this.n = Integer.MAX_VALUE;
        this.G = new ArrayList<>();
        this.O = new Pools.SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        this.A = new e(context);
        super.addView(this.A, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray a2 = l.a(context, attributeSet, a.k.TabLayout, i2, a.j.Widget_Design_TabLayout, a.k.TabLayout_tabTextAppearance);
        this.A.b(a2.getDimensionPixelSize(a.k.TabLayout_tabIndicatorHeight, -1));
        this.A.a(a2.getColor(a.k.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(com.google.android.material.f.a.b(context, a2, a.k.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(a2.getInt(a.k.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(a2.getBoolean(a.k.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = a2.getDimensionPixelSize(a.k.TabLayout_tabPadding, 0);
        this.f13475d = dimensionPixelSize;
        this.f13474c = dimensionPixelSize;
        this.f13473b = dimensionPixelSize;
        this.f13472a = dimensionPixelSize;
        this.f13472a = a2.getDimensionPixelSize(a.k.TabLayout_tabPaddingStart, this.f13472a);
        this.f13473b = a2.getDimensionPixelSize(a.k.TabLayout_tabPaddingTop, this.f13473b);
        this.f13474c = a2.getDimensionPixelSize(a.k.TabLayout_tabPaddingEnd, this.f13474c);
        this.f13475d = a2.getDimensionPixelSize(a.k.TabLayout_tabPaddingBottom, this.f13475d);
        this.f13476e = a2.getResourceId(a.k.TabLayout_tabTextAppearance, a.j.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.f13476e, a.j.TextAppearance);
        try {
            this.k = (float) obtainStyledAttributes.getDimensionPixelSize(a.j.TextAppearance_android_textSize, 0);
            this.f13477f = com.google.android.material.f.a.a(context, obtainStyledAttributes, a.j.TextAppearance_android_textColor);
            obtainStyledAttributes.recycle();
            if (a2.hasValue(a.k.TabLayout_tabTextColor)) {
                this.f13477f = com.google.android.material.f.a.a(context, a2, a.k.TabLayout_tabTextColor);
            }
            if (a2.hasValue(a.k.TabLayout_tabSelectedTextColor)) {
                this.f13477f = a(this.f13477f.getDefaultColor(), a2.getColor(a.k.TabLayout_tabSelectedTextColor, 0));
            }
            this.f13478g = com.google.android.material.f.a.a(context, a2, a.k.TabLayout_tabIconTint);
            this.j = m.a(a2.getInt(a.k.TabLayout_tabIconTintMode, -1), (PorterDuff.Mode) null);
            this.h = com.google.android.material.f.a.a(context, a2, a.k.TabLayout_tabRippleColor);
            this.p = a2.getInt(a.k.TabLayout_tabIndicatorAnimationDuration, 300);
            this.B = a2.getDimensionPixelSize(a.k.TabLayout_tabMinWidth, -1);
            this.C = a2.getDimensionPixelSize(a.k.TabLayout_tabMaxWidth, -1);
            this.m = a2.getResourceId(a.k.TabLayout_tabBackground, 0);
            this.E = a2.getDimensionPixelSize(a.k.TabLayout_tabContentStart, 0);
            this.r = a2.getInt(a.k.TabLayout_tabMode, 1);
            this.o = a2.getInt(a.k.TabLayout_tabGravity, 0);
            this.s = a2.getBoolean(a.k.TabLayout_tabInlineLabel, false);
            this.u = a2.getBoolean(a.k.TabLayout_tabUnboundedRipple, false);
            a2.recycle();
            Resources resources = getResources();
            this.l = (float) resources.getDimensionPixelSize(a.d.design_tab_text_size_2line);
            this.D = resources.getDimensionPixelSize(a.d.design_tab_scrollable_min_width);
            h();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.A.a(i2);
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.A.b(i2);
    }

    public void a(int i2, float f2, boolean z2) {
        a(i2, f2, z2, true);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float f2, boolean z2, boolean z3) {
        int round = Math.round(((float) i2) + f2);
        if (round >= 0 && round < this.A.getChildCount()) {
            if (z3) {
                this.A.a(i2, f2);
            }
            ValueAnimator valueAnimator = this.I;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.I.cancel();
            }
            scrollTo(a(i2, f2), 0);
            if (z2) {
                setSelectedTabView(round);
            }
        }
    }

    public void a(f fVar) {
        a(fVar, this.x.isEmpty());
    }

    public void a(f fVar, boolean z2) {
        a(fVar, this.x.size(), z2);
    }

    public void a(f fVar, int i2, boolean z2) {
        if (fVar.f13497a == this) {
            a(fVar, i2);
            e(fVar);
            if (z2) {
                fVar.f();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    private void a(a aVar) {
        f a2 = a();
        if (aVar.f13515a != null) {
            a2.a(aVar.f13515a);
        }
        if (aVar.f13516b != null) {
            a2.a(aVar.f13516b);
        }
        if (aVar.f13517c != 0) {
            a2.a(aVar.f13517c);
        }
        if (!TextUtils.isEmpty(aVar.getContentDescription())) {
            a2.b(aVar.getContentDescription());
        }
        a(a2);
    }

    @Deprecated
    public void setOnTabSelectedListener(b bVar) {
        b bVar2 = this.F;
        if (bVar2 != null) {
            b(bVar2);
        }
        this.F = bVar;
        if (bVar != null) {
            a(bVar);
        }
    }

    public void a(b bVar) {
        if (!this.G.contains(bVar)) {
            this.G.add(bVar);
        }
    }

    public void b(b bVar) {
        this.G.remove(bVar);
    }

    public f a() {
        f b2 = b();
        b2.f13497a = this;
        b2.f13498b = d(b2);
        return b2;
    }

    /* access modifiers changed from: protected */
    public f b() {
        f acquire = w.acquire();
        return acquire == null ? new f() : acquire;
    }

    /* access modifiers changed from: protected */
    public boolean b(f fVar) {
        return w.release(fVar);
    }

    public int getTabCount() {
        return this.x.size();
    }

    public f a(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.x.get(i2);
    }

    public int getSelectedTabPosition() {
        f fVar = this.y;
        if (fVar != null) {
            return fVar.d();
        }
        return -1;
    }

    public void c() {
        for (int childCount = this.A.getChildCount() - 1; childCount >= 0; childCount--) {
            c(childCount);
        }
        Iterator<f> it = this.x.iterator();
        while (it.hasNext()) {
            f next = it.next();
            it.remove();
            next.i();
            b(next);
        }
        this.y = null;
    }

    public void setTabMode(int i2) {
        if (i2 != this.r) {
            this.r = i2;
            h();
        }
    }

    public int getTabMode() {
        return this.r;
    }

    public void setTabGravity(int i2) {
        if (this.o != i2) {
            this.o = i2;
            h();
        }
    }

    public int getTabGravity() {
        return this.o;
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.q != i2) {
            this.q = i2;
            w.e(this.A);
        }
    }

    public int getTabIndicatorGravity() {
        return this.q;
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.t = z2;
        w.e(this.A);
    }

    public void setInlineLabel(boolean z2) {
        if (this.s != z2) {
            this.s = z2;
            for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
                View childAt = this.A.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).c();
                }
            }
            h();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    public void setUnboundedRipple(boolean z2) {
        if (this.u != z2) {
            this.u = z2;
            for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
                View childAt = this.A.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).a(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f13477f != colorStateList) {
            this.f13477f = colorStateList;
            e();
        }
    }

    public ColorStateList getTabTextColors() {
        return this.f13477f;
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f13478g != colorStateList) {
            this.f13478g = colorStateList;
            e();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public ColorStateList getTabIconTint() {
        return this.f13478g;
    }

    public ColorStateList getTabRippleColor() {
        return this.h;
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.h != colorStateList) {
            this.h = colorStateList;
            for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
                View childAt = this.A.getChildAt(i2);
                if (childAt instanceof h) {
                    ((h) childAt).a(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public Drawable getTabSelectedIndicator() {
        return this.i;
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.i != drawable) {
            this.i = drawable;
            w.e(this.A);
        }
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(androidx.appcompat.a.a.a.b(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public void setupWithViewPager(ViewPager viewPager) {
        a(viewPager, true);
    }

    public void a(ViewPager viewPager, boolean z2) {
        a(viewPager, z2, false);
    }

    private void a(ViewPager viewPager, boolean z2, boolean z3) {
        ViewPager viewPager2 = this.v;
        if (viewPager2 != null) {
            g gVar = this.L;
            if (gVar != null) {
                viewPager2.removeOnPageChangeListener(gVar);
            }
            a aVar = this.M;
            if (aVar != null) {
                this.v.removeOnAdapterChangeListener(aVar);
            }
        }
        b bVar = this.H;
        if (bVar != null) {
            b(bVar);
            this.H = null;
        }
        if (viewPager != null) {
            this.v = viewPager;
            if (this.L == null) {
                this.L = new g(this);
            }
            this.L.a();
            viewPager.addOnPageChangeListener(this.L);
            this.H = new i(viewPager);
            a(this.H);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z2);
            }
            if (this.M == null) {
                this.M = new a();
            }
            this.M.a(z2);
            viewPager.addOnAdapterChangeListener(this.M);
            a(viewPager.getCurrentItem(), (float) BitmapDescriptorFactory.HUE_RED, true);
        } else {
            this.v = null;
            a((androidx.viewpager.widget.a) null, false);
        }
        this.N = z3;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        a(aVar, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.v == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.N) {
            setupWithViewPager((ViewPager) null);
            this.N = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.A.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    /* access modifiers changed from: package-private */
    public void a(androidx.viewpager.widget.a aVar, boolean z2) {
        androidx.viewpager.widget.a aVar2 = this.J;
        if (aVar2 != null) {
            DataSetObserver dataSetObserver = this.K;
            if (dataSetObserver != null) {
                aVar2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.J = aVar;
        if (z2 && aVar != null) {
            if (this.K == null) {
                this.K = new d();
            }
            aVar.registerDataSetObserver(this.K);
        }
        d();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        c();
        androidx.viewpager.widget.a aVar = this.J;
        if (aVar != null) {
            int count = aVar.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                a(a().a(this.J.getPageTitle(i2)), false);
            }
            ViewPager viewPager = this.v;
            if (viewPager != null && count > 0) {
                int currentItem = viewPager.getCurrentItem();
                if (currentItem != getSelectedTabPosition() && currentItem < getTabCount()) {
                    c(a(currentItem));
                }
            }
        }
    }

    private void e() {
        int size = this.x.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.x.get(i2).h();
        }
    }

    private h d(f fVar) {
        Pools.a<h> aVar = this.O;
        h acquire = aVar != null ? aVar.acquire() : null;
        if (acquire == null) {
            acquire = new h(getContext());
        }
        acquire.a(fVar);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(fVar.f13502f)) {
            acquire.setContentDescription(fVar.f13501e);
        } else {
            acquire.setContentDescription(fVar.f13502f);
        }
        return acquire;
    }

    private void a(f fVar, int i2) {
        fVar.b(i2);
        this.x.add(i2, fVar);
        int size = this.x.size();
        while (true) {
            i2++;
            if (i2 < size) {
                this.x.get(i2).b(i2);
            } else {
                return;
            }
        }
    }

    private void e(f fVar) {
        this.A.addView(fVar.f13498b, fVar.d(), f());
    }

    public void addView(View view) {
        a(view);
    }

    public void addView(View view, int i2) {
        a(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    private void a(View view) {
        if (view instanceof a) {
            a((a) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private LinearLayout.LayoutParams f() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.r == 1 && this.o == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = BitmapDescriptorFactory.HUE_RED;
    }

    /* access modifiers changed from: package-private */
    public int b(int i2) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i2));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
            View childAt = this.A.getChildAt(i2);
            if (childAt instanceof h) {
                ((h) childAt).a(canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int b2 = b(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(b2, View.MeasureSpec.getSize(i3)), 1073741824);
        } else if (mode == 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(b2, 1073741824);
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            int i4 = this.C;
            if (i4 <= 0) {
                i4 = size - b(56);
            }
            this.n = i4;
        }
        super.onMeasure(i2, i3);
        if (getChildCount() == 1) {
            boolean z2 = false;
            View childAt = getChildAt(0);
            int i5 = this.r;
            if (i5 == 0 ? childAt.getMeasuredWidth() < getMeasuredWidth() : !(i5 != 1 || childAt.getMeasuredWidth() == getMeasuredWidth())) {
                z2 = true;
            }
            if (z2) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    private void c(int i2) {
        h hVar = (h) this.A.getChildAt(i2);
        this.A.removeViewAt(i2);
        if (hVar != null) {
            hVar.a();
            this.O.release(hVar);
        }
        requestLayout();
    }

    private void d(int i2) {
        if (i2 != -1) {
            if (getWindowToken() == null || !w.A(this) || this.A.a()) {
                a(i2, (float) BitmapDescriptorFactory.HUE_RED, true);
                return;
            }
            int scrollX = getScrollX();
            int a2 = a(i2, (float) BitmapDescriptorFactory.HUE_RED);
            if (scrollX != a2) {
                g();
                this.I.setIntValues(new int[]{scrollX, a2});
                this.I.start();
            }
            this.A.b(i2, this.p);
        }
    }

    private void g() {
        if (this.I == null) {
            this.I = new ValueAnimator();
            this.I.setInterpolator(com.google.android.material.a.a.f13099b);
            this.I.setDuration((long) this.p);
            this.I.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        g();
        this.I.addListener(animatorListener);
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.A.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.A.getChildAt(i3);
                boolean z2 = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z2 = false;
                }
                childAt.setActivated(z2);
                i3++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(f fVar) {
        b(fVar, true);
    }

    /* access modifiers changed from: package-private */
    public void b(f fVar, boolean z2) {
        f fVar2 = this.y;
        if (fVar2 != fVar) {
            int d2 = fVar != null ? fVar.d() : -1;
            if (z2) {
                if ((fVar2 == null || fVar2.d() == -1) && d2 != -1) {
                    a(d2, (float) BitmapDescriptorFactory.HUE_RED, true);
                } else {
                    d(d2);
                }
                if (d2 != -1) {
                    setSelectedTabView(d2);
                }
            }
            this.y = fVar;
            if (fVar2 != null) {
                g(fVar2);
            }
            if (fVar != null) {
                f(fVar);
            }
        } else if (fVar2 != null) {
            h(fVar);
            d(fVar.d());
        }
    }

    private void f(f fVar) {
        for (int size = this.G.size() - 1; size >= 0; size--) {
            this.G.get(size).a(fVar);
        }
    }

    private void g(f fVar) {
        for (int size = this.G.size() - 1; size >= 0; size--) {
            this.G.get(size).b(fVar);
        }
    }

    private void h(f fVar) {
        for (int size = this.G.size() - 1; size >= 0; size--) {
            this.G.get(size).c(fVar);
        }
    }

    private int a(int i2, float f2) {
        int i3 = 0;
        if (this.r != 0) {
            return 0;
        }
        View childAt = this.A.getChildAt(i2);
        int i4 = i2 + 1;
        View childAt2 = i4 < this.A.getChildCount() ? this.A.getChildAt(i4) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i3 = childAt2.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i5 = (int) (((float) (width + i3)) * 0.5f * f2);
        return w.g(this) == 0 ? left + i5 : left - i5;
    }

    private void h() {
        w.b(this.A, this.r == 0 ? Math.max(0, this.E - this.f13472a) : 0, 0, 0, 0);
        int i2 = this.r;
        if (i2 == 0) {
            this.A.setGravity(8388611);
        } else if (i2 == 1) {
            this.A.setGravity(1);
        }
        a(true);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
            View childAt = this.A.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            a((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public TabLayout f13497a;

        /* renamed from: b  reason: collision with root package name */
        public h f13498b;

        /* renamed from: c  reason: collision with root package name */
        private Object f13499c;

        /* renamed from: d  reason: collision with root package name */
        private Drawable f13500d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f13501e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f13502f;

        /* renamed from: g  reason: collision with root package name */
        private int f13503g = -1;
        private View h;

        public Object a() {
            return this.f13499c;
        }

        public f a(Object obj) {
            this.f13499c = obj;
            return this;
        }

        public View b() {
            return this.h;
        }

        public f a(View view) {
            this.h = view;
            h();
            return this;
        }

        public f a(int i) {
            return a(LayoutInflater.from(this.f13498b.getContext()).inflate(i, this.f13498b, false));
        }

        public Drawable c() {
            return this.f13500d;
        }

        public int d() {
            return this.f13503g;
        }

        /* access modifiers changed from: package-private */
        public void b(int i) {
            this.f13503g = i;
        }

        public CharSequence e() {
            return this.f13501e;
        }

        public f a(Drawable drawable) {
            this.f13500d = drawable;
            h();
            return this;
        }

        public f a(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f13502f) && !TextUtils.isEmpty(charSequence)) {
                this.f13498b.setContentDescription(charSequence);
            }
            this.f13501e = charSequence;
            h();
            return this;
        }

        public void f() {
            TabLayout tabLayout = this.f13497a;
            if (tabLayout != null) {
                tabLayout.c(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public boolean g() {
            TabLayout tabLayout = this.f13497a;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.f13503g;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public f b(CharSequence charSequence) {
            this.f13502f = charSequence;
            h();
            return this;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            h hVar = this.f13498b;
            if (hVar != null) {
                hVar.b();
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            this.f13497a = null;
            this.f13498b = null;
            this.f13499c = null;
            this.f13500d = null;
            this.f13501e = null;
            this.f13502f = null;
            this.f13503g = -1;
            this.h = null;
        }
    }

    class h extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private f f13508b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f13509c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f13510d;

        /* renamed from: e  reason: collision with root package name */
        private View f13511e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f13512f;

        /* renamed from: g  reason: collision with root package name */
        private ImageView f13513g;
        private Drawable h;
        private int i = 2;

        public h(Context context) {
            super(context);
            a(context);
            w.b(this, TabLayout.this.f13472a, TabLayout.this.f13473b, TabLayout.this.f13474c, TabLayout.this.f13475d);
            setGravity(17);
            setOrientation(TabLayout.this.s ^ true ? 1 : 0);
            setClickable(true);
            w.a((View) this, t.a(getContext(), 1002));
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: android.graphics.drawable.GradientDrawable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: android.graphics.drawable.GradientDrawable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: android.graphics.drawable.GradientDrawable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: android.graphics.drawable.GradientDrawable} */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.content.Context r7) {
            /*
                r6 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = r0.m
                r1 = 0
                if (r0 == 0) goto L_0x0025
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = r0.m
                android.graphics.drawable.Drawable r7 = androidx.appcompat.a.a.a.b(r7, r0)
                r6.h = r7
                android.graphics.drawable.Drawable r7 = r6.h
                if (r7 == 0) goto L_0x0027
                boolean r7 = r7.isStateful()
                if (r7 == 0) goto L_0x0027
                android.graphics.drawable.Drawable r7 = r6.h
                int[] r0 = r6.getDrawableState()
                r7.setState(r0)
                goto L_0x0027
            L_0x0025:
                r6.h = r1
            L_0x0027:
                android.graphics.drawable.GradientDrawable r7 = new android.graphics.drawable.GradientDrawable
                r7.<init>()
                r0 = r7
                android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
                r2 = 0
                r0.setColor(r2)
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r0 = r0.h
                if (r0 == 0) goto L_0x0080
                android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
                r0.<init>()
                r3 = 925353388(0x3727c5ac, float:1.0E-5)
                r0.setCornerRadius(r3)
                r3 = -1
                r0.setColor(r3)
                com.google.android.material.tabs.TabLayout r3 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r3 = r3.h
                android.content.res.ColorStateList r3 = com.google.android.material.g.a.a((android.content.res.ColorStateList) r3)
                int r4 = android.os.Build.VERSION.SDK_INT
                r5 = 21
                if (r4 < r5) goto L_0x006b
                android.graphics.drawable.RippleDrawable r2 = new android.graphics.drawable.RippleDrawable
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.u
                if (r4 == 0) goto L_0x005f
                r7 = r1
            L_0x005f:
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.u
                if (r4 == 0) goto L_0x0066
                r0 = r1
            L_0x0066:
                r2.<init>(r3, r7, r0)
                r7 = r2
                goto L_0x0080
            L_0x006b:
                android.graphics.drawable.Drawable r0 = androidx.core.graphics.drawable.a.g(r0)
                androidx.core.graphics.drawable.a.a((android.graphics.drawable.Drawable) r0, (android.content.res.ColorStateList) r3)
                android.graphics.drawable.LayerDrawable r1 = new android.graphics.drawable.LayerDrawable
                r3 = 2
                android.graphics.drawable.Drawable[] r3 = new android.graphics.drawable.Drawable[r3]
                r3[r2] = r7
                r7 = 1
                r3[r7] = r0
                r1.<init>(r3)
                r7 = r1
            L_0x0080:
                androidx.core.g.w.a((android.view.View) r6, (android.graphics.drawable.Drawable) r7)
                com.google.android.material.tabs.TabLayout r7 = com.google.android.material.tabs.TabLayout.this
                r7.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.h.a(android.content.Context):void");
        }

        /* access modifiers changed from: private */
        public void a(Canvas canvas) {
            Drawable drawable = this.h;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.h.draw(canvas);
            }
        }

        /* access modifiers changed from: protected */
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.h;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.h.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f13508b == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f13508b.f();
            return true;
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f13509c;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f13510d;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f13511e;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(a.c.class.getName());
        }

        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(a.c.class.getName());
        }

        public void onMeasure(int i2, int i3) {
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.n, RNCartPanelDataEntity.NULL_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.f13509c != null) {
                float f2 = TabLayout.this.k;
                int i4 = this.i;
                ImageView imageView = this.f13510d;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f13509c;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.l;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.f13509c.getTextSize();
                int lineCount = this.f13509c.getLineCount();
                int a2 = androidx.core.widget.i.a(this.f13509c);
                if (f2 != textSize || (a2 >= 0 && i4 != a2)) {
                    if (TabLayout.this.r == 1 && f2 > textSize && lineCount == 1) {
                        Layout layout = this.f13509c.getLayout();
                        if (layout == null || a(layout, 0, f2) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f13509c.setTextSize(0, f2);
                        this.f13509c.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(f fVar) {
            if (fVar != this.f13508b) {
                this.f13508b = fVar;
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            a((f) null);
            setSelected(false);
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            f fVar = this.f13508b;
            Drawable drawable = null;
            View b2 = fVar != null ? fVar.b() : null;
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.f13511e = b2;
                TextView textView = this.f13509c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f13510d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f13510d.setImageDrawable((Drawable) null);
                }
                this.f13512f = (TextView) b2.findViewById(16908308);
                TextView textView2 = this.f13512f;
                if (textView2 != null) {
                    this.i = androidx.core.widget.i.a(textView2);
                }
                this.f13513g = (ImageView) b2.findViewById(16908294);
            } else {
                View view = this.f13511e;
                if (view != null) {
                    removeView(view);
                    this.f13511e = null;
                }
                this.f13512f = null;
                this.f13513g = null;
            }
            boolean z = false;
            if (this.f13511e == null) {
                if (this.f13510d == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(a.h.design_layout_tab_icon, this, false);
                    addView(imageView2, 0);
                    this.f13510d = imageView2;
                }
                if (!(fVar == null || fVar.c() == null)) {
                    drawable = androidx.core.graphics.drawable.a.g(fVar.c()).mutate();
                }
                if (drawable != null) {
                    androidx.core.graphics.drawable.a.a(drawable, TabLayout.this.f13478g);
                    if (TabLayout.this.j != null) {
                        androidx.core.graphics.drawable.a.a(drawable, TabLayout.this.j);
                    }
                }
                if (this.f13509c == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(a.h.design_layout_tab_text, this, false);
                    addView(textView3);
                    this.f13509c = textView3;
                    this.i = androidx.core.widget.i.a(this.f13509c);
                }
                androidx.core.widget.i.a(this.f13509c, TabLayout.this.f13476e);
                if (TabLayout.this.f13477f != null) {
                    this.f13509c.setTextColor(TabLayout.this.f13477f);
                }
                a(this.f13509c, this.f13510d);
            } else if (!(this.f13512f == null && this.f13513g == null)) {
                a(this.f13512f, this.f13513g);
            }
            if (fVar != null && !TextUtils.isEmpty(fVar.f13502f)) {
                setContentDescription(fVar.f13502f);
            }
            if (fVar != null && fVar.g()) {
                z = true;
            }
            setSelected(z);
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            setOrientation(TabLayout.this.s ^ true ? 1 : 0);
            if (this.f13512f == null && this.f13513g == null) {
                a(this.f13509c, this.f13510d);
            } else {
                a(this.f13512f, this.f13513g);
            }
        }

        private void a(TextView textView, ImageView imageView) {
            f fVar = this.f13508b;
            Drawable mutate = (fVar == null || fVar.c() == null) ? null : androidx.core.graphics.drawable.a.g(this.f13508b.c()).mutate();
            f fVar2 = this.f13508b;
            CharSequence e2 = fVar2 != null ? fVar2.e() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable((Drawable) null);
                }
            }
            boolean z = !TextUtils.isEmpty(e2);
            if (textView != null) {
                if (z) {
                    textView.setText(e2);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int b2 = (!z || imageView.getVisibility() != 0) ? 0 : TabLayout.this.b(8);
                if (TabLayout.this.s) {
                    if (b2 != androidx.core.g.g.b(marginLayoutParams)) {
                        androidx.core.g.g.a(marginLayoutParams, b2);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (b2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = b2;
                    androidx.core.g.g.a(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            f fVar3 = this.f13508b;
            CharSequence a2 = fVar3 != null ? fVar3.f13502f : null;
            if (z) {
                a2 = null;
            }
            at.a(this, a2);
        }

        /* access modifiers changed from: private */
        public int d() {
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (View view : new View[]{this.f13509c, this.f13510d, this.f13511e}) {
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getLeft()) : view.getLeft();
                    i2 = z ? Math.max(i2, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i2 - i3;
        }

        private float a(Layout layout, int i2, float f2) {
            return layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize());
        }
    }

    private class e extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        int f13483a = -1;

        /* renamed from: b  reason: collision with root package name */
        float f13484b;

        /* renamed from: d  reason: collision with root package name */
        private int f13486d;

        /* renamed from: e  reason: collision with root package name */
        private final Paint f13487e;

        /* renamed from: f  reason: collision with root package name */
        private final GradientDrawable f13488f;

        /* renamed from: g  reason: collision with root package name */
        private int f13489g = -1;
        private int h = -1;
        private int i = -1;
        private ValueAnimator j;

        e(Context context) {
            super(context);
            setWillNotDraw(false);
            this.f13487e = new Paint();
            this.f13488f = new GradientDrawable();
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if (this.f13487e.getColor() != i2) {
                this.f13487e.setColor(i2);
                w.e(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            if (this.f13486d != i2) {
                this.f13486d = i2;
                w.e(this);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, float f2) {
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.j.cancel();
            }
            this.f13483a = i2;
            this.f13484b = f2;
            b();
        }

        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT < 23 && this.f13489g != i2) {
                requestLayout();
                this.f13489g = i2;
            }
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                boolean z = true;
                if (TabLayout.this.r == 1 && TabLayout.this.o == 1) {
                    int childCount = getChildCount();
                    int i4 = 0;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = getChildAt(i5);
                        if (childAt.getVisibility() == 0) {
                            i4 = Math.max(i4, childAt.getMeasuredWidth());
                        }
                    }
                    if (i4 > 0) {
                        if (i4 * childCount <= getMeasuredWidth() - (TabLayout.this.b(16) * 2)) {
                            boolean z2 = false;
                            for (int i6 = 0; i6 < childCount; i6++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                                if (layoutParams.width != i4 || layoutParams.weight != BitmapDescriptorFactory.HUE_RED) {
                                    layoutParams.width = i4;
                                    layoutParams.weight = BitmapDescriptorFactory.HUE_RED;
                                    z2 = true;
                                }
                            }
                            z = z2;
                        } else {
                            TabLayout tabLayout = TabLayout.this;
                            tabLayout.o = 0;
                            tabLayout.a(false);
                        }
                        if (z) {
                            super.onMeasure(i2, i3);
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                b();
                return;
            }
            this.j.cancel();
            b(this.f13483a, Math.round((1.0f - this.j.getAnimatedFraction()) * ((float) this.j.getDuration())));
        }

        private void b() {
            int i2;
            int i3;
            View childAt = getChildAt(this.f13483a);
            if (childAt == null || childAt.getWidth() <= 0) {
                i3 = -1;
                i2 = -1;
            } else {
                i3 = childAt.getLeft();
                i2 = childAt.getRight();
                if (!TabLayout.this.t && (childAt instanceof h)) {
                    a((h) childAt, TabLayout.this.z);
                    i3 = (int) TabLayout.this.z.left;
                    i2 = (int) TabLayout.this.z.right;
                }
                if (this.f13484b > BitmapDescriptorFactory.HUE_RED && this.f13483a < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f13483a + 1);
                    int left = childAt2.getLeft();
                    int right = childAt2.getRight();
                    if (!TabLayout.this.t && (childAt2 instanceof h)) {
                        a((h) childAt2, TabLayout.this.z);
                        left = (int) TabLayout.this.z.left;
                        right = (int) TabLayout.this.z.right;
                    }
                    float f2 = this.f13484b;
                    i3 = (int) ((((float) left) * f2) + ((1.0f - f2) * ((float) i3)));
                    i2 = (int) ((((float) right) * f2) + ((1.0f - f2) * ((float) i2)));
                }
            }
            a(i3, i2);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            if (i2 != this.h || i3 != this.i) {
                this.h = i2;
                this.i = i3;
                w.e(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(final int i2, int i3) {
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.j.cancel();
            }
            View childAt = getChildAt(i2);
            if (childAt == null) {
                b();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (!TabLayout.this.t && (childAt instanceof h)) {
                a((h) childAt, TabLayout.this.z);
                left = (int) TabLayout.this.z.left;
                right = (int) TabLayout.this.z.right;
            }
            final int i4 = left;
            final int i5 = right;
            final int i6 = this.h;
            final int i7 = this.i;
            if (i6 != i4 || i7 != i5) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.j = valueAnimator2;
                valueAnimator2.setInterpolator(com.google.android.material.a.a.f13099b);
                valueAnimator2.setDuration((long) i3);
                valueAnimator2.setFloatValues(new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        e.this.a(com.google.android.material.a.a.a(i6, i4, animatedFraction), com.google.android.material.a.a.a(i7, i5, animatedFraction));
                    }
                });
                valueAnimator2.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        e eVar = e.this;
                        eVar.f13483a = i2;
                        eVar.f13484b = BitmapDescriptorFactory.HUE_RED;
                    }
                });
                valueAnimator2.start();
            }
        }

        private void a(h hVar, RectF rectF) {
            int a2 = hVar.d();
            if (a2 < TabLayout.this.b(24)) {
                a2 = TabLayout.this.b(24);
            }
            int left = (hVar.getLeft() + hVar.getRight()) / 2;
            int i2 = a2 / 2;
            rectF.set((float) (left - i2), BitmapDescriptorFactory.HUE_RED, (float) (left + i2), BitmapDescriptorFactory.HUE_RED);
        }

        public void draw(Canvas canvas) {
            int i2 = 0;
            int intrinsicHeight = TabLayout.this.i != null ? TabLayout.this.i.getIntrinsicHeight() : 0;
            int i3 = this.f13486d;
            if (i3 >= 0) {
                intrinsicHeight = i3;
            }
            int i4 = TabLayout.this.q;
            if (i4 == 0) {
                i2 = getHeight() - intrinsicHeight;
                intrinsicHeight = getHeight();
            } else if (i4 == 1) {
                i2 = (getHeight() - intrinsicHeight) / 2;
                intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
            } else if (i4 != 2) {
                intrinsicHeight = i4 != 3 ? 0 : getHeight();
            }
            int i5 = this.h;
            if (i5 >= 0 && this.i > i5) {
                Drawable g2 = androidx.core.graphics.drawable.a.g(TabLayout.this.i != null ? TabLayout.this.i : this.f13488f);
                g2.setBounds(this.h, i2, this.i, intrinsicHeight);
                if (this.f13487e != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        g2.setColorFilter(this.f13487e.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        androidx.core.graphics.drawable.a.a(g2, this.f13487e.getColor());
                    }
                }
                g2.draw(canvas);
            }
            super.draw(canvas);
        }
    }

    private static ColorStateList a(int i2, int i3) {
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private int getDefaultHeight() {
        int size = this.x.size();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            f fVar = this.x.get(i2);
            if (fVar != null && fVar.c() != null && !TextUtils.isEmpty(fVar.e())) {
                z2 = true;
                break;
            }
            i2++;
        }
        return (!z2 || this.s) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.B;
        if (i2 != -1) {
            return i2;
        }
        if (this.r == 0) {
            return this.D;
        }
        return 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: package-private */
    public int getTabMaxWidth() {
        return this.n;
    }

    public static class g implements ViewPager.f {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TabLayout> f13504a;

        /* renamed from: b  reason: collision with root package name */
        private int f13505b;

        /* renamed from: c  reason: collision with root package name */
        private int f13506c;

        public g(TabLayout tabLayout) {
            this.f13504a = new WeakReference<>(tabLayout);
        }

        public void onPageScrollStateChanged(int i) {
            this.f13505b = this.f13506c;
            this.f13506c = i;
        }

        public void onPageScrolled(int i, float f2, int i2) {
            TabLayout tabLayout = (TabLayout) this.f13504a.get();
            if (tabLayout != null) {
                boolean z = false;
                boolean z2 = this.f13506c != 2 || this.f13505b == 1;
                if (!(this.f13506c == 2 && this.f13505b == 0)) {
                    z = true;
                }
                tabLayout.a(i, f2, z2, z);
            }
        }

        public void onPageSelected(int i) {
            TabLayout tabLayout = (TabLayout) this.f13504a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                int i2 = this.f13506c;
                tabLayout.b(tabLayout.a(i), i2 == 0 || (i2 == 2 && this.f13505b == 0));
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f13506c = 0;
            this.f13505b = 0;
        }
    }

    public static class i implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager f13514a;

        public void b(f fVar) {
        }

        public void c(f fVar) {
        }

        public i(ViewPager viewPager) {
            this.f13514a = viewPager;
        }

        public void a(f fVar) {
            this.f13514a.setCurrentItem(fVar.d());
        }
    }

    private class d extends DataSetObserver {
        d() {
        }

        public void onChanged() {
            TabLayout.this.d();
        }

        public void onInvalidated() {
            TabLayout.this.d();
        }
    }

    private class a implements ViewPager.e {

        /* renamed from: b  reason: collision with root package name */
        private boolean f13481b;

        a() {
        }

        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            if (TabLayout.this.v == viewPager) {
                TabLayout.this.a(aVar2, this.f13481b);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            this.f13481b = z;
        }
    }
}
