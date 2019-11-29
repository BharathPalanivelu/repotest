package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.w;
import com.google.android.material.d.b;
import java.util.List;

public abstract class ExpandableBehavior extends CoordinatorLayout.b<View> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f13539a = 0;

    /* access modifiers changed from: protected */
    public abstract boolean a(View view, View view2, boolean z, boolean z2);

    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    public ExpandableBehavior() {
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, final View view, int i) {
        if (w.A(view)) {
            return false;
        }
        final b a2 = a(coordinatorLayout, view);
        if (a2 == null || !a(a2.a())) {
            return false;
        }
        this.f13539a = a2.a() ? 1 : 2;
        final int i2 = this.f13539a;
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                if (ExpandableBehavior.this.f13539a == i2) {
                    ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                    b bVar = a2;
                    expandableBehavior.a((View) bVar, view, bVar.a(), false);
                }
                return false;
            }
        });
        return false;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b bVar = (b) view2;
        if (!a(bVar.a())) {
            return false;
        }
        this.f13539a = bVar.a() ? 1 : 2;
        return a((View) bVar, view, bVar.a(), true);
    }

    /* access modifiers changed from: protected */
    public b a(CoordinatorLayout coordinatorLayout, View view) {
        List<View> c2 = coordinatorLayout.c(view);
        int size = c2.size();
        for (int i = 0; i < size; i++) {
            View view2 = c2.get(i);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (b) view2;
            }
        }
        return null;
    }

    private boolean a(boolean z) {
        if (z) {
            int i = this.f13539a;
            return i == 0 || i == 2;
        } else if (this.f13539a == 1) {
            return true;
        } else {
            return false;
        }
    }
}
