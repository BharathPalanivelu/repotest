package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.b.a;
import androidx.core.g.ae;
import androidx.core.g.d;
import androidx.core.g.w;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.util.List;

abstract class b extends c<View> {

    /* renamed from: a  reason: collision with root package name */
    final Rect f13152a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    final Rect f13153b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private int f13154c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f13155d;

    private static int c(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public float a(View view) {
        return 1.0f;
    }

    /* access modifiers changed from: package-private */
    public abstract View b(List<View> list);

    public b() {
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 != -1 && i5 != -2) {
            return false;
        }
        View b2 = b(coordinatorLayout.c(view));
        if (b2 == null) {
            return false;
        }
        if (!w.t(b2) || w.t(view)) {
            View view2 = view;
        } else {
            View view3 = view;
            w.b(view, true);
            if (w.t(view)) {
                view.requestLayout();
                return true;
            }
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        coordinatorLayout.a(view, i, i2, View.MeasureSpec.makeMeasureSpec((size - b2.getMeasuredHeight()) + b(b2), i5 == -1 ? 1073741824 : RNCartPanelDataEntity.NULL_VALUE), i4);
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(CoordinatorLayout coordinatorLayout, View view, int i) {
        View b2 = b(coordinatorLayout.c(view));
        if (b2 != null) {
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) view.getLayoutParams();
            Rect rect = this.f13152a;
            rect.set(coordinatorLayout.getPaddingLeft() + eVar.leftMargin, b2.getBottom() + eVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - eVar.rightMargin, ((coordinatorLayout.getHeight() + b2.getBottom()) - coordinatorLayout.getPaddingBottom()) - eVar.bottomMargin);
            ae lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && w.t(coordinatorLayout) && !w.t(view)) {
                rect.left += lastWindowInsets.a();
                rect.right -= lastWindowInsets.c();
            }
            Rect rect2 = this.f13153b;
            d.a(c(eVar.f1501c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int c2 = c(b2);
            view.layout(rect2.left, rect2.top - c2, rect2.right, rect2.bottom - c2);
            this.f13154c = rect2.top - b2.getBottom();
            return;
        }
        super.a(coordinatorLayout, view, i);
        this.f13154c = 0;
    }

    /* access modifiers changed from: package-private */
    public final int c(View view) {
        if (this.f13155d == 0) {
            return 0;
        }
        float a2 = a(view);
        int i = this.f13155d;
        return a.a((int) (a2 * ((float) i)), 0, i);
    }

    /* access modifiers changed from: package-private */
    public int b(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f13154c;
    }

    public final void b(int i) {
        this.f13155d = i;
    }

    public final int c() {
        return this.f13155d;
    }
}
