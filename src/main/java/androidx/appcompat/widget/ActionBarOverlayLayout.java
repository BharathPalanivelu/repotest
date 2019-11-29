package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.m;
import androidx.core.g.n;
import androidx.core.g.o;
import androidx.core.g.p;
import androidx.core.g.q;
import androidx.core.g.w;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

public class ActionBarOverlayLayout extends ViewGroup implements x, n, o, p {

    /* renamed from: e  reason: collision with root package name */
    static final int[] f912e = {a.C0012a.actionBarSize, 16842841};
    private final Runnable A;
    private final q B;

    /* renamed from: a  reason: collision with root package name */
    ActionBarContainer f913a;

    /* renamed from: b  reason: collision with root package name */
    boolean f914b;

    /* renamed from: c  reason: collision with root package name */
    ViewPropertyAnimator f915c;

    /* renamed from: d  reason: collision with root package name */
    final AnimatorListenerAdapter f916d;

    /* renamed from: f  reason: collision with root package name */
    private int f917f;

    /* renamed from: g  reason: collision with root package name */
    private int f918g;
    private ContentFrameLayout h;
    private y i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private final Rect v;
    private final Rect w;
    private a x;
    private OverScroller y;
    private final Runnable z;

    public interface a {
        void b(int i);

        void g(boolean z);

        void j();

        void k();

        void l();

        void m();
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i2) {
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f918g = 0;
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.v = new Rect();
        this.w = new Rect();
        this.f916d = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f915c = null;
                actionBarOverlayLayout.f914b = false;
            }

            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f915c = null;
                actionBarOverlayLayout.f914b = false;
            }
        };
        this.z = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.d();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f915c = actionBarOverlayLayout.f913a.animate().translationY(BitmapDescriptorFactory.HUE_RED).setListener(ActionBarOverlayLayout.this.f916d);
            }
        };
        this.A = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.d();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f915c = actionBarOverlayLayout.f913a.animate().translationY((float) (-ActionBarOverlayLayout.this.f913a.getHeight())).setListener(ActionBarOverlayLayout.this.f916d);
            }
        };
        a(context);
        this.B = new q(this);
    }

    private void a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f912e);
        boolean z2 = false;
        this.f917f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.j = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.j == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z2 = true;
        }
        this.k = z2;
        this.y = new OverScroller(context);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.x = aVar;
        if (getWindowToken() != null) {
            this.x.b(this.f918g);
            int i2 = this.p;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                w.s(this);
            }
        }
    }

    public void setOverlayMode(boolean z2) {
        this.l = z2;
        this.k = z2 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public boolean a() {
        return this.l;
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.m = z2;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        w.s(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i2);
        }
        c();
        int i3 = this.p ^ i2;
        this.p = i2;
        boolean z2 = false;
        boolean z3 = (i2 & 4) == 0;
        if ((i2 & 256) != 0) {
            z2 = true;
        }
        a aVar = this.x;
        if (aVar != null) {
            aVar.g(!z2);
            if (z3 || !z2) {
                this.x.j();
            } else {
                this.x.k();
            }
        }
        if ((i3 & 256) != 0 && this.x != null) {
            w.s(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f918g = i2;
        a aVar = this.x;
        if (aVar != null) {
            aVar.b(i2);
        }
    }

    private boolean a(View view, Rect rect, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        b bVar = (b) view.getLayoutParams();
        if (!z2 || bVar.leftMargin == rect.left) {
            z6 = false;
        } else {
            bVar.leftMargin = rect.left;
            z6 = true;
        }
        if (z3 && bVar.topMargin != rect.top) {
            bVar.topMargin = rect.top;
            z6 = true;
        }
        if (z5 && bVar.rightMargin != rect.right) {
            bVar.rightMargin = rect.right;
            z6 = true;
        }
        if (!z4 || bVar.bottomMargin == rect.bottom) {
            return z6;
        }
        bVar.bottomMargin = rect.bottom;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        c();
        int r2 = w.r(this) & 256;
        boolean a2 = a((View) this.f913a, rect, true, true, false, true);
        this.t.set(rect);
        ax.a(this, this.t, this.q);
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            a2 = true;
        }
        if (!this.r.equals(this.q)) {
            this.r.set(this.q);
            a2 = true;
        }
        if (a2) {
            requestLayout();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public b generateDefaultLayoutParams() {
        return new b(-1, -1);
    }

    /* renamed from: a */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        c();
        measureChildWithMargins(this.f913a, i2, 0, i3, 0);
        b bVar = (b) this.f913a.getLayoutParams();
        int max = Math.max(0, this.f913a.getMeasuredWidth() + bVar.leftMargin + bVar.rightMargin);
        int max2 = Math.max(0, this.f913a.getMeasuredHeight() + bVar.topMargin + bVar.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f913a.getMeasuredState());
        boolean z2 = (w.r(this) & 256) != 0;
        if (z2) {
            i4 = this.f917f;
            if (this.m && this.f913a.getTabContainer() != null) {
                i4 += this.f917f;
            }
        } else {
            i4 = this.f913a.getVisibility() != 8 ? this.f913a.getMeasuredHeight() : 0;
        }
        this.s.set(this.q);
        this.v.set(this.t);
        if (this.l || z2) {
            this.v.top += i4;
            this.v.bottom += 0;
        } else {
            this.s.top += i4;
            this.s.bottom += 0;
        }
        a((View) this.h, this.s, true, true, true, true);
        if (!this.w.equals(this.v)) {
            this.w.set(this.v);
            this.h.a(this.v);
        }
        measureChildWithMargins(this.h, i2, 0, i3, 0);
        b bVar2 = (b) this.h.getLayoutParams();
        int max3 = Math.max(max, this.h.getMeasuredWidth() + bVar2.leftMargin + bVar2.rightMargin);
        int max4 = Math.max(max2, this.h.getMeasuredHeight() + bVar2.topMargin + bVar2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = bVar.leftMargin + paddingLeft;
                int i8 = bVar.topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.j != null && !this.k) {
            int bottom = this.f913a.getVisibility() == 0 ? (int) (((float) this.f913a.getBottom()) + this.f913a.getTranslationY() + 0.5f) : 0;
            this.j.setBounds(0, bottom, getWidth(), this.j.getIntrinsicHeight() + bottom);
            this.j.draw(canvas);
        }
    }

    public void a(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        a(view, i2, i3, i4, i5, i6);
    }

    public boolean a(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    public void b(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    public void a(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    public void a(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    public void a(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f913a.getVisibility() != 0) {
            return false;
        }
        return this.n;
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.B.a(view, view2, i2);
        this.o = getActionBarHideOffset();
        d();
        a aVar = this.x;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        this.o += i3;
        setActionBarHideOffset(this.o);
    }

    public void onStopNestedScroll(View view) {
        if (this.n && !this.f914b) {
            if (this.o <= this.f913a.getHeight()) {
                l();
            } else {
                m();
            }
        }
        a aVar = this.x;
        if (aVar != null) {
            aVar.m();
        }
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (!this.n || !z2) {
            return false;
        }
        if (a(f2, f3)) {
            o();
        } else {
            n();
        }
        this.f914b = true;
        return true;
    }

    public int getNestedScrollAxes() {
        return this.B.a();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.h == null) {
            this.h = (ContentFrameLayout) findViewById(a.f.action_bar_activity_content);
            this.f913a = (ActionBarContainer) findViewById(a.f.action_bar_container);
            this.i = a(findViewById(a.f.action_bar));
        }
    }

    private y a(View view) {
        if (view instanceof y) {
            return (y) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.n) {
            this.n = z2;
            if (!z2) {
                d();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f913a;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int i2) {
        d();
        this.f913a.setTranslationY((float) (-Math.max(0, Math.min(i2, this.f913a.getHeight()))));
    }

    /* access modifiers changed from: package-private */
    public void d() {
        removeCallbacks(this.z);
        removeCallbacks(this.A);
        ViewPropertyAnimator viewPropertyAnimator = this.f915c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    private void l() {
        d();
        postDelayed(this.z, 600);
    }

    private void m() {
        d();
        postDelayed(this.A, 600);
    }

    private void n() {
        d();
        this.z.run();
    }

    private void o() {
        d();
        this.A.run();
    }

    private boolean a(float f2, float f3) {
        this.y.fling(0, 0, 0, (int) f3, 0, 0, RNCartPanelDataEntity.NULL_VALUE, Integer.MAX_VALUE);
        return this.y.getFinalY() > this.f913a.getHeight();
    }

    public void setWindowCallback(Window.Callback callback) {
        c();
        this.i.a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        c();
        this.i.a(charSequence);
    }

    public CharSequence getTitle() {
        c();
        return this.i.e();
    }

    public void a(int i2) {
        c();
        if (i2 == 2) {
            this.i.f();
        } else if (i2 == 5) {
            this.i.g();
        } else if (i2 == 109) {
            setOverlayMode(true);
        }
    }

    public void setIcon(int i2) {
        c();
        this.i.a(i2);
    }

    public void setIcon(Drawable drawable) {
        c();
        this.i.a(drawable);
    }

    public void setLogo(int i2) {
        c();
        this.i.b(i2);
    }

    public boolean e() {
        c();
        return this.i.h();
    }

    public boolean f() {
        c();
        return this.i.i();
    }

    public boolean g() {
        c();
        return this.i.j();
    }

    public boolean h() {
        c();
        return this.i.k();
    }

    public boolean i() {
        c();
        return this.i.l();
    }

    public void j() {
        c();
        this.i.m();
    }

    public void a(Menu menu, m.a aVar) {
        c();
        this.i.a(menu, aVar);
    }

    public void k() {
        c();
        this.i.n();
    }

    public static class b extends ViewGroup.MarginLayoutParams {
        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
