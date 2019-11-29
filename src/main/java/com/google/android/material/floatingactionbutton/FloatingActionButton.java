package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.j;
import androidx.appcompat.widget.m;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.u;
import androidx.core.g.w;
import androidx.core.widget.l;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.a;
import com.google.android.material.a.h;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.d.c;
import com.google.android.material.floatingactionbutton.a;
import com.google.android.material.internal.d;
import com.google.android.material.internal.n;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;

@CoordinatorLayout.c(a = Behavior.class)
public class FloatingActionButton extends n implements u, l, com.google.android.material.d.a {

    /* renamed from: a  reason: collision with root package name */
    boolean f13279a;

    /* renamed from: b  reason: collision with root package name */
    final Rect f13280b;

    /* renamed from: c  reason: collision with root package name */
    private ColorStateList f13281c;

    /* renamed from: d  reason: collision with root package name */
    private PorterDuff.Mode f13282d;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f13283e;

    /* renamed from: f  reason: collision with root package name */
    private PorterDuff.Mode f13284f;

    /* renamed from: g  reason: collision with root package name */
    private int f13285g;
    private ColorStateList h;
    private int i;
    private int j;
    /* access modifiers changed from: private */
    public int k;
    private int l;
    private final Rect m;
    private final m n;
    private final c o;
    private a p;

    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    public FloatingActionButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.floatingActionButtonStyle);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13280b = new Rect();
        this.m = new Rect();
        TypedArray a2 = com.google.android.material.internal.l.a(context, attributeSet, a.k.FloatingActionButton, i2, a.j.Widget_Design_FloatingActionButton, new int[0]);
        this.f13281c = com.google.android.material.f.a.a(context, a2, a.k.FloatingActionButton_backgroundTint);
        this.f13282d = com.google.android.material.internal.m.a(a2.getInt(a.k.FloatingActionButton_backgroundTintMode, -1), (PorterDuff.Mode) null);
        this.h = com.google.android.material.f.a.a(context, a2, a.k.FloatingActionButton_rippleColor);
        this.i = a2.getInt(a.k.FloatingActionButton_fabSize, -1);
        this.j = a2.getDimensionPixelSize(a.k.FloatingActionButton_fabCustomSize, 0);
        this.f13285g = a2.getDimensionPixelSize(a.k.FloatingActionButton_borderWidth, 0);
        float dimension = a2.getDimension(a.k.FloatingActionButton_elevation, BitmapDescriptorFactory.HUE_RED);
        float dimension2 = a2.getDimension(a.k.FloatingActionButton_hoveredFocusedTranslationZ, BitmapDescriptorFactory.HUE_RED);
        float dimension3 = a2.getDimension(a.k.FloatingActionButton_pressedTranslationZ, BitmapDescriptorFactory.HUE_RED);
        this.f13279a = a2.getBoolean(a.k.FloatingActionButton_useCompatPadding, false);
        this.l = a2.getDimensionPixelSize(a.k.FloatingActionButton_maxImageSize, 0);
        h a3 = h.a(context, a2, a.k.FloatingActionButton_showMotionSpec);
        h a4 = h.a(context, a2, a.k.FloatingActionButton_hideMotionSpec);
        a2.recycle();
        this.n = new m(this);
        this.n.a(attributeSet, i2);
        this.o = new c(this);
        getImpl().a(this.f13281c, this.f13282d, this.h, this.f13285g);
        getImpl().a(dimension);
        getImpl().b(dimension2);
        getImpl().c(dimension3);
        getImpl().a(this.l);
        getImpl().a(a3);
        getImpl().b(a4);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.k = (sizeDimension - this.l) / 2;
        getImpl().j();
        int min = Math.min(a(sizeDimension, i2), a(sizeDimension, i3));
        setMeasuredDimension(this.f13280b.left + min + this.f13280b.right, min + this.f13280b.top + this.f13280b.bottom);
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.h;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.h;
    }

    public void setRippleColor(int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.h != colorStateList) {
            this.h = colorStateList;
            getImpl().b(this.h);
        }
    }

    public ColorStateList getBackgroundTintList() {
        return this.f13281c;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f13281c != colorStateList) {
            this.f13281c = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f13282d;
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f13282d != mode) {
            this.f13282d = mode;
            getImpl().a(mode);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f13283e != colorStateList) {
            this.f13283e = colorStateList;
            c();
        }
    }

    public ColorStateList getSupportImageTintList() {
        return this.f13283e;
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f13284f != mode) {
            this.f13284f = mode;
            c();
        }
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f13284f;
    }

    private void c() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.f13283e;
            if (colorStateList == null) {
                androidx.core.graphics.drawable.a.f(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.f13284f;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(j.a(colorForState, mode));
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundColor(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setImageResource(int i2) {
        this.n.a(i2);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        getImpl().d();
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar, boolean z) {
        getImpl().b(a(aVar), z);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        getImpl().a(animatorListener);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        getImpl().b(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar, boolean z) {
        getImpl().a(a(aVar), z);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        getImpl().c(animatorListener);
    }

    public void d(Animator.AnimatorListener animatorListener) {
        getImpl().d(animatorListener);
    }

    public boolean a() {
        return this.o.a();
    }

    public void setExpandedComponentIdHint(int i2) {
        this.o.a(i2);
    }

    public int getExpandedComponentIdHint() {
        return this.o.c();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f13279a != z) {
            this.f13279a = z;
            getImpl().i();
        }
    }

    public boolean getUseCompatPadding() {
        return this.f13279a;
    }

    public void setSize(int i2) {
        this.j = 0;
        if (i2 != this.i) {
            this.i = i2;
            requestLayout();
        }
    }

    public int getSize() {
        return this.i;
    }

    private a.d a(final a aVar) {
        if (aVar == null) {
            return null;
        }
        return new a.d() {
            public void a() {
                aVar.a(FloatingActionButton.this);
            }

            public void b() {
                aVar.b(FloatingActionButton.this);
            }
        };
    }

    public boolean b() {
        return getImpl().r();
    }

    public void setCustomSize(int i2) {
        if (i2 >= 0) {
            this.j = i2;
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    public int getCustomSize() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public int getSizeDimension() {
        return a(this.i);
    }

    private int a(int i2) {
        int i3 = this.j;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i2 != -1) {
            if (i2 != 1) {
                return resources.getDimensionPixelSize(a.d.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(a.d.design_fab_size_mini);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return a(1);
        } else {
            return a(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().k();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().l();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().g();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
        extendableSavedState.f13471a.put("expandableWidgetHelper", this.o.b());
        return extendableSavedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        this.o.a(extendableSavedState.f13471a.get("expandableWidgetHelper"));
    }

    @Deprecated
    public boolean a(Rect rect) {
        if (!w.A(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        c(rect);
        return true;
    }

    public void b(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        c(rect);
    }

    private void c(Rect rect) {
        rect.left += this.f13280b.left;
        rect.top += this.f13280b.top;
        rect.right -= this.f13280b.right;
        rect.bottom -= this.f13280b.bottom;
    }

    public Drawable getContentBackground() {
        return getImpl().h();
    }

    private static int a(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i2, size);
        }
        if (mode == 0) {
            return i2;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !a(this.m) || this.m.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
        }

        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
            super.onAttachedToLayoutParams(eVar);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.b<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f13288a;

        /* renamed from: b  reason: collision with root package name */
        private a f13289b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f13290c;

        public BaseBehavior() {
            this.f13290c = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.FloatingActionButton_Behavior_Layout);
            this.f13290c = obtainStyledAttributes.getBoolean(a.k.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        public void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
            if (eVar.h == 0) {
                eVar.h = 80;
            }
        }

        /* renamed from: a */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (!a(view)) {
                return false;
            } else {
                b(view, floatingActionButton);
                return false;
            }
        }

        private static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                return ((CoordinatorLayout.e) layoutParams).b() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) floatingActionButton.getLayoutParams();
            if (this.f13290c && eVar.a() == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a((View) appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f13288a == null) {
                this.f13288a = new Rect();
            }
            Rect rect = this.f13288a;
            d.b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.b(this.f13289b, false);
                return true;
            }
            floatingActionButton.a(this.f13289b, false);
            return true;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((CoordinatorLayout.e) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.b(this.f13289b, false);
                return true;
            }
            floatingActionButton.a(this.f13289b, false);
            return true;
        }

        /* renamed from: a */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> c2 = coordinatorLayout.c((View) floatingActionButton);
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = c2.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                } else if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.b((View) floatingActionButton, i);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        /* renamed from: a */
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f13280b;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        private void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i;
            Rect rect = floatingActionButton.f13280b;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.e eVar = (CoordinatorLayout.e) floatingActionButton.getLayoutParams();
                int i2 = 0;
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - eVar.rightMargin) {
                    i = rect.right;
                } else {
                    i = floatingActionButton.getLeft() <= eVar.leftMargin ? -rect.left : 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - eVar.bottomMargin) {
                    i2 = rect.bottom;
                } else if (floatingActionButton.getTop() <= eVar.topMargin) {
                    i2 = -rect.top;
                }
                if (i2 != 0) {
                    w.h(floatingActionButton, i2);
                }
                if (i != 0) {
                    w.i(floatingActionButton, i);
                }
            }
        }
    }

    public float getCompatElevation() {
        return getImpl().a();
    }

    public void setCompatElevation(float f2) {
        getImpl().a(f2);
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().b();
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().b(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().c();
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().c(f2);
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public h getShowMotionSpec() {
        return getImpl().e();
    }

    public void setShowMotionSpec(h hVar) {
        getImpl().a(hVar);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(h.a(getContext(), i2));
    }

    public h getHideMotionSpec() {
        return getImpl().f();
    }

    public void setHideMotionSpec(h hVar) {
        getImpl().b(hVar);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(h.a(getContext(), i2));
    }

    private a getImpl() {
        if (this.p == null) {
            this.p = d();
        }
        return this.p;
    }

    private a d() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new b(this, new b());
        }
        return new a(this, new b());
    }

    private class b implements com.google.android.material.h.b {
        b() {
        }

        public float a() {
            return ((float) FloatingActionButton.this.getSizeDimension()) / 2.0f;
        }

        public void a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.f13280b.set(i, i2, i3, i4);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i + floatingActionButton.k, i2 + FloatingActionButton.this.k, i3 + FloatingActionButton.this.k, i4 + FloatingActionButton.this.k);
        }

        public void a(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        public boolean b() {
            return FloatingActionButton.this.f13279a;
        }
    }
}
