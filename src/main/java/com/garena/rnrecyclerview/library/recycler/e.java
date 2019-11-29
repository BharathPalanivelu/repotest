package com.garena.rnrecyclerview.library.recycler;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.garena.rnrecyclerview.library.view.a;

public class e extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private a f8607a;

    /* renamed from: b  reason: collision with root package name */
    private int f8608b;

    /* renamed from: c  reason: collision with root package name */
    private int f8609c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnLayoutChangeListener f8610d = new View.OnLayoutChangeListener() {
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (i8 - i6 != i4 - i2 && e.this.getParent() != null) {
                e.this.requestLayout();
                e.this.getParent().requestLayout();
            }
        }
    };

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public e(Context context, a aVar) {
        super(context);
        this.f8607a = aVar;
        this.f8609c = 100;
        this.f8608b = context.getResources().getDisplayMetrics().widthPixels;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        view.addOnLayoutChangeListener(this.f8610d);
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        view.removeOnLayoutChangeListener(this.f8610d);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt instanceof a) {
                this.f8608b = childAt.getMeasuredWidth();
                this.f8609c = ((a) childAt).getExpectedHeight();
            } else {
                this.f8608b = childAt.getMeasuredWidth();
                this.f8609c = childAt.getMeasuredHeight();
            }
            setMeasuredDimension(this.f8608b, this.f8609c);
            return;
        }
        setMeasuredDimension(this.f8608b, this.f8609c);
    }

    public a getAdapter() {
        return this.f8607a;
    }
}
