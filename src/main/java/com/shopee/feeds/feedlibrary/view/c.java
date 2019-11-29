package com.shopee.feeds.feedlibrary.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;

public class c extends RecyclerView.h {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f28549e = {16843284};

    /* renamed from: a  reason: collision with root package name */
    private Paint f28550a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f28551b;

    /* renamed from: c  reason: collision with root package name */
    private int f28552c = 2;

    /* renamed from: d  reason: collision with root package name */
    private int f28553d;

    public c(Context context, int i) {
        if (i == 1 || i == 0) {
            this.f28553d = i;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f28549e);
            this.f28551b = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("请输入正确的参数！");
    }

    public c(Context context, int i, int i2) {
        this(context, i);
        this.f28551b = b.a(context, i2);
    }

    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
        super.a(rect, view, recyclerView, tVar);
        if (this.f28553d == 1) {
            rect.set(0, 0, 0, this.f28552c);
        } else {
            rect.set(0, 0, this.f28552c, 0);
        }
    }

    public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.t tVar) {
        super.b(canvas, recyclerView, tVar);
        if (this.f28553d == 1) {
            c(canvas, recyclerView);
        } else {
            d(canvas, recyclerView);
        }
    }

    private void c(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int measuredWidth = recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((RecyclerView.j) childAt.getLayoutParams()).bottomMargin;
            int i2 = this.f28552c + bottom;
            Drawable drawable = this.f28551b;
            if (drawable != null) {
                drawable.setBounds(paddingLeft, bottom, measuredWidth, i2);
                this.f28551b.draw(canvas);
            }
            Paint paint = this.f28550a;
            if (paint != null) {
                canvas.drawRect((float) paddingLeft, (float) bottom, (float) measuredWidth, (float) i2, paint);
            }
        }
    }

    private void d(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int right = childAt.getRight() + ((RecyclerView.j) childAt.getLayoutParams()).rightMargin;
            int i2 = this.f28552c + right;
            Drawable drawable = this.f28551b;
            if (drawable != null) {
                drawable.setBounds(right, paddingTop, i2, measuredHeight);
                this.f28551b.draw(canvas);
            }
            Paint paint = this.f28550a;
            if (paint != null) {
                canvas.drawRect((float) right, (float) paddingTop, (float) i2, (float) measuredHeight, paint);
            }
        }
    }
}
