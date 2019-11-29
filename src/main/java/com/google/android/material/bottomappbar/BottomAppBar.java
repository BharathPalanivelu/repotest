package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.w;
import androidx.core.graphics.drawable.a;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.i.c;
import java.util.ArrayList;
import java.util.List;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.a {

    /* renamed from: a  reason: collision with root package name */
    AnimatorListenerAdapter f13195a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13196b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final c f13197c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final a f13198d;

    /* renamed from: e  reason: collision with root package name */
    private Animator f13199e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Animator f13200f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Animator f13201g;
    private int h;
    private boolean i;
    private boolean j;

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    public int getFabAlignmentMode() {
        return this.h;
    }

    public void setFabAlignmentMode(int i2) {
        a(i2);
        a(i2, this.j);
        this.h = i2;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        a.a((Drawable) this.f13197c, colorStateList);
    }

    public ColorStateList getBackgroundTint() {
        return this.f13197c.a();
    }

    public float getFabCradleMargin() {
        return this.f13198d.d();
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            this.f13198d.d(f2);
            this.f13197c.invalidateSelf();
        }
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.f13198d.e();
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            this.f13198d.e(f2);
            this.f13197c.invalidateSelf();
        }
    }

    public float getCradleVerticalOffset() {
        return this.f13198d.b();
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            this.f13198d.b(f2);
            this.f13197c.invalidateSelf();
        }
    }

    public boolean getHideOnScroll() {
        return this.i;
    }

    public void setHideOnScroll(boolean z) {
        this.i = z;
    }

    /* access modifiers changed from: package-private */
    public void setFabDiameter(int i2) {
        float f2 = (float) i2;
        if (f2 != this.f13198d.c()) {
            this.f13198d.c(f2);
            this.f13197c.invalidateSelf();
        }
    }

    private void a(int i2) {
        if (this.h != i2 && w.A(this)) {
            Animator animator = this.f13200f;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            a(i2, (List<Animator>) arrayList);
            b(i2, (List<Animator>) arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f13200f = animatorSet;
            this.f13200f.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    Animator unused = BottomAppBar.this.f13200f = null;
                }
            });
            this.f13200f.start();
        }
    }

    private void a(int i2, List<Animator> list) {
        if (this.j) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f13198d.a(), (float) b(i2)});
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BottomAppBar.this.f13198d.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    BottomAppBar.this.f13197c.invalidateSelf();
                }
            });
            ofFloat.setDuration(300);
            list.add(ofFloat);
        }
    }

    /* access modifiers changed from: private */
    public FloatingActionButton a() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View next : ((CoordinatorLayout) getParent()).d((View) this)) {
            if (next instanceof FloatingActionButton) {
                return (FloatingActionButton) next;
            }
        }
        return null;
    }

    private boolean b() {
        FloatingActionButton a2 = a();
        return a2 != null && a2.b();
    }

    private void b(int i2, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a(), "translationX", new float[]{(float) b(i2)});
        ofFloat.setDuration(300);
        list.add(ofFloat);
    }

    private void a(int i2, boolean z) {
        if (w.A(this)) {
            Animator animator = this.f13201g;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!b()) {
                i2 = 0;
                z = false;
            }
            a(i2, z, (List<Animator>) arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f13201g = animatorSet;
            this.f13201g.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    Animator unused = BottomAppBar.this.f13201g = null;
                }
            });
            this.f13201g.start();
        }
    }

    private void a(final int i2, final boolean z, List<Animator> list) {
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{1.0f});
            if ((this.j || (z && b())) && (this.h == 1 || i2 == 1)) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{0.0f});
                ofFloat2.addListener(new AnimatorListenerAdapter() {

                    /* renamed from: a  reason: collision with root package name */
                    public boolean f13205a;

                    public void onAnimationCancel(Animator animator) {
                        this.f13205a = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (!this.f13205a) {
                            BottomAppBar.this.a(actionMenuView, i2, z);
                        }
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(150);
                animatorSet.playSequentially(new Animator[]{ofFloat2, ofFloat});
                list.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        }
    }

    private float a(boolean z) {
        FloatingActionButton a2 = a();
        if (a2 == null) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        Rect rect = new Rect();
        a2.a(rect);
        float height = (float) rect.height();
        if (height == BitmapDescriptorFactory.HUE_RED) {
            height = (float) a2.getMeasuredHeight();
        }
        float height2 = (float) (a2.getHeight() - rect.height());
        float height3 = (-getCradleVerticalOffset()) + (height / 2.0f) + ((float) (a2.getHeight() - rect.bottom));
        float paddingBottom = height2 - ((float) a2.getPaddingBottom());
        float f2 = (float) (-getMeasuredHeight());
        if (z) {
            paddingBottom = height3;
        }
        return f2 + paddingBottom;
    }

    /* access modifiers changed from: private */
    public float getFabTranslationY() {
        return a(this.j);
    }

    private int b(int i2) {
        int i3 = 1;
        boolean z = w.g(this) == 1;
        if (i2 != 1) {
            return 0;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - this.f13196b;
        if (z) {
            i3 = -1;
        }
        return measuredWidth * i3;
    }

    private float getFabTranslationX() {
        return (float) b(this.h);
    }

    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void a(ActionMenuView actionMenuView, int i2, boolean z) {
        boolean z2 = w.g(this) == 1;
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if ((childAt.getLayoutParams() instanceof Toolbar.b) && (((Toolbar.b) childAt.getLayoutParams()).f632a & 8388615) == 8388611) {
                i3 = Math.max(i3, z2 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i2 != 1 || !z) ? BitmapDescriptorFactory.HUE_RED : (float) (i3 - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft())));
    }

    private void c() {
        Animator animator = this.f13199e;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f13201g;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.f13200f;
        if (animator3 != null) {
            animator3.cancel();
        }
    }

    /* access modifiers changed from: private */
    public boolean d() {
        Animator animator = this.f13199e;
        if (animator == null || !animator.isRunning()) {
            Animator animator2 = this.f13201g;
            if (animator2 == null || !animator2.isRunning()) {
                Animator animator3 = this.f13200f;
                if (animator3 == null || !animator3.isRunning()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        c();
        e();
    }

    /* access modifiers changed from: private */
    public void e() {
        this.f13198d.a(getFabTranslationX());
        FloatingActionButton a2 = a();
        this.f13197c.a((!this.j || !b()) ? BitmapDescriptorFactory.HUE_RED : 1.0f);
        if (a2 != null) {
            a2.setTranslationY(getFabTranslationY());
            a2.setTranslationX(getFabTranslationX());
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (!b()) {
                a(actionMenuView, 0, false);
            } else {
                a(actionMenuView, this.h, this.j);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(FloatingActionButton floatingActionButton) {
        b(floatingActionButton);
        floatingActionButton.c((Animator.AnimatorListener) this.f13195a);
        floatingActionButton.a((Animator.AnimatorListener) this.f13195a);
    }

    private void b(FloatingActionButton floatingActionButton) {
        floatingActionButton.d(this.f13195a);
        floatingActionButton.b((Animator.AnimatorListener) this.f13195a);
    }

    public CoordinatorLayout.b<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f13210a = new Rect();

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private boolean a(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
            ((CoordinatorLayout.e) floatingActionButton.getLayoutParams()).f1502d = 17;
            bottomAppBar.a(floatingActionButton);
            return true;
        }

        /* renamed from: a */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            FloatingActionButton c2 = bottomAppBar.a();
            if (c2 != null) {
                a(c2, bottomAppBar);
                c2.b(this.f13210a);
                bottomAppBar.setFabDiameter(this.f13210a.height());
            }
            if (!bottomAppBar.d()) {
                bottomAppBar.e();
            }
            coordinatorLayout.b((View) bottomAppBar, i);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i);
        }

        /* renamed from: a */
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i, i2);
        }

        /* access modifiers changed from: protected */
        public void a(BottomAppBar bottomAppBar) {
            super.a(bottomAppBar);
            FloatingActionButton c2 = bottomAppBar.a();
            if (c2 != null) {
                c2.clearAnimation();
                c2.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(com.google.android.material.a.a.f13101d).setDuration(225);
            }
        }

        /* access modifiers changed from: protected */
        public void b(BottomAppBar bottomAppBar) {
            super.b(bottomAppBar);
            FloatingActionButton c2 = bottomAppBar.a();
            if (c2 != null) {
                c2.a(this.f13210a);
                c2.clearAnimation();
                c2.animate().translationY(((float) (-c2.getPaddingBottom())) + ((float) (c2.getMeasuredHeight() - this.f13210a.height()))).setInterpolator(com.google.android.material.a.a.f13100c).setDuration(175);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f13211a = this.h;
        savedState.f13212b = this.j;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.h = savedState.f13211a;
        this.j = savedState.f13212b;
    }

    static class SavedState extends AbsSavedState {
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
        int f13211a;

        /* renamed from: b  reason: collision with root package name */
        boolean f13212b;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13211a = parcel.readInt();
            this.f13212b = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f13211a);
            parcel.writeInt(this.f13212b ? 1 : 0);
        }
    }
}
