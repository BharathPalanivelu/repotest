package com.airpay.paysdk.base.ui.weidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.airpay.paysdk.c;

public abstract class i extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f3945a = false;

    /* renamed from: b  reason: collision with root package name */
    protected int f3946b = 2000;

    /* renamed from: c  reason: collision with root package name */
    private int f3947c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f3948d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f3949e = -1;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3950f = false;

    public abstract void a();

    public abstract void b();

    public abstract int getLayoutID();

    public i(Context context) {
        super(context);
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.k.BSSectionBaseItemView);
        this.f3948d = obtainStyledAttributes.getDimensionPixelSize(c.k.BSSectionBaseItemView_base_min_height, this.f3948d);
        this.f3949e = obtainStyledAttributes.getResourceId(c.k.BSSectionBaseItemView_base_background, this.f3949e);
        this.f3947c = obtainStyledAttributes.getResourceId(c.k.BSSectionBaseItemView_base_layout_ref, this.f3947c);
        this.f3945a = obtainStyledAttributes.getBoolean(c.k.BSSectionBaseItemView_base_editable, false);
        this.f3946b = obtainStyledAttributes.getInt(c.k.BSSectionBaseItemView_base_max_length, 2000);
        obtainStyledAttributes.recycle();
    }

    public void a(Context context) {
        setOrientation(0);
        if (this.f3949e != -1) {
            setBackgroundDrawable(context.getResources().getDrawable(this.f3949e));
        }
        int i = this.f3947c;
        if (i == -1) {
            i = getLayoutID();
        }
        if (i != 0) {
            View inflate = LayoutInflater.from(context).inflate(i, this);
            int i2 = this.f3948d;
            if (i2 != 0) {
                inflate.setMinimumHeight(i2);
            }
        }
        b();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f3950f) {
            return super.dispatchTouchEvent(motionEvent);
        }
        onTouchEvent(motionEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f3950f = true;
        super.setOnClickListener(onClickListener);
    }

    public void setBackgroundSrc(int i) {
        this.f3949e = i;
    }

    public void setContentMinHeight(int i) {
        this.f3948d = i;
    }
}
